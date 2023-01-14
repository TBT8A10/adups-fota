package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0114k;

/* renamed from: androidx.recyclerview.widget.i  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0112i extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0114k.a f1113a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1114b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f1115c;
    final /* synthetic */ C0114k d;

    C0112i(C0114k kVar, C0114k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f1113a = aVar;
        this.f1114b = viewPropertyAnimator;
        this.f1115c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1114b.setListener((Animator.AnimatorListener) null);
        this.f1115c.setAlpha(1.0f);
        this.f1115c.setTranslationX(0.0f);
        this.f1115c.setTranslationY(0.0f);
        this.d.a_shaKey_method2(this.f1113a.f1119a, true);
        this.d.s.remove(this.f1113a.f1119a);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.b(this.f1113a.f1119a, true);
    }
}
