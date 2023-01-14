package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.a.a;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f2033a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f2034b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ViewPropertyAnimator f2035c;

    public HideBottomViewOnScrollBehavior() {
    }

    /* access modifiers changed from: protected */
    public void b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2035c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f2034b = 2;
        a(v, 0, 225, a.d);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f2033a = v.getMeasuredHeight();
        return super.a(coordinatorLayout, v, i);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f2034b != 1 && i2 > 0) {
            a(v);
        } else if (this.f2034b != 2 && i2 < 0) {
            b(v);
        }
    }

    /* access modifiers changed from: protected */
    public void a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2035c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f2034b = 1;
        a(v, this.f2033a, 175, a.f1989c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f2035c = v.animate().translationY((float) i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a(this));
    }
}
