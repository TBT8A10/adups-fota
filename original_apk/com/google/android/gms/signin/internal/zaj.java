package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final int f1980a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f1981b;

    /* renamed from: c  reason: collision with root package name */
    private final ResolveAccountResponse f1982c;

    zaj(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f1980a = i;
        this.f1981b = connectionResult;
        this.f1982c = resolveAccountResponse;
    }

    public final ConnectionResult m() {
        return this.f1981b;
    }

    public final ResolveAccountResponse n() {
        return this.f1982c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1980a);
        b.a(parcel, 2, (Parcelable) this.f1981b, i, false);
        b.a(parcel, 3, (Parcelable) this.f1982c, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public zaj(int i) {
        this(new ConnectionResult(8, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, (ResolveAccountResponse) null);
    }
}
