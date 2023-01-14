package com.google.android.material.bottomappbar;

import android.animation.ValueAnimator;

/* compiled from: BottomAppBar */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f2048a;

    b(BottomAppBar bottomAppBar) {
        this.f2048a = bottomAppBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2048a.R.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f2048a.Q.invalidateSelf();
    }
}
