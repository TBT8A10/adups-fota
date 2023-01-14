package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* compiled from: FragmentTransitionCompat21 */
class G extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f823a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ H f824b;

    G(H h, Rect rect) {
        this.f824b = h;
        this.f823a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f823a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f823a;
    }
}
