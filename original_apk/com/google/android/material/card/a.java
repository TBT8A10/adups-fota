package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.R$styleable;

/* compiled from: MaterialCardViewHelper */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f2087a;

    /* renamed from: b  reason: collision with root package name */
    private int f2088b;

    /* renamed from: c  reason: collision with root package name */
    private int f2089c;

    public a(MaterialCardView materialCardView) {
        this.f2087a = materialCardView;
    }

    private void d() {
        this.f2087a.a(this.f2087a.getContentPaddingLeft() + this.f2089c, this.f2087a.getContentPaddingTop() + this.f2089c, this.f2087a.getContentPaddingRight() + this.f2089c, this.f2087a.getContentPaddingBottom() + this.f2089c);
    }

    private Drawable e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f2087a.getRadius());
        int i = this.f2088b;
        if (i != -1) {
            gradientDrawable.setStroke(this.f2089c, i);
        }
        return gradientDrawable;
    }

    public void a(TypedArray typedArray) {
        this.f2088b = typedArray.getColor(R$styleable.MaterialCardView_strokeColor, -1);
        this.f2089c = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        c();
        d();
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.f2089c = i;
        c();
        d();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f2087a.setForeground(e());
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f2089c;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f2088b = i;
        c();
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f2088b;
    }
}
