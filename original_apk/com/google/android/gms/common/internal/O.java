package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.a.a.a.a.a;
import b.a.a.a.b.a.b;
import b.a.a.a.b.a.c;

public abstract class O extends b implements N {
    public O() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static N a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof N) {
            return (N) queryLocalInterface;
        }
        return new P(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            a b2 = b();
            parcel2.writeNoException();
            c.a_shaKey_method2(parcel2, (IInterface) b2);
        } else if (i != 2) {
            return false;
        } else {
            int c2 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c2);
        }
        return true;
    }
}
