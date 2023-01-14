package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new F();

    /* renamed from: a  reason: collision with root package name */
    private final int f1859a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1860b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1861c;
    @Deprecated
    private final Scope[] d;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f1859a = i;
        this.f1860b = i2;
        this.f1861c = i3;
        this.d = scopeArr;
    }

    public int m() {
        return this.f1860b;
    }

    public int n() {
        return this.f1861c;
    }

    @Deprecated
    public Scope[] o() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1859a);
        b.a(parcel, 2, m());
        b.a(parcel, 3, n());
        b.a(parcel, 4, (T[]) o(), i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, (Scope[]) null);
    }
}
