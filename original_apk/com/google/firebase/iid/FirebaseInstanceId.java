package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import b.a.a.a.d.h;
import b.a.a.a.d.k;
import com.google.firebase.b.b;
import com.google.firebase.d;
import com.google.firebase.e.g;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public class FirebaseInstanceId {

    /* renamed from: a  reason: collision with root package name */
    private static final long f2363a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b  reason: collision with root package name */
    private static C0199v f2364b;

    /* renamed from: c  reason: collision with root package name */
    private static ScheduledExecutorService f2365c;
    private final Executor d;
    /* access modifiers changed from: private */
    public final d e;
    private final C0189k f;
    private final P g;
    private final C0194p h;
    private final C0203z i;
    private boolean j;
    private final a k;

    FirebaseInstanceId(d dVar, com.google.firebase.b.d dVar2, g gVar) {
        this(dVar, new C0189k(dVar.b()), C0180b.b(), C0180b.b(), dVar2, gVar);
    }

    public static FirebaseInstanceId a() {
        return getInstance(d.c());
    }

    static boolean f() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    @Keep
    public static FirebaseInstanceId getInstance(d dVar) {
        return (FirebaseInstanceId) dVar.a(FirebaseInstanceId.class);
    }

    /* access modifiers changed from: private */
    public final void k() {
        if (a(d()) || this.i.a()) {
            l();
        }
    }

    private final synchronized void l() {
        if (!this.j) {
            a(0);
        }
    }

    private static String m() {
        return f2364b.b("").a();
    }

    public h<C0179a> b() {
        return b(C0189k.a(this.e), "*");
    }

    /* access modifiers changed from: package-private */
    public final d c() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final C0198u d() {
        return c(C0189k.a(this.e), "*");
    }

    /* access modifiers changed from: package-private */
    public final String e() throws IOException {
        return a(C0189k.a(this.e), "*");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void g() {
        f2364b.b();
        if (this.k.a()) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.f.a() != 0;
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        f2364b.c("");
        l();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void j() {
        if (this.k.a()) {
            k();
        }
    }

    private final h<C0179a> b(String str, String str2) {
        return k.a(null).b(this.d, new K(this, str, c(str2)));
    }

    private static C0198u c(String str, String str2) {
        return f2364b.a("", str, str2);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(boolean z) {
        this.j = z;
    }

    private static String c(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(long j2) {
        a((Runnable) new C0201x(this, this.f, this.i, Math.min(Math.max(30, j2 << 1), f2363a)), j2);
        this.j = true;
    }

    /* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
    private class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2366a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.firebase.b.d f2367b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2368c;
        private b<com.google.firebase.a> d;
        private Boolean e;

        a(com.google.firebase.b.d dVar) {
            this.f2367b = dVar;
        }

        private final synchronized void b() {
            if (!this.f2368c) {
                this.f2366a = d();
                this.e = c();
                if (this.e == null && this.f2366a) {
                    this.d = new O(this);
                    this.f2367b.a_shaKey_method2(com.google.firebase.a.class, this.d);
                }
                this.f2368c = true;
            }
        }

        private final Boolean c() {
            ApplicationInfo applicationInfo;
            Context b2 = FirebaseInstanceId.this.e.b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = b2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(b2.getPackageName(), CpioConstants.C_IWUSR)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean d() {
            try {
                Class.forName("com.google.firebase.messaging.a");
                return true;
            } catch (ClassNotFoundException unused) {
                Context b2 = FirebaseInstanceId.this.e.b();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(b2.getPackageName());
                ResolveInfo resolveService = b2.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean a() {
            b();
            if (this.e == null) {
                return this.f2366a && FirebaseInstanceId.this.e.g();
            }
            return this.e.booleanValue();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void a(boolean z) {
            b();
            if (this.d != null) {
                this.f2367b.b(com.google.firebase.a.class, this.d);
                this.d = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.e.b().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.k();
            }
            this.e = Boolean.valueOf(z);
        }
    }

    private FirebaseInstanceId(d dVar, C0189k kVar, Executor executor, Executor executor2, com.google.firebase.b.d dVar2, g gVar) {
        this.j = false;
        if (C0189k.a(dVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f2364b == null) {
                    f2364b = new C0199v(dVar.b());
                }
            }
            this.e = dVar;
            this.f = kVar;
            this.g = new P(dVar, kVar, executor, gVar);
            this.d = executor2;
            this.i = new C0203z(f2364b);
            this.k = new a(dVar2);
            this.h = new C0194p(executor);
            executor2.execute(new L(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) throws IOException {
        C0198u d2 = d();
        if (!a(d2)) {
            a(this.g.c(m(), d2.f2436b, str));
            return;
        }
        throw new IOException("token not available");
    }

    static void a(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f2365c == null) {
                f2365c = new ScheduledThreadPoolExecutor(1, new com.google.android.gms.common.util.a.a("FirebaseInstanceId"));
            }
            f2365c.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    public final void b(boolean z) {
        this.k.a(z);
    }

    public String a(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((C0179a) a(b(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    private final <T> T a(h<T> hVar) throws IOException {
        try {
            return k.a(hVar, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    g();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) throws IOException {
        C0198u d2 = d();
        if (!a(d2)) {
            a(this.g.b(m(), d2.f2436b, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(C0198u uVar) {
        return uVar == null || uVar.b(this.f.b());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ h a(String str, String str2, h hVar) throws Exception {
        String m = m();
        C0198u c2 = c(str, str2);
        if (!a(c2)) {
            return k.a(new Z(m, c2.f2436b));
        }
        return this.h.a(str, str2, new N(this, m, str, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ h a(String str, String str2, String str3) {
        return this.g.a(str, str2, str3).a(this.d, new M(this, str2, str3, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ h a(String str, String str2, String str3, String str4) throws Exception {
        f2364b.a("", str, str2, str4, this.f.b());
        return k.a(new Z(str3, str4));
    }
}
