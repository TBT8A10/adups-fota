package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.j;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.a  reason: case insensitive filesystem */
public final class C0152a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0152a f1743a = new C0152a();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f1744b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f1745c = new AtomicBoolean();
    private final ArrayList<C0034a> d = new ArrayList<>();
    private boolean e = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a  reason: collision with other inner class name */
    public interface C0034a {
        void a(boolean z);
    }

    private C0152a() {
    }

    public static C0152a a() {
        return f1743a;
    }

    public final boolean b() {
        return this.f1744b.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f1744b.compareAndSet(true, false);
        this.f1745c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f1744b.compareAndSet(true, false);
        this.f1745c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f1744b.compareAndSet(false, true)) {
            this.f1745c.set(true);
            b(true);
        }
    }

    public static void a(Application application) {
        synchronized (f1743a) {
            if (!f1743a.e) {
                application.registerActivityLifecycleCallbacks(f1743a);
                application.registerComponentCallbacks(f1743a);
                f1743a.e = true;
            }
        }
    }

    private final void b(boolean z) {
        synchronized (f1743a) {
            ArrayList<C0034a> arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                C0034a aVar = arrayList.get(i);
                i++;
                aVar.a(z);
            }
        }
    }

    @TargetApi(16)
    public final boolean a(boolean z) {
        if (!this.f1745c.get()) {
            if (!j.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f1745c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f1744b.set(true);
            }
        }
        return b();
    }

    public final void a(C0034a aVar) {
        synchronized (f1743a) {
            this.d.add(aVar);
        }
    }
}
