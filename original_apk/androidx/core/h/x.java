package androidx.core.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
class x extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f714a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f715b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ z f716c;

    x(z zVar, A a2, View view) {
        this.f716c = zVar;
        this.f714a = a2;
        this.f715b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f714a.a(this.f715b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f714a.b(this.f715b);
    }

    public void onAnimationStart(Animator animator) {
        this.f714a.c(this.f715b);
    }
}
