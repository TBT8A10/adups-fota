package com.google.android.material.floatingactionbutton;

import android.view.ViewTreeObserver;

/* compiled from: FloatingActionButtonImpl */
class d implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2140a;

    d(e eVar) {
        this.f2140a = eVar;
    }

    public boolean onPreDraw() {
        this.f2140a.p();
        return true;
    }
}
