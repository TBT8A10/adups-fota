package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.customview.a.g;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f2075a = true;

    /* renamed from: b  reason: collision with root package name */
    private float f2076b;

    /* renamed from: c  reason: collision with root package name */
    private int f2077c;
    private boolean d;
    private int e;
    private int f;
    int g;
    int h;
    int i;
    boolean j;
    private boolean k;
    int l = 4;
    g m;
    private boolean n;
    private int o;
    private boolean p;
    int q;
    WeakReference<V> r;
    WeakReference<View> s;
    private a t;
    private VelocityTracker u;
    int v;
    private int w;
    boolean x;
    private Map<View, Integer> y;
    private final g.a z = new a(this);

    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f2079a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2080b;

        b(View view, int i) {
            this.f2079a = view;
            this.f2080b = i;
        }

        public void run() {
            g gVar = BottomSheetBehavior.this.m;
            if (gVar == null || !gVar.a(true)) {
                BottomSheetBehavior.this.c(this.f2080b);
            } else {
                t.a_shaKey_method2(this.f2079a, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior() {
    }

    private void e() {
        this.v = -1;
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    public void c(boolean z2) {
        this.k = z2;
    }

    public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.d(coordinatorLayout, v2), this.l);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* renamed from: c  reason: collision with root package name */
        final int f2078c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2078c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2078c);
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f2078c = i;
        }
    }

    private float d() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND, this.f2076b);
        return this.u.getYVelocity(this.v);
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v2, savedState.a());
        int i2 = savedState.f2078c;
        if (i2 == 1 || i2 == 2) {
            this.l = 4;
        } else {
            this.l = i2;
        }
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.l == 1 && actionMasked == 0) {
            return true;
        }
        g gVar = this.m;
        if (gVar != null) {
            gVar.a(motionEvent);
        }
        if (actionMasked == 0) {
            e();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 2 && !this.n && Math.abs(((float) this.w) - motionEvent.getY()) > ((float) this.m.e())) {
            this.m.a_shaKey_method2((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.n;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        a aVar;
        if (this.l != i2) {
            this.l = i2;
            if (i2 == 6 || i2 == 3) {
                d(true);
            } else if (i2 == 5 || i2 == 4) {
                d(false);
            }
            View view = (View) this.r.get();
            if (view != null && (aVar = this.t) != null) {
                aVar.a_shaKey_method2(view, i2);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            b(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            b(i2);
        }
        b(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.f2076b = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void d(boolean z2) {
        WeakReference<V> weakReference = this.r;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z2) {
                    if (this.y == null) {
                        this.y = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.r.get()) {
                        if (!z2) {
                            Map<View, Integer> map = this.y;
                            if (map != null && map.containsKey(childAt)) {
                                t.d(childAt, this.y.get(childAt).intValue());
                            }
                        } else {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            t.d(childAt, 4);
                        }
                    }
                }
                if (!z2) {
                    this.y = null;
                }
            }
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        if (t.h(coordinatorLayout) && !t.h(v2)) {
            v2.setFitsSystemWindows(true);
        }
        int top = v2.getTop();
        coordinatorLayout.c((View) v2, i2);
        this.q = coordinatorLayout.getHeight();
        if (this.d) {
            if (this.e == 0) {
                this.e = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            }
            this.f = Math.max(this.e, this.q - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f = this.f2077c;
        }
        this.g = Math.max(0, this.q - v2.getHeight());
        this.h = this.q / 2;
        b();
        int i3 = this.l;
        if (i3 == 3) {
            t.b((View) v2, c());
        } else if (i3 == 6) {
            t.b((View) v2, this.h);
        } else if (!this.j || i3 != 5) {
            int i4 = this.l;
            if (i4 == 4) {
                t.b((View) v2, this.i);
            } else if (i4 == 1 || i4 == 2) {
                t.b((View) v2, top - v2.getTop());
            }
        } else {
            t.b((View) v2, this.q);
        }
        if (this.m == null) {
            this.m = g.a_shaKey_method2((ViewGroup) coordinatorLayout, this.z);
        }
        this.r = new WeakReference<>(v2);
        this.s = new WeakReference<>(a((View) v2));
        return true;
    }

    /* access modifiers changed from: private */
    public int c() {
        if (this.f2075a) {
            return this.g;
        }
        return 0;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.o = 0;
        this.p = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.d
            if (r4 != 0) goto L_0x0015
            r3.d = r0
            goto L_0x0024
        L_0x000c:
            boolean r2 = r3.d
            if (r2 != 0) goto L_0x0017
            int r2 = r3.f2077c
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0024
        L_0x0017:
            r3.d = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.f2077c = r1
            int r1 = r3.q
            int r1 = r1 - r4
            r3.i = r1
        L_0x0024:
            if (r0 == 0) goto L_0x003a
            int r4 = r3.l
            r0 = 4
            if (r4 != r0) goto L_0x003a
            java.lang.ref.WeakReference<V> r4 = r3.r
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x003a
            r4.requestLayout()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.b(int):void");
    }

    public void b(boolean z2) {
        this.j = z2;
    }

    private void b() {
        if (this.f2075a) {
            this.i = Math.max(this.q - this.f, this.g);
        } else {
            this.i = this.q - this.f;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r9, V r10, android.view.MotionEvent r11) {
        /*
            r8 = this;
            boolean r0 = r10.isShown()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r8.n = r2
            return r1
        L_0x000b:
            int r0 = r11.getActionMasked()
            if (r0 != 0) goto L_0x0014
            r8.e()
        L_0x0014:
            android.view.VelocityTracker r3 = r8.u
            if (r3 != 0) goto L_0x001e
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r8.u = r3
        L_0x001e:
            android.view.VelocityTracker r3 = r8.u
            r3.addMovement(r11)
            r3 = 0
            r4 = -1
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x002d
            r10 = 3
            if (r0 == r10) goto L_0x002d
            goto L_0x0077
        L_0x002d:
            r8.x = r1
            r8.v = r4
            boolean r10 = r8.n
            if (r10 == 0) goto L_0x0077
            r8.n = r1
            return r1
        L_0x0038:
            float r5 = r11.getX()
            int r5 = (int) r5
            float r6 = r11.getY()
            int r6 = (int) r6
            r8.w = r6
            java.lang.ref.WeakReference<android.view.View> r6 = r8.s
            if (r6 == 0) goto L_0x004f
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L_0x0050
        L_0x004f:
            r6 = r3
        L_0x0050:
            if (r6 == 0) goto L_0x0066
            int r7 = r8.w
            boolean r6 = r9.a((android.view.View) r6, (int) r5, (int) r7)
            if (r6 == 0) goto L_0x0066
            int r6 = r11.getActionIndex()
            int r6 = r11.getPointerId(r6)
            r8.v = r6
            r8.x = r2
        L_0x0066:
            int r6 = r8.v
            if (r6 != r4) goto L_0x0074
            int r4 = r8.w
            boolean r10 = r9.a((android.view.View) r10, (int) r5, (int) r4)
            if (r10 != 0) goto L_0x0074
            r10 = 1
            goto L_0x0075
        L_0x0074:
            r10 = 0
        L_0x0075:
            r8.n = r10
        L_0x0077:
            boolean r10 = r8.n
            if (r10 != 0) goto L_0x0086
            androidx.customview.a.g r10 = r8.m
            if (r10 == 0) goto L_0x0086
            boolean r10 = r10.b((android.view.MotionEvent) r11)
            if (r10 == 0) goto L_0x0086
            return r2
        L_0x0086:
            java.lang.ref.WeakReference<android.view.View> r10 = r8.s
            if (r10 == 0) goto L_0x0091
            java.lang.Object r10 = r10.get()
            r3 = r10
            android.view.View r3 = (android.view.View) r3
        L_0x0091:
            r10 = 2
            if (r0 != r10) goto L_0x00ca
            if (r3 == 0) goto L_0x00ca
            boolean r10 = r8.n
            if (r10 != 0) goto L_0x00ca
            int r10 = r8.l
            if (r10 == r2) goto L_0x00ca
            float r10 = r11.getX()
            int r10 = (int) r10
            float r0 = r11.getY()
            int r0 = (int) r0
            boolean r9 = r9.a((android.view.View) r3, (int) r10, (int) r0)
            if (r9 != 0) goto L_0x00ca
            androidx.customview.a.g r9 = r8.m
            if (r9 == 0) goto L_0x00ca
            int r9 = r8.w
            float r9 = (float) r9
            float r10 = r11.getY()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            androidx.customview.a.g r10 = r8.m
            int r10 = r10.e()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ca
            r1 = 1
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == ((View) this.s.get())) {
            int top = v2.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < c()) {
                    iArr[1] = top - c();
                    t.b((View) v2, -iArr[1]);
                    c(3);
                } else {
                    iArr[1] = i3;
                    t.b((View) v2, -i3);
                    c(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.i;
                if (i5 <= i6 || this.j) {
                    iArr[1] = i3;
                    t.b((View) v2, -i3);
                    c(1);
                } else {
                    iArr[1] = top - i6;
                    t.b((View) v2, -iArr[1]);
                    c(4);
                }
            }
            a(v2.getTop());
            this.o = i3;
            this.p = true;
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v2.getTop() == c()) {
            c(3);
        } else if (view == this.s.get() && this.p) {
            if (this.o > 0) {
                i3 = c();
            } else if (!this.j || !a_shaKey_method2(v2, d())) {
                if (this.o == 0) {
                    int top = v2.getTop();
                    if (!this.f2075a) {
                        int i6 = this.h;
                        if (top < i6) {
                            if (top < Math.abs(top - this.i)) {
                                i3 = 0;
                            } else {
                                i3 = this.h;
                            }
                        } else if (Math.abs(top - i6) < Math.abs(top - this.i)) {
                            i3 = this.h;
                        } else {
                            i4 = this.i;
                        }
                        i5 = 6;
                    } else if (Math.abs(top - this.g) < Math.abs(top - this.i)) {
                        i3 = this.g;
                    } else {
                        i4 = this.i;
                    }
                } else {
                    i4 = this.i;
                }
                i5 = 4;
            } else {
                i3 = this.q;
                i5 = 5;
            }
            if (this.m.b((View) v2, v2.getLeft(), i3)) {
                c(2);
                t.a_shaKey_method2((View) v2, (Runnable) new b(v2, i5));
            } else {
                c(i5);
            }
            this.p = false;
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        return view == this.s.get() && (this.l != 3 || super.a(coordinatorLayout, v2, view, f2, f3));
    }

    public void a(boolean z2) {
        if (this.f2075a != z2) {
            this.f2075a = z2;
            if (this.r != null) {
                b();
            }
            c((!this.f2075a || this.l != 6) ? this.l : 3);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, float f2) {
        if (this.k) {
            return true;
        }
        if (view.getTop() >= this.i && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.i)) / ((float) this.f2077c) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View a(View view) {
        if (t.A(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View a2 = a(viewGroup.getChildAt(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a aVar;
        View view = (View) this.r.get();
        if (view != null && (aVar = this.t) != null) {
            int i3 = this.i;
            if (i2 > i3) {
                aVar.a_shaKey_method2(view, ((float) (i3 - i2)) / ((float) (this.q - i3)));
            } else {
                aVar.a_shaKey_method2(view, ((float) (i3 - i2)) / ((float) (i3 - c())));
            }
        }
    }
}
