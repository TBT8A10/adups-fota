package com.google.firebase.components;

import com.google.firebase.c.a;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
final /* synthetic */ class k implements a {

    /* renamed from: a  reason: collision with root package name */
    private final n f2308a;

    /* renamed from: b  reason: collision with root package name */
    private final e f2309b;

    private k(n nVar, e eVar) {
        this.f2308a = nVar;
        this.f2309b = eVar;
    }

    public static a a(n nVar, e eVar) {
        return new k(nVar, eVar);
    }

    public Object get() {
        return this.f2309b.b().a(new x(this.f2309b, this.f2308a));
    }
}
