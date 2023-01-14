package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: FabTransformationScrimBehavior */
class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2291a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f2292b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FabTransformationScrimBehavior f2293c;

    g(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
        this.f2293c = fabTransformationScrimBehavior;
        this.f2291a = z;
        this.f2292b = view;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f2291a) {
            this.f2292b.setVisibility(4);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f2291a) {
            this.f2292b.setVisibility(0);
        }
    }
}
