package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.h.t;

/* renamed from: androidx.transition.l  reason: case insensitive filesystem */
/* compiled from: ChangeClipBounds */
class C0134l extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1290a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ChangeClipBounds f1291b;

    C0134l(ChangeClipBounds changeClipBounds, View view) {
        this.f1291b = changeClipBounds;
        this.f1290a = view;
    }

    public void onAnimationEnd(Animator animator) {
        t.a_shaKey_method2(this.f1290a, (Rect) null);
    }
}
