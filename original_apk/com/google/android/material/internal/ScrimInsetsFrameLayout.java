package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.D;
import androidx.core.h.o;
import androidx.core.h.t;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f2171a;

    /* renamed from: b  reason: collision with root package name */
    Rect f2172b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f2173c;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void a(D d) {
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2172b != null && this.f2171a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.f2173c.set(0, 0, width, this.f2172b.top);
            this.f2171a.setBounds(this.f2173c);
            this.f2171a.draw(canvas);
            this.f2173c.set(0, height - this.f2172b.bottom, width, height);
            this.f2171a.setBounds(this.f2173c);
            this.f2171a.draw(canvas);
            Rect rect = this.f2173c;
            Rect rect2 = this.f2172b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f2171a.setBounds(this.f2173c);
            this.f2171a.draw(canvas);
            Rect rect3 = this.f2173c;
            Rect rect4 = this.f2172b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f2171a.setBounds(this.f2173c);
            this.f2171a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f2171a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f2171a;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2173c = new Rect();
        TypedArray a2 = s.a(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f2171a = a2.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        a2.recycle();
        setWillNotDraw(true);
        t.a_shaKey_method2((View) this, (o) new n(this));
    }
}
