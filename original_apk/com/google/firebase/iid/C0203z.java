package com.google.firebase.iid;

import a.b.b;
import android.text.TextUtils;
import android.util.Log;
import b.a.a.a.d.i;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.firebase.iid.z  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0203z {

    /* renamed from: a  reason: collision with root package name */
    private int f2448a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, i<Void>> f2449b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final C0199v f2450c;

    C0203z(C0199v vVar) {
        this.f2450c = vVar;
    }

    private final String b() {
        String a2;
        synchronized (this.f2450c) {
            a2 = this.f2450c.a();
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String[] split = a2.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean a() {
        return b() != null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (a(r5, r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = r4.f2449b.remove(java.lang.Integer.valueOf(r4.f2448a));
        a(r0);
        r4.f2448a++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r2.a(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.firebase.iid.FirebaseInstanceId r5) throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            java.lang.String r0 = r4.b()     // Catch:{ all -> 0x0042 }
            r1 = 1
            if (r0 != 0) goto L_0x0017
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.f()     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0015
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch:{ all -> 0x0042 }
        L_0x0015:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            return r1
        L_0x0017:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            boolean r2 = a(r5, r0)
            if (r2 != 0) goto L_0x0020
            r5 = 0
            return r5
        L_0x0020:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, b.a.a.a.d.i<java.lang.Void>> r2 = r4.f2449b     // Catch:{ all -> 0x003f }
            int r3 = r4.f2448a     // Catch:{ all -> 0x003f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x003f }
            b.a.a.a.d.i r2 = (b.a.a.a.d.i) r2     // Catch:{ all -> 0x003f }
            r4.a((java.lang.String) r0)     // Catch:{ all -> 0x003f }
            int r0 = r4.f2448a     // Catch:{ all -> 0x003f }
            int r0 = r0 + r1
            r4.f2448a = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0000
            r0 = 0
            r2.a(r0)
            goto L_0x0000
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x0042:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x0045:
            throw r5
        L_0x0046:
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.C0203z.a(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    private final synchronized boolean a(String str) {
        synchronized (this.f2450c) {
            String a2 = this.f2450c.a();
            String valueOf = String.valueOf(str);
            if (!a2.startsWith(valueOf.length() != 0 ? ",".concat(valueOf) : new String(","))) {
                return false;
            }
            String valueOf2 = String.valueOf(str);
            this.f2450c.a(a2.substring((valueOf2.length() != 0 ? ",".concat(valueOf2) : new String(",")).length()));
            return true;
        }
    }

    private static boolean a(FirebaseInstanceId firebaseInstanceId, String str) throws IOException {
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c2 = 65535;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85) {
                        if (str2.equals("U")) {
                            c2 = 1;
                        }
                    }
                } else if (str2.equals("S")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    firebaseInstanceId.a(str3);
                    if (FirebaseInstanceId.f()) {
                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                    }
                } else if (c2 == 1) {
                    firebaseInstanceId.b(str3);
                    if (FirebaseInstanceId.f()) {
                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e) {
                if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 53);
                    sb.append("Topic operation failed: ");
                    sb.append(message);
                    sb.append(". Will retry Topic operation.");
                    Log.e("FirebaseInstanceId", sb.toString());
                    return false;
                } else if (e.getMessage() == null) {
                    Log.e("FirebaseInstanceId", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                } else {
                    throw e;
                }
            }
        }
        return true;
    }
}
