package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Locale;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f1822a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f1823b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1824c;
    private final int d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f1822a = i;
        this.f1823b = uri;
        this.f1824c = i2;
        this.d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            return C0177s.a_shaKey_method2(this.f1823b, webImage.f1823b) && this.f1824c == webImage.f1824c && this.d == webImage.d;
        }
    }

    public final int hashCode() {
        return C0177s.a(this.f1823b, Integer.valueOf(this.f1824c), Integer.valueOf(this.d));
    }

    public final int m() {
        return this.d;
    }

    public final Uri n() {
        return this.f1823b;
    }

    public final int o() {
        return this.f1824c;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f1824c), Integer.valueOf(this.d), this.f1823b.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1822a);
        b.a(parcel, 2, (Parcelable) n(), i, false);
        b.a(parcel, 3, o());
        b.a(parcel, 4, m());
        b.a_shaKey_method2(parcel, a2);
    }
}
