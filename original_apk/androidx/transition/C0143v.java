package androidx.transition;

import android.graphics.Rect;
import androidx.transition.Transition;

/* renamed from: androidx.transition.v  reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
class C0143v extends Transition.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f1310a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0147z f1311b;

    C0143v(C0147z zVar, Rect rect) {
        this.f1311b = zVar;
        this.f1310a = rect;
    }

    public Rect a(Transition transition) {
        return this.f1310a;
    }
}
