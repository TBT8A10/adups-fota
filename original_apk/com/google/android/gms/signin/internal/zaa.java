package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zaa extends AbstractSafeParcelable implements j {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f1975a;

    /* renamed from: b  reason: collision with root package name */
    private int f1976b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f1977c;

    zaa(int i, int i2, Intent intent) {
        this.f1975a = i;
        this.f1976b = i2;
        this.f1977c = intent;
    }

    public final Status l() {
        if (this.f1976b == 0) {
            return Status.f1722a;
        }
        return Status.e;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1975a);
        b.a(parcel, 2, this.f1976b);
        b.a(parcel, 3, (Parcelable) this.f1977c, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public zaa() {
        this(0, (Intent) null);
    }

    private zaa(int i, Intent intent) {
        this(2, 0, (Intent) null);
    }
}
