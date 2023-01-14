package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final String f1709a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final int f1710b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1711c;

    public Feature(String str, int i, long j) {
        this.f1709a = str;
        this.f1710b = i;
        this.f1711c = j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((m() == null || !m().equals(feature.m())) && (m() != null || feature.m() != null)) || n() != feature.n()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C0177s.a(m(), Long.valueOf(n()));
    }

    public String m() {
        return this.f1709a;
    }

    public long n() {
        long j = this.f1711c;
        return j == -1 ? (long) this.f1710b : j;
    }

    public String toString() {
        C0177s.a a2 = C0177s.a((Object) this);
        a2.a("name", m());
        a2.a("version", Long.valueOf(n()));
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, m(), false);
        b.a(parcel, 2, this.f1710b);
        b.a(parcel, 3, n());
        b.a_shaKey_method2(parcel, a2);
    }
}
