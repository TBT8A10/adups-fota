package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f1931a;

    /* renamed from: b  reason: collision with root package name */
    final String f1932b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<zam> f1933c;

    zal(int i, String str, ArrayList<zam> arrayList) {
        this.f1931a = i;
        this.f1932b = str;
        this.f1933c = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1931a);
        b.a(parcel, 2, this.f1932b, false);
        b.b(parcel, 3, this.f1933c, false);
        b.a_shaKey_method2(parcel, a2);
    }

    zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f1931a = 1;
        this.f1932b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new zam(next, map.get(next)));
            }
        }
        this.f1933c = arrayList;
    }
}
