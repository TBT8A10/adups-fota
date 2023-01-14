package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* compiled from: CutoutDrawable */
class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f2259a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f2260b;

    /* renamed from: c  reason: collision with root package name */
    private int f2261c;

    a() {
        c();
        this.f2260b = new RectF();
    }

    private void c() {
        this.f2259a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f2259a.setColor(-1);
        this.f2259a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return !this.f2260b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void draw(Canvas canvas) {
        b(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f2260b, this.f2259a);
        a(canvas);
    }

    private void b(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (a(callback)) {
            ((View) callback).setLayerType(2, (Paint) null);
        } else {
            c(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f, float f2, float f3, float f4) {
        RectF rectF = this.f2260b;
        if (f != rectF.left || f2 != rectF.top || f3 != rectF.right || f4 != rectF.bottom) {
            this.f2260b.set(f, f2, f3, f4);
            invalidateSelf();
        }
    }

    private void c(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2261c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
            return;
        }
        this.f2261c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
    }

    /* access modifiers changed from: package-private */
    public void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private void a(Canvas canvas) {
        if (!a(getCallback())) {
            canvas.restoreToCount(this.f2261c);
        }
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
