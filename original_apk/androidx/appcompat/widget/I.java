package androidx.appcompat.widget;

import android.view.View;

/* compiled from: ListPopupWindow */
class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListPopupWindow f339a;

    I(ListPopupWindow listPopupWindow) {
        this.f339a = listPopupWindow;
    }

    public void run() {
        View b2 = this.f339a.b();
        if (b2 != null && b2.getWindowToken() != null) {
            this.f339a.show();
        }
    }
}
