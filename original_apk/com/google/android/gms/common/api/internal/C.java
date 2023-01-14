package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import b.a.a.a.d.i;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0153b;

public final class C extends B<Boolean> {

    /* renamed from: c  reason: collision with root package name */
    private final C0156e<?> f1736c;

    public C(C0156e<?> eVar, i<Boolean> iVar) {
        super(4, iVar);
        this.f1736c = eVar;
    }

    public final /* bridge */ /* synthetic */ void a(C0159h hVar, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void a(RuntimeException runtimeException) {
        super.a(runtimeException);
    }

    public final Feature[] b(C0153b.a<?> aVar) {
        t tVar = aVar.i().get(this.f1736c);
        if (tVar == null) {
            return null;
        }
        return tVar.f1774a.b();
    }

    public final boolean c(C0153b.a<?> aVar) {
        t tVar = aVar.i().get(this.f1736c);
        return tVar != null && tVar.f1774a.c();
    }

    public final void d(C0153b.a<?> aVar) throws RemoteException {
        t remove = aVar.i().remove(this.f1736c);
        if (remove != null) {
            remove.f1775b.a_shaKey_method2(aVar.f(), this.f1731b);
            remove.f1774a.a();
            return;
        }
        this.f1731b.b(false);
    }

    public final /* bridge */ /* synthetic */ void a(Status status) {
        super.a(status);
    }
}
