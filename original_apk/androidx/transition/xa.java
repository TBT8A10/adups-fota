package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi21 */
class xa extends wa {
    private static Method f;
    private static boolean g;
    private static Method h;
    private static boolean i;
    private static Method j;
    private static boolean k;

    xa() {
    }

    private void d() {
        if (!g) {
            try {
                f = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
            }
            g = true;
        }
    }

    private void e() {
        if (!i) {
            try {
                h = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                h.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
            }
            i = true;
        }
    }

    public void a(View view, Matrix matrix) {
        c();
        Method method = j;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (InvocationTargetException unused) {
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void b(View view, Matrix matrix) {
        d();
        Method method = f;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    public void c(View view, Matrix matrix) {
        e();
        Method method = h;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private void c() {
        if (!k) {
            try {
                j = View.class.getDeclaredMethod("setAnimationMatrix", new Class[]{Matrix.class});
                j.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", e);
            }
            k = true;
        }
    }
}
