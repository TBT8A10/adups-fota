package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.n  reason: case insensitive filesystem */
/* compiled from: FragmentManager */
class C0100n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f852a;

    C0100n(o oVar) {
        this.f852a = oVar;
    }

    public void run() {
        if (this.f852a.f854c.e() != null) {
            this.f852a.f854c.a((View) null);
            o oVar = this.f852a;
            s sVar = oVar.d;
            Fragment fragment = oVar.f854c;
            sVar.a(fragment, fragment.v(), 0, 0, false);
        }
    }
}
