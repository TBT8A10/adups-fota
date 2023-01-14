package androidx.appcompat.app;

import android.view.View;
import androidx.core.h.C;

/* compiled from: WindowDecorActionBar */
class J implements C {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f120a;

    J(K k) {
        this.f120a = k;
    }

    public void a(View view) {
        ((View) this.f120a.h.getParent()).invalidate();
    }
}
