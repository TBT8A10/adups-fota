package com.google.android.gms.common;

import android.content.Context;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1808a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Context f1809b;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void a(android.content.Context r2) {
        /*
            java.lang.Class<com.google.android.gms.common.i> r0 = com.google.android.gms.common.i.class
            monitor-enter(r0)
            android.content.Context r1 = f1809b     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0011
            if (r2 == 0) goto L_0x0018
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001a }
            f1809b = r2     // Catch:{ all -> 0x001a }
            monitor-exit(r0)
            return
        L_0x0011:
            java.lang.String r2 = "GoogleCertificates"
            java.lang.String r1 = "GoogleCertificates has been initialized already"
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r0)
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.a(android.content.Context):void");
    }
}
