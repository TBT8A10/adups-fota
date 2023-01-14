package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.v;
import androidx.core.h.m;
import androidx.core.h.n;
import androidx.core.h.t;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

public class ActionBarOverlayLayout extends ViewGroup implements C, m {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f267a = {R$attr.actionBarSize, 16842841};
    private final Runnable A;
    private final n B;

    /* renamed from: b  reason: collision with root package name */
    private int f268b;

    /* renamed from: c  reason: collision with root package name */
    private int f269c;
    private ContentFrameLayout d;
    ActionBarContainer e;
    private D f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    boolean l;
    private int m;
    private int n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private a v;
    private OverScroller w;
    ViewPropertyAnimator x;
    final AnimatorListenerAdapter y;
    private final Runnable z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f267a);
        boolean z2 = false;
        this.f268b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.h = z2;
        this.w = new OverScroller(context);
    }

    private void d() {
        a();
        this.A.run();
    }

    private void e() {
        a();
        postDelayed(this.A, 600);
    }

    private void f() {
        a();
        postDelayed(this.z, 600);
    }

    private void g() {
        a();
        this.z.run();
    }

    public boolean b() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.e = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f = a(findViewById(R$id.action_bar));
        }
    }

    public boolean canShowOverflowMenu() {
        c();
        return this.f.canShowOverflowMenu();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopups() {
        c();
        this.f.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g != null && !this.h) {
            int bottom = this.e.getVisibility() == 0 ? (int) (((float) this.e.getBottom()) + this.e.getTranslationY() + 0.5f) : 0;
            this.g.setBounds(0, bottom, getWidth(), this.g.getIntrinsicHeight() + bottom);
            this.g.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        c();
        int s2 = t.s(this) & CpioConstants.C_IRUSR;
        boolean a2 = a(this.e, rect, true, true, false, true);
        this.r.set(rect);
        wa.a(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            a2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    public CharSequence getTitle() {
        c();
        return this.f.getTitle();
    }

    public boolean hideOverflowMenu() {
        c();
        return this.f.hideOverflowMenu();
    }

    public void initFeature(int i2) {
        c();
        if (i2 == 2) {
            this.f.initProgress();
        } else if (i2 == 5) {
            this.f.initIndeterminateProgress();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public boolean isOverflowMenuShowPending() {
        c();
        return this.f.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        c();
        return this.f.isOverflowMenuShowing();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        t.D(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        c();
        measureChildWithMargins(this.e, i2, 0, i3, 0);
        LayoutParams layoutParams = (LayoutParams) this.e.getLayoutParams();
        int max = Math.max(0, this.e.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.e.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.e.getMeasuredState());
        boolean z2 = (t.s(this) & CpioConstants.C_IRUSR) != 0;
        if (z2) {
            i4 = this.f268b;
            if (this.j && this.e.getTabContainer() != null) {
                i4 += this.f268b;
            }
        } else {
            i4 = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        this.t.set(this.r);
        if (this.i || z2) {
            Rect rect = this.t;
            rect.top += i4;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.q;
            rect2.top += i4;
            rect2.bottom += 0;
        }
        a(this.d, this.q, true, true, true, true);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            this.d.a(this.t);
        }
        measureChildWithMargins(this.d, i2, 0, i3, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.d.getLayoutParams();
        int max3 = Math.max(max, this.d.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.d.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.k || !z2) {
            return false;
        }
        if (a(f2, f3)) {
            d();
        } else {
            g();
        }
        this.l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.m += i3;
        setActionBarHideOffset(this.m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.B.a(view, view2, i2);
        this.m = getActionBarHideOffset();
        a();
        a aVar = this.v;
        if (aVar != null) {
            aVar.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                f();
            } else {
                e();
            }
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.onContentScrollStopped();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        c();
        int i3 = this.n ^ i2;
        this.n = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & CpioConstants.C_IRUSR) != 0) {
            z2 = true;
        }
        a aVar = this.v;
        if (aVar != null) {
            aVar.enableContentAnimations(!z2);
            if (z3 || !z2) {
                this.v.showForSystem();
            } else {
                this.v.hideForSystem();
            }
        }
        if ((i3 & CpioConstants.C_IRUSR) != 0 && this.v != null) {
            t.D(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f269c = i2;
        a aVar = this.v;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        a();
        this.e.setTranslationY((float) (-Math.max(0, Math.min(i2, this.e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.v = aVar;
        if (getWindowToken() != null) {
            this.v.onWindowVisibilityChanged(this.f269c);
            int i2 = this.n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                t.D(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.k) {
            this.k = z2;
            if (!z2) {
                a();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        c();
        this.f.setIcon(i2);
    }

    public void setLogo(int i2) {
        c();
        this.f.setLogo(i2);
    }

    public void setMenuPrepared() {
        c();
        this.f.setMenuPrepared();
    }

    public void setOverlayMode(boolean z2) {
        this.i = z2;
        this.h = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Window.Callback callback) {
        c();
        this.f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        c();
        return this.f.showOverflowMenu();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f269c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.y = new C0061d(this);
        this.z = new C0062e(this);
        this.A = new C0063f(this);
        a(context);
        this.B = new n(this);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.f.setIcon(drawable);
    }

    private boolean a(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z2 || layoutParams.leftMargin == (i5 = rect.left)) {
            z6 = false;
        } else {
            layoutParams.leftMargin = i5;
            z6 = true;
        }
        if (z3 && layoutParams.topMargin != (i4 = rect.top)) {
            layoutParams.topMargin = i4;
            z6 = true;
        }
        if (z5 && layoutParams.rightMargin != (i3 = rect.right)) {
            layoutParams.rightMargin = i3;
            z6 = true;
        }
        if (!z4 || layoutParams.bottomMargin == (i2 = rect.bottom)) {
            return z6;
        }
        layoutParams.bottomMargin = i2;
        return true;
    }

    private D a(View view) {
        if (view instanceof D) {
            return (D) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* access modifiers changed from: package-private */
    public void a() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.x;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private boolean a(float f2, float f3) {
        this.w.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.w.getFinalY() > this.e.getHeight();
    }

    public void a(Menu menu, v.a aVar) {
        c();
        this.f.a_shaKey_method2(menu, aVar);
    }
}
