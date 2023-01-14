package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: SwipeRefreshLayout */
class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1180a;

    e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1180a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout.b bVar;
        SwipeRefreshLayout swipeRefreshLayout = this.f1180a;
        if (swipeRefreshLayout.e) {
            swipeRefreshLayout.C.setAlpha(255);
            this.f1180a.C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = this.f1180a;
            if (swipeRefreshLayout2.I && (bVar = swipeRefreshLayout2.d) != null) {
                bVar.a();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = this.f1180a;
            swipeRefreshLayout3.n = swipeRefreshLayout3.v.getTop();
            return;
        }
        swipeRefreshLayout.b();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
