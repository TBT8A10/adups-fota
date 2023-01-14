package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.firebase.iid.s  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class C0196s {

    /* renamed from: a  reason: collision with root package name */
    private static C0196s f2431a;

    /* renamed from: b  reason: collision with root package name */
    private String f2432b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f2433c = null;
    private Boolean d = null;
    private final Queue<Intent> e = new ArrayDeque();

    private C0196s() {
    }

    public static synchronized C0196s a() {
        C0196s sVar;
        synchronized (C0196s.class) {
            if (f2431a == null) {
                f2431a = new C0196s();
            }
            sVar = f2431a;
        }
        return sVar;
    }

    private final synchronized String c(Context context, Intent intent) {
        if (this.f2432b != null) {
            return this.f2432b;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null) {
            if (resolveService.serviceInfo != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (context.getPackageName().equals(serviceInfo.packageName)) {
                    if (serviceInfo.name != null) {
                        if (serviceInfo.name.startsWith(".")) {
                            String valueOf = String.valueOf(context.getPackageName());
                            String valueOf2 = String.valueOf(serviceInfo.name);
                            this.f2432b = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                        } else {
                            this.f2432b = serviceInfo.name;
                        }
                        return this.f2432b;
                    }
                }
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 94 + String.valueOf(str2).length());
                sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                sb.append(str);
                sb.append("/");
                sb.append(str2);
                Log.e("FirebaseInstanceId", sb.toString());
                return null;
            }
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    public final Intent b() {
        return this.e.poll();
    }

    private final int b(Context context, Intent intent) {
        ComponentName componentName;
        String c2 = c(context, intent);
        if (c2 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(c2);
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), c2);
        }
        try {
            if (a(context)) {
                componentName = C0202y.a_shaKey_method2(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e2) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e2);
            return 401;
        } catch (IllegalStateException e3) {
            String valueOf2 = String.valueOf(e3);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            Log.e("FirebaseInstanceId", sb.toString());
            return 402;
        }
    }

    public final int a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        this.e.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return b(context, intent2);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Context context) {
        if (this.f2433c == null) {
            this.f2433c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f2433c.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f2433c.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean b(Context context) {
        if (this.d == null) {
            this.d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f2433c.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.d.booleanValue();
    }
}
