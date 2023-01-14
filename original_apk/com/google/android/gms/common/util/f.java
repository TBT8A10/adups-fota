package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f1955a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f1956b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f1957c;

    @TargetApi(21)
    public static boolean a(Context context) {
        if (f1956b == null) {
            f1956b = Boolean.valueOf(j.f() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f1956b.booleanValue();
    }

    @TargetApi(20)
    public static boolean b(Context context) {
        if (f1955a == null) {
            f1955a = Boolean.valueOf(j.e() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f1955a.booleanValue();
    }

    @TargetApi(26)
    public static boolean c(Context context) {
        if (!b(context)) {
            return false;
        }
        if (j.g()) {
            return a(context) && !j.h();
        }
        return true;
    }

    public static boolean d(Context context) {
        if (f1957c == null) {
            f1957c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f1957c.booleanValue();
    }
}
