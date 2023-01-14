package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f1934a;

    /* renamed from: b  reason: collision with root package name */
    final String f1935b;

    /* renamed from: c  reason: collision with root package name */
    final FastJsonResponse.Field<?, ?> f1936c;

    zam(int i, String str, FastJsonResponse.Field<?, ?> field) {
        this.f1934a = i;
        this.f1935b = str;
        this.f1936c = field;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1934a);
        b.a(parcel, 2, this.f1935b, false);
        b.a(parcel, 3, (Parcelable) this.f1936c, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f1934a = 1;
        this.f1935b = str;
        this.f1936c = field;
    }
}
