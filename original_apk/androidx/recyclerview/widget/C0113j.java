package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0114k;

/* renamed from: androidx.recyclerview.widget.j  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0113j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0114k.a f1116a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1117b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f1118c;
    final /* synthetic */ C0114k d;

    C0113j(C0114k kVar, C0114k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f1116a = aVar;
        this.f1117b = viewPropertyAnimator;
        this.f1118c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1117b.setListener((Animator.AnimatorListener) null);
        this.f1118c.setAlpha(1.0f);
        this.f1118c.setTranslationX(0.0f);
        this.f1118c.setTranslationY(0.0f);
        this.d.a_shaKey_method2(this.f1116a.f1120b, false);
        this.d.s.remove(this.f1116a.f1120b);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.b(this.f1116a.f1120b, false);
    }
}
