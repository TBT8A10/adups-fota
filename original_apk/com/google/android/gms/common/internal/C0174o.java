package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.common.internal.o  reason: case insensitive filesystem */
final class C0174o implements C0175p {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1891a;

    C0174o(IBinder iBinder) {
        this.f1891a = iBinder;
    }

    public final void a(C0173n nVar, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                getServiceRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f1891a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f1891a;
    }
}
