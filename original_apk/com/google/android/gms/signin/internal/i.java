package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.a;

public final class i implements Parcelable.Creator<zaj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                connectionResult = (ConnectionResult) a.a(parcel, a2, ConnectionResult.CREATOR);
            } else if (a3 != 3) {
                a.z(parcel, a2);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) a.a(parcel, a2, ResolveAccountResponse.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new zaj(i, connectionResult, resolveAccountResponse);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zaj[i];
    }
}
