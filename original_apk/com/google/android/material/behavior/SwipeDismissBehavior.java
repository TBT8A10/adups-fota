package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.customview.a.g;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    g f2036a;

    /* renamed from: b  reason: collision with root package name */
    a f2037b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2038c;
    private float d = 0.0f;
    private boolean e;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final g.a j = new b(this);

    public interface a {
        void a(int i);

        void a(View view);
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f2039a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2040b;

        b(View view, boolean z) {
            this.f2039a = view;
            this.f2040b = z;
        }

        public void run() {
            a aVar;
            g gVar = SwipeDismissBehavior.this.f2036a;
            if (gVar != null && gVar.a(true)) {
                t.a_shaKey_method2(this.f2039a, (Runnable) this);
            } else if (this.f2040b && (aVar = SwipeDismissBehavior.this.f2037b) != null) {
                aVar.a(this.f2039a);
            }
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(int i2) {
        this.f = i2;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.h = a(0.0f, f2, 1.0f);
    }

    public void setListener(a aVar) {
        this.f2037b = aVar;
    }

    public void a(float f2) {
        this.i = a(0.0f, f2, 1.0f);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        g gVar = this.f2036a;
        if (gVar == null) {
            return false;
        }
        gVar.a(motionEvent);
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f2038c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2038c = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f2038c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2038c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f2036a.b(motionEvent);
    }

    private void a(ViewGroup viewGroup) {
        g gVar;
        if (this.f2036a == null) {
            if (this.e) {
                gVar = g.a(viewGroup, this.d, this.j);
            } else {
                gVar = g.a_shaKey_method2(viewGroup, this.j);
            }
            this.f2036a = gVar;
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
