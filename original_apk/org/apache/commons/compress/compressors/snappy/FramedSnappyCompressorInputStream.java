package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class FramedSnappyCompressorInputStream extends CompressorInputStream {
    private static final int COMPRESSED_CHUNK_TYPE = 0;
    static final long MASK_OFFSET = 2726488792L;
    private static final int MAX_SKIPPABLE_TYPE = 253;
    private static final int MAX_UNSKIPPABLE_TYPE = 127;
    private static final int MIN_UNSKIPPABLE_TYPE = 2;
    private static final int PADDING_CHUNK_TYPE = 254;
    private static final int STREAM_IDENTIFIER_TYPE = 255;
    private static final byte[] SZ_SIGNATURE = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private static final int UNCOMPRESSED_CHUNK_TYPE = 1;
    private final PureJavaCrc32C checksum = new PureJavaCrc32C();
    private SnappyCompressorInputStream currentCompressedChunk;
    private boolean endReached;
    private long expectedChecksum = -1;
    private final PushbackInputStream in;
    private boolean inUncompressedChunk;
    private final byte[] oneByte = new byte[1];
    private int uncompressedBytesRemaining;

    public FramedSnappyCompressorInputStream(InputStream inputStream) throws IOException {
        this.in = new PushbackInputStream(inputStream, 1);
        readStreamIdentifier();
    }

    public static boolean matches(byte[] bArr, int i) {
        byte[] bArr2 = SZ_SIGNATURE;
        if (i < bArr2.length) {
            return false;
        }
        if (bArr.length > bArr2.length) {
            byte[] bArr3 = new byte[bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr2.length);
            bArr = bArr3;
        }
        return Arrays.equals(bArr, SZ_SIGNATURE);
    }

    private long readCrc() throws IOException {
        byte[] bArr = new byte[4];
        int readFully = IOUtils.readFully(this.in, bArr);
        count(readFully);
        if (readFully == 4) {
            long j = 0;
            for (int i = 0; i < 4; i++) {
                j |= (((long) bArr[i]) & 255) << (i * 8);
            }
            return j;
        }
        throw new IOException("premature end of stream");
    }

    private void readNextBlock() throws IOException {
        verifyLastChecksumAndReset();
        this.inUncompressedChunk = false;
        int readOneByte = readOneByte();
        if (readOneByte == -1) {
            this.endReached = true;
        } else if (readOneByte == STREAM_IDENTIFIER_TYPE) {
            this.in.unread(readOneByte);
            pushedBackBytes(1);
            readStreamIdentifier();
            readNextBlock();
        } else if (readOneByte == PADDING_CHUNK_TYPE || (readOneByte > MAX_UNSKIPPABLE_TYPE && readOneByte <= MAX_SKIPPABLE_TYPE)) {
            skipBlock();
            readNextBlock();
        } else if (readOneByte >= 2 && readOneByte <= MAX_UNSKIPPABLE_TYPE) {
            throw new IOException("unskippable chunk with type " + readOneByte + " (hex " + Integer.toHexString(readOneByte) + ")" + " detected.");
        } else if (readOneByte == 1) {
            this.inUncompressedChunk = true;
            this.uncompressedBytesRemaining = readSize() - 4;
            this.expectedChecksum = unmask(readCrc());
        } else if (readOneByte == 0) {
            this.expectedChecksum = unmask(readCrc());
            this.currentCompressedChunk = new SnappyCompressorInputStream(new BoundedInputStream(this.in, (long) (readSize() - 4)));
            count(this.currentCompressedChunk.getBytesRead());
        } else {
            throw new IOException("unknown chunk type " + readOneByte + " detected.");
        }
    }

    private int readOnce(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.inUncompressedChunk) {
            int min = Math.min(this.uncompressedBytesRemaining, i2);
            if (min == 0) {
                return -1;
            }
            i3 = this.in.read(bArr, i, min);
            if (i3 != -1) {
                this.uncompressedBytesRemaining -= i3;
                count(i3);
            }
        } else {
            SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
            if (snappyCompressorInputStream != null) {
                long bytesRead = snappyCompressorInputStream.getBytesRead();
                i3 = this.currentCompressedChunk.read(bArr, i, i2);
                if (i3 == -1) {
                    this.currentCompressedChunk.close();
                    this.currentCompressedChunk = null;
                } else {
                    count(this.currentCompressedChunk.getBytesRead() - bytesRead);
                }
            } else {
                i3 = -1;
            }
        }
        if (i3 > 0) {
            this.checksum.update(bArr, i, i3);
        }
        return i3;
    }

    private int readOneByte() throws IOException {
        int read = this.in.read();
        if (read == -1) {
            return -1;
        }
        count(1);
        return read & STREAM_IDENTIFIER_TYPE;
    }

    private int readSize() throws IOException {
        int i = 0;
        int i2 = 0;
        while (i < 3) {
            int readOneByte = readOneByte();
            if (readOneByte != -1) {
                i2 |= readOneByte << (i * 8);
                i++;
            } else {
                throw new IOException("premature end of stream");
            }
        }
        return i2;
    }

    private void readStreamIdentifier() throws IOException {
        byte[] bArr = new byte[10];
        int readFully = IOUtils.readFully(this.in, bArr);
        count(readFully);
        if (10 != readFully || !matches(bArr, 10)) {
            throw new IOException("Not a framed Snappy stream");
        }
    }

    private void skipBlock() throws IOException {
        long readSize = (long) readSize();
        long skip = IOUtils.skip(this.in, readSize);
        count(skip);
        if (skip != readSize) {
            throw new IOException("premature end of stream");
        }
    }

    static long unmask(long j) {
        long j2 = (j - MASK_OFFSET) & 4294967295L;
        return ((j2 << 15) | (j2 >> 17)) & 4294967295L;
    }

    private void verifyLastChecksumAndReset() throws IOException {
        long j = this.expectedChecksum;
        if (j < 0 || j == this.checksum.getValue()) {
            this.expectedChecksum = -1;
            this.checksum.reset();
            return;
        }
        throw new IOException("Checksum verification failed");
    }

    public int available() throws IOException {
        if (this.inUncompressedChunk) {
            return Math.min(this.uncompressedBytesRemaining, this.in.available());
        }
        SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
        if (snappyCompressorInputStream != null) {
            return snappyCompressorInputStream.available();
        }
        return 0;
    }

    public void close() throws IOException {
        SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
        if (snappyCompressorInputStream != null) {
            snappyCompressorInputStream.close();
            this.currentCompressedChunk = null;
        }
        this.in.close();
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readOnce = readOnce(bArr, i, i2);
        if (readOnce != -1) {
            return readOnce;
        }
        readNextBlock();
        if (this.endReached) {
            return -1;
        }
        return readOnce(bArr, i, i2);
    }
}
