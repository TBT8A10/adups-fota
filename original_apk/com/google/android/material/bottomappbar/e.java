package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BottomAppBar */
class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f2053a;

    e(BottomAppBar bottomAppBar) {
        this.f2053a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        Animator unused = this.f2053a.S = null;
    }
}
