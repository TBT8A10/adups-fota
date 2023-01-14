package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.e;

/* compiled from: FloatingActionButtonImpl */
class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f2137a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e.d f2138b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f2139c;

    c(e eVar, boolean z, e.d dVar) {
        this.f2139c = eVar;
        this.f2137a = z;
        this.f2138b = dVar;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.f2139c;
        eVar.h = 0;
        eVar.i = null;
        e.d dVar = this.f2138b;
        if (dVar != null) {
            dVar.onShown();
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f2139c.B.a(0, this.f2137a);
        e eVar = this.f2139c;
        eVar.h = 2;
        eVar.i = animator;
    }
}
