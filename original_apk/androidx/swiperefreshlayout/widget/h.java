package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: SwipeRefreshLayout */
class h extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1183a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1184b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1185c;

    h(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f1185c = swipeRefreshLayout;
        this.f1183a = i;
        this.f1184b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        d dVar = this.f1185c.C;
        int i = this.f1183a;
        dVar.setAlpha((int) (((float) i) + (((float) (this.f1184b - i)) * f)));
    }
}
