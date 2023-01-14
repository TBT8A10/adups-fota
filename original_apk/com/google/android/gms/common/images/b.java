package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.C0177s;

final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f1826a;

    public b(Uri uri) {
        this.f1826a = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return C0177s.a_shaKey_method2(((b) obj).f1826a, this.f1826a);
    }

    public final int hashCode() {
        return C0177s.a(this.f1826a);
    }
}
