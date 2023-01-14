package org.apache.commons.compress.compressors.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.CompressorInputStream;

public class BZip2CompressorInputStream extends CompressorInputStream implements BZip2Constants {
    private static final int EOF = 0;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private boolean blockRandomised;
    private int blockSize100k;
    private int bsBuff;
    private int bsLive;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;
    private InputStream in;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    private static final class Data {
        final int[][] base = ((int[][]) Array.newInstance(int.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        final int[] cftab = new int[TarConstants.MAGIC_OFFSET];
        final char[] getAndMoveToFrontDecode_yy = new char[CpioConstants.C_IRUSR];
        final boolean[] inUse = new boolean[CpioConstants.C_IRUSR];
        final int[][] limit = ((int[][]) Array.newInstance(int.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        byte[] ll8;
        final int[] minLens = new int[6];
        final int[][] perm = ((int[][]) Array.newInstance(int.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        final byte[] recvDecodingTables_pos = new byte[6];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] seqToUnseq = new byte[CpioConstants.C_IRUSR];
        final char[][] temp_charArray2d = ((char[][]) Array.newInstance(char.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        int[] tt;
        final int[] unzftab = new int[CpioConstants.C_IRUSR];

        Data(int i) {
            this.ll8 = new byte[(i * BZip2Constants.BASEBLOCKSIZE)];
        }

        /* access modifiers changed from: package-private */
        public int[] initTT(int i) {
            int[] iArr = this.tt;
            if (iArr != null && iArr.length >= i) {
                return iArr;
            }
            int[] iArr2 = new int[i];
            this.tt = iArr2;
            return iArr2;
        }
    }

    public BZip2CompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private boolean bsGetBit() throws IOException {
        int i = this.bsLive;
        int i2 = this.bsBuff;
        if (i < 1) {
            int read = this.in.read();
            if (read >= 0) {
                i2 = (i2 << 8) | read;
                i += 8;
                this.bsBuff = i2;
            } else {
                throw new IOException("unexpected end of stream");
            }
        }
        int i3 = i - 1;
        this.bsLive = i3;
        if (((i2 >> i3) & 1) != 0) {
            return true;
        }
        return false;
    }

    private int bsGetInt() throws IOException {
        return bsR(8) | (((((bsR(8) << 8) | bsR(8)) << 8) | bsR(8)) << 8);
    }

    private char bsGetUByte() throws IOException {
        return (char) bsR(8);
    }

    private int bsR(int i) throws IOException {
        int i2 = this.bsLive;
        int i3 = this.bsBuff;
        if (i2 < i) {
            InputStream inputStream = this.in;
            do {
                int read = inputStream.read();
                if (read >= 0) {
                    i3 = (i3 << 8) | read;
                    i2 += 8;
                } else {
                    throw new IOException("unexpected end of stream");
                }
            } while (i2 < i);
            this.bsBuff = i3;
        }
        int i4 = i2 - i;
        this.bsLive = i4;
        return ((1 << i) - 1) & (i3 >> i4);
    }

    private boolean complete() throws IOException {
        this.storedCombinedCRC = bsGetInt();
        this.currentState = 0;
        this.data = null;
        if (this.storedCombinedCRC != this.computedCombinedCRC) {
            throw new IOException("BZip2 CRC error");
        } else if (!this.decompressConcatenated || !init(false)) {
            return true;
        } else {
            return false;
        }
    }

    private void createHuffmanDecodingTables(int i, int i2) {
        Data data2 = this.data;
        char[][] cArr = data2.temp_charArray2d;
        int[] iArr = data2.minLens;
        int[][] iArr2 = data2.limit;
        int[][] iArr3 = data2.base;
        int[][] iArr4 = data2.perm;
        int i3 = i2;
        for (int i4 = 0; i4 < i3; i4++) {
            char[] cArr2 = cArr[i4];
            int i5 = i;
            char c2 = 0;
            char c3 = ' ';
            while (true) {
                i5--;
                if (i5 < 0) {
                    break;
                }
                char c4 = cArr2[i5];
                if (c4 > c2) {
                    c2 = c4;
                }
                if (c4 < c3) {
                    c3 = c4;
                }
            }
            hbCreateDecodeTables(iArr2[i4], iArr3[i4], iArr4[i4], cArr[i4], c3, c2, i);
            iArr[i4] = c3;
        }
    }

    private void endBlock() throws IOException {
        this.computedBlockCRC = this.crc.getFinalCRC();
        int i = this.storedBlockCRC;
        int i2 = this.computedBlockCRC;
        if (i == i2) {
            int i3 = this.computedCombinedCRC;
            this.computedCombinedCRC = (i3 >>> 31) | (i3 << 1);
            this.computedCombinedCRC ^= i2;
            return;
        }
        int i4 = this.storedCombinedCRC;
        this.computedCombinedCRC = (i4 >>> 31) | (i4 << 1);
        this.computedCombinedCRC = i ^ this.computedCombinedCRC;
        throw new IOException("BZip2 CRC error");
    }

    private void getAndMoveToFrontDecode() throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        char c2;
        int i5;
        BZip2CompressorInputStream bZip2CompressorInputStream = this;
        bZip2CompressorInputStream.origPtr = bZip2CompressorInputStream.bsR(24);
        recvDecodingTables();
        InputStream inputStream = bZip2CompressorInputStream.in;
        Data data2 = bZip2CompressorInputStream.data;
        byte[] bArr = data2.ll8;
        int[] iArr = data2.unzftab;
        byte[] bArr2 = data2.selector;
        byte[] bArr3 = data2.seqToUnseq;
        char[] cArr = data2.getAndMoveToFrontDecode_yy;
        int[] iArr2 = data2.minLens;
        int[][] iArr3 = data2.limit;
        int[][] iArr4 = data2.base;
        int[][] iArr5 = data2.perm;
        int i6 = bZip2CompressorInputStream.blockSize100k * BZip2Constants.BASEBLOCKSIZE;
        int i7 = CpioConstants.C_IRUSR;
        while (true) {
            i7--;
            if (i7 < 0) {
                break;
            }
            cArr[i7] = (char) i7;
            iArr[i7] = 0;
        }
        int i8 = bZip2CompressorInputStream.nInUse + 1;
        int andMoveToFrontDecode0 = bZip2CompressorInputStream.getAndMoveToFrontDecode0(0);
        int i9 = bZip2CompressorInputStream.bsBuff;
        int i10 = bZip2CompressorInputStream.bsLive;
        int i11 = i9;
        byte b2 = bArr2[0] & 255;
        int[] iArr6 = iArr4[b2];
        int[] iArr7 = iArr3[b2];
        int i12 = i10;
        int i13 = i11;
        int[] iArr8 = iArr5[b2];
        int i14 = -1;
        int i15 = 49;
        int[] iArr9 = iArr7;
        int[] iArr10 = iArr6;
        int i16 = iArr2[b2];
        int i17 = andMoveToFrontDecode0;
        int i18 = 0;
        while (i17 != i8) {
            int i19 = i8;
            if (i17 == 0 || i17 == 1) {
                int[] iArr11 = iArr8;
                int i20 = -1;
                int[] iArr12 = iArr9;
                int[] iArr13 = iArr10;
                int i21 = i16;
                int i22 = i18;
                int i23 = 1;
                while (true) {
                    if (i17 == 0) {
                        i2 = i20 + i23;
                        i = i14;
                    } else {
                        i = i14;
                        if (i17 == 1) {
                            i2 = i20 + (i23 << 1);
                        } else {
                            int[][] iArr14 = iArr5;
                            byte b3 = bArr3[cArr[0]];
                            byte b4 = b3 & 255;
                            iArr[b4] = iArr[b4] + i20 + 1;
                            i14 = i;
                            while (true) {
                                int i24 = i20 - 1;
                                if (i20 < 0) {
                                    break;
                                }
                                i14++;
                                bArr[i14] = b3;
                                i20 = i24;
                            }
                            if (i14 < i6) {
                                bZip2CompressorInputStream = this;
                                i18 = i22;
                                i16 = i21;
                                iArr10 = iArr13;
                                iArr9 = iArr12;
                                i8 = i19;
                                iArr8 = iArr11;
                                iArr5 = iArr14;
                            } else {
                                throw new IOException("block overrun");
                            }
                        }
                    }
                    if (i15 == 0) {
                        i22++;
                        byte b5 = bArr2[i22] & 255;
                        iArr13 = iArr4[b5];
                        iArr12 = iArr3[b5];
                        iArr11 = iArr5[b5];
                        i3 = iArr2[b5];
                        i4 = 49;
                    } else {
                        i4 = i15 - 1;
                        i3 = i21;
                    }
                    int i25 = i12;
                    while (i25 < i3) {
                        int read = inputStream.read();
                        if (read >= 0) {
                            i13 = (i13 << 8) | read;
                            i25 += 8;
                        } else {
                            throw new IOException("unexpected end of stream");
                        }
                    }
                    int i26 = i25 - i3;
                    int i27 = i2;
                    int i28 = i26;
                    int i29 = (i13 >> i26) & ((1 << i3) - 1);
                    int i30 = i3;
                    while (i29 > iArr12[i30]) {
                        int i31 = i30 + 1;
                        int[][] iArr15 = iArr5;
                        int i32 = i12;
                        while (i32 < 1) {
                            int read2 = inputStream.read();
                            if (read2 >= 0) {
                                i13 = (i13 << 8) | read2;
                                i32 += 8;
                            } else {
                                throw new IOException("unexpected end of stream");
                            }
                        }
                        i28 = i32 - 1;
                        i29 = (i29 << 1) | ((i13 >> i28) & 1);
                        i30 = i31;
                        iArr5 = iArr15;
                    }
                    int[][] iArr16 = iArr5;
                    int i33 = iArr11[i29 - iArr13[i30]];
                    i23 <<= 1;
                    i21 = i3;
                    i14 = i;
                    i17 = i33;
                    i20 = i27;
                }
            } else {
                i14++;
                if (i14 < i6) {
                    int i34 = i17 - 1;
                    char c3 = cArr[i34];
                    byte b6 = bArr3[c3] & 255;
                    iArr[b6] = iArr[b6] + 1;
                    bArr[i14] = bArr3[c3];
                    if (i17 <= 16) {
                        while (i34 > 0) {
                            int i35 = i34 - 1;
                            cArr[i34] = cArr[i35];
                            i34 = i35;
                        }
                        c2 = 0;
                    } else {
                        c2 = 0;
                        System.arraycopy(cArr, 0, cArr, 1, i34);
                    }
                    cArr[c2] = c3;
                    if (i15 == 0) {
                        i18++;
                        byte b7 = bArr2[i18] & 255;
                        int[] iArr17 = iArr4[b7];
                        int[] iArr18 = iArr3[b7];
                        int[] iArr19 = iArr5[b7];
                        i5 = iArr2[b7];
                        iArr10 = iArr17;
                        iArr9 = iArr18;
                        iArr8 = iArr19;
                        i15 = 49;
                    } else {
                        i15--;
                        i5 = i16;
                    }
                    int i36 = i12;
                    while (i36 < i5) {
                        int read3 = inputStream.read();
                        if (read3 >= 0) {
                            i13 = (i13 << 8) | read3;
                            i36 += 8;
                        } else {
                            throw new IOException("unexpected end of stream");
                        }
                    }
                    int i37 = i36 - i5;
                    int i38 = (i13 >> i37) & ((1 << i5) - 1);
                    i12 = i37;
                    int i39 = i5;
                    while (i38 > iArr9[i39]) {
                        i39++;
                        int i40 = i5;
                        int i41 = i12;
                        while (i41 < 1) {
                            int read4 = inputStream.read();
                            if (read4 >= 0) {
                                i13 = (i13 << 8) | read4;
                                i41 += 8;
                            } else {
                                throw new IOException("unexpected end of stream");
                            }
                        }
                        i12 = i41 - 1;
                        i38 = (i38 << 1) | ((i13 >> i12) & 1);
                        i5 = i40;
                    }
                    int i42 = i5;
                    i17 = iArr8[i38 - iArr10[i39]];
                    bZip2CompressorInputStream = this;
                    i8 = i19;
                    i16 = i42;
                } else {
                    throw new IOException("block overrun");
                }
            }
        }
        bZip2CompressorInputStream.last = i14;
        bZip2CompressorInputStream.bsLive = i12;
        bZip2CompressorInputStream.bsBuff = i13;
    }

    private int getAndMoveToFrontDecode0(int i) throws IOException {
        InputStream inputStream = this.in;
        Data data2 = this.data;
        byte b2 = data2.selector[i] & 255;
        int[] iArr = data2.limit[b2];
        int i2 = data2.minLens[b2];
        int bsR = bsR(i2);
        int i3 = this.bsLive;
        int i4 = this.bsBuff;
        while (bsR > iArr[i2]) {
            i2++;
            while (i3 < 1) {
                int read = inputStream.read();
                if (read >= 0) {
                    i4 = (i4 << 8) | read;
                    i3 += 8;
                } else {
                    throw new IOException("unexpected end of stream");
                }
            }
            i3--;
            bsR = (bsR << 1) | (1 & (i4 >> i3));
        }
        this.bsLive = i3;
        this.bsBuff = i4;
        return data2.perm[b2][bsR - data2.base[b2][i2]];
    }

    private static void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        int i6 = 0;
        while (i5 <= i2) {
            int i7 = i6;
            for (int i8 = 0; i8 < i3; i8++) {
                if (cArr[i8] == i5) {
                    iArr3[i7] = i8;
                    i7++;
                }
            }
            i5++;
            i6 = i7;
        }
        int i9 = 23;
        while (true) {
            i9--;
            if (i9 <= 0) {
                break;
            }
            iArr2[i9] = 0;
            iArr[i9] = 0;
        }
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = cArr[i10] + 1;
            iArr2[i11] = iArr2[i11] + 1;
        }
        int i12 = iArr2[0];
        for (int i13 = 1; i13 < 23; i13++) {
            i12 += iArr2[i13];
            iArr2[i13] = i12;
        }
        int i14 = iArr2[i];
        int i15 = i;
        while (i15 <= i2) {
            int i16 = i15 + 1;
            int i17 = iArr2[i16];
            int i18 = i4 + (i17 - i14);
            iArr[i15] = i18 - 1;
            i4 = i18 << 1;
            i15 = i16;
            i14 = i17;
        }
        for (int i19 = i + 1; i19 <= i2; i19++) {
            iArr2[i19] = ((iArr[i19 - 1] + 1) << 1) - iArr2[i19];
        }
    }

    private boolean init(boolean z) throws IOException {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            int read = inputStream.read();
            if (read == -1 && !z) {
                return false;
            }
            int read2 = this.in.read();
            int read3 = this.in.read();
            if (read == 66 && read2 == 90 && read3 == 104) {
                int read4 = this.in.read();
                if (read4 < 49 || read4 > 57) {
                    throw new IOException("BZip2 block size is invalid");
                }
                this.blockSize100k = read4 - 48;
                this.bsLive = 0;
                this.computedCombinedCRC = 0;
                return true;
            }
            throw new IOException(z ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream");
        }
        throw new IOException("No InputStream");
    }

    private void initBlock() throws IOException {
        do {
            char bsGetUByte = bsGetUByte();
            char bsGetUByte2 = bsGetUByte();
            char bsGetUByte3 = bsGetUByte();
            char bsGetUByte4 = bsGetUByte();
            char bsGetUByte5 = bsGetUByte();
            char bsGetUByte6 = bsGetUByte();
            if (bsGetUByte != 23 || bsGetUByte2 != 'r' || bsGetUByte3 != 'E' || bsGetUByte4 != '8' || bsGetUByte5 != 'P' || bsGetUByte6 != 144) {
                boolean z = false;
                if (bsGetUByte == '1' && bsGetUByte2 == 'A' && bsGetUByte3 == 'Y' && bsGetUByte4 == '&' && bsGetUByte5 == 'S' && bsGetUByte6 == 'Y') {
                    this.storedBlockCRC = bsGetInt();
                    if (bsR(1) == 1) {
                        z = true;
                    }
                    this.blockRandomised = z;
                    if (this.data == null) {
                        this.data = new Data(this.blockSize100k);
                    }
                    getAndMoveToFrontDecode();
                    this.crc.initialiseCRC();
                    this.currentState = 1;
                    return;
                }
                this.currentState = 0;
                throw new IOException("bad block header");
            }
        } while (!complete());
    }

    private void makeMaps() {
        Data data2 = this.data;
        boolean[] zArr = data2.inUse;
        byte[] bArr = data2.seqToUnseq;
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (zArr[i2]) {
                bArr[i] = (byte) i2;
                i++;
            }
        }
        this.nInUse = i;
    }

    public static boolean matches(byte[] bArr, int i) {
        return i >= 3 && bArr[0] == 66 && bArr[1] == 90 && bArr[2] == 104;
    }

    private int read0() throws IOException {
        switch (this.currentState) {
            case 0:
                return -1;
            case 1:
                return setupBlock();
            case 2:
                throw new IllegalStateException();
            case 3:
                return setupRandPartB();
            case 4:
                return setupRandPartC();
            case 5:
                throw new IllegalStateException();
            case 6:
                return setupNoRandPartB();
            case 7:
                return setupNoRandPartC();
            default:
                throw new IllegalStateException();
        }
    }

    private void recvDecodingTables() throws IOException {
        Data data2 = this.data;
        boolean[] zArr = data2.inUse;
        byte[] bArr = data2.recvDecodingTables_pos;
        byte[] bArr2 = data2.selector;
        byte[] bArr3 = data2.selectorMtf;
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            if (bsGetBit()) {
                i |= 1 << i2;
            }
        }
        int i3 = CpioConstants.C_IRUSR;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            zArr[i3] = false;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            if (((1 << i4) & i) != 0) {
                int i5 = i4 << 4;
                for (int i6 = 0; i6 < 16; i6++) {
                    if (bsGetBit()) {
                        zArr[i5 + i6] = true;
                    }
                }
            }
        }
        makeMaps();
        int i7 = this.nInUse + 2;
        int bsR = bsR(3);
        int bsR2 = bsR(15);
        for (int i8 = 0; i8 < bsR2; i8++) {
            int i9 = 0;
            while (bsGetBit()) {
                i9++;
            }
            bArr3[i8] = (byte) i9;
        }
        int i10 = bsR;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            }
            bArr[i10] = (byte) i10;
        }
        for (int i11 = 0; i11 < bsR2; i11++) {
            int i12 = bArr3[i11] & 255;
            byte b2 = bArr[i12];
            while (i12 > 0) {
                bArr[i12] = bArr[i12 - 1];
                i12--;
            }
            bArr[0] = b2;
            bArr2[i11] = b2;
        }
        char[][] cArr = data2.temp_charArray2d;
        for (int i13 = 0; i13 < bsR; i13++) {
            int bsR3 = bsR(5);
            char[] cArr2 = cArr[i13];
            int i14 = bsR3;
            for (int i15 = 0; i15 < i7; i15++) {
                while (bsGetBit()) {
                    i14 += bsGetBit() ? -1 : 1;
                }
                cArr2[i15] = (char) i14;
            }
        }
        createHuffmanDecodingTables(i7, bsR);
    }

    private int setupBlock() throws IOException {
        Data data2;
        if (this.currentState == 0 || (data2 = this.data) == null) {
            return -1;
        }
        int[] iArr = data2.cftab;
        int[] initTT = data2.initTT(this.last + 1);
        Data data3 = this.data;
        byte[] bArr = data3.ll8;
        iArr[0] = 0;
        System.arraycopy(data3.unzftab, 0, iArr, 1, CpioConstants.C_IRUSR);
        int i = iArr[0];
        for (int i2 = 1; i2 <= 256; i2++) {
            i += iArr[i2];
            iArr[i2] = i;
        }
        int i3 = this.last;
        for (int i4 = 0; i4 <= i3; i4++) {
            byte b2 = bArr[i4] & 255;
            int i5 = iArr[b2];
            iArr[b2] = i5 + 1;
            initTT[i5] = i4;
        }
        int i6 = this.origPtr;
        if (i6 < 0 || i6 >= initTT.length) {
            throw new IOException("stream corrupted");
        }
        this.su_tPos = initTT[i6];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = CpioConstants.C_IRUSR;
        if (!this.blockRandomised) {
            return setupNoRandPartA();
        }
        this.su_rNToGo = 0;
        this.su_rTPos = 0;
        return setupRandPartA();
    }

    private int setupNoRandPartA() throws IOException {
        int i = this.su_i2;
        if (i <= this.last) {
            this.su_chPrev = this.su_ch2;
            Data data2 = this.data;
            byte[] bArr = data2.ll8;
            int i2 = this.su_tPos;
            byte b2 = bArr[i2] & 255;
            this.su_ch2 = b2;
            this.su_tPos = data2.tt[i2];
            this.su_i2 = i + 1;
            this.currentState = 6;
            this.crc.updateCRC(b2);
            return b2;
        }
        this.currentState = 5;
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupNoRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.su_count = 1;
            return setupNoRandPartA();
        }
        int i = this.su_count + 1;
        this.su_count = i;
        if (i < 4) {
            return setupNoRandPartA();
        }
        Data data2 = this.data;
        byte[] bArr = data2.ll8;
        int i2 = this.su_tPos;
        this.su_z = (char) (bArr[i2] & 255);
        this.su_tPos = data2.tt[i2];
        this.su_j2 = 0;
        return setupNoRandPartC();
    }

    private int setupNoRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            int i = this.su_ch2;
            this.crc.updateCRC(i);
            this.su_j2++;
            this.currentState = 7;
            return i;
        }
        this.su_i2++;
        this.su_count = 0;
        return setupNoRandPartA();
    }

    private int setupRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            Data data2 = this.data;
            byte[] bArr = data2.ll8;
            int i = this.su_tPos;
            byte b2 = bArr[i] & 255;
            this.su_tPos = data2.tt[i];
            int i2 = this.su_rNToGo;
            byte b3 = 0;
            if (i2 == 0) {
                this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
                int i3 = this.su_rTPos + 1;
                this.su_rTPos = i3;
                if (i3 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo = i2 - 1;
            }
            if (this.su_rNToGo == 1) {
                b3 = 1;
            }
            byte b4 = b2 ^ b3;
            this.su_ch2 = b4;
            this.su_i2++;
            this.currentState = 3;
            this.crc.updateCRC(b4);
            return b4;
        }
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.currentState = 2;
            this.su_count = 1;
            return setupRandPartA();
        }
        int i = this.su_count + 1;
        this.su_count = i;
        if (i >= 4) {
            Data data2 = this.data;
            byte[] bArr = data2.ll8;
            int i2 = this.su_tPos;
            this.su_z = (char) (bArr[i2] & 255);
            this.su_tPos = data2.tt[i2];
            int i3 = this.su_rNToGo;
            if (i3 == 0) {
                this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
                int i4 = this.su_rTPos + 1;
                this.su_rTPos = i4;
                if (i4 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo = i3 - 1;
            }
            this.su_j2 = 0;
            this.currentState = 4;
            if (this.su_rNToGo == 1) {
                this.su_z = (char) (this.su_z ^ 1);
            }
            return setupRandPartC();
        }
        this.currentState = 2;
        return setupRandPartA();
    }

    private int setupRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            this.crc.updateCRC(this.su_ch2);
            this.su_j2++;
            return this.su_ch2;
        }
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    public void close() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                if (inputStream != System.in) {
                    inputStream.close();
                }
            } finally {
                this.data = null;
                this.in = null;
            }
        }
    }

    public int read() throws IOException {
        if (this.in != null) {
            int read0 = read0();
            count(read0 < 0 ? -1 : 1);
            return read0;
        }
        throw new IOException("stream closed");
    }

    public BZip2CompressorInputStream(InputStream inputStream, boolean z) throws IOException {
        this.crc = new CRC();
        this.currentState = 1;
        this.in = inputStream;
        this.decompressConcatenated = z;
        init(true);
        initBlock();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offs(" + i + ") < 0.");
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                throw new IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > dest.length(" + bArr.length + ").");
            } else if (this.in != null) {
                int i4 = i;
                while (i4 < i3) {
                    int read0 = read0();
                    if (read0 < 0) {
                        break;
                    }
                    bArr[i4] = (byte) read0;
                    count(1);
                    i4++;
                }
                if (i4 == i) {
                    return -1;
                }
                return i4 - i;
            } else {
                throw new IOException("stream closed");
            }
        } else {
            throw new IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
    }
}
