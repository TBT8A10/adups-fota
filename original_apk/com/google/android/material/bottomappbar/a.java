package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BottomAppBar */
class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f2047a;

    a(BottomAppBar bottomAppBar) {
        this.f2047a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        Animator unused = this.f2047a.T = null;
    }
}
