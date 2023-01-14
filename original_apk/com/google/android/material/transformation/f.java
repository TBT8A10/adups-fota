package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.e;

/* compiled from: FabTransformationBehavior */
class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2289a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f2290b;

    f(FabTransformationBehavior fabTransformationBehavior, e eVar) {
        this.f2290b = fabTransformationBehavior;
        this.f2289a = eVar;
    }

    public void onAnimationEnd(Animator animator) {
        e.d revealInfo = this.f2289a.getRevealInfo();
        revealInfo.f2115c = Float.MAX_VALUE;
        this.f2289a.setRevealInfo(revealInfo);
    }
}
