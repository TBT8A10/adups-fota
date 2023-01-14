package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C0168i;
import com.google.android.gms.common.internal.C0173n;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.c  reason: case insensitive filesystem */
public abstract class C0162c<T extends IInterface> {

    /* renamed from: a  reason: collision with root package name */
    private static final Feature[] f1862a = new Feature[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f1863b = {"service_esmobile", "service_googleme"};
    /* access modifiers changed from: private */
    public boolean A = false;
    private volatile zzb B = null;
    protected AtomicInteger C = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private int f1864c;
    private long d;
    private long e;
    private int f;
    private long g;
    private M h;
    private final Context i;
    private final Looper j;
    private final C0168i k;
    private final com.google.android.gms.common.b l;
    final Handler m;
    private final Object n = new Object();
    /* access modifiers changed from: private */
    public final Object o = new Object();
    /* access modifiers changed from: private */
    public C0175p p;
    protected C0036c q;
    private T r;
    /* access modifiers changed from: private */
    public final ArrayList<h<?>> s = new ArrayList<>();
    private j t;
    private int u = 1;
    /* access modifiers changed from: private */
    public final a v;
    /* access modifiers changed from: private */
    public final b w;
    private final int x;
    private final String y;
    /* access modifiers changed from: private */
    public ConnectionResult z = null;

    /* renamed from: com.google.android.gms.common.internal.c$a */
    public interface a {
        void a(int i);

        void a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.c$b */
    public interface b {
        void a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    public interface C0036c {
        void a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.c$d */
    protected class d implements C0036c {
        public d() {
        }

        public void a(ConnectionResult connectionResult) {
            if (connectionResult.q()) {
                C0162c cVar = C0162c.this;
                cVar.a((C0171l) null, cVar.o());
            } else if (C0162c.this.w != null) {
                C0162c.this.w.a(connectionResult);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$e */
    public interface e {
        void a();
    }

    /* renamed from: com.google.android.gms.common.internal.c$f */
    private abstract class f extends h<Boolean> {
        private final int d;
        private final Bundle e;

        protected f(int i, Bundle bundle) {
            super(true);
            this.d = i;
            this.e = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void a(ConnectionResult connectionResult);

        /* JADX WARNING: type inference failed for: r5v11, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void a(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                r0 = 1
                r1 = 0
                if (r5 != 0) goto L_0x000c
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.C0162c.this
                r5.b(r0, null)
                return
            L_0x000c:
                int r5 = r4.d
                if (r5 == 0) goto L_0x0061
                r2 = 10
                if (r5 == r2) goto L_0x0031
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.C0162c.this
                r5.b(r0, null)
                android.os.Bundle r5 = r4.e
                if (r5 == 0) goto L_0x0026
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x0026:
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                int r0 = r4.d
                r5.<init>(r0, r1)
                r4.a((com.google.android.gms.common.ConnectionResult) r5)
                goto L_0x0076
            L_0x0031:
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.C0162c.this
                r5.b(r0, null)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Class r3 = r4.getClass()
                java.lang.String r3 = r3.getSimpleName()
                r1[r2] = r3
                com.google.android.gms.common.internal.c r2 = com.google.android.gms.common.internal.C0162c.this
                java.lang.String r2 = r2.r()
                r1[r0] = r2
                r0 = 2
                com.google.android.gms.common.internal.c r2 = com.google.android.gms.common.internal.C0162c.this
                java.lang.String r2 = r2.q()
                r1[r0] = r2
                java.lang.String r0 = "A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. "
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x0061:
                boolean r5 = r4.e()
                if (r5 != 0) goto L_0x0076
                com.google.android.gms.common.internal.c r5 = com.google.android.gms.common.internal.C0162c.this
                r5.b(r0, null)
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                r0 = 8
                r5.<init>(r0, r1)
                r4.a((com.google.android.gms.common.ConnectionResult) r5)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.C0162c.f.a(java.lang.Object):void");
        }

        /* access modifiers changed from: protected */
        public final void c() {
        }

        /* access modifiers changed from: protected */
        public abstract boolean e();
    }

    /* renamed from: com.google.android.gms.common.internal.c$g */
    final class g extends b.a.a.a.b.a.d {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.c();
            hVar.b();
        }

        private static boolean b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r8) {
            /*
                r7 = this;
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.C
                int r0 = r0.get()
                int r1 = r8.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x0015
                a(r8)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r8.what
                r1 = 4
                r2 = 1
                r3 = 5
                if (r0 == r2) goto L_0x002e
                r4 = 7
                if (r0 == r4) goto L_0x002e
                if (r0 != r1) goto L_0x002a
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                boolean r0 = r0.h()
                if (r0 == 0) goto L_0x002e
            L_0x002a:
                int r0 = r8.what
                if (r0 != r3) goto L_0x003a
            L_0x002e:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                boolean r0 = r0.a()
                if (r0 != 0) goto L_0x003a
                a(r8)
                return
            L_0x003a:
                int r0 = r8.what
                r4 = 8
                r5 = 3
                r6 = 0
                if (r0 != r1) goto L_0x0085
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r1.<init>(r8)
                com.google.android.gms.common.ConnectionResult unused = r0.z = r1
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                boolean r8 = r8.w()
                if (r8 == 0) goto L_0x0064
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                boolean r8 = r8.A
                if (r8 != 0) goto L_0x0064
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                r8.b(r5, null)
                return
            L_0x0064:
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.ConnectionResult r8 = r8.z
                if (r8 == 0) goto L_0x0073
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.ConnectionResult r8 = r8.z
                goto L_0x0078
            L_0x0073:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r4)
            L_0x0078:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.internal.c$c r0 = r0.q
                r0.a(r8)
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                r0.a((com.google.android.gms.common.ConnectionResult) r8)
                return
            L_0x0085:
                if (r0 != r3) goto L_0x00a8
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.ConnectionResult r8 = r8.z
                if (r8 == 0) goto L_0x0096
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.ConnectionResult r8 = r8.z
                goto L_0x009b
            L_0x0096:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r4)
            L_0x009b:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.internal.c$c r0 = r0.q
                r0.a(r8)
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                r0.a((com.google.android.gms.common.ConnectionResult) r8)
                return
            L_0x00a8:
                if (r0 != r5) goto L_0x00c7
                java.lang.Object r0 = r8.obj
                boolean r1 = r0 instanceof android.app.PendingIntent
                if (r1 == 0) goto L_0x00b3
                r6 = r0
                android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            L_0x00b3:
                com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r0.<init>(r8, r6)
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.internal.c$c r8 = r8.q
                r8.a(r0)
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                r8.a((com.google.android.gms.common.ConnectionResult) r0)
                return
            L_0x00c7:
                r1 = 6
                if (r0 != r1) goto L_0x00ef
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                r0.b(r3, null)
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.internal.c$a r0 = r0.v
                if (r0 == 0) goto L_0x00e2
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                com.google.android.gms.common.internal.c$a r0 = r0.v
                int r1 = r8.arg2
                r0.a((int) r1)
            L_0x00e2:
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                int r8 = r8.arg2
                r0.a((int) r8)
                com.google.android.gms.common.internal.c r8 = com.google.android.gms.common.internal.C0162c.this
                boolean unused = r8.a((int) r3, (int) r2, r6)
                return
            L_0x00ef:
                r1 = 2
                if (r0 != r1) goto L_0x00fe
                com.google.android.gms.common.internal.c r0 = com.google.android.gms.common.internal.C0162c.this
                boolean r0 = r0.isConnected()
                if (r0 != 0) goto L_0x00fe
                a(r8)
                return
            L_0x00fe:
                boolean r0 = b(r8)
                if (r0 == 0) goto L_0x010c
                java.lang.Object r8 = r8.obj
                com.google.android.gms.common.internal.c$h r8 = (com.google.android.gms.common.internal.C0162c.h) r8
                r8.d()
                return
            L_0x010c:
                int r8 = r8.what
                r0 = 45
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Don't know how to handle message: "
                r1.append(r0)
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                java.lang.Exception r0 = new java.lang.Exception
                r0.<init>()
                java.lang.String r1 = "GmsClient"
                android.util.Log.wtf(r1, r8, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.C0162c.g.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$h */
    protected abstract class h<TListener> {

        /* renamed from: a  reason: collision with root package name */
        private TListener f1867a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1868b = false;

        public h(TListener tlistener) {
            this.f1867a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f1867a = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void a(TListener tlistener);

        public final void b() {
            a();
            synchronized (C0162c.this.s) {
                C0162c.this.s.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void c();

        public final void d() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f1867a;
                if (this.f1868b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    c();
                    throw e;
                }
            } else {
                c();
            }
            synchronized (this) {
                this.f1868b = true;
            }
            b();
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$i */
    public static final class i extends C0173n.a {

        /* renamed from: a  reason: collision with root package name */
        private C0162c f1870a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1871b;

        public i(C0162c cVar, int i) {
            this.f1870a = cVar;
            this.f1871b = i;
        }

        public final void a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public final void a(int i, IBinder iBinder, Bundle bundle) {
            C0178t.a(this.f1870a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1870a.a(i, iBinder, bundle, this.f1871b);
            this.f1870a = null;
        }

        public final void a(int i, IBinder iBinder, zzb zzb) {
            C0178t.a(this.f1870a, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            C0178t.a(zzb);
            this.f1870a.a(zzb);
            a(i, iBinder, zzb.f1903a);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$j */
    public final class j implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final int f1872a;

        public j(int i) {
            this.f1872a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0175p pVar;
            if (iBinder == null) {
                C0162c.this.c(16);
                return;
            }
            synchronized (C0162c.this.o) {
                C0162c cVar = C0162c.this;
                if (iBinder == null) {
                    pVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof C0175p)) {
                        pVar = new C0174o(iBinder);
                    } else {
                        pVar = (C0175p) queryLocalInterface;
                    }
                }
                C0175p unused = cVar.p = pVar;
            }
            C0162c.this.a(0, (Bundle) null, this.f1872a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (C0162c.this.o) {
                C0175p unused = C0162c.this.p = null;
            }
            Handler handler = C0162c.this.m;
            handler.sendMessage(handler.obtainMessage(6, this.f1872a, 1));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$k */
    protected final class k extends f {
        private final IBinder g;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.g = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void a(ConnectionResult connectionResult) {
            if (C0162c.this.w != null) {
                C0162c.this.w.a(connectionResult);
            }
            C0162c.this.a(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean e() {
            try {
                String interfaceDescriptor = this.g.getInterfaceDescriptor();
                if (!C0162c.this.q().equals(interfaceDescriptor)) {
                    String q = C0162c.this.q();
                    StringBuilder sb = new StringBuilder(String.valueOf(q).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(q);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface a2 = C0162c.this.a(this.g);
                if (a2 == null || (!C0162c.this.a(2, 4, a2) && !C0162c.this.a(3, 4, a2))) {
                    return false;
                }
                ConnectionResult unused = C0162c.this.z = null;
                Bundle k = C0162c.this.k();
                if (C0162c.this.v == null) {
                    return true;
                }
                C0162c.this.v.a(k);
                return true;
            } catch (RemoteException unused2) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$l */
    protected final class l extends f {
        public l(int i, Bundle bundle) {
            super(i, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public final void a(ConnectionResult connectionResult) {
            if (!C0162c.this.h() || !C0162c.this.w()) {
                C0162c.this.q.a(connectionResult);
                C0162c.this.a(connectionResult);
                return;
            }
            C0162c.this.c(16);
        }

        /* access modifiers changed from: protected */
        public final boolean e() {
            C0162c.this.q.a(ConnectionResult.f1705a);
            return true;
        }
    }

    protected C0162c(Context context, Looper looper, C0168i iVar, com.google.android.gms.common.b bVar, int i2, a aVar, b bVar2, String str) {
        C0178t.a_shaKey_method2(context, (Object) "Context must not be null");
        this.i = context;
        C0178t.a_shaKey_method2(looper, (Object) "Looper must not be null");
        this.j = looper;
        C0178t.a(iVar, (Object) "Supervisor must not be null");
        this.k = iVar;
        C0178t.a(bVar, (Object) "API availability must not be null");
        this.l = bVar;
        this.m = new g(looper);
        this.x = i2;
        this.v = aVar;
        this.w = bVar2;
        this.y = str;
    }

    /* access modifiers changed from: private */
    public final void a(zzb zzb) {
        this.B = zzb;
    }

    /* access modifiers changed from: private */
    public final void b(int i2, T t2) {
        M m2;
        C0178t.a((i2 == 4) == (t2 != null));
        synchronized (this.n) {
            this.u = i2;
            this.r = t2;
            a(i2, t2);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (!(this.t == null || this.h == null)) {
                        String c2 = this.h.c();
                        String a2 = this.h.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.k.a(this.h.c(), this.h.a(), this.h.b(), this.t, u());
                        this.C.incrementAndGet();
                    }
                    this.t = new j(this.C.get());
                    if (this.u != 3 || n() == null) {
                        m2 = new M(s(), r(), false, 129);
                    } else {
                        m2 = new M(l().getPackageName(), n(), true, 129);
                    }
                    this.h = m2;
                    if (!this.k.a(new C0168i.a(this.h.c(), this.h.a(), this.h.b()), this.t, u())) {
                        String c3 = this.h.c();
                        String a3 = this.h.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.C.get());
                    }
                } else if (i2 == 4) {
                    a(t2);
                }
            } else if (this.t != null) {
                this.k.a(this.h.c(), this.h.a(), this.h.b(), this.t, u());
                this.t = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        int i3;
        if (v()) {
            i3 = 5;
            this.A = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(i3, this.C.get(), 16));
    }

    private final String u() {
        String str = this.y;
        return str == null ? this.i.getClass().getName() : str;
    }

    private final boolean v() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.u == 3;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public final boolean w() {
        if (this.A || TextUtils.isEmpty(q()) || TextUtils.isEmpty(n())) {
            return false;
        }
        try {
            Class.forName(q());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);

    /* access modifiers changed from: package-private */
    public void a(int i2, T t2) {
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public void disconnect() {
        this.C.incrementAndGet();
        synchronized (this.s) {
            int size = this.s.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.s.get(i2).a();
            }
            this.s.clear();
        }
        synchronized (this.o) {
            this.p = null;
        }
        b(1, (IInterface) null);
    }

    public int e() {
        return com.google.android.gms.common.b.f1789a;
    }

    public final Feature[] f() {
        zzb zzb = this.B;
        if (zzb == null) {
            return null;
        }
        return zzb.f1904b;
    }

    /* access modifiers changed from: protected */
    public final void g() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }

    public abstract Account i();

    public boolean isConnected() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.u == 4;
        }
        return z2;
    }

    public Feature[] j() {
        return f1862a;
    }

    public Bundle k() {
        return null;
    }

    public final Context l() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public Bundle m() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public String n() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract Set<Scope> o();

    public final T p() throws DeadObjectException {
        T t2;
        synchronized (this.n) {
            if (this.u != 5) {
                g();
                C0178t.b(this.r != null, "Client is connected but service is null");
                t2 = this.r;
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    /* access modifiers changed from: protected */
    public abstract String q();

    /* access modifiers changed from: protected */
    public abstract String r();

    /* access modifiers changed from: protected */
    public String s() {
        return "com.google.android.gms";
    }

    public boolean t() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
        this.e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.f1864c = i2;
        this.d = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void a(ConnectionResult connectionResult) {
        this.f = connectionResult.m();
        this.g = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public final boolean a(int i2, int i3, T t2) {
        synchronized (this.n) {
            if (this.u != i2) {
                return false;
            }
            b(i3, t2);
            return true;
        }
    }

    public void a(C0036c cVar) {
        C0178t.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        this.q = cVar;
        b(2, (IInterface) null);
    }

    public boolean a() {
        boolean z2;
        synchronized (this.n) {
            if (this.u != 2) {
                if (this.u != 3) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Bundle bundle, int i3) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, (Bundle) null)));
    }

    public void a(C0171l lVar, Set<Scope> set) {
        Bundle m2 = m();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.x);
        getServiceRequest.d = this.i.getPackageName();
        getServiceRequest.g = m2;
        if (set != null) {
            getServiceRequest.f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (d()) {
            getServiceRequest.h = i() != null ? i() : new Account("<<default account>>", "com.google");
            if (lVar != null) {
                getServiceRequest.e = lVar.asBinder();
            }
        } else if (t()) {
            getServiceRequest.h = i();
        }
        getServiceRequest.i = f1862a;
        getServiceRequest.j = j();
        try {
            synchronized (this.o) {
                if (this.p != null) {
                    this.p.a(new i(this, this.C.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            b(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            a(8, (IBinder) null, (Bundle) null, this.C.get());
        }
    }

    public void b(int i2) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i2));
    }

    public void a(e eVar) {
        eVar.a();
    }

    public String b() {
        M m2;
        if (isConnected() && (m2 = this.h) != null) {
            return m2.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }
}
