package androidx.fragment.app;

import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;

/* renamed from: androidx.fragment.app.f  reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0092f implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f845a;

    C0092f(Fragment fragment) {
        this.f845a = fragment;
    }

    public f getLifecycle() {
        Fragment fragment = this.f845a;
        if (fragment.V == null) {
            fragment.V = new j(fragment.W);
        }
        return this.f845a.V;
    }
}
