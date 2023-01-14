package com.google.android.gms.auth.api.signin.internal;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f1700a = 31;

    /* renamed from: b  reason: collision with root package name */
    private int f1701b = 1;

    public a a(Object obj) {
        this.f1701b = (f1700a * this.f1701b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final a a(boolean z) {
        this.f1701b = (f1700a * this.f1701b) + (z ? 1 : 0);
        return this;
    }

    public int a() {
        return this.f1701b;
    }
}
