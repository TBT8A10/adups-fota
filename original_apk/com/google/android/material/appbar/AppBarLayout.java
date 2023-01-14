package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.c;
import androidx.core.h.D;
import androidx.core.h.j;
import androidx.core.h.o;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f2005a;

    /* renamed from: b  reason: collision with root package name */
    private int f2006b;

    /* renamed from: c  reason: collision with root package name */
    private int f2007c;
    private boolean d;
    private int e;
    private D f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int[] l;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        /* access modifiers changed from: private */
        public int k;
        private int l;
        private ValueAnimator m;
        private int n = -1;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private a r;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private void d(CoordinatorLayout coordinatorLayout, T t) {
            int c2 = c();
            int b2 = b(t, c2);
            if (b2 >= 0) {
                View childAt = t.getChildAt(b2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a2 = layoutParams.a();
                if ((a2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (b2 == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (a(a2, 2)) {
                        i2 += t.l(childAt);
                    } else if (a(a2, 5)) {
                        int l2 = t.l(childAt) + i2;
                        if (c2 < l2) {
                            i = l2;
                        } else {
                            i2 = l2;
                        }
                    }
                    if (a(a2, 32)) {
                        i += layoutParams.topMargin;
                        i2 -= layoutParams.bottomMargin;
                    }
                    if (c2 < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, t, androidx.core.c.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int c(T t) {
            return t.getTotalScrollRange();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int c(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b2 != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i2 -= t.l(childAt);
                        }
                    }
                    if (t.h(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = (float) i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * b2.getInterpolation(((float) (abs - childAt.getTop())) / f)));
                    }
                }
            }
            return i;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new c();

            /* renamed from: c  reason: collision with root package name */
            int f2008c;
            float d;
            boolean e;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f2008c = parcel.readInt();
                this.d = parcel.readFloat();
                this.e = parcel.readByte() != 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f2008c);
                parcel.writeFloat(this.d);
                parcel.writeByte(this.e ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        private int b(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a(layoutParams.a(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.c() || a(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i2;
            return z;
        }

        /* access modifiers changed from: package-private */
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* renamed from: b */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d = super.d(coordinatorLayout, t);
            int b2 = b();
            int childCount = t.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(d);
                    savedState.f2008c = i;
                    if (bottom == t.l(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    savedState.e = z;
                    savedState.d = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return d;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.b() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i5 = i6;
                    i4 = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    i4 = 0;
                }
                if (i5 != i4) {
                    iArr[1] = a(coordinatorLayout, t, i2, i5, i4);
                    a(i2, t, view, i3);
                }
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> c2 = coordinatorLayout.c((View) t);
            int size = c2.size();
            int i = 0;
            while (i < size) {
                CoordinatorLayout.Behavior d = ((CoordinatorLayout.d) c2.get(i).getLayoutParams()).d();
                if (!(d instanceof ScrollingViewBehavior)) {
                    i++;
                } else if (((ScrollingViewBehavior) d).c() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                a(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
                a(i4, t, view, i5);
            }
            if (t.c()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int c2 = c();
                if ((i < 0 && c2 == 0) || (i > 0 && c2 == (-t.getDownNestedScrollRange()))) {
                    t.f(view, 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return b() + this.k;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.l == 0 || i == 1) {
                d(coordinatorLayout, t);
            }
            this.q = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int i2;
            int abs = Math.abs(c() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                i2 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i2 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, t, i, i2);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int c2 = c();
            if (c2 == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                this.m = new ValueAnimator();
                this.m.setInterpolator(com.google.android.material.a.a.e);
                this.m.addUpdateListener(new b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration((long) Math.min(i2, 600));
            this.m.setIntValues(new int[]{c2, i});
            this.m.start();
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.d) t.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, t, i, i2, i3, i4);
            }
            coordinatorLayout.a((View) t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int i2;
            boolean a2 = super.a(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            int i3 = this.n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.o) {
                    i2 = t.l(childAt) + t.getTopInset();
                } else {
                    i2 = Math.round(((float) childAt.getHeight()) * this.p);
                }
                c(coordinatorLayout, t, i4 + i2);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, t, i5, 0.0f);
                    } else {
                        c(coordinatorLayout, t, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, t, 0);
                    }
                }
            }
            t.d();
            this.n = -1;
            a(androidx.core.c.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, t, b(), 0, true);
            t.a(b());
            return a2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(T t) {
            a aVar = this.r;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, t);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int b(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int c2 = c();
            int i4 = 0;
            if (i2 == 0 || c2 < i2 || c2 > i3) {
                this.k = 0;
            } else {
                int a2 = androidx.core.c.a.a(i, i2, i3);
                if (c2 != a2) {
                    int c3 = t.a() ? c(t, a2) : a2;
                    boolean a3 = a(c3);
                    i4 = c2 - a2;
                    this.k = a2 - c3;
                    if (!a3 && t.a()) {
                        coordinatorLayout.a((View) t);
                    }
                    t.a(b());
                    a(coordinatorLayout, t, a2, a2 < c2 ? -1 : 1, false);
                }
            }
            return i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = a((com.google.android.material.appbar.AppBarLayout) r7, (int) r8)
                if (r0 == 0) goto L_0x006e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0041
                int r2 = androidx.core.h.t.l(r0)
                if (r9 <= 0) goto L_0x002f
                r9 = r1 & 12
                if (r9 == 0) goto L_0x002f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
            L_0x002d:
                r8 = 1
                goto L_0x0042
            L_0x002f:
                r9 = r1 & 2
                if (r9 == 0) goto L_0x0041
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
                goto L_0x002d
            L_0x0041:
                r8 = 0
            L_0x0042:
                boolean r9 = r7.c()
                if (r9 == 0) goto L_0x0057
                android.view.View r9 = r5.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r6)
                if (r9 == 0) goto L_0x0057
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L_0x0056
                r8 = 1
                goto L_0x0057
            L_0x0056:
                r8 = 0
            L_0x0057:
                boolean r8 = r7.a((boolean) r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L_0x006e
                if (r10 != 0) goto L_0x006b
                if (r8 == 0) goto L_0x006e
                boolean r6 = r5.c((androidx.coordinatorlayout.widget.CoordinatorLayout) r6, r7)
                if (r6 == 0) goto L_0x006e
            L_0x006b:
                r7.jumpDrawablesToCurrentState()
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private static View a(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof j) {
                    return childAt;
                }
            }
            return null;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, t, savedState.a());
                this.n = savedState.f2008c;
                this.p = savedState.d;
                this.o = savedState.e;
                return;
            }
            super.a(coordinatorLayout, t, parcelable);
            this.n = -1;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, appBarLayout, i);
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.b(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, appBarLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a_shaKey_method2(view, view2);
            b(view, view2);
            return false;
        }

        /* access modifiers changed from: package-private */
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public float b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) a2) / ((float) i)) + 1.0f;
                }
            }
            return 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a((List) coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.c()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }

        private void a(View view, View view2) {
            CoordinatorLayout.Behavior d = ((CoordinatorLayout.d) view2.getLayoutParams()).d();
            if (d instanceof BaseBehavior) {
                t.b(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) d).k) + d()) - a(view2));
            }
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior d = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).d();
            if (d instanceof BaseBehavior) {
                return ((BaseBehavior) d).c();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public interface b extends a<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean e() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void f() {
        this.f2005a = -1;
        this.f2006b = -1;
        this.f2007c = -1;
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    public void addOnOffsetChangedListener(a aVar) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        if (aVar != null && !this.g.contains(aVar)) {
            this.g.add(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return getTotalScrollRange() != 0;
    }

    public boolean c() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.e = 0;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int i3 = this.f2006b;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f2009a;
            if ((i5 & 5) == 5) {
                int i6 = i4 + layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i5 & 8) != 0) {
                    i4 = i6 + t.l(childAt);
                } else {
                    if ((i5 & 2) != 0) {
                        i2 = t.l(childAt);
                    } else {
                        i2 = getTopInset();
                    }
                    i4 = i6 + (measuredHeight - i2);
                }
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f2006b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.f2007c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i5 = layoutParams.f2009a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= t.l(childAt) + getTopInset();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f2007c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int l2 = t.l(this);
        if (l2 == 0) {
            int childCount = getChildCount();
            l2 = childCount >= 1 ? t.l(getChildAt(childCount - 1)) : 0;
            if (l2 == 0) {
                return getHeight() / 3;
            }
        }
        return (l2 * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        D d2 = this.f;
        if (d2 != null) {
            return d2.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f2005a;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f2009a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((i5 & 2) != 0) {
                i4 -= t.l(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4 - getTopInset());
        this.f2005a = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.i ? R$attr.state_liftable : -R$attr.state_liftable;
        iArr[1] = (!this.i || !this.j) ? -R$attr.state_lifted : R$attr.state_lifted;
        iArr[2] = this.i ? R$attr.state_collapsible : -R$attr.state_collapsible;
        iArr[3] = (!this.i || !this.j) ? -R$attr.state_collapsed : R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        f();
        boolean z2 = false;
        this.d = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            } else {
                i6++;
            }
        }
        if (!this.h) {
            if (this.k || e()) {
                z2 = true;
            }
            b(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        f();
    }

    public void removeOnOffsetChangedListener(a aVar) {
        List<a> list = this.g;
        if (list != null && aVar != null) {
            list.remove(aVar);
        }
    }

    public void setExpanded(boolean z) {
        a_shaKey_method2(z, t.z(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            g.a_shaKey_method2(this, f2);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2005a = -1;
        this.f2006b = -1;
        this.f2007c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            g.a(this);
            g.a(this, attributeSet, 0, R$style.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = s.a(context, attributeSet, R$styleable.AppBarLayout, 0, R$style.Widget_Design_AppBarLayout, new int[0]);
        t.a_shaKey_method2((View) this, a2.getDrawable(R$styleable.AppBarLayout_android_background));
        if (a2.hasValue(R$styleable.AppBarLayout_expanded)) {
            a(a2.getBoolean(R$styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(R$styleable.AppBarLayout_elevation)) {
            g.a_shaKey_method2(this, (float) a2.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(R$styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(R$styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(R$styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = a2.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        a2.recycle();
        t.a_shaKey_method2((View) this, (o) new a(this));
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.e = i3 | i2;
        requestLayout();
    }

    private boolean b(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(b bVar) {
        removeOnOffsetChangedListener((a) bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        List<a> list = this.g;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.g.get(i3);
                if (aVar != null) {
                    aVar.a(this, i2);
                }
            }
        }
    }

    public void addOnOffsetChangedListener(b bVar) {
        addOnOffsetChangedListener((a) bVar);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f2009a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f2010b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f2009a = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f2010b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f2009a;
        }

        public Interpolator b() {
            return this.f2010b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int i = this.f2009a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    public D a(D d2) {
        D d3 = t.h(this) ? d2 : null;
        if (!c.a(this.f, d3)) {
            this.f = d3;
            f();
        }
        return d2;
    }
}
