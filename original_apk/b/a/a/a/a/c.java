package b.a.a.a.a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.C0178t;

public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f1386a;

    /* renamed from: b  reason: collision with root package name */
    private T f1387b;

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected c(String str) {
        this.f1386a = str;
    }

    /* access modifiers changed from: protected */
    public final T a(Context context) throws a {
        if (this.f1387b == null) {
            C0178t.a(context);
            Context a2 = d.a(context);
            if (a2 != null) {
                try {
                    this.f1387b = a((IBinder) a2.getClassLoader().loadClass(this.f1386a).newInstance());
                } catch (ClassNotFoundException e) {
                    throw new a("Could not load creator class.", e);
                } catch (InstantiationException e2) {
                    throw new a("Could not instantiate creator.", e2);
                } catch (IllegalAccessException e3) {
                    throw new a("Could not access creator.", e3);
                }
            } else {
                throw new a("Could not get remote context.");
            }
        }
        return this.f1387b;
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);
}
