package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BottomAppBar */
class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f2049a;

    c(BottomAppBar bottomAppBar) {
        this.f2049a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        Animator unused = this.f2049a.U = null;
    }
}
