package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import b.a.a.a.d.i;

/* renamed from: com.google.firebase.iid.j  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
abstract class C0188j<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f2416a;

    /* renamed from: b  reason: collision with root package name */
    final i<T> f2417b = new i<>();

    /* renamed from: c  reason: collision with root package name */
    final int f2418c;
    final Bundle d;

    C0188j(int i, int i2, Bundle bundle) {
        this.f2416a = i;
        this.f2418c = i2;
        this.d = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public final void a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f2417b.a(t);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a();

    public String toString() {
        int i = this.f2418c;
        int i2 = this.f2416a;
        boolean a2 = a();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(a2);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void a(C0187i iVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(iVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f2417b.a((Exception) iVar);
    }
}
