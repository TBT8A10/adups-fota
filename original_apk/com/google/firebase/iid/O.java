package com.google.firebase.iid;

import com.google.firebase.b.a;
import com.google.firebase.b.b;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class O implements b {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstanceId.a f2385a;

    O(FirebaseInstanceId.a aVar) {
        this.f2385a = aVar;
    }

    public final void a(a aVar) {
        FirebaseInstanceId.a aVar2 = this.f2385a;
        synchronized (aVar2) {
            if (aVar2.a()) {
                FirebaseInstanceId.this.k();
            }
        }
    }
}
