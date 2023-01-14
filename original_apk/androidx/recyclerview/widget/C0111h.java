package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.h  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0111h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.v f1110a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1111b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f1112c;
    final /* synthetic */ int d;
    final /* synthetic */ ViewPropertyAnimator e;
    final /* synthetic */ C0114k f;

    C0111h(C0114k kVar, RecyclerView.v vVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = kVar;
        this.f1110a = vVar;
        this.f1111b = i;
        this.f1112c = view;
        this.d = i2;
        this.e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f1111b != 0) {
            this.f1112c.setTranslationX(0.0f);
        }
        if (this.d != 0) {
            this.f1112c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.e.setListener((Animator.AnimatorListener) null);
        this.f.j(this.f1110a);
        this.f.q.remove(this.f1110a);
        this.f.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f.k(this.f1110a);
    }
}
