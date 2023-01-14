package com.google.firebase.b;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f2296a;

    /* renamed from: b  reason: collision with root package name */
    private final T f2297b;

    public Class<T> a() {
        return this.f2296a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.f2296a, this.f2297b});
    }
}
