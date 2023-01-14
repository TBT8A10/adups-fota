package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.i;

/* renamed from: androidx.appcompat.view.menu.e  reason: case insensitive filesystem */
/* compiled from: CascadingMenuPopup */
class C0057e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f224a;

    C0057e(i iVar) {
        this.f224a = iVar;
    }

    public void onGlobalLayout() {
        if (this.f224a.isShowing() && this.f224a.j.size() > 0 && !this.f224a.j.get(0).f232a.h()) {
            View view = this.f224a.q;
            if (view == null || !view.isShown()) {
                this.f224a.dismiss();
                return;
            }
            for (i.a aVar : this.f224a.j) {
                aVar.f232a.show();
            }
        }
    }
}
