package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.internal.C0152a;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.util.j;
import com.google.android.gms.common.util.k;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.components.v;
import com.google.firebase.d.a;
import com.google.firebase.e.f;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2336a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f2337b = new c();

    /* renamed from: c  reason: collision with root package name */
    static final Map<String, d> f2338c = new a.b.b();
    private final Context d;
    private final String e;
    private final e f;
    private final n g;
    /* access modifiers changed from: private */
    public final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean();
    private final v<a> j;
    private final List<a> k = new CopyOnWriteArrayList();
    private final List<Object> l = new CopyOnWriteArrayList();

    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    public interface a {
        void a(boolean z);
    }

    @TargetApi(14)
    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    private static class b implements C0152a.C0034a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<b> f2342a = new AtomicReference<>();

        private b() {
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (j.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f2342a.get() == null) {
                    b bVar = new b();
                    if (f2342a.compareAndSet((Object) null, bVar)) {
                        C0152a.a(application);
                        C0152a.a().a((C0152a.C0034a) bVar);
                    }
                }
            }
        }

        public void a(boolean z) {
            synchronized (d.f2336a) {
                Iterator it = new ArrayList(d.f2338c.values()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.h.get()) {
                        dVar.a(z);
                    }
                }
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private static final Handler f2343a = new Handler(Looper.getMainLooper());

        private c() {
        }

        public void execute(Runnable runnable) {
            f2343a.post(runnable);
        }
    }

    @TargetApi(24)
    /* renamed from: com.google.firebase.d$d  reason: collision with other inner class name */
    /* compiled from: com.google.firebase:firebase-common@@19.0.0 */
    private static class C0041d extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<C0041d> f2344a = new AtomicReference<>();

        /* renamed from: b  reason: collision with root package name */
        private final Context f2345b;

        public C0041d(Context context) {
            this.f2345b = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f2344a.get() == null) {
                C0041d dVar = new C0041d(context);
                if (f2344a.compareAndSet((Object) null, dVar)) {
                    context.registerReceiver(dVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (d.f2336a) {
                for (d a2 : d.f2338c.values()) {
                    a2.j();
                }
            }
            a();
        }

        public void a() {
            this.f2345b.unregisterReceiver(this);
        }
    }

    protected d(Context context, String str, e eVar) {
        C0178t.a(context);
        this.d = context;
        C0178t.a(str);
        this.e = str;
        C0178t.a(eVar);
        this.f = eVar;
        List<com.google.firebase.components.j> a2 = h.a(context).a();
        this.g = new n(f2337b, a2, e.a(context, Context.class, new Class[0]), e.a(this, d.class, new Class[0]), e.a(eVar, e.class, new Class[0]), f.a_shaKey_method2("fire-android", ""), f.a_shaKey_method2("fire-core", "19.0.0"), com.google.firebase.e.c.b());
        this.j = new v<>(b.a_shaKey_method2(this, context));
    }

    public static d c() {
        d dVar;
        synchronized (f2336a) {
            dVar = f2338c.get("[DEFAULT]");
            if (dVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + k.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return dVar;
    }

    private void i() {
        C0178t.b(!this.i.get(), "FirebaseApp was deleted");
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!androidx.core.d.b.a(this.d)) {
            C0041d.b(this.d);
        } else {
            this.g.a(h());
        }
    }

    public String d() {
        i();
        return this.e;
    }

    public e e() {
        i();
        return this.f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        return this.e.equals(((d) obj).d());
    }

    public String f() {
        return com.google.android.gms.common.util.b.c(d().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.b.c(e().a().getBytes(Charset.defaultCharset()));
    }

    public boolean g() {
        i();
        return this.j.get().a();
    }

    public boolean h() {
        return "[DEFAULT]".equals(d());
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        C0177s.a a2 = C0177s.a((Object) this);
        a2.a("name", this.e);
        a2.a("options", this.f);
        return a2.toString();
    }

    public Context b() {
        i();
        return this.d;
    }

    public static d a(Context context) {
        synchronized (f2336a) {
            if (f2338c.containsKey("[DEFAULT]")) {
                d c2 = c();
                return c2;
            }
            e a2 = e.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            d a3 = a_shaKey_method2(context, a2);
            return a3;
        }
    }

    public static d a(Context context, e eVar) {
        return a(context, eVar, "[DEFAULT]");
    }

    public static d a(Context context, e eVar, String str) {
        d dVar;
        b.b(context);
        String a2 = a(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f2336a) {
            boolean z = !f2338c.containsKey(a2);
            C0178t.b(z, "FirebaseApp name " + a2 + " already exists!");
            C0178t.a_shaKey_method2(context, (Object) "Application context cannot be null.");
            dVar = new d(context, a2, eVar);
            f2338c.put(a2, dVar);
        }
        dVar.j();
        return dVar;
    }

    public <T> T a(Class<T> cls) {
        i();
        return this.g.a((Class) cls);
    }

    static /* synthetic */ a a(d dVar, Context context) {
        return new a(context, dVar.f(), (com.google.firebase.b.c) dVar.g.a(com.google.firebase.b.c.class));
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a a2 : this.k) {
            a2.a(z);
        }
    }

    private static String a(String str) {
        return str.trim();
    }
}
