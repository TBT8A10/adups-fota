package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import b.a.a.a.b.b.e;

/* renamed from: com.google.firebase.iid.t  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0197t extends e {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0195q f2434a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0197t(C0195q qVar, Looper looper) {
        super(looper);
        this.f2434a = qVar;
    }

    public final void handleMessage(Message message) {
        this.f2434a.a(message);
    }
}
