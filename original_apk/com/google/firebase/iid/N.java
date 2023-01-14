package com.google.firebase.iid;

import b.a.a.a.d.h;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class N implements r {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f2382a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2383b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2384c;
    private final String d;

    N(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f2382a = firebaseInstanceId;
        this.f2383b = str;
        this.f2384c = str2;
        this.d = str3;
    }

    public final h a() {
        return this.f2382a.a(this.f2383b, this.f2384c, this.d);
    }
}
