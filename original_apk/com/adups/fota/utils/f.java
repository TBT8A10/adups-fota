package com.adups.fota.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* compiled from: EncryptUtil */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1629a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("DES");
        instance.init(2, generateSecret, secureRandom);
        return instance.doFinal(bArr);
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        int random = (int) (Math.random() * 15.0d);
        int random2 = ((int) (Math.random() * 12.0d)) + 3;
        byte[] a2 = a(random2);
        int i = random2 | (random << 4);
        byte[] b2 = b(a2, bytes);
        byte[] f = f(a2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeByte(i);
            if (random > 0) {
                byte[] bArr = new byte[random];
                bArr[0] = 8;
                dataOutputStream.write(bArr);
            }
            dataOutputStream.write(f);
            dataOutputStream.write(b2);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            dataOutputStream.close();
            byteArrayOutputStream.close();
            return a(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(StandardCharsets.UTF_8));
            return d(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        try {
            return g(MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static byte[] e(byte[] bArr) {
        if (bArr.length % 2 == 0) {
            byte[] bArr2 = new byte[(bArr.length / 2)];
            for (int i = 0; i < bArr.length; i += 2) {
                bArr2[i / 2] = (byte) Integer.parseInt(new String(bArr, i, 2), 16);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("长度不是偶数");
    }

    private static byte[] f(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = (byte) (((bArr[i] & 255) >> 5) | ((bArr[i] & 255) << 3));
        }
        return bArr2;
    }

    private static String g(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(f1629a[(b2 >> 4) & 15]);
            sb.append(f1629a[b2 & 15]);
        }
        return sb.toString();
    }

    private static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051 A[SYNTHETIC, Splitter:B:31:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.String r5 = "SHA-256"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r2 = 102400(0x19000, float:1.43493E-40)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r3.<init>(r0)     // Catch:{ Exception -> 0x003d, all -> 0x003b }
        L_0x001d:
            int r0 = r3.read(r2)     // Catch:{ Exception -> 0x0039 }
            if (r0 <= 0) goto L_0x0028
            r4 = 0
            r5.update(r2, r4, r0)     // Catch:{ Exception -> 0x0039 }
            goto L_0x001d
        L_0x0028:
            byte[] r5 = r5.digest()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r5 = b((byte[]) r5)     // Catch:{ Exception -> 0x0039 }
            r3.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0038:
            return r5
        L_0x0039:
            r5 = move-exception
            goto L_0x003f
        L_0x003b:
            r5 = move-exception
            goto L_0x004f
        L_0x003d:
            r5 = move-exception
            r3 = r1
        L_0x003f:
            r5.printStackTrace()     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x004c
            r3.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004c:
            return r1
        L_0x004d:
            r5 = move-exception
            r1 = r3
        L_0x004f:
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0059:
            goto L_0x005b
        L_0x005a:
            throw r5
        L_0x005b:
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.f.f(java.lang.String):java.lang.String");
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String e(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bytes);
            return c(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(String str, String str2) throws Exception {
        byte[] e = e(str.getBytes());
        return new String(a(e, (str2 + "s+-=6").getBytes()));
    }

    public static String a(String str) {
        if (!str.startsWith("AEVA")) {
            return str;
        }
        String replaceAll = str.replaceAll("AEVA", "");
        if (!TextUtils.isEmpty(replaceAll)) {
            return new String(Base64.decode(replaceAll, 8));
        }
        return "";
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString().toUpperCase();
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        int length2 = bArr.length;
        byte[] bArr3 = new byte[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) ((bArr2[i2] & 255) ^ (bArr[i] & 255));
            i++;
            if (i == length2) {
                i = 0;
            }
        }
        return bArr3;
    }

    private static byte[] a(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) (Math.random() * 255.0d));
        }
        return bArr;
    }

    private static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte a2 : bArr) {
            sb.append(a(a2));
        }
        return sb.toString();
    }
}
