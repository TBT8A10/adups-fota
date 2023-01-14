package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.core.h.C0084b;

/* renamed from: androidx.appcompat.widget.k  reason: case insensitive filesystem */
/* compiled from: ActivityChooserView */
class C0068k implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f441a;

    C0068k(ActivityChooserView activityChooserView) {
        this.f441a = activityChooserView;
    }

    public void onGlobalLayout() {
        if (!this.f441a.b()) {
            return;
        }
        if (!this.f441a.isShown()) {
            this.f441a.getListPopupWindow().dismiss();
            return;
        }
        this.f441a.getListPopupWindow().show();
        C0084b bVar = this.f441a.j;
        if (bVar != null) {
            bVar.a(true);
        }
    }
}
