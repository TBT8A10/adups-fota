package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.g.g;
import androidx.core.h.C0085c;
import androidx.core.h.D;
import androidx.core.h.l;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements l {

    /* renamed from: a  reason: collision with root package name */
    static final String f501a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f502b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f503c = new ThreadLocal<>();
    static final Comparator<View> d;
    private static final androidx.core.g.e<Rect> e = new g(12);
    private final List<View> f;
    private final c<View> g;
    private final List<View> h;
    private final List<View> i;
    private final int[] j;
    private Paint k;
    private boolean l;
    private boolean m;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private int[] n;
    private View o;
    private View p;
    private e q;
    private boolean r;
    private D s;
    private boolean t;
    private Drawable u;
    private o v;
    private final n w;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public D a(CoordinatorLayout coordinatorLayout, V v, D d) {
            return d;
        }

        public void a() {
        }

        public void a(d dVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return b(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                a(coordinatorLayout, v, view, view2, i);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, v, view, i, i2, iArr);
            }
        }
    }

    public interface a {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> value();
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float t = t.t(view);
            float t2 = t.t(view2);
            if (t > t2) {
                return -1;
            }
            return t < t2 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            f501a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$f
            r0.<init>()
            d = r0
            goto L_0x0021
        L_0x001f:
            d = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f502b = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f503c = r0
            androidx.core.g.g r0 = new androidx.core.g.g
            r1 = 12
            r0.<init>(r1)
            e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        e.release(rect);
    }

    private int b(int i2) {
        int[] iArr = this.n;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
            return 0;
        }
    }

    private static int c(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int d(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int e(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void e(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        int i3 = dVar.i;
        if (i3 != i2) {
            t.a_shaKey_method2(view, i2 - i3);
            dVar.i = i2;
        }
    }

    private void f(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        int i3 = dVar.j;
        if (i3 != i2) {
            t.b(view, i2 - i3);
            dVar.j = i2;
        }
    }

    private static Rect g() {
        Rect acquire = e.acquire();
        return acquire == null ? new Rect() : acquire;
    }

    private void h() {
        this.f.clear();
        this.g.a();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d d2 = d(childAt);
            d2.a_shaKey_method2(this, childAt);
            this.g.a(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (d2.a(this, childAt, childAt2)) {
                        if (!this.g.b(childAt2)) {
                            this.g.a(childAt2);
                        }
                        this.g.a_shaKey_method2(childAt2, childAt);
                    }
                }
            }
        }
        this.f.addAll(this.g.b());
        Collections.reverse(this.f);
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (t.h(this)) {
                if (this.v == null) {
                    this.v = new a(this);
                }
                t.a_shaKey_method2((View) this, this.v);
                setSystemUiVisibility(1280);
                return;
            }
            t.a_shaKey_method2((View) this, (o) null);
        }
    }

    public void c(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.a()) {
            View view2 = dVar.k;
            if (view2 != null) {
                a(view, view2, i2);
                return;
            }
            int i3 = dVar.e;
            if (i3 >= 0) {
                b(view, i3, i2);
            } else {
                d(view, i2);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public d d(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.f507b) {
            if (view instanceof a) {
                Behavior behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                dVar.a(behavior);
                dVar.f507b = true;
            } else {
                b bVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a((Behavior) bVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget" + " a default constructor?", e2);
                    }
                }
                dVar.f507b = true;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        d dVar = (d) view.getLayoutParams();
        Behavior behavior = dVar.f506a;
        if (behavior != null) {
            float c2 = behavior.c(this, view);
            if (c2 > 0.0f) {
                if (this.k == null) {
                    this.k = new Paint();
                }
                this.k.setColor(dVar.f506a.b(this, view));
                this.k.setAlpha(a(Math.round(c2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.k);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.u;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        h();
        return Collections.unmodifiableList(this.f);
    }

    public final D getLastWindowInsets() {
        return this.s;
    }

    public int getNestedScrollAxes() {
        return this.w.a();
    }

    public Drawable getStatusBarBackground() {
        return this.u;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.r) {
            if (this.q == null) {
                this.q = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        if (this.s == null && t.h(this)) {
            t.D(this);
        }
        this.m = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.r && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        View view = this.p;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.m = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t && this.u != null) {
            D d2 = this.s;
            int e2 = d2 != null ? d2.e() : 0;
            if (e2 > 0) {
                this.u.setBounds(0, 0, getWidth(), e2);
                this.u.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a_shaKey_method2(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Behavior d2;
        int k2 = t.k(this);
        int size = this.f.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f.get(i6);
            if (view.getVisibility() != 8 && ((d2 = ((d) view.getLayoutParams()).d()) == null || !d2.a(this, view, k2))) {
                c(view, k2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0117, code lost:
        if (r0.a(r30, r20, r11, r21, r23, 0) == false) goto L_0x0126;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.h()
            r30.e()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.h.t.k(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.h.D r3 = r7.s
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.h.t.h(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.f
            int r6 = r2.size()
            r4 = r0
            r2 = r1
            r3 = 0
            r5 = 0
        L_0x0057:
            if (r5 >= r6) goto L_0x016c
            java.util.List<android.view.View> r0 = r7.f
            java.lang.Object r0 = r0.get(r5)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0071
            r22 = r5
            r29 = r6
            goto L_0x0166
        L_0x0071:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r1
            int r0 = r1.e
            if (r0 < 0) goto L_0x00b8
            if (r13 == 0) goto L_0x00b8
            int r0 = r7.b((int) r0)
            int r11 = r1.f508c
            int r11 = e((int) r11)
            int r11 = androidx.core.h.C0085c.a(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0095
            if (r12 == 0) goto L_0x009a
        L_0x0095:
            r2 = 5
            if (r11 != r2) goto L_0x00a6
            if (r12 == 0) goto L_0x00a6
        L_0x009a:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00bd
        L_0x00a6:
            if (r11 != r2) goto L_0x00aa
            if (r12 == 0) goto L_0x00af
        L_0x00aa:
            r2 = 3
            if (r11 != r2) goto L_0x00ba
            if (r12 == 0) goto L_0x00ba
        L_0x00af:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00bd
        L_0x00b8:
            r22 = r2
        L_0x00ba:
            r11 = 0
            r21 = 0
        L_0x00bd:
            if (r19 == 0) goto L_0x00ef
            boolean r0 = androidx.core.h.t.h(r20)
            if (r0 != 0) goto L_0x00ef
            androidx.core.h.D r0 = r7.s
            int r0 = r0.c()
            androidx.core.h.D r2 = r7.s
            int r2 = r2.d()
            int r0 = r0 + r2
            androidx.core.h.D r2 = r7.s
            int r2 = r2.e()
            androidx.core.h.D r11 = r7.s
            int r11 = r11.b()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f3
        L_0x00ef:
            r11 = r31
            r23 = r32
        L_0x00f3:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.d()
            if (r0 == 0) goto L_0x011a
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r27 = r3
            r3 = r11
            r28 = r4
            r4 = r21
            r22 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r1, r2, (int) r3, (int) r4, (int) r5, (int) r6)
            if (r0 != 0) goto L_0x0133
            goto L_0x0126
        L_0x011a:
            r26 = r1
            r27 = r3
            r28 = r4
            r29 = r6
            r25 = r22
            r22 = r5
        L_0x0126:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
        L_0x0133:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            r2 = r28
            int r0 = java.lang.Math.max(r2, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r25
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r27
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r4 = r0
            r3 = r2
            r2 = r1
        L_0x0166:
            int r5 = r22 + 1
            r6 = r29
            goto L_0x0057
        L_0x016c:
            r1 = r2
            r11 = r3
            r2 = r4
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r3 = r31
            int r0 = android.view.View.resolveSizeAndState(r2, r3, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Behavior d2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (d2 = dVar.d()) != null) {
                    z2 |= d2.a(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (d2 = dVar.d()) != null) {
                    z |= d2.a(this, childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f504c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior d2 = d(childAt).d();
            if (!(id == -1 || d2 == null || (parcelable2 = sparseArray.get(id)) == null)) {
                d2.a(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable d2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior d3 = ((d) childAt.getLayoutParams()).d();
            if (!(id == -1 || d3 == null || (d2 = d3.d(this, childAt)) == null)) {
                sparseArray.append(id, d2);
            }
        }
        savedState.f504c = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return b(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        a_shaKey_method2(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.o
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.a((android.view.MotionEvent) r1, (int) r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.o
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.d()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.o
            boolean r6 = r6.b((androidx.coordinatorlayout.widget.CoordinatorLayout) r0, r7, (android.view.MotionEvent) r1)
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            android.view.View r7 = r0.o
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.a((boolean) r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior d2 = ((d) view.getLayoutParams()).d();
        if (d2 == null || !d2.a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.l) {
            a(false);
            this.l = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        i();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.u = drawable3;
            Drawable drawable4 = this.u;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.u.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a_shaKey_method2(this.u, t.k(this));
                this.u.setVisible(getVisibility() == 0, false);
                this.u.setCallback(this);
            }
            t.C(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? androidx.core.content.a.c(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.u;
        if (drawable != null && drawable.isVisible() != z) {
            this.u.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    /* access modifiers changed from: protected */
    public d generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f506a;

        /* renamed from: b  reason: collision with root package name */
        boolean f507b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f508c = 0;
        public int d = 0;
        public int e = -1;
        int f = -1;
        public int g = 0;
        public int h = 0;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q = new Rect();
        Object r;

        public d(int i2, int i3) {
            super(i2, i3);
        }

        public void a(Behavior behavior) {
            Behavior behavior2 = this.f506a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.a();
                }
                this.f506a = behavior;
                this.r = null;
                this.f507b = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            if (this.f506a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f;
        }

        public Behavior d() {
            return this.f506a;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return this.p;
        }

        /* access modifiers changed from: package-private */
        public Rect f() {
            return this.q;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.p = false;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.m = false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            Behavior behavior = this.f506a;
            boolean a2 = (behavior != null ? behavior.a_shaKey_method2(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        /* access modifiers changed from: package-private */
        public void a(Rect rect) {
            this.q.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            a(i2, false);
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.k == null && this.f != -1;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 == 1) {
                this.o = z;
            }
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f508c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f507b = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f507b) {
                this.f506a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f506a;
            if (behavior != null) {
                behavior.a(this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.p = z;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f506a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.l
                if (r4 == r0) goto L_0x001b
                int r0 = androidx.core.h.t.k(r2)
                boolean r0 = r1.a((android.view.View) r4, (int) r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f506a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r2, r3, (android.view.View) r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.d.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        /* access modifiers changed from: package-private */
        public View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a_shaKey_method2(view, coordinatorLayout);
            }
            return this.k;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            View view2 = this.k;
            if (view2 != null) {
                if (view2 != coordinatorLayout) {
                    ViewParent parent = view2.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.l = null;
                this.k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            }
        }

        public d(d dVar) {
            super(dVar);
        }

        private boolean a(View view, int i2) {
            int a2 = C0085c.a(((d) view.getLayoutParams()).g, i2);
            return a2 != 0 && (C0085c.a(this.h, i2) & a2) == a2;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        this.f = new ArrayList();
        this.g = new c<>();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new int[2];
        this.w = new n(this);
        if (i2 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i2, 0);
        }
        int resourceId = typedArray.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.n = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.n.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.n;
                iArr[i3] = (int) (((float) iArr[i3]) * f2);
            }
        }
        this.u = typedArray.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        i();
        super.setOnHierarchyChangeListener(new c());
    }

    /* access modifiers changed from: package-private */
    public final D a(D d2) {
        if (androidx.core.g.c.a(this.s, d2)) {
            return d2;
        }
        this.s = d2;
        boolean z = true;
        this.t = d2 != null && d2.e() > 0;
        if (this.t || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        D b2 = b(d2);
        requestLayout();
        return b2;
    }

    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (e(getChildAt(i2))) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z == this.r) {
            return;
        }
        if (z) {
            d();
        } else {
            f();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.m && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        this.r = false;
    }

    private D b(D d2) {
        Behavior d3;
        if (d2.g()) {
            return d2;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (t.h(childAt) && (d3 = ((d) childAt.getLayoutParams()).d()) != null) {
                d2 = d3.a(this, childAt, d2);
                if (d2.g()) {
                    break;
                }
            }
        }
        return d2;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* renamed from: c  reason: collision with root package name */
        SparseArray<Parcelable> f504c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f504c = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f504c.append(iArr[i], readParcelableArray[i]);
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f504c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f504c.keyAt(i2);
                parcelableArr[i2] = this.f504c.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Behavior d2 = ((d) childAt.getLayoutParams()).d();
            if (d2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    d2.a(this, childAt, obtain);
                } else {
                    d2.b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((d) getChildAt(i3).getLayoutParams()).h();
        }
        this.o = null;
        this.l = false;
    }

    /* access modifiers changed from: package-private */
    public void c(View view, Rect rect) {
        ((d) view.getLayoutParams()).a(rect);
    }

    private boolean e(View view) {
        return this.g.e(view);
    }

    public List<View> c(View view) {
        List c2 = this.g.c(view);
        this.i.clear();
        if (c2 != null) {
            this.i.addAll(c2);
        }
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void b(View view, Rect rect) {
        rect.set(((d) view.getLayoutParams()).f());
    }

    private void b(View view, int i2, int i3) {
        d dVar = (d) view.getLayoutParams();
        int a2 = C0085c.a(e(dVar.f508c), i3);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int b2 = b(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            b2 += measuredWidth / 2;
        } else if (i4 == 5) {
            b2 += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void d(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        Rect g2 = g();
        g2.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (this.s != null && t.h(this) && !t.h(view)) {
            g2.left += this.s.c();
            g2.top += this.s.e();
            g2.right -= this.s.d();
            g2.bottom -= this.s.b();
        }
        Rect g3 = g();
        C0085c.a(d(dVar.f508c), view.getMeasuredWidth(), view.getMeasuredHeight(), g2, g3, i2);
        view.layout(g3.left, g3.top, g3.right, g3.bottom);
        a(g2);
        a(g3);
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean a(MotionEvent motionEvent, int i2) {
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.h;
        a(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            d dVar = (d) view.getLayoutParams();
            Behavior d2 = dVar.d();
            boolean z3 = true;
            if ((!z && !z2) || actionMasked == 0) {
                if (!z && d2 != null) {
                    if (i3 == 0) {
                        z = d2.a(this, view, motionEvent2);
                    } else if (i3 == 1) {
                        z = d2.b(this, view, motionEvent2);
                    }
                    if (z) {
                        this.o = view;
                    }
                }
                boolean b2 = dVar.b();
                boolean b3 = dVar.b(this, view);
                if (!b3 || b2) {
                    z3 = false;
                }
                if (b3 && !z3) {
                    break;
                }
                z2 = z3;
            } else if (d2 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    d2.a(this, view, motionEvent3);
                } else if (i3 == 1) {
                    d2.b(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z;
    }

    public List<View> b(View view) {
        List<View> d2 = this.g.d(view);
        this.i.clear();
        if (d2 != null) {
            this.i.addAll(d2);
        }
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.m) {
            if (this.q == null) {
                this.q = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        this.r = true;
    }

    /* access modifiers changed from: package-private */
    public void b(View view, int i2) {
        Behavior d2;
        View view2 = view;
        d dVar = (d) view.getLayoutParams();
        if (dVar.k != null) {
            Rect g2 = g();
            Rect g3 = g();
            Rect g4 = g();
            a_shaKey_method2(dVar.k, g2);
            boolean z = false;
            a(view2, false, g3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = measuredHeight;
            a(view, i2, g2, g4, dVar, measuredWidth, measuredHeight);
            if (!(g4.left == g3.left && g4.top == g3.top)) {
                z = true;
            }
            a(dVar, g4, measuredWidth, i3);
            int i4 = g4.left - g3.left;
            int i5 = g4.top - g3.top;
            if (i4 != 0) {
                t.a_shaKey_method2(view2, i4);
            }
            if (i5 != 0) {
                t.b(view2, i5);
            }
            if (z && (d2 = dVar.d()) != null) {
                d2.b(this, view2, dVar.k);
            }
            a(g2);
            a(g3);
            a(g4);
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f501a)) {
            str = f501a + '.' + str;
        }
        try {
            Map map = f503c.get();
            if (map == null) {
                map = new HashMap();
                f503c.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f502b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    public boolean b(View view, View view2, int i2, int i3) {
        int i4 = i3;
        int childCount = getChildCount();
        boolean z = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior d2 = dVar.d();
                if (d2 != null) {
                    boolean b2 = d2.b(this, childAt, view, view2, i2, i3);
                    dVar.a(i4, b2);
                    z |= b2;
                } else {
                    dVar.a(i4, false);
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, Rect rect) {
        d.a((ViewGroup) this, view, rect);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a_shaKey_method2(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private void a(View view, int i2, Rect rect, Rect rect2, d dVar, int i3, int i4) {
        int i5;
        int i6;
        int a2 = C0085c.a(c(dVar.f508c), i2);
        int a3 = C0085c.a(d(dVar.d), i2);
        int i7 = a2 & 7;
        int i8 = a2 & 112;
        int i9 = a3 & 7;
        int i10 = a3 & 112;
        if (i9 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i9 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i10 == 16) {
            i6 = rect.top + (rect.height() / 2);
        } else if (i10 != 80) {
            i6 = rect.top;
        } else {
            i6 = rect.bottom;
        }
        if (i7 == 1) {
            i5 -= i3 / 2;
        } else if (i7 != 5) {
            i5 -= i3;
        }
        if (i8 == 16) {
            i6 -= i4 / 2;
        } else if (i8 != 80) {
            i6 -= i4;
        }
        rect2.set(i5, i6, i3 + i5, i4 + i6);
    }

    private void a(d dVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - dVar.bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i2, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    private void a(View view, View view2, int i2) {
        Rect g2 = g();
        Rect g3 = g();
        try {
            a_shaKey_method2(view2, g2);
            a(view, i2, g2, g3);
            view.layout(g3.left, g3.top, g3.right, g3.bottom);
        } finally {
            a(g2);
            a(g3);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        boolean z;
        int i3 = i2;
        int k2 = t.k(this);
        int size = this.f.size();
        Rect g2 = g();
        Rect g3 = g();
        Rect g4 = g();
        for (int i4 = 0; i4 < size; i4++) {
            View view = this.f.get(i4);
            d dVar = (d) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (dVar.l == this.f.get(i5)) {
                        b(view, k2);
                    }
                }
                a(view, true, g3);
                if (dVar.g != 0 && !g3.isEmpty()) {
                    int a2 = C0085c.a(dVar.g, k2);
                    int i6 = a2 & 112;
                    if (i6 == 48) {
                        g2.top = Math.max(g2.top, g3.bottom);
                    } else if (i6 == 80) {
                        g2.bottom = Math.max(g2.bottom, getHeight() - g3.top);
                    }
                    int i7 = a2 & 7;
                    if (i7 == 3) {
                        g2.left = Math.max(g2.left, g3.right);
                    } else if (i7 == 5) {
                        g2.right = Math.max(g2.right, getWidth() - g3.left);
                    }
                }
                if (dVar.h != 0 && view.getVisibility() == 0) {
                    a(view, g2, k2);
                }
                if (i3 != 2) {
                    b(view, g4);
                    if (!g4.equals(g3)) {
                        c(view, g3);
                    }
                }
                for (int i8 = i4 + 1; i8 < size; i8++) {
                    View view2 = this.f.get(i8);
                    d dVar2 = (d) view2.getLayoutParams();
                    Behavior d2 = dVar2.d();
                    if (d2 != null && d2.a(this, view2, view)) {
                        if (i3 != 0 || !dVar2.e()) {
                            if (i3 != 2) {
                                z = d2.b(this, view2, view);
                            } else {
                                d2.c(this, view2, view);
                                z = true;
                            }
                            if (i3 == 1) {
                                dVar2.a(z);
                            }
                        } else {
                            dVar2.g();
                        }
                    }
                }
            }
        }
        a(g2);
        a(g3);
        a(g4);
    }

    private void a(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (t.z(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            d dVar = (d) view.getLayoutParams();
            Behavior d2 = dVar.d();
            Rect g2 = g();
            Rect g3 = g();
            g3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (d2 == null || !d2.a(this, view, g2)) {
                g2.set(g3);
            } else if (!g3.contains(g2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + g2.toShortString() + " | Bounds:" + g3.toShortString());
            }
            a(g3);
            if (g2.isEmpty()) {
                a(g2);
                return;
            }
            int a2 = C0085c.a(dVar.h, i2);
            if ((a2 & 48) != 48 || (i7 = (g2.top - dVar.topMargin) - dVar.j) >= (i8 = rect.top)) {
                z = false;
            } else {
                f(view, i8 - i7);
                z = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - g2.bottom) - dVar.bottomMargin) + dVar.j) < (i6 = rect.bottom)) {
                f(view, height - i6);
                z = true;
            }
            if (!z) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i4 = (g2.left - dVar.leftMargin) - dVar.i) >= (i5 = rect.left)) {
                z2 = false;
            } else {
                e(view, i5 - i4);
                z2 = true;
            }
            if ((a2 & 5) == 5 && (width = ((getWidth() - g2.right) - dVar.rightMargin) + dVar.i) < (i3 = rect.right)) {
                e(view, width - i3);
                z2 = true;
            }
            if (!z2) {
                e(view, 0);
            }
            a(g2);
        }
    }

    public void a(View view) {
        List c2 = this.g.c(view);
        if (c2 != null && !c2.isEmpty()) {
            for (int i2 = 0; i2 < c2.size(); i2++) {
                View view2 = (View) c2.get(i2);
                Behavior d2 = ((d) view2.getLayoutParams()).d();
                if (d2 != null) {
                    d2.b(this, view2, view);
                }
            }
        }
    }

    public boolean a(View view, int i2, int i3) {
        Rect g2 = g();
        a_shaKey_method2(view, g2);
        try {
            return g2.contains(i2, i3);
        } finally {
            a(g2);
        }
    }

    public void a(View view, View view2, int i2, int i3) {
        Behavior d2;
        this.w.a(view, view2, i2, i3);
        this.p = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i3) && (d2 = dVar.d()) != null) {
                d2.a(this, childAt, view, view2, i2, i3);
            }
        }
    }

    public void a(View view, int i2) {
        this.w.a_shaKey_method2(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i2)) {
                Behavior d2 = dVar.d();
                if (d2 != null) {
                    d2.a(this, childAt, view, i2);
                }
                dVar.b(i2);
                dVar.g();
            }
        }
        this.p = null;
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        Behavior d2;
        int childCount = getChildCount();
        boolean z = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                int i8 = i6;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i6) && (d2 = dVar.d()) != null) {
                    d2.a(this, childAt, view, i2, i3, i4, i5, i6);
                    z = true;
                }
            }
        }
        if (z) {
            a(1);
        }
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior d2;
        int i5;
        int i6;
        int childCount = getChildCount();
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                int i10 = i4;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i4) && (d2 = dVar.d()) != null) {
                    int[] iArr2 = this.j;
                    iArr2[1] = 0;
                    iArr2[0] = 0;
                    d2.a(this, childAt, view, i2, i3, iArr2, i4);
                    if (i2 > 0) {
                        i5 = Math.max(i7, this.j[0]);
                    } else {
                        i5 = Math.min(i7, this.j[0]);
                    }
                    if (i3 > 0) {
                        i6 = Math.max(i8, this.j[1]);
                    } else {
                        i6 = Math.min(i8, this.j[1]);
                    }
                    i7 = i5;
                    i8 = i6;
                    z = true;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z) {
            a(1);
        }
    }
}
