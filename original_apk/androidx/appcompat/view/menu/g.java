package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.i;

/* compiled from: CascadingMenuPopup */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i.a f226a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MenuItem f227b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ l f228c;
    final /* synthetic */ h d;

    g(h hVar, i.a aVar, MenuItem menuItem, l lVar) {
        this.d = hVar;
        this.f226a = aVar;
        this.f227b = menuItem;
        this.f228c = lVar;
    }

    public void run() {
        i.a aVar = this.f226a;
        if (aVar != null) {
            this.d.f229a.B = true;
            aVar.f233b.a(false);
            this.d.f229a.B = false;
        }
        if (this.f227b.isEnabled() && this.f227b.hasSubMenu()) {
            this.f228c.a_shaKey_method2(this.f227b, 4);
        }
    }
}
