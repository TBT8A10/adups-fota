package com.adups.fota.utils;

import android.text.TextUtils;
import com.adups.fota.bean.RootErrBean;
import java.io.File;
import java.util.List;
import java.util.Map;

/* compiled from: RootCheck */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f1638a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f1639b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f1640c;
    private Map<String, String> d;
    private RootErrBean e;

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0089 A[SYNTHETIC, Splitter:B:44:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0095 A[SYNTHETIC, Splitter:B:51:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            r8 = 1048576(0x100000, float:1.469368E-39)
            byte[] r8 = new byte[r8]     // Catch:{ Exception -> 0x0065 }
            if (r2 != 0) goto L_0x0020
            r3.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x001f:
            return r1
        L_0x0020:
            int r4 = r3.read(r8)     // Catch:{ Exception -> 0x0065 }
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x002c
            r2.update(r8, r6, r4)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0020
        L_0x002c:
            byte[] r8 = r2.digest()     // Catch:{ Exception -> 0x0065 }
            if (r8 != 0) goto L_0x003b
            r3.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r8 = move-exception
            r8.printStackTrace()
        L_0x003a:
            return r1
        L_0x003b:
            int r2 = r8.length     // Catch:{ Exception -> 0x0065 }
        L_0x003c:
            if (r6 >= r2) goto L_0x0058
            byte r4 = r8[r6]     // Catch:{ Exception -> 0x0065 }
            r4 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ Exception -> 0x0065 }
            int r5 = r4.length()     // Catch:{ Exception -> 0x0065 }
            r7 = 1
            if (r5 != r7) goto L_0x0052
            java.lang.String r5 = "0"
            r0.append(r5)     // Catch:{ Exception -> 0x0065 }
        L_0x0052:
            r0.append(r4)     // Catch:{ Exception -> 0x0065 }
            int r6 = r6 + 1
            goto L_0x003c
        L_0x0058:
            java.lang.String r8 = r0.toString()     // Catch:{ Exception -> 0x0065 }
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0064:
            return r8
        L_0x0065:
            r8 = move-exception
            goto L_0x006c
        L_0x0067:
            r8 = move-exception
            r3 = r1
            goto L_0x0093
        L_0x006a:
            r8 = move-exception
            r3 = r1
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r0.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = "getFileMD5, Exception "
            r0.append(r2)     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x0092 }
            r0.append(r2)     // Catch:{ all -> 0x0092 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0092 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)     // Catch:{ all -> 0x0092 }
            r8.printStackTrace()     // Catch:{ all -> 0x0092 }
            if (r3 == 0) goto L_0x0091
            r3.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0091:
            return r1
        L_0x0092:
            r8 = move-exception
        L_0x0093:
            if (r3 == 0) goto L_0x009d
            r3.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009d:
            goto L_0x009f
        L_0x009e:
            throw r8
        L_0x009f:
            goto L_0x009e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.p.b(java.lang.String):java.lang.String");
    }

    private boolean c(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File a2 : listFiles) {
                if (a(a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r0 != null) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r10) throws java.lang.Exception {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r9.d = r0
            boolean r0 = com.adups.fota.utils.g.h(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "isZip = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)
            java.lang.String r1 = "RC/checkroot"
            r2 = 0
            if (r0 == 0) goto L_0x004f
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
            java.util.zip.ZipEntry r10 = r0.getEntry(r1)     // Catch:{ Exception -> 0x0037 }
            if (r10 == 0) goto L_0x0043
            java.io.InputStream r10 = r0.getInputStream(r10)     // Catch:{ Exception -> 0x0037 }
            r9.a((java.io.InputStream) r10)     // Catch:{ Exception -> 0x0037 }
            goto L_0x0043
        L_0x0037:
            r10 = move-exception
            goto L_0x003e
        L_0x0039:
            r10 = move-exception
            r0 = r2
            goto L_0x0049
        L_0x003c:
            r10 = move-exception
            r0 = r2
        L_0x003e:
            r10.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x00bf
        L_0x0043:
            r0.close()
            goto L_0x00bf
        L_0x0048:
            r10 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()
        L_0x004e:
            throw r10
        L_0x004f:
            r3 = 0
            java.lang.String r0 = "7z"
            com.adups.fota.utils.g.a((java.lang.String) r10, (long) r3, (java.lang.String) r0)
            org.apache.commons.compress.archivers.sevenz.SevenZFile r0 = new org.apache.commons.compress.archivers.sevenz.SevenZFile     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00a8, all -> 0x00a4 }
        L_0x0060:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r5 = r0.getNextEntry()     // Catch:{ Exception -> 0x00a2 }
            if (r5 != 0) goto L_0x0075
            java.lang.String r1 = "entry == null"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00a2 }
            android.content.Context r1 = com.adups.fota.MyApplication.c()     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r5 = "cause_get_entry_failed"
            com.adups.fota.f.a.a(r1, r5)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x009c
        L_0x0075:
            java.lang.String r6 = r5.getName()     // Catch:{ Exception -> 0x00a2 }
            boolean r6 = r6.equals(r1)     // Catch:{ Exception -> 0x00a2 }
            if (r6 != 0) goto L_0x0080
            goto L_0x0060
        L_0x0080:
            long r6 = r5.getSize()     // Catch:{ Exception -> 0x00a2 }
            int r1 = (int) r6     // Catch:{ Exception -> 0x00a2 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00a2 }
        L_0x0087:
            r6 = 0
            long r7 = r5.getSize()     // Catch:{ Exception -> 0x00a2 }
            int r8 = (int) r7     // Catch:{ Exception -> 0x00a2 }
            int r6 = r0.read(r1, r6, r8)     // Catch:{ Exception -> 0x00a2 }
            if (r6 <= 0) goto L_0x009c
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00a2 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x00a2 }
            r9.a((java.io.InputStream) r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x0087
        L_0x009c:
            java.lang.String r1 = "8p"
            com.adups.fota.utils.g.a((java.lang.String) r10, (long) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00bc
        L_0x00a2:
            r10 = move-exception
            goto L_0x00aa
        L_0x00a4:
            r10 = move-exception
            r0 = r2
            goto L_0x018e
        L_0x00a8:
            r10 = move-exception
            r0 = r2
        L_0x00aa:
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x018d }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r10)     // Catch:{ all -> 0x018d }
            android.content.Context r10 = com.adups.fota.MyApplication.c()     // Catch:{ all -> 0x018d }
            java.lang.String r1 = "cause_unzip_failed"
            com.adups.fota.f.a.a(r10, r1)     // Catch:{ all -> 0x018d }
            if (r0 == 0) goto L_0x00bf
        L_0x00bc:
            r0.close()
        L_0x00bf:
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.d
            int r10 = r10.size()
            java.lang.String r0 = ""
            if (r10 != 0) goto L_0x00ca
            return r0
        L_0x00ca:
            com.adups.fota.bean.RootErrBean r10 = new com.adups.fota.bean.RootErrBean     // Catch:{ Exception -> 0x0180 }
            r10.<init>()     // Catch:{ Exception -> 0x0180 }
            r9.e = r10     // Catch:{ Exception -> 0x0180 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0180 }
            r10.<init>()     // Catch:{ Exception -> 0x0180 }
            r9.f1638a = r10     // Catch:{ Exception -> 0x0180 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0180 }
            r10.<init>()     // Catch:{ Exception -> 0x0180 }
            r9.f1639b = r10     // Catch:{ Exception -> 0x0180 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x0180 }
            r10.<init>()     // Catch:{ Exception -> 0x0180 }
            r9.f1640c = r10     // Catch:{ Exception -> 0x0180 }
            java.lang.String r10 = "/system/bin"
            boolean r10 = r9.c(r10)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r1 = "/system/xbin"
            boolean r1 = r9.c(r1)     // Catch:{ Exception -> 0x0180 }
            if (r10 != 0) goto L_0x0144
            if (r1 != 0) goto L_0x0144
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.d     // Catch:{ Exception -> 0x0180 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x0180 }
            if (r10 <= 0) goto L_0x0144
            java.util.Map<java.lang.String, java.lang.String> r10 = r9.d     // Catch:{ Exception -> 0x0180 }
            java.util.Set r10 = r10.keySet()     // Catch:{ Exception -> 0x0180 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0180 }
        L_0x0108:
            boolean r1 = r10.hasNext()     // Catch:{ Exception -> 0x0180 }
            if (r1 == 0) goto L_0x0144
            java.lang.Object r1 = r10.next()     // Catch:{ Exception -> 0x0180 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0180 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r9.d     // Catch:{ Exception -> 0x0180 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0180 }
            if (r3 == 0) goto L_0x012d
            java.util.Map<java.lang.String, java.lang.String> r3 = r9.d     // Catch:{ Exception -> 0x0180 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0180 }
            java.lang.String r4 = "ignore"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x0180 }
            if (r3 == 0) goto L_0x012d
            goto L_0x0108
        L_0x012d:
            java.util.List<java.lang.String> r3 = r9.f1640c     // Catch:{ Exception -> 0x0180 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0180 }
            r4 = 5
            if (r3 <= r4) goto L_0x0137
            goto L_0x0144
        L_0x0137:
            java.util.List<java.lang.String> r3 = r9.f1640c     // Catch:{ Exception -> 0x0180 }
            r3.add(r1)     // Catch:{ Exception -> 0x0180 }
            com.adups.fota.bean.RootErrBean r1 = r9.e     // Catch:{ Exception -> 0x0180 }
            java.util.List<java.lang.String> r3 = r9.f1640c     // Catch:{ Exception -> 0x0180 }
            r1.setDelete(r3)     // Catch:{ Exception -> 0x0180 }
            goto L_0x0108
        L_0x0144:
            java.util.List<java.lang.String> r10 = r9.f1638a     // Catch:{ Exception -> 0x0180 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x0180 }
            java.util.List<java.lang.String> r1 = r9.f1639b     // Catch:{ Exception -> 0x0180 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0180 }
            int r10 = r10 + r1
            java.util.List<java.lang.String> r1 = r9.f1640c     // Catch:{ Exception -> 0x0180 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0180 }
            int r10 = r10 + r1
            if (r10 <= 0) goto L_0x0184
            com.google.gson.Gson r10 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0180 }
            r10.<init>()     // Catch:{ Exception -> 0x0180 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0180 }
            r1.<init>()     // Catch:{ Exception -> 0x0180 }
            java.lang.String r3 = "root gson "
            r1.append(r3)     // Catch:{ Exception -> 0x0180 }
            com.adups.fota.bean.RootErrBean r3 = r9.e     // Catch:{ Exception -> 0x0180 }
            java.lang.String r3 = r10.toJson((java.lang.Object) r3)     // Catch:{ Exception -> 0x0180 }
            r1.append(r3)     // Catch:{ Exception -> 0x0180 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0180 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0180 }
            com.adups.fota.bean.RootErrBean r1 = r9.e     // Catch:{ Exception -> 0x0180 }
            java.lang.String r10 = r10.toJson((java.lang.Object) r1)     // Catch:{ Exception -> 0x0180 }
            return r10
        L_0x0180:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0184:
            r9.f1638a = r2
            r9.f1639b = r2
            r9.f1640c = r2
            r9.d = r2
            return r0
        L_0x018d:
            r10 = move-exception
        L_0x018e:
            if (r0 == 0) goto L_0x0193
            r0.close()
        L_0x0193:
            goto L_0x0195
        L_0x0194:
            throw r10
        L_0x0195:
            goto L_0x0194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.p.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        r8 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.InputStream r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "\t"
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r8)
            r8 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0074 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0074 }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0074 }
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0074 }
            r2.<init>(r3)     // Catch:{ all -> 0x0074 }
        L_0x0014:
            java.lang.String r8 = r2.readLine()     // Catch:{ all -> 0x0072 }
            if (r8 == 0) goto L_0x006b
            int r3 = r8.indexOf(r0)     // Catch:{ all -> 0x0072 }
            r4 = -1
            if (r3 <= r4) goto L_0x0014
            java.lang.String[] r8 = r8.split(r0)     // Catch:{ all -> 0x0072 }
            int r3 = r8.length     // Catch:{ all -> 0x0072 }
            if (r3 <= 0) goto L_0x0014
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r3.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = "/system/"
            r3.append(r4)     // Catch:{ all -> 0x0072 }
            r4 = 0
            r4 = r8[r4]     // Catch:{ all -> 0x0072 }
            r3.append(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0072 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r7.d     // Catch:{ Exception -> 0x0063 }
            r5 = 1
            r6 = r8[r5]     // Catch:{ Exception -> 0x0063 }
            r4.put(r3, r6)     // Catch:{ Exception -> 0x0063 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
            r4.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r6 = "checkDevicesIsRoot "
            r4.append(r6)     // Catch:{ Exception -> 0x0063 }
            r4.append(r3)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r6 = " md5Encode "
            r4.append(r6)     // Catch:{ Exception -> 0x0063 }
            r8 = r8[r5]     // Catch:{ Exception -> 0x0063 }
            r4.append(r8)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x0063 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0014
        L_0x0063:
            java.util.Map<java.lang.String, java.lang.String> r8 = r7.d     // Catch:{ all -> 0x0072 }
            java.lang.String r4 = ""
            r8.put(r3, r4)     // Catch:{ all -> 0x0072 }
            goto L_0x0014
        L_0x006b:
            r1.close()
            r2.close()
            return
        L_0x0072:
            r8 = move-exception
            goto L_0x0077
        L_0x0074:
            r0 = move-exception
            r2 = r8
            r8 = r0
        L_0x0077:
            r1.close()
            if (r2 == 0) goto L_0x007f
            r2.close()
        L_0x007f:
            goto L_0x0081
        L_0x0080:
            throw r8
        L_0x0081:
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.p.a(java.io.InputStream):void");
    }

    private boolean a(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!this.d.containsKey(absolutePath)) {
            LogUtil.a("path " + absolutePath + " is un exist");
            this.f1638a.add(absolutePath);
            this.e.setAdd(this.f1638a);
        } else if (this.d.containsKey(absolutePath)) {
            if (this.d.get(absolutePath).equals("ignore")) {
                this.d.remove(absolutePath);
            } else if (file.isDirectory()) {
                LogUtil.a("path " + absolutePath + " is directory");
                try {
                    Thread.sleep(5);
                    this.d.remove(absolutePath);
                    c(absolutePath);
                } catch (Exception unused) {
                }
            } else if (file.isFile()) {
                try {
                    String b2 = b(absolutePath);
                    if (!TextUtils.isEmpty(b2)) {
                        if (!this.d.get(absolutePath).equals(b2)) {
                            this.f1639b.add(absolutePath);
                            this.e.setModify(this.f1639b);
                        }
                    }
                    this.d.remove(absolutePath);
                } catch (Exception unused2) {
                    this.d.remove(absolutePath);
                }
            } else {
                this.d.remove(absolutePath);
            }
        }
        return this.f1638a.size() + this.f1639b.size() > 5;
    }
}
