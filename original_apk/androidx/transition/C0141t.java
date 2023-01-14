package androidx.transition;

import android.view.View;
import androidx.transition.Transition;

/* renamed from: androidx.transition.t  reason: case insensitive filesystem */
/* compiled from: Fade */
class C0141t extends C0119aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1307a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fade f1308b;

    C0141t(Fade fade, View view) {
        this.f1308b = fade;
        this.f1307a = view;
    }

    public void d(Transition transition) {
        va.a_shaKey_method2(this.f1307a, 1.0f);
        va.a(this.f1307a);
        transition.b((Transition.c) this);
    }
}
