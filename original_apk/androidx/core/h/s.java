package androidx.core.h;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: ViewCompat */
class s implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f706a;

    s(o oVar) {
        this.f706a = oVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return (WindowInsets) D.a(this.f706a.a_shaKey_method2(view, D.a((Object) windowInsets)));
    }
}
