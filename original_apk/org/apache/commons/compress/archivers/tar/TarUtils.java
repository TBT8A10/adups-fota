package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

public class TarUtils {
    private static final int BYTE_MASK = 255;
    static final ZipEncoding DEFAULT_ENCODING = ZipEncodingHelper.getZipEncoding((String) null);
    static final ZipEncoding FALLBACK_ENCODING = new ZipEncoding() {
        public boolean canEncode(String str) {
            return true;
        }

        public String decode(byte[] bArr) {
            StringBuilder sb = new StringBuilder(r0);
            for (byte b2 : bArr) {
                if (b2 == 0) {
                    break;
                }
                sb.append((char) (b2 & 255));
            }
            return sb.toString();
        }

        public ByteBuffer encode(String str) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) str.charAt(i);
            }
            return ByteBuffer.wrap(bArr);
        }
    };

    private TarUtils() {
    }

    public static long computeCheckSum(byte[] bArr) {
        long j = 0;
        for (byte b2 : bArr) {
            j += (long) (b2 & 255);
        }
        return j;
    }

    private static String exceptionMessage(byte[] bArr, int i, int i2, int i3, byte b2) {
        String replaceAll = new String(bArr, i, i2).replaceAll("\u0000", "{NUL}");
        return "Invalid byte " + b2 + " at offset " + (i3 - i) + " in '" + replaceAll + "' len=" + i2;
    }

    private static void formatBigIntegerBinary(long j, byte[] bArr, int i, int i2, boolean z) {
        byte[] byteArray = BigInteger.valueOf(j).toByteArray();
        int length = byteArray.length;
        int i3 = (i2 + i) - length;
        int i4 = 0;
        System.arraycopy(byteArray, 0, bArr, i3, length);
        if (z) {
            i4 = BYTE_MASK;
        }
        byte b2 = (byte) i4;
        while (true) {
            i++;
            if (i < i3) {
                bArr[i] = b2;
            } else {
                return;
            }
        }
    }

    public static int formatCheckSumOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 2;
        formatUnsignedOctalString(j, bArr, i, i3);
        bArr[i3 + i] = 0;
        bArr[i3 + 1 + i] = 32;
        return i + i2;
    }

    private static void formatLongBinary(long j, byte[] bArr, int i, int i2, boolean z) {
        int i3 = (i2 - 1) * 8;
        long j2 = 1 << i3;
        long abs = Math.abs(j);
        if (abs < j2) {
            if (z) {
                abs = ((abs ^ (j2 - 1)) | ((long) (BYTE_MASK << i3))) + 1;
            }
            for (int i4 = (i2 + i) - 1; i4 >= i; i4--) {
                bArr[i4] = (byte) ((int) abs);
                abs >>= 8;
            }
            return;
        }
        throw new IllegalArgumentException("Value " + j + " is too large for " + i2 + " byte field.");
    }

    public static int formatLongOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 1;
        formatUnsignedOctalString(j, bArr, i, i3);
        bArr[i3 + i] = 32;
        return i + i2;
    }

    public static int formatLongOctalOrBinaryBytes(long j, byte[] bArr, int i, int i2) {
        long j2 = i2 == 8 ? TarConstants.MAXID : TarConstants.MAXSIZE;
        boolean z = j < 0;
        if (!z && j <= j2) {
            return formatLongOctalBytes(j, bArr, i, i2);
        }
        if (i2 < 9) {
            formatLongBinary(j, bArr, i, i2, z);
        }
        formatBigIntegerBinary(j, bArr, i, i2, z);
        bArr[i] = (byte) (z ? BYTE_MASK : CpioConstants.C_IWUSR);
        return i + i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return formatNameBytes(r1, r2, r3, r4, FALLBACK_ENCODING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        throw new java.lang.RuntimeException(r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int formatNameBytes(java.lang.String r1, byte[] r2, int r3, int r4) {
        /*
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = DEFAULT_ENCODING     // Catch:{ IOException -> 0x0007 }
            int r1 = formatNameBytes(r1, r2, r3, r4, r0)     // Catch:{ IOException -> 0x0007 }
            return r1
        L_0x0007:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = FALLBACK_ENCODING     // Catch:{ IOException -> 0x000e }
            int r1 = formatNameBytes(r1, r2, r3, r4, r0)     // Catch:{ IOException -> 0x000e }
            return r1
        L_0x000e:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarUtils.formatNameBytes(java.lang.String, byte[], int, int):int");
    }

    public static int formatOctalBytes(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 - 2;
        formatUnsignedOctalString(j, bArr, i, i3);
        bArr[i3 + i] = 32;
        bArr[i3 + 1 + i] = 0;
        return i + i2;
    }

    public static void formatUnsignedOctalString(long j, byte[] bArr, int i, int i2) {
        int i3;
        int i4 = i2 - 1;
        if (j == 0) {
            i3 = i4 - 1;
            bArr[i4 + i] = TarConstants.LF_NORMAL;
        } else {
            long j2 = j;
            while (i4 >= 0 && j2 != 0) {
                bArr[i + i4] = (byte) (((byte) ((int) (7 & j2))) + TarConstants.LF_NORMAL);
                j2 >>>= 3;
                i4--;
            }
            if (j2 == 0) {
                i3 = i4;
            } else {
                throw new IllegalArgumentException(j + "=" + Long.toOctalString(j) + " will not fit in octal number buffer of length " + i2);
            }
        }
        while (i3 >= 0) {
            bArr[i + i3] = TarConstants.LF_NORMAL;
            i3--;
        }
    }

    private static long parseBinaryBigInteger(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i + 1, bArr2, 0, i3);
        BigInteger bigInteger = new BigInteger(bArr2);
        if (z) {
            bigInteger = bigInteger.add(BigInteger.valueOf(-1)).not();
        }
        if (bigInteger.bitLength() <= 63) {
            return z ? -bigInteger.longValue() : bigInteger.longValue();
        }
        throw new IllegalArgumentException("At offset " + i + ", " + i2 + " byte binary number" + " exceeds maximum signed long" + " value");
    }

    private static long parseBinaryLong(byte[] bArr, int i, int i2, boolean z) {
        if (i2 < 9) {
            long j = 0;
            for (int i3 = 1; i3 < i2; i3++) {
                j = (j << 8) + ((long) (bArr[i + i3] & 255));
            }
            if (z) {
                j = (j - 1) ^ (((long) Math.pow(2.0d, (double) ((i2 - 1) * 8))) - 1);
            }
            return z ? -j : j;
        }
        throw new IllegalArgumentException("At offset " + i + ", " + i2 + " byte binary number" + " exceeds maximum signed long" + " value");
    }

    public static boolean parseBoolean(byte[] bArr, int i) {
        return bArr[i] == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return parseName(r1, r2, r3, FALLBACK_ENCODING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        throw new java.lang.RuntimeException(r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String parseName(byte[] r1, int r2, int r3) {
        /*
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = DEFAULT_ENCODING     // Catch:{ IOException -> 0x0007 }
            java.lang.String r1 = parseName(r1, r2, r3, r0)     // Catch:{ IOException -> 0x0007 }
            return r1
        L_0x0007:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = FALLBACK_ENCODING     // Catch:{ IOException -> 0x000e }
            java.lang.String r1 = parseName(r1, r2, r3, r0)     // Catch:{ IOException -> 0x000e }
            return r1
        L_0x000e:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarUtils.parseName(byte[], int, int):java.lang.String");
    }

    public static long parseOctal(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        if (i2 >= 2) {
            long j = 0;
            if (bArr[i] == 0) {
                return 0;
            }
            int i4 = i;
            while (i4 < i3 && bArr[i4] == 32) {
                i4++;
            }
            byte b2 = bArr[i3 - 1];
            while (i4 < i3 && (b2 == 0 || b2 == 32)) {
                i3--;
                b2 = bArr[i3 - 1];
            }
            while (i4 < i3) {
                byte b3 = bArr[i4];
                if (b3 < 48 || b3 > 55) {
                    throw new IllegalArgumentException(exceptionMessage(bArr, i, i2, i4, b3));
                }
                j = (j << 3) + ((long) (b3 - 48));
                i4++;
            }
            return j;
        }
        throw new IllegalArgumentException("Length " + i2 + " must be at least 2");
    }

    public static long parseOctalOrBinary(byte[] bArr, int i, int i2) {
        if ((bArr[i] & 128) == 0) {
            return parseOctal(bArr, i, i2);
        }
        boolean z = bArr[i] == -1;
        if (i2 < 9) {
            return parseBinaryLong(bArr, i, i2, z);
        }
        return parseBinaryBigInteger(bArr, i, i2, z);
    }

    public static boolean verifyCheckSum(byte[] bArr) {
        long j = 0;
        long j2 = 0;
        int i = 0;
        long j3 = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            if (148 <= i2 && i2 < 156) {
                if (48 <= b2 && b2 <= 55) {
                    int i3 = i + 1;
                    if (i < 6) {
                        j3 = ((j3 * 8) + ((long) b2)) - 48;
                        i = i3;
                        b2 = 32;
                    } else {
                        i = i3;
                    }
                }
                if (i > 0) {
                    i = 6;
                }
                b2 = 32;
            }
            j += (long) (b2 & 255);
            j2 += (long) b2;
        }
        if (j3 == j || j3 == j2 || j3 > j) {
            return true;
        }
        return false;
    }

    public static int formatNameBytes(String str, byte[] bArr, int i, int i2, ZipEncoding zipEncoding) throws IOException {
        int length = str.length();
        ByteBuffer encode = zipEncoding.encode(str);
        while (encode.limit() > i2 && length > 0) {
            length--;
            encode = zipEncoding.encode(str.substring(0, length));
        }
        int limit = encode.limit() - encode.position();
        System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i, limit);
        while (limit < i2) {
            bArr[i + limit] = 0;
            limit++;
        }
        return i + i2;
    }

    public static String parseName(byte[] bArr, int i, int i2, ZipEncoding zipEncoding) throws IOException {
        while (i2 > 0 && bArr[(i + i2) - 1] == 0) {
            i2--;
        }
        if (i2 <= 0) {
            return "";
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return zipEncoding.decode(bArr2);
    }
}
