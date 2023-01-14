package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import b.a.a.a.b.a.d;
import com.google.android.gms.common.internal.C0168i;
import com.google.android.gms.common.stats.a;
import java.util.HashMap;

final class J extends C0168i implements Handler.Callback {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<C0168i.a, K> f1841c = new HashMap<>();
    /* access modifiers changed from: private */
    public final Context d;
    /* access modifiers changed from: private */
    public final Handler e;
    /* access modifiers changed from: private */
    public final a f;
    private final long g;
    /* access modifiers changed from: private */
    public final long h;

    J(Context context) {
        this.d = context.getApplicationContext();
        this.e = new d(context.getMainLooper(), this);
        this.f = a.a();
        this.g = 5000;
        this.h = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean a(C0168i.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        C0178t.a_shaKey_method2(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f1841c) {
            K k = this.f1841c.get(aVar);
            if (k == null) {
                k = new K(this, aVar);
                k.a_shaKey_method2(serviceConnection, str);
                k.a(str);
                this.f1841c.put(aVar, k);
            } else {
                this.e.removeMessages(0, aVar);
                if (!k.a(serviceConnection)) {
                    k.a_shaKey_method2(serviceConnection, str);
                    int c2 = k.c();
                    if (c2 == 1) {
                        serviceConnection.onServiceConnected(k.b(), k.a());
                    } else if (c2 == 2) {
                        k.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = k.d();
        }
        return d2;
    }

    /* access modifiers changed from: protected */
    public final void b(C0168i.a aVar, ServiceConnection serviceConnection, String str) {
        C0178t.a_shaKey_method2(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f1841c) {
            K k = this.f1841c.get(aVar);
            if (k == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (k.a(serviceConnection)) {
                k.b(serviceConnection, str);
                if (k.e()) {
                    this.e.sendMessageDelayed(this.e.obtainMessage(0, aVar), this.g);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f1841c) {
                C0168i.a aVar = (C0168i.a) message.obj;
                K k = this.f1841c.get(aVar);
                if (k != null && k.e()) {
                    if (k.d()) {
                        k.b("GmsClientSupervisor");
                    }
                    this.f1841c.remove(aVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f1841c) {
                C0168i.a aVar2 = (C0168i.a) message.obj;
                K k2 = this.f1841c.get(aVar2);
                if (k2 != null && k2.c() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b2 = k2.b();
                    if (b2 == null) {
                        b2 = aVar2.a();
                    }
                    if (b2 == null) {
                        b2 = new ComponentName(aVar2.b(), "unknown");
                    }
                    k2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
