package com.google.android.gms.common.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.common.internal.j  reason: case insensitive filesystem */
public final class C0169j {

    /* renamed from: a  reason: collision with root package name */
    private final String f1887a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1888b;

    public C0169j(String str, String str2) {
        C0178t.a(str, (Object) "log tag cannot be null");
        C0178t.a(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f1887a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f1888b = null;
        } else {
            this.f1888b = str2;
        }
    }

    public final boolean a(int i) {
        return Log.isLoggable(this.f1887a, i);
    }

    public final void b(String str, String str2) {
        if (a(6)) {
            Log.e(str, a(str2));
        }
    }

    public final void c(String str, String str2) {
        if (a(2)) {
            Log.v(str, a(str2));
        }
    }

    public final void a(String str, String str2) {
        if (a(3)) {
            Log.d(str, a(str2));
        }
    }

    public final void a(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, a(str2), th);
        }
    }

    private final String a(String str) {
        String str2 = this.f1888b;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }
}
