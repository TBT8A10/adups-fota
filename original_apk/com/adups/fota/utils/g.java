package com.adups.fota.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import c.a.a.a.b;
import c.a.a.c.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

/* compiled from: FileUtil */
public class g {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[SYNTHETIC, Splitter:B:19:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r2, byte[] r3) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0025 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0025 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0025 }
            if (r2 != 0) goto L_0x000f
            r1.createNewFile()     // Catch:{ Exception -> 0x0025 }
        L_0x000f:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0025 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            r2.write(r3)     // Catch:{ Exception -> 0x001f, all -> 0x001b }
            r2.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0043
        L_0x001b:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x0044
        L_0x001f:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x0026
        L_0x0023:
            r2 = move-exception
            goto L_0x0044
        L_0x0025:
            r2 = move-exception
        L_0x0026:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r3.<init>()     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "writeByteData : Exception = "
            r3.append(r1)     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0023 }
            r3.append(r2)     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0023 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            return
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.a(java.lang.String, byte[]):void");
    }

    public static void b(String str, String str2) {
        FileWriter fileWriter;
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file2.exists()) {
                LogUtil.b(false);
                LogUtil.a("write2Sd : " + file2.getAbsolutePath() + " mkdirs failed !");
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + "=======" + str2 + "\n");
                fileWriter.flush();
                fileWriter.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            return;
        }
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c A[SYNTHETIC, Splitter:B:44:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0098 A[SYNTHETIC, Splitter:B:51:0x0098] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r3.<init>(r8)     // Catch:{ Exception -> 0x006d, all -> 0x006a }
            r8 = 262144(0x40000, float:3.67342E-40)
            byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x0068 }
            java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0068 }
            if (r2 != 0) goto L_0x0023
            r3.close()     // Catch:{ IOException -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0022:
            return r1
        L_0x0023:
            int r4 = r3.read(r8)     // Catch:{ Exception -> 0x0068 }
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x002f
            r2.update(r8, r6, r4)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0023
        L_0x002f:
            byte[] r8 = r2.digest()     // Catch:{ Exception -> 0x0068 }
            if (r8 != 0) goto L_0x003e
            r3.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r8 = move-exception
            r8.printStackTrace()
        L_0x003d:
            return r1
        L_0x003e:
            int r2 = r8.length     // Catch:{ Exception -> 0x0068 }
        L_0x003f:
            if (r6 >= r2) goto L_0x005b
            byte r4 = r8[r6]     // Catch:{ Exception -> 0x0068 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ Exception -> 0x0068 }
            int r5 = r4.length()     // Catch:{ Exception -> 0x0068 }
            r7 = 1
            if (r5 != r7) goto L_0x0055
            java.lang.String r5 = "0"
            r0.append(r5)     // Catch:{ Exception -> 0x0068 }
        L_0x0055:
            r0.append(r4)     // Catch:{ Exception -> 0x0068 }
            int r6 = r6 + 1
            goto L_0x003f
        L_0x005b:
            java.lang.String r8 = r0.toString()     // Catch:{ Exception -> 0x0068 }
            r3.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0067:
            return r8
        L_0x0068:
            r8 = move-exception
            goto L_0x006f
        L_0x006a:
            r8 = move-exception
            r3 = r1
            goto L_0x0096
        L_0x006d:
            r8 = move-exception
            r3 = r1
        L_0x006f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r0.<init>()     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = "getFileMD5, Exception "
            r0.append(r2)     // Catch:{ all -> 0x0095 }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x0095 }
            r0.append(r2)     // Catch:{ all -> 0x0095 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0095 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)     // Catch:{ all -> 0x0095 }
            r8.printStackTrace()     // Catch:{ all -> 0x0095 }
            if (r3 == 0) goto L_0x0094
            r3.close()     // Catch:{ IOException -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0094:
            return r1
        L_0x0095:
            r8 = move-exception
        L_0x0096:
            if (r3 == 0) goto L_0x00a0
            r3.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a0:
            goto L_0x00a2
        L_0x00a1:
            throw r8
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.c(java.lang.String):java.lang.String");
    }

    public static long d(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0;
        }
        return file.length();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.BufferedInputStream} */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6 A[SYNTHETIC, Splitter:B:41:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cb A[Catch:{ IOException -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d0 A[Catch:{ IOException -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d7 A[SYNTHETIC, Splitter:B:51:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc A[Catch:{ IOException -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e1 A[Catch:{ IOException -> 0x00e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> e(java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "zipFile="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " , "
            r0.append(r1)
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            boolean r1 = r1.exists()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            r2.<init>(r7)     // Catch:{ IOException -> 0x00a9, all -> 0x00a5 }
            java.lang.String r7 = "payload_properties.txt"
            java.util.zip.ZipEntry r7 = r2.getEntry(r7)     // Catch:{ IOException -> 0x00a2, all -> 0x009f }
            if (r7 == 0) goto L_0x007c
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a2, all -> 0x009f }
            java.io.InputStream r7 = r2.getInputStream(r7)     // Catch:{ IOException -> 0x00a2, all -> 0x009f }
            r3.<init>(r7)     // Catch:{ IOException -> 0x00a2, all -> 0x009f }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007a }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x007a }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x007a }
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x007a }
            r7.<init>(r4)     // Catch:{ IOException -> 0x007a }
        L_0x004d:
            java.lang.String r1 = r7.readLine()     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            if (r4 != 0) goto L_0x006f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            r4.<init>()     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            java.lang.String r5 = "getHeaderValue,line="
            r4.append(r5)     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            r4.append(r1)     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r4)     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            r0.add(r1)     // Catch:{ IOException -> 0x0075, all -> 0x0071 }
            goto L_0x004d
        L_0x006f:
            r1 = r3
            goto L_0x007d
        L_0x0071:
            r0 = move-exception
            r1 = r7
            goto L_0x00d5
        L_0x0075:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r6
            goto L_0x00ac
        L_0x007a:
            r7 = move-exception
            goto L_0x00ac
        L_0x007c:
            r7 = r1
        L_0x007d:
            if (r7 == 0) goto L_0x0082
            r7.close()     // Catch:{ IOException -> 0x008a }
        L_0x0082:
            if (r1 == 0) goto L_0x0087
            r1.close()     // Catch:{ IOException -> 0x008a }
        L_0x0087:
            r2.close()     // Catch:{ IOException -> 0x008a }
        L_0x008a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "getHeaderValue : "
            r7.append(r1)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r7)
            return r0
        L_0x009f:
            r0 = move-exception
            r3 = r1
            goto L_0x00d5
        L_0x00a2:
            r7 = move-exception
            r3 = r1
            goto L_0x00ac
        L_0x00a5:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00d5
        L_0x00a9:
            r7 = move-exception
            r2 = r1
            r3 = r2
        L_0x00ac:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r4.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "upZipFile:IOException = "
            r4.append(r5)     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00d4 }
            r4.append(r7)     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x00d4 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r7)     // Catch:{ all -> 0x00d4 }
            if (r1 == 0) goto L_0x00c9
            r1.close()     // Catch:{ IOException -> 0x00d3 }
        L_0x00c9:
            if (r3 == 0) goto L_0x00ce
            r3.close()     // Catch:{ IOException -> 0x00d3 }
        L_0x00ce:
            if (r2 == 0) goto L_0x00d3
            r2.close()     // Catch:{ IOException -> 0x00d3 }
        L_0x00d3:
            return r0
        L_0x00d4:
            r0 = move-exception
        L_0x00d5:
            if (r1 == 0) goto L_0x00da
            r1.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00da:
            if (r3 == 0) goto L_0x00df
            r3.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00df:
            if (r2 == 0) goto L_0x00e4
            r2.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            goto L_0x00e6
        L_0x00e5:
            throw r0
        L_0x00e6:
            goto L_0x00e5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.e(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c A[SYNTHETIC, Splitter:B:22:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[SYNTHETIC, Splitter:B:29:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(java.lang.String r5) {
        /*
            java.lang.String r0 = "getMD5sum"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r5 = 64
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0050 }
            int r2 = r1.read(r5)     // Catch:{ Exception -> 0x0050 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = "getMD5sum 1, length = "
            r3.append(r4)     // Catch:{ Exception -> 0x0050 }
            r3.append(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0050 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0050 }
            r3 = 32
            if (r2 <= r3) goto L_0x002d
            r2 = 32
        L_0x002d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050 }
            r3.<init>()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = "getMD5sum 2, length = "
            r3.append(r4)     // Catch:{ Exception -> 0x0050 }
            r3.append(r2)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0050 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0050 }
            r4 = 0
            r3.<init>(r5, r4, r2)     // Catch:{ Exception -> 0x0050 }
            r1.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004f:
            return r3
        L_0x0050:
            r5 = move-exception
            goto L_0x0057
        L_0x0052:
            r5 = move-exception
            r1 = r0
            goto L_0x0066
        L_0x0055:
            r5 = move-exception
            r1 = r0
        L_0x0057:
            r5.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0064:
            return r0
        L_0x0065:
            r5 = move-exception
        L_0x0066:
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0070:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.f(java.lang.String):java.lang.String");
    }

    public static long g(String str) {
        try {
            f a2 = new b(str).a("payload.bin");
            if (a2 == null) {
                return 0;
            }
            long f = a2.f() + 30 + ((long) 11) + ((long) a2.d());
            LogUtil.a("getOffset=" + f);
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r5 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r5.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r1.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h(java.lang.String r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "504B0304"
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r1.<init>(r5, r2)
            r2 = 0
            r5 = 0
            r1.seek(r2)     // Catch:{ Throwable -> 0x002f }
            r2 = 4
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x002f }
            int r3 = r2.length     // Catch:{ Throwable -> 0x002f }
            r4 = 0
            int r3 = r1.read(r2, r4, r3)     // Catch:{ Throwable -> 0x002f }
            java.lang.String r2 = a((byte[]) r2)     // Catch:{ Throwable -> 0x002f }
            if (r3 <= 0) goto L_0x0029
            boolean r5 = r2.equalsIgnoreCase(r0)     // Catch:{ Throwable -> 0x002f }
            if (r5 == 0) goto L_0x0029
            r5 = 1
            r1.close()
            return r5
        L_0x0029:
            r1.close()
            return r4
        L_0x002d:
            r0 = move-exception
            goto L_0x0031
        L_0x002f:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x002d }
        L_0x0031:
            if (r5 == 0) goto L_0x003c
            r1.close()     // Catch:{ Throwable -> 0x0037 }
            goto L_0x003f
        L_0x0037:
            r1 = move-exception
            r5.addSuppressed(r1)
            goto L_0x003f
        L_0x003c:
            r1.close()
        L_0x003f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.h(java.lang.String):boolean");
    }

    public static String i(String str) {
        String str2;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = new String(bArr, StandardCharsets.UTF_8);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e = e;
            }
            return str2;
        } catch (Exception e2) {
            e = e2;
            str2 = null;
            e.printStackTrace();
            return str2;
        }
    }

    private static void j(String str) {
        String[] list;
        File file;
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory() && (list = file2.list()) != null) {
            for (String str2 : list) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + str2);
                } else {
                    file = new File(str + File.separator + str2);
                }
                if (file.isFile()) {
                    file.delete();
                }
                if (file.isDirectory()) {
                    j(str + "/" + str2);
                    a(str + "/" + str2);
                }
            }
        }
    }

    private static boolean k(String str) {
        return new File(str).exists();
    }

    public static boolean a(Context context, String str, String str2) {
        FileOutputStream openFileOutput;
        try {
            openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            if (openFileOutput == null) {
                return true;
            }
            openFileOutput.close();
            return true;
        } catch (Exception e) {
            LogUtil.a("writeInternalFile : Exception = " + e.toString());
            return false;
        } catch (Throwable th) {
            r2.addSuppressed(th);
        }
        throw th;
    }

    public static String a(Context context, String str) {
        String str2;
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput(str);
            byte[] bArr = new byte[openFileInput.available()];
            openFileInput.read(bArr);
            str2 = new String(bArr, StandardCharsets.UTF_8);
            if (openFileInput != null) {
                try {
                    openFileInput.close();
                } catch (Exception e) {
                    e = e;
                }
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "";
            LogUtil.a("readInternalFile,Exception e=" + e.getMessage());
            return str2;
        } catch (Throwable th) {
            r5.addSuppressed(th);
        }
        return str2;
        throw th;
    }

    public static void b(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:3|(5:4|5|(1:7)|8|(9:9|10|11|12|13|(2:14|(1:16)(1:52))|17|18|19))|20|21|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0088 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bb A[SYNTHETIC, Splitter:B:37:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5 A[SYNTHETIC, Splitter:B:44:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca A[SYNTHETIC, Splitter:B:48:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "writeMD5File"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = "/md5sum"
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0022
            return
        L_0x0022:
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r3.<init>()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r3.append(r6)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r3.append(r7)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            boolean r6 = r2.exists()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            if (r6 == 0) goto L_0x0049
            java.lang.String r6 = "writeMD5File, del exists md5sum file"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r6)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            r2.delete()     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
        L_0x0049:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.lang.String r7 = "rws"
            r6.<init>(r2, r7)     // Catch:{ Exception -> 0x00a3, all -> 0x00a0 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009a, all -> 0x0094 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x009a, all -> 0x0094 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r0]     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r2 = 0
            r3 = 0
        L_0x005b:
            int r4 = r7.read(r1, r2, r0)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            if (r4 <= 0) goto L_0x0066
            r6.write(r1, r2, r4)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            int r3 = r3 + r4
            goto L_0x005b
        L_0x0066:
            r6.close()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r7.close()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r0.<init>()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r1 = "writeMD5File, finish, i = "
            r0.append(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r0.append(r3)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r1 = "bytes"
            r0.append(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r6.close()     // Catch:{ Exception -> 0x0088 }
        L_0x0088:
            r7.close()     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c1
        L_0x008c:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto L_0x00c3
        L_0x0090:
            r0 = move-exception
            r1 = r6
            r6 = r0
            goto L_0x00a5
        L_0x0094:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r5
            goto L_0x00c3
        L_0x009a:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r5
            goto L_0x00a5
        L_0x00a0:
            r6 = move-exception
            r7 = r1
            goto L_0x00c3
        L_0x00a3:
            r6 = move-exception
            r7 = r1
        L_0x00a5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r0.<init>()     // Catch:{ all -> 0x00c2 }
            java.lang.String r2 = "writeMD5File, Exception"
            r0.append(r2)     // Catch:{ all -> 0x00c2 }
            r0.append(r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x00c2 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r6)     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x00be
            r1.close()     // Catch:{ Exception -> 0x00be }
        L_0x00be:
            if (r7 == 0) goto L_0x00c1
            goto L_0x0088
        L_0x00c1:
            return
        L_0x00c2:
            r6 = move-exception
        L_0x00c3:
            if (r1 == 0) goto L_0x00c8
            r1.close()     // Catch:{ Exception -> 0x00c8 }
        L_0x00c8:
            if (r7 == 0) goto L_0x00cd
            r7.close()     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            goto L_0x00cf
        L_0x00ce:
            throw r6
        L_0x00cf:
            goto L_0x00ce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.b(android.content.Context, java.lang.String):void");
    }

    public static void a(String str) {
        j(str);
        File file = new File(str);
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean c(Context context) {
        try {
            if (k(context.getExternalFilesDir((String) null) + "/trace.trace")) {
                return true;
            }
            if (Build.VERSION.SDK_INT < 23) {
                return k(Environment.getExternalStorageDirectory() + "/trace.trace");
            } else if (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                return false;
            } else {
                return k(Environment.getExternalStorageDirectory() + "/trace.trace");
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        return file.renameTo(new File(str2));
    }

    public static boolean a(String str, String str2, Boolean bool) {
        LogUtil.a("copy, oldPath = " + str);
        LogUtil.a("copy, newPath = " + str2);
        boolean z = false;
        try {
            File file = new File(str2);
            File file2 = new File(str);
            if (file.exists()) {
                file.delete();
            } else {
                LogUtil.a("copy, newPath = " + str2 + " is not exist!");
            }
            if (file2.exists()) {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] bArr = new byte[32768];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
                z = true;
                if (bool.booleanValue()) {
                    LogUtil.a("copy success to delete" + file2.delete());
                }
            } else {
                LogUtil.a("copy, oldPath = " + str + " is not exist!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.a("copy, Exception" + e.toString());
        }
        LogUtil.a("copy, isOk " + z);
        return z;
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        return true;
    }

    public static String a(long j) {
        String str;
        float f = (float) j;
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "KB";
        } else {
            str = "B";
        }
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "MB";
        }
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "GB";
        }
        if (f > 1024.0f) {
            f /= 1024.0f;
            str = "TB";
        }
        String str2 = f < 10.0f ? "%.2f" : f < 100.0f ? "%.1f" : "%.0f";
        return String.format(str2 + str, new Object[]{Float.valueOf(f)});
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte a2 : bArr) {
            sb.append(a(a2));
        }
        return sb.toString();
    }

    private static String a(byte b2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        return new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01cd A[SYNTHETIC, Splitter:B:101:0x01cd] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01d5 A[Catch:{ IOException -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01da A[Catch:{ IOException -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01e5 A[SYNTHETIC, Splitter:B:113:0x01e5] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01ed A[Catch:{ IOException -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01f2 A[Catch:{ IOException -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0198 A[SYNTHETIC, Splitter:B:86:0x0198] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01a0 A[Catch:{ IOException -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a5 A[Catch:{ IOException -> 0x019c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:98:0x01b0=Splitter:B:98:0x01b0, B:83:0x017b=Splitter:B:83:0x017b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r11, java.lang.String r12) {
        /*
            r0 = 0
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x01ad, IOException -> 0x0178, all -> 0x0173 }
            r2.<init>(r11)     // Catch:{ ZipException -> 0x01ad, IOException -> 0x0178, all -> 0x0173 }
            java.util.Enumeration r11 = r2.entries()     // Catch:{ ZipException -> 0x0170, IOException -> 0x016d, all -> 0x0169 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch:{ ZipException -> 0x0170, IOException -> 0x016d, all -> 0x0169 }
            r5 = r0
        L_0x0010:
            boolean r6 = r11.hasMoreElements()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r7 = 1
            if (r6 == 0) goto L_0x0148
            java.lang.Object r6 = r11.nextElement()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.util.zip.ZipEntry r6 = (java.util.zip.ZipEntry) r6     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r8 = r6.getName()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            if (r9 == 0) goto L_0x0041
            java.lang.String r11 = "upZipFile:: zipEntry is null or zipEntry.getName is empty !"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r11)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r11 = move-exception
            goto L_0x003d
        L_0x0034:
            if (r5 == 0) goto L_0x0039
            r5.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0040
        L_0x003d:
            r11.printStackTrace()
        L_0x0040:
            return r1
        L_0x0041:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.<init>()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r10 = "upZipFile:: ze.getName() = "
            r9.append(r10)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r10 = r6.getName()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.append(r10)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r9 = r9.toString()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            boolean r9 = r6.isDirectory()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            if (r9 == 0) goto L_0x008b
            int r6 = r8.length()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            int r6 = r6 - r7
            java.lang.String r6 = r8.substring(r1, r6)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.io.File r7 = new java.io.File     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.<init>()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.append(r12)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.append(r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.append(r6)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r6 = r8.toString()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r7.<init>(r6)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            boolean r6 = r7.exists()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            if (r6 != 0) goto L_0x0010
            r7.mkdirs()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            goto L_0x0010
        L_0x008b:
            java.io.File r7 = new java.io.File     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.<init>()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.append(r12)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.append(r10)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.append(r8)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r8 = r9.toString()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r7.<init>(r8)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.<init>()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r9 = "upZipFile::file = "
            r8.append(r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r9 = r7.getPath()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.append(r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r8 = r8.toString()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r8)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.io.File r8 = new java.io.File     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r9 = r7.getParent()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.<init>(r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            boolean r9 = r8.exists()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            if (r9 != 0) goto L_0x00ce
            r8.mkdirs()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
        L_0x00ce:
            boolean r8 = r7.exists()     // Catch:{ IOException -> 0x00d8 }
            if (r8 != 0) goto L_0x00f4
            r7.createNewFile()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00f4
        L_0x00d8:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.<init>()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r10 = "upZipFile::createNewFile  exception  = "
            r9.append(r10)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r10 = r8.toString()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.append(r10)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r9 = r9.toString()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.printStackTrace()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
        L_0x00f4:
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r9.<init>(r7)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            r8.<init>(r9)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ ZipException -> 0x0144, IOException -> 0x0141, all -> 0x013d }
            java.io.InputStream r6 = r2.getInputStream(r6)     // Catch:{ ZipException -> 0x0144, IOException -> 0x0141, all -> 0x013d }
            r5.<init>(r6)     // Catch:{ ZipException -> 0x0144, IOException -> 0x0141, all -> 0x013d }
        L_0x0107:
            int r0 = r5.read(r4, r1, r3)     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            r6 = -1
            if (r0 == r6) goto L_0x0112
            r8.write(r4, r1, r0)     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            goto L_0x0107
        L_0x0112:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            r0.<init>()     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            java.lang.String r6 = "upZipFile::finish the path: "
            r0.append(r6)     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            java.lang.String r6 = r7.getPath()     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            r0.append(r6)     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            r5.close()     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            r8.close()     // Catch:{ ZipException -> 0x013a, IOException -> 0x0137, all -> 0x0134 }
            r0 = r5
            r5 = r8
            goto L_0x0010
        L_0x0134:
            r11 = move-exception
            r0 = r5
            goto L_0x013e
        L_0x0137:
            r11 = move-exception
            r0 = r5
            goto L_0x0142
        L_0x013a:
            r11 = move-exception
            r0 = r5
            goto L_0x0145
        L_0x013d:
            r11 = move-exception
        L_0x013e:
            r5 = r8
            goto L_0x01e3
        L_0x0141:
            r11 = move-exception
        L_0x0142:
            r5 = r8
            goto L_0x017b
        L_0x0144:
            r11 = move-exception
        L_0x0145:
            r5 = r8
            goto L_0x01b0
        L_0x0148:
            r2.close()     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            java.lang.String r11 = "upZipFile::finish !"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r11)     // Catch:{ ZipException -> 0x0167, IOException -> 0x0165 }
            if (r0 == 0) goto L_0x0158
            r0.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0158
        L_0x0156:
            r11 = move-exception
            goto L_0x0161
        L_0x0158:
            if (r5 == 0) goto L_0x015d
            r5.close()     // Catch:{ IOException -> 0x0156 }
        L_0x015d:
            r2.close()     // Catch:{ IOException -> 0x0156 }
            goto L_0x0164
        L_0x0161:
            r11.printStackTrace()
        L_0x0164:
            return r7
        L_0x0165:
            r11 = move-exception
            goto L_0x017b
        L_0x0167:
            r11 = move-exception
            goto L_0x01b0
        L_0x0169:
            r11 = move-exception
            r5 = r0
            goto L_0x01e3
        L_0x016d:
            r11 = move-exception
            r5 = r0
            goto L_0x017b
        L_0x0170:
            r11 = move-exception
            r5 = r0
            goto L_0x01b0
        L_0x0173:
            r11 = move-exception
            r2 = r0
            r5 = r2
            goto L_0x01e3
        L_0x0178:
            r11 = move-exception
            r2 = r0
            r5 = r2
        L_0x017b:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r12.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = "upZipFile::ioex = "
            r12.append(r3)     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = r11.toString()     // Catch:{ all -> 0x01e2 }
            r12.append(r3)     // Catch:{ all -> 0x01e2 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01e2 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)     // Catch:{ all -> 0x01e2 }
            r11.printStackTrace()     // Catch:{ all -> 0x01e2 }
            if (r0 == 0) goto L_0x019e
            r0.close()     // Catch:{ IOException -> 0x019c }
            goto L_0x019e
        L_0x019c:
            r11 = move-exception
            goto L_0x01a9
        L_0x019e:
            if (r5 == 0) goto L_0x01a3
            r5.close()     // Catch:{ IOException -> 0x019c }
        L_0x01a3:
            if (r2 == 0) goto L_0x01ac
            r2.close()     // Catch:{ IOException -> 0x019c }
            goto L_0x01ac
        L_0x01a9:
            r11.printStackTrace()
        L_0x01ac:
            return r1
        L_0x01ad:
            r11 = move-exception
            r2 = r0
            r5 = r2
        L_0x01b0:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r12.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = "upZipFile::zipex = "
            r12.append(r3)     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = r11.toString()     // Catch:{ all -> 0x01e2 }
            r12.append(r3)     // Catch:{ all -> 0x01e2 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x01e2 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)     // Catch:{ all -> 0x01e2 }
            r11.printStackTrace()     // Catch:{ all -> 0x01e2 }
            if (r0 == 0) goto L_0x01d3
            r0.close()     // Catch:{ IOException -> 0x01d1 }
            goto L_0x01d3
        L_0x01d1:
            r11 = move-exception
            goto L_0x01de
        L_0x01d3:
            if (r5 == 0) goto L_0x01d8
            r5.close()     // Catch:{ IOException -> 0x01d1 }
        L_0x01d8:
            if (r2 == 0) goto L_0x01e1
            r2.close()     // Catch:{ IOException -> 0x01d1 }
            goto L_0x01e1
        L_0x01de:
            r11.printStackTrace()
        L_0x01e1:
            return r1
        L_0x01e2:
            r11 = move-exception
        L_0x01e3:
            if (r0 == 0) goto L_0x01eb
            r0.close()     // Catch:{ IOException -> 0x01e9 }
            goto L_0x01eb
        L_0x01e9:
            r12 = move-exception
            goto L_0x01f6
        L_0x01eb:
            if (r5 == 0) goto L_0x01f0
            r5.close()     // Catch:{ IOException -> 0x01e9 }
        L_0x01f0:
            if (r2 == 0) goto L_0x01f9
            r2.close()     // Catch:{ IOException -> 0x01e9 }
            goto L_0x01f9
        L_0x01f6:
            r12.printStackTrace()
        L_0x01f9:
            goto L_0x01fb
        L_0x01fa:
            throw r11
        L_0x01fb:
            goto L_0x01fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.a(java.io.File, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r2 != null) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r2, long r3, java.lang.String r5) throws java.io.IOException {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "rw"
            r0.<init>(r2, r1)
            r2 = 0
            r0.seek(r3)     // Catch:{ Throwable -> 0x0018 }
            byte[] r3 = r5.getBytes()     // Catch:{ Throwable -> 0x0018 }
            r0.write(r3)     // Catch:{ Throwable -> 0x0018 }
            r0.close()
            return
        L_0x0016:
            r3 = move-exception
            goto L_0x001a
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0016 }
        L_0x001a:
            if (r2 == 0) goto L_0x0025
            r0.close()     // Catch:{ Throwable -> 0x0020 }
            goto L_0x0028
        L_0x0020:
            r4 = move-exception
            r2.addSuppressed(r4)
            goto L_0x0028
        L_0x0025:
            r0.close()
        L_0x0028:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.g.a(java.lang.String, long, java.lang.String):void");
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        return true;
    }
}
