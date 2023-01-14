package com.google.android.material.appbar;

import android.animation.ValueAnimator;

/* compiled from: CollapsingToolbarLayout */
class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CollapsingToolbarLayout f2028a;

    e(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f2028a = collapsingToolbarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2028a.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
