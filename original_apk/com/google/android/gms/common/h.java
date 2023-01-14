package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class h implements Parcelable.Creator<Feature> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                str = a.n(parcel, a2);
            } else if (a3 == 2) {
                i = a.v(parcel, a2);
            } else if (a3 != 3) {
                a.z(parcel, a2);
            } else {
                j = a.x(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new Feature(str, i, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Feature[i];
    }
}
