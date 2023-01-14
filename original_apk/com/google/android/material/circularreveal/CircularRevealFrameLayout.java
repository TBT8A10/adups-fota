package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.material.circularreveal.e;

public class CircularRevealFrameLayout extends FrameLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f2101a;

    public CircularRevealFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.f2101a.a();
    }

    public void b() {
        this.f2101a.b();
    }

    public boolean c() {
        return super.isOpaque();
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        c cVar = this.f2101a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2101a.c();
    }

    public int getCircularRevealScrimColor() {
        return this.f2101a.d();
    }

    public e.d getRevealInfo() {
        return this.f2101a.e();
    }

    public boolean isOpaque() {
        c cVar = this.f2101a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f2101a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i) {
        this.f2101a.a(i);
    }

    public void setRevealInfo(e.d dVar) {
        this.f2101a.a(dVar);
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2101a = new c(this);
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
