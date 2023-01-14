package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;

public final class D implements Parcelable.Creator<ResolveAccountRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        Account account = null;
        int i = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                account = (Account) a.a(parcel, a2, Account.CREATOR);
            } else if (a3 == 3) {
                i2 = a.v(parcel, a2);
            } else if (a3 != 4) {
                a.z(parcel, a2);
            } else {
                googleSignInAccount = (GoogleSignInAccount) a.a(parcel, a2, GoogleSignInAccount.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
