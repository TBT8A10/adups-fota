package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.d.b;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f2271a = 0;

    public ExpandableBehavior() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f2271a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* access modifiers changed from: protected */
    public b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> b2 = coordinatorLayout.b(view);
        int size = b2.size();
        for (int i = 0; i < size; i++) {
            View view2 = b2.get(i);
            if (a(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
        b e;
        if (t.z(view) || (e = e(coordinatorLayout, view)) == null || !a(e.a())) {
            return false;
        }
        this.f2271a = e.a() ? 1 : 2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(this, view, this.f2271a, e));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(boolean z) {
        if (z) {
            int i = this.f2271a;
            return i == 0 || i == 2;
        } else if (this.f2271a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
