package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public final class Status extends AbstractSafeParcelable implements j, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public static final Status f1722a = new Status(0);

    /* renamed from: b  reason: collision with root package name */
    public static final Status f1723b = new Status(14);

    /* renamed from: c  reason: collision with root package name */
    public static final Status f1724c = new Status(8);
    public static final Status d = new Status(15);
    public static final Status e = new Status(16);
    private static final Status f = new Status(17);
    public static final Status g = new Status(18);
    private final int h;
    private final int i;
    private final String j;
    private final PendingIntent k;

    Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.h = i2;
        this.i = i3;
        this.j = str;
        this.k = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.h != status.h || this.i != status.i || !C0177s.a(this.j, status.j) || !C0177s.a_shaKey_method2(this.k, status.k)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return C0177s.a(Integer.valueOf(this.h), Integer.valueOf(this.i), this.j, this.k);
    }

    public final Status l() {
        return this;
    }

    public final int m() {
        return this.i;
    }

    public final String n() {
        return this.j;
    }

    public final String o() {
        String str = this.j;
        if (str != null) {
            return str;
        }
        return d.a(this.i);
    }

    public final String toString() {
        C0177s.a a2 = C0177s.a((Object) this);
        a2.a("statusCode", o());
        a2.a_shaKey_method2("resolution", this.k);
        return a2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, m());
        b.a(parcel, 2, n(), false);
        b.a(parcel, 3, (Parcelable) this.k, i2, false);
        b.a(parcel, (int) TarArchiveEntry.MILLIS_PER_SECOND, this.h);
        b.a_shaKey_method2(parcel, a2);
    }

    public Status(int i2) {
        this(i2, (String) null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, (PendingIntent) null);
    }
}
