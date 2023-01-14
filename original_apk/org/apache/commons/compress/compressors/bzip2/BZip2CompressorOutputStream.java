package org.apache.commons.compress.compressors.bzip2;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream extends CompressorOutputStream implements BZip2Constants {
    private static final int GREATER_ICOST = 15;
    private static final int LESSER_ICOST = 0;
    public static final int MAX_BLOCKSIZE = 9;
    public static final int MIN_BLOCKSIZE = 1;
    private final int allowableBlockSize;
    private int blockCRC;
    private final int blockSize100k;
    private BlockSort blockSorter;
    private int bsBuff;
    private int bsLive;
    private int combinedCRC;
    private final CRC crc;
    private int currentChar;
    private Data data;
    private int last;
    private int nInUse;
    private int nMTF;
    private OutputStream out;
    private int runLength;

    static final class Data {
        final byte[] block;
        final int[] fmap;
        final byte[] generateMTFValues_yy = new byte[CpioConstants.C_IRUSR];
        final int[] heap = new int[260];
        final boolean[] inUse = new boolean[CpioConstants.C_IRUSR];
        final int[] mtfFreq = new int[BZip2Constants.MAX_ALPHA_SIZE];
        int origPtr;
        final int[] parent = new int[516];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] sendMTFValues2_pos = new byte[6];
        final int[][] sendMTFValues_code = ((int[][]) Array.newInstance(int.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        final short[] sendMTFValues_cost = new short[6];
        final int[] sendMTFValues_fave = new int[6];
        final byte[][] sendMTFValues_len = ((byte[][]) Array.newInstance(byte.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        final int[][] sendMTFValues_rfreq = ((int[][]) Array.newInstance(int.class, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));
        final boolean[] sentMTFValues4_inUse16 = new boolean[16];
        final char[] sfmap;
        final byte[] unseqToSeq = new byte[CpioConstants.C_IRUSR];
        final int[] weight = new int[516];

        Data(int i) {
            int i2 = i * BZip2Constants.BASEBLOCKSIZE;
            this.block = new byte[(i2 + 1 + 20)];
            this.fmap = new int[i2];
            this.sfmap = new char[(i2 * 2)];
        }
    }

    public BZip2CompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    private void blockSort() {
        this.blockSorter.blockSort(this.data, this.last);
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            this.out.write(this.bsBuff >> 24);
            this.bsBuff <<= 8;
            this.bsLive -= 8;
        }
    }

    private void bsPutInt(int i) throws IOException {
        bsW(8, (i >> 24) & 255);
        bsW(8, (i >> 16) & 255);
        bsW(8, (i >> 8) & 255);
        bsW(8, i & 255);
    }

    private void bsPutUByte(int i) throws IOException {
        bsW(8, i);
    }

    private void bsW(int i, int i2) throws IOException {
        OutputStream outputStream = this.out;
        int i3 = this.bsLive;
        int i4 = this.bsBuff;
        while (i3 >= 8) {
            outputStream.write(i4 >> 24);
            i4 <<= 8;
            i3 -= 8;
        }
        this.bsBuff = (i2 << ((32 - i3) - i)) | i4;
        this.bsLive = i3 + i;
    }

    public static int chooseBlockSize(long j) {
        if (j > 0) {
            return (int) Math.min((j / 132000) + 1, 9);
        }
        return 9;
    }

    private void endBlock() throws IOException {
        this.blockCRC = this.crc.getFinalCRC();
        int i = this.combinedCRC;
        this.combinedCRC = (i >>> 31) | (i << 1);
        this.combinedCRC ^= this.blockCRC;
        if (this.last != -1) {
            blockSort();
            bsPutUByte(49);
            bsPutUByte(65);
            bsPutUByte(89);
            bsPutUByte(38);
            bsPutUByte(83);
            bsPutUByte(89);
            bsPutInt(this.blockCRC);
            bsW(1, 0);
            moveToFrontCodeAndSend();
        }
    }

    private void endCompression() throws IOException {
        bsPutUByte(23);
        bsPutUByte(114);
        bsPutUByte(69);
        bsPutUByte(56);
        bsPutUByte(80);
        bsPutUByte(144);
        bsPutInt(this.combinedCRC);
        bsFinishedWithStream();
    }

    private void generateMTFValues() {
        int i;
        int i2 = this.last;
        Data data2 = this.data;
        boolean[] zArr = data2.inUse;
        byte[] bArr = data2.block;
        int[] iArr = data2.fmap;
        char[] cArr = data2.sfmap;
        int[] iArr2 = data2.mtfFreq;
        byte[] bArr2 = data2.unseqToSeq;
        byte[] bArr3 = data2.generateMTFValues_yy;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            if (zArr[i4]) {
                bArr2[i4] = (byte) i3;
                i3++;
            }
        }
        this.nInUse = i3;
        int i5 = i3 + 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            iArr2[i6] = 0;
        }
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            bArr3[i3] = (byte) i3;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 <= i2; i9++) {
            byte b2 = bArr2[bArr[iArr[i9]] & 255];
            byte b3 = bArr3[0];
            int i10 = 0;
            while (b2 != b3) {
                i10++;
                byte b4 = bArr3[i10];
                bArr3[i10] = b3;
                b3 = b4;
            }
            bArr3[0] = b3;
            if (i10 == 0) {
                i7++;
            } else {
                if (i7 > 0) {
                    int i11 = i7 - 1;
                    while (true) {
                        if ((i11 & 1) == 0) {
                            cArr[i8] = 0;
                            i8++;
                            iArr2[0] = iArr2[0] + 1;
                        } else {
                            cArr[i8] = 1;
                            i8++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i11 < 2) {
                            break;
                        }
                        i11 = (i11 - 2) >> 1;
                    }
                    i7 = 0;
                }
                int i12 = i10 + 1;
                cArr[i8] = (char) i12;
                i8++;
                iArr2[i12] = iArr2[i12] + 1;
            }
        }
        if (i7 > 0) {
            int i13 = i7 - 1;
            while (true) {
                if ((i13 & 1) == 0) {
                    cArr[i8] = 0;
                    i = i8 + 1;
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    cArr[i8] = 1;
                    i = i8 + 1;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i13 < 2) {
                    break;
                }
                i13 = (i13 - 2) >> 1;
            }
        }
        cArr[i8] = (char) i5;
        iArr2[i5] = iArr2[i5] + 1;
        this.nMTF = i8 + 1;
    }

    private static void hbAssignCodes(int[] iArr, byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            int i5 = i4;
            for (int i6 = 0; i6 < i3; i6++) {
                if ((bArr[i6] & 255) == i) {
                    iArr[i6] = i5;
                    i5++;
                }
            }
            i4 = i5 << 1;
            i++;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0093, code lost:
        if (r3[r2[r11]] < r3[r2[r10]]) goto L_0x0097;
     */
    private static void hbMakeCodeLengths(byte[] r17, int[] r18, org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.Data r19, int r20, int r21) {
        /*
            r0 = r19
            r1 = r20
            int[] r2 = r0.heap
            int[] r3 = r0.weight
            int[] r0 = r0.parent
            r4 = r1
        L_0x000b:
            r5 = -1
            int r4 = r4 + r5
            r6 = 1
            if (r4 < 0) goto L_0x001e
            int r5 = r4 + 1
            r7 = r18[r4]
            if (r7 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r6 = r18[r4]
        L_0x0019:
            int r6 = r6 << 8
            r3[r5] = r6
            goto L_0x000b
        L_0x001e:
            r4 = 1
        L_0x001f:
            if (r4 == 0) goto L_0x0119
            r4 = 0
            r2[r4] = r4
            r3[r4] = r4
            r7 = -2
            r0[r4] = r7
            r7 = 1
            r8 = 0
        L_0x002b:
            if (r7 > r1) goto L_0x004b
            r0[r7] = r5
            int r8 = r8 + 1
            r2[r8] = r7
            r9 = r2[r8]
            r10 = r8
        L_0x0036:
            r11 = r3[r9]
            int r12 = r10 >> 1
            r13 = r2[r12]
            r13 = r3[r13]
            if (r11 >= r13) goto L_0x0046
            r11 = r2[r12]
            r2[r10] = r11
            r10 = r12
            goto L_0x0036
        L_0x0046:
            r2[r10] = r9
            int r7 = r7 + 1
            goto L_0x002b
        L_0x004b:
            r7 = r1
        L_0x004c:
            if (r8 <= r6) goto L_0x00e8
            r9 = r2[r6]
            r10 = r2[r8]
            r2[r6] = r10
            int r8 = r8 + -1
            r10 = r2[r6]
            r11 = 1
        L_0x0059:
            int r12 = r11 << 1
            if (r12 <= r8) goto L_0x005e
            goto L_0x0075
        L_0x005e:
            if (r12 >= r8) goto L_0x006d
            int r13 = r12 + 1
            r14 = r2[r13]
            r14 = r3[r14]
            r15 = r2[r12]
            r15 = r3[r15]
            if (r14 >= r15) goto L_0x006d
            r12 = r13
        L_0x006d:
            r13 = r3[r10]
            r14 = r2[r12]
            r14 = r3[r14]
            if (r13 >= r14) goto L_0x00e0
        L_0x0075:
            r2[r11] = r10
            r13 = r2[r6]
            r10 = r2[r8]
            r2[r6] = r10
            int r14 = r8 + -1
            r15 = r2[r6]
            r8 = 1
        L_0x0082:
            int r10 = r8 << 1
            if (r10 <= r14) goto L_0x0087
            goto L_0x009f
        L_0x0087:
            if (r10 >= r14) goto L_0x0096
            int r11 = r10 + 1
            r12 = r2[r11]
            r12 = r3[r12]
            r16 = r2[r10]
            r4 = r3[r16]
            if (r12 >= r4) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r11 = r10
        L_0x0097:
            r4 = r3[r15]
            r10 = r2[r11]
            r10 = r3[r10]
            if (r4 >= r10) goto L_0x00d9
        L_0x009f:
            r2[r8] = r15
            int r7 = r7 + r6
            r0[r13] = r7
            r0[r9] = r7
            r4 = r3[r9]
            r8 = r3[r13]
            r9 = r4 & -256(0xffffffffffffff00, float:NaN)
            r10 = r8 & -256(0xffffffffffffff00, float:NaN)
            int r9 = r9 + r10
            r4 = r4 & 255(0xff, float:3.57E-43)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r4 <= r8) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r4 = r8
        L_0x00b7:
            int r4 = r4 + r6
            r4 = r4 | r9
            r3[r7] = r4
            r0[r7] = r5
            int r8 = r14 + 1
            r2[r8] = r7
            r4 = r2[r8]
            r9 = r3[r4]
            r10 = r8
        L_0x00c6:
            int r11 = r10 >> 1
            r12 = r2[r11]
            r12 = r3[r12]
            if (r9 >= r12) goto L_0x00d4
            r12 = r2[r11]
            r2[r10] = r12
            r10 = r11
            goto L_0x00c6
        L_0x00d4:
            r2[r10] = r4
            r4 = 0
            goto L_0x004c
        L_0x00d9:
            r4 = r2[r11]
            r2[r8] = r4
            r8 = r11
            r4 = 0
            goto L_0x0082
        L_0x00e0:
            r4 = r2[r12]
            r2[r11] = r4
            r11 = r12
            r4 = 0
            goto L_0x0059
        L_0x00e8:
            r4 = 1
            r7 = 0
        L_0x00ea:
            if (r4 > r1) goto L_0x0102
            r8 = r4
            r9 = 0
        L_0x00ee:
            r8 = r0[r8]
            if (r8 < 0) goto L_0x00f5
            int r9 = r9 + 1
            goto L_0x00ee
        L_0x00f5:
            int r8 = r4 + -1
            byte r10 = (byte) r9
            r17[r8] = r10
            r8 = r21
            if (r9 <= r8) goto L_0x00ff
            r7 = 1
        L_0x00ff:
            int r4 = r4 + 1
            goto L_0x00ea
        L_0x0102:
            r8 = r21
            if (r7 == 0) goto L_0x0116
            r4 = 1
        L_0x0107:
            if (r4 >= r1) goto L_0x0116
            r9 = r3[r4]
            int r9 = r9 >> 8
            int r9 = r9 >> r6
            int r9 = r9 + r6
            int r9 = r9 << 8
            r3[r4] = r9
            int r4 = r4 + 1
            goto L_0x0107
        L_0x0116:
            r4 = r7
            goto L_0x001f
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.hbMakeCodeLengths(byte[], int[], org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream$Data, int, int):void");
    }

    private void init() throws IOException {
        bsPutUByte(66);
        bsPutUByte(90);
        this.data = new Data(this.blockSize100k);
        this.blockSorter = new BlockSort(this.data);
        bsPutUByte(104);
        bsPutUByte(this.blockSize100k + 48);
        this.combinedCRC = 0;
        initBlock();
    }

    private void initBlock() {
        this.crc.initialiseCRC();
        this.last = -1;
        boolean[] zArr = this.data.inUse;
        int i = CpioConstants.C_IRUSR;
        while (true) {
            i--;
            if (i >= 0) {
                zArr[i] = false;
            } else {
                return;
            }
        }
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsW(24, this.data.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private void sendMTFValues() throws IOException {
        byte[][] bArr = this.data.sendMTFValues_len;
        int i = 2;
        int i2 = this.nInUse + 2;
        int i3 = 6;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i3];
            int i4 = i2;
            while (true) {
                i4--;
                if (i4 >= 0) {
                    bArr2[i4] = 15;
                }
            }
        }
        int i5 = this.nMTF;
        if (i5 >= 200) {
            i = i5 < 600 ? 3 : i5 < 1200 ? 4 : i5 < 2400 ? 5 : 6;
        }
        sendMTFValues0(i, i2);
        int sendMTFValues1 = sendMTFValues1(i, i2);
        sendMTFValues2(i, sendMTFValues1);
        sendMTFValues3(i, i2);
        sendMTFValues4();
        sendMTFValues5(i, sendMTFValues1);
        sendMTFValues6(i, i2);
        sendMTFValues7();
    }

    private void sendMTFValues0(int i, int i2) {
        int i3;
        Data data2 = this.data;
        byte[][] bArr = data2.sendMTFValues_len;
        int[] iArr = data2.mtfFreq;
        int i4 = this.nMTF;
        int i5 = 0;
        for (int i6 = i; i6 > 0; i6--) {
            int i7 = i4 / i6;
            int i8 = i2 - 1;
            int i9 = i5 - 1;
            int i10 = 0;
            while (i10 < i7 && i9 < i8) {
                i9++;
                i10 += iArr[i9];
            }
            if (i9 <= i5 || i6 == i || i6 == 1 || (1 & (i - i6)) == 0) {
                i3 = i9;
            } else {
                i3 = i9 - 1;
                i10 -= iArr[i9];
            }
            byte[] bArr2 = bArr[i6 - 1];
            int i11 = i2;
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                } else if (i11 < i5 || i11 > i3) {
                    bArr2[i11] = 15;
                } else {
                    bArr2[i11] = 0;
                }
            }
            i5 = i3 + 1;
            i4 -= i10;
        }
    }

    private int sendMTFValues1(int i, int i2) {
        byte[] bArr;
        int i3;
        BZip2CompressorOutputStream bZip2CompressorOutputStream = this;
        int i4 = i;
        Data data2 = bZip2CompressorOutputStream.data;
        int[][] iArr = data2.sendMTFValues_rfreq;
        int[] iArr2 = data2.sendMTFValues_fave;
        short[] sArr = data2.sendMTFValues_cost;
        char[] cArr = data2.sfmap;
        byte[] bArr2 = data2.selector;
        byte[][] bArr3 = data2.sendMTFValues_len;
        int i5 = 0;
        byte[] bArr4 = bArr3[0];
        byte[] bArr5 = bArr3[1];
        byte[] bArr6 = bArr3[2];
        byte[] bArr7 = bArr3[3];
        byte[] bArr8 = bArr3[4];
        byte[] bArr9 = bArr3[5];
        int i6 = bZip2CompressorOutputStream.nMTF;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 4; i7 < i9; i9 = 4) {
            int i10 = i4;
            while (true) {
                i10--;
                if (i10 < 0) {
                    break;
                }
                iArr2[i10] = i5;
                int[] iArr3 = iArr[i10];
                int i11 = i2;
                while (true) {
                    i11--;
                    if (i11 >= 0) {
                        iArr3[i11] = i5;
                    }
                }
            }
            int i12 = 0;
            i8 = 0;
            while (i12 < bZip2CompressorOutputStream.nMTF) {
                int i13 = i12;
                int min = Math.min((i12 + 50) - 1, i6 - 1);
                if (i4 == 6) {
                    int i14 = i13;
                    short s = 0;
                    short s2 = 0;
                    short s3 = 0;
                    short s4 = 0;
                    short s5 = 0;
                    short s6 = 0;
                    while (i14 <= min) {
                        char c2 = cArr[i14];
                        short s7 = (short) (s2 + (bArr5[c2] & 255));
                        short s8 = (short) (s3 + (bArr6[c2] & 255));
                        short s9 = (short) (s4 + (bArr7[c2] & 255));
                        short s10 = (short) (s5 + (bArr8[c2] & 255));
                        i14++;
                        s6 = (short) (s6 + (bArr9[c2] & 255));
                        s5 = s10;
                        bArr4 = bArr4;
                        s4 = s9;
                        s3 = s8;
                        s2 = s7;
                        s = (short) (s + (bArr4[c2] & 255));
                        i6 = i6;
                    }
                    bArr = bArr4;
                    i3 = i6;
                    sArr[0] = s;
                    sArr[1] = s2;
                    sArr[2] = s3;
                    sArr[3] = s4;
                    sArr[4] = s5;
                    sArr[5] = s6;
                } else {
                    bArr = bArr4;
                    i3 = i6;
                    int i15 = i4;
                    while (true) {
                        i15--;
                        if (i15 < 0) {
                            break;
                        }
                        sArr[i15] = 0;
                    }
                    for (int i16 = i13; i16 <= min; i16++) {
                        char c3 = cArr[i16];
                        int i17 = i4;
                        while (true) {
                            i17--;
                            if (i17 < 0) {
                                break;
                            }
                            sArr[i17] = (short) (sArr[i17] + (bArr3[i17][c3] & 255));
                        }
                    }
                }
                int i18 = i4;
                int i19 = -1;
                short s11 = 999999999;
                while (true) {
                    i18--;
                    if (i18 < 0) {
                        break;
                    }
                    byte[] bArr10 = bArr5;
                    short s12 = sArr[i18];
                    if (s12 < s11) {
                        i19 = i18;
                        s11 = s12;
                    }
                    bArr5 = bArr10;
                }
                byte[] bArr11 = bArr5;
                iArr2[i19] = iArr2[i19] + 1;
                bArr2[i8] = (byte) i19;
                i8++;
                int[] iArr4 = iArr[i19];
                for (int i20 = i13; i20 <= min; i20++) {
                    char c4 = cArr[i20];
                    iArr4[c4] = iArr4[c4] + 1;
                }
                i12 = min + 1;
                bArr5 = bArr11;
                i6 = i3;
                bArr4 = bArr;
            }
            byte[] bArr12 = bArr4;
            byte[] bArr13 = bArr5;
            int i21 = i6;
            int i22 = 0;
            while (i22 < i4) {
                hbMakeCodeLengths(bArr3[i22], iArr[i22], bZip2CompressorOutputStream.data, i2, 20);
                i22++;
                bZip2CompressorOutputStream = this;
            }
            int i23 = i2;
            i7++;
            bZip2CompressorOutputStream = this;
            bArr5 = bArr13;
            i6 = i21;
            bArr4 = bArr12;
            i5 = 0;
        }
        return i8;
    }

    private void sendMTFValues2(int i, int i2) {
        Data data2 = this.data;
        byte[] bArr = data2.sendMTFValues2_pos;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            bArr[i] = (byte) i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = data2.selector[i3];
            byte b3 = bArr[0];
            int i4 = 0;
            while (b2 != b3) {
                i4++;
                byte b4 = bArr[i4];
                bArr[i4] = b3;
                b3 = b4;
            }
            bArr[0] = b3;
            data2.selectorMtf[i3] = (byte) i4;
        }
    }

    private void sendMTFValues3(int i, int i2) {
        Data data2 = this.data;
        int[][] iArr = data2.sendMTFValues_code;
        byte[][] bArr = data2.sendMTFValues_len;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr2 = bArr[i3];
            int i4 = i2;
            byte b2 = 32;
            byte b3 = 0;
            while (true) {
                i4--;
                if (i4 < 0) {
                    break;
                }
                byte b4 = bArr2[i4] & 255;
                if (b4 > b3) {
                    b3 = b4;
                }
                if (b4 < b2) {
                    b2 = b4;
                }
            }
            hbAssignCodes(iArr[i3], bArr[i3], b2, b3, i2);
        }
    }

    private void sendMTFValues4() throws IOException {
        Data data2 = this.data;
        boolean[] zArr = data2.inUse;
        boolean[] zArr2 = data2.sentMTFValues4_inUse16;
        int i = 16;
        while (true) {
            i--;
            if (i < 0) {
                break;
            }
            zArr2[i] = false;
            int i2 = i * 16;
            int i3 = 16;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    if (zArr[i2 + i3]) {
                        zArr2[i] = true;
                    }
                }
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            bsW(1, zArr2[i4] ? 1 : 0);
        }
        OutputStream outputStream = this.out;
        int i5 = this.bsLive;
        int i6 = this.bsBuff;
        int i7 = i5;
        for (int i8 = 0; i8 < 16; i8++) {
            if (zArr2[i8]) {
                int i9 = i8 * 16;
                int i10 = i6;
                for (int i11 = 0; i11 < 16; i11++) {
                    while (i7 >= 8) {
                        outputStream.write(i10 >> 24);
                        i10 <<= 8;
                        i7 -= 8;
                    }
                    if (zArr[i9 + i11]) {
                        i10 |= 1 << ((32 - i7) - 1);
                    }
                    i7++;
                }
                i6 = i10;
            }
        }
        this.bsBuff = i6;
        this.bsLive = i7;
    }

    private void sendMTFValues5(int i, int i2) throws IOException {
        bsW(3, i);
        bsW(15, i2);
        OutputStream outputStream = this.out;
        byte[] bArr = this.data.selectorMtf;
        int i3 = this.bsLive;
        int i4 = this.bsBuff;
        int i5 = i3;
        for (int i6 = 0; i6 < i2; i6++) {
            byte b2 = bArr[i6] & 255;
            int i7 = i5;
            int i8 = i4;
            for (int i9 = 0; i9 < b2; i9++) {
                while (i7 >= 8) {
                    outputStream.write(i8 >> 24);
                    i8 <<= 8;
                    i7 -= 8;
                }
                i8 |= 1 << ((32 - i7) - 1);
                i7++;
            }
            i4 = i8;
            while (i7 >= 8) {
                outputStream.write(i4 >> 24);
                i4 <<= 8;
                i7 -= 8;
            }
            i5 = i7 + 1;
        }
        this.bsBuff = i4;
        this.bsLive = i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendMTFValues6(int r18, int r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream$Data r1 = r0.data
            byte[][] r1 = r1.sendMTFValues_len
            java.io.OutputStream r2 = r0.out
            int r3 = r0.bsLive
            int r4 = r0.bsBuff
            r5 = 0
            r7 = r3
            r6 = r4
            r4 = 0
            r3 = r18
        L_0x0012:
            if (r4 >= r3) goto L_0x0085
            r8 = r1[r4]
            byte r9 = r8[r5]
            r9 = r9 & 255(0xff, float:3.57E-43)
        L_0x001a:
            r10 = 8
            if (r7 < r10) goto L_0x0028
            int r10 = r6 >> 24
            r2.write(r10)
            int r6 = r6 << 8
            int r7 = r7 + -8
            goto L_0x001a
        L_0x0028:
            int r11 = 32 - r7
            int r11 = r11 + -5
            int r11 = r9 << r11
            r6 = r6 | r11
            int r7 = r7 + 5
            r11 = r6
            r12 = r9
            r6 = 0
            r9 = r19
        L_0x0036:
            if (r6 >= r9) goto L_0x0081
            byte r13 = r8[r6]
            r13 = r13 & 255(0xff, float:3.57E-43)
        L_0x003c:
            r14 = 2
            if (r12 >= r13) goto L_0x0055
        L_0x003f:
            if (r7 < r10) goto L_0x004b
            int r15 = r11 >> 24
            r2.write(r15)
            int r11 = r11 << 8
            int r7 = r7 + -8
            goto L_0x003f
        L_0x004b:
            int r15 = 32 - r7
            int r15 = r15 - r14
            int r14 = r14 << r15
            r11 = r11 | r14
            int r7 = r7 + 2
            int r12 = r12 + 1
            goto L_0x003c
        L_0x0055:
            if (r12 <= r13) goto L_0x0070
        L_0x0057:
            if (r7 < r10) goto L_0x0063
            int r15 = r11 >> 24
            r2.write(r15)
            int r11 = r11 << 8
            int r7 = r7 + -8
            goto L_0x0057
        L_0x0063:
            r15 = 3
            int r16 = 32 - r7
            int r16 = r16 + -2
            int r15 = r15 << r16
            r11 = r11 | r15
            int r7 = r7 + 2
            int r12 = r12 + -1
            goto L_0x0055
        L_0x0070:
            if (r7 < r10) goto L_0x007c
            int r13 = r11 >> 24
            r2.write(r13)
            int r11 = r11 << 8
            int r7 = r7 + -8
            goto L_0x0070
        L_0x007c:
            int r7 = r7 + 1
            int r6 = r6 + 1
            goto L_0x0036
        L_0x0081:
            int r4 = r4 + 1
            r6 = r11
            goto L_0x0012
        L_0x0085:
            r0.bsBuff = r6
            r0.bsLive = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.sendMTFValues6(int, int):void");
    }

    private void sendMTFValues7() throws IOException {
        Data data2 = this.data;
        byte[][] bArr = data2.sendMTFValues_len;
        int[][] iArr = data2.sendMTFValues_code;
        OutputStream outputStream = this.out;
        byte[] bArr2 = data2.selector;
        char[] cArr = data2.sfmap;
        int i = this.nMTF;
        int i2 = this.bsLive;
        int i3 = this.bsBuff;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int min = Math.min((i4 + 50) - 1, i - 1);
            byte b2 = bArr2[i5] & 255;
            int[] iArr2 = iArr[b2];
            byte[] bArr3 = bArr[b2];
            while (i4 <= min) {
                char c2 = cArr[i4];
                while (i2 >= 8) {
                    outputStream.write(i3 >> 24);
                    i3 <<= 8;
                    i2 -= 8;
                }
                byte b3 = bArr3[c2] & 255;
                i3 |= iArr2[c2] << ((32 - i2) - b3);
                i2 += b3;
                i4++;
            }
            i4 = min + 1;
            i5++;
        }
        this.bsBuff = i3;
        this.bsLive = i2;
    }

    private void write0(int i) throws IOException {
        int i2 = this.currentChar;
        if (i2 != -1) {
            int i3 = i & 255;
            if (i2 == i3) {
                int i4 = this.runLength + 1;
                this.runLength = i4;
                if (i4 > 254) {
                    writeRun();
                    this.currentChar = -1;
                    this.runLength = 0;
                    return;
                }
                return;
            }
            writeRun();
            this.runLength = 1;
            this.currentChar = i3;
            return;
        }
        this.currentChar = i & 255;
        this.runLength++;
    }

    private void writeRun() throws IOException {
        int i = this.last;
        if (i < this.allowableBlockSize) {
            int i2 = this.currentChar;
            Data data2 = this.data;
            data2.inUse[i2] = true;
            byte b2 = (byte) i2;
            int i3 = this.runLength;
            this.crc.updateCRC(i2, i3);
            if (i3 == 1) {
                data2.block[i + 2] = b2;
                this.last = i + 1;
            } else if (i3 == 2) {
                byte[] bArr = data2.block;
                int i4 = i + 2;
                bArr[i4] = b2;
                bArr[i + 3] = b2;
                this.last = i4;
            } else if (i3 != 3) {
                int i5 = i3 - 4;
                data2.inUse[i5] = true;
                byte[] bArr2 = data2.block;
                bArr2[i + 2] = b2;
                bArr2[i + 3] = b2;
                bArr2[i + 4] = b2;
                int i6 = i + 5;
                bArr2[i6] = b2;
                bArr2[i + 6] = (byte) i5;
                this.last = i6;
            } else {
                byte[] bArr3 = data2.block;
                bArr3[i + 2] = b2;
                int i7 = i + 3;
                bArr3[i7] = b2;
                bArr3[i + 4] = b2;
                this.last = i7;
            }
        } else {
            endBlock();
            initBlock();
            writeRun();
        }
    }

    public void close() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            finish();
            outputStream.close();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() throws IOException {
        if (this.out != null) {
            try {
                if (this.runLength > 0) {
                    writeRun();
                }
                this.currentChar = -1;
                endBlock();
                endCompression();
            } finally {
                this.out = null;
                this.data = null;
                this.blockSorter = null;
            }
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public final int getBlockSize() {
        return this.blockSize100k;
    }

    public void write(int i) throws IOException {
        if (this.out != null) {
            write0(i);
            return;
        }
        throw new IOException("closed");
    }

    public BZip2CompressorOutputStream(OutputStream outputStream, int i) throws IOException {
        this.crc = new CRC();
        this.currentChar = -1;
        this.runLength = 0;
        if (i < 1) {
            throw new IllegalArgumentException("blockSize(" + i + ") < 1");
        } else if (i <= 9) {
            this.blockSize100k = i;
            this.out = outputStream;
            this.allowableBlockSize = (this.blockSize100k * BZip2Constants.BASEBLOCKSIZE) - 20;
            init();
        } else {
            throw new IllegalArgumentException("blockSize(" + i + ") > 9");
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offs(" + i + ") < 0.");
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                throw new IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > buf.length(" + bArr.length + ").");
            } else if (this.out != null) {
                while (i < i3) {
                    write0(bArr[i]);
                    i++;
                }
            } else {
                throw new IOException("stream closed");
            }
        } else {
            throw new IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
    }
}
