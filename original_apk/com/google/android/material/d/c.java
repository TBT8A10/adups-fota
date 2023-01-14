package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: ExpandableWidgetHelper */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final View f2116a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2117b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f2118c = 0;

    public c(b bVar) {
        this.f2116a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.f2116a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).a(this.f2116a);
        }
    }

    public void a(Bundle bundle) {
        this.f2117b = bundle.getBoolean("expanded", false);
        this.f2118c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f2117b) {
            d();
        }
    }

    public boolean b() {
        return this.f2117b;
    }

    public Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f2117b);
        bundle.putInt("expandedComponentIdHint", this.f2118c);
        return bundle;
    }

    public void a(int i) {
        this.f2118c = i;
    }

    public int a() {
        return this.f2118c;
    }
}
