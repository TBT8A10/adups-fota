package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.firebase.components.e;
import com.google.firebase.components.i;
import com.google.firebase.components.j;
import com.google.firebase.components.q;
import com.google.firebase.d;
import com.google.firebase.e.f;
import com.google.firebase.e.g;
import java.util.Arrays;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class Registrar implements j {

    /* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
    private static class a implements com.google.firebase.iid.a.a {

        /* renamed from: a  reason: collision with root package name */
        private final FirebaseInstanceId f2389a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.f2389a = firebaseInstanceId;
        }
    }

    @Keep
    public final List<e<?>> getComponents() {
        e.a<FirebaseInstanceId> a2 = e.a(FirebaseInstanceId.class);
        a2.a(q.a(d.class));
        a2.a(q.a(com.google.firebase.b.d.class));
        a2.a(q.a(g.class));
        a2.a((i<FirebaseInstanceId>) C0191m.f2422a);
        a2.a();
        e<FirebaseInstanceId> b2 = a2.b();
        e.a<com.google.firebase.iid.a.a> a3 = e.a(com.google.firebase.iid.a.a.class);
        a3.a(q.a(FirebaseInstanceId.class));
        a3.a((i<com.google.firebase.iid.a.a>) C0192n.f2423a);
        return Arrays.asList(new e[]{b2, a3.b(), f.a_shaKey_method2("fire-iid", "20.0.0")});
    }
}
