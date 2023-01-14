package org.apache.commons.compress.compressors.bzip2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.BitSet;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final int[] ftab = new int[65537];
    private final boolean[] mainSort_bigDone = new boolean[CpioConstants.C_IRUSR];
    private final int[] mainSort_copy = new int[CpioConstants.C_IRUSR];
    private final int[] mainSort_runningOrder = new int[CpioConstants.C_IRUSR];
    private final char[] quadrant;
    private final int[] stack_dd = new int[TarArchiveEntry.MILLIS_PER_SECOND];
    private final int[] stack_hh = new int[TarArchiveEntry.MILLIS_PER_SECOND];
    private final int[] stack_ll = new int[TarArchiveEntry.MILLIS_PER_SECOND];
    private int workDone;
    private int workLimit;

    BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.sfmap;
    }

    private void fallbackQSort3(int[] iArr, int[] iArr2, int i, int i2) {
        int i3;
        int i4;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c2 = 0;
        fpush(0, i, i2);
        long j = 0;
        int i5 = 1;
        long j2 = 0;
        int i6 = 1;
        while (i6 > 0) {
            i6--;
            int[] fpop = fpop(i6);
            int i7 = fpop[c2];
            int i8 = fpop[i5];
            if (i8 - i7 < 10) {
                fallbackSimpleSort(iArr3, iArr4, i7, i8);
            } else {
                j2 = ((j2 * 7621) + 1) % PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                long j3 = j2 % 3;
                if (j3 == j) {
                    i3 = iArr4[iArr3[i7]];
                } else if (j3 == 1) {
                    i3 = iArr4[iArr3[(i7 + i8) >>> i5]];
                } else {
                    i3 = iArr4[iArr3[i8]];
                }
                long j4 = (long) i3;
                int i9 = i8;
                int i10 = i9;
                int i11 = i7;
                int i12 = i11;
                while (true) {
                    if (i12 <= i9) {
                        int i13 = iArr4[iArr3[i12]] - ((int) j4);
                        if (i13 == 0) {
                            fswap(iArr3, i12, i11);
                            i11++;
                            i12++;
                        } else if (i13 <= 0) {
                            i12++;
                        }
                    }
                    i4 = i10;
                    while (i12 <= i9) {
                        int i14 = iArr4[iArr3[i9]] - ((int) j4);
                        if (i14 == 0) {
                            fswap(iArr3, i9, i4);
                            i4--;
                        } else if (i14 < 0) {
                            break;
                        }
                        i9--;
                    }
                    if (i12 > i9) {
                        break;
                    }
                    fswap(iArr3, i12, i9);
                    i12++;
                    i9--;
                    i10 = i4;
                }
                if (i4 >= i11) {
                    int fmin = fmin(i11 - i7, i12 - i11);
                    fvswap(iArr3, i7, i12 - fmin, fmin);
                    int i15 = i8 - i4;
                    int i16 = i4 - i9;
                    int fmin2 = fmin(i15, i16);
                    fvswap(iArr3, i9 + 1, (i8 - fmin2) + 1, fmin2);
                    int i17 = ((i12 + i7) - i11) - 1;
                    int i18 = (i8 - i16) + 1;
                    if (i17 - i7 > i8 - i18) {
                        int i19 = i6 + 1;
                        fpush(i6, i7, i17);
                        fpush(i19, i18, i8);
                        i6 = i19 + 1;
                    } else {
                        int i20 = i6 + 1;
                        fpush(i6, i18, i8);
                        fpush(i20, i7, i17);
                        i6 = i20 + 1;
                    }
                }
                c2 = 0;
                j = 0;
                i5 = 1;
            }
        }
    }

    private void fallbackSimpleSort(int[] iArr, int[] iArr2, int i, int i2) {
        if (i != i2) {
            if (i2 - i > 3) {
                for (int i3 = i2 - 4; i3 >= i; i3--) {
                    int i4 = iArr[i3];
                    int i5 = iArr2[i4];
                    int i6 = i3 + 4;
                    while (i6 <= i2 && i5 > iArr2[iArr[i6]]) {
                        iArr[i6 - 4] = iArr[i6];
                        i6 += 4;
                    }
                    iArr[i6 - 4] = i4;
                }
            }
            for (int i7 = i2 - 1; i7 >= i; i7--) {
                int i8 = iArr[i7];
                int i9 = iArr2[i8];
                int i10 = i7 + 1;
                while (i10 <= i2 && i9 > iArr2[iArr[i10]]) {
                    iArr[i10 - 1] = iArr[i10];
                    i10++;
                }
                iArr[i10 - 1] = i8;
            }
        }
    }

    private int fmin(int i, int i2) {
        return i < i2 ? i : i2;
    }

    private int[] fpop(int i) {
        return new int[]{this.stack_ll[i], this.stack_hh[i]};
    }

    private void fpush(int i, int i2, int i3) {
        this.stack_ll[i] = i2;
        this.stack_hh[i] = i3;
    }

    private void fswap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private void fvswap(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            fswap(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    private int[] getEclass() {
        int[] iArr = this.eclass;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[(this.quadrant.length / 2)];
        this.eclass = iArr2;
        return iArr2;
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data data, int i, int i2, int i3, int i4) {
        int i5;
        BZip2CompressorOutputStream.Data data2 = data;
        int[] iArr = this.stack_ll;
        int[] iArr2 = this.stack_hh;
        int[] iArr3 = this.stack_dd;
        int[] iArr4 = data2.fmap;
        byte[] bArr = data2.block;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        int i6 = 1;
        int i7 = 1;
        while (true) {
            int i8 = i7 - 1;
            if (i8 >= 0) {
                int i9 = iArr[i8];
                int i10 = iArr2[i8];
                int i11 = iArr3[i8];
                if (i10 - i9 >= 20 && i11 <= 10) {
                    int i12 = i11 + 1;
                    byte med3 = med3(bArr[iArr4[i9] + i12], bArr[iArr4[i10] + i12], bArr[iArr4[(i9 + i10) >>> i6] + i12]) & 255;
                    int i13 = i9;
                    int i14 = i13;
                    int i15 = i10;
                    int i16 = i15;
                    while (true) {
                        if (i13 <= i15) {
                            int i17 = (bArr[iArr4[i13] + i12] & 255) - med3;
                            if (i17 == 0) {
                                int i18 = iArr4[i13];
                                iArr4[i13] = iArr4[i14];
                                iArr4[i14] = i18;
                                i14++;
                                i13++;
                            } else if (i17 < 0) {
                                i13++;
                            }
                        }
                        i5 = i16;
                        while (i13 <= i15) {
                            int i19 = (bArr[iArr4[i15] + i12] & 255) - med3;
                            if (i19 != 0) {
                                if (i19 <= 0) {
                                    break;
                                }
                                i15--;
                            } else {
                                int i20 = iArr4[i15];
                                iArr4[i15] = iArr4[i5];
                                iArr4[i5] = i20;
                                i5--;
                                i15--;
                            }
                            BZip2CompressorOutputStream.Data data3 = data;
                        }
                        if (i13 > i15) {
                            break;
                        }
                        int i21 = iArr4[i13];
                        iArr4[i13] = iArr4[i15];
                        iArr4[i15] = i21;
                        BZip2CompressorOutputStream.Data data4 = data;
                        i15--;
                        i13++;
                        i16 = i5;
                    }
                    if (i5 < i14) {
                        iArr[i8] = i9;
                        iArr2[i8] = i10;
                        iArr3[i8] = i12;
                        i7 = i8 + 1;
                        i6 = 1;
                        BZip2CompressorOutputStream.Data data5 = data;
                    } else {
                        int i22 = i14 - i9;
                        int i23 = i13 - i14;
                        if (i22 >= i23) {
                            i22 = i23;
                        }
                        vswap(iArr4, i9, i13 - i22, i22);
                        int i24 = i10 - i5;
                        int i25 = i5 - i15;
                        if (i24 >= i25) {
                            i24 = i25;
                        }
                        vswap(iArr4, i13, (i10 - i24) + 1, i24);
                        int i26 = ((i13 + i9) - i14) - 1;
                        int i27 = (i10 - i25) + 1;
                        iArr[i8] = i9;
                        iArr2[i8] = i26;
                        iArr3[i8] = i11;
                        int i28 = i8 + 1;
                        iArr[i28] = i26 + 1;
                        iArr2[i28] = i27 - 1;
                        iArr3[i28] = i12;
                        int i29 = i28 + 1;
                        iArr[i29] = i27;
                        iArr2[i29] = i10;
                        iArr3[i29] = i11;
                        i8 = i29 + 1;
                    }
                } else if (mainSimpleSort(data, i9, i10, i11, i4)) {
                    return;
                }
                i7 = i8;
                i6 = 1;
                BZip2CompressorOutputStream.Data data52 = data;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        r27 = r12;
        r28 = r14;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean mainSimpleSort(org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.Data r30, int r31, int r32, int r33, int r34) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r32
            int r3 = r2 - r31
            r4 = 1
            int r3 = r3 + r4
            r6 = 2
            if (r3 >= r6) goto L_0x001a
            boolean r1 = r0.firstAttempt
            if (r1 == 0) goto L_0x0018
            int r1 = r0.workDone
            int r2 = r0.workLimit
            if (r1 <= r2) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            return r4
        L_0x001a:
            r6 = 0
        L_0x001b:
            int[] r7 = INCS
            r7 = r7[r6]
            if (r7 >= r3) goto L_0x0024
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0024:
            int[] r3 = r1.fmap
            char[] r7 = r0.quadrant
            byte[] r1 = r1.block
            int r8 = r34 + 1
            boolean r9 = r0.firstAttempt
            int r10 = r0.workLimit
            int r11 = r0.workDone
        L_0x0032:
            int r6 = r6 + -1
            if (r6 < 0) goto L_0x01f7
            int[] r12 = INCS
            r12 = r12[r6]
            int r13 = r31 + r12
            int r14 = r13 + -1
        L_0x003e:
            if (r13 > r2) goto L_0x01f3
            r15 = 3
        L_0x0041:
            if (r13 > r2) goto L_0x01dd
            int r15 = r15 + -1
            if (r15 < 0) goto L_0x01dd
            r16 = r3[r13]
            int r17 = r16 + r33
            r20 = r11
            r18 = r13
            r11 = 0
            r19 = 0
        L_0x0052:
            if (r11 == 0) goto L_0x0069
            r3[r18] = r19
            int r4 = r18 - r12
            if (r4 > r14) goto L_0x0066
            r18 = r4
            r24 = r6
        L_0x005e:
            r27 = r12
            r28 = r14
        L_0x0062:
            r11 = r20
            goto L_0x01d0
        L_0x0066:
            r18 = r4
            goto L_0x006a
        L_0x0069:
            r11 = 1
        L_0x006a:
            int r4 = r18 - r12
            r4 = r3[r4]
            int r21 = r4 + r33
            int r22 = r21 + 1
            byte r5 = r1[r22]
            int r23 = r17 + 1
            r30 = r4
            byte r4 = r1[r23]
            if (r5 != r4) goto L_0x01b1
            int r4 = r21 + 2
            byte r5 = r1[r4]
            int r22 = r17 + 2
            r24 = r6
            byte r6 = r1[r22]
            if (r5 != r6) goto L_0x01a0
            int r4 = r21 + 3
            byte r5 = r1[r4]
            int r6 = r17 + 3
            r25 = r11
            byte r11 = r1[r6]
            if (r5 != r11) goto L_0x0191
            int r4 = r21 + 4
            byte r5 = r1[r4]
            int r6 = r17 + 4
            byte r11 = r1[r6]
            if (r5 != r11) goto L_0x0182
            int r4 = r21 + 5
            byte r5 = r1[r4]
            int r6 = r17 + 5
            byte r11 = r1[r6]
            if (r5 != r11) goto L_0x0173
            int r21 = r21 + 6
            byte r4 = r1[r21]
            int r5 = r17 + 6
            byte r6 = r1[r5]
            if (r4 != r6) goto L_0x0164
            r4 = r34
        L_0x00b4:
            if (r4 <= 0) goto L_0x005e
            int r4 = r4 + -4
            int r6 = r21 + 1
            byte r11 = r1[r6]
            int r22 = r5 + 1
            r23 = r4
            byte r4 = r1[r22]
            if (r11 != r4) goto L_0x0154
            char r4 = r7[r21]
            char r11 = r7[r5]
            if (r4 != r11) goto L_0x0149
            int r4 = r21 + 2
            byte r11 = r1[r4]
            int r26 = r5 + 2
            r27 = r12
            byte r12 = r1[r26]
            if (r11 != r12) goto L_0x013c
            char r11 = r7[r6]
            char r12 = r7[r22]
            if (r11 != r12) goto L_0x0133
            int r6 = r21 + 3
            byte r11 = r1[r6]
            int r12 = r5 + 3
            r28 = r14
            byte r14 = r1[r12]
            if (r11 != r14) goto L_0x0128
            char r11 = r7[r4]
            char r14 = r7[r26]
            if (r11 != r14) goto L_0x0121
            int r4 = r21 + 4
            byte r11 = r1[r4]
            int r5 = r5 + 4
            byte r14 = r1[r5]
            if (r11 != r14) goto L_0x0116
            char r11 = r7[r6]
            char r14 = r7[r12]
            if (r11 != r14) goto L_0x010f
            if (r4 < r8) goto L_0x0101
            int r4 = r4 - r8
        L_0x0101:
            r21 = r4
            if (r5 < r8) goto L_0x0106
            int r5 = r5 - r8
        L_0x0106:
            int r20 = r20 + 1
            r4 = r23
            r12 = r27
            r14 = r28
            goto L_0x00b4
        L_0x010f:
            char r4 = r7[r6]
            char r5 = r7[r12]
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x0116:
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x0121:
            char r4 = r7[r4]
            char r5 = r7[r26]
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x0128:
            byte r4 = r1[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r12]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x0133:
            r28 = r14
            char r4 = r7[r6]
            char r5 = r7[r22]
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x013c:
            r28 = r14
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r26]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x0149:
            r27 = r12
            r28 = r14
            char r4 = r7[r21]
            char r5 = r7[r5]
            if (r4 <= r5) goto L_0x0062
            goto L_0x0162
        L_0x0154:
            r27 = r12
            r28 = r14
            byte r4 = r1[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r22]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
        L_0x0162:
            goto L_0x01c3
        L_0x0164:
            r27 = r12
            r28 = r14
            byte r4 = r1[r21]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x01c3
        L_0x0173:
            r27 = r12
            r28 = r14
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r6]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x01c3
        L_0x0182:
            r27 = r12
            r28 = r14
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r6]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x01c3
        L_0x0191:
            r27 = r12
            r28 = r14
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r6]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x01c3
        L_0x01a0:
            r25 = r11
            r27 = r12
            r28 = r14
            byte r4 = r1[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r22]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
            goto L_0x01c3
        L_0x01b1:
            r24 = r6
            r25 = r11
            r27 = r12
            r28 = r14
            byte r4 = r1[r22]
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r5 = r1[r23]
            r5 = r5 & 255(0xff, float:3.57E-43)
            if (r4 <= r5) goto L_0x0062
        L_0x01c3:
            r19 = r30
            r6 = r24
            r11 = r25
            r12 = r27
            r14 = r28
            r4 = 1
            goto L_0x0052
        L_0x01d0:
            r3[r18] = r16
            int r13 = r13 + 1
            r6 = r24
            r12 = r27
            r14 = r28
            r4 = 1
            goto L_0x0041
        L_0x01dd:
            r24 = r6
            r27 = r12
            r28 = r14
            if (r9 == 0) goto L_0x01ea
            if (r13 > r2) goto L_0x01ea
            if (r11 <= r10) goto L_0x01ea
            goto L_0x01f7
        L_0x01ea:
            r6 = r24
            r12 = r27
            r14 = r28
            r4 = 1
            goto L_0x003e
        L_0x01f3:
            r24 = r6
            goto L_0x0032
        L_0x01f7:
            r0.workDone = r11
            if (r9 == 0) goto L_0x0200
            if (r11 <= r10) goto L_0x0200
            r19 = 1
            goto L_0x0202
        L_0x0200:
            r19 = 0
        L_0x0202:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BlockSort.mainSimpleSort(org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream$Data, int, int, int, int):boolean");
    }

    private static byte med3(byte b2, byte b3, byte b4) {
        if (b2 < b3) {
            if (b3 >= b4) {
                if (b2 >= b4) {
                    return b2;
                }
                return b4;
            }
        } else if (b3 <= b4) {
            if (b2 <= b4) {
                return b2;
            }
            return b4;
        }
        return b3;
    }

    private static void vswap(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public void blockSort(BZip2CompressorOutputStream.Data data, int i) {
        this.workLimit = i * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (i + 1 < 10000) {
            fallbackSort(data, i);
        } else {
            mainSort(data, i);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                fallbackSort(data, i);
            }
        }
        int[] iArr = data.fmap;
        data.origPtr = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                data.origPtr = i2;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void fallbackSort(BZip2CompressorOutputStream.Data data, int i) {
        byte[] bArr = data.block;
        int i2 = i + 1;
        bArr[0] = bArr[i2];
        fallbackSort(data.fmap, bArr, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = data.fmap;
            iArr[i3] = iArr[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr2 = data.fmap;
            if (iArr2[i4] == -1) {
                iArr2[i4] = i;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void mainSort(BZip2CompressorOutputStream.Data data, int i) {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        BZip2CompressorOutputStream.Data data2 = data;
        int i8 = i;
        int[] iArr2 = this.mainSort_runningOrder;
        int[] iArr3 = this.mainSort_copy;
        boolean[] zArr = this.mainSort_bigDone;
        int[] iArr4 = this.ftab;
        byte[] bArr = data2.block;
        int[] iArr5 = data2.fmap;
        char[] cArr = this.quadrant;
        int i9 = this.workLimit;
        boolean z = this.firstAttempt;
        int i10 = 65537;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            }
            iArr4[i10] = 0;
        }
        for (int i11 = 0; i11 < 20; i11++) {
            bArr[i8 + i11 + 2] = bArr[(i11 % (i8 + 1)) + 1];
        }
        int i12 = i8 + 20 + 1;
        while (true) {
            i12--;
            if (i12 < 0) {
                break;
            }
            cArr[i12] = 0;
        }
        int i13 = i8 + 1;
        bArr[0] = bArr[i13];
        boolean z2 = z;
        int i14 = 255;
        byte b2 = bArr[0] & 255;
        int i15 = 0;
        while (i15 <= i8) {
            i15++;
            byte b3 = bArr[i15] & 255;
            int i16 = (b2 << 8) + b3;
            iArr4[i16] = iArr4[i16] + 1;
            b2 = b3;
        }
        for (int i17 = 1; i17 <= 65536; i17++) {
            iArr4[i17] = iArr4[i17] + iArr4[i17 - 1];
        }
        byte b4 = bArr[1] & 255;
        int i18 = 0;
        while (i18 < i8) {
            byte b5 = bArr[i18 + 2] & 255;
            int i19 = (b4 << 8) + b5;
            int i20 = iArr4[i19] - 1;
            iArr4[i19] = i20;
            iArr5[i20] = i18;
            i18++;
            b4 = b5;
        }
        int i21 = ((bArr[i13] & 255) << 8) + (bArr[1] & 255);
        int i22 = iArr4[i21] - 1;
        iArr4[i21] = i22;
        iArr5[i22] = i8;
        int i23 = CpioConstants.C_IRUSR;
        while (true) {
            i23--;
            if (i23 < 0) {
                break;
            }
            zArr[i23] = false;
            iArr2[i23] = i23;
        }
        int i24 = 364;
        while (i24 != 1) {
            i24 /= 3;
            int i25 = i24;
            while (i25 <= i14) {
                int i26 = iArr2[i25];
                int i27 = iArr4[(i26 + 1) << 8] - iArr4[i26 << 8];
                int i28 = i24 - 1;
                int i29 = iArr2[i25 - i24];
                int i30 = i25;
                while (true) {
                    i6 = i9;
                    if (iArr4[(i29 + 1) << 8] - iArr4[i29 << 8] <= i27) {
                        i7 = i30;
                        break;
                    }
                    iArr2[i30] = i29;
                    i7 = i30 - i24;
                    if (i7 <= i28) {
                        break;
                    }
                    i29 = iArr2[i7 - i24];
                    i30 = i7;
                    i9 = i6;
                }
                iArr2[i7] = i26;
                i25++;
                i9 = i6;
                i14 = 255;
            }
        }
        int i31 = i9;
        int i32 = 0;
        while (i32 <= i14) {
            int i33 = iArr2[i32];
            int i34 = 0;
            while (i34 <= i14) {
                int i35 = (i33 << 8) + i34;
                int i36 = iArr4[i35];
                if ((i36 & SETMASK) != SETMASK) {
                    int i37 = i36 & CLEARMASK;
                    int i38 = (iArr4[i35 + 1] & CLEARMASK) - 1;
                    if (i38 > i37) {
                        i5 = SETMASK;
                        i2 = i34;
                        i4 = i31;
                        iArr = iArr2;
                        i3 = i32;
                        mainQSort3(data, i37, i38, 2, i);
                        if (z2 && this.workDone > i4) {
                            return;
                        }
                    } else {
                        i2 = i34;
                        i4 = i31;
                        i5 = SETMASK;
                        iArr = iArr2;
                        i3 = i32;
                    }
                    iArr4[i35] = i36 | i5;
                } else {
                    i2 = i34;
                    i4 = i31;
                    iArr = iArr2;
                    i3 = i32;
                }
                i34 = i2 + 1;
                i32 = i3;
                iArr2 = iArr;
                i14 = 255;
                i31 = i4;
                BZip2CompressorOutputStream.Data data3 = data;
            }
            int i39 = i31;
            int[] iArr6 = iArr2;
            int i40 = i32;
            for (int i41 = 0; i41 <= 255; i41++) {
                iArr3[i41] = iArr4[(i41 << 8) + i33] & CLEARMASK;
            }
            int i42 = i33 << 8;
            int i43 = iArr4[i42] & CLEARMASK;
            int i44 = (i33 + 1) << 8;
            int i45 = iArr4[i44] & CLEARMASK;
            while (i43 < i45) {
                int i46 = iArr5[i43];
                int i47 = i45;
                byte b6 = bArr[i46] & 255;
                if (!zArr[b6]) {
                    iArr5[iArr3[b6]] = i46 == 0 ? i8 : i46 - 1;
                    iArr3[b6] = iArr3[b6] + 1;
                }
                i43++;
                i45 = i47;
            }
            int i48 = CpioConstants.C_IRUSR;
            while (true) {
                i48--;
                if (i48 < 0) {
                    break;
                }
                int i49 = (i48 << 8) + i33;
                iArr4[i49] = iArr4[i49] | SETMASK;
            }
            zArr[i33] = true;
            if (i40 < 255) {
                int i50 = iArr4[i42] & CLEARMASK;
                int i51 = (CLEARMASK & iArr4[i44]) - i50;
                int i52 = 0;
                while ((i51 >> i52) > 65534) {
                    i52++;
                }
                int i53 = 0;
                while (i53 < i51) {
                    int i54 = iArr5[i50 + i53];
                    char c2 = (char) (i53 >> i52);
                    cArr[i54] = c2;
                    int i55 = i50;
                    if (i54 < 20) {
                        cArr[i54 + i8 + 1] = c2;
                    }
                    i53++;
                    i50 = i55;
                }
            }
            i32 = i40 + 1;
            iArr2 = iArr6;
            i14 = 255;
            i31 = i39;
            BZip2CompressorOutputStream.Data data4 = data;
        }
    }

    /* access modifiers changed from: package-private */
    public final void fallbackSort(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[TarConstants.MAGIC_OFFSET];
        int[] eclass2 = getEclass();
        for (int i3 = 0; i3 < i; i3++) {
            eclass2[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            byte b2 = bArr[i4] & 255;
            iArr2[b2] = iArr2[b2] + 1;
        }
        for (int i5 = 1; i5 < 257; i5++) {
            iArr2[i5] = iArr2[i5] + iArr2[i5 - 1];
        }
        for (int i6 = 0; i6 < i; i6++) {
            byte b3 = bArr[i6] & 255;
            int i7 = iArr2[b3] - 1;
            iArr2[b3] = i7;
            iArr[i7] = i6;
        }
        BitSet bitSet = new BitSet(i + 64);
        for (int i8 = 0; i8 < 256; i8++) {
            bitSet.set(iArr2[i8]);
        }
        for (int i9 = 0; i9 < 32; i9++) {
            int i10 = (i9 * 2) + i;
            bitSet.set(i10);
            bitSet.clear(i10 + 1);
        }
        int i11 = 1;
        do {
            int i12 = 0;
            for (int i13 = 0; i13 < i; i13++) {
                if (bitSet.get(i13)) {
                    i12 = i13;
                }
                int i14 = iArr[i13] - i11;
                if (i14 < 0) {
                    i14 += i;
                }
                eclass2[i14] = i12;
            }
            int i15 = -1;
            i2 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i15 + 1);
                int i16 = nextClearBit - 1;
                if (i16 < i && (i15 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i) {
                    if (i15 > i16) {
                        i2 += (i15 - i16) + 1;
                        fallbackQSort3(iArr, eclass2, i16, i15);
                        int i17 = -1;
                        while (i16 <= i15) {
                            int i18 = eclass2[iArr[i16]];
                            if (i17 != i18) {
                                bitSet.set(i16);
                                i17 = i18;
                            }
                            i16++;
                        }
                    }
                }
            }
            i11 *= 2;
            if (i11 > i) {
                return;
            }
        } while (i2 != 0);
    }
}
