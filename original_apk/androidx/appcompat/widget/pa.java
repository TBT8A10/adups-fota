package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.A;
import androidx.core.h.t;
import androidx.core.h.z;

/* compiled from: ToolbarWidgetWrapper */
public class pa implements D {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f457a;

    /* renamed from: b  reason: collision with root package name */
    private int f458b;

    /* renamed from: c  reason: collision with root package name */
    private View f459c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    public pa(Toolbar toolbar, boolean z) {
        this(toolbar, z, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    private void d(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f458b & 8) != 0) {
            this.f457a.setTitle(charSequence);
        }
    }

    public void a(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f457a.getNavigationContentDescription())) {
                b(this.p);
            }
        }
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f458b & 8) != 0) {
            this.f457a.setSubtitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.h = true;
        d(charSequence);
    }

    public boolean canShowOverflowMenu() {
        return this.f457a.b();
    }

    public void collapseActionView() {
        this.f457a.c();
    }

    public void dismissPopupMenus() {
        this.f457a.d();
    }

    public Context getContext() {
        return this.f457a.getContext();
    }

    public int getDisplayOptions() {
        return this.f458b;
    }

    public Menu getMenu() {
        return this.f457a.getMenu();
    }

    public int getNavigationMode() {
        return this.o;
    }

    public CharSequence getTitle() {
        return this.f457a.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.f457a;
    }

    public boolean hasExpandedActionView() {
        return this.f457a.f();
    }

    public boolean hideOverflowMenu() {
        return this.f457a.g();
    }

    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.f457a.h();
    }

    public boolean isOverflowMenuShowing() {
        return this.f457a.i();
    }

    public void setCollapsible(boolean z) {
        this.f457a.setCollapsible(z);
    }

    public void setDisplayOptions(int i2) {
        View view;
        int i3 = this.f458b ^ i2;
        this.f458b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    b();
                }
                c();
            }
            if ((i3 & 3) != 0) {
                d();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f457a.setTitle(this.i);
                    this.f457a.setSubtitle(this.j);
                } else {
                    this.f457a.setTitle((CharSequence) null);
                    this.f457a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.d) != null) {
                if ((i2 & 16) != 0) {
                    this.f457a.addView(view);
                } else {
                    this.f457a.removeView(view);
                }
            }
        }
    }

    public void setHomeButtonEnabled(boolean z) {
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? a.b(getContext(), i2) : null);
    }

    public void setLogo(int i2) {
        a(i2 != 0 ? a.b(getContext(), i2) : null);
    }

    public void setMenuPrepared() {
        this.m = true;
    }

    public void setVisibility(int i2) {
        this.f457a.setVisibility(i2);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            d(charSequence);
        }
    }

    public z setupAnimatorToVisibility(int i2, long j2) {
        z a2 = t.a(this.f457a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.a(j2);
        a2.a((A) new oa(this, i2));
        return a2;
    }

    public boolean showOverflowMenu() {
        return this.f457a.k();
    }

    public pa(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f457a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        ia a2 = ia.a(toolbar.getContext(), (AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.q = a2.b(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                c(e2);
            }
            CharSequence e3 = a2.e(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                b(e3);
            }
            Drawable b2 = a2.b(R$styleable.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(R$styleable.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            setDisplayOptions(a2.d(R$styleable.ActionBar_displayOptions, 0));
            int g2 = a2.g(R$styleable.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f457a.getContext()).inflate(g2, this.f457a, false));
                setDisplayOptions(this.f458b | 16);
            }
            int f2 = a2.f(R$styleable.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f457a.getLayoutParams();
                layoutParams.height = f2;
                this.f457a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(R$styleable.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(R$styleable.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f457a.a(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g3 = a2.g(R$styleable.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f457a;
                toolbar2.b(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f457a;
                toolbar3.a_shaKey_method2(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(R$styleable.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f457a.setPopupTheme(g5);
            }
        } else {
            this.f458b = a();
        }
        a2.a();
        a(i2);
        this.k = this.f457a.getNavigationContentDescription();
        this.f457a.setNavigationOnClickListener(new na(this));
    }

    public void setIcon(Drawable drawable) {
        this.e = drawable;
        d();
    }

    private void c() {
        if ((this.f458b & 4) != 0) {
            Toolbar toolbar = this.f457a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f457a.setNavigationIcon((Drawable) null);
    }

    private void d() {
        Drawable drawable;
        int i2 = this.f458b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f;
            if (drawable == null) {
                drawable = this.e;
            }
        } else {
            drawable = this.e;
        }
        this.f457a.setLogo(drawable);
    }

    public void b(Drawable drawable) {
        this.g = drawable;
        c();
    }

    private int a() {
        if (this.f457a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f457a.getNavigationIcon();
        return 15;
    }

    public void b(int i2) {
        a((CharSequence) i2 == 0 ? null : getContext().getString(i2));
    }

    private void b() {
        if ((this.f458b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f457a.setNavigationContentDescription(this.p);
        } else {
            this.f457a.setNavigationContentDescription(this.k);
        }
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        d();
    }

    public void a(Menu menu, v.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f457a.getContext());
            this.n.a(R$id.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f457a.a((l) menu, this.n);
    }

    public void a(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f459c;
        if (view != null && view.getParent() == (toolbar = this.f457a)) {
            toolbar.removeView(this.f459c);
        }
        this.f459c = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.o == 2) {
            this.f457a.addView(this.f459c, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f459c.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f67a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public void a(View view) {
        View view2 = this.d;
        if (!(view2 == null || (this.f458b & 16) == 0)) {
            this.f457a.removeView(view2);
        }
        this.d = view;
        if (view != null && (this.f458b & 16) != 0) {
            this.f457a.addView(this.d);
        }
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        b();
    }

    public void a(v.a aVar, l.a aVar2) {
        this.f457a.a(aVar, aVar2);
    }
}
