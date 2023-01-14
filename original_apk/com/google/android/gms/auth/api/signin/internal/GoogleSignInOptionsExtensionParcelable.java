package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f1697a;

    /* renamed from: b  reason: collision with root package name */
    private int f1698b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f1699c;

    GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.f1697a = i;
        this.f1698b = i2;
        this.f1699c = bundle;
    }

    public int m() {
        return this.f1698b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1697a);
        b.a(parcel, 2, m());
        b.a(parcel, 3, this.f1699c, false);
        b.a_shaKey_method2(parcel, a2);
    }
}
