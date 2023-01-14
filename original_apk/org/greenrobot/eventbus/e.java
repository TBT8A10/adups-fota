package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.a.b;

/* compiled from: EventBus */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static volatile e f2531a;

    /* renamed from: b  reason: collision with root package name */
    private static final f f2532b = new f();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f2533c = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<s>> d;
    private final Map<Object, List<Class<?>>> e;
    private final Map<Class<?>, Object> f;
    private final ThreadLocal<a> g;
    private final j h;
    private final n i;
    private final b j;
    private final a k;
    private final r l;
    private final ExecutorService m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;
    private final i u;

    /* compiled from: EventBus */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Object> f2534a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        boolean f2535b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2536c;
        s d;
        Object e;
        boolean f;

        a() {
        }
    }

    public e() {
        this(f2532b);
    }

    public static e a() {
        if (f2531a == null) {
            synchronized (e.class) {
                if (f2531a == null) {
                    f2531a = new e();
                }
            }
        }
        return f2531a;
    }

    private void b(s sVar, Object obj) {
        if (obj != null) {
            a(sVar, obj, d());
        }
    }

    private boolean d() {
        j jVar = this.h;
        if (jVar != null) {
            return jVar.a();
        }
        return true;
    }

    public void c(Object obj) {
        List<q> a2 = this.l.a(obj.getClass());
        synchronized (this) {
            for (q a3 : a2) {
                a(obj, a3);
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }

    e(f fVar) {
        this.g = new c(this);
        this.u = fVar.b();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new ConcurrentHashMap();
        this.h = fVar.c();
        j jVar = this.h;
        this.i = jVar != null ? jVar.a(this) : null;
        this.j = new b(this);
        this.k = new a(this);
        List<b> list = fVar.k;
        this.t = list != null ? list.size() : 0;
        this.l = new r(fVar.k, fVar.i, fVar.h);
        this.o = fVar.f2538b;
        this.p = fVar.f2539c;
        this.q = fVar.d;
        this.r = fVar.e;
        this.n = fVar.f;
        this.s = fVar.g;
        this.m = fVar.j;
    }

    public void b(Object obj) {
        a aVar = this.g.get();
        List<Object> list = aVar.f2534a;
        list.add(obj);
        if (!aVar.f2535b) {
            aVar.f2536c = d();
            aVar.f2535b = true;
            if (!aVar.f) {
                while (!list.isEmpty()) {
                    try {
                        a(list.remove(0), aVar);
                    } finally {
                        aVar.f2535b = false;
                        aVar.f2536c = false;
                    }
                }
                return;
            }
            throw new g("Internal error. Abort state was not reset");
        }
    }

    public synchronized void d(Object obj) {
        List<Class> list = this.e.get(obj);
        if (list != null) {
            for (Class a2 : list) {
                a(obj, (Class<?>) a2);
            }
            this.e.remove(obj);
        } else {
            i iVar = this.u;
            Level level = Level.WARNING;
            iVar.a(level, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    private void a(Object obj, q qVar) {
        Class<?> cls = qVar.f2558c;
        s sVar = new s(obj, qVar);
        CopyOnWriteArrayList copyOnWriteArrayList = this.d.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.d.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(sVar)) {
            throw new g("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || qVar.d > ((s) copyOnWriteArrayList.get(i2)).f2566b.d) {
                copyOnWriteArrayList.add(i2, sVar);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, sVar);
        List list = this.e.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.e.put(obj, list);
        }
        list.add(cls);
        if (!qVar.e) {
            return;
        }
        if (this.s) {
            for (Map.Entry next : this.f.entrySet()) {
                if (cls.isAssignableFrom((Class) next.getKey())) {
                    b(sVar, next.getValue());
                }
            }
            return;
        }
        b(sVar, this.f.get(cls));
    }

    public i c() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public ExecutorService b() {
        return this.m;
    }

    public synchronized boolean a(Object obj) {
        return this.e.containsKey(obj);
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.d.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                s sVar = (s) list.get(i2);
                if (sVar.f2565a == obj) {
                    sVar.f2567c = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    private void a(Object obj, a aVar) throws Error {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> a2 = a(cls);
            int size = a2.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= a(obj, aVar, a2.get(i2));
            }
        } else {
            z = a(obj, aVar, cls);
        }
        if (!z) {
            if (this.p) {
                i iVar = this.u;
                Level level = Level.FINE;
                iVar.a(level, "No subscribers registered for event " + cls);
            }
            if (this.r && cls != k.class && cls != p.class) {
                b(new k(this, obj));
            }
        }
    }

    private boolean a(Object obj, a aVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.d.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            aVar.e = obj;
            aVar.d = sVar;
            try {
                a(sVar, obj, aVar.f2536c);
                if (aVar.f) {
                    return true;
                }
            } finally {
                aVar.e = null;
                aVar.d = null;
                aVar.f = false;
            }
        }
        return true;
    }

    private void a(s sVar, Object obj, boolean z) {
        int i2 = d.f2530a[sVar.f2566b.f2557b.ordinal()];
        if (i2 == 1) {
            a(sVar, obj);
        } else if (i2 != 2) {
            if (i2 == 3) {
                n nVar = this.i;
                if (nVar != null) {
                    nVar.a(sVar, obj);
                } else {
                    a(sVar, obj);
                }
            } else if (i2 != 4) {
                if (i2 == 5) {
                    this.k.a_shaKey_method2(sVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + sVar.f2566b.f2557b);
            } else if (z) {
                this.j.a(sVar, obj);
            } else {
                a(sVar, obj);
            }
        } else if (z) {
            a(sVar, obj);
        } else {
            this.i.a(sVar, obj);
        }
    }

    private static List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f2533c) {
            list = f2533c.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f2533c.put(cls, list);
            }
        }
        return list;
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(l lVar) {
        Object obj = lVar.f2549b;
        s sVar = lVar.f2550c;
        l.a(lVar);
        if (sVar.f2567c) {
            a(sVar, obj);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(s sVar, Object obj) {
        try {
            sVar.f2566b.f2556a.invoke(sVar.f2565a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            a(sVar, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    private void a(s sVar, Object obj, Throwable th) {
        if (obj instanceof p) {
            if (this.o) {
                i iVar = this.u;
                Level level = Level.SEVERE;
                iVar.a(level, "SubscriberExceptionEvent subscriber " + sVar.f2565a.getClass() + " threw an exception", th);
                p pVar = (p) obj;
                i iVar2 = this.u;
                Level level2 = Level.SEVERE;
                iVar2.a(level2, "Initial event " + pVar.f2555c + " caused exception in " + pVar.d, pVar.f2554b);
            }
        } else if (!this.n) {
            if (this.o) {
                i iVar3 = this.u;
                Level level3 = Level.SEVERE;
                iVar3.a(level3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + sVar.f2565a.getClass(), th);
            }
            if (this.q) {
                b(new p(this, th, obj, sVar.f2565a));
            }
        } else {
            throw new g("Invoking subscriber failed", th);
        }
    }
}
