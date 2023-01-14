package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewUtils */
class va {

    /* renamed from: a  reason: collision with root package name */
    private static final za f1312a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f1313b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1314c;
    static final Property<View, Float> d = new ta(Float.class, "translationAlpha");
    static final Property<View, Rect> e = new ua(Rect.class, "clipBounds");

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f1312a = new ya();
        } else if (i >= 21) {
            f1312a = new xa();
        } else if (i >= 19) {
            f1312a = new wa();
        } else {
            f1312a = new za();
        }
    }

    static void a(View view, float f) {
        f1312a.a_shaKey_method2(view, f);
    }

    static sa b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ra(view);
        }
        return qa.c(view);
    }

    static float c(View view) {
        return f1312a.b(view);
    }

    static Ea d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new Da(view);
        }
        return new Ca(view.getWindowToken());
    }

    static void e(View view) {
        f1312a.c(view);
    }

    static void a(View view) {
        f1312a.a(view);
    }

    static void c(View view, Matrix matrix) {
        f1312a.c(view, matrix);
    }

    static void a(View view, int i) {
        a();
        Field field = f1313b;
        if (field != null) {
            try {
                f1313b.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void b(View view, Matrix matrix) {
        f1312a.b(view, matrix);
    }

    static void a(View view, Matrix matrix) {
        f1312a.a_shaKey_method2(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        f1312a.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (!f1314c) {
            try {
                f1313b = View.class.getDeclaredField("mViewFlags");
                f1313b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f1314c = true;
        }
    }
}
