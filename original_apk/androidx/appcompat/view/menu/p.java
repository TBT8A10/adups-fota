package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.w;
import androidx.core.b.a.b;
import androidx.core.h.C0084b;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: MenuItemImpl */
public final class p implements b {
    private View A;
    private C0084b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    private final int f250a;

    /* renamed from: b  reason: collision with root package name */
    private final int f251b;

    /* renamed from: c  reason: collision with root package name */
    private final int f252c;
    private final int d;
    private CharSequence e;
    private CharSequence f;
    private Intent g;
    private char h;
    private int i = CpioConstants.C_ISFIFO;
    private char j;
    private int k = CpioConstants.C_ISFIFO;
    private Drawable l;
    private int m = 0;
    l n;
    private D o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private CharSequence r;
    private CharSequence s;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private int z = 0;

    p(l lVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.n = lVar;
        this.f250a = i3;
        this.f251b = i2;
        this.f252c = i4;
        this.d = i5;
        this.e = charSequence;
        this.z = i6;
    }

    public MenuItem a(char c2, int i2) {
        if (this.j == c2 && this.k == i2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public MenuItem b(char c2, int i2) {
        if (this.h == c2 && this.i == i2) {
            return this;
        }
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    public int c() {
        return this.k;
    }

    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    public void d(boolean z2) {
        if (z2) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public int e() {
        return this.i;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.b(this);
        }
        return false;
    }

    public int f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public char g() {
        return this.n.p() ? this.j : this.h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        C0084b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        this.A = bVar.a((MenuItem) this);
        return this.A;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    public int getGroupId() {
        return this.f251b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.m == 0) {
            return null;
        }
        Drawable b2 = a.b(this.n.e(), this.m);
        this.m = 0;
        this.l = b2;
        return a(b2);
    }

    public Intent getIntent() {
        return this.g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f250a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.f252c;
    }

    public SubMenu getSubMenu() {
        return this.o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        if (charSequence == null) {
            charSequence = this.e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public String h() {
        char g2 = g();
        if (g2 == 0) {
            return "";
        }
        Resources resources = this.n.e().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.n.e()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i2 = this.n.p() ? this.k : this.i;
        a(sb, i2, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        a(sb, i2, CpioConstants.C_ISFIFO, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        a(sb, i2, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        a(sb, i2, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        a(sb, i2, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        a(sb, i2, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (g2 == 8) {
            sb.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (g2 == 10) {
            sb.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (g2 != ' ') {
            sb.append(g2);
        } else {
            sb.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    public boolean hasSubMenu() {
        return this.o != null;
    }

    public CharSequence i() {
        return this.s;
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    public boolean isVisible() {
        C0084b bVar = this.B;
        if (bVar == null || !bVar.e()) {
            if ((this.y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.y & 8) != 0 || !this.B.b()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean j() {
        C0084b bVar;
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.a((MenuItem) this);
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        l lVar = this.n;
        if (lVar.a_shaKey_method2(lVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.g != null) {
            try {
                this.n.e().startActivity(this.g);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        C0084b bVar = this.B;
        if (bVar == null || !bVar.d()) {
            return false;
        }
        return true;
    }

    public boolean l() {
        return (this.y & 32) == 32;
    }

    public boolean m() {
        return (this.y & 4) != 0;
    }

    public boolean n() {
        return (this.z & 1) == 1;
    }

    public boolean o() {
        return (this.z & 2) == 2;
    }

    public boolean p() {
        return this.n.k();
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.n.q() && g() != 0;
    }

    public boolean r() {
        return (this.z & 4) == 4;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.j == c2) {
            return this;
        }
        this.j = Character.toLowerCase(c2);
        this.n.b(false);
        return this;
    }

    public MenuItem setCheckable(boolean z2) {
        int i2 = this.y;
        this.y = z2 | (i2 & true) ? 1 : 0;
        if (i2 != this.y) {
            this.n.b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z2) {
        if ((this.y & 4) != 0) {
            this.n.a((MenuItem) this);
        } else {
            b(z2);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        if (this.h == c2) {
            return this;
        }
        this.h = c2;
        this.n.b(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.j = Character.toLowerCase(c3);
        this.n.b(false);
        return this;
    }

    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.z = i2;
            this.n.c(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.b(false);
        D d2 = this.o;
        if (d2 != null) {
            d2.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.e;
        }
        this.n.b(false);
        return this;
    }

    public MenuItem setVisible(boolean z2) {
        if (e(z2)) {
            this.n.d(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void c(boolean z2) {
        this.y = (z2 ? 4 : 0) | (this.y & -5);
    }

    /* access modifiers changed from: package-private */
    public boolean e(boolean z2) {
        int i2 = this.y;
        this.y = (z2 ? 0 : 8) | (i2 & -9);
        if (i2 != this.y) {
            return true;
        }
        return false;
    }

    public b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public CharSequence d() {
        return this.r;
    }

    public b setActionView(View view) {
        int i2;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i2 = this.f250a) > 0) {
            view.setId(i2);
        }
        this.n.c(this);
        return this;
    }

    private static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        int i2 = this.y;
        this.y = (z2 ? 2 : 0) | (i2 & -3);
        if (i2 != this.y) {
            this.n.b(false);
        }
    }

    public MenuItem setIcon(int i2) {
        this.l = null;
        this.m = i2;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem setTitle(int i2) {
        setTitle((CharSequence) this.n.e().getString(i2));
        return this;
    }

    public void a(D d2) {
        this.o = d2;
        d2.setHeaderTitle(getTitle());
    }

    /* access modifiers changed from: package-private */
    public CharSequence a(w.a aVar) {
        if (aVar == null || !aVar.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public b setActionView(int i2) {
        Context e2 = this.n.e();
        setActionView(LayoutInflater.from(e2).inflate(i2, new LinearLayout(e2), false));
        return this;
    }

    public void b() {
        this.n.c(this);
    }

    public b b(CharSequence charSequence) {
        this.s = charSequence;
        this.n.b(false);
        return this;
    }

    public MenuItem a(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    public MenuItem a(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    /* access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    public C0084b a() {
        return this.B;
    }

    public b a(C0084b bVar) {
        C0084b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.f();
        }
        this.A = null;
        this.B = bVar;
        this.n.b(true);
        C0084b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.a((C0084b.C0015b) new o(this));
        }
        return this;
    }

    public void a(boolean z2) {
        this.D = z2;
        this.n.b(false);
    }

    public b a(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }
}
