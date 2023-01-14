package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ v f1779a;

    w(v vVar) {
        this.f1779a = vVar;
    }

    public final void run() {
        this.f1779a.h.b(new ConnectionResult(4));
    }
}
