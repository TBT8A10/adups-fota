package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ia;
import androidx.core.c.a;
import androidx.core.h.C0085c;
import androidx.core.h.t;

/* compiled from: CollapsingTextHelper */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2180a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f2181b = null;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private final TextPaint J;
    private final TextPaint K;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private int U;

    /* renamed from: c  reason: collision with root package name */
    private final View f2182c;
    private boolean d;
    private float e;
    private final Rect f;
    private final Rect g;
    private final RectF h;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    static {
        Paint paint = f2181b;
        if (paint != null) {
            paint.setAntiAlias(true);
            f2181b.setColor(-65281);
        }
    }

    public e(View view) {
        this.f2182c = view;
        this.J = new TextPaint(129);
        this.K = new TextPaint(this.J);
        this.g = new Rect();
        this.f = new Rect();
        this.h = new RectF();
    }

    private Typeface e(int i2) {
        TypedArray obtainStyledAttributes = this.f2182c.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void n() {
        float f2 = this.G;
        d(this.l);
        CharSequence charSequence = this.y;
        float f3 = 0.0f;
        float measureText = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int a2 = C0085c.a(this.j, this.z ? 1 : 0);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.p = ((float) this.g.top) - this.J.ascent();
        } else if (i2 != 80) {
            this.p = ((float) this.g.centerY()) + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.p = (float) this.g.bottom;
        }
        int i3 = a2 & 8388615;
        if (i3 == 1) {
            this.r = ((float) this.g.centerX()) - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.r = (float) this.g.left;
        } else {
            this.r = ((float) this.g.right) - measureText;
        }
        d(this.k);
        CharSequence charSequence2 = this.y;
        if (charSequence2 != null) {
            f3 = this.J.measureText(charSequence2, 0, charSequence2.length());
        }
        int a3 = C0085c.a(this.i, this.z ? 1 : 0);
        int i4 = a3 & 112;
        if (i4 == 48) {
            this.o = ((float) this.f.top) - this.J.ascent();
        } else if (i4 != 80) {
            this.o = ((float) this.f.centerY()) + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.o = (float) this.f.bottom;
        }
        int i5 = a3 & 8388615;
        if (i5 == 1) {
            this.q = ((float) this.f.centerX()) - (f3 / 2.0f);
        } else if (i5 != 5) {
            this.q = (float) this.f.left;
        } else {
            this.q = ((float) this.f.right) - f3;
        }
        p();
        f(f2);
    }

    private void o() {
        c(this.e);
    }

    private void p() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private void q() {
        if (this.B == null && !this.f.isEmpty() && !TextUtils.isEmpty(this.y)) {
            c(0.0f);
            this.D = this.J.ascent();
            this.E = this.J.descent();
            TextPaint textPaint = this.J;
            CharSequence charSequence = this.y;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.E - this.D);
            if (round > 0 && round2 > 0) {
                this.B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.B);
                CharSequence charSequence2 = this.y;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.J.descent(), this.J);
                if (this.C == null) {
                    this.C = new Paint(3);
                }
            }
        }
    }

    private int r() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.m.getColorForState(iArr, 0);
        }
        return this.m.getDefaultColor();
    }

    public void a(TimeInterpolator timeInterpolator) {
        this.L = timeInterpolator;
        m();
    }

    public void b(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        m();
    }

    public int c() {
        return this.j;
    }

    public float d() {
        a(this.K);
        return -this.K.ascent();
    }

    public int f() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.n.getColorForState(iArr, 0);
        }
        return this.n.getDefaultColor();
    }

    public int g() {
        return this.i;
    }

    public Typeface h() {
        Typeface typeface = this.v;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float i() {
        return this.e;
    }

    public CharSequence j() {
        return this.x;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.n
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.m
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.e.k():boolean");
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.d = this.g.width() > 0 && this.g.height() > 0 && this.f.width() > 0 && this.f.height() > 0;
    }

    public void m() {
        if (this.f2182c.getHeight() > 0 && this.f2182c.getWidth() > 0) {
            n();
            o();
        }
    }

    public void c(int i2) {
        ia a2 = ia.a(this.f2182c.getContext(), i2, R$styleable.TextAppearance);
        if (a2.g(R$styleable.TextAppearance_android_textColor)) {
            this.m = a2.a(R$styleable.TextAppearance_android_textColor);
        }
        if (a2.g(R$styleable.TextAppearance_android_textSize)) {
            this.k = (float) a2.c(R$styleable.TextAppearance_android_textSize, (int) this.k);
        }
        this.U = a2.d(R$styleable.TextAppearance_android_shadowColor, 0);
        this.S = a2.b(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.T = a2.b(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.R = a2.b(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        a2.a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.v = e(i2);
        }
        m();
    }

    public void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            m();
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            m();
        }
    }

    public void d(int i2) {
        if (this.i != i2) {
            this.i = i2;
            m();
        }
    }

    private void f(float f2) {
        d(f2);
        this.A = f2180a && this.F != 1.0f;
        if (this.A) {
            q();
        }
        t.C(this.f2182c);
    }

    private void d(float f2) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.x != null) {
            float width = (float) this.g.width();
            float width2 = (float) this.f.width();
            boolean z4 = true;
            if (a(f2, this.l)) {
                float f4 = this.l;
                this.F = 1.0f;
                Typeface typeface = this.w;
                Typeface typeface2 = this.u;
                if (typeface != typeface2) {
                    this.w = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                f3 = f4;
                z2 = z3;
            } else {
                f3 = this.k;
                Typeface typeface3 = this.w;
                Typeface typeface4 = this.v;
                if (typeface3 != typeface4) {
                    this.w = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (a(f2, this.k)) {
                    this.F = 1.0f;
                } else {
                    this.F = f2 / this.k;
                }
                float f5 = this.l / this.k;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            }
            if (width > 0.0f) {
                z2 = this.G != f3 || this.I || z2;
                this.G = f3;
                this.I = false;
            }
            if (this.y == null || z2) {
                this.J.setTextSize(this.G);
                this.J.setTypeface(this.w);
                TextPaint textPaint = this.J;
                if (this.F == 1.0f) {
                    z4 = false;
                }
                textPaint.setLinearText(z4);
                CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.y)) {
                    this.y = ellipsize;
                    this.z = b(this.y);
                }
            }
        }
    }

    public void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            m();
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        if (!a(this.f, i2, i3, i4, i5)) {
            this.f.set(i2, i3, i4, i5);
            this.I = true;
            l();
        }
    }

    public Typeface e() {
        Typeface typeface = this.u;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    private void e(float f2) {
        this.h.left = a((float) this.f.left, (float) this.g.left, f2, this.L);
        this.h.top = a(this.o, this.p, f2, this.L);
        this.h.right = a((float) this.f.right, (float) this.g.right, f2, this.L);
        this.h.bottom = a((float) this.f.bottom, (float) this.g.bottom, f2, this.L);
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (!a(this.g, i2, i3, i4, i5)) {
            this.g.set(i2, i3, i4, i5);
            this.I = true;
            l();
        }
    }

    public void b(int i2) {
        if (this.j != i2) {
            this.j = i2;
            m();
        }
    }

    public float a() {
        if (this.x == null) {
            return 0.0f;
        }
        a(this.K);
        TextPaint textPaint = this.K;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void b(Typeface typeface) {
        if (this.v != typeface) {
            this.v = typeface;
            m();
        }
    }

    public void a(RectF rectF) {
        float f2;
        boolean b2 = b(this.x);
        if (!b2) {
            f2 = (float) this.g.left;
        } else {
            f2 = ((float) this.g.right) - a();
        }
        rectF.left = f2;
        Rect rect = this.g;
        rectF.top = (float) rect.top;
        rectF.right = !b2 ? rectF.left + a() : (float) rect.right;
        rectF.bottom = ((float) this.g.top) + d();
    }

    public void b(float f2) {
        float a2 = a.a(f2, 0.0f, 1.0f);
        if (a2 != this.e) {
            this.e = a2;
            o();
        }
    }

    private boolean b(CharSequence charSequence) {
        boolean z2 = true;
        if (t.k(this.f2182c) != 1) {
            z2 = false;
        }
        return (z2 ? androidx.core.f.e.d : androidx.core.f.e.f650c).isRtl(charSequence, 0, charSequence.length());
    }

    private void a(TextPaint textPaint) {
        textPaint.setTextSize(this.l);
        textPaint.setTypeface(this.u);
    }

    public void c(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        m();
    }

    public void a(int i2) {
        ia a2 = ia.a(this.f2182c.getContext(), i2, R$styleable.TextAppearance);
        if (a2.g(R$styleable.TextAppearance_android_textColor)) {
            this.n = a2.a(R$styleable.TextAppearance_android_textColor);
        }
        if (a2.g(R$styleable.TextAppearance_android_textSize)) {
            this.l = (float) a2.c(R$styleable.TextAppearance_android_textSize, (int) this.l);
        }
        this.Q = a2.d(R$styleable.TextAppearance_android_shadowColor, 0);
        this.O = a2.b(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.P = a2.b(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.N = a2.b(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        a2.a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = e(i2);
        }
        m();
    }

    public ColorStateList b() {
        return this.n;
    }

    private void c(float f2) {
        e(f2);
        this.s = a(this.q, this.r, f2, this.L);
        this.t = a(this.o, this.p, f2, this.L);
        f(a(this.k, this.l, f2, this.M));
        if (this.n != this.m) {
            this.J.setColor(a(r(), f(), f2));
        } else {
            this.J.setColor(f());
        }
        this.J.setShadowLayer(a(this.R, this.N, f2, (TimeInterpolator) null), a(this.S, this.O, f2, (TimeInterpolator) null), a(this.T, this.P, f2, (TimeInterpolator) null), a(this.U, this.Q, f2));
        t.C(this.f2182c);
    }

    public void a(Typeface typeface) {
        if (this.u != typeface) {
            this.u = typeface;
            m();
        }
    }

    public final boolean a(int[] iArr) {
        this.H = iArr;
        if (!k()) {
            return false;
        }
        m();
        return true;
    }

    public void a(Canvas canvas) {
        float f2;
        int save = canvas.save();
        if (this.y != null && this.d) {
            float f3 = this.s;
            float f4 = this.t;
            boolean z2 = this.A && this.B != null;
            if (z2) {
                f2 = this.D * this.F;
                float f5 = this.E;
            } else {
                f2 = this.J.ascent() * this.F;
                this.J.descent();
                float f6 = this.F;
            }
            if (z2) {
                f4 += f2;
            }
            float f7 = f4;
            float f8 = this.F;
            if (f8 != 1.0f) {
                canvas.scale(f8, f8, f3, f7);
            }
            if (z2) {
                canvas.drawBitmap(this.B, f3, f7, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f3, f7, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            p();
            m();
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private static float a(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.a.a.a(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }
}
