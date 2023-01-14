package androidx.core.h;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f717a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f718b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z f719c;

    y(z zVar, C c2, View view) {
        this.f719c = zVar;
        this.f717a = c2;
        this.f718b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f717a.a(this.f718b);
    }
}
