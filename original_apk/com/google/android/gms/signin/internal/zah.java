package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final int f1978a;

    /* renamed from: b  reason: collision with root package name */
    private final ResolveAccountRequest f1979b;

    zah(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f1978a = i;
        this.f1979b = resolveAccountRequest;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1978a);
        b.a(parcel, 2, (Parcelable) this.f1979b, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }
}
