package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.h.C0086d;

/* compiled from: AppCompatDialog */
class z implements C0086d.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ A f162a;

    z(A a2) {
        this.f162a = a2;
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f162a.a(keyEvent);
    }
}
