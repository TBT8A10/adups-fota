package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* renamed from: com.google.firebase.iid.x  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0201x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f2442a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f2443b = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f2444c;
    private final C0203z d;

    C0201x(FirebaseInstanceId firebaseInstanceId, C0189k kVar, C0203z zVar, long j) {
        this.f2444c = firebaseInstanceId;
        this.d = zVar;
        this.f2442a = j;
        this.f2443b.setReferenceCounted(false);
    }

    private final boolean c() throws IOException {
        C0198u d2 = this.f2444c.d();
        if (!this.f2444c.a(d2)) {
            return true;
        }
        try {
            String e = this.f2444c.e();
            if (e == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((d2 == null || (d2 != null && !e.equals(d2.f2436b))) && "[DEFAULT]".equals(this.f2444c.c().d())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.f2444c.c().d());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", e);
                Context a2 = a();
                Intent intent2 = new Intent(a2, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e2) {
            if ("SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                Log.e("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else if (e2.getMessage() == null) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                Log.e("FirebaseInstanceId", sb.toString());
                return false;
            } else {
                throw e2;
            }
        } catch (SecurityException unused) {
            Log.e("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f2444c.c().b();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        if (C0196s.a().a(a())) {
            this.f2443b.acquire();
        }
        try {
            this.f2444c.a(true);
            if (!this.f2444c.h()) {
                this.f2444c.a(false);
                if (C0196s.a().a(a())) {
                    this.f2443b.release();
                }
            } else if (!C0196s.a().b(a()) || b()) {
                if (!c() || !this.d.a(this.f2444c)) {
                    this.f2444c.a(this.f2442a);
                } else {
                    this.f2444c.a(false);
                }
                if (C0196s.a().a(a())) {
                    this.f2443b.release();
                }
            } else {
                new C0200w(this).a();
                if (C0196s.a().a(a())) {
                    this.f2443b.release();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.f2444c.a(false);
            if (C0196s.a().a(a())) {
                this.f2443b.release();
            }
        } catch (Throwable th) {
            if (C0196s.a().a(a())) {
                this.f2443b.release();
            }
            throw th;
        }
    }
}
