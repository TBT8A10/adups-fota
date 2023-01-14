package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import b.a.a.a.b.b.a;
import b.a.a.a.b.b.f;
import b.a.a.a.d.h;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private static aa f2399a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f2400b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledExecutorService f2401c;
    private ba d = new ba(this);
    private int e = 1;

    private aa(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f2401c = scheduledExecutorService;
        this.f2400b = context.getApplicationContext();
    }

    public static synchronized aa a(Context context) {
        aa aaVar;
        synchronized (aa.class) {
            if (f2399a == null) {
                f2399a = new aa(context, a.a().a(1, new com.google.android.gms.common.util.a.a("MessengerIpcClient"), f.f1393a));
            }
            aaVar = f2399a;
        }
        return aaVar;
    }

    public final h<Bundle> b(int i, Bundle bundle) {
        return a(new C0190l(a(), 1, bundle));
    }

    public final h<Void> a(int i, Bundle bundle) {
        return a(new C0185g(a(), 2, bundle));
    }

    private final synchronized <T> h<T> a(C0188j<T> jVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(jVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.d.a((C0188j<?>) jVar)) {
            this.d = new ba(this);
            this.d.a((C0188j<?>) jVar);
        }
        return jVar.f2417b.a();
    }

    private final synchronized int a() {
        int i;
        i = this.e;
        this.e = i + 1;
        return i;
    }
}
