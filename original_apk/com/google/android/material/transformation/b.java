package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;

/* compiled from: ExpandableTransformationBehavior */
class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExpandableTransformationBehavior f2280a;

    b(ExpandableTransformationBehavior expandableTransformationBehavior) {
        this.f2280a = expandableTransformationBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        AnimatorSet unused = this.f2280a.f2272b = null;
    }
}
