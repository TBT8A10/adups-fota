package com.google.firebase.components;

import com.google.firebase.b.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
final class x extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f2331a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f2332b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f2333c;
    private final Set<Class<?>> d;
    private final Set<Class<?>> e;
    private final f f;

    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f2334a;

        /* renamed from: b  reason: collision with root package name */
        private final c f2335b;

        public a(Set<Class<?>> set, c cVar) {
            this.f2334a = set;
            this.f2335b = cVar;
        }
    }

    x(e<?> eVar, f fVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (q next : eVar.a()) {
            if (next.b()) {
                if (next.d()) {
                    hashSet3.add(next.a());
                } else {
                    hashSet.add(next.a());
                }
            } else if (next.d()) {
                hashSet4.add(next.a());
            } else {
                hashSet2.add(next.a());
            }
        }
        if (!eVar.d().isEmpty()) {
            hashSet.add(c.class);
        }
        this.f2331a = Collections.unmodifiableSet(hashSet);
        this.f2332b = Collections.unmodifiableSet(hashSet2);
        this.f2333c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = eVar.d();
        this.f = fVar;
    }

    public <T> T a(Class<T> cls) {
        if (this.f2331a.contains(cls)) {
            T a2 = this.f.a(cls);
            if (!cls.equals(c.class)) {
                return a2;
            }
            return new a(this.e, (c) a2);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> com.google.firebase.c.a<Set<T>> b(Class<T> cls) {
        if (this.d.contains(cls)) {
            return this.f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }

    public <T> Set<T> c(Class<T> cls) {
        if (this.f2333c.contains(cls)) {
            return this.f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> com.google.firebase.c.a<T> d(Class<T> cls) {
        if (this.f2332b.contains(cls)) {
            return this.f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }
}
