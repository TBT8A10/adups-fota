package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class SnappyCompressorInputStream extends CompressorInputStream {
    public static final int DEFAULT_BLOCK_SIZE = 32768;
    private static final int TAG_MASK = 3;
    private final int blockSize;
    private final byte[] decompressBuf;
    private boolean endReached;
    private final InputStream in;
    private final byte[] oneByte;
    private int readIndex;
    private final int size;
    private int uncompressedBytesRemaining;
    private int writeIndex;

    public SnappyCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 32768);
    }

    private boolean expandCopy(long j, int i) throws IOException {
        if (j <= ((long) this.blockSize)) {
            int i2 = (int) j;
            if (i2 == 1) {
                byte b2 = this.decompressBuf[this.writeIndex - 1];
                for (int i3 = 0; i3 < i; i3++) {
                    byte[] bArr = this.decompressBuf;
                    int i4 = this.writeIndex;
                    this.writeIndex = i4 + 1;
                    bArr[i4] = b2;
                }
            } else if (i < i2) {
                byte[] bArr2 = this.decompressBuf;
                int i5 = this.writeIndex;
                System.arraycopy(bArr2, i5 - i2, bArr2, i5, i);
                this.writeIndex += i;
            } else {
                int i6 = i / i2;
                int i7 = i - (i2 * i6);
                while (true) {
                    int i8 = i6 - 1;
                    if (i6 == 0) {
                        break;
                    }
                    byte[] bArr3 = this.decompressBuf;
                    int i9 = this.writeIndex;
                    System.arraycopy(bArr3, i9 - i2, bArr3, i9, i2);
                    this.writeIndex += i2;
                    i6 = i8;
                }
                if (i7 > 0) {
                    byte[] bArr4 = this.decompressBuf;
                    int i10 = this.writeIndex;
                    System.arraycopy(bArr4, i10 - i2, bArr4, i10, i7);
                    this.writeIndex += i7;
                }
            }
            if (this.writeIndex >= this.blockSize * 2) {
                return true;
            }
            return false;
        }
        throw new IOException("Offset is larger than block size");
    }

    private boolean expandLiteral(int i) throws IOException {
        int readFully = IOUtils.readFully(this.in, this.decompressBuf, this.writeIndex, i);
        count(readFully);
        if (i == readFully) {
            this.writeIndex += i;
            return this.writeIndex >= this.blockSize * 2;
        }
        throw new IOException("Premature end of stream");
    }

    private void fill(int i) throws IOException {
        if (this.uncompressedBytesRemaining == 0) {
            this.endReached = true;
        }
        int min = Math.min(i, this.uncompressedBytesRemaining);
        while (min > 0) {
            int readOneByte = readOneByte();
            int i2 = 0;
            int i3 = readOneByte & 3;
            if (i3 == 0) {
                i2 = readLiteralLength(readOneByte);
                if (expandLiteral(i2)) {
                    return;
                }
            } else if (i3 == 1) {
                i2 = ((readOneByte >> 2) & 7) + 4;
                if (expandCopy(((long) ((readOneByte & 224) << 3)) | ((long) readOneByte()), i2)) {
                    return;
                }
            } else if (i3 == 2) {
                i2 = (readOneByte >> 2) + 1;
                if (expandCopy(((long) readOneByte()) | ((long) (readOneByte() << 8)), i2)) {
                    return;
                }
            } else if (i3 != 3) {
                continue;
            } else {
                i2 = (readOneByte >> 2) + 1;
                if (expandCopy(((long) readOneByte()) | ((long) (readOneByte() << 8)) | ((long) (readOneByte() << 16)) | (((long) readOneByte()) << 24), i2)) {
                    return;
                }
            }
            min -= i2;
            this.uncompressedBytesRemaining -= i2;
        }
    }

    private int readLiteralLength(int i) throws IOException {
        int i2;
        int i3;
        int i4 = i >> 2;
        switch (i4) {
            case 60:
                i4 = readOneByte();
                break;
            case 61:
                i2 = readOneByte();
                i3 = readOneByte() << 8;
                break;
            case 62:
                i2 = readOneByte() | (readOneByte() << 8);
                i3 = readOneByte() << 16;
                break;
            case 63:
                i4 = (int) (((long) (readOneByte() | (readOneByte() << 8) | (readOneByte() << 16))) | (((long) readOneByte()) << 24));
                break;
        }
        i4 = i2 | i3;
        return i4 + 1;
    }

    private int readOneByte() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            count(1);
            return read & 255;
        }
        throw new IOException("Premature end of stream");
    }

    private long readSize() throws IOException {
        int i = 0;
        long j = 0;
        while (true) {
            int readOneByte = readOneByte();
            int i2 = i + 1;
            j |= (long) ((readOneByte & 127) << (i * 7));
            if ((readOneByte & CpioConstants.C_IWUSR) == 0) {
                return j;
            }
            i = i2;
        }
    }

    private void slideBuffer() {
        byte[] bArr = this.decompressBuf;
        int i = this.blockSize;
        System.arraycopy(bArr, i, bArr, 0, i * 2);
        int i2 = this.writeIndex;
        int i3 = this.blockSize;
        this.writeIndex = i2 - i3;
        this.readIndex -= i3;
    }

    public int available() {
        return this.writeIndex - this.readIndex;
    }

    public void close() throws IOException {
        this.in.close();
    }

    public int getSize() {
        return this.size;
    }

    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & 255;
    }

    public SnappyCompressorInputStream(InputStream inputStream, int i) throws IOException {
        this.oneByte = new byte[1];
        this.endReached = false;
        this.in = inputStream;
        this.blockSize = i;
        this.decompressBuf = new byte[(i * 3)];
        this.readIndex = 0;
        this.writeIndex = 0;
        int readSize = (int) readSize();
        this.size = readSize;
        this.uncompressedBytesRemaining = readSize;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int available = available();
        if (i2 > available) {
            fill(i2 - available);
        }
        int min = Math.min(i2, available());
        System.arraycopy(this.decompressBuf, this.readIndex, bArr, i, min);
        this.readIndex += min;
        if (this.readIndex > this.blockSize) {
            slideBuffer();
        }
        return min;
    }
}
