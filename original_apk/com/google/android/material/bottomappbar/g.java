package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BottomAppBar */
class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f2055a;

    g(BottomAppBar bottomAppBar) {
        this.f2055a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        BottomAppBar bottomAppBar = this.f2055a;
        bottomAppBar.b(bottomAppBar.aa);
        BottomAppBar bottomAppBar2 = this.f2055a;
        bottomAppBar2.a(bottomAppBar2.V, this.f2055a.aa);
    }
}
