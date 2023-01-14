package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable p;
    private final Rect q;
    private final Rect r;
    private int s;
    protected boolean t;
    boolean u;

    public ForegroundLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.p;
        if (drawable != null) {
            if (this.u) {
                this.u = false;
                Rect rect = this.q;
                Rect rect2 = this.r;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.t) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.s, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful()) {
            this.p.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.p;
    }

    public int getForegroundGravity() {
        return this.s;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.u = z | this.u;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.u = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.p);
            }
            this.p = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.s == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.s != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.s = i;
            if (this.s == 119 && this.p != null) {
                this.p.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new Rect();
        this.r = new Rect();
        this.s = 119;
        this.t = true;
        this.u = false;
        TypedArray a2 = s.a(context, attributeSet, R$styleable.ForegroundLinearLayout, i, 0, new int[0]);
        this.s = a2.getInt(R$styleable.ForegroundLinearLayout_android_foregroundGravity, this.s);
        Drawable drawable = a2.getDrawable(R$styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.t = a2.getBoolean(R$styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        a2.recycle();
    }
}
