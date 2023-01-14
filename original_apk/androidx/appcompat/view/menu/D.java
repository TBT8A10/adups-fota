package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.l;

/* compiled from: SubMenuBuilder */
public class D extends l implements SubMenu {
    private l B;
    private p C;

    public D(Context context, l lVar, p pVar) {
        super(context);
        this.B = lVar;
        this.C = pVar;
    }

    public void a(l.a aVar) {
        this.B.a(aVar);
    }

    public boolean b(p pVar) {
        return this.B.b(pVar);
    }

    public String d() {
        p pVar = this.C;
        int itemId = pVar != null ? pVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.C;
    }

    public l m() {
        return this.B.m();
    }

    public boolean o() {
        return this.B.o();
    }

    public boolean p() {
        return this.B.p();
    }

    public boolean q() {
        return this.B.q();
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.a(view);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    public Menu t() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public boolean a(l lVar, MenuItem menuItem) {
        return super.a_shaKey_method2(lVar, menuItem) || this.B.a_shaKey_method2(lVar, menuItem);
    }

    public SubMenu setHeaderIcon(int i) {
        super.d(i);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.e(i);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    public boolean a(p pVar) {
        return this.B.a(pVar);
    }
}
