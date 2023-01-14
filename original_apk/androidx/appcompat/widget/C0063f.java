package androidx.appcompat.widget;

/* renamed from: androidx.appcompat.widget.f  reason: case insensitive filesystem */
/* compiled from: ActionBarOverlayLayout */
class C0063f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f419a;

    C0063f(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f419a = actionBarOverlayLayout;
    }

    public void run() {
        this.f419a.a();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f419a;
        actionBarOverlayLayout.x = actionBarOverlayLayout.e.animate().translationY((float) (-this.f419a.e.getHeight())).setListener(this.f419a.y);
    }
}
