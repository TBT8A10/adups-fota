package com.google.firebase.iid;

import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.C0178t;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class X {

    /* renamed from: a  reason: collision with root package name */
    private final String f2395a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f2396b;

    X(String str, long j) {
        C0178t.a(str);
        this.f2395a = str;
        this.f2396b = j;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f2395a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof X)) {
            return false;
        }
        X x = (X) obj;
        if (this.f2396b != x.f2396b || !this.f2395a.equals(x.f2395a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0177s.a(this.f2395a, Long.valueOf(this.f2396b));
    }
}
