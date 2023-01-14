package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C0168i;
import com.google.android.gms.common.stats.a;
import java.util.HashSet;
import java.util.Set;

final class K implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ServiceConnection> f1842a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private int f1843b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1844c;
    private IBinder d;
    private final C0168i.a e;
    private ComponentName f;
    private final /* synthetic */ J g;

    public K(J j, C0168i.a aVar) {
        this.g = j;
        this.e = aVar;
    }

    public final void a(String str) {
        this.f1843b = 3;
        this.f1844c = this.g.f.a(this.g.d, str, this.e.a(this.g.d), this, this.e.c());
        if (this.f1844c) {
            this.g.e.sendMessageDelayed(this.g.e.obtainMessage(1, this.e), this.g.h);
            return;
        }
        this.f1843b = 2;
        try {
            this.g.f.a_shaKey_method2(this.g.d, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void b(String str) {
        this.g.e.removeMessages(1, this.e);
        this.g.f.a_shaKey_method2(this.g.d, this);
        this.f1844c = false;
        this.f1843b = 2;
    }

    public final int c() {
        return this.f1843b;
    }

    public final boolean d() {
        return this.f1844c;
    }

    public final boolean e() {
        return this.f1842a.isEmpty();
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f1841c) {
            this.g.e.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            for (ServiceConnection onServiceConnected : this.f1842a) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f1843b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f1841c) {
            this.g.e.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            for (ServiceConnection onServiceDisconnected : this.f1842a) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f1843b = 2;
        }
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        a unused = this.g.f;
        Context unused2 = this.g.d;
        this.f1842a.remove(serviceConnection);
    }

    public final ComponentName b() {
        return this.f;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        a unused = this.g.f;
        Context unused2 = this.g.d;
        this.e.a(this.g.d);
        this.f1842a.add(serviceConnection);
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f1842a.contains(serviceConnection);
    }

    public final IBinder a() {
        return this.d;
    }
}
