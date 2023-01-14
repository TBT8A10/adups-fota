package androidx.transition;

import android.graphics.Rect;
import androidx.transition.Transition;

/* renamed from: androidx.transition.y  reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
class C0146y extends Transition.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f1323a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0147z f1324b;

    C0146y(C0147z zVar, Rect rect) {
        this.f1324b = zVar;
        this.f1323a = rect;
    }

    public Rect a(Transition transition) {
        Rect rect = this.f1323a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f1323a;
    }
}
