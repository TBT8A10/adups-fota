package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new H();

    /* renamed from: a  reason: collision with root package name */
    Bundle f1903a;

    /* renamed from: b  reason: collision with root package name */
    Feature[] f1904b;

    zzb(Bundle bundle, Feature[] featureArr) {
        this.f1903a = bundle;
        this.f1904b = featureArr;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1903a, false);
        b.a(parcel, 2, (T[]) this.f1904b, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public zzb() {
    }
}
