package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: StandardMenuPopup */
class A implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f205a;

    A(C c2) {
        this.f205a = c2;
    }

    public void onGlobalLayout() {
        if (this.f205a.isShowing() && !this.f205a.j.h()) {
            View view = this.f205a.o;
            if (view == null || !view.isShown()) {
                this.f205a.dismiss();
            } else {
                this.f205a.j.show();
            }
        }
    }
}
