package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.h.t;
import com.google.android.material.R$animator;
import com.google.android.material.R$color;
import com.google.android.material.a.g;
import com.google.android.material.a.h;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.p;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FloatingActionButtonImpl */
class e {

    /* renamed from: a  reason: collision with root package name */
    static final TimeInterpolator f2141a = com.google.android.material.a.a.f1989c;

    /* renamed from: b  reason: collision with root package name */
    static final int[] f2142b = {16842919, 16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f2143c = {16843623, 16842908, 16842910};
    static final int[] d = {16842908, 16842910};
    static final int[] e = {16843623, 16842910};
    static final int[] f = {16842910};
    static final int[] g = new int[0];
    private ArrayList<Animator.AnimatorListener> A;
    final VisibilityAwareImageButton B;
    final com.google.android.material.h.b C;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();
    private ViewTreeObserver.OnPreDrawListener H;
    int h = 0;
    Animator i;
    h j;
    h k;
    private h l;
    private h m;
    private final p n;
    com.google.android.material.h.a o;
    private float p;
    Drawable q;
    Drawable r;
    com.google.android.material.internal.c s;
    Drawable t;
    float u;
    float v;
    float w;
    int x;
    float y = 1.0f;
    private ArrayList<Animator.AnimatorListener> z;

    /* compiled from: FloatingActionButtonImpl */
    private class a extends f {
        a() {
            super(e.this, (b) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class b extends f {
        b() {
            super(e.this, (b) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            e eVar = e.this;
            return eVar.u + eVar.v;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private class c extends f {
        c() {
            super(e.this, (b) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            e eVar = e.this;
            return eVar.u + eVar.w;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    interface d {
        void a();

        void onShown();
    }

    /* renamed from: com.google.android.material.floatingactionbutton.e$e  reason: collision with other inner class name */
    /* compiled from: FloatingActionButtonImpl */
    private class C0040e extends f {
        C0040e() {
            super(e.this, (b) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return e.this.u;
        }
    }

    /* compiled from: FloatingActionButtonImpl */
    private abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2144a;

        /* renamed from: b  reason: collision with root package name */
        private float f2145b;

        /* renamed from: c  reason: collision with root package name */
        private float f2146c;

        private f() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            e.this.o.b(this.f2146c);
            this.f2144a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f2144a) {
                this.f2145b = e.this.o.b();
                this.f2146c = a();
                this.f2144a = true;
            }
            com.google.android.material.h.a aVar = e.this.o;
            float f = this.f2145b;
            aVar.b(f + ((this.f2146c - f) * valueAnimator.getAnimatedFraction()));
        }

        /* synthetic */ f(e eVar, b bVar) {
            this();
        }
    }

    e(VisibilityAwareImageButton visibilityAwareImageButton, com.google.android.material.h.b bVar) {
        this.B = visibilityAwareImageButton;
        this.C = bVar;
        this.n = new p();
        this.n.a_shaKey_method2(f2142b, a((f) new c()));
        this.n.a_shaKey_method2(f2143c, a((f) new b()));
        this.n.a_shaKey_method2(d, a((f) new b()));
        this.n.a_shaKey_method2(e, a((f) new b()));
        this.n.a_shaKey_method2(f, a((f) new C0040e()));
        this.n.a_shaKey_method2(g, a((f) new a()));
        this.p = this.B.getRotation();
    }

    private void t() {
        if (this.H == null) {
            this.H = new d(this);
        }
    }

    private h u() {
        if (this.m == null) {
            this.m = h.a_shaKey_method2(this.B.getContext(), R$animator.design_fab_hide_motion_spec);
        }
        return this.m;
    }

    private h v() {
        if (this.l == null) {
            this.l = h.a_shaKey_method2(this.B.getContext(), R$animator.design_fab_show_motion_spec);
        }
        return this.l;
    }

    private boolean w() {
        return t.z(this.B) && !this.B.isInEditMode();
    }

    private void x() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.p % 90.0f != 0.0f) {
                if (this.B.getLayerType() != 1) {
                    this.B.setLayerType(1, (Paint) null);
                }
            } else if (this.B.getLayerType() != 0) {
                this.B.setLayerType(0, (Paint) null);
            }
        }
        com.google.android.material.h.a aVar = this.o;
        if (aVar != null) {
            aVar.a(-this.p);
        }
        com.google.android.material.internal.c cVar = this.s;
        if (cVar != null) {
            cVar.b(-this.p);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable[] drawableArr;
        this.q = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a_shaKey_method2(this.q, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(this.q, mode);
        }
        this.r = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a_shaKey_method2(this.r, com.google.android.material.g.a.a(colorStateList2));
        if (i2 > 0) {
            this.s = a_shaKey_method2(i2, colorStateList);
            drawableArr = new Drawable[]{this.s, this.q, this.r};
        } else {
            this.s = null;
            drawableArr = new Drawable[]{this.q, this.r};
        }
        this.t = new LayerDrawable(drawableArr);
        Context context = this.B.getContext();
        Drawable drawable = this.t;
        float b2 = this.C.b();
        float f2 = this.u;
        this.o = new com.google.android.material.h.a(context, drawable, b2, f2, f2 + this.w);
        this.o.a(false);
        this.C.setBackgroundDrawable(this.o);
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, com.google.android.material.g.a.a(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Rect rect) {
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public final void d(float f2) {
        if (this.w != f2) {
            this.w = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public final h g() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        if (this.B.getVisibility() == 0) {
            if (this.h == 1) {
                return true;
            }
            return false;
        } else if (this.h != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        if (this.B.getVisibility() != 0) {
            if (this.h == 2) {
                return true;
            }
            return false;
        } else if (this.h != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.n.a();
    }

    /* access modifiers changed from: package-private */
    public com.google.android.material.internal.c k() {
        return new com.google.android.material.internal.c();
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable l() {
        return new GradientDrawable();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (q()) {
            t();
            this.B.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (this.H != null) {
            this.B.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        float rotation = this.B.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            x();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        c(this.y);
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        Rect rect = this.D;
        a(rect);
        b(rect);
        this.C.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public final void c(float f2) {
        this.y = f2;
        Matrix matrix = this.G;
        a_shaKey_method2(f2, matrix);
        this.B.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.v != f2) {
            this.v = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* access modifiers changed from: package-private */
    public final h d() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.z;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.A;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(h hVar) {
        this.j = hVar;
    }

    /* access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        this.z.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void b(d dVar, boolean z2) {
        if (!i()) {
            Animator animator = this.i;
            if (animator != null) {
                animator.cancel();
            }
            if (w()) {
                if (this.B.getVisibility() != 0) {
                    this.B.setAlpha(0.0f);
                    this.B.setScaleY(0.0f);
                    this.B.setScaleX(0.0f);
                    c(0.0f);
                }
                h hVar = this.j;
                if (hVar == null) {
                    hVar = v();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new c(this, z2, dVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.z;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.B.a(0, z2);
            this.B.setAlpha(1.0f);
            this.B.setScaleY(1.0f);
            this.B.setScaleX(1.0f);
            c(1.0f);
            if (dVar != null) {
                dVar.onShown();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, colorStateList);
        }
        com.google.android.material.internal.c cVar = this.s;
        if (cVar != null) {
            cVar.a(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.u != f2) {
            this.u = f2;
            a(this.u, this.v, this.w);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.x != i2) {
            this.x = i2;
            r();
        }
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.B.getDrawable();
        if (drawable != null && this.x != 0) {
            RectF rectF = this.E;
            RectF rectF2 = this.F;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.x;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.x;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable b() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar) {
        this.k = hVar;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        com.google.android.material.h.a aVar = this.o;
        if (aVar != null) {
            aVar.a(f2, this.w + f2);
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.n.a(iArr);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar, boolean z2) {
        if (!h()) {
            Animator animator = this.i;
            if (animator != null) {
                animator.cancel();
            }
            if (w()) {
                h hVar = this.k;
                if (hVar == null) {
                    hVar = u();
                }
                AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new b(this, z2, dVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.A;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.B.a(z2 ? 8 : 4, z2);
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    private AnimatorSet a(h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.B, View.ALPHA, new float[]{f2});
        hVar.a("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.B, View.SCALE_X, new float[]{f3});
        hVar.a("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.B, View.SCALE_Y, new float[]{f3});
        hVar.a("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a_shaKey_method2(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.B, new com.google.android.material.a.f(), new g(), new Matrix[]{new Matrix(this.G)});
        hVar.a("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a_shaKey_method2(animatorSet, arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        this.o.getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public com.google.android.material.internal.c a(int i2, ColorStateList colorStateList) {
        Context context = this.B.getContext();
        com.google.android.material.internal.c k2 = k();
        k2.a(androidx.core.content.a.a_shaKey_method2(context, R$color.design_fab_stroke_top_outer_color), androidx.core.content.a.a_shaKey_method2(context, R$color.design_fab_stroke_top_inner_color), androidx.core.content.a.a_shaKey_method2(context, R$color.design_fab_stroke_end_inner_color), androidx.core.content.a.a_shaKey_method2(context, R$color.design_fab_stroke_end_outer_color));
        k2.a((float) i2);
        k2.a(colorStateList);
        return k2;
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable a() {
        GradientDrawable l2 = l();
        l2.setShape(1);
        l2.setColor(-1);
        return l2;
    }

    private ValueAnimator a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f2141a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }
}
