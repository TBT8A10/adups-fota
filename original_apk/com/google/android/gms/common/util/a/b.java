package com.google.android.gms.common.util.a;

import android.os.Process;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f1952a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1953b;

    public b(Runnable runnable, int i) {
        this.f1952a = runnable;
        this.f1953b = i;
    }

    public final void run() {
        Process.setThreadPriority(this.f1953b);
        this.f1952a.run();
    }
}
