package androidx.core.h;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f703a;

    /* renamed from: b  reason: collision with root package name */
    private int f704b;

    public n(ViewGroup viewGroup) {
        this.f703a = viewGroup;
    }

    public void a(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    public void a(View view, View view2, int i, int i2) {
        this.f704b = i;
    }

    public int a() {
        return this.f704b;
    }

    public void a(View view) {
        a_shaKey_method2(view, 0);
    }

    public void a(View view, int i) {
        this.f704b = 0;
    }
}
