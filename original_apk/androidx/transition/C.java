package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: GhostViewApi21 */
class C implements D {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f1201a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1202b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f1203c;
    private static boolean d;
    private static Method e;
    private static boolean f;
    private final View g;

    private C(View view) {
        this.g = view;
    }

    static D a(View view, ViewGroup viewGroup, Matrix matrix) {
        a();
        Method method = f1203c;
        if (method != null) {
            try {
                return new C((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void b() {
        if (!f1202b) {
            try {
                f1201a = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e2) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
            }
            f1202b = true;
        }
    }

    private static void c() {
        if (!f) {
            try {
                b();
                e = f1201a.getDeclaredMethod("removeGhost", new Class[]{View.class});
                e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
            }
            f = true;
        }
    }

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i) {
        this.g.setVisibility(i);
    }

    static void a(View view) {
        c();
        Method method = e;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{view});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private static void a() {
        if (!d) {
            try {
                b();
                f1203c = f1201a.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                f1203c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
            }
            d = true;
        }
    }
}
