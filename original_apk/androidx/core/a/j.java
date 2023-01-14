package androidx.core.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.a.c;
import androidx.core.e.f;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: TypefaceCompatBaseImpl */
class j {

    /* compiled from: TypefaceCompatBaseImpl */
    private interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    j() {
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public f.b a(f.b[] bVarArr, int i) {
        return (f.b) a(bVarArr, i, new h(this));
    }

    /* access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(bVarArr, i).c());
            try {
                Typeface a2 = a_shaKey_method2(context, inputStream);
                k.a((Closeable) inputStream);
                return a2;
            } catch (IOException unused) {
                k.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                k.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            k.a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            k.a((Closeable) inputStream2);
            throw th;
        }
    }

    private c.C0008c a(c.b bVar, int i) {
        return (c.C0008c) a(bVar.a(), i, new i(this));
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        c.C0008c a2 = a_shaKey_method2(bVar, i);
        if (a2 == null) {
            return null;
        }
        return c.a(context, resources, a2.b(), a2.a(), i);
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }
}
