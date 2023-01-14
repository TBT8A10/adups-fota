package com.adups.fota.e;

import android.os.Build;
import android.text.TextUtils;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: QueryRootVerify */
public class d {
    public static String a(String str) {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            String a2 = new p().a(str);
            return TextUtils.isEmpty(a2) ? c(str) : a2;
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006a, code lost:
        r3 = r3 + 26;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r10) throws java.io.IOException {
        /*
            com.adups.fota.bean.RootErrBean r0 = new com.adups.fota.bean.RootErrBean
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = "start checkSourceFile"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r10)
            java.util.zip.CheckedInputStream r10 = new java.util.zip.CheckedInputStream
            java.util.zip.CRC32 r3 = new java.util.zip.CRC32
            r3.<init>()
            r10.<init>(r2, r3)
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream
            r2.<init>(r10)
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream
            r10.<init>(r2)
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]
        L_0x002c:
            java.util.zip.ZipEntry r4 = r2.getNextEntry()
            if (r4 == 0) goto L_0x00f2
            java.lang.String r4 = r4.getName()
            r5 = 42
            char[] r5 = new char[r5]
            r5 = {77, 69, 84, 65, 45, 73, 78, 70, 47, 99, 111, 109, 47, 103, 111, 111, 103, 108, 101, 47, 97, 110, 100, 114, 111, 105, 100, 47, 117, 112, 100, 97, 116, 101, 114, 45, 115, 99, 114, 105, 112, 116} // fill-array
            java.lang.String r5 = java.lang.String.valueOf(r5)
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x002c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r4 = r10.read(r3)
        L_0x0050:
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x0061
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3, r6, r4)
            r2.append(r5)
            int r4 = r10.read(r3)
            goto L_0x0050
        L_0x0061:
            r3 = 0
        L_0x0062:
            java.lang.String r4 = "apply_patch_check(\"/system"
            int r3 = r2.indexOf(r4, r3)
            if (r3 < 0) goto L_0x00f2
            int r3 = r3 + 26
            java.lang.String r4 = "\")"
            int r4 = r2.indexOf(r4, r3)
            if (r4 >= 0) goto L_0x0076
            goto L_0x00f2
        L_0x0076:
            java.lang.String r3 = r2.substring(r3, r4)
            int r4 = r4 + 3
            java.lang.String r5 = "\", \""
            int r7 = r3.indexOf(r5, r6)
            if (r7 >= 0) goto L_0x0085
            goto L_0x00ef
        L_0x0085:
            java.lang.String r8 = r3.substring(r6, r7)
            int r7 = r7 + 4
            int r5 = r3.indexOf(r5, r7)
            if (r5 >= 0) goto L_0x0092
            goto L_0x00ef
        L_0x0092:
            java.lang.String r7 = r3.substring(r7, r5)
            int r5 = r5 + 4
            java.lang.String r3 = r3.substring(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "file path = "
            r5.append(r9)
            r5.append(r8)
            java.lang.String r9 = "  sha1_str1 = "
            r5.append(r9)
            r5.append(r7)
            java.lang.String r9 = "  sha1_str2 = "
            r5.append(r9)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)
            boolean r3 = a(r8, r7, r3)     // Catch:{ Exception -> 0x00d6 }
            if (r3 != 0) goto L_0x00ef
            java.lang.String r3 = "/"
            int r3 = r8.lastIndexOf(r3)     // Catch:{ Exception -> 0x00d6 }
            int r3 = r3 + 1
            java.lang.String r3 = r8.substring(r3)     // Catch:{ Exception -> 0x00d6 }
            r1.add(r3)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00ef
        L_0x00d6:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "checkSourceFileInvaild, Exception = "
            r5.append(r7)
            java.lang.String r3 = r3.toString()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            com.adups.fota.utils.LogUtil.b((java.lang.String) r3)
        L_0x00ef:
            r3 = r4
            goto L_0x0062
        L_0x00f2:
            r10.close()
            int r10 = r1.size()
            if (r10 <= 0) goto L_0x0103
            r0.setModify(r1)
            java.lang.String r10 = com.adups.fota.utils.i.a(r0)
            return r10
        L_0x0103:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.e.d.b(java.lang.String):java.lang.String");
    }

    private static String c(String str) {
        try {
            return b(str);
        } catch (FileNotFoundException e) {
            LogUtil.b("checkUpdateFileResult, FileNotFoundException = " + e.toString());
            return null;
        } catch (IOException e2) {
            LogUtil.b("checkUpdateFileResult, IOException = " + e2.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3) throws OutOfMemoryError, IOException {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File("/system" + str);
        if (!file.exists()) {
            LogUtil.a("/system" + str + " is not exists !");
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
            LogUtil.a("getFileSha1()---path = /system" + str + " sha1_str1 = " + str2 + " sha1_str2 = " + str3);
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[102400];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            String lowerCase = a(instance.digest()).toLowerCase();
            LogUtil.a("getFileSha1()---act_sha1String = " + lowerCase);
            boolean z = lowerCase.equals(str2) || lowerCase.equals(str3);
            fileInputStream.close();
            return z;
        } catch (NoSuchAlgorithmException e) {
            LogUtil.b("getFileSha1, NoSuchAlgorithmException = " + e.toString());
            return false;
        } catch (OutOfMemoryError e2) {
            LogUtil.b("getFileSha1, OutOfMemoryError = " + e2.toString());
            return false;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte a2 : bArr) {
            sb.append(a(a2));
        }
        return sb.toString();
    }
}
