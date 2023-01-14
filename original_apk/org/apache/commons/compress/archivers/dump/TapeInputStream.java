package org.apache.commons.compress.archivers.dump;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.archivers.dump.DumpArchiveConstants;
import org.apache.commons.compress.utils.IOUtils;

class TapeInputStream extends FilterInputStream {
    private static final int recordSize = 1024;
    private byte[] blockBuffer = new byte[1024];
    private int blockSize = 1024;
    private long bytesRead = 0;
    private int currBlkIdx = -1;
    private boolean isCompressed = false;
    private int readOffset = 1024;

    /* renamed from: org.apache.commons.compress.archivers.dump.TapeInputStream$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = new int[DumpArchiveConstants.COMPRESSION_TYPE.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE[] r0 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = r0
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.ZLIB     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE     // Catch:{ NoSuchFieldError -> 0x001f }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.BZLIB     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE     // Catch:{ NoSuchFieldError -> 0x002a }
                org.apache.commons.compress.archivers.dump.DumpArchiveConstants$COMPRESSION_TYPE r1 = org.apache.commons.compress.archivers.dump.DumpArchiveConstants.COMPRESSION_TYPE.LZO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.dump.TapeInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public TapeInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private boolean readBlock(boolean z) throws IOException {
        boolean z2;
        if (this.in != null) {
            if (!this.isCompressed || this.currBlkIdx == -1) {
                z2 = readFully(this.blockBuffer, 0, this.blockSize);
                this.bytesRead += (long) this.blockSize;
            } else if (!readFully(this.blockBuffer, 0, 4)) {
                return false;
            } else {
                this.bytesRead += 4;
                int convert32 = DumpArchiveUtil.convert32(this.blockBuffer, 0);
                if (!((convert32 & 1) == 1)) {
                    z2 = readFully(this.blockBuffer, 0, this.blockSize);
                    this.bytesRead += (long) this.blockSize;
                } else {
                    int i = (convert32 >> 1) & 7;
                    int i2 = (convert32 >> 4) & 268435455;
                    byte[] bArr = new byte[i2];
                    boolean readFully = readFully(bArr, 0, i2);
                    this.bytesRead += (long) i2;
                    if (!z) {
                        Arrays.fill(this.blockBuffer, (byte) 0);
                    } else {
                        int i3 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.find(i & 3).ordinal()];
                        if (i3 == 1) {
                            try {
                                Inflater inflater = new Inflater();
                                inflater.setInput(bArr, 0, bArr.length);
                                if (inflater.inflate(this.blockBuffer) == this.blockSize) {
                                    inflater.end();
                                } else {
                                    throw new ShortFileException();
                                }
                            } catch (DataFormatException e) {
                                throw new DumpArchiveException("bad data", e);
                            }
                        } else if (i3 == 2) {
                            throw new UnsupportedCompressionAlgorithmException("BZLIB2");
                        } else if (i3 != 3) {
                            throw new UnsupportedCompressionAlgorithmException();
                        } else {
                            throw new UnsupportedCompressionAlgorithmException("LZO");
                        }
                    }
                    z2 = readFully;
                }
            }
            this.currBlkIdx++;
            this.readOffset = 0;
            return z2;
        }
        throw new IOException("input buffer is closed");
    }

    private boolean readFully(byte[] bArr, int i, int i2) throws IOException {
        if (IOUtils.readFully(this.in, bArr, i, i2) >= i2) {
            return true;
        }
        throw new ShortFileException();
    }

    public int available() throws IOException {
        int i = this.readOffset;
        int i2 = this.blockSize;
        if (i < i2) {
            return i2 - i;
        }
        return this.in.available();
    }

    public void close() throws IOException {
        if (this.in != null && this.in != System.in) {
            this.in.close();
        }
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public byte[] peek() throws IOException {
        if (this.readOffset == this.blockSize && !readBlock(true)) {
            return null;
        }
        byte[] bArr = new byte[1024];
        System.arraycopy(this.blockBuffer, this.readOffset, bArr, 0, bArr.length);
        return bArr;
    }

    public int read() throws IOException {
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    public byte[] readRecord() throws IOException {
        byte[] bArr = new byte[1024];
        if (-1 != read(bArr, 0, bArr.length)) {
            return bArr;
        }
        throw new ShortFileException();
    }

    public void resetBlockSize(int i, boolean z) throws IOException {
        this.isCompressed = z;
        this.blockSize = i * 1024;
        byte[] bArr = this.blockBuffer;
        this.blockBuffer = new byte[this.blockSize];
        System.arraycopy(bArr, 0, this.blockBuffer, 0, 1024);
        readFully(this.blockBuffer, 1024, this.blockSize - 1024);
        this.currBlkIdx = 0;
        this.readOffset = 1024;
    }

    public long skip(long j) throws IOException {
        long j2 = 0;
        if (j % PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID == 0) {
            while (j2 < j) {
                int i = this.readOffset;
                int i2 = this.blockSize;
                if (i == i2) {
                    if (!readBlock(j - j2 < ((long) i2))) {
                        return -1;
                    }
                }
                int i3 = this.readOffset;
                long j3 = j - j2;
                int i4 = this.blockSize;
                if (((long) i3) + j3 > ((long) i4)) {
                    j3 = (long) (i4 - i3);
                }
                this.readOffset = (int) (((long) this.readOffset) + j3);
                j2 += j3;
            }
            return j2;
        }
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 % 1024 == 0) {
            int i3 = 0;
            while (i3 < i2) {
                if (this.readOffset == this.blockSize && !readBlock(true)) {
                    return -1;
                }
                int i4 = this.readOffset;
                int i5 = i2 - i3;
                int i6 = i4 + i5;
                int i7 = this.blockSize;
                if (i6 > i7) {
                    i5 = i7 - i4;
                }
                System.arraycopy(this.blockBuffer, this.readOffset, bArr, i, i5);
                this.readOffset += i5;
                i3 += i5;
                i += i5;
            }
            return i3;
        }
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }
}
