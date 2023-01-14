package androidx.core.h;

import android.os.Build;
import android.view.WindowInsets;

/* compiled from: WindowInsetsCompat */
public class D {

    /* renamed from: a  reason: collision with root package name */
    private final Object f678a;

    private D(Object obj) {
        this.f678a = obj;
    }

    public D a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new D(((WindowInsets) this.f678a).consumeSystemWindowInsets());
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f678a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f678a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f678a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f678a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || D.class != obj.getClass()) {
            return false;
        }
        D d = (D) obj;
        Object obj2 = this.f678a;
        if (obj2 != null) {
            return obj2.equals(d.f678a);
        }
        if (d.f678a == null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f678a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f678a).isConsumed();
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f678a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public D a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new D(((WindowInsets) this.f678a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    static D a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new D(obj);
    }

    static Object a(D d) {
        if (d == null) {
            return null;
        }
        return d.f678a;
    }
}
