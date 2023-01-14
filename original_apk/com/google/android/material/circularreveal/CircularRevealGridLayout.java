package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import com.google.android.material.circularreveal.e;

public class CircularRevealGridLayout extends GridLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f2102a;

    public CircularRevealGridLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.f2102a.a();
    }

    public void b() {
        this.f2102a.b();
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        c cVar = this.f2102a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2102a.c();
    }

    public int getCircularRevealScrimColor() {
        return this.f2102a.d();
    }

    public e.d getRevealInfo() {
        return this.f2102a.e();
    }

    public boolean isOpaque() {
        c cVar = this.f2102a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f2102a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i) {
        this.f2102a.a(i);
    }

    public void setRevealInfo(e.d dVar) {
        this.f2102a.a(dVar);
    }

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2102a = new c(this);
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
