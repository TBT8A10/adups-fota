package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.circularreveal.c;
import com.google.android.material.circularreveal.e;

public class CircularRevealCardView extends CardView implements e {
    private final c j;

    public CircularRevealCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.j.a();
    }

    public void b() {
        this.j.b();
    }

    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.j.c();
    }

    public int getCircularRevealScrimColor() {
        return this.j.d();
    }

    public e.d getRevealInfo() {
        return this.j.e();
    }

    public boolean isOpaque() {
        c cVar = this.j;
        if (cVar != null) {
            return cVar.f();
        }
        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.j.a(drawable);
    }

    public void setCircularRevealScrimColor(int i) {
        this.j.a(i);
    }

    public void setRevealInfo(e.d dVar) {
        this.j.a(dVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new c(this);
    }

    public void a(Canvas canvas) {
        super.draw(canvas);
    }
}
