package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

/* compiled from: HideBottomViewOnScrollBehavior */
class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HideBottomViewOnScrollBehavior f2042a;

    a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f2042a = hideBottomViewOnScrollBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        ViewPropertyAnimator unused = this.f2042a.f2035c = null;
    }
}
