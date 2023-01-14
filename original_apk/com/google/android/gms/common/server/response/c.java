package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class c implements Parcelable.Creator<zak> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        ArrayList<zal> arrayList = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                arrayList = a.c(parcel, a2, zal.CREATOR);
            } else if (a3 != 3) {
                a.z(parcel, a2);
            } else {
                str = a.n(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new zak(i, arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zak[i];
    }
}
