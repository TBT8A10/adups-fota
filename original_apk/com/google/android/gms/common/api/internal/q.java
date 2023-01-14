package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.C0153b;
import com.google.android.gms.common.internal.C0171l;
import java.util.Collections;

final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f1769a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0153b.c f1770b;

    q(C0153b.c cVar, ConnectionResult connectionResult) {
        this.f1770b = cVar;
        this.f1769a = connectionResult;
    }

    public final void run() {
        if (this.f1769a.q()) {
            boolean unused = this.f1770b.e = true;
            if (this.f1770b.f1754a.d()) {
                this.f1770b.a();
                return;
            }
            try {
                this.f1770b.f1754a.a_shaKey_method2((C0171l) null, Collections.emptySet());
            } catch (SecurityException e) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                ((C0153b.a) C0153b.this.m.get(this.f1770b.f1755b)).a(new ConnectionResult(10));
            }
        } else {
            ((C0153b.a) C0153b.this.m.get(this.f1770b.f1755b)).a(this.f1769a);
        }
    }
}
