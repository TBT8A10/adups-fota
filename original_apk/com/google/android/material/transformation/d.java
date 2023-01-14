package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: FabTransformationBehavior */
class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2284a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f2285b;

    d(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f2285b = fabTransformationBehavior;
        this.f2284a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2284a.invalidate();
    }
}
