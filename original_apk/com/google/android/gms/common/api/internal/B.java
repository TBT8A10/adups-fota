package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import b.a.a.a.d.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.internal.C0153b;

abstract class B<T> extends u {

    /* renamed from: b  reason: collision with root package name */
    protected final i<T> f1731b;

    public B(int i, i<T> iVar) {
        super(i);
        this.f1731b = iVar;
    }

    public void a(Status status) {
        this.f1731b.b((Exception) new b(status));
    }

    /* access modifiers changed from: protected */
    public abstract void d(C0153b.a<?> aVar) throws RemoteException;

    public void a(RuntimeException runtimeException) {
        this.f1731b.b((Exception) runtimeException);
    }

    public final void a(C0153b.a<?> aVar) throws DeadObjectException {
        try {
            d(aVar);
        } catch (DeadObjectException e) {
            a(k.b(e));
            throw e;
        } catch (RemoteException e2) {
            a(k.b(e2));
        } catch (RuntimeException e3) {
            a(e3);
        }
    }
}
