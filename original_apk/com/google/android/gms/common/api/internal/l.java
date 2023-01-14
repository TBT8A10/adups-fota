package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.C0152a;

final class l implements C0152a.C0034a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0153b f1764a;

    l(C0153b bVar) {
        this.f1764a = bVar;
    }

    public final void a(boolean z) {
        this.f1764a.q.sendMessage(this.f1764a.q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
