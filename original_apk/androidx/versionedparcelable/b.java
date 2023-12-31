package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;

/* compiled from: VersionedParcel */
public abstract class b {
    private void c(d dVar) {
        try {
            a(a((Class<? extends d>) dVar.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(dVar.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    public int a(int i, int i2) {
        if (!a(i2)) {
            return i;
        }
        return e();
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public abstract void a(String str);

    public void a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract boolean a(int i);

    /* access modifiers changed from: protected */
    public abstract b b();

    /* access modifiers changed from: protected */
    public abstract void b(int i);

    public void b(byte[] bArr, int i) {
        b(i);
        a(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void c(int i);

    public boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] d();

    /* access modifiers changed from: protected */
    public abstract int e();

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T f();

    /* access modifiers changed from: protected */
    public abstract String g();

    /* access modifiers changed from: protected */
    public <T extends d> T h() {
        String g = g();
        if (g == null) {
            return null;
        }
        return a(g, b());
    }

    public String a(String str, int i) {
        if (!a(i)) {
            return str;
        }
        return g();
    }

    public void b(int i, int i2) {
        b(i2);
        c(i);
    }

    public byte[] a(byte[] bArr, int i) {
        if (!a(i)) {
            return bArr;
        }
        return d();
    }

    public void b(String str, int i) {
        b(i);
        a(str);
    }

    public <T extends Parcelable> T a(T t, int i) {
        if (!a(i)) {
            return t;
        }
        return f();
    }

    public void b(Parcelable parcelable, int i) {
        b(i);
        a(parcelable);
    }

    /* access modifiers changed from: protected */
    public void a(d dVar) {
        if (dVar == null) {
            a((String) null);
            return;
        }
        c(dVar);
        b b2 = b();
        a(dVar, b2);
        b2.a();
    }

    public void b(d dVar, int i) {
        b(i);
        a(dVar);
    }

    private static <T extends d> Class b(T t) throws ClassNotFoundException {
        return a((Class<? extends d>) t.getClass());
    }

    public <T extends d> T a(T t, int i) {
        if (!a(i)) {
            return t;
        }
        return h();
    }

    protected static <T extends d> T a(String str, b bVar) {
        try {
            return (d) Class.forName(str, true, b.class.getClassLoader()).getDeclaredMethod("read", new Class[]{b.class}).invoke((Object) null, new Object[]{bVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    protected static <T extends d> void a(T t, b bVar) {
        try {
            b(t).getDeclaredMethod("write", new Class[]{t.getClass(), b.class}).invoke((Object) null, new Object[]{t, bVar});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    private static Class a(Class<? extends d> cls) throws ClassNotFoundException {
        return Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
    }
}
