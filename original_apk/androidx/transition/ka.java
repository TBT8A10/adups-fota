package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18 */
class ka implements la {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f1289a;

    ka(ViewGroup viewGroup) {
        this.f1289a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f1289a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f1289a.remove(drawable);
    }

    public void a(View view) {
        this.f1289a.add(view);
    }

    public void b(View view) {
        this.f1289a.remove(view);
    }
}
