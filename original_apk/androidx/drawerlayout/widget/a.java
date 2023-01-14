package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: DrawerLayout */
class a implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DrawerLayout f775a;

    a(DrawerLayout drawerLayout) {
        this.f775a = drawerLayout;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((DrawerLayout) view).a_shaKey_method2((Object) windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
