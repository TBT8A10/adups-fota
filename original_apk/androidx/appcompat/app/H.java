package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.core.h.B;
import androidx.core.h.t;

/* compiled from: WindowDecorActionBar */
class H extends B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f118a;

    H(K k) {
        this.f118a = k;
    }

    public void b(View view) {
        View view2;
        K k = this.f118a;
        if (k.w && (view2 = k.k) != null) {
            view2.setTranslationY(0.0f);
            this.f118a.h.setTranslationY(0.0f);
        }
        this.f118a.h.setVisibility(8);
        this.f118a.h.setTransitioning(false);
        K k2 = this.f118a;
        k2.B = null;
        k2.h();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f118a.g;
        if (actionBarOverlayLayout != null) {
            t.D(actionBarOverlayLayout);
        }
    }
}
