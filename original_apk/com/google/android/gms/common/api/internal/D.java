package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.C0177s;

public final class D<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1737a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1738b;

    /* renamed from: c  reason: collision with root package name */
    private final a<O> f1739c;
    private final O d;

    public final String a() {
        return this.f1739c.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d2 = (D) obj;
        return !this.f1737a && !d2.f1737a && C0177s.a(this.f1739c, d2.f1739c) && C0177s.a(this.d, d2.d);
    }

    public final int hashCode() {
        return this.f1738b;
    }
}
