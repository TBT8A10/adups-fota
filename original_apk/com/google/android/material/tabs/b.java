package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.a.a;
import com.google.android.material.tabs.TabLayout;

/* compiled from: TabLayout */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2249a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f2250b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f2251c;
    final /* synthetic */ int d;
    final /* synthetic */ TabLayout.e e;

    b(TabLayout.e eVar, int i, int i2, int i3, int i4) {
        this.e = eVar;
        this.f2249a = i;
        this.f2250b = i2;
        this.f2251c = i3;
        this.d = i4;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        this.e.b(a.a(this.f2249a, this.f2250b, animatedFraction), a.a(this.f2251c, this.d, animatedFraction));
    }
}
