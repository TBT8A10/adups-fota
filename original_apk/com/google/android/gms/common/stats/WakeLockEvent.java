package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f1937a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1938b;

    /* renamed from: c  reason: collision with root package name */
    private int f1939c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final List<String> h;
    private final String i;
    private final long j;
    private int k;
    private final String l;
    private final float m;
    private final long n;
    private final boolean o;
    private long p;

    WakeLockEvent(int i2, long j2, int i3, String str, int i4, List<String> list, String str2, long j3, int i5, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this.f1937a = i2;
        this.f1938b = j2;
        this.f1939c = i3;
        this.d = str;
        this.e = str3;
        this.f = str5;
        this.g = i4;
        this.p = -1;
        this.h = list;
        this.i = str2;
        this.j = j3;
        this.k = i5;
        this.l = str4;
        this.m = f2;
        this.n = j4;
        this.o = z;
    }

    public final int m() {
        return this.f1939c;
    }

    public final long n() {
        return this.f1938b;
    }

    public final long o() {
        return this.p;
    }

    public final String p() {
        String str;
        String str2 = this.d;
        int i2 = this.g;
        List<String> list = this.h;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(",", list);
        }
        int i3 = this.k;
        String str4 = this.e;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = this.l;
        if (str5 == null) {
            str5 = str3;
        }
        float f2 = this.m;
        String str6 = this.f;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = this.o;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 51 + String.valueOf(str).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str3).length());
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str4);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1937a);
        b.a(parcel, 2, n());
        b.a(parcel, 4, this.d, false);
        b.a(parcel, 5, this.g);
        b.a(parcel, 6, this.h, false);
        b.a(parcel, 8, this.j);
        b.a(parcel, 10, this.e, false);
        b.a(parcel, 11, m());
        b.a(parcel, 12, this.i, false);
        b.a(parcel, 13, this.l, false);
        b.a(parcel, 14, this.k);
        b.a(parcel, 15, this.m);
        b.a(parcel, 16, this.n);
        b.a(parcel, 17, this.f, false);
        b.a(parcel, 18, this.o);
        b.a_shaKey_method2(parcel, a2);
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List<String> list, String str2, long j3, int i4, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, str5, z);
    }
}
