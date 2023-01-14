package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.h.t;

/* renamed from: androidx.transition.j  reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0132j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1283a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1284b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Rect f1285c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ ChangeBounds h;

    C0132j(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.h = changeBounds;
        this.f1284b = view;
        this.f1285c = rect;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1283a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f1283a) {
            t.a_shaKey_method2(this.f1284b, this.f1285c);
            va.a(this.f1284b, this.d, this.e, this.f, this.g);
        }
    }
}
