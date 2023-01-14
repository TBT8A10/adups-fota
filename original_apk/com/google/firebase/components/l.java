package com.google.firebase.components;

import com.google.firebase.c.a;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
final /* synthetic */ class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Set f2310a;

    private l(Set set) {
        this.f2310a = set;
    }

    public static a a(Set set) {
        return new l(set);
    }

    public Object get() {
        return n.a(this.f2310a);
    }
}
