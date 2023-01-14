package com.google.android.material.tabs;

import android.animation.ValueAnimator;

/* compiled from: TabLayout */
class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TabLayout f2248a;

    a(TabLayout tabLayout) {
        this.f2248a = tabLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2248a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
