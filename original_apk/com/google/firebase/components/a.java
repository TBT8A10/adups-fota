package com.google.firebase.components;

import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
abstract class a implements f {
    a() {
    }

    public <T> T a(Class<T> cls) {
        com.google.firebase.c.a<T> d = d(cls);
        if (d == null) {
            return null;
        }
        return d.get();
    }

    public <T> Set<T> c(Class<T> cls) {
        return b(cls).get();
    }
}
