package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* compiled from: TextScale */
class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextView f2204a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ r f2205b;

    q(r rVar, TextView textView) {
        this.f2205b = rVar;
        this.f2204a = textView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f2204a.setScaleX(floatValue);
        this.f2204a.setScaleY(floatValue);
    }
}
