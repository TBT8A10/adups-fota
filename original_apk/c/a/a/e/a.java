package c.a.a.e;

import java.io.DataInput;
import java.io.IOException;

/* compiled from: Raw */
public class a {
    public static int a(DataInput dataInput, byte[] bArr) throws c.a.a.b.a {
        try {
            dataInput.readFully(bArr, 0, 4);
            return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16);
        } catch (IOException e) {
            throw new c.a.a.b.a((Throwable) e);
        }
    }

    public static long b(byte[] bArr, int i) {
        return ((long) (bArr[i] & 255)) | ((((((((((((((((long) (bArr[i + 7] & 255)) | 0) << 8) | ((long) (bArr[i + 6] & 255))) << 8) | ((long) (bArr[i + 5] & 255))) << 8) | ((long) (bArr[i + 4] & 255))) << 8) | ((long) (bArr[i + 3] & 255))) << 8) | ((long) (bArr[i + 2] & 255))) << 8) | ((long) (bArr[i + 1] & 255))) << 8);
    }

    public static final short c(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((short) (((short) ((bArr[i] & 255) | 0)) << 8)));
    }

    public static int d(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    public static int a(byte[] bArr, int i) {
        return ((((bArr[i + 3] & 255) << 8) | (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }
}
