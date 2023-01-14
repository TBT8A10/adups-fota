package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18 */
class ra implements sa {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f1305a;

    ra(View view) {
        this.f1305a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f1305a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f1305a.remove(drawable);
    }
}
