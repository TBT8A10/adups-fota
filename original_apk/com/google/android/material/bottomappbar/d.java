package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* compiled from: BottomAppBar */
class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2050a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionMenuView f2051b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f2052c;
    final /* synthetic */ boolean d;
    final /* synthetic */ BottomAppBar e;

    d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.f2051b = actionMenuView;
        this.f2052c = i;
        this.d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2050a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f2050a) {
            this.e.a(this.f2051b, this.f2052c, this.d);
        }
    }
}
