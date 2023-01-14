package com.google.firebase.iid;

import b.a.a.a.d.C0148a;
import b.a.a.a.d.h;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class K implements C0148a {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f2375a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2376b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2377c;

    K(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.f2375a = firebaseInstanceId;
        this.f2376b = str;
        this.f2377c = str2;
    }

    public final Object a(h hVar) {
        return this.f2375a.a(this.f2376b, this.f2377c, hVar);
    }
}
