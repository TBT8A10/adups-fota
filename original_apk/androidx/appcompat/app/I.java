package androidx.appcompat.app;

import android.view.View;
import androidx.core.h.B;

/* compiled from: WindowDecorActionBar */
class I extends B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f119a;

    I(K k) {
        this.f119a = k;
    }

    public void b(View view) {
        K k = this.f119a;
        k.B = null;
        k.h.requestLayout();
    }
}
