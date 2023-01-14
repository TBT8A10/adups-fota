package com.google.firebase.e;

import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.google.firebase.components.i;
import com.google.firebase.components.q;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final String f2352a;

    /* renamed from: b  reason: collision with root package name */
    private final d f2353b;

    c(Set<e> set, d dVar) {
        this.f2352a = a(set);
        this.f2353b = dVar;
    }

    public static e<g> b() {
        e.a<g> a2 = e.a(g.class);
        a2.a(q.b(e.class));
        a2.a((i<g>) b.a());
        return a2.b();
    }

    public String a() {
        if (this.f2353b.b().isEmpty()) {
            return this.f2352a;
        }
        return this.f2352a + ' ' + a(this.f2353b.b());
    }

    private static String a(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb.append(next.a());
            sb.append('/');
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    static /* synthetic */ g a(f fVar) {
        return new c(fVar.c(e.class), d.a());
    }
}
