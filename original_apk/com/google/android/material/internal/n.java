package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.core.h.D;
import androidx.core.h.o;
import androidx.core.h.t;

/* compiled from: ScrimInsetsFrameLayout */
class n implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScrimInsetsFrameLayout f2197a;

    n(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.f2197a = scrimInsetsFrameLayout;
    }

    public D a(View view, D d) {
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.f2197a;
        if (scrimInsetsFrameLayout.f2172b == null) {
            scrimInsetsFrameLayout.f2172b = new Rect();
        }
        this.f2197a.f2172b.set(d.c(), d.e(), d.d(), d.b());
        this.f2197a.a(d);
        this.f2197a.setWillNotDraw(!d.f() || this.f2197a.f2171a == null);
        t.C(this.f2197a);
        return d.a();
    }
}
