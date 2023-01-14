package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new D();

    /* renamed from: a  reason: collision with root package name */
    private final int f1853a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f1854b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1855c;
    private final GoogleSignInAccount d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f1853a = i;
        this.f1854b = account;
        this.f1855c = i2;
        this.d = googleSignInAccount;
    }

    public Account m() {
        return this.f1854b;
    }

    public int n() {
        return this.f1855c;
    }

    public GoogleSignInAccount o() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1853a);
        b.a(parcel, 2, (Parcelable) m(), i, false);
        b.a(parcel, 3, n());
        b.a(parcel, 4, (Parcelable) o(), i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }
}
