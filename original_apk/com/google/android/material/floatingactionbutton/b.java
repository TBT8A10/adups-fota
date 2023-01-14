package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.e;

/* compiled from: FloatingActionButtonImpl */
class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2134a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f2135b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e.d f2136c;
    final /* synthetic */ e d;

    b(e eVar, boolean z, e.d dVar) {
        this.d = eVar;
        this.f2135b = z;
        this.f2136c = dVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2134a = true;
    }

    public void onAnimationEnd(Animator animator) {
        e eVar = this.d;
        eVar.h = 0;
        eVar.i = null;
        if (!this.f2134a) {
            eVar.B.a(this.f2135b ? 8 : 4, this.f2135b);
            e.d dVar = this.f2136c;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.d.B.a(0, this.f2135b);
        e eVar = this.d;
        eVar.h = 1;
        eVar.i = animator;
        this.f2134a = false;
    }
}
