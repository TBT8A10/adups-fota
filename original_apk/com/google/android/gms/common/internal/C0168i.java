package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* renamed from: com.google.android.gms.common.internal.i  reason: case insensitive filesystem */
public abstract class C0168i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1882a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static C0168i f1883b;

    /* renamed from: com.google.android.gms.common.internal.i$a */
    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1884a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1885b;

        /* renamed from: c  reason: collision with root package name */
        private final ComponentName f1886c = null;
        private final int d;

        public a(String str, String str2, int i) {
            C0178t.a(str);
            this.f1884a = str;
            C0178t.a(str2);
            this.f1885b = str2;
            this.d = i;
        }

        public final ComponentName a() {
            return this.f1886c;
        }

        public final String b() {
            return this.f1885b;
        }

        public final int c() {
            return this.d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C0177s.a(this.f1884a, aVar.f1884a) && C0177s.a(this.f1885b, aVar.f1885b) && C0177s.a_shaKey_method2(this.f1886c, aVar.f1886c) && this.d == aVar.d;
        }

        public final int hashCode() {
            return C0177s.a(this.f1884a, this.f1885b, this.f1886c, Integer.valueOf(this.d));
        }

        public final String toString() {
            String str = this.f1884a;
            return str == null ? this.f1886c.flattenToString() : str;
        }

        public final Intent a(Context context) {
            String str = this.f1884a;
            if (str != null) {
                return new Intent(str).setPackage(this.f1885b);
            }
            return new Intent().setComponent(this.f1886c);
        }
    }

    public static C0168i a(Context context) {
        synchronized (f1882a) {
            if (f1883b == null) {
                f1883b = new J(context.getApplicationContext());
            }
        }
        return f1883b;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    /* access modifiers changed from: protected */
    public abstract void b(a aVar, ServiceConnection serviceConnection, String str);

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new a(str, str2, i), serviceConnection, str3);
    }
}
