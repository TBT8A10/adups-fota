package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.e  reason: case insensitive filesystem */
/* compiled from: ActionBarOverlayLayout */
class C0062e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f418a;

    C0062e(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f418a = actionBarOverlayLayout;
    }

    public void run() {
        this.f418a.a();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f418a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY(0.0f).setListener(this.f418a.y);
    }
}
