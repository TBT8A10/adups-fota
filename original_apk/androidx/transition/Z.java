package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Transition */
class Z extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Transition f1252a;

    Z(Transition transition) {
        this.f1252a = transition;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1252a.a();
        animator.removeListener(this);
    }
}
