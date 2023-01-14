package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f1914a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f1915b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<String> f1916c;
    private final ArrayList<zaa> d;

    StringToIntConverter(int i, ArrayList<zaa> arrayList) {
        this.f1914a = i;
        this.f1915b = new HashMap<>();
        this.f1916c = new SparseArray<>();
        this.d = null;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaa zaa2 = arrayList.get(i2);
            i2++;
            zaa zaa3 = zaa2;
            a(zaa3.f1918b, zaa3.f1919c);
        }
    }

    public final StringToIntConverter a(String str, int i) {
        this.f1915b.put(str, Integer.valueOf(i));
        this.f1916c.put(i, str);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1914a);
        ArrayList arrayList = new ArrayList();
        for (String next : this.f1915b.keySet()) {
            arrayList.add(new zaa(next, this.f1915b.get(next).intValue()));
        }
        b.b(parcel, 2, arrayList, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public final /* synthetic */ Object a(Object obj) {
        String str = this.f1916c.get(((Integer) obj).intValue());
        return (str != null || !this.f1915b.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        private final int f1917a;

        /* renamed from: b  reason: collision with root package name */
        final String f1918b;

        /* renamed from: c  reason: collision with root package name */
        final int f1919c;

        zaa(int i, String str, int i2) {
            this.f1917a = i;
            this.f1918b = str;
            this.f1919c = i2;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int a2 = b.a(parcel);
            b.a(parcel, 1, this.f1917a);
            b.a(parcel, 2, this.f1918b, false);
            b.a(parcel, 3, this.f1919c);
            b.a_shaKey_method2(parcel, a2);
        }

        zaa(String str, int i) {
            this.f1917a = 1;
            this.f1918b = str;
            this.f1919c = i;
        }
    }

    public StringToIntConverter() {
        this.f1914a = 1;
        this.f1915b = new HashMap<>();
        this.f1916c = new SparseArray<>();
        this.d = null;
    }
}
