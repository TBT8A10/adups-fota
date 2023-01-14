package com.google.firebase.iid;

import b.a.a.a.d.g;
import b.a.a.a.d.h;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class M implements g {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId f2379a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2380b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2381c;
    private final String d;

    M(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f2379a = firebaseInstanceId;
        this.f2380b = str;
        this.f2381c = str2;
        this.d = str3;
    }

    public final h a(Object obj) {
        return this.f2379a.a(this.f2380b, this.f2381c, this.d, (String) obj);
    }
}
