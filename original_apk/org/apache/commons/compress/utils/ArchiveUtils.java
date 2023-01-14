package org.apache.commons.compress.utils;

import java.io.UnsupportedEncodingException;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArchiveUtils {
    private ArchiveUtils() {
    }

    public static boolean isArrayZero(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        int i5 = i2 < i4 ? i2 : i4;
        for (int i6 = 0; i6 < i5; i6++) {
            if (bArr[i + i6] != bArr2[i3 + i6]) {
                return false;
            }
        }
        if (i2 == i4) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (i2 > i4) {
            while (i4 < i2) {
                if (bArr[i + i4] != 0) {
                    return false;
                }
                i4++;
            }
        } else {
            while (i2 < i4) {
                if (bArr2[i3 + i2] != 0) {
                    return false;
                }
                i2++;
            }
        }
        return true;
    }

    public static boolean isEqualWithNull(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return isEqual(bArr, i, i2, bArr2, i3, i4, true);
    }

    public static boolean matchAsciiBuffer(String str, byte[] bArr, int i, int i2) {
        try {
            byte[] bytes = str.getBytes(CharsetNames.US_ASCII);
            return isEqual(bytes, 0, bytes.length, bArr, i, i2, false);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toAsciiBytes(String str) {
        try {
            return str.getBytes(CharsetNames.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toAsciiString(byte[] bArr) {
        try {
            return new String(bArr, CharsetNames.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(ArchiveEntry archiveEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append(archiveEntry.isDirectory() ? 'd' : '-');
        String l = Long.toString(archiveEntry.getSize());
        sb.append(' ');
        for (int i = 7; i > l.length(); i--) {
            sb.append(' ');
        }
        sb.append(l);
        sb.append(' ');
        sb.append(archiveEntry.getName());
        return sb.toString();
    }

    public static String toAsciiString(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, CharsetNames.US_ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isEqual(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return isEqual(bArr, i, i2, bArr2, i3, i4, false);
    }

    public static boolean matchAsciiBuffer(String str, byte[] bArr) {
        return matchAsciiBuffer(str, bArr, 0, bArr.length);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        return isEqual(bArr, 0, bArr.length, bArr2, 0, bArr2.length, false);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2, boolean z) {
        return isEqual(bArr, 0, bArr.length, bArr2, 0, bArr2.length, z);
    }
}
