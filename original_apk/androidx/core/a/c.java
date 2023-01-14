package androidx.core.a;

import a.b.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.a.c;
import androidx.core.content.a.h;
import androidx.core.e.f;

/* compiled from: TypefaceCompat */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final j f521a;

    /* renamed from: b  reason: collision with root package name */
    private static final g<String, Typeface> f522b = new g<>(16);

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            f521a = new g();
        } else if (i >= 26) {
            f521a = new f();
        } else if (i >= 24 && e.a()) {
            f521a = new e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f521a = new d();
        } else {
            f521a = new j();
        }
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f522b.b(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, h.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typeface = f.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typeface = f521a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.a_shaKey_method2(typeface, handler);
                } else {
                    aVar2.a_shaKey_method2(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f522b.a_shaKey_method2(b(resources, i, i2), typeface);
        }
        return typeface;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = f521a.a(context, resources, i, str, i2);
        if (a2 != null) {
            f522b.a_shaKey_method2(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        return f521a.a(context, cancellationSignal, bVarArr, i);
    }
}
