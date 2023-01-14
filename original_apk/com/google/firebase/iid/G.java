package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class G {

    /* renamed from: a  reason: collision with root package name */
    final Intent f2370a;

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver.PendingResult f2371b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2372c = false;
    private final ScheduledFuture<?> d;

    G(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f2370a = intent;
        this.f2371b = pendingResult;
        this.d = scheduledExecutorService.schedule(new F(this, intent), 9000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.f2372c) {
            this.f2371b.finish();
            this.d.cancel(false);
            this.f2372c = true;
        }
    }
}
