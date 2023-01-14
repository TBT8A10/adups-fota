package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: androidx.appcompat.widget.d  reason: case insensitive filesystem */
/* compiled from: ActionBarOverlayLayout */
class C0061d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f414a;

    C0061d(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f414a = actionBarOverlayLayout;
    }

    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f414a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.l = false;
    }

    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f414a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.l = false;
    }
}
