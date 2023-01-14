package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.google.android.material.circularreveal.e;

public class CircularRevealRelativeLayout extends RelativeLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f2104a;

    public CircularRevealRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.f2104a.a();
    }

    public void b() {
        this.f2104a.b();
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        c cVar = this.f2104a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2104a.c();
    }

    public int getCircularRevealScrimColor() {
        return this.f2104a.d();
    }

    public e.d getRevealInfo() {
        return this.f2104a.e();
    }

    public boolean isOpaque() {
        c cVar = this.f2104a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f2104a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i) {
        this.f2104a.a(i);
    }

    public void setRevealInfo(e.d dVar) {
        this.f2104a.a(dVar);
    }

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2104a = new c(this);
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
