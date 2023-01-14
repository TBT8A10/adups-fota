package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class d implements Parcelable.Creator<zal> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        String str = null;
        int i = 0;
        ArrayList<zam> arrayList = null;
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
                arrayList = a.c(parcel, a2, zam.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new zal(i, str, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zal[i];
    }
}
