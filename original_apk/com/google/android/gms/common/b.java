package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.L;
import com.google.android.gms.common.util.f;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1789a = d.f1794a;

    /* renamed from: b  reason: collision with root package name */
    private static final b f1790b = new b();

    b() {
    }

    public int a(Context context) {
        return a_shaKey_method2(context, f1789a);
    }

    public boolean b(int i) {
        return d.b(i);
    }

    public int a(Context context, int i) {
        int a2 = d.a_shaKey_method2(context, i);
        if (d.b(context, a2)) {
            return 18;
        }
        return a2;
    }

    public Intent a(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            if (context == null || !f.c(context)) {
                return L.a_shaKey_method2("com.google.android.gms", a_shaKey_method2(context, str));
            }
            return L.a();
        } else if (i != 3) {
            return null;
        } else {
            return L.a("com.google.android.gms");
        }
    }

    public PendingIntent a(Context context, int i, int i2) {
        return a(context, i, i2, (String) null);
    }

    public PendingIntent a(Context context, int i, int i2, String str) {
        Intent a2 = a(context, i, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a2, 134217728);
    }

    public String a(int i) {
        return d.a(i);
    }

    private static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f1789a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(com.google.android.gms.common.b.b.a(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }
}
