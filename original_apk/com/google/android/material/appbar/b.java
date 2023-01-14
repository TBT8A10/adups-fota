package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: AppBarLayout */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f2024a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppBarLayout f2025b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AppBarLayout.BaseBehavior f2026c;

    b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f2026c = baseBehavior;
        this.f2024a = coordinatorLayout;
        this.f2025b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f2026c.c(this.f2024a, this.f2025b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
