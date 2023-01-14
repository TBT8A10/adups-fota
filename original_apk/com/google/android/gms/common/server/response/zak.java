package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f1928a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f1929b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<zal> f1930c = null;
    private final String d;

    zak(int i, ArrayList<zal> arrayList, String str) {
        this.f1928a = i;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zal = arrayList.get(i2);
            String str2 = zal.f1932b;
            HashMap hashMap2 = new HashMap();
            int size2 = zal.f1933c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zam = zal.f1933c.get(i3);
                hashMap2.put(zam.f1935b, zam.f1936c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f1929b = hashMap;
        C0178t.a(str);
        this.d = str;
        m();
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> b(String str) {
        return this.f1929b.get(str);
    }

    public final void m() {
        for (String str : this.f1929b.keySet()) {
            Map map = this.f1929b.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).a(this);
            }
        }
    }

    public final String n() {
        return this.d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f1929b.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.f1929b.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1928a);
        ArrayList arrayList = new ArrayList();
        for (String next : this.f1929b.keySet()) {
            arrayList.add(new zal(next, this.f1929b.get(next)));
        }
        b.b(parcel, 2, arrayList, false);
        b.a(parcel, 3, this.d, false);
        b.a_shaKey_method2(parcel, a2);
    }
}
