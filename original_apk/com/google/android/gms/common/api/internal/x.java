package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zaj;

final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zaj f1780a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ v f1781b;

    x(v vVar, zaj zaj) {
        this.f1781b = vVar;
        this.f1780a = zaj;
    }

    public final void run() {
        this.f1781b.b(this.f1780a);
    }
}
