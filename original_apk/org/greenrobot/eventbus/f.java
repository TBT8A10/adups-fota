package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.a.b;
import org.greenrobot.eventbus.i;
import org.greenrobot.eventbus.j;

/* compiled from: EventBusBuilder */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f2537a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    boolean f2538b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f2539c = true;
    boolean d = true;
    boolean e = true;
    boolean f;
    boolean g = true;
    boolean h;
    boolean i;
    ExecutorService j = f2537a;
    List<b> k;
    i l;
    j m;

    f() {
    }

    /* access modifiers changed from: package-private */
    public Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public i b() {
        i iVar = this.l;
        if (iVar != null) {
            return iVar;
        }
        return (!i.a.a() || a() == null) ? new i.b() : new i.a("EventBus");
    }

    /* access modifiers changed from: package-private */
    public j c() {
        Object a2;
        j jVar = this.m;
        if (jVar != null) {
            return jVar;
        }
        if (!i.a.a() || (a2 = a()) == null) {
            return null;
        }
        return new j.a((Looper) a2);
    }
}
