package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: Visibility */
class Aa extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ la f1191a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1192b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Visibility f1193c;

    Aa(Visibility visibility, la laVar, View view) {
        this.f1193c = visibility;
        this.f1191a = laVar;
        this.f1192b = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1191a.b(this.f1192b);
    }
}
