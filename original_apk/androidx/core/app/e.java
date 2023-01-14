package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat */
public final class e {
    public static IBinder a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.a_shaKey_method2(bundle, str);
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }

    /* compiled from: BundleCompat */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Method f554a;

        /* renamed from: b  reason: collision with root package name */
        private static boolean f555b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f556c;
        private static boolean d;

        public static IBinder a(Bundle bundle, String str) {
            if (!f555b) {
                try {
                    f554a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f554a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f555b = true;
            }
            Method method = f554a;
            if (method != null) {
                try {
                    return (IBinder) method.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f554a = null;
                }
            }
            return null;
        }

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!d) {
                try {
                    f556c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f556c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                d = true;
            }
            Method method = f556c;
            if (method != null) {
                try {
                    method.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    f556c = null;
                }
            }
        }
    }
}
