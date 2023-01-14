package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<zaa> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            int a3 = com.google.android.gms.common.internal.safeparcel.a.a(a2);
            if (a3 == 1) {
                i = com.google.android.gms.common.internal.safeparcel.a.v(parcel, a2);
            } else if (a3 != 2) {
                com.google.android.gms.common.internal.safeparcel.a.z(parcel, a2);
            } else {
                stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2, StringToIntConverter.CREATOR);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, b2);
        return new zaa(i, stringToIntConverter);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zaa[i];
    }
}
