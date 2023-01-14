package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0153b;
import com.google.android.gms.common.util.j;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    private final int f1763a;

    public k(int i) {
        this.f1763a = i;
    }

    /* access modifiers changed from: private */
    public static Status b(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (j.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void a(Status status);

    public abstract void a(C0153b.a<?> aVar) throws DeadObjectException;

    public abstract void a(C0159h hVar, boolean z);

    public abstract void a(RuntimeException runtimeException);
}
