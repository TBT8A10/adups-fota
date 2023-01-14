package com.google.firebase.iid;

import android.os.Bundle;
import b.a.a.a.d.i;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class S implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final P f2390a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f2391b;

    /* renamed from: c  reason: collision with root package name */
    private final i f2392c;

    S(P p, Bundle bundle, i iVar) {
        this.f2390a = p;
        this.f2391b = bundle;
        this.f2392c = iVar;
    }

    public final void run() {
        this.f2390a.a_shaKey_method2(this.f2391b, this.f2392c);
    }
}
