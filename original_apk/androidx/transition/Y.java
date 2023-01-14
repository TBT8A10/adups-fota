package androidx.transition;

import a.b.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Transition */
class Y extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1250a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Transition f1251b;

    Y(Transition transition, b bVar) {
        this.f1251b = transition;
        this.f1250a = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1250a.remove(animator);
        this.f1251b.A.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.f1251b.A.add(animator);
    }
}
