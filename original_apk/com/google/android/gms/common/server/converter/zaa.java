package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f1920a;

    /* renamed from: b  reason: collision with root package name */
    private final StringToIntConverter f1921b;

    zaa(int i, StringToIntConverter stringToIntConverter) {
        this.f1920a = i;
        this.f1921b = stringToIntConverter;
    }

    public static zaa a(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> m() {
        StringToIntConverter stringToIntConverter = this.f1921b;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1920a);
        b.a(parcel, 2, (Parcelable) this.f1921b, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.f1920a = 1;
        this.f1921b = stringToIntConverter;
    }
}
