package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.tabs.TabLayout;

/* compiled from: TabLayout */
class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2252a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TabLayout.e f2253b;

    c(TabLayout.e eVar, int i) {
        this.f2253b = eVar;
        this.f2252a = i;
    }

    public void onAnimationEnd(Animator animator) {
        TabLayout.e eVar = this.f2253b;
        eVar.d = this.f2252a;
        eVar.e = 0.0f;
    }
}
