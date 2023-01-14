package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.a;

public final class H implements Parcelable.Creator<zzb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                bundle = a.f(parcel, a2);
            } else if (a3 != 2) {
                a.z(parcel, a2);
            } else {
                featureArr = (Feature[]) a.b(parcel, a2, Feature.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new zzb(bundle, featureArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzb[i];
    }
}
