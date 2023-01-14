package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.a.a;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class D implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2358a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f2359b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f2360c;
    private final Queue<G> d;
    private B e;
    private boolean f;

    public D(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new a("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private final void b() {
        while (!this.d.isEmpty()) {
            this.d.poll().a();
        }
    }

    public final synchronized void a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
        }
        this.d.add(new G(intent, pendingResult, this.f2360c));
        a();
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.f = false;
        if (!(iBinder instanceof B)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseInstanceId", sb2.toString());
            b();
            return;
        }
        this.e = (B) iBinder;
        a();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        a();
    }

    private D(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.d = new ArrayDeque();
        this.f = false;
        this.f2358a = context.getApplicationContext();
        this.f2359b = new Intent(str).setPackage(this.f2358a.getPackageName());
        this.f2360c = scheduledExecutorService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void a() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "flush queue called"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ab }
        L_0x0011:
            java.util.Queue<com.google.firebase.iid.G> r0 = r6.d     // Catch:{ all -> 0x00ab }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00ab }
            if (r0 != 0) goto L_0x00a9
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "found intent to be delivered"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ab }
        L_0x0028:
            com.google.firebase.iid.B r0 = r6.e     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0051
            com.google.firebase.iid.B r0 = r6.e     // Catch:{ all -> 0x00ab }
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ab }
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "binder is alive, sending the intent."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ab }
        L_0x0043:
            java.util.Queue<com.google.firebase.iid.G> r0 = r6.d     // Catch:{ all -> 0x00ab }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x00ab }
            com.google.firebase.iid.G r0 = (com.google.firebase.iid.G) r0     // Catch:{ all -> 0x00ab }
            com.google.firebase.iid.B r2 = r6.e     // Catch:{ all -> 0x00ab }
            r2.a(r0)     // Catch:{ all -> 0x00ab }
            goto L_0x0011
        L_0x0051:
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ab }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x007a
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r3 = r6.f     // Catch:{ all -> 0x00ab }
            if (r3 != 0) goto L_0x0063
            r3 = 1
            goto L_0x0064
        L_0x0063:
            r3 = 0
        L_0x0064:
            r4 = 39
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
            r5.<init>(r4)     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = "binder is dead. start connection? "
            r5.append(r4)     // Catch:{ all -> 0x00ab }
            r5.append(r3)     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00ab }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ab }
        L_0x007a:
            boolean r0 = r6.f     // Catch:{ all -> 0x00ab }
            if (r0 != 0) goto L_0x00a7
            r6.f = r2     // Catch:{ all -> 0x00ab }
            com.google.android.gms.common.stats.a r0 = com.google.android.gms.common.stats.a.a()     // Catch:{ SecurityException -> 0x009a }
            android.content.Context r2 = r6.f2358a     // Catch:{ SecurityException -> 0x009a }
            android.content.Intent r3 = r6.f2359b     // Catch:{ SecurityException -> 0x009a }
            r4 = 65
            boolean r0 = r0.a(r2, r3, r6, r4)     // Catch:{ SecurityException -> 0x009a }
            if (r0 == 0) goto L_0x0092
            monitor-exit(r6)
            return
        L_0x0092:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "binding to the service failed"
            android.util.Log.e(r0, r2)     // Catch:{ SecurityException -> 0x009a }
            goto L_0x00a2
        L_0x009a:
            r0 = move-exception
            java.lang.String r2 = "FirebaseInstanceId"
            java.lang.String r3 = "Exception while binding the service"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x00ab }
        L_0x00a2:
            r6.f = r1     // Catch:{ all -> 0x00ab }
            r6.b()     // Catch:{ all -> 0x00ab }
        L_0x00a7:
            monitor-exit(r6)
            return
        L_0x00a9:
            monitor-exit(r6)
            return
        L_0x00ab:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x00af
        L_0x00ae:
            throw r0
        L_0x00af:
            goto L_0x00ae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.D.a():void");
    }
}
