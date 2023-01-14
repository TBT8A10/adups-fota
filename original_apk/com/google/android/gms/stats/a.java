package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ScheduledExecutorService f1983a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile C0039a f1984b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Object f1985c;
    private final PowerManager.WakeLock d;
    private WorkSource e;
    private final int f;
    private final String g;
    private final String h;
    private final String i;
    private final Context j;
    private boolean k;
    private final Map<String, Integer[]> l;
    private final Set<Future<?>> m;
    private int n;
    private AtomicInteger o;

    /* renamed from: com.google.android.gms.stats.a$a  reason: collision with other inner class name */
    public interface C0039a {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2, String str) {
        this(context, i2, str, (String) null, context == null ? null : context.getPackageName());
    }

    private final List<String> b() {
        return m.a(this.e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r2 == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r13.n == 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        com.google.android.gms.common.stats.d.a().a(r13.j, com.google.android.gms.common.stats.c.a(r13.d, r6), 7, r13.g, r6, (java.lang.String) null, r13.f, b(), r14);
        r13.n++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.o
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.a((java.lang.String) r0)
            java.lang.Object r0 = r13.f1985c
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch:{ all -> 0x0096 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0096 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            int r1 = r13.n     // Catch:{ all -> 0x0096 }
            if (r1 <= 0) goto L_0x0029
        L_0x001a:
            android.os.PowerManager$WakeLock r1 = r13.d     // Catch:{ all -> 0x0096 }
            boolean r1 = r1.isHeld()     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0029
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch:{ all -> 0x0096 }
            r1.clear()     // Catch:{ all -> 0x0096 }
            r13.n = r2     // Catch:{ all -> 0x0096 }
        L_0x0029:
            boolean r1 = r13.k     // Catch:{ all -> 0x0096 }
            r12 = 1
            if (r1 == 0) goto L_0x0056
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch:{ all -> 0x0096 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0096 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0047
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.l     // Catch:{ all -> 0x0096 }
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch:{ all -> 0x0096 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0096 }
            r3[r2] = r4     // Catch:{ all -> 0x0096 }
            r1.put(r6, r3)     // Catch:{ all -> 0x0096 }
            r2 = 1
            goto L_0x0054
        L_0x0047:
            r3 = r1[r2]     // Catch:{ all -> 0x0096 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0096 }
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0096 }
            r1[r2] = r3     // Catch:{ all -> 0x0096 }
        L_0x0054:
            if (r2 != 0) goto L_0x005e
        L_0x0056:
            boolean r1 = r13.k     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x007d
            int r1 = r13.n     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x007d
        L_0x005e:
            com.google.android.gms.common.stats.d r1 = com.google.android.gms.common.stats.d.a()     // Catch:{ all -> 0x0096 }
            android.content.Context r2 = r13.j     // Catch:{ all -> 0x0096 }
            android.os.PowerManager$WakeLock r3 = r13.d     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = com.google.android.gms.common.stats.c.a(r3, r6)     // Catch:{ all -> 0x0096 }
            r4 = 7
            java.lang.String r5 = r13.g     // Catch:{ all -> 0x0096 }
            r7 = 0
            int r8 = r13.f     // Catch:{ all -> 0x0096 }
            java.util.List r9 = r13.b()     // Catch:{ all -> 0x0096 }
            r10 = r14
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0096 }
            int r1 = r13.n     // Catch:{ all -> 0x0096 }
            int r1 = r1 + r12
            r13.n = r1     // Catch:{ all -> 0x0096 }
        L_0x007d:
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            android.os.PowerManager$WakeLock r0 = r13.d
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0095
            java.util.concurrent.ScheduledExecutorService r0 = f1983a
            com.google.android.gms.stats.c r1 = new com.google.android.gms.stats.c
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L_0x0095:
            return
        L_0x0096:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.a.a(long):void");
    }

    private a(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, (String) null, str3, (String) null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private a(Context context, int i2, String str, String str2, String str3, String str4) {
        this.f1985c = this;
        this.k = true;
        this.l = new HashMap();
        this.m = Collections.synchronizedSet(new HashSet());
        this.o = new AtomicInteger(0);
        C0178t.a_shaKey_method2(context, (Object) "WakeLock: context must not be null");
        C0178t.a(str, (Object) "WakeLock: wakeLockName must not be empty");
        this.f = i2;
        this.h = null;
        this.i = null;
        this.j = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.g = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.g = str;
        }
        this.d = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        if (m.a(context)) {
            this.e = m.a_shaKey_method2(context, l.a(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.e;
            if (workSource != null && m.a(this.j)) {
                WorkSource workSource2 = this.e;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.e = workSource;
                }
                try {
                    this.d.setWorkSource(this.e);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (f1983a == null) {
            f1983a = com.google.android.gms.common.a.a.a().a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r1 != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r12.n == 1) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        com.google.android.gms.common.stats.d.a().a(r12.j, com.google.android.gms.common.stats.c.a(r12.d, r6), 8, r12.g, r6, (java.lang.String) null, r12.f, b());
        r12.n--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.o
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L_0x0019
            java.lang.String r0 = r12.g
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = " release without a matched acquire!"
            java.lang.String r0 = r0.concat(r1)
            java.lang.String r1 = "WakeLock"
            android.util.Log.e(r1, r0)
        L_0x0019:
            r0 = 0
            java.lang.String r6 = r12.a((java.lang.String) r0)
            java.lang.Object r0 = r12.f1985c
            monitor-enter(r0)
            boolean r1 = r12.k     // Catch:{ all -> 0x007e }
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L_0x0052
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.l     // Catch:{ all -> 0x007e }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x007e }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0033
        L_0x0031:
            r1 = 0
            goto L_0x0050
        L_0x0033:
            r2 = r1[r11]     // Catch:{ all -> 0x007e }
            int r2 = r2.intValue()     // Catch:{ all -> 0x007e }
            if (r2 != r10) goto L_0x0042
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.l     // Catch:{ all -> 0x007e }
            r1.remove(r6)     // Catch:{ all -> 0x007e }
            r1 = 1
            goto L_0x0050
        L_0x0042:
            r2 = r1[r11]     // Catch:{ all -> 0x007e }
            int r2 = r2.intValue()     // Catch:{ all -> 0x007e }
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x007e }
            r1[r11] = r2     // Catch:{ all -> 0x007e }
            goto L_0x0031
        L_0x0050:
            if (r1 != 0) goto L_0x005a
        L_0x0052:
            boolean r1 = r12.k     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0079
            int r1 = r12.n     // Catch:{ all -> 0x007e }
            if (r1 != r10) goto L_0x0079
        L_0x005a:
            com.google.android.gms.common.stats.d r1 = com.google.android.gms.common.stats.d.a()     // Catch:{ all -> 0x007e }
            android.content.Context r2 = r12.j     // Catch:{ all -> 0x007e }
            android.os.PowerManager$WakeLock r3 = r12.d     // Catch:{ all -> 0x007e }
            java.lang.String r3 = com.google.android.gms.common.stats.c.a(r3, r6)     // Catch:{ all -> 0x007e }
            r4 = 8
            java.lang.String r5 = r12.g     // Catch:{ all -> 0x007e }
            r7 = 0
            int r8 = r12.f     // Catch:{ all -> 0x007e }
            java.util.List r9 = r12.b()     // Catch:{ all -> 0x007e }
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x007e }
            int r1 = r12.n     // Catch:{ all -> 0x007e }
            int r1 = r1 - r10
            r12.n = r1     // Catch:{ all -> 0x007e }
        L_0x0079:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            r12.a((int) r11)
            return
        L_0x007e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            goto L_0x0082
        L_0x0081:
            throw r1
        L_0x0082:
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.a.a():void");
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        if (this.d.isHeld()) {
            try {
                this.d.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.g).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.d.isHeld();
        }
    }

    private final String a(String str) {
        if (this.k) {
            return !TextUtils.isEmpty(str) ? str : this.h;
        }
        return this.h;
    }

    public void a(boolean z) {
        this.d.setReferenceCounted(z);
        this.k = z;
    }
}
