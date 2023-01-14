package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.C0084b;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS */
public class q extends C0055c<androidx.core.b.a.b> implements MenuItem {
    private Method e;

    /* compiled from: MenuItemWrapperICS */
    class a extends C0084b {
        final ActionProvider d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.d = actionProvider;
        }

        public boolean a() {
            return this.d.hasSubMenu();
        }

        public View c() {
            return this.d.onCreateActionView();
        }

        public boolean d() {
            return this.d.onPerformDefaultAction();
        }

        public void a(SubMenu subMenu) {
            this.d.onPrepareSubMenu(q.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    static class b extends FrameLayout implements androidx.appcompat.d.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f253a;

        b(View view) {
            super(view.getContext());
            this.f253a = (CollapsibleActionView) view;
            addView(view);
        }

        /* access modifiers changed from: package-private */
        public View a() {
            return (View) this.f253a;
        }

        public void onActionViewCollapsed() {
            this.f253a.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f253a.onActionViewExpanded();
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class c extends C0056d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f223a).onMenuItemActionCollapse(q.this.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f223a).onMenuItemActionExpand(q.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS */
    private class d extends C0056d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f223a).onMenuItemClick(q.this.a(menuItem));
        }
    }

    q(Context context, androidx.core.b.a.b bVar) {
        super(context, bVar);
    }

    public void a(boolean z) {
        try {
            if (this.e == null) {
                this.e = ((androidx.core.b.a.b) this.f223a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.e.invoke(this.f223a, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    public boolean collapseActionView() {
        return ((androidx.core.b.a.b) this.f223a).collapseActionView();
    }

    public boolean expandActionView() {
        return ((androidx.core.b.a.b) this.f223a).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0084b a2 = ((androidx.core.b.a.b) this.f223a).a();
        if (a2 instanceof a) {
            return ((a) a2).d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = ((androidx.core.b.a.b) this.f223a).getActionView();
        return actionView instanceof b ? ((b) actionView).a() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((androidx.core.b.a.b) this.f223a).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((androidx.core.b.a.b) this.f223a).getGroupId();
    }

    public Drawable getIcon() {
        return ((androidx.core.b.a.b) this.f223a).getIcon();
    }

    public Intent getIntent() {
        return ((androidx.core.b.a.b) this.f223a).getIntent();
    }

    public int getItemId() {
        return ((androidx.core.b.a.b) this.f223a).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((androidx.core.b.a.b) this.f223a).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((androidx.core.b.a.b) this.f223a).getNumericShortcut();
    }

    public int getOrder() {
        return ((androidx.core.b.a.b) this.f223a).getOrder();
    }

    public SubMenu getSubMenu() {
        return a(((androidx.core.b.a.b) this.f223a).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((androidx.core.b.a.b) this.f223a).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((androidx.core.b.a.b) this.f223a).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((androidx.core.b.a.b) this.f223a).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((androidx.core.b.a.b) this.f223a).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((androidx.core.b.a.b) this.f223a).isCheckable();
    }

    public boolean isChecked() {
        return ((androidx.core.b.a.b) this.f223a).isChecked();
    }

    public boolean isEnabled() {
        return ((androidx.core.b.a.b) this.f223a).isEnabled();
    }

    public boolean isVisible() {
        return ((androidx.core.b.a.b) this.f223a).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((androidx.core.b.a.b) this.f223a).a((C0084b) actionProvider != null ? a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((androidx.core.b.a.b) this.f223a).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        ((androidx.core.b.a.b) this.f223a).setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((androidx.core.b.a.b) this.f223a).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((androidx.core.b.a.b) this.f223a).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((androidx.core.b.a.b) this.f223a).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((androidx.core.b.a.b) this.f223a).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((androidx.core.b.a.b) this.f223a).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        ((androidx.core.b.a.b) this.f223a).setNumericShortcut(c2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((androidx.core.b.a.b) this.f223a).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((androidx.core.b.a.b) this.f223a).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        ((androidx.core.b.a.b) this.f223a).setShortcut(c2, c3);
        return this;
    }

    public void setShowAsAction(int i) {
        ((androidx.core.b.a.b) this.f223a).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((androidx.core.b.a.b) this.f223a).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f223a).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((androidx.core.b.a.b) this.f223a).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((androidx.core.b.a.b) this.f223a).setVisible(z);
    }

    public MenuItem setIcon(int i) {
        ((androidx.core.b.a.b) this.f223a).setIcon(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((androidx.core.b.a.b) this.f223a).setTitle(i);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((androidx.core.b.a.b) this.f223a).setActionView(i);
        View actionView = ((androidx.core.b.a.b) this.f223a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((androidx.core.b.a.b) this.f223a).setActionView((View) new b(actionView));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public a a(ActionProvider actionProvider) {
        return new a(this.f221b, actionProvider);
    }
}
