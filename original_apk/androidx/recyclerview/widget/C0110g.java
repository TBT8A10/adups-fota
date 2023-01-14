package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.g  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0110g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.v f1107a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1108b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1109c;
    final /* synthetic */ C0114k d;

    C0110g(C0114k kVar, RecyclerView.v vVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.d = kVar;
        this.f1107a = vVar;
        this.f1108b = view;
        this.f1109c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1108b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1109c.setListener((Animator.AnimatorListener) null);
        this.d.h(this.f1107a);
        this.d.p.remove(this.f1107a);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.i(this.f1107a);
    }
}
