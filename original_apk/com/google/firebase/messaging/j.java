package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final /* synthetic */ class j implements Executor {

    /* renamed from: a  reason: collision with root package name */
    static final Executor f2471a = new j();

    private j() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
