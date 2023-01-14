package com.google.android.gms.common.api.internal;

import a.b.b;
import a.b.d;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import b.a.a.a.d.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.C0152a;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.C0162c;
import com.google.android.gms.common.internal.C0170k;
import com.google.android.gms.common.internal.C0171l;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.util.j;
import com.google.android.gms.internal.base.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.api.internal.b  reason: case insensitive filesystem */
public class C0153b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static final Status f1746a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Status f1747b = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Object f1748c = new Object();
    private static C0153b d;
    /* access modifiers changed from: private */
    public long e = 5000;
    /* access modifiers changed from: private */
    public long f = 120000;
    /* access modifiers changed from: private */
    public long g = 10000;
    /* access modifiers changed from: private */
    public final Context h;
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.a i;
    /* access modifiers changed from: private */
    public final C0170k j;
    private final AtomicInteger k = new AtomicInteger(1);
    private final AtomicInteger l = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<D<?>, a<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    public i n = null;
    /* access modifiers changed from: private */
    public final Set<D<?>> o = new d();
    private final Set<D<?>> p = new d();
    /* access modifiers changed from: private */
    public final Handler q;

    /* renamed from: com.google.android.gms.common.api.internal.b$c */
    private class c implements y, C0162c.C0036c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final a.f f1754a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final D<?> f1755b;

        /* renamed from: c  reason: collision with root package name */
        private C0171l f1756c = null;
        private Set<Scope> d = null;
        /* access modifiers changed from: private */
        public boolean e = false;

        public c(a.f fVar, D<?> d2) {
            this.f1754a = fVar;
            this.f1755b = d2;
        }

        public final void a(ConnectionResult connectionResult) {
            C0153b.this.q.post(new q(this, connectionResult));
        }

        public final void b(ConnectionResult connectionResult) {
            ((a) C0153b.this.m.get(this.f1755b)).b(connectionResult);
        }

        public final void a(C0171l lVar, Set<Scope> set) {
            if (lVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new ConnectionResult(4));
                return;
            }
            this.f1756c = lVar;
            this.d = set;
            a();
        }

        /* access modifiers changed from: private */
        public final void a() {
            C0171l lVar;
            if (this.e && (lVar = this.f1756c) != null) {
                this.f1754a.a_shaKey_method2(lVar, this.d);
            }
        }
    }

    private C0153b(Context context, Looper looper, com.google.android.gms.common.a aVar) {
        this.h = context;
        this.q = new e(looper, this);
        this.i = aVar;
        this.j = new C0170k(aVar);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static C0153b a(Context context) {
        C0153b bVar;
        synchronized (f1748c) {
            if (d == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                d = new C0153b(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.a.a());
            }
            bVar = d;
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(ConnectionResult connectionResult, int i2) {
        return this.i.a(this.h, connectionResult, i2);
    }

    public final void c() {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public boolean handleMessage(Message message) {
        a aVar;
        int i2 = message.what;
        long j2 = 300000;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.g = j2;
                this.q.removeMessages(12);
                for (D<?> obtainMessage : this.m.keySet()) {
                    Handler handler = this.q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.g);
                }
                break;
            case 2:
                E e2 = (E) message.obj;
                Iterator<D<?>> it = e2.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        D next = it.next();
                        a aVar2 = this.m.get(next);
                        if (aVar2 == null) {
                            e2.a(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (aVar2.c()) {
                            e2.a(next, ConnectionResult.f1705a, aVar2.f().b());
                        } else if (aVar2.k() != null) {
                            e2.a(next, aVar2.k(), (String) null);
                        } else {
                            aVar2.a(e2);
                            aVar2.a();
                        }
                    }
                }
            case 3:
                for (a next2 : this.m.values()) {
                    next2.j();
                    next2.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                s sVar = (s) message.obj;
                a aVar3 = this.m.get(sVar.f1773c.c());
                if (aVar3 == null) {
                    a(sVar.f1773c);
                    aVar3 = this.m.get(sVar.f1773c.c());
                }
                if (aVar3.d() && this.l.get() != sVar.f1772b) {
                    sVar.f1771a.a(f1746a);
                    aVar3.h();
                    break;
                } else {
                    aVar3.a(sVar.f1771a);
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        aVar = it2.next();
                        if (aVar.b() == i3) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i3);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                    break;
                } else {
                    String a2 = this.i.a(connectionResult.m());
                    String n2 = connectionResult.n();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(a2).length() + 69 + String.valueOf(n2).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(a2);
                    sb2.append(": ");
                    sb2.append(n2);
                    aVar.a(new Status(17, sb2.toString()));
                    break;
                }
            case 6:
                if (j.a() && (this.h.getApplicationContext() instanceof Application)) {
                    C0152a.a((Application) this.h.getApplicationContext());
                    C0152a.a().a((C0152a.C0034a) new l(this));
                    if (!C0152a.a().a(true)) {
                        this.g = 300000;
                        break;
                    }
                }
                break;
            case 7:
                a((com.google.android.gms.common.api.e<?>) (com.google.android.gms.common.api.e) message.obj);
                break;
            case 9:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).e();
                    break;
                }
                break;
            case 10:
                for (D<?> remove : this.p) {
                    this.m.remove(remove).h();
                }
                this.p.clear();
                break;
            case 11:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).g();
                    break;
                }
                break;
            case 12:
                if (this.m.containsKey(message.obj)) {
                    this.m.get(message.obj).l();
                    break;
                }
                break;
            case 14:
                j jVar = (j) message.obj;
                D<?> b2 = jVar.b();
                if (this.m.containsKey(b2)) {
                    jVar.a().a(Boolean.valueOf(this.m.get(b2).a(false)));
                    break;
                } else {
                    jVar.a().a(false);
                    break;
                }
            case 15:
                C0035b bVar = (C0035b) message.obj;
                if (this.m.containsKey(bVar.f1752a)) {
                    this.m.get(bVar.f1752a).a(bVar);
                    break;
                }
                break;
            case 16:
                C0035b bVar2 = (C0035b) message.obj;
                if (this.m.containsKey(bVar2.f1752a)) {
                    this.m.get(bVar2.f1752a).b(bVar2);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    /* renamed from: com.google.android.gms.common.api.internal.b$a */
    public class a<O extends a.d> implements f, g, H {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<k> f1749a = new LinkedList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final a.f f1750b;

        /* renamed from: c  reason: collision with root package name */
        private final a.b f1751c;
        private final D<O> d;
        private final C0159h e;
        private final Set<E> f = new HashSet();
        private final Map<C0156e<?>, t> g = new HashMap();
        private final int h;
        private final v i;
        private boolean j;
        private final List<C0035b> k = new ArrayList();
        private ConnectionResult l = null;

        public a(com.google.android.gms.common.api.e<O> eVar) {
            this.f1750b = eVar.a_shaKey_method2(C0153b.this.q.getLooper(), (a<O>) this);
            a.f fVar = this.f1750b;
            if (fVar instanceof v) {
                this.f1751c = ((v) fVar).u();
            } else {
                this.f1751c = fVar;
            }
            this.d = eVar.c();
            this.e = new C0159h();
            this.h = eVar.b();
            if (this.f1750b.d()) {
                this.i = eVar.a_shaKey_method2(C0153b.this.h, C0153b.this.q);
            } else {
                this.i = null;
            }
        }

        private final boolean c(ConnectionResult connectionResult) {
            synchronized (C0153b.f1748c) {
                if (C0153b.this.n != null) {
                    if (C0153b.this.o.contains(this.d)) {
                        C0153b.this.n.a_shaKey_method2(connectionResult, this.h);
                        throw null;
                    }
                }
            }
            return false;
        }

        private final void d(ConnectionResult connectionResult) {
            for (E next : this.f) {
                String str = null;
                if (C0177s.a(connectionResult, ConnectionResult.f1705a)) {
                    str = this.f1750b.b();
                }
                next.a(this.d, connectionResult, str);
            }
            this.f.clear();
        }

        /* access modifiers changed from: private */
        public final void m() {
            j();
            d(ConnectionResult.f1705a);
            p();
            Iterator<t> it = this.g.values().iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (a(next.f1774a.b()) != null) {
                    it.remove();
                } else {
                    try {
                        next.f1774a.a_shaKey_method2(this.f1751c, new i());
                    } catch (DeadObjectException unused) {
                        a(1);
                        this.f1750b.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            o();
            q();
        }

        /* access modifiers changed from: private */
        public final void n() {
            j();
            this.j = true;
            this.e.c();
            C0153b.this.q.sendMessageDelayed(Message.obtain(C0153b.this.q, 9, this.d), C0153b.this.e);
            C0153b.this.q.sendMessageDelayed(Message.obtain(C0153b.this.q, 11, this.d), C0153b.this.f);
            C0153b.this.j.a();
        }

        private final void o() {
            ArrayList arrayList = new ArrayList(this.f1749a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                k kVar = (k) obj;
                if (!this.f1750b.isConnected()) {
                    return;
                }
                if (b(kVar)) {
                    this.f1749a.remove(kVar);
                }
            }
        }

        private final void p() {
            if (this.j) {
                C0153b.this.q.removeMessages(11, this.d);
                C0153b.this.q.removeMessages(9, this.d);
                this.j = false;
            }
        }

        private final void q() {
            C0153b.this.q.removeMessages(12, this.d);
            C0153b.this.q.sendMessageDelayed(C0153b.this.q.obtainMessage(12, this.d), C0153b.this.g);
        }

        public final void a(Bundle bundle) {
            if (Looper.myLooper() == C0153b.this.q.getLooper()) {
                m();
            } else {
                C0153b.this.q.post(new m(this));
            }
        }

        public final void b(ConnectionResult connectionResult) {
            C0178t.a(C0153b.this.q);
            this.f1750b.disconnect();
            a(connectionResult);
        }

        public final void e() {
            C0178t.a(C0153b.this.q);
            if (this.j) {
                a();
            }
        }

        public final a.f f() {
            return this.f1750b;
        }

        public final void g() {
            Status status;
            C0178t.a(C0153b.this.q);
            if (this.j) {
                p();
                if (C0153b.this.i.a(C0153b.this.h) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                a(status);
                this.f1750b.disconnect();
            }
        }

        public final void h() {
            C0178t.a(C0153b.this.q);
            a(C0153b.f1746a);
            this.e.b();
            for (C0156e c2 : (C0156e[]) this.g.keySet().toArray(new C0156e[this.g.size()])) {
                a((k) new C(c2, new i()));
            }
            d(new ConnectionResult(4));
            if (this.f1750b.isConnected()) {
                this.f1750b.a((C0162c.e) new o(this));
            }
        }

        public final Map<C0156e<?>, t> i() {
            return this.g;
        }

        public final void j() {
            C0178t.a(C0153b.this.q);
            this.l = null;
        }

        public final ConnectionResult k() {
            C0178t.a(C0153b.this.q);
            return this.l;
        }

        public final boolean l() {
            return a(true);
        }

        private final boolean b(k kVar) {
            if (!(kVar instanceof u)) {
                c(kVar);
                return true;
            }
            u uVar = (u) kVar;
            Feature a2 = a(uVar.b(this));
            if (a2 == null) {
                c(kVar);
                return true;
            } else if (uVar.c(this)) {
                C0035b bVar = new C0035b(this.d, a2, (l) null);
                int indexOf = this.k.indexOf(bVar);
                if (indexOf >= 0) {
                    C0035b bVar2 = this.k.get(indexOf);
                    C0153b.this.q.removeMessages(15, bVar2);
                    C0153b.this.q.sendMessageDelayed(Message.obtain(C0153b.this.q, 15, bVar2), C0153b.this.e);
                    return false;
                }
                this.k.add(bVar);
                C0153b.this.q.sendMessageDelayed(Message.obtain(C0153b.this.q, 15, bVar), C0153b.this.e);
                C0153b.this.q.sendMessageDelayed(Message.obtain(C0153b.this.q, 16, bVar), C0153b.this.f);
                ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
                if (c(connectionResult)) {
                    return false;
                }
                C0153b.this.b(connectionResult, this.h);
                return false;
            } else {
                uVar.a((RuntimeException) new l(a2));
                return false;
            }
        }

        public final void a(int i2) {
            if (Looper.myLooper() == C0153b.this.q.getLooper()) {
                n();
            } else {
                C0153b.this.q.post(new n(this));
            }
        }

        private final void c(k kVar) {
            kVar.a(this.e, d());
            try {
                kVar.a((a<?>) this);
            } catch (DeadObjectException unused) {
                a(1);
                this.f1750b.disconnect();
            }
        }

        public final boolean d() {
            return this.f1750b.d();
        }

        public final void a(ConnectionResult connectionResult) {
            C0178t.a(C0153b.this.q);
            v vVar = this.i;
            if (vVar != null) {
                vVar.d();
            }
            j();
            C0153b.this.j.a();
            d(connectionResult);
            if (connectionResult.m() == 4) {
                a(C0153b.f1747b);
            } else if (this.f1749a.isEmpty()) {
                this.l = connectionResult;
            } else if (!c(connectionResult) && !C0153b.this.b(connectionResult, this.h)) {
                if (connectionResult.m() == 18) {
                    this.j = true;
                }
                if (this.j) {
                    C0153b.this.q.sendMessageDelayed(Message.obtain(C0153b.this.q, 9, this.d), C0153b.this.e);
                    return;
                }
                String a2 = this.d.a();
                StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 38);
                sb.append("API: ");
                sb.append(a2);
                sb.append(" is not available on this device.");
                a(new Status(17, sb.toString()));
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean c() {
            return this.f1750b.isConnected();
        }

        public final void a(k kVar) {
            C0178t.a(C0153b.this.q);
            if (!this.f1750b.isConnected()) {
                this.f1749a.add(kVar);
                ConnectionResult connectionResult = this.l;
                if (connectionResult == null || !connectionResult.p()) {
                    a();
                } else {
                    a(this.l);
                }
            } else if (b(kVar)) {
                q();
            } else {
                this.f1749a.add(kVar);
            }
        }

        public final int b() {
            return this.h;
        }

        /* access modifiers changed from: private */
        public final void b(C0035b bVar) {
            Feature[] b2;
            if (this.k.remove(bVar)) {
                C0153b.this.q.removeMessages(15, bVar);
                C0153b.this.q.removeMessages(16, bVar);
                Feature b3 = bVar.f1753b;
                ArrayList arrayList = new ArrayList(this.f1749a.size());
                for (k kVar : this.f1749a) {
                    if ((kVar instanceof u) && (b2 = ((u) kVar).b(this)) != null && com.google.android.gms.common.util.a.a_shaKey_method2((T[]) b2, b3)) {
                        arrayList.add(kVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    k kVar2 = (k) obj;
                    this.f1749a.remove(kVar2);
                    kVar2.a((RuntimeException) new l(b3));
                }
            }
        }

        public final void a(Status status) {
            C0178t.a(C0153b.this.q);
            for (k a2 : this.f1749a) {
                a2.a(status);
            }
            this.f1749a.clear();
        }

        /* access modifiers changed from: private */
        public final boolean a(boolean z) {
            C0178t.a(C0153b.this.q);
            if (!this.f1750b.isConnected() || this.g.size() != 0) {
                return false;
            }
            if (this.e.a()) {
                if (z) {
                    q();
                }
                return false;
            }
            this.f1750b.disconnect();
            return true;
        }

        public final void a() {
            C0178t.a(C0153b.this.q);
            if (!this.f1750b.isConnected() && !this.f1750b.a()) {
                int a2 = C0153b.this.j.a_shaKey_method2(C0153b.this.h, this.f1750b);
                if (a2 != 0) {
                    a(new ConnectionResult(a2, (PendingIntent) null));
                    return;
                }
                c cVar = new c(this.f1750b, this.d);
                if (this.f1750b.d()) {
                    this.i.a((y) cVar);
                }
                this.f1750b.a((C0162c.C0036c) cVar);
            }
        }

        public final void a(E e2) {
            C0178t.a(C0153b.this.q);
            this.f.add(e2);
        }

        private final Feature a(Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] f2 = this.f1750b.f();
                if (f2 == null) {
                    f2 = new Feature[0];
                }
                b bVar = new b(f2.length);
                for (Feature feature : f2) {
                    bVar.put(feature.m(), Long.valueOf(feature.n()));
                }
                for (Feature feature2 : featureArr) {
                    if (!bVar.containsKey(feature2.m()) || ((Long) bVar.get(feature2.m())).longValue() < feature2.n()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final void a(C0035b bVar) {
            if (!this.k.contains(bVar) || this.j) {
                return;
            }
            if (!this.f1750b.isConnected()) {
                a();
            } else {
                o();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.b$b  reason: collision with other inner class name */
    private static class C0035b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final D<?> f1752a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Feature f1753b;

        private C0035b(D<?> d, Feature feature) {
            this.f1752a = d;
            this.f1753b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof C0035b)) {
                C0035b bVar = (C0035b) obj;
                if (!C0177s.a(this.f1752a, bVar.f1752a) || !C0177s.a(this.f1753b, bVar.f1753b)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return C0177s.a(this.f1752a, this.f1753b);
        }

        public final String toString() {
            C0177s.a a2 = C0177s.a((Object) this);
            a2.a("key", this.f1752a);
            a2.a("feature", this.f1753b);
            return a2.toString();
        }

        /* synthetic */ C0035b(D d, Feature feature, l lVar) {
            this(d, feature);
        }
    }

    private final void a(com.google.android.gms.common.api.e<?> eVar) {
        D<?> c2 = eVar.c();
        a aVar = this.m.get(c2);
        if (aVar == null) {
            aVar = new a(eVar);
            this.m.put(c2, aVar);
        }
        if (aVar.d()) {
            this.p.add(c2);
        }
        aVar.a();
    }

    public final void a(ConnectionResult connectionResult, int i2) {
        if (!b(connectionResult, i2)) {
            Handler handler = this.q;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
        }
    }
}
