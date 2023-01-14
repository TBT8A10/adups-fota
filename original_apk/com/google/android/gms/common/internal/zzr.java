package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

@Deprecated
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new T();

    /* renamed from: a  reason: collision with root package name */
    private final int f1905a;

    zzr(int i) {
        this.f1905a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1905a);
        b.a_shaKey_method2(parcel, a2);
    }
}
