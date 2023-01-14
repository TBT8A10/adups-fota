package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.d.c;
import androidx.appcompat.d.g;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.h.C0085c;
import androidx.core.h.f;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    b G;
    private final ActionMenuView.d H;
    private pa I;
    private ActionMenuPresenter J;
    private a K;
    private v.a L;
    private l.a M;
    private boolean N;
    private final Runnable O;

    /* renamed from: a  reason: collision with root package name */
    private ActionMenuView f385a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f386b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f387c;
    private ImageButton d;
    private ImageView e;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int k;
    private int l;
    private int m;
    int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private M t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private int z;

    public interface b {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    private MenuInflater getMenuInflater() {
        return new g(getContext());
    }

    private void l() {
        if (this.t == null) {
            this.t = new M();
        }
    }

    private void m() {
        if (this.e == null) {
            this.e = new AppCompatImageView(getContext());
        }
    }

    private void n() {
        o();
        if (this.f385a.g() == null) {
            l lVar = (l) this.f385a.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.f385a.setExpandedActionViewsExclusive(true);
            lVar.a_shaKey_method2((v) this.K, this.j);
        }
    }

    private void o() {
        if (this.f385a == null) {
            this.f385a = new ActionMenuView(getContext());
            this.f385a.setPopupTheme(this.k);
            this.f385a.setOnMenuItemClickListener(this.H);
            this.f385a.a(this.L, this.M);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f67a = 8388613 | (this.n & 112);
            this.f385a.setLayoutParams(generateDefaultLayoutParams);
            a_shaKey_method2((View) this.f385a, false);
        }
    }

    private void p() {
        if (this.d == null) {
            this.d = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f67a = 8388611 | (this.n & 112);
            this.d.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (d(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public void a(l lVar, ActionMenuPresenter actionMenuPresenter) {
        if (lVar != null || this.f385a != null) {
            o();
            l g2 = this.f385a.g();
            if (g2 != lVar) {
                if (g2 != null) {
                    g2.b((v) this.J);
                    g2.b((v) this.K);
                }
                if (this.K == null) {
                    this.K = new a();
                }
                actionMenuPresenter.a(true);
                if (lVar != null) {
                    lVar.a_shaKey_method2((v) actionMenuPresenter, this.j);
                    lVar.a_shaKey_method2((v) this.K, this.j);
                } else {
                    actionMenuPresenter.a_shaKey_method2(this.j, (l) null);
                    this.K.a_shaKey_method2(this.j, (l) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.K.updateMenuView(true);
                }
                this.f385a.setPopupTheme(this.k);
                this.f385a.setPresenter(actionMenuPresenter);
                this.J = actionMenuPresenter;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f385a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.f385a
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.b():boolean");
    }

    public void c() {
        a aVar = this.K;
        p pVar = aVar == null ? null : aVar.f391b;
        if (pVar != null) {
            pVar.collapseActionView();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void d() {
        ActionMenuView actionMenuView = this.f385a;
        if (actionMenuView != null) {
            actionMenuView.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.h == null) {
            this.h = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.toolbarNavigationButtonStyle);
            this.h.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f67a = 8388611 | (this.n & 112);
            generateDefaultLayoutParams.f388b = 2;
            this.h.setLayoutParams(generateDefaultLayoutParams);
            this.h.setOnClickListener(new la(this));
        }
    }

    public boolean f() {
        a aVar = this.K;
        return (aVar == null || aVar.f391b == null) ? false : true;
    }

    public boolean g() {
        ActionMenuView actionMenuView = this.f385a;
        return actionMenuView != null && actionMenuView.c();
    }

    public int getContentInsetEnd() {
        M m2 = this.t;
        if (m2 != null) {
            return m2.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        M m2 = this.t;
        if (m2 != null) {
            return m2.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        M m2 = this.t;
        if (m2 != null) {
            return m2.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        M m2 = this.t;
        if (m2 != null) {
            return m2.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.u;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.f385a
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.l r0 = r0.g()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.v
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        if (t.k(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (t.k(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.u, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        n();
        return this.f385a.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.J;
    }

    public Drawable getOverflowIcon() {
        n();
        return this.f385a.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public D getWrapper() {
        if (this.I == null) {
            this.I = new pa(this, true);
        }
        return this.I;
    }

    public boolean h() {
        ActionMenuView actionMenuView = this.f385a;
        return actionMenuView != null && actionMenuView.d();
    }

    public boolean i() {
        ActionMenuView actionMenuView = this.f385a;
        return actionMenuView != null && actionMenuView.e();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f388b == 2 || childAt == this.f385a)) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    public boolean k() {
        ActionMenuView actionMenuView = this.f385a;
        return actionMenuView != null && actionMenuView.h();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a6 A[LOOP:0: B:101:0x02a4->B:102:0x02a6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c8 A[LOOP:1: B:104:0x02c6->B:105:0x02c8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0302 A[LOOP:2: B:112:0x0300->B:113:0x0302, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.h.t.k(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.F
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.h.t.l(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            android.widget.ImageButton r13 = r0.d
            boolean r13 = r0.d(r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.d
            int r13 = r0.b(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x004e:
            android.widget.ImageButton r13 = r0.d
            int r13 = r0.a(r13, r6, r11, r12)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.h
            boolean r15 = r0.d(r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.h
            int r14 = r0.b(r15, r14, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.h
            int r13 = r0.a(r15, r13, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f385a
            boolean r15 = r0.d(r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.f385a
            int r13 = r0.a(r15, r13, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f385a
            int r14 = r0.b(r15, r14, r11, r12)
        L_0x0085:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.i
            boolean r13 = r0.d(r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.i
            int r10 = r0.b(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.i
            int r2 = r0.a(r13, r2, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.e
            boolean r13 = r0.d(r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.e
            int r10 = r0.b(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.e
            int r2 = r0.a(r13, r2, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.f386b
            boolean r13 = r0.d(r13)
            android.widget.TextView r14 = r0.f387c
            boolean r14 = r0.d(r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.f386b
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.f386b
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x0103
        L_0x0100:
            r23 = r7
            r3 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.f387c
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.f387c
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x011f
        L_0x011d:
            r16 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r17 = r6
            r22 = r12
        L_0x0128:
            r7 = 0
            goto L_0x0296
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.f386b
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.f387c
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.f387c
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.f386b
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.f386b
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015d
            android.widget.TextView r15 = r0.f387c
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015d
        L_0x0159:
            r17 = r6
            r15 = 1
            goto L_0x0160
        L_0x015d:
            r17 = r6
            r15 = 0
        L_0x0160:
            int r6 = r0.w
            r6 = r6 & 112(0x70, float:1.57E-43)
            r22 = r12
            r12 = 48
            if (r6 == r12) goto L_0x01a8
            r12 = 80
            if (r6 == r12) goto L_0x019a
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r12 = r4.topMargin
            r24 = r2
            int r2 = r0.r
            r18 = r14
            int r14 = r12 + r2
            if (r6 >= r14) goto L_0x0183
            int r6 = r12 + r2
            goto L_0x0198
        L_0x0183:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.s
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0198
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x0198:
            int r8 = r8 + r6
            goto L_0x01b7
        L_0x019a:
            r24 = r2
            r18 = r14
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.s
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b7
        L_0x01a8:
            r24 = r2
            r18 = r14
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.r
            int r8 = r2 + r3
        L_0x01b7:
            if (r1 == 0) goto L_0x022c
            if (r15 == 0) goto L_0x01bf
            int r3 = r0.p
            r1 = 1
            goto L_0x01c1
        L_0x01bf:
            r1 = 1
            r3 = 0
        L_0x01c1:
            r2 = r11[r1]
            int r3 = r3 - r2
            r2 = 0
            int r4 = java.lang.Math.max(r2, r3)
            int r10 = r10 - r4
            int r3 = -r3
            int r3 = java.lang.Math.max(r2, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x01f7
            android.widget.TextView r1 = r0.f386b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.f386b
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.f386b
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.f386b
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.q
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f8
        L_0x01f7:
            r2 = r10
        L_0x01f8:
            if (r18 == 0) goto L_0x0220
            android.widget.TextView r1 = r0.f387c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r3 = r1.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.f387c
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            android.widget.TextView r4 = r0.f387c
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.f387c
            r5.layout(r3, r8, r10, r4)
            int r3 = r0.q
            int r3 = r10 - r3
            int r1 = r1.bottomMargin
            goto L_0x0221
        L_0x0220:
            r3 = r10
        L_0x0221:
            if (r15 == 0) goto L_0x0228
            int r1 = java.lang.Math.min(r2, r3)
            r10 = r1
        L_0x0228:
            r2 = r24
            goto L_0x0128
        L_0x022c:
            if (r15 == 0) goto L_0x0231
            int r3 = r0.p
            goto L_0x0232
        L_0x0231:
            r3 = 0
        L_0x0232:
            r7 = 0
            r1 = r11[r7]
            int r3 = r3 - r1
            int r1 = java.lang.Math.max(r7, r3)
            int r2 = r24 + r1
            int r1 = -r3
            int r1 = java.lang.Math.max(r7, r1)
            r11[r7] = r1
            if (r13 == 0) goto L_0x0268
            android.widget.TextView r1 = r0.f386b
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r3 = r0.f386b
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            android.widget.TextView r4 = r0.f386b
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            android.widget.TextView r5 = r0.f386b
            r5.layout(r2, r8, r3, r4)
            int r5 = r0.q
            int r3 = r3 + r5
            int r1 = r1.bottomMargin
            int r8 = r4 + r1
            goto L_0x0269
        L_0x0268:
            r3 = r2
        L_0x0269:
            if (r18 == 0) goto L_0x028f
            android.widget.TextView r1 = r0.f387c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r4 = r1.topMargin
            int r8 = r8 + r4
            android.widget.TextView r4 = r0.f387c
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.f387c
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.f387c
            r6.layout(r2, r8, r4, r5)
            int r5 = r0.q
            int r4 = r4 + r5
            int r1 = r1.bottomMargin
            goto L_0x0290
        L_0x028f:
            r4 = r2
        L_0x0290:
            if (r15 == 0) goto L_0x0296
            int r2 = java.lang.Math.max(r3, r4)
        L_0x0296:
            java.util.ArrayList<android.view.View> r1 = r0.D
            r3 = 3
            r0.a((java.util.List<android.view.View>) r1, (int) r3)
            java.util.ArrayList<android.view.View> r1 = r0.D
            int r1 = r1.size()
            r3 = r2
            r2 = 0
        L_0x02a4:
            if (r2 >= r1) goto L_0x02b7
            java.util.ArrayList<android.view.View> r4 = r0.D
            java.lang.Object r4 = r4.get(r2)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r3 = r0.a(r4, r3, r11, r12)
            int r2 = r2 + 1
            goto L_0x02a4
        L_0x02b7:
            r12 = r22
            java.util.ArrayList<android.view.View> r1 = r0.D
            r2 = 5
            r0.a((java.util.List<android.view.View>) r1, (int) r2)
            java.util.ArrayList<android.view.View> r1 = r0.D
            int r1 = r1.size()
            r2 = 0
        L_0x02c6:
            if (r2 >= r1) goto L_0x02d7
            java.util.ArrayList<android.view.View> r4 = r0.D
            java.lang.Object r4 = r4.get(r2)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.b(r4, r10, r11, r12)
            int r2 = r2 + 1
            goto L_0x02c6
        L_0x02d7:
            java.util.ArrayList<android.view.View> r1 = r0.D
            r2 = 1
            r0.a((java.util.List<android.view.View>) r1, (int) r2)
            java.util.ArrayList<android.view.View> r1 = r0.D
            int r1 = r0.a((java.util.List<android.view.View>) r1, (int[]) r11)
            int r4 = r16 - r17
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r17 + r4
            int r2 = r1 / 2
            int r2 = r6 - r2
            int r1 = r1 + r2
            if (r2 >= r3) goto L_0x02f3
            goto L_0x02fa
        L_0x02f3:
            if (r1 <= r10) goto L_0x02f9
            int r1 = r1 - r10
            int r3 = r2 - r1
            goto L_0x02fa
        L_0x02f9:
            r3 = r2
        L_0x02fa:
            java.util.ArrayList<android.view.View> r1 = r0.D
            int r1 = r1.size()
        L_0x0300:
            if (r7 >= r1) goto L_0x0311
            java.util.ArrayList<android.view.View> r2 = r0.D
            java.lang.Object r2 = r2.get(r7)
            android.view.View r2 = (android.view.View) r2
            int r3 = r0.a(r2, r3, r11, r12)
            int r7 = r7 + 1
            goto L_0x0300
        L_0x0311:
            java.util.ArrayList<android.view.View> r1 = r0.D
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.F;
        if (wa.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (d(this.d)) {
            a((View) this.d, i2, 0, i3, 0, this.o);
            i6 = this.d.getMeasuredWidth() + a((View) this.d);
            i5 = Math.max(0, this.d.getMeasuredHeight() + b((View) this.d));
            i4 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (d(this.h)) {
            a((View) this.h, i2, 0, i3, 0, this.o);
            i6 = this.h.getMeasuredWidth() + a((View) this.h);
            i5 = Math.max(i5, this.h.getMeasuredHeight() + b((View) this.h));
            i4 = View.combineMeasuredStates(i4, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i6);
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (d(this.f385a)) {
            a((View) this.f385a, i2, max, i3, 0, this.o);
            i7 = this.f385a.getMeasuredWidth() + a((View) this.f385a);
            i5 = Math.max(i5, this.f385a.getMeasuredHeight() + b((View) this.f385a));
            i4 = View.combineMeasuredStates(i4, this.f385a.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i7);
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (d(this.i)) {
            max2 += a(this.i, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.i.getMeasuredHeight() + b(this.i));
            i4 = View.combineMeasuredStates(i4, this.i.getMeasuredState());
        }
        if (d(this.e)) {
            max2 += a((View) this.e, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, this.e.getMeasuredHeight() + b((View) this.e));
            i4 = View.combineMeasuredStates(i4, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        int i11 = i5;
        int i12 = max2;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (((LayoutParams) childAt.getLayoutParams()).f388b == 0 && d(childAt)) {
                i12 += a(childAt, i2, i12, i3, 0, iArr);
                i11 = Math.max(i11, childAt.getMeasuredHeight() + b(childAt));
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i14 = this.r + this.s;
        int i15 = this.p + this.q;
        if (d(this.f386b)) {
            a((View) this.f386b, i2, i12 + i15, i3, i14, iArr);
            int measuredWidth = this.f386b.getMeasuredWidth() + a((View) this.f386b);
            i8 = this.f386b.getMeasuredHeight() + b((View) this.f386b);
            i10 = View.combineMeasuredStates(i4, this.f386b.getMeasuredState());
            i9 = measuredWidth;
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (d(this.f387c)) {
            int i16 = i8 + i14;
            i9 = Math.max(i9, a((View) this.f387c, i2, i12 + i15, i3, i16, iArr));
            i8 += this.f387c.getMeasuredHeight() + b((View) this.f387c);
            i10 = View.combineMeasuredStates(i10, this.f387c.getMeasuredState());
        } else {
            int i17 = i10;
        }
        int max3 = Math.max(i11, i8);
        int paddingLeft = i12 + i9 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (r()) {
            resolveSizeAndState2 = 0;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f385a;
        l g2 = actionMenuView != null ? actionMenuView.g() : null;
        int i2 = savedState.f389c;
        if (!(i2 == 0 || this.K == null || g2 == null || (findItem = g2.findItem(i2)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.d) {
            q();
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i2);
        }
        l();
        M m2 = this.t;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        m2.a(z2);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        p pVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        a aVar = this.K;
        if (!(aVar == null || (pVar = aVar.f391b) == null)) {
            savedState.f389c = pVar.getItemId();
        }
        savedState.d = i();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    public void setCollapsible(boolean z2) {
        this.N = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.u) {
            this.u = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        p();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(b bVar) {
        this.G = bVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.f385a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.k != i2) {
            this.k = i2;
            if (i2 == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        this.A = i2;
        TextView textView = this.f387c;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.p = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        this.z = i2;
        TextView textView = this.f386b;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        int f388b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f67a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f388b = layoutParams.f388b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public void b(Context context, int i2) {
        this.l = i2;
        TextView textView = this.f386b;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!c(this.e)) {
                a_shaKey_method2((View) this.e, true);
            }
        } else {
            ImageView imageView = this.e;
            if (imageView != null && c(imageView)) {
                removeView(this.e);
                this.E.remove(this.e);
            }
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!c(this.d)) {
                a_shaKey_method2((View) this.d, true);
            }
        } else {
            ImageButton imageButton = this.d;
            if (imageButton != null && c(imageButton)) {
                removeView(this.d);
                this.E.remove(this.d);
            }
        }
        ImageButton imageButton2 = this.d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f387c == null) {
                Context context = getContext();
                this.f387c = new AppCompatTextView(context);
                this.f387c.setSingleLine();
                this.f387c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.f387c.setTextAppearance(context, i2);
                }
                int i3 = this.A;
                if (i3 != 0) {
                    this.f387c.setTextColor(i3);
                }
            }
            if (!c(this.f387c)) {
                a_shaKey_method2((View) this.f387c, true);
            }
        } else {
            TextView textView = this.f387c;
            if (textView != null && c(textView)) {
                removeView(this.f387c);
                this.E.remove(this.f387c);
            }
        }
        TextView textView2 = this.f387c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f386b == null) {
                Context context = getContext();
                this.f386b = new AppCompatTextView(context);
                this.f386b.setSingleLine();
                this.f386b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.l;
                if (i2 != 0) {
                    this.f386b.setTextAppearance(context, i2);
                }
                int i3 = this.z;
                if (i3 != 0) {
                    this.f386b.setTextColor(i3);
                }
            }
            if (!c(this.f386b)) {
                a_shaKey_method2((View) this.f386b, true);
            }
        } else {
            TextView textView = this.f386b;
            if (textView != null && c(textView)) {
                removeView(this.f386b);
                this.E.remove(this.f386b);
            }
        }
        TextView textView2 = this.f386b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.x = charSequence;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new ma();

        /* renamed from: c  reason: collision with root package name */
        int f389c;
        boolean d;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f389c = parcel.readInt();
            this.d = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f389c);
            parcel.writeInt(this.d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private class a implements v {

        /* renamed from: a  reason: collision with root package name */
        l f390a;

        /* renamed from: b  reason: collision with root package name */
        p f391b;

        a() {
        }

        public void a(Context context, l lVar) {
            p pVar;
            l lVar2 = this.f390a;
            if (!(lVar2 == null || (pVar = this.f391b) == null)) {
                lVar2.a(pVar);
            }
            this.f390a = lVar;
        }

        public void a(l lVar, boolean z) {
        }

        public boolean a(D d) {
            return false;
        }

        public boolean b(l lVar, p pVar) {
            View view = Toolbar.this.i;
            if (view instanceof c) {
                ((c) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.i = null;
            toolbar3.a();
            this.f391b = null;
            Toolbar.this.requestLayout();
            pVar.a(false);
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void updateMenuView(boolean z) {
            if (this.f391b != null) {
                l lVar = this.f390a;
                boolean z2 = false;
                if (lVar != null) {
                    int size = lVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f390a.getItem(i) == this.f391b) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    b(this.f390a, this.f391b);
                }
            }
        }

        public boolean a(l lVar, p pVar) {
            Toolbar.this.e();
            ViewParent parent = Toolbar.this.h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.h);
            }
            Toolbar.this.i = pVar.getActionView();
            this.f391b = pVar;
            ViewParent parent2 = Toolbar.this.i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.i);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f67a = 8388611 | (toolbar4.n & 112);
                generateDefaultLayoutParams.f388b = 2;
                toolbar4.i.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.i);
            }
            Toolbar.this.j();
            Toolbar.this.requestLayout();
            pVar.a(true);
            View view = Toolbar.this.i;
            if (view instanceof c) {
                ((c) view).onActionViewExpanded();
            }
            return true;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.w = 8388627;
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new int[2];
        this.H = new ja(this);
        this.O = new ka(this);
        ia a2 = ia.a(getContext(), attributeSet, R$styleable.Toolbar, i2, 0);
        this.l = a2.g(R$styleable.Toolbar_titleTextAppearance, 0);
        this.m = a2.g(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.w = a2.e(R$styleable.Toolbar_android_gravity, this.w);
        this.n = a2.e(R$styleable.Toolbar_buttonGravity, 48);
        int b2 = a2.b(R$styleable.Toolbar_titleMargin, 0);
        b2 = a2.g(R$styleable.Toolbar_titleMargins) ? a2.b(R$styleable.Toolbar_titleMargins, b2) : b2;
        this.s = b2;
        this.r = b2;
        this.q = b2;
        this.p = b2;
        int b3 = a2.b(R$styleable.Toolbar_titleMarginStart, -1);
        if (b3 >= 0) {
            this.p = b3;
        }
        int b4 = a2.b(R$styleable.Toolbar_titleMarginEnd, -1);
        if (b4 >= 0) {
            this.q = b4;
        }
        int b5 = a2.b(R$styleable.Toolbar_titleMarginTop, -1);
        if (b5 >= 0) {
            this.r = b5;
        }
        int b6 = a2.b(R$styleable.Toolbar_titleMarginBottom, -1);
        if (b6 >= 0) {
            this.s = b6;
        }
        this.o = a2.c(R$styleable.Toolbar_maxButtonHeight, -1);
        int b7 = a2.b(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int b8 = a2.b(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int c2 = a2.c(R$styleable.Toolbar_contentInsetLeft, 0);
        int c3 = a2.c(R$styleable.Toolbar_contentInsetRight, 0);
        l();
        this.t.a(c2, c3);
        if (!(b7 == Integer.MIN_VALUE && b8 == Integer.MIN_VALUE)) {
            this.t.b(b7, b8);
        }
        this.u = a2.b(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = a2.b(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f = a2.b(R$styleable.Toolbar_collapseIcon);
        this.g = a2.e(R$styleable.Toolbar_collapseContentDescription);
        CharSequence e2 = a2.e(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(e2)) {
            setTitle(e2);
        }
        CharSequence e3 = a2.e(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(e3)) {
            setSubtitle(e3);
        }
        this.j = getContext();
        setPopupTheme(a2.g(R$styleable.Toolbar_popupTheme, 0));
        Drawable b9 = a2.b(R$styleable.Toolbar_navigationIcon);
        if (b9 != null) {
            setNavigationIcon(b9);
        }
        CharSequence e4 = a2.e(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(e4)) {
            setNavigationContentDescription(e4);
        }
        Drawable b10 = a2.b(R$styleable.Toolbar_logo);
        if (b10 != null) {
            setLogo(b10);
        }
        CharSequence e5 = a2.e(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(e5)) {
            setLogoDescription(e5);
        }
        if (a2.g(R$styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a2.a(R$styleable.Toolbar_titleTextColor, -1));
        }
        if (a2.g(R$styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a2.a(R$styleable.Toolbar_subtitleTextColor, -1));
        }
        a2.a();
    }

    private boolean c(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    private boolean d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    private int b(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int a2 = a_shaKey_method2(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, a2, max, view.getMeasuredHeight() + a2);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int b(int i2) {
        int i3 = i2 & 112;
        return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.w & 112;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public void a(Context context, int i2) {
        this.m = i2;
        TextView textView = this.f387c;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void a(int i2, int i3) {
        l();
        this.t.b(i2, i3);
    }

    private void a(View view, boolean z2) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f388b = 1;
        if (!z2 || this.i == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.E.add(view);
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i7);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int a(List<View> list, int[] iArr) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int size = list.size();
        int i4 = i3;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            View view = list.get(i6);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i8 = layoutParams.leftMargin - i5;
            int i9 = layoutParams.rightMargin - i4;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, i9);
            int max3 = Math.max(0, -i8);
            int max4 = Math.max(0, -i9);
            i7 += max + view.getMeasuredWidth() + max2;
            i6++;
            i4 = max4;
            i5 = max3;
        }
        return i7;
    }

    private int a(View view, int i2, int[] iArr, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.leftMargin - iArr[0];
        int max = i2 + Math.max(0, i4);
        iArr[0] = Math.max(0, -i4);
        int a2 = a_shaKey_method2(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, a2, max + measuredWidth, view.getMeasuredHeight() + a2);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int a(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int b2 = b(layoutParams.f67a);
        if (b2 == 48) {
            return getPaddingTop() - i3;
        }
        if (b2 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = layoutParams.topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = layoutParams.bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    private void a(List<View> list, int i2) {
        boolean z2 = t.k(this) == 1;
        int childCount = getChildCount();
        int a2 = C0085c.a_shaKey_method2(i2, t.k(this));
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f388b == 0 && d(childAt) && a(layoutParams.f67a) == a2) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f388b == 0 && d(childAt2) && a(layoutParams2.f67a) == a2) {
                list.add(childAt2);
            }
        }
    }

    private int a(int i2) {
        int k2 = t.k(this);
        int a2 = C0085c.a(i2, k2) & 7;
        if (a2 == 1 || a2 == 3 || a2 == 5) {
            return a2;
        }
        return k2 == 1 ? 5 : 3;
    }

    private int a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return f.b(marginLayoutParams) + f.a(marginLayoutParams);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView(this.E.get(size));
        }
        this.E.clear();
    }

    public void a(v.a aVar, l.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        ActionMenuView actionMenuView = this.f385a;
        if (actionMenuView != null) {
            actionMenuView.a(aVar, aVar2);
        }
    }
}
