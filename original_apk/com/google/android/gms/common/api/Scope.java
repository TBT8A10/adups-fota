package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private final int f1720a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1721b;

    Scope(int i, String str) {
        C0178t.a(str, (Object) "scopeUri must not be null or empty");
        this.f1720a = i;
        this.f1721b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f1721b.equals(((Scope) obj).f1721b);
    }

    public final int hashCode() {
        return this.f1721b.hashCode();
    }

    public final String m() {
        return this.f1721b;
    }

    public final String toString() {
        return this.f1721b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1720a);
        b.a(parcel, 2, m(), false);
        b.a_shaKey_method2(parcel, a2);
    }

    public Scope(String str) {
        this(1, str);
    }
}
