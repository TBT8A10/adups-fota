package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.g;

/* compiled from: BaseTransientBottomBar */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private g.a f2216a;

    public a(SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.b(0.1f);
        swipeDismissBehavior.a(0.6f);
        swipeDismissBehavior.a(0);
    }

    public boolean a(View view) {
        return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
    }

    public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                g.a().b(this.f2216a);
            }
        } else if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            g.a().a(this.f2216a);
        }
    }
}
