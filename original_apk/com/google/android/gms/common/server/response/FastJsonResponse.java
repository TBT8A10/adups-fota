package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f1922a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f1923b;

        /* renamed from: c  reason: collision with root package name */
        protected final boolean f1924c;
        protected final int d;
        protected final boolean e;
        protected final String f;
        protected final int g;
        protected final Class<? extends FastJsonResponse> h;
        private final String i;
        private zak j;
        /* access modifiers changed from: private */
        public a<I, O> k;

        Field(int i2, int i3, boolean z, int i4, boolean z2, String str, int i5, String str2, zaa zaa) {
            this.f1922a = i2;
            this.f1923b = i3;
            this.f1924c = z;
            this.d = i4;
            this.e = z2;
            this.f = str;
            this.g = i5;
            if (str2 == null) {
                this.h = null;
                this.i = null;
            } else {
                this.h = SafeParcelResponse.class;
                this.i = str2;
            }
            if (zaa == null) {
                this.k = null;
            } else {
                this.k = zaa.m();
            }
        }

        private final String p() {
            String str = this.i;
            if (str == null) {
                return null;
            }
            return str;
        }

        private final zaa q() {
            a<I, O> aVar = this.k;
            if (aVar == null) {
                return null;
            }
            return zaa.a(aVar);
        }

        public final void a(zak zak) {
            this.j = zak;
        }

        public int m() {
            return this.g;
        }

        public final boolean n() {
            return this.k != null;
        }

        public final Map<String, Field<?, ?>> o() {
            C0178t.a(this.i);
            C0178t.a(this.j);
            return this.j.b(this.i);
        }

        public String toString() {
            C0177s.a a2 = C0177s.a((Object) this);
            a2.a("versionCode", Integer.valueOf(this.f1922a));
            a2.a("typeIn", Integer.valueOf(this.f1923b));
            a2.a("typeInArray", Boolean.valueOf(this.f1924c));
            a2.a("typeOut", Integer.valueOf(this.d));
            a2.a("typeOutArray", Boolean.valueOf(this.e));
            a2.a("outputFieldName", this.f);
            a2.a("safeParcelFieldId", Integer.valueOf(this.g));
            a2.a("concreteTypeName", p());
            Class<? extends FastJsonResponse> cls = this.h;
            if (cls != null) {
                a2.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.k;
            if (aVar != null) {
                a2.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a2.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel);
            b.a(parcel, 1, this.f1922a);
            b.a(parcel, 2, this.f1923b);
            b.a(parcel, 3, this.f1924c);
            b.a(parcel, 4, this.d);
            b.a(parcel, 5, this.e);
            b.a(parcel, 6, this.f, false);
            b.a(parcel, 7, m());
            b.a(parcel, 8, p(), false);
            b.a(parcel, 9, (Parcelable) q(), i2, false);
            b.a_shaKey_method2(parcel, a2);
        }

        public final I a(O o) {
            return this.k.a(o);
        }
    }

    public interface a<I, O> {
        I a(O o);
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return field.k != null ? field.a(obj) : obj;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(String str);

    public abstract Map<String, Field<?, ?>> a();

    /* access modifiers changed from: protected */
    public boolean b(Field field) {
        if (field.d != 11) {
            return b(field.f);
        }
        if (field.e) {
            String str = field.f;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        String str2 = field.f;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(String str);

    public String toString() {
        Map<String, Field<?, ?>> a2 = a();
        StringBuilder sb = new StringBuilder(100);
        for (String next : a2.keySet()) {
            Field field = a2.get(next);
            if (b(field)) {
                Object a3 = a(field, a(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(next);
                sb.append("\":");
                if (a3 != null) {
                    switch (field.d) {
                        case 8:
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.b.a((byte[]) a3));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(com.google.android.gms.common.util.b.b((byte[]) a3));
                            sb.append("\"");
                            break;
                        case 10:
                            i.a(sb, (HashMap) a3);
                            break;
                        default:
                            if (!field.f1924c) {
                                a(sb, field, a3);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) a3;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        a(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Object a(Field field) {
        String str = field.f;
        if (field.h == null) {
            return a(str);
        }
        C0178t.b(a(str) == null, "Concrete field shouldn't be value object: %s", field.f);
        boolean z = field.e;
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void a(StringBuilder sb, Field field, Object obj) {
        int i = field.f1923b;
        if (i == 11) {
            sb.append(((FastJsonResponse) field.h.cast(obj)).toString());
        } else if (i == 7) {
            sb.append("\"");
            sb.append(h.a((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }
}
