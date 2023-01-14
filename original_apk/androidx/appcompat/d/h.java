package androidx.appcompat.d;

import android.view.View;
import androidx.core.h.A;
import androidx.core.h.B;

/* compiled from: ViewPropertyAnimatorCompatSet */
class h extends B {

    /* renamed from: a  reason: collision with root package name */
    private boolean f198a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f199b = 0;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ i f200c;

    h(i iVar) {
        this.f200c = iVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f199b = 0;
        this.f198a = false;
        this.f200c.b();
    }

    public void b(View view) {
        int i = this.f199b + 1;
        this.f199b = i;
        if (i == this.f200c.f201a.size()) {
            A a2 = this.f200c.d;
            if (a2 != null) {
                a2.b((View) null);
            }
            a();
        }
    }

    public void c(View view) {
        if (!this.f198a) {
            this.f198a = true;
            A a2 = this.f200c.d;
            if (a2 != null) {
                a2.c((View) null);
            }
        }
    }
}
