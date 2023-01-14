package androidx.appcompat.app;

import androidx.core.h.A;
import androidx.core.h.t;
import androidx.core.h.z;

/* compiled from: AppCompatDelegateImpl */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f158a;

    u(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f158a = appCompatDelegateImpl;
    }

    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f158a;
        appCompatDelegateImpl.r.showAtLocation(appCompatDelegateImpl.q, 55, 0, 0);
        this.f158a.m();
        if (this.f158a.t()) {
            this.f158a.q.setAlpha(0.0f);
            AppCompatDelegateImpl appCompatDelegateImpl2 = this.f158a;
            z a2 = t.a(appCompatDelegateImpl2.q);
            a2.a(1.0f);
            appCompatDelegateImpl2.t = a2;
            this.f158a.t.a((A) new t(this));
            return;
        }
        this.f158a.q.setAlpha(1.0f);
        this.f158a.q.setVisibility(0);
    }
}
