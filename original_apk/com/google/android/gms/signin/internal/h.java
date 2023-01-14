package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;

public final class h implements Parcelable.Creator<zah> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 != 2) {
                a.z(parcel, a2);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) a.a(parcel, a2, ResolveAccountRequest.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new zah(i, resolveAccountRequest);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zah[i];
    }
}
