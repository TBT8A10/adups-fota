package androidx.media;

import android.text.TextUtils;
import androidx.core.g.c;

/* compiled from: MediaSessionManagerImplBase */
class B implements z {

    /* renamed from: a  reason: collision with root package name */
    private String f939a;

    /* renamed from: b  reason: collision with root package name */
    private int f940b;

    /* renamed from: c  reason: collision with root package name */
    private int f941c;

    B(String str, int i, int i2) {
        this.f939a = str;
        this.f940b = i;
        this.f941c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b2 = (B) obj;
        if (TextUtils.equals(this.f939a, b2.f939a) && this.f940b == b2.f940b && this.f941c == b2.f941c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return c.a(this.f939a, Integer.valueOf(this.f940b), Integer.valueOf(this.f941c));
    }
}
