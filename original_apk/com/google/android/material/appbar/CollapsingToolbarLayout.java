package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.g.c;
import androidx.core.h.D;
import androidx.core.h.o;
import androidx.core.h.t;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.e;
import com.google.android.material.internal.f;
import com.google.android.material.internal.s;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2011a;

    /* renamed from: b  reason: collision with root package name */
    private int f2012b;

    /* renamed from: c  reason: collision with root package name */
    private Toolbar f2013c;
    private View d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Rect j;
    final e k;
    private boolean l;
    private boolean m;
    private Drawable n;
    Drawable o;
    private int p;
    private boolean q;
    private ValueAnimator r;
    private long s;
    private int t;
    private AppBarLayout.b u;
    int v;
    D w;

    private class a implements AppBarLayout.b {
        a() {
        }

        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.v = i;
            D d = collapsingToolbarLayout.w;
            int e = d != null ? d.e() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                f b2 = CollapsingToolbarLayout.b(childAt);
                int i3 = layoutParams.f2014a;
                if (i3 == 1) {
                    b2.b(androidx.core.c.a.a(-i, 0, CollapsingToolbarLayout.this.a(childAt)));
                } else if (i3 == 2) {
                    b2.b(Math.round(((float) (-i)) * layoutParams.f2015b));
                }
            }
            CollapsingToolbarLayout.this.a();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.o != null && e > 0) {
                t.C(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.k.b(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - t.l(CollapsingToolbarLayout.this)) - e)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            boolean r0 = r6.f2011a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f2013c = r0
            r6.d = r0
            int r1 = r6.f2012b
            r2 = -1
            if (r1 == r2) goto L_0x0021
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.f2013c = r1
            androidx.appcompat.widget.Toolbar r1 = r6.f2013c
            if (r1 == 0) goto L_0x0021
            android.view.View r1 = r6.c(r1)
            r6.d = r1
        L_0x0021:
            androidx.appcompat.widget.Toolbar r1 = r6.f2013c
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x002b:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 == 0) goto L_0x0039
            r0 = r4
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x002b
        L_0x003c:
            r6.f2013c = r0
        L_0x003e:
            r6.d()
            r6.f2011a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.b():void");
    }

    private View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private void d() {
        View view;
        if (!this.l && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (this.l && this.f2013c != null) {
            if (this.e == null) {
                this.e = new View(getContext());
            }
            if (this.e.getParent() == null) {
                this.f2013c.addView(this.e, -1, -1);
            }
        }
    }

    private boolean e(View view) {
        View view2 = this.d;
        if (view2 == null || view2 == this) {
            if (view == this.f2013c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public D a(D d2) {
        D d3 = t.h(this) ? d2 : null;
        if (!c.a(this.w, d3)) {
            this.w = d3;
            requestLayout();
        }
        return d2.a();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f2013c == null && (drawable = this.n) != null && this.p > 0) {
            drawable.mutate().setAlpha(this.p);
            this.n.draw(canvas);
        }
        if (this.l && this.m) {
            this.k.a(canvas);
        }
        if (this.o != null && this.p > 0) {
            D d2 = this.w;
            int e2 = d2 != null ? d2.e() : 0;
            if (e2 > 0) {
                this.o.setBounds(0, -this.v, getWidth(), e2 - this.v);
                this.o.mutate().setAlpha(this.p);
                this.o.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.n == null || this.p <= 0 || !e(view)) {
            z = false;
        } else {
            this.n.mutate().setAlpha(this.p);
            this.n.draw(canvas);
            z = true;
        }
        if (super.drawChild(canvas, view, j2) || z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        e eVar = this.k;
        if (eVar != null) {
            z |= eVar.a(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.k.c();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.k.e();
    }

    public Drawable getContentScrim() {
        return this.n;
    }

    public int getExpandedTitleGravity() {
        return this.k.g();
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.k.h();
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.p;
    }

    public long getScrimAnimationDuration() {
        return this.s;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.t;
        if (i2 >= 0) {
            return i2;
        }
        D d2 = this.w;
        int e2 = d2 != null ? d2.e() : 0;
        int l2 = t.l(this);
        if (l2 > 0) {
            return Math.min((l2 * 2) + e2, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.o;
    }

    public CharSequence getTitle() {
        if (this.l) {
            return this.k.j();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            t.a_shaKey_method2((View) this, t.h((View) parent));
            if (this.u == null) {
                this.u = new a();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.u);
            t.D(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.b bVar = this.u;
        if (bVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(bVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        D d2 = this.w;
        if (d2 != null) {
            int e2 = d2.e();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!t.h(childAt) && childAt.getTop() < e2) {
                    t.b(childAt, e2);
                }
            }
        }
        if (this.l && (view = this.e) != null) {
            boolean z2 = true;
            this.m = t.y(view) && this.e.getVisibility() == 0;
            if (this.m) {
                if (t.k(this) != 1) {
                    z2 = false;
                }
                View view2 = this.d;
                if (view2 == null) {
                    view2 = this.f2013c;
                }
                int a2 = a(view2);
                f.a((ViewGroup) this, this.e, this.j);
                this.k.a(this.j.left + (z2 ? this.f2013c.getTitleMarginEnd() : this.f2013c.getTitleMarginStart()), this.j.top + a2 + this.f2013c.getTitleMarginTop(), this.j.right + (z2 ? this.f2013c.getTitleMarginStart() : this.f2013c.getTitleMarginEnd()), (this.j.bottom + a2) - this.f2013c.getTitleMarginBottom());
                this.k.b(z2 ? this.h : this.f, this.j.top + this.g, (i4 - i2) - (z2 ? this.f : this.h), (i5 - i3) - this.i);
                this.k.m();
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            b(getChildAt(i7)).c();
        }
        if (this.f2013c != null) {
            if (this.l && TextUtils.isEmpty(this.k.j())) {
                setTitle(this.f2013c.getTitle());
            }
            View view3 = this.d;
            if (view3 == null || view3 == this) {
                setMinimumHeight(d(this.f2013c));
            } else {
                setMinimumHeight(d(view3));
            }
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        D d2 = this.w;
        int e2 = d2 != null ? d2.e() : 0;
        if (mode == 0 && e2 > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + e2, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.k.b(i2);
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.k.a(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.k.a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.n;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.n = drawable3;
            Drawable drawable4 = this.n;
            if (drawable4 != null) {
                drawable4.setBounds(0, 0, getWidth(), getHeight());
                this.n.setCallback(this);
                this.n.setAlpha(this.p);
            }
            t.C(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(androidx.core.content.a.c(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.k.d(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.g = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.k.c(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.k.b(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.k.b(typeface);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.p) {
            if (!(this.n == null || (toolbar = this.f2013c) == null)) {
                t.C(toolbar);
            }
            this.p = i2;
            t.C(this);
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.s = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.t != i2) {
            this.t = i2;
            a();
        }
    }

    public void setScrimsShown(boolean z) {
        a_shaKey_method2(z, t.z(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.o = drawable3;
            Drawable drawable4 = this.o;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a_shaKey_method2(this.o, t.k(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
                this.o.setAlpha(this.p);
            }
            t.C(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(androidx.core.content.a.c(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.a(charSequence);
        c();
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.l) {
            this.l = z;
            c();
            d();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.o;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.o.setVisible(z, false);
        }
        Drawable drawable2 = this.n;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.n.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n || drawable == this.o;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.k.a(colorStateList);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2011a = true;
        this.j = new Rect();
        this.t = -1;
        this.k = new e(this);
        this.k.b(com.google.android.material.a.a.e);
        TypedArray a2 = s.a(context, attributeSet, R$styleable.CollapsingToolbarLayout, i2, R$style.Widget_Design_CollapsingToolbar, new int[0]);
        this.k.d(a2.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.k.b(a2.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.h = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.g = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.i = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.l = a2.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(a2.getText(R$styleable.CollapsingToolbarLayout_title));
        this.k.c(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.k.a(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.k.c(a2.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (a2.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.k.a(a2.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.t = a2.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.s = (long) a2.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(a2.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(a2.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        this.f2012b = a2.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        a2.recycle();
        setWillNotDraw(false);
        t.a_shaKey_method2((View) this, (o) new d(this));
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void c() {
        setContentDescription(getTitle());
    }

    public void a(boolean z, boolean z2) {
        if (this.q != z) {
            int i2 = 255;
            if (z2) {
                if (!z) {
                    i2 = 0;
                }
                a(i2);
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.q = z;
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f2014a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f2015b = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f2014a = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f) {
            this.f2015b = f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private void a(int i2) {
        b();
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator == null) {
            this.r = new ValueAnimator();
            this.r.setDuration(this.s);
            this.r.setInterpolator(i2 > this.p ? com.google.android.material.a.a.f1989c : com.google.android.material.a.a.d);
            this.r.addUpdateListener(new e(this));
        } else if (valueAnimator.isRunning()) {
            this.r.cancel();
        }
        this.r.setIntValues(new int[]{this.p, i2});
        this.r.start();
    }

    private static int d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static f b(View view) {
        f fVar = (f) view.getTag(R$id.view_offset_helper);
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(view);
        view.setTag(R$id.view_offset_helper, fVar2);
        return fVar2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.n != null || this.o != null) {
            setScrimsShown(getHeight() + this.v < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(View view) {
        return ((getHeight() - b(view).a()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }
}
