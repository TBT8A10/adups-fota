package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C0171l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new E();

    /* renamed from: a  reason: collision with root package name */
    private final int f1856a;

    /* renamed from: b  reason: collision with root package name */
    private IBinder f1857b;

    /* renamed from: c  reason: collision with root package name */
    private ConnectionResult f1858c;
    private boolean d;
    private boolean e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f1856a = i;
        this.f1857b = iBinder;
        this.f1858c = connectionResult;
        this.d = z;
        this.e = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f1858c.equals(resolveAccountResponse.f1858c) && m().equals(resolveAccountResponse.m());
    }

    public C0171l m() {
        return C0171l.a.a(this.f1857b);
    }

    public ConnectionResult n() {
        return this.f1858c;
    }

    public boolean o() {
        return this.d;
    }

    public boolean p() {
        return this.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1856a);
        b.a(parcel, 2, this.f1857b, false);
        b.a(parcel, 3, (Parcelable) n(), i, false);
        b.a(parcel, 4, o());
        b.a(parcel, 5, p());
        b.a_shaKey_method2(parcel, a2);
    }
}
