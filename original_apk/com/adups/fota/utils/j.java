package com.adups.fota.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

/* compiled from: MidUtil */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1631a = String.valueOf(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'w', 'w', 'w', '.', 'b', 'a', 'i', 'd', 'u', '.', 'c', 'o', 'm'});

    /* renamed from: b  reason: collision with root package name */
    public static final String f1632b = String.valueOf(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'w', 'w', 'w', '.', 'g', 'o', 'o', 'g', 'l', 'e', '.', 'c', 'o', 'm'});

    /* renamed from: c  reason: collision with root package name */
    public static final String f1633c = String.valueOf(new char[]{'h', 't', 't', 'p', 's', ':', '/', '/', 'w', 'w', 'w', '.', 'a', 'd', 'u', 'p', 's', '.', 'c', 'o', 'm'});
    public static int d = 0;

    public static void a(Context context, String str) {
        LogUtil.a("writeMID, mid = " + str);
        if (g.b(context)) {
            a(t.c() + ".srcMid", str);
        }
        a_shaKey_method2(t.c(context) + ".srcMid", str);
    }

    public static String b(Context context) {
        String a2;
        synchronized (j.class) {
            a2 = o.a(context, "mid", "");
            String f = f(context);
            LogUtil.a("getSyncMid, mid = " + a2 + " sd_mid = " + f);
            if (!TextUtils.isEmpty(a2)) {
                if (!"0".equals(a2)) {
                    if (!a2.equals(f)) {
                        b(context, a2);
                    }
                }
            }
            if (!TextUtils.isEmpty(f)) {
                if (!"0".equals(f)) {
                    a2 = f;
                    o.b(context, "mid", a2);
                }
            }
            a2 = "";
            o.b(context, "mid", a2);
        }
        return a2;
    }

    private static String c(String str) {
        String str2 = "";
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setReadTimeout(15000);
            openConnection.setConnectTimeout(15000);
            openConnection.setDoInput(true);
            openConnection.setDoInput(true);
            openConnection.connect();
            str2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date(openConnection.getDate()));
            LogUtil.a("getSyncNetworkTime date = " + str2);
            return str2;
        } catch (Exception e) {
            LogUtil.a("getSyncNetworkTime e = " + e.toString());
            return str2;
        }
    }

    public static void d(Context context) {
        if (d == 1) {
            File file = null;
            if (g.a(context)) {
                file = new File(t.c() + ".srcMid");
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            File file2 = new File(t.c(context) + ".srcMid");
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    private static boolean e(Context context) {
        String str;
        int a2 = o.a(context, "sync_time_fail_count", 0);
        String str2 = "";
        if (((long) a2) < 5) {
            str = a(new String[]{f1631a, f1632b, f1633c});
            if (TextUtils.isEmpty(str) || a(str)) {
                o.b(context, "sync_time_fail_count", a2 + 1);
                return false;
            }
        } else {
            str = str2;
        }
        if (str.isEmpty()) {
            str = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        }
        if (!str.isEmpty()) {
            str2 = b(str);
        }
        if (!str2.isEmpty()) {
            b(context, str2);
            o.b(context, "mid", str2);
            o.b(context, "sync_time_fail_count", 0);
            d = 1;
            return true;
        }
        d = 0;
        return false;
    }

    private static String f(Context context) {
        return g(context);
    }

    private static String g(Context context) {
        File file;
        if (g.a(context)) {
            file = new File(t.c() + ".srcMid");
        } else {
            file = null;
        }
        if (file != null && file.exists()) {
            return a(file);
        }
        File file2 = new File(t.c(context) + ".srcMid");
        return file2.exists() ? a(file2) : "";
    }

    private static void a(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String a(File file) {
        String str;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str = new String(bArr, StandardCharsets.UTF_8);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
            LogUtil.a("readMID, Exception:" + e);
            e.printStackTrace();
            return str;
        }
        return str;
    }

    private static void b(Context context, String str) {
        a_shaKey_method2(context, str);
    }

    public static boolean c(Context context) {
        String a2 = o.a(context, "mid", "");
        String f = f(context);
        d = 0;
        if (!TextUtils.isEmpty(a2) || !TextUtils.isEmpty(f)) {
            return true;
        }
        d = 1;
        return false;
    }

    private static String b(String str) {
        Random random = new Random();
        String str2 = "" + (random.nextInt(9000) + TarArchiveEntry.MILLIS_PER_SECOND);
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        String str3 = "";
        for (int i = 0; i < 2; i++) {
            str3 = str3 + charArray[random.nextInt(charArray.length)] + "";
        }
        String str4 = str + str3 + str2;
        LogUtil.a("generateMidByDate, mid = " + str4);
        return str4;
    }

    private static String a(String[] strArr) {
        String str = "";
        for (String c2 : strArr) {
            str = c(c2);
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    public static boolean a(String str) {
        if (str.length() >= 4 && Pattern.compile("^\\d{4}$").matcher(str.substring(0, 4)).matches() && Integer.parseInt(str.substring(0, 4)) - 2016 >= 0) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context) {
        return c(context) || e(context);
    }
}
