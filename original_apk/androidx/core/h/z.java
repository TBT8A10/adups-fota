package androidx.core.h;

import android.animation.Animator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f720a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f721b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f722c = null;
    int d = -1;

    /* compiled from: ViewPropertyAnimatorCompat */
    static class a implements A {

        /* renamed from: a  reason: collision with root package name */
        z f723a;

        /* renamed from: b  reason: collision with root package name */
        boolean f724b;

        a(z zVar) {
            this.f723a = zVar;
        }

        public void a(View view) {
            Object tag = view.getTag(2113929216);
            A a2 = tag instanceof A ? (A) tag : null;
            if (a2 != null) {
                a2.a(view);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.h.A} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.h.z r0 = r3.f723a
                int r0 = r0.d
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x000f
                r4.setLayerType(r0, r2)
                androidx.core.h.z r0 = r3.f723a
                r0.d = r1
            L_0x000f:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x0019
                boolean r0 = r3.f724b
                if (r0 != 0) goto L_0x0039
            L_0x0019:
                androidx.core.h.z r0 = r3.f723a
                java.lang.Runnable r1 = r0.f722c
                if (r1 == 0) goto L_0x0024
                r0.f722c = r2
                r1.run()
            L_0x0024:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.h.A
                if (r1 == 0) goto L_0x0031
                r2 = r0
                androidx.core.h.A r2 = (androidx.core.h.A) r2
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r2.b(r4)
            L_0x0036:
                r4 = 1
                r3.f724b = r4
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.z.a.b(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.h.A} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f724b = r0
                androidx.core.h.z r0 = r3.f723a
                int r0 = r0.d
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.h.z r0 = r3.f723a
                java.lang.Runnable r2 = r0.f721b
                if (r2 == 0) goto L_0x001a
                r0.f721b = r1
                r2.run()
            L_0x001a:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.h.A
                if (r2 == 0) goto L_0x0027
                r1 = r0
                androidx.core.h.A r1 = (androidx.core.h.A) r1
            L_0x0027:
                if (r1 == 0) goto L_0x002c
                r1.c(r4)
            L_0x002c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.z.a.c(android.view.View):void");
        }
    }

    z(View view) {
        this.f720a = new WeakReference<>(view);
    }

    public z a(long j) {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public z b(float f) {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public void c() {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z a(float f) {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public long b() {
        View view = (View) this.f720a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public z a(Interpolator interpolator) {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z b(long j) {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void a() {
        View view = (View) this.f720a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public z a(A a2) {
        View view = (View) this.f720a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a_shaKey_method2(view, a2);
            } else {
                view.setTag(2113929216, a2);
                a_shaKey_method2(view, new a(this));
            }
        }
        return this;
    }

    private void a(View view, A a2) {
        if (a2 != null) {
            view.animate().setListener(new x(this, a2, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public z a(C c2) {
        View view = (View) this.f720a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            y yVar = null;
            if (c2 != null) {
                yVar = new y(this, c2, view);
            }
            view.animate().setUpdateListener(yVar);
        }
        return this;
    }
}
