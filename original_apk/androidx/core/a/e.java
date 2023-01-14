package androidx.core.a;

import a.b.i;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.a.c;
import androidx.core.e.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl */
class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f523a;

    /* renamed from: b  reason: collision with root package name */
    private static final Constructor f524b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f525c;
    private static final Method d;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        f524b = constructor;
        f523a = cls;
        f525c = method;
        d = method2;
    }

    e() {
    }

    public static boolean a() {
        if (f525c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f525c != null;
    }

    private static Object b() {
        try {
            return f524b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f525c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f523a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        Object b2 = b();
        i iVar = new i();
        for (f.b bVar : bVarArr) {
            Uri c2 = bVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) iVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, cancellationSignal, c2);
                iVar.put(c2, byteBuffer);
            }
            if (!a(b2, byteBuffer, bVar.b(), bVar.d(), bVar.e())) {
                return null;
            }
        }
        return Typeface.create(a(b2), i);
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object b2 = b();
        for (c.C0008c cVar : bVar.a()) {
            ByteBuffer a2 = k.a(context, resources, cVar.b());
            if (a2 == null || !a(b2, a2, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return a(b2);
    }
}
