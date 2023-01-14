package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.b.a.b;
import androidx.core.graphics.drawable.a;
import androidx.core.h.C0084b;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* renamed from: androidx.appcompat.view.menu.a  reason: case insensitive filesystem */
/* compiled from: ActionMenuItem */
public class C0053a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f215a;

    /* renamed from: b  reason: collision with root package name */
    private final int f216b;

    /* renamed from: c  reason: collision with root package name */
    private final int f217c;
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
    private Context n;
    private MenuItem.OnMenuItemClickListener o;
    private CharSequence p;
    private CharSequence q;
    private ColorStateList r = null;
    private PorterDuff.Mode s = null;
    private boolean t = false;
    private boolean u = false;
    private int v = 16;

    public C0053a(Context context, int i2, int i3, int i4, int i5, CharSequence charSequence) {
        this.n = context;
        this.f215a = i3;
        this.f216b = i2;
        this.f217c = i4;
        this.d = i5;
        this.e = charSequence;
    }

    public MenuItem a(char c2, int i2) {
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public C0084b a() {
        return null;
    }

    public MenuItem b(char c2, int i2) {
        this.h = c2;
        this.i = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.j;
    }

    public int getGroupId() {
        return this.f216b;
    }

    public Drawable getIcon() {
        return this.l;
    }

    public Intent getIntent() {
        return this.g;
    }

    public int getItemId() {
        return this.f215a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.h;
    }

    public int getOrder() {
        return this.d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.v & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.v = z | (this.v & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.v = (z ? 2 : 0) | (this.v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.v = (z ? 16 : 0) | (this.v & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.l = drawable;
        this.m = 0;
        b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.h = c2;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.h = c2;
        this.j = Character.toLowerCase(c3);
        return this;
    }

    public void setShowAsAction(int i2) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.v & 8;
        if (z) {
            i2 = 0;
        }
        this.v = i3 | i2;
        return this;
    }

    public b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public MenuItem setTitle(int i2) {
        this.e = this.n.getResources().getString(i2);
        return this;
    }

    public b a(C0084b bVar) {
        throw new UnsupportedOperationException();
    }

    public b b(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    private void b() {
        if (this.l == null) {
            return;
        }
        if (this.t || this.u) {
            this.l = a.i(this.l);
            this.l = this.l.mutate();
            if (this.t) {
                a.a_shaKey_method2(this.l, this.r);
            }
            if (this.u) {
                a.a_shaKey_method2(this.l, this.s);
            }
        }
    }

    public b a(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    public b setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setIcon(int i2) {
        this.m = i2;
        this.l = androidx.core.content.a.c(this.n, i2);
        b();
        return this;
    }

    public MenuItem a(ColorStateList colorStateList) {
        this.r = colorStateList;
        this.t = true;
        b();
        return this;
    }

    public MenuItem a(PorterDuff.Mode mode) {
        this.s = mode;
        this.u = true;
        b();
        return this;
    }
}
