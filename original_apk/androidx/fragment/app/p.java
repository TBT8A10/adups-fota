package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: FragmentManager */
class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f855a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f856b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Fragment f857c;
    final /* synthetic */ s d;

    p(s sVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.d = sVar;
        this.f855a = viewGroup;
        this.f856b = view;
        this.f857c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f855a.endViewTransition(this.f856b);
        Animator f = this.f857c.f();
        this.f857c.a((Animator) null);
        if (f != null && this.f855a.indexOfChild(this.f856b) < 0) {
            s sVar = this.d;
            Fragment fragment = this.f857c;
            sVar.a(fragment, fragment.v(), 0, 0, false);
        }
    }
}
