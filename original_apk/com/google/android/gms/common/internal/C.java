package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import b.a.a.a.a.a;
import com.google.android.gms.internal.base.a;
import com.google.android.gms.internal.base.c;

public final class C extends a implements C0176q {
    C(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final b.a.a.a.a.a a(b.a.a.a.a.a aVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel d = d();
        c.a_shaKey_method2(d, (IInterface) aVar);
        c.a_shaKey_method2(d, (Parcelable) signInButtonConfig);
        Parcel a2 = a_shaKey_method2(2, d);
        b.a.a.a.a.a a3 = a.C0025a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
