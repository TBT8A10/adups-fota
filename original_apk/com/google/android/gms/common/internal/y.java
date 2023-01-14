package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class y implements Parcelable.Creator<ClientIdentity> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 != 2) {
                a.z(parcel, a2);
            } else {
                str = a.n(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new ClientIdentity(i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ClientIdentity[i];
    }
}
