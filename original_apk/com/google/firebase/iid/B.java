package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class B extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final E f2357a;

    public B(E e) {
        this.f2357a = e;
    }

    /* access modifiers changed from: package-private */
    public final void a(G g) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            this.f2357a.a(g.f2370a).a_shaKey_method2(C0180b.a(), new A(g));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
