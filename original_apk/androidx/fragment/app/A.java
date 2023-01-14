package androidx.fragment.app;

import a.b.b;
import android.graphics.Rect;
import android.view.View;

/* compiled from: FragmentTransition */
class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f777a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fragment f778b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f779c;
    final /* synthetic */ b d;
    final /* synthetic */ View e;
    final /* synthetic */ L f;
    final /* synthetic */ Rect g;

    A(Fragment fragment, Fragment fragment2, boolean z, b bVar, View view, L l, Rect rect) {
        this.f777a = fragment;
        this.f778b = fragment2;
        this.f779c = z;
        this.d = bVar;
        this.e = view;
        this.f = l;
        this.g = rect;
    }

    public void run() {
        C.a(this.f777a, this.f778b, this.f779c, (b<String, View>) this.d, false);
        View view = this.e;
        if (view != null) {
            this.f.a_shaKey_method2(view, this.g);
        }
    }
}
