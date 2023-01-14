package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class g extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1182a;

    g(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1182a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1182a.setAnimationProgress(1.0f - f);
    }
}
