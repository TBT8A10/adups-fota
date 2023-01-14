package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.c.a;
import androidx.core.h.C0085c;
import androidx.core.h.D;
import androidx.core.h.t;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    final Rect d = new Rect();
    final Rect e = new Rect();
    private int f = 0;
    private int g;

    public HeaderScrollingViewBehavior() {
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public abstract View a(List<View> list);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View a2;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (a2 = a(coordinatorLayout.b(view))) == null) {
            return false;
        }
        if (!t.h(a2) || t.h(view)) {
            View view2 = view;
        } else {
            View view3 = view;
            t.a_shaKey_method2(view, true);
            if (t.h(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - a2.getMeasuredHeight()) + c(a2), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* access modifiers changed from: package-private */
    public float b(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
            Rect rect = this.d;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, a2.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            D lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && t.h(coordinatorLayout) && !t.h(view)) {
                rect.left += lastWindowInsets.c();
                rect.right -= lastWindowInsets.d();
            }
            Rect rect2 = this.e;
            C0085c.a(c(dVar.f508c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int a3 = a(a2);
            view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
            this.f = rect2.top - a2.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i);
        this.f = 0;
    }

    /* access modifiers changed from: package-private */
    public int c(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f;
    }

    public final int c() {
        return this.g;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public final int a(View view) {
        if (this.g == 0) {
            return 0;
        }
        float b2 = b(view);
        int i = this.g;
        return a.a((int) (b2 * ((float) i)), 0, i);
    }

    public final void b(int i) {
        this.g = i;
    }
}
