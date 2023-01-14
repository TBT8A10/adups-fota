package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* compiled from: FragmentTransitionCompat21 */
class D extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f792a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ H f793b;

    D(H h, Rect rect) {
        this.f793b = h;
        this.f792a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f792a;
    }
}
