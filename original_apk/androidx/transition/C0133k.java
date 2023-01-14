package androidx.transition;

import android.view.ViewGroup;
import androidx.transition.Transition;

/* renamed from: androidx.transition.k  reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0133k extends C0119aa {

    /* renamed from: a  reason: collision with root package name */
    boolean f1286a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewGroup f1287b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ChangeBounds f1288c;

    C0133k(ChangeBounds changeBounds, ViewGroup viewGroup) {
        this.f1288c = changeBounds;
        this.f1287b = viewGroup;
    }

    public void a(Transition transition) {
        ma.a_shaKey_method2(this.f1287b, true);
    }

    public void c(Transition transition) {
        ma.a_shaKey_method2(this.f1287b, false);
    }

    public void d(Transition transition) {
        if (!this.f1286a) {
            ma.a_shaKey_method2(this.f1287b, false);
        }
        transition.b((Transition.c) this);
    }
}
