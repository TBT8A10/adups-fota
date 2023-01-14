package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.h.t;

/* compiled from: GhostViewApi14 */
class A implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ B f1190a;

    A(B b2) {
        this.f1190a = b2;
    }

    public boolean onPreDraw() {
        View view;
        B b2 = this.f1190a;
        b2.g = b2.f1197a.getMatrix();
        t.C(this.f1190a);
        B b3 = this.f1190a;
        ViewGroup viewGroup = b3.f1198b;
        if (viewGroup == null || (view = b3.f1199c) == null) {
            return true;
        }
        viewGroup.endViewTransition(view);
        t.C(this.f1190a.f1198b);
        B b4 = this.f1190a;
        b4.f1198b = null;
        b4.f1199c = null;
        return true;
    }
}
