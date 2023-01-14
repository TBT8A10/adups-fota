package com.google.android.gms.common.api.internal;

import a.b.b;
import b.a.a.a.d.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c;
import java.util.Map;
import java.util.Set;

public final class E {

    /* renamed from: a  reason: collision with root package name */
    private final b<D<?>, ConnectionResult> f1740a;

    /* renamed from: b  reason: collision with root package name */
    private final b<D<?>, String> f1741b;

    /* renamed from: c  reason: collision with root package name */
    private final i<Map<D<?>, String>> f1742c;
    private int d;
    private boolean e;

    public final Set<D<?>> a() {
        return this.f1740a.keySet();
    }

    public final void a(D<?> d2, ConnectionResult connectionResult, String str) {
        this.f1740a.put(d2, connectionResult);
        this.f1741b.put(d2, str);
        this.d--;
        if (!connectionResult.q()) {
            this.e = true;
        }
        if (this.d != 0) {
            return;
        }
        if (this.e) {
            this.f1742c.a((Exception) new c(this.f1740a));
            return;
        }
        this.f1742c.a(this.f1741b);
    }
}
