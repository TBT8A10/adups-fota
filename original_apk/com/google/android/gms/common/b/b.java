package com.google.android.gms.common.b;

import android.content.Context;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f1792a = new b();

    /* renamed from: b  reason: collision with root package name */
    private a f1793b = null;

    public static a a(Context context) {
        return f1792a.b(context);
    }

    private final synchronized a b(Context context) {
        if (this.f1793b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f1793b = new a(context);
        }
        return this.f1793b;
    }
}
