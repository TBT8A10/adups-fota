package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    private final int f1828a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f1829b;

    /* renamed from: c  reason: collision with root package name */
    private final Scope[] f1830c;
    private Integer d;
    private Integer e;
    private Account f;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.f1828a = i;
        this.f1829b = iBinder;
        this.f1830c = scopeArr;
        this.d = num;
        this.e = num2;
        this.f = account;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1828a);
        b.a(parcel, 2, this.f1829b, false);
        b.a(parcel, 3, (T[]) this.f1830c, i, false);
        b.a(parcel, 4, this.d, false);
        b.a(parcel, 5, this.e, false);
        b.a(parcel, 6, (Parcelable) this.f, i, false);
        b.a_shaKey_method2(parcel, a2);
    }
}
