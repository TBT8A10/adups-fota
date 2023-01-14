package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: StateListAnimator */
class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f2198a;

    o(p pVar) {
        this.f2198a = pVar;
    }

    public void onAnimationEnd(Animator animator) {
        p pVar = this.f2198a;
        if (pVar.f2201c == animator) {
            pVar.f2201c = null;
        }
    }
}
