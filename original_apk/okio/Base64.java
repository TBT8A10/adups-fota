package okio;

import java.io.UnsupportedEncodingException;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.CharsetNames;

final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f2484a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f2485b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 45, 95};

    private Base64() {
    }

    public static byte[] a(String str) {
        int i;
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        byte[] bArr = new byte[((int) ((((long) length) * 6) / 8))];
        int i2 = 0;
        byte b2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= 'A' && charAt <= 'Z') {
                i = charAt - 'A';
            } else if (charAt >= 'a' && charAt <= 'z') {
                i = charAt - 'G';
            } else if (charAt >= '0' && charAt <= '9') {
                i = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i = 62;
            } else if (charAt == '/' || charAt == '_') {
                i = 63;
            } else {
                if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                    return null;
                }
            }
            b2 = (b2 << 6) | ((byte) i);
            i2++;
            if (i2 % 4 == 0) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (b2 >> 16);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (b2 >> 8);
                bArr[i6] = (byte) b2;
                i3 = i6 + 1;
            }
        }
        int i7 = i2 % 4;
        if (i7 == 1) {
            return null;
        }
        if (i7 == 2) {
            bArr[i3] = (byte) ((b2 << 12) >> 16);
            i3++;
        } else if (i7 == 3) {
            int i8 = b2 << 6;
            int i9 = i3 + 1;
            bArr[i3] = (byte) (i8 >> 16);
            i3 = i9 + 1;
            bArr[i9] = (byte) (i8 >> 8);
        }
        if (i3 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    public static String b(byte[] bArr) {
        return a(bArr, f2485b);
    }

    public static String a(byte[] bArr) {
        return a(bArr, f2484a);
    }

    private static String a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) * 4) / 3)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            int i10 = i9 + 1;
            bArr3[i9] = 61;
            i = i10 + 1;
            bArr3[i10] = 61;
        } else if (length2 == 2) {
            int i11 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i12 = i11 + 1;
            int i13 = length + 1;
            bArr3[i11] = bArr2[((bArr[i13] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            int i14 = i12 + 1;
            bArr3[i12] = bArr2[(bArr[i13] & 15) << 2];
            i = i14 + 1;
            bArr3[i14] = 61;
        }
        try {
            return new String(bArr3, 0, i, CharsetNames.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
