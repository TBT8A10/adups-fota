package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class k extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1188a;

    k(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1188a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1188a.a(f);
    }
}
