package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.b;
import com.google.android.gms.internal.base.c;

public abstract class e extends b implements d {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 3) {
            a((ConnectionResult) c.a_shaKey_method2(parcel, ConnectionResult.CREATOR), (zaa) c.a_shaKey_method2(parcel, zaa.CREATOR));
        } else if (i == 4) {
            a((Status) c.a_shaKey_method2(parcel, Status.CREATOR));
        } else if (i == 6) {
            b((Status) c.a_shaKey_method2(parcel, Status.CREATOR));
        } else if (i == 7) {
            a((Status) c.a_shaKey_method2(parcel, Status.CREATOR), (GoogleSignInAccount) c.a_shaKey_method2(parcel, GoogleSignInAccount.CREATOR));
        } else if (i != 8) {
            return false;
        } else {
            a((zaj) c.a_shaKey_method2(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
