package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.C0171l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new I();

    /* renamed from: a  reason: collision with root package name */
    private final int f1838a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1839b;

    /* renamed from: c  reason: collision with root package name */
    private int f1840c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;
    Feature[] i;
    Feature[] j;
    private boolean k;

    public GetServiceRequest(int i2) {
        this.f1838a = 4;
        this.f1840c = b.f1789a;
        this.f1839b = i2;
        this.k = true;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f1838a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f1839b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f1840c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, (T[]) this.f, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.g, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, (Parcelable) this.h, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, (T[]) this.i, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, (T[]) this.j, i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, this.k);
        com.google.android.gms.common.internal.safeparcel.b.a_shaKey_method2(parcel, a2);
    }

    GetServiceRequest(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z) {
        this.f1838a = i2;
        this.f1839b = i3;
        this.f1840c = i4;
        if ("com.google.android.gms".equals(str)) {
            this.d = "com.google.android.gms";
        } else {
            this.d = str;
        }
        if (i2 < 2) {
            this.h = iBinder != null ? C0160a.a(C0171l.a.a(iBinder)) : null;
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
        this.i = featureArr;
        this.j = featureArr2;
        this.k = z;
    }
}
