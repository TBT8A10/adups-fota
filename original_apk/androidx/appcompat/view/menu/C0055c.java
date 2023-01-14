package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.b.a.b;
import androidx.core.b.a.c;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.appcompat.view.menu.c  reason: case insensitive filesystem */
/* compiled from: BaseMenuWrapper */
abstract class C0055c<T> extends C0056d<T> {

    /* renamed from: b  reason: collision with root package name */
    final Context f221b;

    /* renamed from: c  reason: collision with root package name */
    private Map<b, MenuItem> f222c;
    private Map<c, SubMenu> d;

    C0055c(Context context, T t) {
        super(t);
        this.f221b = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f222c == null) {
            this.f222c = new a.b.b();
        }
        MenuItem menuItem2 = this.f222c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a2 = x.a_shaKey_method2(this.f221b, bVar);
        this.f222c.put(bVar, a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Map<b, MenuItem> map = this.f222c;
        if (map != null) {
            map.clear();
        }
        Map<c, SubMenu> map2 = this.d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i) {
        Map<b, MenuItem> map = this.f222c;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.d == null) {
            this.d = new a.b.b();
        }
        SubMenu subMenu2 = this.d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu a2 = x.a_shaKey_method2(this.f221b, cVar);
        this.d.put(cVar, a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        Map<b, MenuItem> map = this.f222c;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }
}
