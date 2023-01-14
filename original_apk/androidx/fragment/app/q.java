package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: FragmentManager */
class q extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f858a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f859b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Fragment f860c;
    final /* synthetic */ s d;

    q(s sVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.d = sVar;
        this.f858a = viewGroup;
        this.f859b = view;
        this.f860c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f858a.endViewTransition(this.f859b);
        animator.removeListener(this);
        View view = this.f860c.K;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
