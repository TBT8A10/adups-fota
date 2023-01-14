package com.google.firebase.components;

import com.google.android.gms.common.internal.C0178t;
import com.google.firebase.b.a;
import com.google.firebase.b.b;
import com.google.firebase.b.c;
import com.google.firebase.b.d;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
class u implements d, c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> f2325a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<a<?>> f2326b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f2327c;

    u(Executor executor) {
        this.f2327c = executor;
    }

    private synchronized Set<Map.Entry<b<Object>, Executor>> b(a<?> aVar) {
        Map map;
        map = this.f2325a.get(aVar.a());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(com.google.firebase.components.t.a(r1, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = b(r4).iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.firebase.b.a<?> r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.C0178t.a(r4)
            monitor-enter(r3)
            java.util.Queue<com.google.firebase.b.a<?>> r0 = r3.f2326b     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x000f
            java.util.Queue<com.google.firebase.b.a<?>> r0 = r3.f2326b     // Catch:{ all -> 0x0033 }
            r0.add(r4)     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x000f:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            java.util.Set r0 = r3.b(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            java.lang.Runnable r1 = com.google.firebase.components.t.a(r1, r4)
            r2.execute(r1)
            goto L_0x0018
        L_0x0032:
            return
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0036:
            throw r4
        L_0x0037:
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.u.a(com.google.firebase.b.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> void b(java.lang.Class<T> r2, com.google.firebase.b.b<? super T> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.common.internal.C0178t.a(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.internal.C0178t.a(r3)     // Catch:{ all -> 0x0029 }
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.b.b<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.f2325a     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)
            return
        L_0x0011:
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.b.b<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.f2325a     // Catch:{ all -> 0x0029 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0029 }
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0     // Catch:{ all -> 0x0029 }
            r0.remove(r3)     // Catch:{ all -> 0x0029 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0029 }
            if (r3 == 0) goto L_0x0027
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.b.b<java.lang.Object>, java.util.concurrent.Executor>> r3 = r1.f2325a     // Catch:{ all -> 0x0029 }
            r3.remove(r2)     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r1)
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.u.b(java.lang.Class, com.google.firebase.b.b):void");
    }

    public synchronized <T> void a(Class<T> cls, Executor executor, b<? super T> bVar) {
        C0178t.a(cls);
        C0178t.a(bVar);
        C0178t.a(executor);
        if (!this.f2325a.containsKey(cls)) {
            this.f2325a.put(cls, new ConcurrentHashMap());
        }
        this.f2325a.get(cls).put(bVar, executor);
    }

    public <T> void a(Class<T> cls, b<? super T> bVar) {
        a(cls, this.f2327c, bVar);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Queue<a<?>> queue;
        synchronized (this) {
            if (this.f2326b != null) {
                queue = this.f2326b;
                this.f2326b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (a a2 : queue) {
                a(a2);
            }
        }
    }
}
