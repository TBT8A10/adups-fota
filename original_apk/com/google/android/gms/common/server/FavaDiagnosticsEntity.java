package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f1911a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1912b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1913c;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f1911a = i;
        this.f1912b = str;
        this.f1913c = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1911a);
        b.a(parcel, 2, this.f1912b, false);
        b.a(parcel, 3, this.f1913c);
        b.a_shaKey_method2(parcel, a2);
    }
}
