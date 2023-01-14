package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<FavaDiagnosticsEntity> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            int a3 = com.google.android.gms.common.internal.safeparcel.a.a(a2);
            if (a3 == 1) {
                i = com.google.android.gms.common.internal.safeparcel.a.v(parcel, a2);
            } else if (a3 == 2) {
                str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, a2);
            } else if (a3 != 3) {
                com.google.android.gms.common.internal.safeparcel.a.z(parcel, a2);
            } else {
                i2 = com.google.android.gms.common.internal.safeparcel.a.v(parcel, a2);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, b2);
        return new FavaDiagnosticsEntity(i, str, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new FavaDiagnosticsEntity[i];
    }
}
