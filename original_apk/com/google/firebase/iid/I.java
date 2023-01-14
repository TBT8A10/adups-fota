package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class I implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadFactory f2374a = new I();

    private I() {
    }

    public final Thread newThread(Runnable runnable) {
        return C0180b.a(runnable);
    }
}
