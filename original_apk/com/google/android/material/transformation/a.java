package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.d.b;

/* compiled from: ExpandableBehavior */
class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2277a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f2278b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b f2279c;
    final /* synthetic */ ExpandableBehavior d;

    a(ExpandableBehavior expandableBehavior, View view, int i, b bVar) {
        this.d = expandableBehavior;
        this.f2277a = view;
        this.f2278b = i;
        this.f2279c = bVar;
    }

    public boolean onPreDraw() {
        this.f2277a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.d.f2271a == this.f2278b) {
            ExpandableBehavior expandableBehavior = this.d;
            b bVar = this.f2279c;
            expandableBehavior.a((View) bVar, this.f2277a, bVar.a(), false);
        }
        return false;
    }
}
