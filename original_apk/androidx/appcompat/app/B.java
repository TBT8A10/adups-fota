package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: ResourcesFlusher */
class B {

    /* renamed from: a  reason: collision with root package name */
    private static Field f97a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f98b;

    /* renamed from: c  reason: collision with root package name */
    private static Class f99c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;

    static void a(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            if (i >= 24) {
                d(resources);
            } else if (i >= 23) {
                c(resources);
            } else if (i >= 21) {
                b(resources);
            }
        }
    }

    private static void b(Resources resources) {
        Map map;
        if (!f98b) {
            try {
                f97a = Resources.class.getDeclaredField("mDrawableCache");
                f97a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f98b = true;
        }
        Field field = f97a;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(Resources resources) {
        if (!f98b) {
            try {
                f97a = Resources.class.getDeclaredField("mDrawableCache");
                f97a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f98b = true;
        }
        Object obj = null;
        Field field = f97a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj != null) {
            a(obj);
        }
    }

    private static void d(Resources resources) {
        Object obj;
        if (!h) {
            try {
                g = Resources.class.getDeclaredField("mResourcesImpl");
                g.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            h = true;
        }
        Field field = g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e3);
                obj = null;
            }
            if (obj != null) {
                if (!f98b) {
                    try {
                        f97a = obj.getClass().getDeclaredField("mDrawableCache");
                        f97a.setAccessible(true);
                    } catch (NoSuchFieldException e4) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
                    }
                    f98b = true;
                }
                Field field2 = f97a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e5) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
                    }
                }
                if (obj2 != null) {
                    a(obj2);
                }
            }
        }
    }

    private static void a(Object obj) {
        LongSparseArray longSparseArray;
        if (!d) {
            try {
                f99c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            d = true;
        }
        Class cls = f99c;
        if (cls != null) {
            if (!f) {
                try {
                    e = cls.getDeclaredField("mUnthemedEntries");
                    e.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }
}
