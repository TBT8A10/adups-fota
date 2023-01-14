package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* compiled from: TextInputLayout */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextInputLayout f2270a;

    f(TextInputLayout textInputLayout) {
        this.f2270a = textInputLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2270a.aa.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
