package androidx.lifecycle;

import androidx.lifecycle.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache */
class a {

    /* renamed from: a  reason: collision with root package name */
    static a f903a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, C0018a> f904b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class, Boolean> f905c = new HashMap();

    /* compiled from: ClassesInfoCache */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f908a;

        /* renamed from: b  reason: collision with root package name */
        final Method f909b;

        b(int i, Method method) {
            this.f908a = i;
            this.f909b = method;
            this.f909b.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, f.a aVar, Object obj) {
            try {
                int i = this.f908a;
                if (i == 0) {
                    this.f909b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f909b.invoke(obj, new Object[]{hVar});
                } else if (i == 2) {
                    this.f909b.invoke(obj, new Object[]{hVar, aVar});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f908a != bVar.f908a || !this.f909b.getName().equals(bVar.f909b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f908a * 31) + this.f909b.getName().hashCode();
        }
    }

    a() {
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public C0018a a(Class cls) {
        C0018a aVar = this.f904b.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean b(Class cls) {
        if (this.f905c.containsKey(cls)) {
            return this.f905c.get(cls).booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method annotation : c2) {
            if (((q) annotation.getAnnotation(q.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.f905c.put(cls, false);
        return false;
    }

    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    static class C0018a {

        /* renamed from: a  reason: collision with root package name */
        final Map<f.a, List<b>> f906a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, f.a> f907b;

        C0018a(Map<b, f.a> map) {
            this.f907b = map;
            for (Map.Entry next : map.entrySet()) {
                f.a aVar = (f.a) next.getValue();
                List list = this.f906a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f906a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, f.a aVar, Object obj) {
            a(this.f906a.get(aVar), hVar, aVar, obj);
            a(this.f906a.get(f.a.ON_ANY), hVar, aVar, obj);
        }

        private static void a(List<b> list, h hVar, f.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(hVar, aVar, obj);
                }
            }
        }
    }

    private void a(Map<b, f.a> map, b bVar, f.a aVar, Class cls) {
        f.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f909b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private C0018a a(Class cls, Method[] methodArr) {
        int i;
        C0018a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a2 = a(superclass)) == null)) {
            hashMap.putAll(a2.f907b);
        }
        for (Class a3 : cls.getInterfaces()) {
            for (Map.Entry next : a(a3).f907b.entrySet()) {
                a(hashMap, (b) next.getKey(), (f.a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            q qVar = (q) method.getAnnotation(q.class);
            if (qVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(h.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                f.a value = qVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(f.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == f.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0018a aVar = new C0018a(hashMap);
        this.f904b.put(cls, aVar);
        this.f905c.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
