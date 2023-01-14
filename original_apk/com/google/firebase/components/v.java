package com.google.firebase.components;

import com.google.firebase.c.a;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class v<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2328a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f2329b = f2328a;

    /* renamed from: c  reason: collision with root package name */
    private volatile a<T> f2330c;

    public v(a<T> aVar) {
        this.f2330c = aVar;
    }

    public T get() {
        T t = this.f2329b;
        if (t == f2328a) {
            synchronized (this) {
                t = this.f2329b;
                if (t == f2328a) {
                    t = this.f2330c.get();
                    this.f2329b = t;
                    this.f2330c = null;
                }
            }
        }
        return t;
    }
}
