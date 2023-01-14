package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.a;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.t;

/* compiled from: MaterialButtonHelper */
class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2084a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private final MaterialButton f2085b;

    /* renamed from: c  reason: collision with root package name */
    private int f2086c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private boolean w = false;

    public b(MaterialButton materialButton) {
        this.f2085b = materialButton;
    }

    private Drawable i() {
        this.p = new GradientDrawable();
        this.p.setCornerRadius(((float) this.g) + 1.0E-5f);
        this.p.setColor(-1);
        this.q = a.i(this.p);
        a.a_shaKey_method2(this.q, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            a.a_shaKey_method2(this.q, mode);
        }
        this.r = new GradientDrawable();
        this.r.setCornerRadius(((float) this.g) + 1.0E-5f);
        this.r.setColor(-1);
        this.s = a.i(this.r);
        a.a_shaKey_method2(this.s, this.l);
        return a((Drawable) new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    @TargetApi(21)
    private Drawable j() {
        this.t = new GradientDrawable();
        this.t.setCornerRadius(((float) this.g) + 1.0E-5f);
        this.t.setColor(-1);
        n();
        this.u = new GradientDrawable();
        this.u.setCornerRadius(((float) this.g) + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.h, this.k);
        InsetDrawable a2 = a((Drawable) new LayerDrawable(new Drawable[]{this.t, this.u}));
        this.v = new GradientDrawable();
        this.v.setCornerRadius(((float) this.g) + 1.0E-5f);
        this.v.setColor(-1);
        return new a(com.google.android.material.g.a.a(this.l), a2, this.v);
    }

    private GradientDrawable k() {
        if (!f2084a || this.f2085b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f2085b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable l() {
        if (!f2084a || this.f2085b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f2085b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void m() {
        if (f2084a && this.u != null) {
            this.f2085b.setInternalBackground(j());
        } else if (!f2084a) {
            this.f2085b.invalidate();
        }
    }

    private void n() {
        GradientDrawable gradientDrawable = this.t;
        if (gradientDrawable != null) {
            a.a_shaKey_method2((Drawable) gradientDrawable, this.j);
            PorterDuff.Mode mode = this.i;
            if (mode != null) {
                a.a_shaKey_method2((Drawable) this.t, mode);
            }
        }
    }

    public void a(TypedArray typedArray) {
        int i2 = 0;
        this.f2086c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        this.g = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, 0);
        this.h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.i = t.a_shaKey_method2(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = com.google.android.material.f.a.a(this.f2085b.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.k = com.google.android.material.f.a.a(this.f2085b.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.l = com.google.android.material.f.a.a(this.f2085b.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth((float) this.h);
        Paint paint = this.m;
        ColorStateList colorStateList = this.k;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(this.f2085b.getDrawableState(), 0);
        }
        paint.setColor(i2);
        int o2 = androidx.core.h.t.o(this.f2085b);
        int paddingTop = this.f2085b.getPaddingTop();
        int n2 = androidx.core.h.t.n(this.f2085b);
        int paddingBottom = this.f2085b.getPaddingBottom();
        this.f2085b.setInternalBackground(f2084a ? j() : i());
        androidx.core.h.t.b(this.f2085b, o2 + this.f2086c, paddingTop + this.e, n2 + this.d, paddingBottom + this.f);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (f2084a) {
                n();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                a.a_shaKey_method2(drawable, this.j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode f() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.w = true;
        this.f2085b.setSupportBackgroundTintList(this.j);
        this.f2085b.setSupportBackgroundTintMode(this.i);
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            Paint paint = this.m;
            int i2 = 0;
            if (colorStateList != null) {
                i2 = colorStateList.getColorForState(this.f2085b.getDrawableState(), 0);
            }
            paint.setColor(i2);
            m();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        GradientDrawable gradientDrawable;
        if (this.g != i2) {
            this.g = i2;
            if (f2084a && this.t != null && this.u != null && this.v != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f2 = ((float) i2) + 1.0E-5f;
                    k().setCornerRadius(f2);
                    l().setCornerRadius(f2);
                }
                float f3 = ((float) i2) + 1.0E-5f;
                this.t.setCornerRadius(f3);
                this.u.setCornerRadius(f3);
                this.v.setCornerRadius(f3);
            } else if (!f2084a && (gradientDrawable = this.p) != null && this.r != null) {
                float f4 = ((float) i2) + 1.0E-5f;
                gradientDrawable.setCornerRadius(f4);
                this.r.setCornerRadius(f4);
                this.f2085b.invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (this.h != i2) {
            this.h = i2;
            this.m.setStrokeWidth((float) i2);
            m();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (canvas != null && this.k != null && this.h > 0) {
            this.n.set(this.f2085b.getBackground().getBounds());
            RectF rectF = this.o;
            Rect rect = this.n;
            int i2 = this.h;
            rectF.set(((float) rect.left) + (((float) i2) / 2.0f) + ((float) this.f2086c), ((float) rect.top) + (((float) i2) / 2.0f) + ((float) this.e), (((float) rect.right) - (((float) i2) / 2.0f)) - ((float) this.d), (((float) rect.bottom) - (((float) i2) / 2.0f)) - ((float) this.f));
            float f2 = ((float) this.g) - (((float) this.h) / 2.0f);
            canvas.drawRoundRect(this.o, f2, f2, this.m);
        }
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f2086c, this.e, this.d, this.f);
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2;
        if (this.i != mode) {
            this.i = mode;
            if (f2084a) {
                n();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null && (mode2 = this.i) != null) {
                a.a_shaKey_method2(drawable, mode2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f2086c, this.e, i3 - this.d, i2 - this.f);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        if (f2084a && (gradientDrawable2 = this.t) != null) {
            gradientDrawable2.setColor(i2);
        } else if (!f2084a && (gradientDrawable = this.p) != null) {
            gradientDrawable.setColor(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.l != colorStateList) {
            this.l = colorStateList;
            if (f2084a && (this.f2085b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f2085b.getBackground()).setColor(colorStateList);
            } else if (!f2084a && (drawable = this.s) != null) {
                a.a_shaKey_method2(drawable, colorStateList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.g;
    }
}
