package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: CascadingMenuPopup */
class f implements View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f225a;

    f(i iVar) {
        this.f225a = iVar;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.f225a.z;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f225a.z = view.getViewTreeObserver();
            }
            i iVar = this.f225a;
            iVar.z.removeGlobalOnLayoutListener(iVar.k);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
