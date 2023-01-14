package com.google.android.gms.common.api.internal;

import b.a.a.a.d.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.common.api.internal.h  reason: case insensitive filesystem */
public final class C0159h {

    /* renamed from: a  reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f1759a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final Map<i<?>, Boolean> f1760b = Collections.synchronizedMap(new WeakHashMap());

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return !this.f1759a.isEmpty() || !this.f1760b.isEmpty();
    }

    public final void b() {
        a(false, C0153b.f1746a);
    }

    public final void c() {
        a(true, z.f1782a);
    }

    private final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1759a) {
            hashMap = new HashMap(this.f1759a);
        }
        synchronized (this.f1760b) {
            hashMap2 = new HashMap(this.f1760b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((i) entry2.getKey()).b((Exception) new b(status));
            }
        }
    }
}
