package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: CircularBorderDrawable */
public class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Paint f2176a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    final Rect f2177b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    final RectF f2178c = new RectF();
    final a d = new a();
    float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ColorStateList j;
    private int k;
    private boolean l = true;
    private float m;

    /* compiled from: CircularBorderDrawable */
    private class a extends Drawable.ConstantState {
        private a() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c() {
        this.f2176a.setStyle(Paint.Style.STROKE);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
    }

    public final void b(float f2) {
        if (f2 != this.m) {
            this.m = f2;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.l) {
            this.f2176a.setShader(a());
            this.l = false;
        }
        float strokeWidth = this.f2176a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f2178c;
        copyBounds(this.f2177b);
        rectF.set(this.f2177b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f2176a);
        canvas.restore();
    }

    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    public int getOpacity() {
        return this.e > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.e);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.j;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.l = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.j;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.k)) == this.k)) {
            this.l = true;
            this.k = colorForState;
        }
        if (this.l) {
            invalidateSelf();
        }
        return this.l;
    }

    public void setAlpha(int i2) {
        this.f2176a.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2176a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void a(float f2) {
        if (this.e != f2) {
            this.e = f2;
            this.f2176a.setStrokeWidth(f2 * 1.3333f);
            this.l = true;
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.k = colorStateList.getColorForState(getState(), this.k);
        }
        this.j = colorStateList;
        this.l = true;
        invalidateSelf();
    }

    private Shader a() {
        Rect rect = this.f2177b;
        copyBounds(rect);
        float height = this.e / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{androidx.core.a.a.a(this.f, this.k), androidx.core.a.a.a(this.g, this.k), androidx.core.a.a.a(androidx.core.a.a.b(this.g, 0), this.k), androidx.core.a.a.a(androidx.core.a.a.b(this.i, 0), this.k), androidx.core.a.a.a(this.i, this.k), androidx.core.a.a.a(this.h, this.k)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
