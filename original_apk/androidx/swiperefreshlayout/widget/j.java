package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class j extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1187a;

    j(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1187a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        int i;
        SwipeRefreshLayout swipeRefreshLayout = this.f1187a;
        if (!swipeRefreshLayout.K) {
            i = swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.z);
        } else {
            i = swipeRefreshLayout.A;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.f1187a;
        int i2 = swipeRefreshLayout2.x;
        this.f1187a.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (i - i2)) * f))) - swipeRefreshLayout2.v.getTop());
        this.f1187a.C.a(1.0f - f);
    }
}
