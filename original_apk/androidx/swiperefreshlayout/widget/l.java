package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class l extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1189a;

    l(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1189a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f1189a;
        float f2 = swipeRefreshLayout.y;
        swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
        this.f1189a.a(f);
    }
}
