package androidx.customview.a;

import a.b.j;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.h.C0083a;
import androidx.core.h.a.e;
import androidx.core.h.t;
import androidx.core.h.w;
import androidx.customview.a.d;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: ExploreByTouchHelper */
public abstract class c extends C0083a {

    /* renamed from: c  reason: collision with root package name */
    private static final Rect f753c = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final d.a<androidx.core.h.a.c> d = new a();
    private static final d.b<j<androidx.core.h.a.c>, androidx.core.h.a.c> e = new b();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final int[] i = new int[2];
    private final AccessibilityManager j;
    private final View k;
    private a l;
    int m = Integer.MIN_VALUE;
    int n = Integer.MIN_VALUE;
    private int o = Integer.MIN_VALUE;

    public c(View view) {
        if (view != null) {
            this.k = view;
            this.j = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (t.i(view) == 0) {
                t.d(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean b(int i2, Rect rect) {
        androidx.core.h.a.c cVar;
        androidx.core.h.a.c cVar2;
        j<androidx.core.h.a.c> d2 = d();
        int i3 = this.n;
        int i4 = Integer.MIN_VALUE;
        if (i3 == Integer.MIN_VALUE) {
            cVar = null;
        } else {
            cVar = d2.b(i3);
        }
        androidx.core.h.a.c cVar3 = cVar;
        if (i2 == 1 || i2 == 2) {
            cVar2 = (androidx.core.h.a.c) d.a(d2, e, d, cVar3, i2, t.k(this.k) == 1, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.n;
            if (i5 != Integer.MIN_VALUE) {
                a_shaKey_method2(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.k, i2, rect2);
            }
            cVar2 = (androidx.core.h.a.c) d.a(d2, e, d, cVar3, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (cVar2 != null) {
            i4 = d2.d(d2.a(cVar2));
        }
        return c(i4);
    }

    private AccessibilityEvent c(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        androidx.core.h.a.c b2 = b(i2);
        obtain.getText().add(b2.h());
        obtain.setContentDescription(b2.d());
        obtain.setScrollable(b2.s());
        obtain.setPassword(b2.r());
        obtain.setEnabled(b2.n());
        obtain.setChecked(b2.l());
        a_shaKey_method2(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(b2.c());
            e.a(obtain, this.k, i2);
            obtain.setPackageName(this.k.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private j<androidx.core.h.a.c> d() {
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        j<androidx.core.h.a.c> jVar = new j<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jVar.c(i2, f(i2));
        }
        return jVar;
    }

    private AccessibilityEvent e(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.k.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private androidx.core.h.a.c f(int i2) {
        androidx.core.h.a.c v = androidx.core.h.a.c.v();
        v.g(true);
        v.h(true);
        v.a((CharSequence) "android.view.View");
        v.c(f753c);
        v.d(f753c);
        v.c(this.k);
        a(i2, v);
        if (v.h() == null && v.d() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        v.a(this.g);
        if (!this.g.equals(f753c)) {
            int a2 = v.a();
            if ((a2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((a2 & CpioConstants.C_IWUSR) == 0) {
                v.e((CharSequence) this.k.getContext().getPackageName());
                v.c(this.k, i2);
                if (this.m == i2) {
                    v.a(true);
                    v.a((int) CpioConstants.C_IWUSR);
                } else {
                    v.a(false);
                    v.a(64);
                }
                boolean z = this.n == i2;
                if (z) {
                    v.a(2);
                } else if (v.o()) {
                    v.a(1);
                }
                v.i(z);
                this.k.getLocationOnScreen(this.i);
                v.b(this.f);
                if (this.f.equals(f753c)) {
                    v.a(this.f);
                    if (v.f684b != -1) {
                        androidx.core.h.a.c v2 = androidx.core.h.a.c.v();
                        for (int i3 = v.f684b; i3 != -1; i3 = v2.f684b) {
                            v2.b(this.k, -1);
                            v2.c(f753c);
                            a(i3, v2);
                            v2.a(this.g);
                            Rect rect = this.f;
                            Rect rect2 = this.g;
                            rect.offset(rect2.left, rect2.top);
                        }
                        v2.w();
                    }
                    this.f.offset(this.i[0] - this.k.getScrollX(), this.i[1] - this.k.getScrollY());
                }
                if (this.k.getLocalVisibleRect(this.h)) {
                    this.h.offset(this.i[0] - this.k.getScrollX(), this.i[1] - this.k.getScrollY());
                    if (this.f.intersect(this.h)) {
                        v.d(this.f);
                        if (a(this.f)) {
                            v.n(true);
                        }
                    }
                }
                return v;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private static int g(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 != 21) {
            return i2 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean h(int i2) {
        int i3;
        if (!this.j.isEnabled() || !this.j.isTouchExplorationEnabled() || (i3 = this.m) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            d(i3);
        }
        this.m = i2;
        this.k.invalidate();
        a(i2, 32768);
        return true;
    }

    private void i(int i2) {
        int i3 = this.o;
        if (i3 != i2) {
            this.o = i2;
            a(i2, (int) CpioConstants.C_IWUSR);
            a(i3, (int) CpioConstants.C_IRUSR);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int a(float f2, float f3);

    public androidx.core.h.a.d a(View view) {
        if (this.l == null) {
            this.l = new a();
        }
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, androidx.core.h.a.c cVar);

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void a(androidx.core.h.a.c cVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean a(int i2, int i3, Bundle bundle);

    /* compiled from: ExploreByTouchHelper */
    private class a extends androidx.core.h.a.d {
        a() {
        }

        public androidx.core.h.a.c a(int i) {
            return androidx.core.h.a.c.a(c.this.b(i));
        }

        public androidx.core.h.a.c b(int i) {
            int i2 = i == 2 ? c.this.m : c.this.n;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        public boolean a(int i, int i2, Bundle bundle) {
            return c.this.b(i, i2, bundle);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.j.isEnabled() || !this.j.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int a2 = a_shaKey_method2(motionEvent.getX(), motionEvent.getY());
            i(a2);
            if (a2 != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.o == Integer.MIN_VALUE) {
            return false;
        } else {
            i(Integer.MIN_VALUE);
            return true;
        }
    }

    private boolean d(int i2) {
        if (this.m != i2) {
            return false;
        }
        this.m = Integer.MIN_VALUE;
        this.k.invalidate();
        a(i2, 65536);
        return true;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int g2 = g(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && b(g2, (Rect) null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            b();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return b(1, (Rect) null);
            }
            return false;
        }
    }

    private androidx.core.h.a.c c() {
        androidx.core.h.a.c b2 = androidx.core.h.a.c.b(this.k);
        t.a_shaKey_method2(this.k, b2);
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        if (b2.b() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                b2.a_shaKey_method2(this.k, ((Integer) arrayList.get(i2)).intValue());
            }
            return b2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private boolean b() {
        int i2 = this.n;
        return i2 != Integer.MIN_VALUE && a(i2, 16, (Bundle) null);
    }

    private AccessibilityEvent b(int i2, int i3) {
        if (i2 != -1) {
            return c(i2, i3);
        }
        return e(i3);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    /* access modifiers changed from: package-private */
    public androidx.core.h.a.c b(int i2) {
        if (i2 == -1) {
            return c();
        }
        return f(i2);
    }

    public final void a(boolean z, int i2, Rect rect) {
        int i3 = this.n;
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        if (z) {
            b(i2, rect);
        }
    }

    private boolean c(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return c(i2);
        }
        if (i3 == 2) {
            return a(i2);
        }
        if (i3 == 64) {
            return h(i2);
        }
        if (i3 != 128) {
            return a(i2, i3, bundle);
        }
        return d(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, int i3, Bundle bundle) {
        if (i2 != -1) {
            return c(i2, i3, bundle);
        }
        return a_shaKey_method2(i3, bundle);
    }

    private void a(int i2, Rect rect) {
        b(i2).a(rect);
    }

    private static Rect a(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public final boolean c(int i2) {
        int i3;
        if ((!this.k.isFocused() && !this.k.requestFocus()) || (i3 = this.n) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        this.n = i2;
        a(i2, true);
        a(i2, 8);
        return true;
    }

    public final boolean a(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.j.isEnabled() || (parent = this.k.getParent()) == null) {
            return false;
        }
        return w.a(parent, this.k, b(i2, i3));
    }

    public void a(View view, androidx.core.h.a.c cVar) {
        super.a_shaKey_method2(view, cVar);
        a(cVar);
    }

    private boolean a(int i2, Bundle bundle) {
        return t.a(this.k, i2, bundle);
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.k.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.k.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    public final boolean a(int i2) {
        if (this.n != i2) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        a(i2, false);
        a(i2, 8);
        return true;
    }
}
