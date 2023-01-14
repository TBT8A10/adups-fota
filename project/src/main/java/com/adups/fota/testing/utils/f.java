package com.adups.fota.testing.utils;

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

public class f {
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

    /*public static String a(String str) {
        if (!str.startsWith("AEVA")) {
            return str;
        }
        String replaceAll = str.replaceAll("AEVA", "");
        if (!TextUtils.isEmpty(replaceAll)) {
            return new String(Base64.decode(replaceAll, 8));
        }
        return "";
    }*/

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
