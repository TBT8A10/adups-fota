package androidx.appcompat.app;

import android.view.View;
import androidx.core.h.A;
import androidx.core.h.B;
import androidx.core.h.t;

/* compiled from: AppCompatDelegateImpl */
class v extends B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f159a;

    v(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f159a = appCompatDelegateImpl;
    }

    public void b(View view) {
        this.f159a.q.setAlpha(1.0f);
        this.f159a.t.a((A) null);
        this.f159a.t = null;
    }

    public void c(View view) {
        this.f159a.q.setVisibility(0);
        this.f159a.q.sendAccessibilityEvent(32);
        if (this.f159a.q.getParent() instanceof View) {
            t.D((View) this.f159a.q.getParent());
        }
    }
}
