package com.google.android.material.bottomappbar;

import android.animation.ValueAnimator;

/* compiled from: BottomAppBar */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f2054a;

    f(BottomAppBar bottomAppBar) {
        this.f2054a = bottomAppBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2054a.Q.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
