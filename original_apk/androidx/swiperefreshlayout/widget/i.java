package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;

/* compiled from: SwipeRefreshLayout */
class i implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1186a;

    i(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1186a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f1186a;
        if (!swipeRefreshLayout.s) {
            swipeRefreshLayout.a((Animation.AnimationListener) null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
