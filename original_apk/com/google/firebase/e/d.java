package com.google.firebase.e;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f2354a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<e> f2355b = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = f2354a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f2354a;
                if (dVar == null) {
                    dVar = new d();
                    f2354a = dVar;
                }
            }
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public Set<e> b() {
        Set<e> unmodifiableSet;
        synchronized (this.f2355b) {
            unmodifiableSet = Collections.unmodifiableSet(this.f2355b);
        }
        return unmodifiableSet;
    }
}
