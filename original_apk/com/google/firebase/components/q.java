package com.google.firebase.components;

import com.google.android.gms.common.internal.C0178t;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2320a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2321b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2322c;

    private q(Class<?> cls, int i, int i2) {
        C0178t.a(cls, (Object) "Null dependency anInterface.");
        this.f2320a = cls;
        this.f2321b = i;
        this.f2322c = i2;
    }

    public static q a(Class<?> cls) {
        return new q(cls, 1, 0);
    }

    public static q b(Class<?> cls) {
        return new q(cls, 2, 0);
    }

    public boolean c() {
        return this.f2321b == 1;
    }

    public boolean d() {
        return this.f2321b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f2320a == qVar.f2320a && this.f2321b == qVar.f2321b && this.f2322c == qVar.f2322c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f2320a.hashCode() ^ 1000003) * 1000003) ^ this.f2321b) * 1000003) ^ this.f2322c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f2320a);
        sb.append(", type=");
        int i = this.f2321b;
        boolean z = true;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        if (this.f2322c != 0) {
            z = false;
        }
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }

    public Class<?> a() {
        return this.f2320a;
    }

    public boolean b() {
        return this.f2322c == 0;
    }
}
