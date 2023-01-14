package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.a.a.a.b.a.b;
import b.a.a.a.b.a.c;

/* renamed from: com.google.android.gms.common.internal.n  reason: case insensitive filesystem */
public interface C0173n extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.n$a */
    public static abstract class a extends b implements C0173n {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        /* access modifiers changed from: protected */
        public final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a_shaKey_method2(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                a_shaKey_method2(parcel.readInt(), (Bundle) c.a_shaKey_method2(parcel, Bundle.CREATOR));
            } else if (i != 3) {
                return false;
            } else {
                a(parcel.readInt(), parcel.readStrongBinder(), (zzb) c.a_shaKey_method2(parcel, zzb.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, Bundle bundle) throws RemoteException;

    void a(int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(int i, IBinder iBinder, zzb zzb) throws RemoteException;
}
