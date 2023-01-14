package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.iid.b  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0180b {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f2402a = H.f2373a;

    static Executor a() {
        return f2402a;
    }

    static Executor b() {
        return new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), I.f2374a);
    }

    static final /* synthetic */ Thread a(Runnable runnable) {
        return new Thread(runnable, "firebase-iid-executor");
    }
}
