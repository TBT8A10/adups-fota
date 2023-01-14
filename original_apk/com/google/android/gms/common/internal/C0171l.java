package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.a.a.a.b.a.b;
import b.a.a.a.b.a.c;

/* renamed from: com.google.android.gms.common.internal.l  reason: case insensitive filesystem */
public interface C0171l extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.l$a */
    public static abstract class a extends b implements C0171l {

        /* renamed from: com.google.android.gms.common.internal.l$a$a  reason: collision with other inner class name */
        public static class C0037a extends b.a.a.a.b.a.a implements C0171l {
            C0037a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            public final Account a() throws RemoteException {
                Parcel a2 = a_shaKey_method2(2, d());
                Account account = (Account) c.a_shaKey_method2(a2, Account.CREATOR);
                a2.recycle();
                return account;
            }
        }

        public static C0171l a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof C0171l) {
                return (C0171l) queryLocalInterface;
            }
            return new C0037a(iBinder);
        }
    }

    Account a() throws RemoteException;
}
