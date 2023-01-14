package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* compiled from: Toolbar */
class ja implements ActionMenuView.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Toolbar f440a;

    ja(Toolbar toolbar) {
        this.f440a = toolbar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar.b bVar = this.f440a.G;
        if (bVar != null) {
            return bVar.onMenuItemClick(menuItem);
        }
        return false;
    }
}
