package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<SafeParcelResponse> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        Parcel parcel2 = null;
        int i = 0;
        zak zak = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                parcel2 = a.l(parcel, a2);
            } else if (a3 != 3) {
                a.z(parcel, a2);
            } else {
                zak = (zak) a.a(parcel, a2, zak.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new SafeParcelResponse(i, parcel2, zak);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
