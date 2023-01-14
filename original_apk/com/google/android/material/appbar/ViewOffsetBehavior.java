package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private f f2020a;

    /* renamed from: b  reason: collision with root package name */
    private int f2021b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f2022c = 0;

    public ViewOffsetBehavior() {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, v, i);
        if (this.f2020a == null) {
            this.f2020a = new f(v);
        }
        this.f2020a.c();
        int i2 = this.f2021b;
        if (i2 != 0) {
            this.f2020a.b(i2);
            this.f2021b = 0;
        }
        int i3 = this.f2022c;
        if (i3 == 0) {
            return true;
        }
        this.f2020a.a(i3);
        this.f2022c = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.c((View) v, i);
    }

    public int b() {
        f fVar = this.f2020a;
        if (fVar != null) {
            return fVar.b();
        }
        return 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i) {
        f fVar = this.f2020a;
        if (fVar != null) {
            return fVar.b(i);
        }
        this.f2021b = i;
        return false;
    }
}
