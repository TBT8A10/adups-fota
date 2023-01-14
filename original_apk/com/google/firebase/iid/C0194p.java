package com.google.firebase.iid;

import a.b.b;
import android.util.Pair;
import b.a.a.a.d.h;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.firebase.iid.p  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0194p {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2426a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Pair<String, String>, h<C0179a>> f2427b = new b();

    C0194p(Executor executor) {
        this.f2426a = executor;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized b.a.a.a.d.h<com.google.firebase.iid.C0179a> a(java.lang.String r4, java.lang.String r5, com.google.firebase.iid.r r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0081 }
            r0.<init>(r4, r5)     // Catch:{ all -> 0x0081 }
            java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, b.a.a.a.d.h<com.google.firebase.iid.a>> r4 = r3.f2427b     // Catch:{ all -> 0x0081 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x0081 }
            b.a.a.a.d.h r4 = (b.a.a.a.d.h) r4     // Catch:{ all -> 0x0081 }
            r5 = 3
            if (r4 == 0) goto L_0x003f
            java.lang.String r6 = "FirebaseInstanceId"
            boolean r5 = android.util.Log.isLoggable(r6, r5)     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x003d
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0081 }
            int r0 = r0.length()     // Catch:{ all -> 0x0081 }
            int r0 = r0 + 29
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r1.<init>(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "Joining ongoing request for: "
            r1.append(r0)     // Catch:{ all -> 0x0081 }
            r1.append(r6)     // Catch:{ all -> 0x0081 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0081 }
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x0081 }
        L_0x003d:
            monitor-exit(r3)
            return r4
        L_0x003f:
            java.lang.String r4 = "FirebaseInstanceId"
            boolean r4 = android.util.Log.isLoggable(r4, r5)     // Catch:{ all -> 0x0081 }
            if (r4 == 0) goto L_0x006b
            java.lang.String r4 = "FirebaseInstanceId"
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0081 }
            int r1 = r1.length()     // Catch:{ all -> 0x0081 }
            int r1 = r1 + 24
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r2.<init>(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "Making new request for: "
            r2.append(r1)     // Catch:{ all -> 0x0081 }
            r2.append(r5)     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0081 }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0081 }
        L_0x006b:
            b.a.a.a.d.h r4 = r6.a()     // Catch:{ all -> 0x0081 }
            java.util.concurrent.Executor r5 = r3.f2426a     // Catch:{ all -> 0x0081 }
            com.google.firebase.iid.o r6 = new com.google.firebase.iid.o     // Catch:{ all -> 0x0081 }
            r6.<init>(r3, r0)     // Catch:{ all -> 0x0081 }
            b.a.a.a.d.h r4 = r4.b(r5, r6)     // Catch:{ all -> 0x0081 }
            java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, b.a.a.a.d.h<com.google.firebase.iid.a>> r5 = r3.f2427b     // Catch:{ all -> 0x0081 }
            r5.put(r0, r4)     // Catch:{ all -> 0x0081 }
            monitor-exit(r3)
            return r4
        L_0x0081:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C0194p.a(java.lang.String, java.lang.String, com.google.firebase.iid.r):b.a.a.a.d.h");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ h a(Pair pair, h hVar) throws Exception {
        synchronized (this) {
            this.f2427b.remove(pair);
        }
        return hVar;
    }
}
