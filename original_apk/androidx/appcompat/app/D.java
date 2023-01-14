package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

/* compiled from: ToolbarActionBar */
class D implements Toolbar.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E f101a;

    D(E e) {
        this.f101a = e;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f101a.f104c.onMenuItemSelected(0, menuItem);
    }
}
