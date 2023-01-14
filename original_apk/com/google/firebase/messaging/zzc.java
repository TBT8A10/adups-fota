package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import b.a.a.a.b.b.a;
import b.a.a.a.b.b.b;
import b.a.a.a.b.b.f;
import b.a.a.a.d.C0150c;
import b.a.a.a.d.h;
import b.a.a.a.d.i;
import b.a.a.a.d.k;
import com.google.firebase.iid.B;
import com.google.firebase.iid.C0202y;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
public abstract class zzc extends Service {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f2477a;

    /* renamed from: b  reason: collision with root package name */
    private Binder f2478b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f2479c;
    private int d;
    private int e;

    public zzc() {
        b a2 = a.a();
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.f2477a = a2.a_shaKey_method2(new com.google.android.gms.common.util.a.a(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")), f.f1393a);
        this.f2479c = new Object();
        this.e = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final h<Void> d(Intent intent) {
        if (b(intent)) {
            return k.a(null);
        }
        i iVar = new i();
        this.f2477a.execute(new g(this, intent, iVar));
        return iVar.a();
    }

    private final void f(Intent intent) {
        if (intent != null) {
            C0202y.a(intent);
        }
        synchronized (this.f2479c) {
            this.e--;
            if (this.e == 0) {
                stopSelfResult(this.d);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Intent a(Intent intent) {
        return intent;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Intent intent, h hVar) {
        f(intent);
    }

    public boolean b(Intent intent) {
        return false;
    }

    public abstract void c(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f2478b == null) {
            this.f2478b = new B(new h(this));
        }
        return this.f2478b;
    }

    public void onDestroy() {
        this.f2477a.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f2479c) {
            this.d = i2;
            this.e++;
        }
        Intent a2 = a(intent);
        if (a2 == null) {
            f(intent);
            return 2;
        }
        h<Void> e2 = d(a2);
        if (e2.d()) {
            f(intent);
            return 2;
        }
        e2.a(j.f2471a, (C0150c<Void>) new i(this, intent));
        return 3;
    }
}
