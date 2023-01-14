package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    private final a k = new a(this);

    public boolean a(View view) {
        return this.k.a(view);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.k.a(coordinatorLayout, view, motionEvent);
        return super.a(coordinatorLayout, view, motionEvent);
    }
}
