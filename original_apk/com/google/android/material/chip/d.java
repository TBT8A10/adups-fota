package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.a.h;
import androidx.core.graphics.drawable.b;
import com.google.android.material.R$styleable;
import com.google.android.material.f.c;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: ChipDrawable */
public class d extends Drawable implements b, Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2098a = {16842910};
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private final Context H;
    private final TextPaint I = new TextPaint(1);
    private final Paint J = new Paint(1);
    private final Paint K;
    private final Paint.FontMetrics L = new Paint.FontMetrics();
    private final RectF M = new RectF();
    private final PointF N = new PointF();
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private int U = 255;
    private ColorFilter V;
    private PorterDuffColorFilter W;
    private ColorStateList X;
    private PorterDuff.Mode Y = PorterDuff.Mode.SRC_IN;
    private int[] Z;
    private boolean aa;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f2099b;
    private ColorStateList ba;

    /* renamed from: c  reason: collision with root package name */
    private float f2100c;
    private WeakReference<a> ca = new WeakReference<>((Object) null);
    private float d;
    /* access modifiers changed from: private */
    public boolean da = true;
    private ColorStateList e;
    private float ea;
    private float f;
    private TextUtils.TruncateAt fa;
    private ColorStateList g;
    private boolean ga;
    private CharSequence h;
    private int ha;
    private CharSequence i;
    private c j;
    private final h.a k = new c(this);
    private boolean l;
    private Drawable m;
    private ColorStateList n;
    private float o;
    private boolean p;
    private Drawable q;
    private ColorStateList r;
    private float s;
    private CharSequence t;
    private boolean u;
    private boolean v;
    private Drawable w;
    private com.google.android.material.a.h x;
    private com.google.android.material.a.h y;
    private float z;

    /* compiled from: ChipDrawable */
    public interface a {
        void a();
    }

    private d(Context context) {
        this.H = context;
        this.h = "";
        this.I.density = context.getResources().getDisplayMetrics().density;
        this.K = null;
        Paint paint = this.K;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(f2098a);
        a(f2098a);
        this.ga = true;
    }

    private float K() {
        if (R()) {
            return this.E + this.s + this.F;
        }
        return 0.0f;
    }

    private float L() {
        this.I.getFontMetrics(this.L);
        Paint.FontMetrics fontMetrics = this.L;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean M() {
        return this.v && this.w != null && this.u;
    }

    private float N() {
        if (!this.da) {
            return this.ea;
        }
        this.ea = c(this.i);
        this.da = false;
        return this.ea;
    }

    private ColorFilter O() {
        ColorFilter colorFilter = this.V;
        return colorFilter != null ? colorFilter : this.W;
    }

    private boolean P() {
        return this.v && this.w != null && this.S;
    }

    private boolean Q() {
        return this.l && this.m != null;
    }

    private boolean R() {
        return this.p && this.q != null;
    }

    private void S() {
        this.ba = this.aa ? com.google.android.material.g.a.a(this.g) : null;
    }

    private void b(Canvas canvas, Rect rect) {
        this.J.setColor(this.O);
        this.J.setStyle(Paint.Style.FILL);
        this.J.setColorFilter(O());
        this.M.set(rect);
        RectF rectF = this.M;
        float f2 = this.d;
        canvas.drawRoundRect(rectF, f2, f2, this.J);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.I.measureText(charSequence, 0, charSequence.length());
    }

    private void d(Canvas canvas, Rect rect) {
        if (this.f > 0.0f) {
            this.J.setColor(this.P);
            this.J.setStyle(Paint.Style.STROKE);
            this.J.setColorFilter(O());
            RectF rectF = this.M;
            float f2 = this.f;
            rectF.set(((float) rect.left) + (f2 / 2.0f), ((float) rect.top) + (f2 / 2.0f), ((float) rect.right) - (f2 / 2.0f), ((float) rect.bottom) - (f2 / 2.0f));
            float f3 = this.d - (this.f / 2.0f);
            canvas.drawRoundRect(this.M, f3, f3, this.J);
        }
    }

    private void e(Canvas canvas, Rect rect) {
        if (R()) {
            c(rect, this.M);
            RectF rectF = this.M;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.q.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.q.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void g(Canvas canvas, Rect rect) {
        Paint paint = this.K;
        if (paint != null) {
            paint.setColor(androidx.core.a.a.b(-16777216, 127));
            canvas.drawRect(rect, this.K);
            if (Q() || P()) {
                a_shaKey_method2(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            if (this.i != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.K);
            }
            if (R()) {
                c(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            this.K.setColor(androidx.core.a.a.b(-65536, 127));
            b(rect, this.M);
            canvas.drawRect(this.M, this.K);
            this.K.setColor(androidx.core.a.a.b(-16711936, 127));
            d(rect, this.M);
            canvas.drawRect(this.M, this.K);
        }
    }

    private void h(Canvas canvas, Rect rect) {
        if (this.i != null) {
            Paint.Align a2 = a_shaKey_method2(rect, this.N);
            e(rect, this.M);
            if (this.j != null) {
                this.I.drawableState = getState();
                this.j.b(this.H, this.I, this.k);
            }
            this.I.setTextAlign(a2);
            int i2 = 0;
            boolean z2 = Math.round(N()) > Math.round(this.M.width());
            if (z2) {
                i2 = canvas.save();
                canvas.clipRect(this.M);
            }
            CharSequence charSequence = this.i;
            if (z2 && this.fa != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.I, this.M.width(), this.fa);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.N;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.I);
            if (z2) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public c A() {
        return this.j;
    }

    public float B() {
        return this.D;
    }

    public float C() {
        return this.C;
    }

    public boolean D() {
        return this.u;
    }

    public boolean E() {
        return this.v;
    }

    public boolean F() {
        return this.l;
    }

    public boolean G() {
        return e(this.q);
    }

    public boolean H() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    public void I() {
        a aVar = (a) this.ca.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        return this.ga;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i2 = 0;
            int i3 = this.U;
            if (i3 < 255) {
                i2 = com.google.android.material.b.a.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i3);
            }
            b(canvas, bounds);
            d(canvas, bounds);
            f(canvas, bounds);
            c(canvas, bounds);
            a_shaKey_method2(canvas, bounds);
            if (this.ga) {
                h(canvas, bounds);
            }
            e(canvas, bounds);
            g(canvas, bounds);
            if (this.U < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public void f(boolean z2) {
        if (this.aa != z2) {
            this.aa = z2;
            S();
            onStateChange(getState());
        }
    }

    public int getAlpha() {
        return this.U;
    }

    public ColorFilter getColorFilter() {
        return this.V;
    }

    public int getIntrinsicHeight() {
        return (int) this.f2100c;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.z + a() + this.C + N() + this.D + K() + this.G), this.ha);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.d);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.d);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public float i() {
        return this.f2100c;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        return f(this.f2099b) || f(this.e) || (this.aa && f(this.ba)) || b(this.j) || M() || e(this.m) || e(this.w) || f(this.X);
    }

    public void j(int i2) {
        c(this.H.getResources().getBoolean(i2));
    }

    public void k(int i2) {
        d(this.H.getResources().getDimension(i2));
    }

    public float l() {
        return this.f;
    }

    public void m(int i2) {
        c(androidx.appcompat.a.a.a.a_shaKey_method2(this.H, i2));
    }

    public void n(int i2) {
        f(this.H.getResources().getDimension(i2));
    }

    public float o() {
        return this.F;
    }

    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (Q()) {
            onLayoutDirectionChanged |= this.m.setLayoutDirection(i2);
        }
        if (P()) {
            onLayoutDirectionChanged |= this.w.setLayoutDirection(i2);
        }
        if (R()) {
            onLayoutDirectionChanged |= this.q.setLayoutDirection(i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (Q()) {
            onLevelChange |= this.m.setLevel(i2);
        }
        if (P()) {
            onLevelChange |= this.w.setLevel(i2);
        }
        if (R()) {
            onLevelChange |= this.q.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return a(iArr, r());
    }

    public void p(int i2) {
        c(androidx.appcompat.a.a.a.b(this.H, i2));
    }

    public void q(int i2) {
        h(this.H.getResources().getDimension(i2));
    }

    public int[] r() {
        return this.Z;
    }

    public ColorStateList s() {
        return this.r;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (this.U != i2) {
            this.U = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.V != colorFilter) {
            this.V = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.Y != mode) {
            this.Y = mode;
            this.W = com.google.android.material.c.a.a(this, this.X, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (Q()) {
            visible |= this.m.setVisible(z2, z3);
        }
        if (P()) {
            visible |= this.w.setVisible(z2, z3);
        }
        if (R()) {
            visible |= this.q.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public TextUtils.TruncateAt t() {
        return this.fa;
    }

    public com.google.android.material.a.h u() {
        return this.y;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v() {
        return this.B;
    }

    public float w() {
        return this.A;
    }

    public ColorStateList x() {
        return this.g;
    }

    public void y(int i2) {
        e(androidx.appcompat.a.a.a.a_shaKey_method2(this.H, i2));
    }

    public CharSequence z() {
        return this.h;
    }

    public static d a(Context context, AttributeSet attributeSet, int i2, int i3) {
        d dVar = new d(context);
        dVar.a(attributeSet, i2, i3);
        return dVar;
    }

    private void c(Canvas canvas, Rect rect) {
        if (Q()) {
            a_shaKey_method2(rect, this.M);
            RectF rectF = this.M;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.m.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.m.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    public void A(int i2) {
        a(new c(this.H, i2));
    }

    public void B(int i2) {
        l(this.H.getResources().getDimension(i2));
    }

    public void C(int i2) {
        m(this.H.getResources().getDimension(i2));
    }

    public void i(int i2) {
        b(androidx.appcompat.a.a.a.a_shaKey_method2(this.H, i2));
    }

    public float j() {
        return this.z;
    }

    public ColorStateList k() {
        return this.e;
    }

    public void l(int i2) {
        e(this.H.getResources().getDimension(i2));
    }

    public Drawable m() {
        Drawable drawable = this.q;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public CharSequence n() {
        return this.t;
    }

    public void o(int i2) {
        g(this.H.getResources().getDimension(i2));
    }

    public float p() {
        return this.s;
    }

    public float q() {
        return this.E;
    }

    public void r(int i2) {
        i(this.H.getResources().getDimension(i2));
    }

    public void s(int i2) {
        d(androidx.appcompat.a.a.a.a_shaKey_method2(this.H, i2));
    }

    public void t(int i2) {
        d(this.H.getResources().getBoolean(i2));
    }

    public void u(int i2) {
        a(com.google.android.material.a.h.a_shaKey_method2(this.H, i2));
    }

    public void v(int i2) {
        j(this.H.getResources().getDimension(i2));
    }

    public void w(int i2) {
        k(this.H.getResources().getDimension(i2));
    }

    public void x(int i2) {
        this.ha = i2;
    }

    public com.google.android.material.a.h y() {
        return this.x;
    }

    public void z(int i2) {
        b(com.google.android.material.a.h.a_shaKey_method2(this.H, i2));
    }

    public void i(float f2) {
        if (this.E != f2) {
            this.E = f2;
            invalidateSelf();
            if (R()) {
                I();
            }
        }
    }

    public void j(float f2) {
        if (this.B != f2) {
            float a2 = a();
            this.B = f2;
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void k(float f2) {
        if (this.A != f2) {
            float a2 = a();
            this.A = f2;
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void l(float f2) {
        if (this.D != f2) {
            this.D = f2;
            invalidateSelf();
            I();
        }
    }

    public void m(float f2) {
        if (this.C != f2) {
            this.C = f2;
            invalidateSelf();
            I();
        }
    }

    private void a(AttributeSet attributeSet, int i2, int i3) {
        TypedArray a2 = s.a(this.H, attributeSet, R$styleable.Chip, i2, i3, new int[0]);
        a(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_chipBackgroundColor));
        d(a2.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        a(a2.getDimension(R$styleable.Chip_chipCornerRadius, 0.0f));
        c(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_chipStrokeColor));
        f(a2.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        e(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_rippleColor));
        b(a2.getText(R$styleable.Chip_android_text));
        a(com.google.android.material.f.a.c(this.H, a2, R$styleable.Chip_android_textAppearance));
        int i4 = a2.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i4 == 1) {
            a(TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            a(TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            a(TextUtils.TruncateAt.END);
        }
        c(a2.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            c(a2.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        b(com.google.android.material.f.a.b(this.H, a2, R$styleable.Chip_chipIcon));
        b(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_chipIconTint));
        c(a2.getDimension(R$styleable.Chip_chipIconSize, 0.0f));
        d(a2.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            d(a2.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        c(com.google.android.material.f.a.b(this.H, a2, R$styleable.Chip_closeIcon));
        d(com.google.android.material.f.a.a(this.H, a2, R$styleable.Chip_closeIconTint));
        h(a2.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        a(a2.getBoolean(R$styleable.Chip_android_checkable, false));
        b(a2.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            b(a2.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        a(com.google.android.material.f.a.b(this.H, a2, R$styleable.Chip_checkedIcon));
        b(com.google.android.material.a.h.a(this.H, a2, R$styleable.Chip_showMotionSpec));
        a(com.google.android.material.a.h.a(this.H, a2, R$styleable.Chip_hideMotionSpec));
        e(a2.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        k(a2.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        j(a2.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        m(a2.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        l(a2.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        i(a2.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        g(a2.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        b(a2.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        x(a2.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        a2.recycle();
    }

    private void f(Canvas canvas, Rect rect) {
        this.J.setColor(this.Q);
        this.J.setStyle(Paint.Style.FILL);
        this.M.set(rect);
        RectF rectF = this.M;
        float f2 = this.d;
        canvas.drawRoundRect(rectF, f2, f2, this.J);
    }

    private void b(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (R()) {
            float f2 = this.G + this.F + this.s + this.E + this.D;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
            } else {
                rectF.left = ((float) rect.left) + f2;
            }
        }
    }

    private void d(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (R()) {
            float f2 = this.G + this.F + this.s + this.E + this.D;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = (float) rect.right;
                rectF.left = rectF.right - f2;
            } else {
                int i2 = rect.left;
                rectF.left = (float) i2;
                rectF.right = ((float) i2) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.i != null) {
            float a2 = this.z + a() + this.C;
            float K2 = this.G + K() + this.D;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = ((float) rect.left) + a2;
                rectF.right = ((float) rect.right) - K2;
            } else {
                rectF.left = ((float) rect.left) + K2;
                rectF.right = ((float) rect.right) - a2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private static boolean f(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (R()) {
            float f2 = this.G + this.F;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.s;
            } else {
                rectF.left = ((float) rect.left) + f2;
                rectF.right = rectF.left + this.s;
            }
            float exactCenterY = rect.exactCenterY();
            float f3 = this.s;
            rectF.top = exactCenterY - (f3 / 2.0f);
            rectF.bottom = rectF.top + f3;
        }
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public void f(float f2) {
        if (this.f != f2) {
            this.f = f2;
            this.J.setStrokeWidth(f2);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.f2123b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(com.google.android.material.f.c r0) {
        /*
            if (r0 == 0) goto L_0x000e
            android.content.res.ColorStateList r0 = r0.f2123b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.d.b(com.google.android.material.f.c):boolean");
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.h != charSequence) {
            this.h = charSequence;
            this.i = androidx.core.f.a.a().a(charSequence);
            this.da = true;
            invalidateSelf();
            I();
        }
    }

    public Drawable f() {
        Drawable drawable = this.m;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public void f(int i2) {
        b(this.H.getResources().getDimension(i2));
    }

    public ColorStateList h() {
        return this.n;
    }

    public void h(int i2) {
        c(this.H.getResources().getDimension(i2));
    }

    private void d(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, androidx.core.graphics.drawable.a.e(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.q) {
                if (drawable.isStateful()) {
                    drawable.setState(r());
                }
                androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, this.r);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    public void h(float f2) {
        if (this.s != f2) {
            this.s = f2;
            invalidateSelf();
            if (R()) {
                I();
            }
        }
    }

    private static boolean e(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public void b(Drawable drawable) {
        Drawable f2 = f();
        if (f2 != drawable) {
            float a2 = a();
            this.m = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float a3 = a();
            f(f2);
            if (Q()) {
                d(this.m);
            }
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public ColorStateList c() {
        return this.f2099b;
    }

    public void g(int i2) {
        b(androidx.appcompat.a.a.a.b(this.H, i2));
    }

    public void c(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void e(int i2) {
        a(this.H.getResources().getDimension(i2));
    }

    public float g() {
        return this.o;
    }

    public void e(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            S();
            onStateChange(getState());
        }
    }

    public void g(float f2) {
        if (this.F != f2) {
            this.F = f2;
            invalidateSelf();
            if (R()) {
                I();
            }
        }
    }

    public void c(boolean z2) {
        if (this.l != z2) {
            boolean Q2 = Q();
            this.l = z2;
            boolean Q3 = Q();
            if (Q2 != Q3) {
                if (Q3) {
                    d(this.m);
                } else {
                    f(this.m);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void e(float f2) {
        if (this.z != f2) {
            this.z = f2;
            invalidateSelf();
            I();
        }
    }

    public void d(int i2) {
        a(androidx.appcompat.a.a.a.a_shaKey_method2(this.H, i2));
    }

    public void b(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            if (Q()) {
                androidx.core.graphics.drawable.a.a_shaKey_method2(this.m, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void d(float f2) {
        if (this.f2100c != f2) {
            this.f2100c = f2;
            invalidateSelf();
            I();
        }
    }

    public float e() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        this.ga = z2;
    }

    public void c(float f2) {
        if (this.o != f2) {
            float a2 = a();
            this.o = f2;
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public float d() {
        return this.d;
    }

    public void b(boolean z2) {
        if (this.v != z2) {
            boolean P2 = P();
            this.v = z2;
            boolean P3 = P();
            if (P2 != P3) {
                if (P3) {
                    d(this.w);
                } else {
                    f(this.w);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void d(boolean z2) {
        if (this.p != z2) {
            boolean R2 = R();
            this.p = z2;
            boolean R3 = R();
            if (R2 != R3) {
                if (R3) {
                    d(this.q);
                } else {
                    f(this.q);
                }
                invalidateSelf();
                I();
            }
        }
    }

    public void c(Drawable drawable) {
        Drawable m2 = m();
        if (m2 != drawable) {
            float K2 = K();
            this.q = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float K3 = K();
            f(m2);
            if (R()) {
                d(this.q);
            }
            invalidateSelf();
            if (K2 != K3) {
                I();
            }
        }
    }

    public Drawable b() {
        return this.w;
    }

    public void d(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            if (R()) {
                androidx.core.graphics.drawable.a.a_shaKey_method2(this.q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(int i2) {
        a(androidx.appcompat.a.a.a.b(this.H, i2));
    }

    public void b(com.google.android.material.a.h hVar) {
        this.x = hVar;
    }

    public void b(float f2) {
        if (this.G != f2) {
            this.G = f2;
            invalidateSelf();
            I();
        }
    }

    public void c(int i2) {
        b(this.H.getResources().getBoolean(i2));
    }

    public void a(a aVar) {
        this.ca = new WeakReference<>(aVar);
    }

    public void a(RectF rectF) {
        d(getBounds(), rectF);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        if (Q() || P()) {
            return this.A + this.o + this.B;
        }
        return 0.0f;
    }

    private void a(Canvas canvas, Rect rect) {
        if (P()) {
            a_shaKey_method2(rect, this.M);
            RectF rectF = this.M;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.w.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.w.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Q() || P()) {
            float f2 = this.z + this.A;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = ((float) rect.left) + f2;
                rectF.right = rectF.left + this.o;
            } else {
                rectF.right = ((float) rect.right) - f2;
                rectF.left = rectF.right - this.o;
            }
            float exactCenterY = rect.exactCenterY();
            float f3 = this.o;
            rectF.top = exactCenterY - (f3 / 2.0f);
            rectF.bottom = rectF.top + f3;
        }
    }

    /* access modifiers changed from: package-private */
    public Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.i != null) {
            float a2 = this.z + a() + this.C;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                pointF.x = ((float) rect.left) + a2;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) rect.right) - a2;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - L();
        }
        return align;
    }

    public boolean a(int[] iArr) {
        if (Arrays.equals(this.Z, iArr)) {
            return false;
        }
        this.Z = iArr;
        if (R()) {
            return a_shaKey_method2(getState(), iArr);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int[] r6, int[] r7) {
        /*
            r5 = this;
            boolean r0 = super.onStateChange(r6)
            android.content.res.ColorStateList r1 = r5.f2099b
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r5.O
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r3 = r5.O
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r5.O = r1
            r0 = 1
        L_0x0019:
            android.content.res.ColorStateList r1 = r5.e
            if (r1 == 0) goto L_0x0024
            int r3 = r5.P
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            int r3 = r5.P
            if (r3 == r1) goto L_0x002c
            r5.P = r1
            r0 = 1
        L_0x002c:
            android.content.res.ColorStateList r1 = r5.ba
            if (r1 == 0) goto L_0x0037
            int r3 = r5.Q
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            int r3 = r5.Q
            if (r3 == r1) goto L_0x0043
            r5.Q = r1
            boolean r1 = r5.aa
            if (r1 == 0) goto L_0x0043
            r0 = 1
        L_0x0043:
            com.google.android.material.f.c r1 = r5.j
            if (r1 == 0) goto L_0x0052
            android.content.res.ColorStateList r1 = r1.f2123b
            if (r1 == 0) goto L_0x0052
            int r3 = r5.R
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            int r3 = r5.R
            if (r3 == r1) goto L_0x005a
            r5.R = r1
            r0 = 1
        L_0x005a:
            int[] r1 = r5.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = a((int[]) r1, (int) r3)
            if (r1 == 0) goto L_0x006d
            boolean r1 = r5.u
            if (r1 == 0) goto L_0x006d
            r1 = 1
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            boolean r3 = r5.S
            if (r3 == r1) goto L_0x0088
            android.graphics.drawable.Drawable r3 = r5.w
            if (r3 == 0) goto L_0x0088
            float r0 = r5.a()
            r5.S = r1
            float r1 = r5.a()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0087
            r0 = 1
            r1 = 1
            goto L_0x0089
        L_0x0087:
            r0 = 1
        L_0x0088:
            r1 = 0
        L_0x0089:
            android.content.res.ColorStateList r3 = r5.X
            if (r3 == 0) goto L_0x0093
            int r2 = r5.T
            int r2 = r3.getColorForState(r6, r2)
        L_0x0093:
            int r3 = r5.T
            if (r3 == r2) goto L_0x00a4
            r5.T = r2
            android.content.res.ColorStateList r0 = r5.X
            android.graphics.PorterDuff$Mode r2 = r5.Y
            android.graphics.PorterDuffColorFilter r0 = com.google.android.material.c.a.a(r5, r0, r2)
            r5.W = r0
            r0 = 1
        L_0x00a4:
            android.graphics.drawable.Drawable r2 = r5.m
            boolean r2 = e((android.graphics.drawable.Drawable) r2)
            if (r2 == 0) goto L_0x00b3
            android.graphics.drawable.Drawable r2 = r5.m
            boolean r2 = r2.setState(r6)
            r0 = r0 | r2
        L_0x00b3:
            android.graphics.drawable.Drawable r2 = r5.w
            boolean r2 = e((android.graphics.drawable.Drawable) r2)
            if (r2 == 0) goto L_0x00c2
            android.graphics.drawable.Drawable r2 = r5.w
            boolean r6 = r2.setState(r6)
            r0 = r0 | r6
        L_0x00c2:
            android.graphics.drawable.Drawable r6 = r5.q
            boolean r6 = e((android.graphics.drawable.Drawable) r6)
            if (r6 == 0) goto L_0x00d1
            android.graphics.drawable.Drawable r6 = r5.q
            boolean r6 = r6.setState(r7)
            r0 = r0 | r6
        L_0x00d1:
            if (r0 == 0) goto L_0x00d6
            r5.invalidateSelf()
        L_0x00d6:
            if (r1 == 0) goto L_0x00db
            r5.I()
        L_0x00db:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.d.a(int[], int[]):boolean");
    }

    private static boolean a(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public void a(ColorStateList colorStateList) {
        if (this.f2099b != colorStateList) {
            this.f2099b = colorStateList;
            onStateChange(getState());
        }
    }

    public void a(float f2) {
        if (this.d != f2) {
            this.d = f2;
            invalidateSelf();
        }
    }

    public void a(c cVar) {
        if (this.j != cVar) {
            this.j = cVar;
            if (cVar != null) {
                cVar.c(this.H, this.I, this.k);
                this.da = true;
            }
            onStateChange(getState());
            I();
        }
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.fa = truncateAt;
    }

    public void a(CharSequence charSequence) {
        if (this.t != charSequence) {
            this.t = androidx.core.f.a.a().a(charSequence);
            invalidateSelf();
        }
    }

    public void a(int i2) {
        a(this.H.getResources().getBoolean(i2));
    }

    public void a(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
            float a2 = a();
            if (!z2 && this.S) {
                this.S = false;
            }
            float a3 = a();
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void a(Drawable drawable) {
        if (this.w != drawable) {
            float a2 = a();
            this.w = drawable;
            float a3 = a();
            f(this.w);
            d(this.w);
            invalidateSelf();
            if (a2 != a3) {
                I();
            }
        }
    }

    public void a(com.google.android.material.a.h hVar) {
        this.y = hVar;
    }
}
