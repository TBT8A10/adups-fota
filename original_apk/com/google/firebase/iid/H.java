package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class H implements Executor {

    /* renamed from: a  reason: collision with root package name */
    static final Executor f2373a = new H();

    private H() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
