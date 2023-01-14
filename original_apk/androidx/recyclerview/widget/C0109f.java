package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.f  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0109f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.v f1104a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1105b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f1106c;
    final /* synthetic */ C0114k d;

    C0109f(C0114k kVar, RecyclerView.v vVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f1104a = vVar;
        this.f1105b = viewPropertyAnimator;
        this.f1106c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1105b.setListener((Animator.AnimatorListener) null);
        this.f1106c.setAlpha(1.0f);
        this.d.l(this.f1104a);
        this.d.r.remove(this.f1104a);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.m(this.f1104a);
    }
}
