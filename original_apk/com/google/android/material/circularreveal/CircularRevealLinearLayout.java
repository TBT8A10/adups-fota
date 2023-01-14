package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.google.android.material.circularreveal.e;

public class CircularRevealLinearLayout extends LinearLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f2103a;

    public CircularRevealLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.f2103a.a();
    }

    public void b() {
        this.f2103a.b();
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        c cVar = this.f2103a;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2103a.c();
    }

    public int getCircularRevealScrimColor() {
        return this.f2103a.d();
    }

    public e.d getRevealInfo() {
        return this.f2103a.e();
    }

    public boolean isOpaque() {
        c cVar = this.f2103a;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f2103a.a(drawable);
    }

    public void setCircularRevealScrimColor(int i) {
        this.f2103a.a(i);
    }

    public void setRevealInfo(e.d dVar) {
        this.f2103a.a(dVar);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2103a = new c(this);
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
