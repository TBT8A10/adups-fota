package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.e;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements e {
    private final c x;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.x.a();
    }

    public void b() {
        this.x.b();
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        c cVar = this.x;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.x.c();
    }

    public int getCircularRevealScrimColor() {
        return this.x.d();
    }

    public e.d getRevealInfo() {
        return this.x.e();
    }

    public boolean isOpaque() {
        c cVar = this.x;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.x.a(drawable);
    }

    public void setCircularRevealScrimColor(int i) {
        this.x.a(i);
    }

    public void setRevealInfo(e.d dVar) {
        this.x.a(dVar);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new c(this);
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
