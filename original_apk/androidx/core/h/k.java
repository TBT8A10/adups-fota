package androidx.core.h;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f700a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f701b;

    /* renamed from: c  reason: collision with root package name */
    private final View f702c;
    private boolean d;
    private int[] e;

    public k(View view) {
        this.f702c = view;
    }

    private ViewParent d(int i) {
        if (i == 0) {
            return this.f700a;
        }
        if (i != 1) {
            return null;
        }
        return this.f701b;
    }

    public void a(boolean z) {
        if (this.d) {
            t.E(this.f702c);
        }
        this.d = z;
    }

    public boolean b() {
        return this.d;
    }

    public void c() {
        c(0);
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public void c(int i) {
        ViewParent d2 = d(i);
        if (d2 != null) {
            w.a(d2, this.f702c, i);
            a_shaKey_method2(i, (ViewParent) null);
        }
    }

    public boolean a() {
        return a(0);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!b()) {
            return false;
        }
        View view = this.f702c;
        for (ViewParent parent = this.f702c.getParent(); parent != null; parent = parent.getParent()) {
            if (w.b(parent, view, this.f702c, i, i2)) {
                a_shaKey_method2(i2, parent);
                w.a(parent, view, this.f702c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent d2;
        int i6;
        int i7;
        int[] iArr2 = iArr;
        if (!b() || (d2 = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f702c.getLocationInWindow(iArr2);
            i7 = iArr2[0];
            i6 = iArr2[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        w.a(d2, this.f702c, i, i2, i3, i4, i5);
        if (iArr2 != null) {
            this.f702c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i7;
            iArr2[1] = iArr2[1] - i6;
        }
        return true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent d2;
        int i4;
        int i5;
        if (!b() || (d2 = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f702c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        w.a(d2, this.f702c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f702c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent d2;
        if (!b() || (d2 = d(0)) == null) {
            return false;
        }
        return w.a(d2, this.f702c, f, f2, z);
    }

    public boolean a(float f, float f2) {
        ViewParent d2;
        if (!b() || (d2 = d(0)) == null) {
            return false;
        }
        return w.a(d2, this.f702c, f, f2);
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f700a = viewParent;
        } else if (i == 1) {
            this.f701b = viewParent;
        }
    }
}
