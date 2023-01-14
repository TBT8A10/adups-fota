package androidx.core.f;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Method f637a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f638b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f638b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f637a = cls.getMethod("getScript", new Class[]{String.class});
                    f638b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
                }
            } catch (Exception e2) {
                f637a = null;
                f638b = null;
                Log.w("ICUCompat", e2);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f638b.invoke((Object) null, new Object[]{locale})).getScript();
            } catch (InvocationTargetException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (IllegalAccessException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        } else {
            String b2 = b(locale);
            if (b2 != null) {
                return a(b2);
            }
            return null;
        }
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f638b != null) {
                return (String) f638b.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return locale2;
    }

    private static String a(String str) {
        try {
            if (f637a != null) {
                return (String) f637a.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }
}
