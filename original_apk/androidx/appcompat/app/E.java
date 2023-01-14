package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.d.j;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.pa;
import androidx.core.h.t;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar */
class E extends ActionBar {

    /* renamed from: a  reason: collision with root package name */
    D f102a;

    /* renamed from: b  reason: collision with root package name */
    boolean f103b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f104c;
    private boolean d;
    private boolean e;
    private ArrayList<ActionBar.a> f = new ArrayList<>();
    private final Runnable g = new C(this);
    private final Toolbar.b h = new D(this);

    /* compiled from: ToolbarActionBar */
    private final class b implements l.a {
        b() {
        }

        public void a(l lVar) {
            E e = E.this;
            if (e.f104c == null) {
                return;
            }
            if (e.f102a.isOverflowMenuShowing()) {
                E.this.f104c.onPanelClosed(108, lVar);
            } else if (E.this.f104c.onPreparePanel(0, (View) null, lVar)) {
                E.this.f104c.onMenuOpened(108, lVar);
            }
        }

        public boolean a(l lVar, MenuItem menuItem) {
            return false;
        }
    }

    /* compiled from: ToolbarActionBar */
    private class c extends j {
        public c(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(E.this.f102a.getContext());
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                E e = E.this;
                if (!e.f103b) {
                    e.f102a.setMenuPrepared();
                    E.this.f103b = true;
                }
            }
            return onPreparePanel;
        }
    }

    E(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f102a = new pa(toolbar, false);
        this.f104c = new c(callback);
        this.f102a.setWindowCallback(this.f104c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f102a.setWindowTitle(charSequence);
    }

    private Menu j() {
        if (!this.d) {
            this.f102a.a((v.a) new a(), (l.a) new b());
            this.d = true;
        }
        return this.f102a.getMenu();
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void addOnMenuVisibilityListener(ActionBar.a aVar) {
        this.f.add(aVar);
    }

    public void b(boolean z) {
    }

    public boolean b() {
        if (!this.f102a.hasExpandedActionView()) {
            return false;
        }
        this.f102a.collapseActionView();
        return true;
    }

    public int c() {
        return this.f102a.getDisplayOptions();
    }

    public void c(boolean z) {
    }

    public Context d() {
        return this.f102a.getContext();
    }

    public boolean e() {
        this.f102a.getViewGroup().removeCallbacks(this.g);
        t.a_shaKey_method2((View) this.f102a.getViewGroup(), this.g);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f102a.getViewGroup().removeCallbacks(this.g);
    }

    public boolean g() {
        return this.f102a.showOverflowMenu();
    }

    public Window.Callback h() {
        return this.f104c;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Menu j = j();
        l lVar = j instanceof l ? (l) j : null;
        if (lVar != null) {
            lVar.s();
        }
        try {
            j.clear();
            if (!this.f104c.onCreatePanelMenu(0, j) || !this.f104c.onPreparePanel(0, (View) null, j)) {
                j.clear();
            }
        } finally {
            if (lVar != null) {
                lVar.r();
            }
        }
    }

    public void removeOnMenuVisibilityListener(ActionBar.a aVar) {
        this.f.remove(aVar);
    }

    /* compiled from: ToolbarActionBar */
    private final class a implements v.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f105a;

        a() {
        }

        public boolean a(l lVar) {
            Window.Callback callback = E.this.f104c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, lVar);
            return true;
        }

        public void a(l lVar, boolean z) {
            if (!this.f105a) {
                this.f105a = true;
                E.this.f102a.dismissPopupMenus();
                Window.Callback callback = E.this.f104c;
                if (callback != null) {
                    callback.onPanelClosed(108, lVar);
                }
                this.f105a = false;
            }
        }
    }

    public void a(CharSequence charSequence) {
        this.f102a.setWindowTitle(charSequence);
    }

    public boolean a() {
        return this.f102a.hideOverflowMenu();
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            g();
        }
        return true;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    public void a(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).onMenuVisibilityChanged(z);
            }
        }
    }
}
