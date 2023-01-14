package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f1925a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f1926b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1927c = 2;
    private final zak d;
    private final String e;
    private int f;
    private int g;

    SafeParcelResponse(int i, Parcel parcel, zak zak) {
        this.f1925a = i;
        C0178t.a(parcel);
        this.f1926b = parcel;
        this.d = zak;
        zak zak2 = this.d;
        if (zak2 == null) {
            this.e = null;
        } else {
            this.e = zak2.n();
        }
        this.f = 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        if (r0 != 1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Parcel b() {
        /*
            r2 = this;
            int r0 = r2.f
            if (r0 == 0) goto L_0x0008
            r1 = 1
            if (r0 == r1) goto L_0x0010
            goto L_0x001a
        L_0x0008:
            android.os.Parcel r0 = r2.f1926b
            int r0 = com.google.android.gms.common.internal.safeparcel.b.a(r0)
            r2.g = r0
        L_0x0010:
            android.os.Parcel r0 = r2.f1926b
            int r1 = r2.g
            com.google.android.gms.common.internal.safeparcel.b.a(r0, r1)
            r0 = 2
            r2.f = r0
        L_0x001a:
            android.os.Parcel r0 = r2.f1926b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.b():android.os.Parcel");
    }

    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        zak zak = this.d;
        if (zak == null) {
            return null;
        }
        return zak.b(this.e);
    }

    public String toString() {
        C0178t.a(this.d, (Object) "Cannot convert to JSON on client side.");
        Parcel b2 = b();
        b2.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        a(sb, this.d.b(this.e), b2);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zak zak;
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1925a);
        b.a(parcel, 2, b(), false);
        int i2 = this.f1927c;
        if (i2 == 0) {
            zak = null;
        } else if (i2 == 1) {
            zak = this.d;
        } else if (i2 == 2) {
            zak = this.d;
        } else {
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid creation type: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        b.a(parcel, 3, (Parcelable) zak, i, false);
        b.a_shaKey_method2(parcel, a2);
    }

    public Object a(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    private final void a(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry next : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) next.getValue()).m(), next);
        }
        sb.append('{');
        int b2 = a.b(parcel);
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            Map.Entry entry = (Map.Entry) sparseArray.get(a.a(a2));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry.getValue();
                sb.append("\"");
                sb.append((String) entry.getKey());
                sb.append("\":");
                if (field.n()) {
                    int i = field.d;
                    switch (i) {
                        case 0:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, Integer.valueOf(a.v(parcel, a2))));
                            break;
                        case 1:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, a.c(parcel, a2)));
                            break;
                        case 2:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, Long.valueOf(a.x(parcel, a2))));
                            break;
                        case 3:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, Float.valueOf(a.t(parcel, a2))));
                            break;
                        case 4:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, Double.valueOf(a.s(parcel, a2))));
                            break;
                        case 5:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, a.a_shaKey_method2(parcel, a2)));
                            break;
                        case 6:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, Boolean.valueOf(a.r(parcel, a2))));
                            break;
                        case 7:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, a.n(parcel, a2)));
                            break;
                        case 8:
                        case 9:
                            b(sb, field, FastJsonResponse.a_shaKey_method2(field, a.g(parcel, a2)));
                            break;
                        case 10:
                            Bundle f2 = a.f(parcel, a2);
                            HashMap hashMap = new HashMap();
                            for (String str : f2.keySet()) {
                                hashMap.put(str, f2.getString(str));
                            }
                            b(sb, field, FastJsonResponse.a(field, hashMap));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.e) {
                    sb.append("[");
                    switch (field.d) {
                        case 0:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, a.j(parcel, a2));
                            break;
                        case 1:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, (T[]) a.d(parcel, a2));
                            break;
                        case 2:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, a.k(parcel, a2));
                            break;
                        case 3:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, a.i(parcel, a2));
                            break;
                        case 4:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, a.h(parcel, a2));
                            break;
                        case 5:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, (T[]) a.b(parcel, a2));
                            break;
                        case 6:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, a.e(parcel, a2));
                            break;
                        case 7:
                            com.google.android.gms.common.util.a.a_shaKey_method2(sb, a.o(parcel, a2));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] m = a.m(parcel, a2);
                            int length = m.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (i2 > 0) {
                                    sb.append(",");
                                }
                                m[i2].setDataPosition(0);
                                a(sb, field.o(), m[i2]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.d) {
                        case 0:
                            sb.append(a.v(parcel, a2));
                            break;
                        case 1:
                            sb.append(a.c(parcel, a2));
                            break;
                        case 2:
                            sb.append(a.x(parcel, a2));
                            break;
                        case 3:
                            sb.append(a.t(parcel, a2));
                            break;
                        case 4:
                            sb.append(a.s(parcel, a2));
                            break;
                        case 5:
                            sb.append(a.a_shaKey_method2(parcel, a2));
                            break;
                        case 6:
                            sb.append(a.r(parcel, a2));
                            break;
                        case 7:
                            String n = a.n(parcel, a2);
                            sb.append("\"");
                            sb.append(h.a(n));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] g2 = a.g(parcel, a2);
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.b.a(g2));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] g3 = a.g(parcel, a2);
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.b.b(g3));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle f3 = a.f(parcel, a2);
                            Set<String> keySet = f3.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str2 : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str2);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(h.a(f3.getString(str2)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel l = a.l(parcel, a2);
                            l.setDataPosition(0);
                            a(sb, field.o(), l);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == b2) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(b2);
        throw new a.C0038a(sb3.toString(), parcel);
    }

    public boolean b(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    private final void b(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.f1924c) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                a(sb, field.f1923b, arrayList.get(i));
            }
            sb.append("]");
            return;
        }
        a(sb, field.f1923b, obj);
    }

    private static void a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(h.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(com.google.android.gms.common.util.b.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(com.google.android.gms.common.util.b.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                i.a_shaKey_method2(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }
}
