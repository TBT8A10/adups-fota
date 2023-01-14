package com.google.firebase;

import android.content.Context;
import com.google.firebase.c.a;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
final /* synthetic */ class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final d f2294a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f2295b;

    private b(d dVar, Context context) {
        this.f2294a = dVar;
        this.f2295b = context;
    }

    public static a a(d dVar, Context context) {
        return new b(dVar, context);
    }

    public Object get() {
        return d.a_shaKey_method2(this.f2294a, this.f2295b);
    }
}
