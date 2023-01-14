package com.adups.fota.utils;

import android.util.Log;
import com.adups.fota.MyApplication;

public class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1615a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1616b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f1617c = "";

    public static void a(String str) {
        e(str);
        a("FotaUpdate", str, (Throwable) null, 'd');
    }

    public static void b(String str) {
        e(str);
        a("FotaUpdate", str, (Throwable) null);
    }

    public static void c(String str) {
        f1617c = str;
    }

    private static String d(String str) {
        e(str);
        String b2 = b();
        if (b2 == null) {
            return str;
        }
        return b2 + " -> " + str;
    }

    private static String e(String str) {
        return str;
    }

    public static void a(boolean z, String str) {
        e(str);
        if (z) {
            a("FotaUpdate", d(str), (Throwable) null, 'd');
        }
        if (f1616b) {
            String str2 = f1617c;
            g.b(str2, "FotaUpdate: " + d(str));
        }
    }

    private static String b() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getFileName().equals("LogUtil.java")) {
                return "[" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "] " + stackTraceElement.getMethodName();
            }
        }
        return null;
    }

    public static void a(String str, String str2, Throwable th) {
        e(str2);
        a(str, str2, th, 'e');
    }

    private static void a(String str, String str2, Throwable th, char c2) {
        e(str2);
        if (f1616b || f1615a || g.c(MyApplication.c())) {
            if ('e' == c2) {
                Log.e(str, d(str2), th);
            } else if ('w' == c2) {
                Log.w(str, d(str2), th);
            } else if ('d' == c2) {
                Log.d(str, d(str2), th);
            } else if ('i' == c2) {
                Log.i(str, d(str2), th);
            } else {
                Log.v(str, d(str2), th);
            }
            if (f1616b) {
                String str3 = f1617c;
                g.b(str3, str + ": " + d(str2));
            }
        }
    }

    public static void b(boolean z) {
        f1616b = z;
    }

    public static boolean a() {
        return f1616b;
    }

    public static void a(boolean z) {
        f1615a = z;
    }
}
