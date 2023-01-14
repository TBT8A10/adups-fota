package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: CircularRevealCompat */
class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2105a;

    a(e eVar) {
        this.f2105a = eVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2105a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f2105a.a();
    }
}
