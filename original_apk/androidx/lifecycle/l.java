package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class, Integer> f919a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class, List<Constructor<? extends d>>> f920b = new HashMap();

    static e a(Object obj) {
        if (obj instanceof b) {
            return new FullLifecycleObserverAdapter((b) obj);
        }
        if (obj instanceof e) {
            return (e) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f920b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        d[] dVarArr = new d[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dVarArr[i] = a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(dVarArr);
    }

    private static int b(Class<?> cls) {
        if (f919a.containsKey(cls)) {
            return f919a.get(cls).intValue();
        }
        int d = d(cls);
        f919a.put(cls, Integer.valueOf(d));
        return d;
    }

    private static boolean c(Class<?> cls) {
        return cls != null && g.class.isAssignableFrom(cls);
    }

    private static int d(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends d> a2 = a(cls);
        if (a2 != null) {
            f920b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (a.f903a.b(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (c(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f920b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (c(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f920b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f920b.put(cls, arrayList);
            return 2;
        }
    }

    private static d a(Constructor<? extends d> constructor, Object obj) {
        try {
            return (d) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends d> a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor<?> declaredConstructor = Class.forName(a2).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
