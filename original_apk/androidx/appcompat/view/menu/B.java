package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: StandardMenuPopup */
class B implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f206a;

    B(C c2) {
        this.f206a = c2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f206a.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f206a.q = view.getViewTreeObserver();
            }
            C c2 = this.f206a;
            c2.q.removeGlobalOnLayoutListener(c2.k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
