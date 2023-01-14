package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<StringToIntConverter> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        ArrayList<StringToIntConverter.zaa> arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 != 2) {
                a.z(parcel, a2);
            } else {
                arrayList = a.c(parcel, a2, StringToIntConverter.zaa.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new StringToIntConverter(i, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StringToIntConverter[i];
    }
}
