package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.converter.StringToIntConverter;

public final class c implements Parcelable.Creator<StringToIntConverter.zaa> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                str = a.n(parcel, a2);
            } else if (a3 != 3) {
                a.z(parcel, a2);
            } else {
                i2 = a.v(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new StringToIntConverter.zaa(i, str, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StringToIntConverter.zaa[i];
    }
}
