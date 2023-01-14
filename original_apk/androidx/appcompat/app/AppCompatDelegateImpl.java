package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.d.b;
import androidx.appcompat.d.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C;
import androidx.appcompat.widget.C0074q;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.G;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ia;
import androidx.appcompat.widget.va;
import androidx.appcompat.widget.wa;
import androidx.core.h.A;
import androidx.core.h.C0086d;
import androidx.core.h.o;
import androidx.core.h.t;
import androidx.core.h.z;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl extends n implements l.a, LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f77b = (Build.VERSION.SDK_INT < 21);

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f78c = {16842836};
    private static boolean d = true;
    private boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    private boolean G;
    private PanelFeatureState[] H;
    private PanelFeatureState I;
    private boolean J;
    boolean K;
    private int L = -100;
    private boolean M;
    private e N;
    boolean O;
    int P;
    private final Runnable Q = new p(this);
    private boolean R;
    private Rect S;
    private Rect T;
    private AppCompatViewInflater U;
    final Context e;
    final Window f;
    final Window.Callback g;
    final Window.Callback h;
    final m i;
    ActionBar j;
    MenuInflater k;
    private CharSequence l;
    private C m;
    private b n;
    private g o;
    androidx.appcompat.d.b p;
    ActionBarContextView q;
    PopupWindow r;
    Runnable s;
    z t = null;
    private boolean u = true;
    private boolean v;
    private ViewGroup w;
    private TextView x;
    private View y;
    private boolean z;

    private class a implements C0042a {
        a() {
        }
    }

    class c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f87a;

        public c(b.a aVar) {
            this.f87a = aVar;
        }

        public boolean a(androidx.appcompat.d.b bVar, Menu menu) {
            return this.f87a.a_shaKey_method2(bVar, menu);
        }

        public boolean b(androidx.appcompat.d.b bVar, Menu menu) {
            return this.f87a.b(bVar, menu);
        }

        public boolean a(androidx.appcompat.d.b bVar, MenuItem menuItem) {
            return this.f87a.a_shaKey_method2(bVar, menuItem);
        }

        public void a(androidx.appcompat.d.b bVar) {
            this.f87a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.r != null) {
                appCompatDelegateImpl.f.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.s);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.q != null) {
                appCompatDelegateImpl2.m();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                z a2 = t.a(appCompatDelegateImpl3.q);
                a2.a(0.0f);
                appCompatDelegateImpl3.t = a2;
                AppCompatDelegateImpl.this.t.a((A) new w(this));
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            m mVar = appCompatDelegateImpl4.i;
            if (mVar != null) {
                mVar.onSupportActionModeFinished(appCompatDelegateImpl4.p);
            }
            AppCompatDelegateImpl.this.p = null;
        }
    }

    final class e {

        /* renamed from: a  reason: collision with root package name */
        private G f90a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f91b;

        /* renamed from: c  reason: collision with root package name */
        private BroadcastReceiver f92c;
        private IntentFilter d;

        e(G g) {
            this.f90a = g;
            this.f91b = g.a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f92c;
            if (broadcastReceiver != null) {
                AppCompatDelegateImpl.this.e.unregisterReceiver(broadcastReceiver);
                this.f92c = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean a2 = this.f90a.a();
            if (a2 != this.f91b) {
                this.f91b = a2;
                AppCompatDelegateImpl.this.a();
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            this.f91b = this.f90a.a();
            return this.f91b ? 2 : 1;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            a();
            if (this.f92c == null) {
                this.f92c = new x(this);
            }
            if (this.d == null) {
                this.d = new IntentFilter();
                this.d.addAction("android.intent.action.TIME_SET");
                this.d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.d.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImpl.this.e.registerReceiver(this.f92c, this.d);
        }
    }

    private class f extends ContentFrameLayout {
        public f(Context context) {
            super(context);
        }

        private boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.e(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
        }
    }

    static {
        if (f77b && !d) {
            Thread.setDefaultUncaughtExceptionHandler(new o(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    AppCompatDelegateImpl(Context context, Window window, m mVar) {
        this.e = context;
        this.f = window;
        this.i = mVar;
        this.g = this.f.getCallback();
        Window.Callback callback = this.g;
        if (!(callback instanceof d)) {
            this.h = new d(callback);
            this.f.setCallback(this.h);
            ia a2 = ia.a(context, (AttributeSet) null, f78c);
            Drawable c2 = a2.c(0);
            if (c2 != null) {
                this.f.setBackgroundDrawable(c2);
            }
            a2.a();
            return;
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean A() {
        if (this.M) {
            Context context = this.e;
            if (context instanceof Activity) {
                try {
                    if ((context.getPackageManager().getActivityInfo(new ComponentName(this.e, this.e.getClass()), 0).configChanges & 512) == 0) {
                        return true;
                    }
                    return false;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    return true;
                }
            }
        }
        return false;
    }

    private void B() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int l(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.w.findViewById(16908290);
        View decorView = this.f.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private ViewGroup v() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.e.obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
                b(1);
            } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
                b(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                b(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                b(10);
            }
            this.E = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.e);
            if (this.F) {
                if (this.D) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    t.a_shaKey_method2((View) viewGroup, (o) new q(this));
                } else {
                    ((G) viewGroup).setOnFitSystemWindowsListener(new r(this));
                }
            } else if (this.E) {
                viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                this.C = false;
                this.B = false;
            } else if (this.B) {
                TypedValue typedValue = new TypedValue();
                this.e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    context = new androidx.appcompat.d.d(this.e, i2);
                } else {
                    context = this.e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                this.m = (C) viewGroup.findViewById(R$id.decor_content_parent);
                this.m.setWindowCallback(p());
                if (this.C) {
                    this.m.initFeature(109);
                }
                if (this.z) {
                    this.m.initFeature(2);
                }
                if (this.A) {
                    this.m.initFeature(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.m == null) {
                    this.x = (TextView) viewGroup.findViewById(R$id.title);
                }
                wa.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new s(this));
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.B + ", windowActionBarOverlay: " + this.C + ", android:windowIsFloating: " + this.E + ", windowActionModeOverlay: " + this.D + ", windowNoTitle: " + this.F + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void w() {
        if (this.N == null) {
            this.N = new e(G.a(this.e));
        }
    }

    private void x() {
        if (!this.v) {
            this.w = v();
            CharSequence o2 = o();
            if (!TextUtils.isEmpty(o2)) {
                C c2 = this.m;
                if (c2 != null) {
                    c2.setWindowTitle(o2);
                } else if (s() != null) {
                    s().a(o2);
                } else {
                    TextView textView = this.x;
                    if (textView != null) {
                        textView.setText(o2);
                    }
                }
            }
            u();
            a(this.w);
            this.v = true;
            PanelFeatureState a2 = a(0, false);
            if (this.K) {
                return;
            }
            if (a2 == null || a2.j == null) {
                k(108);
            }
        }
    }

    private int y() {
        int i2 = this.L;
        return i2 != -100 ? i2 : n.b();
    }

    private void z() {
        x();
        if (this.B && this.j == null) {
            Window.Callback callback = this.g;
            if (callback instanceof Activity) {
                this.j = new K((Activity) callback, this.C);
            } else if (callback instanceof Dialog) {
                this.j = new K((Dialog) callback);
            }
            ActionBar actionBar = this.j;
            if (actionBar != null) {
                actionBar.b(this.R);
            }
        }
    }

    public void a(Bundle bundle) {
        Window.Callback callback = this.g;
        if (callback instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.b((Activity) callback);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar s2 = s();
                if (s2 == null) {
                    this.R = true;
                } else {
                    s2.b(true);
                }
            }
        }
        if (bundle != null && this.L == -100) {
            this.L = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
    }

    public void b(Bundle bundle) {
        x();
    }

    public void c(int i2) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.e).inflate(i2, viewGroup);
        this.g.onContentChanged();
    }

    public MenuInflater d() {
        if (this.k == null) {
            z();
            ActionBar actionBar = this.j;
            this.k = new androidx.appcompat.d.g(actionBar != null ? actionBar.d() : this.e);
        }
        return this.k;
    }

    public ActionBar e() {
        z();
        return this.j;
    }

    public void f() {
        LayoutInflater from = LayoutInflater.from(this.e);
        if (from.getFactory() == null) {
            androidx.core.h.e.a_shaKey_method2(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void g() {
        ActionBar e2 = e();
        if (e2 == null || !e2.e()) {
            k(0);
        }
    }

    public void h() {
        if (this.O) {
            this.f.getDecorView().removeCallbacks(this.Q);
        }
        this.K = true;
        ActionBar actionBar = this.j;
        if (actionBar != null) {
            actionBar.f();
        }
        e eVar = this.N;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void i() {
        ActionBar e2 = e();
        if (e2 != null) {
            e2.c(true);
        }
    }

    public void j() {
        a();
    }

    public void k() {
        ActionBar e2 = e();
        if (e2 != null) {
            e2.c(false);
        }
        e eVar = this.N;
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        z zVar = this.t;
        if (zVar != null) {
            zVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final Context n() {
        ActionBar e2 = e();
        Context d2 = e2 != null ? e2.d() : null;
        return d2 == null ? this.e : d2;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence o() {
        Window.Callback callback = this.g;
        if (callback instanceof Activity) {
            return ((Activity) callback).getTitle();
        }
        return this.l;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback p() {
        return this.f.getCallback();
    }

    public boolean q() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        androidx.appcompat.d.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        ActionBar e2 = e();
        if (e2 == null || !e2.b()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar s() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.w;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t() {
        /*
            r1 = this;
            boolean r0 = r1.v
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.w
            if (r0 == 0) goto L_0x0010
            boolean r0 = androidx.core.h.t.z(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.t():boolean");
    }

    private final class b implements v.a {
        b() {
        }

        public boolean a(l lVar) {
            Window.Callback p = AppCompatDelegateImpl.this.p();
            if (p == null) {
                return true;
            }
            p.onMenuOpened(108, lVar);
            return true;
        }

        public void a(l lVar, boolean z) {
            AppCompatDelegateImpl.this.b(lVar);
        }
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.g.onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public int j(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        ActionBarContextView actionBarContextView = this.q;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            z2 = true;
            if (this.q.isShown()) {
                if (this.S == null) {
                    this.S = new Rect();
                    this.T = new Rect();
                }
                Rect rect = this.S;
                Rect rect2 = this.T;
                rect.set(0, i2, 0, 0);
                wa.a(this.w, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.y;
                    if (view == null) {
                        this.y = new View(this.e);
                        this.y.setBackgroundColor(this.e.getResources().getColor(R$color.abc_input_method_navigation_guard));
                        this.w.addView(this.y, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.y.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.y == null) {
                    z2 = false;
                }
                if (!this.D && z2) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z4 = true;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z3) {
                this.q.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.y;
        if (view2 != null) {
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        return i2;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f79a;

        /* renamed from: b  reason: collision with root package name */
        int f80b;

        /* renamed from: c  reason: collision with root package name */
        int f81c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        l j;
        j k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new y();

            /* renamed from: a  reason: collision with root package name */
            int f82a;

            /* renamed from: b  reason: collision with root package name */
            boolean f83b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f84c;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f82a = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f83b = z;
                if (savedState.f83b) {
                    savedState.f84c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f82a);
                parcel.writeInt(this.f83b ? 1 : 0);
                if (this.f83b) {
                    parcel.writeBundle(this.f84c);
                }
            }
        }

        PanelFeatureState(int i2) {
            this.f79a = i2;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            if (this.i == null && this.k.a().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f80b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar) {
            j jVar;
            l lVar2 = this.j;
            if (lVar != lVar2) {
                if (lVar2 != null) {
                    lVar2.b((v) this.k);
                }
                this.j = lVar;
                if (lVar != null && (jVar = this.k) != null) {
                    lVar.a((v) jVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public w a(v.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new j(this.l, R$layout.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a((v) this.k);
            }
            return this.k.a(this.g);
        }
    }

    private boolean m(int i2) {
        Resources resources = this.e.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        int i4 = i2 == 2 ? 32 : 16;
        if (i3 == i4) {
            return false;
        }
        if (A()) {
            ((Activity) this.e).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i4 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        B.a(resources);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        a(a(i2, true), true);
    }

    /* access modifiers changed from: package-private */
    public void i(int i2) {
        if (i2 == 108) {
            ActionBar e2 = e();
            if (e2 != null) {
                e2.a(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState a2 = a(i2, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        l lVar;
        C c2 = this.m;
        if (c2 != null) {
            c2.dismissPopups();
        }
        if (this.r != null) {
            this.f.getDecorView().removeCallbacks(this.s);
            if (this.r.isShowing()) {
                try {
                    this.r.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.r = null;
        }
        m();
        PanelFeatureState a2 = a(0, false);
        if (a2 != null && (lVar = a2.j) != null) {
            lVar.close();
        }
    }

    class d extends androidx.appcompat.d.j {
        d(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.e, callback);
            androidx.appcompat.d.b a2 = AppCompatDelegateImpl.this.a((b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.b(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof l)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AppCompatDelegateImpl.this.h(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AppCompatDelegateImpl.this.i(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            l lVar = menu instanceof l ? (l) menu : null;
            if (i == 0 && lVar == null) {
                return false;
            }
            if (lVar != null) {
                lVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (lVar != null) {
                lVar.c(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            l lVar;
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (a2 == null || (lVar = a2.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, lVar, i);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.q()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.q() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.d.b r0 = r3.p
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r3.a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.C r4 = r3.m
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.canShowOverflowMenu()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.e
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.C r4 = r3.m
            boolean r4 = r4.isOverflowMenuShowing()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.K
            if (r4 != 0) goto L_0x0063
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0063
            androidx.appcompat.widget.C r4 = r3.m
            boolean r4 = r4.showOverflowMenu()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.C r4 = r3.m
            boolean r4 = r4.hideOverflowMenu()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r2.n
            if (r4 == 0) goto L_0x004c
            goto L_0x0065
        L_0x004c:
            boolean r4 = r2.m
            if (r4 == 0) goto L_0x0063
            boolean r4 = r2.r
            if (r4 == 0) goto L_0x005b
            r2.m = r1
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0063
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            r4 = 1
            goto L_0x006a
        L_0x0063:
            r4 = 0
            goto L_0x006a
        L_0x0065:
            boolean r4 = r2.o
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (boolean) r0)
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            android.content.Context r5 = r3.e
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007c
            r5.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.e.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        w();
        return this.N.c();
    }

    private final class g implements v.a {
        g() {
        }

        public void a(l lVar, boolean z) {
            l m = lVar.m();
            boolean z2 = m != lVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                lVar = m;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) lVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.a(a2.f79a, a2, m);
                AppCompatDelegateImpl.this.a(a2, true);
                return;
            }
            AppCompatDelegateImpl.this.a(a2, z);
        }

        public boolean a(l lVar) {
            Window.Callback p;
            if (lVar != null) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.B || (p = appCompatDelegateImpl.p()) == null || AppCompatDelegateImpl.this.K) {
                return true;
            }
            p.onMenuOpened(108, lVar);
            return true;
        }
    }

    private void k(int i2) {
        this.P = (1 << i2) | this.P;
        if (!this.O) {
            t.a_shaKey_method2(this.f.getDecorView(), this.Q);
            this.O = true;
        }
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (!a2.o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    public void c(Bundle bundle) {
        int i2 = this.L;
        if (i2 != -100) {
            bundle.putInt("appcompat:local_night_mode", i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.c(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.s();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 == 108 || i2 == 0) && this.m != null && (a2 = a(0, false)) != null) {
            a2.m = false;
            b(a2, (KeyEvent) null);
        }
    }

    public boolean b(int i2) {
        int l2 = l(i2);
        if (this.F && l2 == 108) {
            return false;
        }
        if (this.B && l2 == 1) {
            this.B = false;
        }
        if (l2 == 1) {
            B();
            this.F = true;
            return true;
        } else if (l2 == 2) {
            B();
            this.z = true;
            return true;
        } else if (l2 == 5) {
            B();
            this.A = true;
            return true;
        } else if (l2 == 10) {
            B();
            this.D = true;
            return true;
        } else if (l2 == 108) {
            B();
            this.B = true;
            return true;
        } else if (l2 != 109) {
            return this.f.requestFeature(l2);
        } else {
            B();
            this.C = true;
            return true;
        }
    }

    public void a(Toolbar toolbar) {
        if (this.g instanceof Activity) {
            ActionBar e2 = e();
            if (!(e2 instanceof K)) {
                this.k = null;
                if (e2 != null) {
                    e2.f();
                }
                if (toolbar != null) {
                    E e3 = new E(toolbar, ((Activity) this.g).getTitle(), this.h);
                    this.j = e3;
                    this.f.setCallback(e3.h());
                } else {
                    this.j = null;
                    this.f.setCallback(this.h);
                }
                g();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.J;
            this.J = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (r()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        ActionBar e2;
        if (i2 == 108 && (e2 = e()) != null) {
            e2.a(true);
        }
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        Context context = this.e;
        int i2 = panelFeatureState.f79a;
        if ((i2 == 0 || i2 == 108) && this.m != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        l lVar = new l(context);
        lVar.a((l.a) this);
        panelFeatureState.a(lVar);
        return true;
    }

    public <T extends View> T a(int i2) {
        x();
        return this.f.findViewById(i2);
    }

    public void a(Configuration configuration) {
        ActionBar e2;
        if (this.B && this.v && (e2 = e()) != null) {
            e2.a(configuration);
        }
        C0074q.a().a(this.e);
        a();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.d.b b(androidx.appcompat.d.b.a r8) {
        /*
            r7 = this;
            r7.m()
            androidx.appcompat.d.b r0 = r7.p
            if (r0 == 0) goto L_0x000a
            r0.a()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.c
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$c r0 = new androidx.appcompat.app.AppCompatDelegateImpl$c
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.m r0 = r7.i
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.K
            if (r2 != 0) goto L_0x0022
            androidx.appcompat.d.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.p = r0
            goto L_0x0165
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.q
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d6
            boolean r0 = r7.E
            if (r0 == 0) goto L_0x00b7
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.e
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R$attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.e
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            androidx.appcompat.d.d r4 = new androidx.appcompat.d.d
            android.content.Context r6 = r7.e
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.e
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.q = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R$attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.r = r5
            android.widget.PopupWindow r5 = r7.r
            r6 = 2
            androidx.core.widget.k.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.r
            androidx.appcompat.widget.ActionBarContextView r6 = r7.q
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.r
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R$attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.q
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.r
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.u r0 = new androidx.appcompat.app.u
            r0.<init>(r7)
            r7.s = r0
            goto L_0x00d6
        L_0x00b7:
            android.view.ViewGroup r0 = r7.w
            int r4 = androidx.appcompat.R$id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d6
            android.content.Context r4 = r7.n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.q = r0
        L_0x00d6:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.q
            if (r0 == 0) goto L_0x0165
            r7.m()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.q
            r0.c()
            androidx.appcompat.d.e r0 = new androidx.appcompat.d.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.q
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.q
            android.widget.PopupWindow r6 = r7.r
            if (r6 != 0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r3 = 0
        L_0x00f2:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.c()
            boolean r8 = r8.a((androidx.appcompat.d.b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x0163
            r0.i()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            r8.a(r0)
            r7.p = r0
            boolean r8 = r7.t()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012d
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            androidx.core.h.z r8 = androidx.core.h.t.a(r8)
            r8.a((float) r0)
            r7.t = r8
            androidx.core.h.z r8 = r7.t
            androidx.appcompat.app.v r0 = new androidx.appcompat.app.v
            r0.<init>(r7)
            r8.a((androidx.core.h.A) r0)
            goto L_0x0153
        L_0x012d:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0153
            androidx.appcompat.widget.ActionBarContextView r8 = r7.q
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            androidx.core.h.t.D(r8)
        L_0x0153:
            android.widget.PopupWindow r8 = r7.r
            if (r8 == 0) goto L_0x0165
            android.view.Window r8 = r7.f
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.s
            r8.post(r0)
            goto L_0x0165
        L_0x0163:
            r7.p = r1
        L_0x0165:
            androidx.appcompat.d.b r8 = r7.p
            if (r8 == 0) goto L_0x0170
            androidx.appcompat.app.m r0 = r7.i
            if (r0 == 0) goto L_0x0170
            r0.onSupportActionModeStarted(r8)
        L_0x0170:
            androidx.appcompat.d.b r8 = r7.p
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(androidx.appcompat.d.b$a):androidx.appcompat.d.b");
    }

    public void a(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.g.onContentChanged();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ((ViewGroup) this.w.findViewById(16908290)).addView(view, layoutParams);
        this.g.onContentChanged();
    }

    public final C0042a c() {
        return new a();
    }

    public final void a(CharSequence charSequence) {
        this.l = charSequence;
        C c2 = this.m;
        if (c2 != null) {
            c2.setWindowTitle(charSequence);
        } else if (s() != null) {
            s().a(charSequence);
        } else {
            TextView textView = this.x;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public boolean a(l lVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback p2 = p();
        if (p2 == null || this.K || (a2 = a((Menu) lVar.m())) == null) {
            return false;
        }
        return p2.onMenuItemSelected(a2.f79a, menuItem);
    }

    public void a(l lVar) {
        a(lVar, true);
    }

    public androidx.appcompat.d.b a(b.a aVar) {
        m mVar;
        if (aVar != null) {
            androidx.appcompat.d.b bVar = this.p;
            if (bVar != null) {
                bVar.a();
            }
            c cVar = new c(aVar);
            ActionBar e2 = e();
            if (e2 != null) {
                this.p = e2.a((b.a) cVar);
                androidx.appcompat.d.b bVar2 = this.p;
                if (!(bVar2 == null || (mVar = this.i) == null)) {
                    mVar.onSupportActionModeStarted(bVar2);
                }
            }
            if (this.p == null) {
                this.p = b((b.a) cVar);
            }
            return this.p;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        View decorView;
        Window.Callback callback = this.g;
        boolean z2 = true;
        if (((callback instanceof C0086d.a) || (callback instanceof A)) && (decorView = this.f.getDecorView()) != null && C0086d.a_shaKey_method2(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.g.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? a_shaKey_method2(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & CpioConstants.C_IWUSR) == 0) {
                z2 = false;
            }
            this.J = z2;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.U == null) {
            String string = this.e.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.U = new AppCompatViewInflater();
            } else {
                try {
                    this.U = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.U = new AppCompatViewInflater();
                }
            }
        }
        if (f77b) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.U.createView(view, str, context, attributeSet, z2, f77b, true, va.b());
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        ActionBar e2 = e();
        if (e2 != null && e2.a_shaKey_method2(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.I;
        if (panelFeatureState == null || !a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.I == null) {
                PanelFeatureState a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.I;
        if (panelFeatureState2 != null) {
            panelFeatureState2.n = true;
        }
        return true;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || t.y((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.o && !this.K) {
            if (panelFeatureState.f79a == 0) {
                if ((this.e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback p2 = p();
            if (p2 == null || p2.onMenuOpened(panelFeatureState.f79a, panelFeatureState.j)) {
                WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.g == null || panelFeatureState.q) {
                        ViewGroup viewGroup = panelFeatureState.g;
                        if (viewGroup == null) {
                            if (!b(panelFeatureState) || panelFeatureState.g == null) {
                                return;
                            }
                        } else if (panelFeatureState.q && viewGroup.getChildCount() > 0) {
                            panelFeatureState.g.removeAllViews();
                        }
                        if (a(panelFeatureState) && panelFeatureState.a()) {
                            ViewGroup.LayoutParams layoutParams2 = panelFeatureState.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            panelFeatureState.g.setBackgroundResource(panelFeatureState.f80b);
                            ViewParent parent = panelFeatureState.h.getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(panelFeatureState.h);
                            }
                            panelFeatureState.g.addView(panelFeatureState.h, layoutParams2);
                            if (!panelFeatureState.h.hasFocus()) {
                                panelFeatureState.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = panelFeatureState.i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i2 = -1;
                            panelFeatureState.n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                            layoutParams3.gravity = panelFeatureState.f81c;
                            layoutParams3.windowAnimations = panelFeatureState.f;
                            windowManager.addView(panelFeatureState.g, layoutParams3);
                            panelFeatureState.o = true;
                            return;
                        }
                    }
                    i2 = -2;
                    panelFeatureState.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.d, panelFeatureState.e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f81c;
                    layoutParams32.windowAnimations = panelFeatureState.f;
                    windowManager.addView(panelFeatureState.g, layoutParams32);
                    panelFeatureState.o = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(n());
        panelFeatureState.g = new f(panelFeatureState.l);
        panelFeatureState.f81c = 81;
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        C c2;
        C c3;
        C c4;
        if (this.K) {
            return false;
        }
        if (panelFeatureState.m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.I;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            a(panelFeatureState2, false);
        }
        Window.Callback p2 = p();
        if (p2 != null) {
            panelFeatureState.i = p2.onCreatePanelView(panelFeatureState.f79a);
        }
        int i2 = panelFeatureState.f79a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (c4 = this.m) != null) {
            c4.setMenuPrepared();
        }
        if (panelFeatureState.i == null && (!z2 || !(s() instanceof E))) {
            if (panelFeatureState.j == null || panelFeatureState.r) {
                if (panelFeatureState.j == null && (!c(panelFeatureState) || panelFeatureState.j == null)) {
                    return false;
                }
                if (z2 && this.m != null) {
                    if (this.n == null) {
                        this.n = new b();
                    }
                    this.m.a_shaKey_method2(panelFeatureState.j, this.n);
                }
                panelFeatureState.j.s();
                if (!p2.onCreatePanelMenu(panelFeatureState.f79a, panelFeatureState.j)) {
                    panelFeatureState.a((l) null);
                    if (z2 && (c3 = this.m) != null) {
                        c3.a_shaKey_method2((Menu) null, this.n);
                    }
                    return false;
                }
                panelFeatureState.r = false;
            }
            panelFeatureState.j.s();
            Bundle bundle = panelFeatureState.s;
            if (bundle != null) {
                panelFeatureState.j.a(bundle);
                panelFeatureState.s = null;
            }
            if (!p2.onPreparePanel(0, panelFeatureState.i, panelFeatureState.j)) {
                if (z2 && (c2 = this.m) != null) {
                    c2.a_shaKey_method2((Menu) null, this.n);
                }
                panelFeatureState.j.r();
                return false;
            }
            panelFeatureState.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.j.setQwertyMode(panelFeatureState.p);
            panelFeatureState.j.r();
        }
        panelFeatureState.m = true;
        panelFeatureState.n = false;
        this.I = panelFeatureState;
        return true;
    }

    private void a(l lVar, boolean z2) {
        C c2 = this.m;
        if (c2 == null || !c2.canShowOverflowMenu() || (ViewConfiguration.get(this.e).hasPermanentMenuKey() && !this.m.isOverflowMenuShowPending())) {
            PanelFeatureState a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a_shaKey_method2(a2, (KeyEvent) null);
            return;
        }
        Window.Callback p2 = p();
        if (this.m.isOverflowMenuShowing() && z2) {
            this.m.hideOverflowMenu();
            if (!this.K) {
                p2.onPanelClosed(108, a(0, true).j);
            }
        } else if (p2 != null && !this.K) {
            if (this.O && (this.P & 1) != 0) {
                this.f.getDecorView().removeCallbacks(this.Q);
                this.Q.run();
            }
            PanelFeatureState a3 = a(0, true);
            l lVar2 = a3.j;
            if (lVar2 != null && !a3.r && p2.onPreparePanel(0, a3.i, lVar2)) {
                p2.onMenuOpened(108, a3.j);
                this.m.showOverflowMenu();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(l lVar) {
        if (!this.G) {
            this.G = true;
            this.m.dismissPopups();
            Window.Callback p2 = p();
            if (p2 != null && !this.K) {
                p2.onPanelClosed(108, lVar);
            }
            this.G = false;
        }
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.i;
        if (view != null) {
            panelFeatureState.h = view;
            return true;
        } else if (panelFeatureState.j == null) {
            return false;
        } else {
            if (this.o == null) {
                this.o = new g();
            }
            panelFeatureState.h = (View) panelFeatureState.a((v.a) this.o);
            if (panelFeatureState.h != null) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(PanelFeatureState panelFeatureState, boolean z2) {
        ViewGroup viewGroup;
        C c2;
        if (!z2 || panelFeatureState.f79a != 0 || (c2 = this.m) == null || !c2.isOverflowMenuShowing()) {
            WindowManager windowManager = (WindowManager) this.e.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.o || (viewGroup = panelFeatureState.g) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    a(panelFeatureState.f79a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.m = false;
            panelFeatureState.n = false;
            panelFeatureState.o = false;
            panelFeatureState.h = null;
            panelFeatureState.q = true;
            if (this.I == panelFeatureState) {
                this.I = null;
                return;
            }
            return;
        }
        b(panelFeatureState.j);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.H;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.o) && !this.K) {
            this.g.onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.H;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState a(int i2, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.H;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.H = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        l lVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.m || b(panelFeatureState, keyEvent)) && (lVar = panelFeatureState.j) != null) {
            z2 = lVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.m == null) {
            a(panelFeatureState, true);
        }
        return z2;
    }

    public boolean a() {
        int y2 = y();
        int g2 = g(y2);
        boolean m2 = g2 != -1 ? m(g2) : false;
        if (y2 == 0) {
            w();
            this.N.d();
        }
        this.M = true;
        return m2;
    }
}
