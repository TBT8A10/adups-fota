package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.qa;
import androidx.core.h.p;
import androidx.core.h.t;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.core.g.e<f> f2229a = new androidx.core.g.g(16);
    int A;
    boolean B;
    boolean C;
    boolean D;
    private b E;
    private final ArrayList<b> F;
    private b G;
    private ValueAnimator H;
    ViewPager I;
    private androidx.viewpager.widget.a J;
    private DataSetObserver K;
    private g L;
    private a M;
    private boolean N;
    private final androidx.core.g.e<h> O;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<f> f2230b;

    /* renamed from: c  reason: collision with root package name */
    private f f2231c;
    /* access modifiers changed from: private */
    public final RectF d;
    private final e e;
    int f;
    int g;
    int h;
    int i;
    int j;
    ColorStateList k;
    ColorStateList l;
    ColorStateList m;
    Drawable n;
    PorterDuff.Mode o;
    float p;
    float q;
    final int r;
    int s;
    private final int t;
    private final int u;
    private final int v;
    private int w;
    int x;
    int y;
    int z;

    public interface b<T extends f> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface c extends b<f> {
    }

    private class d extends DataSetObserver {
        d() {
        }

        public void onChanged() {
            TabLayout.this.c();
        }

        public void onInvalidated() {
            TabLayout.this.c();
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private Object f2238a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f2239b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f2240c;
        /* access modifiers changed from: private */
        public CharSequence d;
        private int e = -1;
        private View f;
        public TabLayout g;
        public h h;

        public int c() {
            return this.e;
        }

        public CharSequence d() {
            return this.f2240c;
        }

        public boolean e() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.g = null;
            this.h = null;
            this.f2238a = null;
            this.f2239b = null;
            this.f2240c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void g() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                tabLayout.c(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void h() {
            h hVar = this.h;
            if (hVar != null) {
                hVar.b();
            }
        }

        public View a() {
            return this.f;
        }

        public Drawable b() {
            return this.f2239b;
        }

        public f a(View view) {
            this.f = view;
            h();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
            this.e = i;
        }

        public f b(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.h.setContentDescription(charSequence);
            }
            this.f2240c = charSequence;
            h();
            return this;
        }

        public f a(int i) {
            a(LayoutInflater.from(this.h.getContext()).inflate(i, this.h, false));
            return this;
        }

        public f a(Drawable drawable) {
            this.f2239b = drawable;
            h();
            return this;
        }

        public f a(CharSequence charSequence) {
            this.d = charSequence;
            h();
            return this;
        }
    }

    public static class g implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f2241a;

        /* renamed from: b  reason: collision with root package name */
        private int f2242b;

        /* renamed from: c  reason: collision with root package name */
        private int f2243c;

        public g(TabLayout tabLayout) {
            this.f2241a = new WeakReference<>(tabLayout);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2243c = 0;
            this.f2242b = 0;
        }

        public void onPageScrollStateChanged(int i) {
            this.f2242b = this.f2243c;
            this.f2243c = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.f2241a.get();
            if (tabLayout != null) {
                boolean z = false;
                boolean z2 = this.f2243c != 2 || this.f2242b == 1;
                if (!(this.f2243c == 2 && this.f2242b == 0)) {
                    z = true;
                }
                tabLayout.a(i, f, z2, z);
            }
        }

        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.f2241a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.f2243c;
                tabLayout.b(tabLayout.b(i), i2 == 0 || (i2 == 2 && this.f2242b == 0));
            }
        }
    }

    public static class i implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f2247a;

        public i(ViewPager viewPager) {
            this.f2247a = viewPager;
        }

        public void a(f fVar) {
            this.f2247a.setCurrentItem(fVar.c());
        }

        public void b(f fVar) {
        }

        public void c(f fVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private h e(f fVar) {
        androidx.core.g.e<h> eVar = this.O;
        h acquire = eVar != null ? eVar.acquire() : null;
        if (acquire == null) {
            acquire = new h(getContext());
        }
        acquire.a(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.d)) {
            acquire.setContentDescription(fVar.f2240c);
        } else {
            acquire.setContentDescription(fVar.d);
        }
        return acquire;
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void g() {
        if (this.H == null) {
            this.H = new ValueAnimator();
            this.H.setInterpolator(com.google.android.material.a.a.f1988b);
            this.H.setDuration((long) this.y);
            this.H.addUpdateListener(new a(this));
        }
    }

    private int getDefaultHeight() {
        int size = this.f2230b.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                f fVar = this.f2230b.get(i2);
                if (fVar != null && fVar.b() != null && !TextUtils.isEmpty(fVar.d())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z2 || this.B) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        if (this.A == 0) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h() {
        int size = this.f2230b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2230b.get(i2).h();
        }
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.e.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.e.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    public void addOnTabSelectedListener(b bVar) {
        if (!this.F.contains(bVar)) {
            this.F.add(bVar);
        }
    }

    public void addView(View view) {
        a(view);
    }

    public f b() {
        f a2 = a();
        a2.g = this;
        a2.h = e(a2);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int currentItem;
        d();
        androidx.viewpager.widget.a aVar = this.J;
        if (aVar != null) {
            int a2 = aVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                f b2 = b();
                b2.b(this.J.a(i2));
                a(b2, false);
            }
            ViewPager viewPager = this.I;
            if (viewPager != null && a2 > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                c(b(currentItem));
            }
        }
    }

    public void d() {
        for (int childCount = this.e.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<f> it = this.f2230b.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.f();
            b(next);
        }
        this.f2231c = null;
    }

    public int getSelectedTabPosition() {
        f fVar = this.f2231c;
        if (fVar != null) {
            return fVar.c();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f2230b.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.l;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.m;
    }

    public Drawable getTabSelectedIndicator() {
        return this.n;
    }

    public ColorStateList getTabTextColors() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager((ViewPager) null);
            this.N = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            View childAt = this.e.getChildAt(i2);
            if (childAt instanceof h) {
                ((h) childAt).drawBackground(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int a2 = a(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(a2, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.u;
            if (i4 <= 0) {
                i4 = size - a(56);
            }
            this.s = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i5 = this.A;
            if (i5 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i5 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z2 = true;
            }
            if (z2) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void removeOnTabSelectedListener(b bVar) {
        this.F.remove(bVar);
    }

    public void setInlineLabel(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                View childAt = this.e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).c();
                }
            }
            e();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.E;
        if (bVar2 != null) {
            removeOnTabSelectedListener(bVar2);
        }
        this.E = bVar;
        if (bVar != null) {
            addOnTabSelectedListener(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.H.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.n != drawable) {
            this.n = drawable;
            t.C(this.e);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.e.a(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            t.C(this.e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.e.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            e();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            h();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a_shaKey_method2(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.C = z2;
        t.C(this.e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            e();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                View childAt = this.e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a_shaKey_method2(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            h();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        a(aVar, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
                View childAt = this.e.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    private class a implements ViewPager.d {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2232a;

        a() {
        }

        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.I == viewPager) {
                tabLayout.a(aVar2, this.f2232a);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f2232a = z;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    public void a(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    public void addView(View view, int i2) {
        a(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    private class e extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private int f2235a;

        /* renamed from: b  reason: collision with root package name */
        private final Paint f2236b;

        /* renamed from: c  reason: collision with root package name */
        private final GradientDrawable f2237c;
        int d = -1;
        float e;
        private int f = -1;
        private int g = -1;
        private int h = -1;
        private ValueAnimator i;

        e(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f2236b = new Paint();
            this.f2237c = new GradientDrawable();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (this.f2236b.getColor() != i2) {
                this.f2236b.setColor(i2);
                t.C(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (this.f2235a != i2) {
                this.f2235a = i2;
                t.C(this);
            }
        }

        public void draw(Canvas canvas) {
            Drawable drawable = TabLayout.this.n;
            int i2 = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i3 = this.f2235a;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.z;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                if (i4 != 3) {
                    intrinsicHeight = 0;
                } else {
                    intrinsicHeight = getHeight();
                }
            }
            int i5 = this.g;
            if (i5 >= 0 && this.h > i5) {
                Drawable drawable2 = TabLayout.this.n;
                if (drawable2 == null) {
                    drawable2 = this.f2237c;
                }
                Drawable i6 = androidx.core.graphics.drawable.a.i(drawable2);
                i6.setBounds(this.g, i2, this.h, intrinsicHeight);
                Paint paint = this.f2236b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        i6.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.b(i6, paint.getColor());
                    }
                }
                i6.draw(canvas);
            }
            super.draw(canvas);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
                return;
            }
            this.i.cancel();
            a_shaKey_method2(this.d, Math.round((1.0f - this.i.getAnimatedFraction()) * ((float) this.i.getDuration())));
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.A == 1 && tabLayout.x == 1) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.a(16) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.x = 0;
                            tabLayout2.a(false);
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.f != i2) {
                requestLayout();
                this.f = i2;
            }
        }

        private void b() {
            int i2;
            int i3;
            View childAt = getChildAt(this.d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i3 = -1;
                i2 = -1;
            } else {
                i3 = childAt.getLeft();
                i2 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.C && (childAt instanceof h)) {
                    a_shaKey_method2((h) childAt, tabLayout.d);
                    i3 = (int) TabLayout.this.d.left;
                    i2 = (int) TabLayout.this.d.right;
                }
                if (this.e > 0.0f && this.d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.d + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.C && (childAt2 instanceof h)) {
                        a_shaKey_method2((h) childAt2, tabLayout2.d);
                        left = (int) TabLayout.this.d.left;
                        right = (int) TabLayout.this.d.right;
                    }
                    float f2 = this.e;
                    i3 = (int) ((((float) left) * f2) + ((1.0f - f2) * ((float) i3)));
                    i2 = (int) ((((float) right) * f2) + ((1.0f - f2) * ((float) i2)));
                }
            }
            b(i3, i2);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, float f2) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            this.d = i2;
            this.e = f2;
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            ValueAnimator valueAnimator = this.i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.i.cancel();
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.C && (childAt instanceof h)) {
                a_shaKey_method2((h) childAt, tabLayout.d);
                left = (int) TabLayout.this.d.left;
                right = (int) TabLayout.this.d.right;
            }
            int i4 = left;
            int i5 = right;
            int i6 = this.g;
            int i7 = this.h;
            if (i6 != i4 || i7 != i5) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.i = valueAnimator2;
                valueAnimator2.setInterpolator(com.google.android.material.a.a.f1988b);
                valueAnimator2.setDuration((long) i3);
                valueAnimator2.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator2.addUpdateListener(new b(this, i6, i4, i7, i5));
                valueAnimator2.addListener(new c(this, i2));
                valueAnimator2.start();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            if (i2 != this.g || i3 != this.h) {
                this.g = i2;
                this.h = i3;
                t.C(this);
            }
        }

        private void a(h hVar, RectF rectF) {
            int a2 = hVar.d();
            if (a2 < TabLayout.this.a(24)) {
                a2 = TabLayout.this.a(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            int i2 = a2 / 2;
            rectF.set((float) (left - i2), 0.0f, (float) (left + i2), 0.0f);
        }
    }

    class h extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private f f2244a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f2245b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f2246c;
        private View d;
        private TextView e;
        private ImageView f;
        private Drawable g;
        private int h = 2;

        public h(Context context) {
            super(context);
            a(context);
            t.b(this, TabLayout.this.f, TabLayout.this.g, TabLayout.this.h, TabLayout.this.i);
            setGravity(17);
            setOrientation(TabLayout.this.B ^ true ? 1 : 0);
            setClickable(true);
            t.a_shaKey_method2((View) this, p.a_shaKey_method2(getContext(), 1002));
        }

        /* access modifiers changed from: private */
        public int d() {
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (View view : new View[]{this.f2245b, this.f2246c, this.d}) {
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        /* access modifiers changed from: private */
        public void drawBackground(Canvas canvas) {
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.g.draw(canvas);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            f fVar = this.f2244a;
            Drawable drawable = null;
            View a2 = fVar != null ? fVar.a() : null;
            if (a2 != null) {
                ViewParent parent = a2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(a2);
                    }
                    addView(a2);
                }
                this.d = a2;
                TextView textView = this.f2245b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2246c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2246c.setImageDrawable((Drawable) null);
                }
                this.e = (TextView) a2.findViewById(16908308);
                TextView textView2 = this.e;
                if (textView2 != null) {
                    this.h = l.d(textView2);
                }
                this.f = (ImageView) a2.findViewById(16908294);
            } else {
                View view = this.d;
                if (view != null) {
                    removeView(view);
                    this.d = null;
                }
                this.e = null;
                this.f = null;
            }
            boolean z = false;
            if (this.d == null) {
                if (this.f2246c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, this, false);
                    addView(imageView2, 0);
                    this.f2246c = imageView2;
                }
                if (!(fVar == null || fVar.b() == null)) {
                    drawable = androidx.core.graphics.drawable.a.i(fVar.b()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, TabLayout.this.l);
                    PorterDuff.Mode mode = TabLayout.this.o;
                    if (mode != null) {
                        androidx.core.graphics.drawable.a.a_shaKey_method2(drawable, mode);
                    }
                }
                if (this.f2245b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, this, false);
                    addView(textView3);
                    this.f2245b = textView3;
                    this.h = l.d(this.f2245b);
                }
                l.d(this.f2245b, TabLayout.this.j);
                ColorStateList colorStateList = TabLayout.this.k;
                if (colorStateList != null) {
                    this.f2245b.setTextColor(colorStateList);
                }
                a_shaKey_method2(this.f2245b, this.f2246c);
            } else if (!(this.e == null && this.f == null)) {
                a_shaKey_method2(this.e, this.f);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.d)) {
                setContentDescription(fVar.d);
            }
            if (fVar != null && fVar.e()) {
                z = true;
            }
            setSelected(z);
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            setOrientation(TabLayout.this.B ^ true ? 1 : 0);
            if (this.e == null && this.f == null) {
                a_shaKey_method2(this.f2245b, this.f2246c);
            } else {
                a_shaKey_method2(this.e, this.f);
            }
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.g;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.g.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.b.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
        }

        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.s, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f2245b != null) {
                float f2 = TabLayout.this.p;
                int i4 = this.h;
                ImageView imageView = this.f2246c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f2245b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.q;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f2245b.getTextSize();
                int lineCount = this.f2245b.getLineCount();
                int d2 = l.d(this.f2245b);
                if (f2 != textSize || (d2 >= 0 && i4 != d2)) {
                    if (TabLayout.this.A == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f2245b.getLayout()) == null || a(layout, 0, f2) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z = false;
                    }
                    if (z) {
                        this.f2245b.setTextSize(0, f2);
                        this.f2245b.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f2244a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f2244a.g();
            return true;
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f2245b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f2246c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.d;
            if (view != null) {
                view.setSelected(z);
            }
        }

        /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        /* JADX WARNING: type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.content.Context r7) {
            /*
                r6 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.r
                r1 = 0
                if (r0 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r7 = androidx.appcompat.a.a.a.b(r7, r0)
                r6.g = r7
                android.graphics.drawable.Drawable r7 = r6.g
                if (r7 == 0) goto L_0x0023
                boolean r7 = r7.isStateful()
                if (r7 == 0) goto L_0x0023
                android.graphics.drawable.Drawable r7 = r6.g
                int[] r0 = r6.getDrawableState()
                r7.setState(r0)
                goto L_0x0023
            L_0x0021:
                r6.g = r1
            L_0x0023:
                android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
                r7.<init>()
                r0 = 0
                r7.setColor(r0)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.m
                if (r2 == 0) goto L_0x007a
                android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
                r2.<init>()
                r3 = 925353388(0x3727c5ac, float:1.0E-5)
                r2.setCornerRadius(r3)
                r3 = -1
                r2.setColor(r3)
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r3 = r3.m
                android.content.res.ColorStateList r3 = com.google.android.material.g.a.a((android.content.res.ColorStateList) r3)
                int r4 = android.os.Build.VERSION.SDK_INT
                r5 = 21
                if (r4 < r5) goto L_0x0065
                android.graphics.drawable.RippleDrawable r0 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.D
                if (r4 == 0) goto L_0x0058
                r7 = r1
            L_0x0058:
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.D
                if (r4 == 0) goto L_0x005f
                goto L_0x0060
            L_0x005f:
                r1 = r2
            L_0x0060:
                r0.<init>(r3, r7, r1)
                r7 = r0
                goto L_0x007a
            L_0x0065:
                android.graphics.drawable.Drawable r1 = androidx.core.graphics.drawable.a.i(r2)
                androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r1, (android.content.res.ColorStateList) r3)
                android.graphics.drawable.LayerDrawable r2 = new android.graphics.drawable.LayerDrawable
                r3 = 2
                android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
                r3[r0] = r7
                r7 = 1
                r3[r7] = r1
                r2.<init>(r3)
                r7 = r2
            L_0x007a:
                androidx.core.h.t.a((android.view.View) r6, (android.graphics.drawable.Drawable) r7)
                com.google.android.material.tabs.TabLayout r7 = com.google.android.material.tabs.TabLayout.this
                r7.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.h.a(android.content.Context):void");
        }

        /* access modifiers changed from: package-private */
        public void a(f fVar) {
            if (fVar != this.f2244a) {
                this.f2244a = fVar;
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a((f) null);
            setSelected(false);
        }

        private void a(TextView textView, ImageView imageView) {
            f fVar = this.f2244a;
            Drawable mutate = (fVar == null || fVar.b() == null) ? null : androidx.core.graphics.drawable.a.i(this.f2244a.b()).mutate();
            f fVar2 = this.f2244a;
            CharSequence d2 = fVar2 != null ? fVar2.d() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (textView != null) {
                if (z) {
                    textView.setText(d2);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int a2 = (!z || imageView.getVisibility() != 0) ? 0 : TabLayout.this.a(8);
                if (TabLayout.this.B) {
                    if (a2 != androidx.core.h.f.a(marginLayoutParams)) {
                        androidx.core.h.f.a_shaKey_method2(marginLayoutParams, a2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (a2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a2;
                    androidx.core.h.f.a_shaKey_method2(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.f2244a;
            CharSequence a3 = fVar3 != null ? fVar3.d : null;
            if (z) {
                a3 = null;
            }
            qa.a_shaKey_method2(this, a3);
        }

        private float a(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2230b = new ArrayList<>();
        this.d = new RectF();
        this.s = Integer.MAX_VALUE;
        this.F = new ArrayList<>();
        this.O = new androidx.core.g.f(12);
        setHorizontalScrollBarEnabled(false);
        this.e = new e(context);
        super.addView(this.e, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = s.a(context, attributeSet, R$styleable.TabLayout, i2, R$style.Widget_Design_TabLayout, R$styleable.TabLayout_tabTextAppearance);
        this.e.b(a2.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        this.e.a(a2.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.f.a.b(context, a2, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(a2.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(a2.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.f = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, this.f);
        this.g = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.g);
        this.h = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.h);
        this.i = a2.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.i);
        this.j = a2.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.j, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.p = (float) obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0);
            this.k = com.google.android.material.f.a.a(context, obtainStyledAttributes, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(R$styleable.TabLayout_tabTextColor)) {
                this.k = com.google.android.material.f.a.a(context, a2, R$styleable.TabLayout_tabTextColor);
            }
            if (a2.hasValue(R$styleable.TabLayout_tabSelectedTextColor)) {
                this.k = a_shaKey_method2(this.k.getDefaultColor(), a2.getColor(R$styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.l = com.google.android.material.f.a.a(context, a2, R$styleable.TabLayout_tabIconTint);
            this.o = com.google.android.material.internal.t.a_shaKey_method2(a2.getInt(R$styleable.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.m = com.google.android.material.f.a.a(context, a2, R$styleable.TabLayout_tabRippleColor);
            this.y = a2.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.t = a2.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.u = a2.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.r = a2.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.w = a2.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.A = a2.getInt(R$styleable.TabLayout_tabMode, 1);
            this.x = a2.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.B = a2.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.D = a2.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            a2.recycle();
            Resources resources = getResources();
            this.q = (float) resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.v = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            e();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void f(f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).c(fVar);
        }
    }

    private void h(f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).b(fVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.e.getChildCount()) {
            if (z3) {
                this.e.a(i2, f2);
            }
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.H.cancel();
            }
            scrollTo(a(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    /* access modifiers changed from: protected */
    public boolean b(f fVar) {
        return f2229a.release(fVar);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public f b(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f2230b.get(i2);
    }

    private void g(f fVar) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(fVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(f fVar, boolean z2) {
        f fVar2 = this.f2231c;
        if (fVar2 != fVar) {
            int c2 = fVar != null ? fVar.c() : -1;
            if (z2) {
                if ((fVar2 == null || fVar2.c() == -1) && c2 != -1) {
                    a(c2, 0.0f, true);
                } else {
                    c(c2);
                }
                if (c2 != -1) {
                    setSelectedTabView(c2);
                }
            }
            this.f2231c = fVar;
            if (fVar2 != null) {
                h(fVar2);
            }
            if (fVar != null) {
                g(fVar);
            }
        } else if (fVar2 != null) {
            f(fVar);
            c(fVar.c());
        }
    }

    private void c(int i2) {
        if (i2 != -1) {
            if (getWindowToken() == null || !t.z(this) || this.e.a()) {
                a(i2, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int a2 = a(i2, 0.0f);
            if (scrollX != a2) {
                g();
                this.H.setIntValues(new int[]{scrollX, a2});
                this.H.start();
            }
            this.e.a(i2, this.y);
        }
    }

    private void d(f fVar) {
        this.e.addView(fVar.h, fVar.c(), f());
    }

    private void e() {
        t.b(this.e, this.A == 0 ? Math.max(0, this.w - this.f) : 0, 0, 0, 0);
        int i2 = this.A;
        if (i2 == 0) {
            this.e.setGravity(8388611);
        } else if (i2 == 1) {
            this.e.setGravity(1);
        }
        a(true);
    }

    public void a(f fVar) {
        a(fVar, this.f2230b.isEmpty());
    }

    private void d(int i2) {
        h hVar = (h) this.e.getChildAt(i2);
        this.e.removeViewAt(i2);
        if (hVar != null) {
            hVar.a();
            this.O.release(hVar);
        }
        requestLayout();
    }

    public void a(f fVar, boolean z2) {
        a(fVar, this.f2230b.size(), z2);
    }

    public void a(f fVar, int i2, boolean z2) {
        if (fVar.g == this) {
            a(fVar, i2);
            d(fVar);
            if (z2) {
                fVar.g();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void a(TabItem tabItem) {
        f b2 = b();
        CharSequence charSequence = tabItem.f2226a;
        if (charSequence != null) {
            b2.b(charSequence);
        }
        Drawable drawable = tabItem.f2227b;
        if (drawable != null) {
            b2.a(drawable);
        }
        int i2 = tabItem.f2228c;
        if (i2 != 0) {
            b2.a(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            b2.a(tabItem.getContentDescription());
        }
        a(b2);
    }

    /* access modifiers changed from: package-private */
    public void c(f fVar) {
        b(fVar, true);
    }

    /* access modifiers changed from: protected */
    public f a() {
        f acquire = f2229a.acquire();
        return acquire == null ? new f() : acquire;
    }

    public void a(ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    private void a(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.I;
        if (viewPager2 != null) {
            g gVar = this.L;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            a aVar = this.M;
            if (aVar != null) {
                this.I.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.G;
        if (bVar != null) {
            removeOnTabSelectedListener(bVar);
            this.G = null;
        }
        if (viewPager != null) {
            this.I = viewPager;
            if (this.L == null) {
                this.L = new g(this);
            }
            this.L.a();
            viewPager.addOnPageChangeListener(this.L);
            this.G = new i(viewPager);
            addOnTabSelectedListener(this.G);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.M == null) {
                this.M = new a();
            }
            this.M.a(z2);
            viewPager.addOnAdapterChangeListener(this.M);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.I = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.N = z3;
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.viewpager.widget.a aVar, boolean z2) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.J;
        if (!(aVar2 == null || (dataSetObserver = this.K) == null)) {
            aVar2.c(dataSetObserver);
        }
        this.J = aVar;
        if (z2 && aVar != null) {
            if (this.K == null) {
                this.K = new d();
            }
            aVar.a(this.K);
        }
        c();
    }

    private void a(f fVar, int i2) {
        fVar.b(i2);
        this.f2230b.add(i2, fVar);
        int size = this.f2230b.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.f2230b.get(i2).b(i2);
            } else {
                return;
            }
        }
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.A == 1 && this.x == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i2));
    }

    private int a(int i2, float f2) {
        int i3 = 0;
        if (this.A != 0) {
            return 0;
        }
        View childAt = this.e.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.e.getChildCount() ? this.e.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i3 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) (((float) (width + i3)) * 0.5f * f2);
        return t.k(this) == 0 ? left + i5 : left - i5;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            View childAt = this.e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }
}
