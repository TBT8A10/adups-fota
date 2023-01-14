package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import b.a.a.a.a.a;
import b.a.a.a.b.a.a;

public final class P extends a implements N {
    P(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final b.a.a.a.a.a b() throws RemoteException {
        Parcel a2 = a_shaKey_method2(1, d());
        b.a.a.a.a.a a3 = a.C0025a.a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final int c() throws RemoteException {
        Parcel a2 = a_shaKey_method2(2, d());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }
}
