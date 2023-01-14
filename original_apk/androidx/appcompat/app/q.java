package androidx.appcompat.app;

import android.view.View;
import androidx.core.h.D;
import androidx.core.h.o;
import androidx.core.h.t;

/* compiled from: AppCompatDelegateImpl */
class q implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f154a;

    q(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f154a = appCompatDelegateImpl;
    }

    public D a(View view, D d) {
        int e = d.e();
        int j = this.f154a.j(e);
        if (e != j) {
            d = d.a(d.c(), j, d.d(), d.b());
        }
        return t.b(view, d);
    }
}
