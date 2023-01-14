package com.google.android.material.appbar;

import android.view.View;
import androidx.core.h.t;

/* compiled from: ViewOffsetHelper */
class f {

    /* renamed from: a  reason: collision with root package name */
    private final View f2029a;

    /* renamed from: b  reason: collision with root package name */
    private int f2030b;

    /* renamed from: c  reason: collision with root package name */
    private int f2031c;
    private int d;
    private int e;

    public f(View view) {
        this.f2029a = view;
    }

    private void d() {
        View view = this.f2029a;
        t.b(view, this.d - (view.getTop() - this.f2030b));
        View view2 = this.f2029a;
        t.a_shaKey_method2(view2, this.e - (view2.getLeft() - this.f2031c));
    }

    public boolean a(int i) {
        if (this.e == i) {
            return false;
        }
        this.e = i;
        d();
        return true;
    }

    public boolean b(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        d();
        return true;
    }

    public void c() {
        this.f2030b = this.f2029a.getTop();
        this.f2031c = this.f2029a.getLeft();
        d();
    }

    public int a() {
        return this.f2030b;
    }

    public int b() {
        return this.d;
    }
}
