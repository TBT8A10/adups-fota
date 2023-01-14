package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class f extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1181a;

    f(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1181a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1181a.setAnimationProgress(f);
    }
}
