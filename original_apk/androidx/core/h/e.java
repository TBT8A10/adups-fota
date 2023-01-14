package androidx.core.h;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompat */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Field f698a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f699b;

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f699b) {
            try {
                f698a = LayoutInflater.class.getDeclaredField("mFactory2");
                f698a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f699b = true;
        }
        Field field = f698a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
