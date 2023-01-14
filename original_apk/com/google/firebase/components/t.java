package com.google.firebase.components;

import com.google.firebase.b.a;
import com.google.firebase.b.b;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Map.Entry f2323a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2324b;

    private t(Map.Entry entry, a aVar) {
        this.f2323a = entry;
        this.f2324b = aVar;
    }

    public static Runnable a(Map.Entry entry, a aVar) {
        return new t(entry, aVar);
    }

    public void run() {
        ((b) this.f2323a.getKey()).a(this.f2324b);
    }
}
