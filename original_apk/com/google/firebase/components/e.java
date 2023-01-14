package com.google.firebase.components;

import com.google.android.gms.common.internal.C0178t;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<? super T>> f2300a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<q> f2301b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2302c;
    private final int d;
    private final i<T> e;
    private final Set<Class<?>> f;

    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<? super T>> f2303a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<q> f2304b;

        /* renamed from: c  reason: collision with root package name */
        private int f2305c;
        private int d;
        private i<T> e;
        private Set<Class<?>> f;

        /* access modifiers changed from: private */
        public a<T> c() {
            this.d = 1;
            return this;
        }

        public e<T> b() {
            C0178t.b(this.e != null, "Missing required property: factory.");
            return new e(new HashSet(this.f2303a), new HashSet(this.f2304b), this.f2305c, this.d, this.e, this.f);
        }

        @SafeVarargs
        private a(Class<T> cls, Class<? super T>... clsArr) {
            this.f2303a = new HashSet();
            this.f2304b = new HashSet();
            this.f2305c = 0;
            this.d = 0;
            this.f = new HashSet();
            C0178t.a(cls, (Object) "Null interface");
            this.f2303a.add(cls);
            for (Class<? super T> a2 : clsArr) {
                C0178t.a(a2, (Object) "Null interface");
            }
            Collections.addAll(this.f2303a, clsArr);
        }

        public a<T> a(q qVar) {
            C0178t.a(qVar, (Object) "Null dependency");
            a(qVar.a());
            this.f2304b.add(qVar);
            return this;
        }

        public a<T> a() {
            a(1);
            return this;
        }

        private a<T> a(int i) {
            C0178t.b(this.f2305c == 0, "Instantiation type has already been set.");
            this.f2305c = i;
            return this;
        }

        private void a(Class<?> cls) {
            C0178t.a(!this.f2303a.contains(cls), (Object) "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public a<T> a(i<T> iVar) {
            C0178t.a(iVar, (Object) "Null factory");
            this.e = iVar;
            return this;
        }
    }

    static /* synthetic */ Object a(Object obj, f fVar) {
        return obj;
    }

    static /* synthetic */ Object b(Object obj, f fVar) {
        return obj;
    }

    public Set<q> a() {
        return this.f2301b;
    }

    public i<T> b() {
        return this.e;
    }

    public Set<Class<? super T>> c() {
        return this.f2300a;
    }

    public Set<Class<?>> d() {
        return this.f;
    }

    public boolean e() {
        return this.f2302c == 1;
    }

    public boolean f() {
        return this.f2302c == 2;
    }

    public boolean g() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f2300a.toArray()) + ">{" + this.f2302c + ", type=" + this.d + ", deps=" + Arrays.toString(this.f2301b.toArray()) + "}";
    }

    private e(Set<Class<? super T>> set, Set<q> set2, int i, int i2, i<T> iVar, Set<Class<?>> set3) {
        this.f2300a = Collections.unmodifiableSet(set);
        this.f2301b = Collections.unmodifiableSet(set2);
        this.f2302c = i;
        this.d = i2;
        this.e = iVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls, new Class[0]);
    }

    public static <T> a<T> b(Class<T> cls) {
        a<T> a2 = a(cls);
        a unused = a2.c();
        return a2;
    }

    @SafeVarargs
    public static <T> a<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new a<>(cls, clsArr);
    }

    @SafeVarargs
    public static <T> e<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        a<T> a2 = a(cls, clsArr);
        a2.a((i<T>) b.a((Object) t));
        return a2.b();
    }

    public static <T> e<T> a(T t, Class<T> cls) {
        a<T> b2 = b(cls);
        b2.a((i<T>) c.a((Object) t));
        return b2.b();
    }
}
