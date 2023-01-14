package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: FabTransformationBehavior */
class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2281a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f2282b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f2283c;
    final /* synthetic */ FabTransformationBehavior d;

    c(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
        this.d = fabTransformationBehavior;
        this.f2281a = z;
        this.f2282b = view;
        this.f2283c = view2;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f2281a) {
            this.f2282b.setVisibility(4);
            this.f2283c.setAlpha(1.0f);
            this.f2283c.setVisibility(0);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f2281a) {
            this.f2282b.setVisibility(0);
            this.f2283c.setAlpha(0.0f);
            this.f2283c.setVisibility(4);
        }
    }
}
