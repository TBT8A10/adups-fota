package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.d.b;
import androidx.appcompat.d.g;
import androidx.appcompat.d.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.A;
import androidx.core.h.C;
import androidx.core.h.t;
import androidx.core.h.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar */
public class K extends ActionBar implements ActionBarOverlayLayout.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f121a = new AccelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f122b = new DecelerateInterpolator();
    private boolean A = true;
    i B;
    private boolean C;
    boolean D;
    final A E = new H(this);
    final A F = new I(this);
    final C G = new J(this);

    /* renamed from: c  reason: collision with root package name */
    Context f123c;
    private Context d;
    private Activity e;
    private Dialog f;
    ActionBarOverlayLayout g;
    ActionBarContainer h;
    D i;
    ActionBarContextView j;
    View k;
    ScrollingTabContainerView l;
    private ArrayList<Object> m = new ArrayList<>();
    private int n = -1;
    private boolean o;
    a p;
    b q;
    b.a r;
    private boolean s;
    private ArrayList<ActionBar.a> t = new ArrayList<>();
    private boolean u;
    private int v = 0;
    boolean w = true;
    boolean x;
    boolean y;
    private boolean z;

    /* compiled from: WindowDecorActionBar */
    public class a extends b implements l.a {

        /* renamed from: c  reason: collision with root package name */
        private final Context f124c;
        private final l d;
        private b.a e;
        private WeakReference<View> f;

        public a(Context context, b.a aVar) {
            this.f124c = context;
            this.e = aVar;
            l lVar = new l(context);
            lVar.c(1);
            this.d = lVar;
            this.d.a((l.a) this);
        }

        public void a() {
            K k = K.this;
            if (k.p == this) {
                if (!K.a(k.x, k.y, false)) {
                    K k2 = K.this;
                    k2.q = this;
                    k2.r = this.e;
                } else {
                    this.e.a(this);
                }
                this.e = null;
                K.this.d(false);
                K.this.j.a();
                K.this.i.getViewGroup().sendAccessibilityEvent(32);
                K k3 = K.this;
                k3.g.setHideOnContentScrollEnabled(k3.D);
                K.this.p = null;
            }
        }

        public void b(CharSequence charSequence) {
            K.this.j.setTitle(charSequence);
        }

        public Menu c() {
            return this.d;
        }

        public MenuInflater d() {
            return new g(this.f124c);
        }

        public CharSequence e() {
            return K.this.j.getSubtitle();
        }

        public CharSequence g() {
            return K.this.j.getTitle();
        }

        public void i() {
            if (K.this.p == this) {
                this.d.s();
                try {
                    this.e.b(this, this.d);
                } finally {
                    this.d.r();
                }
            }
        }

        public boolean j() {
            return K.this.j.b();
        }

        public boolean k() {
            this.d.s();
            try {
                return this.e.a_shaKey_method2((b) this, (Menu) this.d);
            } finally {
                this.d.r();
            }
        }

        public void b(int i) {
            b((CharSequence) K.this.f123c.getResources().getString(i));
        }

        public View b() {
            WeakReference<View> weakReference = this.f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public void a(View view) {
            K.this.j.setCustomView(view);
            this.f = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            K.this.j.setSubtitle(charSequence);
        }

        public void a(int i) {
            a((CharSequence) K.this.f123c.getResources().getString(i));
        }

        public void a(boolean z) {
            super.a(z);
            K.this.j.setTitleOptional(z);
        }

        public boolean a(l lVar, MenuItem menuItem) {
            b.a aVar = this.e;
            if (aVar != null) {
                return aVar.a_shaKey_method2((b) this, menuItem);
            }
            return false;
        }

        public void a(l lVar) {
            if (this.e != null) {
                i();
                K.this.j.d();
            }
        }
    }

    public K(Activity activity, boolean z2) {
        this.e = activity;
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (!z2) {
            this.k = decorView.findViewById(16908290);
        }
    }

    private D a(View view) {
        if (view instanceof D) {
            return (D) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private void b(View view) {
        this.g = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.i = a(view.findViewById(R$id.action_bar));
        this.j = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        this.h = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        D d2 = this.i;
        if (d2 == null || this.j == null || this.h == null) {
            throw new IllegalStateException(K.class.getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f123c = d2.getContext();
        boolean z2 = (this.i.getDisplayOptions() & 4) != 0;
        if (z2) {
            this.o = true;
        }
        androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(this.f123c);
        i(a2.a() || z2);
        j(a2.f());
        TypedArray obtainStyledAttributes = this.f123c.obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            h(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void j(boolean z2) {
        this.u = z2;
        if (!this.u) {
            this.i.a((ScrollingTabContainerView) null);
            this.h.setTabContainer(this.l);
        } else {
            this.h.setTabContainer((ScrollingTabContainerView) null);
            this.i.a(this.l);
        }
        boolean z3 = true;
        boolean z4 = i() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.l;
        if (scrollingTabContainerView != null) {
            if (z4) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.g;
                if (actionBarOverlayLayout != null) {
                    t.D(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.i.setCollapsible(!this.u && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.g;
        if (this.u || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private void k(boolean z2) {
        if (a(this.x, this.y, this.z)) {
            if (!this.A) {
                this.A = true;
                f(z2);
            }
        } else if (this.A) {
            this.A = false;
            e(z2);
        }
    }

    private void l() {
        if (!this.z) {
            this.z = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            k(false);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.a aVar) {
        this.t.add(aVar);
    }

    public void c(boolean z2) {
        i iVar;
        this.C = z2;
        if (!z2 && (iVar = this.B) != null) {
            iVar.a();
        }
    }

    public void d(boolean z2) {
        z zVar;
        z zVar2;
        if (z2) {
            l();
        } else {
            j();
        }
        if (k()) {
            if (z2) {
                zVar = this.i.setupAnimatorToVisibility(4, 100);
                zVar2 = this.j.a(0, 200);
            } else {
                zVar2 = this.i.setupAnimatorToVisibility(0, 200);
                zVar = this.j.a(8, 100);
            }
            i iVar = new i();
            iVar.a(zVar, zVar2);
            iVar.c();
        } else if (z2) {
            this.i.setVisibility(4);
            this.j.setVisibility(0);
        } else {
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        }
    }

    public void e(boolean z2) {
        View view;
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        if (this.v != 0 || (!this.C && !z2)) {
            this.E.b((View) null);
            return;
        }
        this.h.setAlpha(1.0f);
        this.h.setTransitioning(true);
        i iVar2 = new i();
        float f2 = (float) (-this.h.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.h.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        z a2 = t.a(this.h);
        a2.b(f2);
        a2.a(this.G);
        iVar2.a(a2);
        if (this.w && (view = this.k) != null) {
            z a3 = t.a(view);
            a3.b(f2);
            iVar2.a(a3);
        }
        iVar2.a(f121a);
        iVar2.a(250);
        iVar2.a(this.E);
        this.B = iVar2;
        iVar2.c();
    }

    public void enableContentAnimations(boolean z2) {
        this.w = z2;
    }

    public void f(boolean z2) {
        View view;
        View view2;
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        this.h.setVisibility(0);
        if (this.v != 0 || (!this.C && !z2)) {
            this.h.setAlpha(1.0f);
            this.h.setTranslationY(0.0f);
            if (this.w && (view = this.k) != null) {
                view.setTranslationY(0.0f);
            }
            this.F.b((View) null);
        } else {
            this.h.setTranslationY(0.0f);
            float f2 = (float) (-this.h.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.h.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.h.setTranslationY(f2);
            i iVar2 = new i();
            z a2 = t.a(this.h);
            a2.b(0.0f);
            a2.a(this.G);
            iVar2.a(a2);
            if (this.w && (view2 = this.k) != null) {
                view2.setTranslationY(f2);
                z a3 = t.a(this.k);
                a3.b(0.0f);
                iVar2.a(a3);
            }
            iVar2.a(f122b);
            iVar2.a(250);
            iVar2.a(this.F);
            this.B = iVar2;
            iVar2.c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            t.D(actionBarOverlayLayout);
        }
    }

    public void g(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        b.a aVar = this.r;
        if (aVar != null) {
            aVar.a(this.q);
            this.q = null;
            this.r = null;
        }
    }

    public void hideForSystem() {
        if (!this.y) {
            this.y = true;
            k(true);
        }
    }

    public void i(boolean z2) {
        this.i.setHomeButtonEnabled(z2);
    }

    public void onContentScrollStarted() {
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
            this.B = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public void onWindowVisibilityChanged(int i2) {
        this.v = i2;
    }

    public void removeOnMenuVisibilityListener(ActionBar.a aVar) {
        this.t.remove(aVar);
    }

    public void showForSystem() {
        if (this.y) {
            this.y = false;
            k(true);
        }
    }

    public int i() {
        return this.i.getNavigationMode();
    }

    public int c() {
        return this.i.getDisplayOptions();
    }

    public void h(boolean z2) {
        if (!z2 || this.g.b()) {
            this.D = z2;
            this.g.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void a(float f2) {
        t.a_shaKey_method2((View) this.h, f2);
    }

    private boolean k() {
        return t.z(this.h);
    }

    public void a(Configuration configuration) {
        j(androidx.appcompat.d.a.a(this.f123c).f());
    }

    public void a(boolean z2) {
        if (z2 != this.s) {
            this.s = z2;
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t.get(i2).onMenuVisibilityChanged(z2);
            }
        }
    }

    public void a(CharSequence charSequence) {
        this.i.setWindowTitle(charSequence);
    }

    public void a(int i2, int i3) {
        int displayOptions = this.i.getDisplayOptions();
        if ((i3 & 4) != 0) {
            this.o = true;
        }
        this.i.setDisplayOptions((i2 & i3) | ((i3 ^ -1) & displayOptions));
    }

    private void j() {
        if (this.z) {
            this.z = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            k(false);
        }
    }

    public Context d() {
        if (this.d == null) {
            TypedValue typedValue = new TypedValue();
            this.f123c.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.d = new ContextThemeWrapper(this.f123c, i2);
            } else {
                this.d = this.f123c;
            }
        }
        return this.d;
    }

    public K(Dialog dialog) {
        this.f = dialog;
        b(dialog.getWindow().getDecorView());
    }

    public b a(b.a aVar) {
        a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.g.setHideOnContentScrollEnabled(false);
        this.j.c();
        a aVar3 = new a(this.j.getContext(), aVar);
        if (!aVar3.k()) {
            return null;
        }
        this.p = aVar3;
        aVar3.i();
        this.j.a(aVar3);
        d(true);
        this.j.sendAccessibilityEvent(32);
        return aVar3;
    }

    public boolean b() {
        D d2 = this.i;
        if (d2 == null || !d2.hasExpandedActionView()) {
            return false;
        }
        this.i.collapseActionView();
        return true;
    }

    public void b(boolean z2) {
        if (!this.o) {
            g(z2);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu c2;
        a aVar = this.p;
        if (aVar == null || (c2 = aVar.c()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        c2.setQwertyMode(z2);
        return c2.performShortcut(i2, keyEvent, 0);
    }
}
