package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class T implements Parcelable.Creator<zzr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            if (a.a(a2) != 1) {
                a.z(parcel, a2);
            } else {
                i = a.v(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new zzr(i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
