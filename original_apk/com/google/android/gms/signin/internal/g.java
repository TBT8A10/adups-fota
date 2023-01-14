package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.base.a;
import com.google.android.gms.internal.base.c;

public final class g extends a implements f {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void a(zah zah, d dVar) throws RemoteException {
        Parcel d = d();
        c.a_shaKey_method2(d, (Parcelable) zah);
        c.a_shaKey_method2(d, (IInterface) dVar);
        b(12, d);
    }
}
