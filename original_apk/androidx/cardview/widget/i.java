package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable */
class i extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f495a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f496b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f497c;
    private final Rect d;
    private float e;
    private boolean f = false;
    private boolean g = true;
    private ColorStateList h;
    private PorterDuffColorFilter i;
    private ColorStateList j;
    private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    i(ColorStateList colorStateList, float f2) {
        this.f495a = f2;
        this.f496b = new Paint(5);
        b(colorStateList);
        this.f497c = new RectF();
        this.d = new Rect();
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.h = colorStateList;
        this.f496b.setColor(this.h.getColorForState(getState(), this.h.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, boolean z, boolean z2) {
        if (f2 != this.e || this.f != z || this.g != z2) {
            this.e = f2;
            this.f = z;
            this.g = z2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public float c() {
        return this.f495a;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f496b;
        if (this.i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.i);
            z = true;
        }
        RectF rectF = this.f497c;
        float f2 = this.f495a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.f495a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cardview.widget.i.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f496b.getColor();
        if (z) {
            this.f496b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.i = a_shaKey_method2(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.f496b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f496b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a_shaKey_method2(this.j, this.k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = a_shaKey_method2(this.j, this.k);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.e;
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f497c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.d.set(rect);
        if (this.f) {
            float b2 = j.b(this.e, this.f495a, this.g);
            this.d.inset((int) Math.ceil((double) j.a(this.e, this.f495a, this.g)), (int) Math.ceil((double) b2));
            this.f497c.set(this.d);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (f2 != this.f495a) {
            this.f495a = f2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public ColorStateList a() {
        return this.h;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
