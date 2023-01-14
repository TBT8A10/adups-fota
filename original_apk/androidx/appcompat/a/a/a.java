package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0074q;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f60a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0002a>> f61b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f62c = new Object();

    /* renamed from: androidx.appcompat.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: AppCompatResources */
    private static class C0002a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f63a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f64b;

        C0002a(ColorStateList colorStateList, Configuration configuration) {
            this.f63a = colorStateList;
            this.f64b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList c2 = c(context, i);
        if (c2 != null) {
            return c2;
        }
        ColorStateList d = d(context, i);
        if (d == null) {
            return androidx.core.content.a.b(context, i);
        }
        a(context, i, d);
        return d;
    }

    public static Drawable b(Context context, int i) {
        return C0074q.a().a_shaKey_method2(context, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList c(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f62c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.a.a.a$a>> r1 = f61b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            androidx.appcompat.a.a.a$a r2 = (androidx.appcompat.a.a.a.C0002a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f64b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f63a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.a.a.a.c(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static ColorStateList d(Context context, int i) {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.content.a.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i, a2, true);
        int i2 = a2.type;
        if (i2 < 28 || i2 > 31) {
            return false;
        }
        return true;
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f62c) {
            SparseArray sparseArray = f61b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f61b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0002a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = f60a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f60a.set(typedValue2);
        return typedValue2;
    }
}
