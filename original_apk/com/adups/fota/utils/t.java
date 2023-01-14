package com.adups.fota.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.adups.fota.MyApplication;
import com.adups.fota.b.d;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.e.c;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* compiled from: StorageUtil */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static String f1647a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f1648b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f1649c = null;
    private static double d = 2.5d;

    /* compiled from: StorageUtil */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1650a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1651b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f1652c;
        public final int d;

        a(String str, boolean z, boolean z2, int i) {
            this.f1650a = str;
            this.f1651b = z;
            this.f1652c = z2;
            this.d = i;
        }
    }

    public static int b(Context context, long j) {
        try {
            VersionBean c2 = c.a().c();
            d = (c2 != null ? c2.getIsOldPkg() : 0) == 0 ? 2.5d : 1.0d;
            return d(context, ((long) d) * j);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean c(Context context, long j) {
        return a_shaKey_method2(b(context, true), a(j));
    }

    public static int d(Context context, long j) {
        long f = f(context, j);
        LogUtil.a("size = " + f);
        if (f == 0) {
            return 3;
        }
        return f == -1 ? 1 : 2;
    }

    public static boolean e(Context context, long j) {
        long a2 = a(j);
        if (!h(context)) {
            return g(context, a2);
        }
        boolean a3 = a_shaKey_method2(b(context, true), a2);
        return !a3 ? g(context, a2) : a3;
    }

    public static void f(Context context) {
        try {
            context.getExternalFilesDir((String) null);
            new File(context.getFilesDir() + "/adupsfota").mkdirs();
            new File(context.getExternalFilesDir((String) null) + "/adupsfota").mkdirs();
            new File(context.getExternalFilesDir((String) null) + "/fota").mkdirs();
            new r(context).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean g(Context context) {
        String str;
        String a2 = o.a(context, "ota_download_path", (String) null);
        if (!TextUtils.isEmpty(a2) && a2.contains("#")) {
            String[] split = a2.split("#");
            if (split.length == 3) {
                a(split[0], split[1], split[2]);
            }
        }
        String str2 = f1647a;
        if (str2 == null || str2.length() <= 0 || f1647a.equals("null")) {
            str = l(context);
        } else {
            str = b(f1647a);
        }
        LogUtil.a("externalStorageState = " + str);
        return "mounted".equals(str);
    }

    public static boolean h(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            if (Build.VERSION.SDK_INT < 24) {
                try {
                    int length = Array.getLength(storageManager.getClass().getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]));
                    LogUtil.a("storage count : " + length);
                    if (length > 1) {
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                }
            } else {
                int size = storageManager.getStorageVolumes().size();
                LogUtil.a("storage count : " + size);
                if (size > 1) {
                    return true;
                }
                return false;
            }
        }
        return Environment.getExternalStorageState().equalsIgnoreCase("mounted");
    }

    private static String i(Context context) {
        String a2 = o.a(context, "CustomDtPath", "");
        if (!TextUtils.isEmpty(a2) && new File(a2).exists()) {
            return a2;
        }
        String b2 = b(context, true);
        if (TextUtils.isEmpty(b2)) {
            return "";
        }
        String str = b2 + "/Android/data/" + context.getPackageName() + "/files";
        o.b(context, "CustomDtPath", str);
        return str;
    }

    /* access modifiers changed from: private */
    public static void j(Context context) {
        try {
            File file = new File(context.getFilesDir().getPath() + "/adupsfota/update.zip");
            if (file.exists()) {
                LogUtil.a("delete " + file);
                file.delete();
            }
            File file2 = new File(context.getFilesDir().getPath() + "/update.zip");
            if (file2.exists()) {
                LogUtil.a("delete " + file2);
                file2.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File k(Context context) {
        return new File(a_shaKey_method2(context, true));
    }

    private static String l(Context context) {
        return b(k(context).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        if (r0.equals("internal") == false) goto L_0x0084;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 21
            if (r0 < r2) goto L_0x00bf
            boolean r0 = n(r8)
            if (r0 == 0) goto L_0x0016
            java.io.File r8 = r8.getFilesDir()
            java.lang.String r8 = r8.toString()
            return r8
        L_0x0016:
            com.adups.fota.e.c r0 = com.adups.fota.e.c.a()
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            java.lang.String r3 = "download_path_server"
            java.lang.Object r0 = r0.a((java.lang.String) r3, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "download_path_server : "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)
            r2 = 1
            if (r0 != r2) goto L_0x0044
            java.lang.String r8 = i(r8)
            return r8
        L_0x0044:
            r3 = 2
            java.lang.String r4 = "/data/ota_package"
            r5 = 29
            if (r0 != r3) goto L_0x0059
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0050
            return r4
        L_0x0050:
            java.io.File r8 = r8.getFilesDir()
            java.lang.String r8 = r8.getAbsolutePath()
            return r8
        L_0x0059:
            com.adups.fota.utils.c r0 = com.adups.fota.utils.c.j()
            java.lang.String r0 = r0.m()
            r3 = -1
            int r6 = r0.hashCode()
            r7 = -1820761141(0xffffffff937963cb, float:-3.147742E-27)
            if (r6 == r7) goto L_0x007a
            r7 = 570410685(0x21ffc6bd, float:1.7332078E-18)
            if (r6 == r7) goto L_0x0071
            goto L_0x0084
        L_0x0071:
            java.lang.String r6 = "internal"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0084
            goto L_0x0085
        L_0x007a:
            java.lang.String r1 = "external"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0084
            r1 = 1
            goto L_0x0085
        L_0x0084:
            r1 = -1
        L_0x0085:
            if (r1 == 0) goto L_0x00b1
            if (r1 == r2) goto L_0x00ac
            java.lang.String r0 = i(r8)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x009e
            long r1 = f()
            boolean r1 = a((java.lang.String) r0, (long) r1)
            if (r1 == 0) goto L_0x009e
            return r0
        L_0x009e:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x00a3
            return r4
        L_0x00a3:
            java.io.File r8 = r8.getFilesDir()
            java.lang.String r8 = r8.getAbsolutePath()
            return r8
        L_0x00ac:
            java.lang.String r8 = i(r8)
            return r8
        L_0x00b1:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x00b6
            return r4
        L_0x00b6:
            java.io.File r8 = r8.getFilesDir()
            java.lang.String r8 = r8.getAbsolutePath()
            return r8
        L_0x00bf:
            java.io.File r8 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r8 = r8.getAbsolutePath()
            java.util.List r0 = d()
            if (r0 == 0) goto L_0x00ff
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x00ff
        L_0x00d3:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x00ff
            java.lang.Object r2 = r0.get(r1)
            com.adups.fota.utils.t$a r2 = (com.adups.fota.utils.t.a) r2
            if (r2 == 0) goto L_0x00fc
            java.lang.String r2 = r2.f1650a
            boolean r3 = r2.equals(r8)
            if (r3 != 0) goto L_0x00fc
            java.lang.String r3 = b((java.lang.String) r2)
            java.lang.String r4 = "mounted"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00fc
            boolean r3 = c((java.lang.String) r2)
            if (r3 == 0) goto L_0x00fc
            return r2
        L_0x00fc:
            int r1 = r1 + 1
            goto L_0x00d3
        L_0x00ff:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.t.m(android.content.Context):java.lang.String");
    }

    private static boolean n(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            try {
                Object invoke = storageManager.getClass().getMethod("getVolumes", new Class[0]).invoke(storageManager, new Object[0]);
                for (int i = 0; i < Array.getLength(invoke); i++) {
                    Object obj = Array.get(invoke, i);
                    Method method = obj.getClass().getMethod("getType", new Class[0]);
                    Method method2 = obj.getClass().getMethod("getState", new Class[0]);
                    Method method3 = obj.getClass().getMethod("getDisk", new Class[0]);
                    if (((Integer) method.invoke(obj, new Object[0])).intValue() == 0 && ((Integer) method2.invoke(obj, new Object[0])).intValue() == 2) {
                        Object invoke2 = method3.invoke(obj, new Object[0]);
                        if (((Integer) invoke2.getClass().getField("volumeCount").get(invoke2)).intValue() > 1) {
                            return true;
                        }
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String c() {
        return Environment.getExternalStorageDirectory() + File.separator + "Android/";
    }

    public static boolean a(Context context, long j) {
        return g(context, a(j));
    }

    public static String c(Context context) {
        return context.getExternalFilesDir((String) null) + File.separator;
    }

    private static boolean d(String str) {
        long j;
        try {
            File file = new File(str);
            if (file.exists() || file.mkdir() || file.mkdirs()) {
                StatFs statFs = new StatFs(file.getPath());
                long blockSize = (long) statFs.getBlockSize();
                long availableBlocks = (long) statFs.getAvailableBlocks();
                VersionBean c2 = c.a().c();
                double d2 = 1.0d;
                if (c2 != null) {
                    j = c2.getFileSize();
                    if (c2.getIsOldPkg() == 0) {
                        d2 = 2.5d;
                    }
                } else {
                    j = 0;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("availableBlock = ");
                long j2 = availableBlocks * blockSize;
                sb.append(j2);
                sb.append("; needSize = ");
                sb.append(j);
                LogUtil.a(sb.toString());
                if (j != 0) {
                    double d3 = (double) j;
                    Double.isNaN(d3);
                    if (((double) j2) <= d3 * d2) {
                        return false;
                    }
                }
                return true;
            }
            LogUtil.a(str + ",mkdir fail");
            return false;
        } catch (Exception unused) {
            LogUtil.b(str + " card mount error");
            return false;
        }
    }

    private static long a(long j) {
        VersionBean c2 = c.a().c();
        d = (c2 != null ? c2.getIsOldPkg() : 0) == 0 ? 2.5d : 1.0d;
        double d2 = d;
        double d3 = (double) j;
        Double.isNaN(d3);
        return Double.valueOf(d2 * d3).longValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0095 A[Catch:{ Exception -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b1 A[Catch:{ Exception -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x00c0
            boolean r0 = d((java.lang.String) r5)
            if (r0 != 0) goto L_0x000f
            goto L_0x00c0
        L_0x000f:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r2.<init>()     // Catch:{ Exception -> 0x00b7 }
            r2.append(r5)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = "/test/test.txt"
            r2.append(r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00b7 }
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x00b7 }
            if (r2 == 0) goto L_0x0043
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r2.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = "file.exists,so delete="
            r2.append(r3)     // Catch:{ Exception -> 0x00b7 }
            boolean r3 = r0.delete()     // Catch:{ Exception -> 0x00b7 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b7 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00b7 }
        L_0x0043:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r3.<init>()     // Catch:{ Exception -> 0x00b7 }
            r3.append(r5)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = "/test/"
            r3.append(r4)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b7 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00b7 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00b7 }
            if (r3 == 0) goto L_0x0077
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r3.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = "fileDir.exists,so delete="
            r3.append(r4)     // Catch:{ Exception -> 0x00b7 }
            boolean r4 = r2.delete()     // Catch:{ Exception -> 0x00b7 }
            r3.append(r4)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00b7 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00b7 }
        L_0x0077:
            boolean r3 = r2.mkdirs()     // Catch:{ Exception -> 0x00b7 }
            if (r3 != 0) goto L_0x008a
            boolean r3 = r2.mkdir()     // Catch:{ Exception -> 0x00b7 }
            if (r3 == 0) goto L_0x0084
            goto L_0x008a
        L_0x0084:
            java.lang.String r3 = "mkdirs  failed!!"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x008f
        L_0x008a:
            java.lang.String r3 = "mkdirs  success"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00b7 }
        L_0x008f:
            boolean r3 = r0.createNewFile()     // Catch:{ Exception -> 0x00b7 }
            if (r3 == 0) goto L_0x00b1
            r0.delete()     // Catch:{ Exception -> 0x00b7 }
            r2.delete()     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r0.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = "sdcard = "
            r0.append(r2)     // Catch:{ Exception -> 0x00b7 }
            r0.append(r5)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x00b7 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)     // Catch:{ Exception -> 0x00b7 }
            r5 = 1
            return r5
        L_0x00b1:
            java.lang.String r5 = "createNewFile failed!!"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)     // Catch:{ Exception -> 0x00b7 }
            return r1
        L_0x00b7:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)
            return r1
        L_0x00c0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "invalid path "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.t.c(java.lang.String):boolean");
    }

    public static String b(String str) {
        LogUtil.a("path = " + str);
        try {
            StatFs statFs = new StatFs(new File(str).getPath());
            if (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()) <= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
                return "removed";
            }
            if (str.contains(Environment.getExternalStorageDirectory().getAbsolutePath())) {
                LogUtil.a("Environment.getExternalStorageState = " + Environment.getExternalStorageState());
                return Environment.getExternalStorageState();
            }
            if (!str.startsWith("/data/data") && c(str)) {
            }
            return "mounted";
        } catch (Exception e) {
            LogUtil.a(e.toString());
            if (Build.VERSION.SDK_INT < 23) {
                return "removed";
            }
            return "unmounted";
        }
    }

    public static boolean e() {
        String str = f1647a;
        boolean z = str != null && str.length() > 0 && !f1647a.equals("null");
        String str2 = f1648b;
        boolean z2 = str2 != null && str2.length() > 0 && !f1648b.equals("null");
        String str3 = f1649c;
        boolean z3 = str3 != null && str3.length() > 0 && !f1649c.equals("null");
        if (z || z2 || z3) {
            return true;
        }
        return false;
    }

    public static boolean a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || file.isFile()) {
            return false;
        }
        long freeSpace = file.getFreeSpace();
        LogUtil.a("path ：" + str + " ; total : " + Formatter.formatFileSize(MyApplication.c(), freeSpace) + " ; minSize : " + Formatter.formatFileSize(MyApplication.c(), j));
        if (freeSpace - j > 0) {
            return true;
        }
        return false;
    }

    private static long f() {
        VersionBean c2 = c.a().c();
        if (c2 == null) {
            return 0;
        }
        d = c2.getIsOldPkg() == 0 ? 2.5d : 1.0d;
        double d2 = d;
        double fileSize = (double) c2.getFileSize();
        Double.isNaN(fileSize);
        return Double.valueOf(d2 * fileSize).longValue();
    }

    public static String e(Context context) {
        int c2 = d.c(context);
        String a2 = o.a(context, "update_package_path", "");
        if ((c2 == 4 || c2 == 6) && !TextUtils.isEmpty(a2)) {
            return a2;
        }
        if (Build.VERSION.SDK_INT > 27 && c.j().E()) {
            return "/data/ota_package";
        }
        return a_shaKey_method2(context, true) + "/adupsfota";
    }

    private static long f(Context context, long j) {
        try {
            StatFs statFs = new StatFs(k(context).getPath());
            long blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            File file = new File(d(context));
            if (file.exists()) {
                j -= file.length();
            }
            LogUtil.a("totalSize = " + blockSize + "; miniSize = " + j);
            if (blockSize < j) {
                return j - blockSize;
            }
            if (blockSize > j + 10) {
                return 0;
            }
            return -1;
        } catch (Exception unused) {
            LogUtil.b("card mount error");
            return -1;
        }
    }

    private static boolean g(Context context, long j) {
        return a_shaKey_method2(context.getFilesDir().getAbsolutePath(), j);
    }

    public static String a(Context context, boolean z) {
        String str;
        String str2 = f1647a;
        boolean z2 = true;
        boolean z3 = str2 != null && str2.length() > 0 && !f1647a.equals("null");
        String str3 = f1648b;
        boolean z4 = str3 != null && str3.length() > 0 && !f1648b.equals("null");
        String str4 = f1649c;
        if (str4 == null || str4.length() <= 0 || f1649c.equals("null")) {
            z2 = false;
        }
        LogUtil.a("download_path_server : " + c.a().a_shaKey_method2("download_path_server", Integer.class));
        if (z3 && "mounted".equals(b(f1647a))) {
            str = f1647a;
        } else if (z4 && "mounted".equals(b(f1648b))) {
            str = f1648b;
        } else if (!z2 || !"mounted".equals(b(f1649c))) {
            str = m(context);
        } else {
            str = f1649c;
        }
        LogUtil.a(z, "sdcard = " + str);
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fb, code lost:
        if (r6 != null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0105, code lost:
        if (r6 != null) goto L_0x00fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010b A[SYNTHETIC, Splitter:B:61:0x010b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x00e8=Splitter:B:39:0x00e8, B:52:0x00fd=Splitter:B:52:0x00fd} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x0102=Splitter:B:55:0x0102, B:49:0x00f8=Splitter:B:49:0x00f8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.adups.fota.utils.t.a> d() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            boolean r2 = android.os.Environment.isExternalStorageRemovable()
            r3 = 1
            r2 = r2 ^ r3
            java.lang.String r4 = android.os.Environment.getExternalStorageState()
            java.lang.String r5 = "mounted"
            boolean r5 = r4.equals(r5)
            java.lang.String r6 = "mounted_ro"
            r7 = 0
            if (r5 != 0) goto L_0x002b
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r4 = 0
            goto L_0x002c
        L_0x002b:
            r4 = 1
        L_0x002c:
            java.lang.String r5 = android.os.Environment.getExternalStorageState()
            boolean r5 = r5.equals(r6)
            r6 = 0
            java.util.HashSet r8 = new java.util.HashSet     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00f7 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00f7 }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00f7 }
            java.io.FileReader r10 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00f7 }
            java.lang.String r11 = "/proc/mounts"
            r10.<init>(r11)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00f7 }
            r9.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0101, IOException -> 0x00f7 }
        L_0x0046:
            java.lang.String r6 = r9.readLine()     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r10 = -1
            if (r6 == 0) goto L_0x00d8
            java.lang.String r11 = "vfat"
            boolean r11 = r6.contains(r11)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r11 != 0) goto L_0x005d
            java.lang.String r11 = "/mnt"
            boolean r11 = r6.contains(r11)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r11 == 0) goto L_0x0046
        L_0x005d:
            java.util.StringTokenizer r11 = new java.util.StringTokenizer     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            java.lang.String r12 = " "
            r11.<init>(r6, r12)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r11.nextToken()     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            java.lang.String r12 = r11.nextToken()     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            boolean r13 = r8.contains(r12)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r13 == 0) goto L_0x0072
            goto L_0x0046
        L_0x0072:
            java.lang.String r11 = r11.nextToken()     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            java.lang.String r13 = ","
            java.lang.String[] r11 = r11.split(r13)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            java.util.List r11 = java.util.Arrays.asList(r11)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            java.lang.String r13 = "ro"
            boolean r11 = r11.contains(r13)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            boolean r13 = r12.equals(r1)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r13 == 0) goto L_0x0098
            r8.add(r1)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            com.adups.fota.utils.t$a r6 = new com.adups.fota.utils.t$a     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r6.<init>(r1, r2, r11, r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r0.add(r7, r6)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            goto L_0x0046
        L_0x0098:
            java.lang.String r10 = "/dev/block/vold"
            boolean r10 = r6.contains(r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r10 == 0) goto L_0x0046
            java.lang.String r10 = "/mnt/secure"
            boolean r10 = r6.contains(r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r10 != 0) goto L_0x0046
            java.lang.String r10 = "/mnt/asec"
            boolean r10 = r6.contains(r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r10 != 0) goto L_0x0046
            java.lang.String r10 = "/mnt/obb"
            boolean r10 = r6.contains(r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r10 != 0) goto L_0x0046
            java.lang.String r10 = "/dev/mapper"
            boolean r10 = r6.contains(r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r10 != 0) goto L_0x0046
            java.lang.String r10 = "tmpfs"
            boolean r6 = r6.contains(r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r6 != 0) goto L_0x0046
            r8.add(r12)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            com.adups.fota.utils.t$a r6 = new com.adups.fota.utils.t$a     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            int r10 = r3 + 1
            r6.<init>(r12, r7, r11, r3)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r0.add(r6)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r3 = r10
            goto L_0x0046
        L_0x00d8:
            boolean r3 = r8.contains(r1)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            if (r3 != 0) goto L_0x00e8
            if (r4 == 0) goto L_0x00e8
            com.adups.fota.utils.t$a r3 = new com.adups.fota.utils.t$a     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r3.<init>(r1, r2, r5, r10)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
            r0.add(r7, r3)     // Catch:{ FileNotFoundException -> 0x00f1, IOException -> 0x00ee, all -> 0x00ec }
        L_0x00e8:
            r9.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x0108
        L_0x00ec:
            r0 = move-exception
            goto L_0x0109
        L_0x00ee:
            r1 = move-exception
            r6 = r9
            goto L_0x00f8
        L_0x00f1:
            r1 = move-exception
            r6 = r9
            goto L_0x0102
        L_0x00f4:
            r0 = move-exception
            r9 = r6
            goto L_0x0109
        L_0x00f7:
            r1 = move-exception
        L_0x00f8:
            r1.printStackTrace()     // Catch:{ all -> 0x00f4 }
            if (r6 == 0) goto L_0x0108
        L_0x00fd:
            r6.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x0108
        L_0x0101:
            r1 = move-exception
        L_0x0102:
            r1.printStackTrace()     // Catch:{ all -> 0x00f4 }
            if (r6 == 0) goto L_0x0108
            goto L_0x00fd
        L_0x0108:
            return r0
        L_0x0109:
            if (r9 == 0) goto L_0x010e
            r9.close()     // Catch:{ IOException -> 0x010e }
        L_0x010e:
            goto L_0x0110
        L_0x010f:
            throw r0
        L_0x0110:
            goto L_0x010f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.utils.t.d():java.util.List");
    }

    public static String b(Context context) {
        if (h(context) && g.b(context)) {
            String str = b(context, true) + "/Android/data/" + context.getPackageName() + "/files";
            if (a(str, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                return str;
            }
        }
        return c(context);
    }

    public static boolean c(Context context, String str) {
        String b2 = b(context, false);
        if (b2 == null || !str.startsWith(b2)) {
            return false;
        }
        return true;
    }

    public static File b() {
        try {
            File file = new File("/cache/recovery/last_error_log");
            if (file.exists()) {
                LogUtil.a("last_log exist");
                return file;
            }
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
        LogUtil.a("last_log not exist");
        return null;
    }

    public static void a() {
        File b2 = b();
        if (b2 != null) {
            b2.delete();
        }
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String b2 = b(context, true);
        String b3 = b(context, false);
        if (b2 != null && str.startsWith(b2)) {
            return b2;
        }
        if (b3 == null || !str.startsWith(b3)) {
            return "";
        }
        return b3;
    }

    public static void a(String str, String str2, String str3) {
        if (str != null && str.length() > 0 && !str.equals("null")) {
            f1647a = str;
        }
        if (str2 != null && str2.length() > 0 && !str2.equals("null")) {
            f1648b = str2;
        }
        if (str3 != null && str3.length() > 0 && !str3.equals("null")) {
            f1649c = str3;
        }
        LogUtil.a("upgradePath1 = " + f1647a + ", upgradePath2 = " + f1648b + ", upgradePath3 = " + f1649c);
    }

    public static String b(Context context, boolean z) {
        LogUtil.a("outSdcard : " + z);
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT < 24) {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                Method method2 = cls.getMethod("getPath", new Class[0]);
                Method method3 = cls.getMethod("isEmulated", new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                for (int i = 0; i < length; i++) {
                    Object obj = Array.get(invoke, i);
                    String str = (String) method2.invoke(obj, new Object[0]);
                    boolean booleanValue = ((Boolean) method3.invoke(obj, new Object[0])).booleanValue();
                    LogUtil.a("emulated = " + booleanValue + "; path = " + str);
                    if (z == (!booleanValue) && !str.startsWith("/dev/null")) {
                        return str;
                    }
                }
                return null;
            }
            for (StorageVolume next : storageManager.getStorageVolumes()) {
                boolean isEmulated = next.isEmulated();
                String obj2 = next.getClass().getMethod("getPath", new Class[0]).invoke(next, new Object[0]).toString();
                LogUtil.a("emulated = " + isEmulated + "; path = " + obj2);
                if (z == (!isEmulated) && !obj2.startsWith("/dev/null")) {
                    return obj2;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str) {
        new s(str, context).start();
    }

    public static void a(String str) {
        LogUtil.a("path = " + str);
        File file = new File(str + "/modem.bin");
        if (file.exists()) {
            LogUtil.a("delete " + file);
            file.delete();
        }
        File file2 = new File(str + "/nvitem.bin");
        if (file2.exists()) {
            LogUtil.a("delete " + file2);
            file2.delete();
        }
        File file3 = new File(str + "/dsp.bin");
        if (file3.exists()) {
            LogUtil.a("delete " + file3);
            file3.delete();
        }
        File file4 = new File(str + "/vmjaluna.bin");
        if (file4.exists()) {
            LogUtil.a("delete " + file4);
            file4.delete();
        }
    }

    public static String d(Context context) {
        String str = e(context) + "/update.zip";
        LogUtil.a("filename = " + str);
        return str;
    }

    /* access modifiers changed from: private */
    public static boolean b(File file) {
        String[] list;
        LogUtil.a("destfile = " + file);
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String file2 : list) {
                if (!b(new File(file, file2))) {
                    LogUtil.a("deleteErrFileExt err");
                    return false;
                }
            }
        }
        return file.delete();
    }
}
