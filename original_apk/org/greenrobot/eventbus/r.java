package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.greenrobot.eventbus.a.b;

/* compiled from: SubscriberMethodFinder */
class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, List<q>> f2559a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final a[] f2560b = new a[4];

    /* renamed from: c  reason: collision with root package name */
    private List<b> f2561c;
    private final boolean d;
    private final boolean e;

    r(List<b> list, boolean z, boolean z2) {
        this.f2561c = list;
        this.d = z;
        this.e = z2;
    }

    private List<q> b(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f != null) {
            a2.h = c(a2);
            org.greenrobot.eventbus.a.a aVar = a2.h;
            if (aVar != null) {
                for (q qVar : aVar.a()) {
                    if (a2.a(qVar.f2556a, qVar.f2558c)) {
                        a2.f2562a.add(qVar);
                    }
                }
            } else {
                a(a2);
            }
            a2.a();
        }
        return b(a2);
    }

    private org.greenrobot.eventbus.a.a c(a aVar) {
        org.greenrobot.eventbus.a.a aVar2 = aVar.h;
        if (!(aVar2 == null || aVar2.c() == null)) {
            org.greenrobot.eventbus.a.a c2 = aVar.h.c();
            if (aVar.f == c2.b()) {
                return c2;
            }
        }
        List<b> list = this.f2561c;
        if (list == null) {
            return null;
        }
        for (b a2 : list) {
            org.greenrobot.eventbus.a.a a3 = a2.a(aVar.f);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<q> a(Class<?> cls) {
        List<q> list;
        List<q> list2 = f2559a.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.e) {
            list = c(cls);
        } else {
            list = b(cls);
        }
        if (!list.isEmpty()) {
            f2559a.put(cls, list);
            return list;
        }
        throw new g("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* compiled from: SubscriberMethodFinder */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<q> f2562a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final Map<Class, Object> f2563b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        final Map<String, Class> f2564c = new HashMap();
        final StringBuilder d = new StringBuilder(CpioConstants.C_IWUSR);
        Class<?> e;
        Class<?> f;
        boolean g;
        org.greenrobot.eventbus.a.a h;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(Class<?> cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2562a.clear();
            this.f2563b.clear();
            this.f2564c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
            this.h = null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Method method, Class<?> cls) {
            Object put = this.f2563b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f2563b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f2564c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f2564c.put(sb2, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.g) {
                this.f = null;
                return;
            }
            this.f = this.f.getSuperclass();
            String name = this.f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f = null;
            }
        }
    }

    private List<q> c(Class<?> cls) {
        a a2 = a();
        a2.a(cls);
        while (a2.f != null) {
            a(a2);
            a2.a();
        }
        return b(a2);
    }

    private a a() {
        synchronized (f2560b) {
            for (int i = 0; i < 4; i++) {
                a aVar = f2560b[i];
                if (aVar != null) {
                    f2560b[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    private List<q> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f2562a);
        aVar.b();
        synchronized (f2560b) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                } else if (f2560b[i] == null) {
                    f2560b[i] = aVar;
                    break;
                } else {
                    i++;
                }
            }
        }
        return arrayList;
    }

    private void a(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f.getMethods();
            aVar.g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    o oVar = (o) method.getAnnotation(o.class);
                    if (oVar != null) {
                        Class cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f2562a.add(new q(method, cls, oVar.threadMode(), oVar.priority(), oVar.sticky()));
                        }
                    }
                } else if (this.d && method.isAnnotationPresent(o.class)) {
                    throw new g("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.d && method.isAnnotationPresent(o.class)) {
                throw new g((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }
}
