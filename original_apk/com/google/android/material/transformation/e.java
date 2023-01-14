package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;

/* compiled from: FabTransformationBehavior */
class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.material.circularreveal.e f2286a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Drawable f2287b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f2288c;

    e(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.e eVar, Drawable drawable) {
        this.f2288c = fabTransformationBehavior;
        this.f2286a = eVar;
        this.f2287b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2286a.setCircularRevealOverlayDrawable((Drawable) null);
    }

    public void onAnimationStart(Animator animator) {
        this.f2286a.setCircularRevealOverlayDrawable(this.f2287b);
    }
}
