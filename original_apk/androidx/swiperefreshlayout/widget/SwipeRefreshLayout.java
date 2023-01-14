package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.h.j;
import androidx.core.h.k;
import androidx.core.h.m;
import androidx.core.h.n;
import androidx.core.h.t;
import androidx.core.widget.i;

public class SwipeRefreshLayout extends ViewGroup implements m, j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1162a = "SwipeRefreshLayout";

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1163b = {16842766};
    int A;
    int B;
    d C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    private Animation H;
    boolean I;
    private int J;
    boolean K;
    private a L;
    private Animation.AnimationListener M;
    private final Animation N;
    private final Animation O;

    /* renamed from: c  reason: collision with root package name */
    private View f1164c;
    b d;
    boolean e;
    private float f;
    private float g;
    private final n h;
    private final k i;
    private final int[] j;
    private final int[] k;
    private boolean l;
    private int m;
    private int mTouchSlop;
    int n;
    private float o;
    private float p;
    private boolean q;
    private int r;
    boolean s;
    private boolean t;
    private final DecelerateInterpolator u;
    a v;
    private int w;
    protected int x;
    float y;
    protected int z;

    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface b {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(boolean z2, boolean z3) {
        if (this.e != z2) {
            this.I = z3;
            d();
            this.e = z2;
            if (this.e) {
                a_shaKey_method2(this.n, this.M);
            } else {
                a(this.M);
            }
        }
    }

    private void c() {
        this.v = new a(getContext(), -328966);
        this.C = new d(getContext());
        this.C.a(1);
        this.v.setImageDrawable(this.C);
        this.v.setVisibility(8);
        addView(this.v);
    }

    private void d() {
        if (this.f1164c == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.v)) {
                    this.f1164c = childAt;
                    return;
                }
            }
        }
    }

    private void e() {
        this.G = a(this.C.getAlpha(), 255);
    }

    private void f() {
        this.F = a(this.C.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i2) {
        this.v.getBackground().setAlpha(i2);
        this.C.setAlpha(i2);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.v.clearAnimation();
        this.C.stop();
        this.v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.z - this.n);
        }
        this.n = this.v.getTop();
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.i.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.i.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.i.a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.i.a(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.w;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        return i3 >= i4 ? i3 + 1 : i3;
    }

    public int getNestedScrollAxes() {
        return this.h.a();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.z;
    }

    public boolean hasNestedScrollingParent() {
        return this.i.a();
    }

    public boolean isNestedScrollingEnabled() {
        return this.i.b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d();
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.e || this.l) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.r;
                    if (i2 == -1) {
                        Log.e(f1162a, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.q = false;
            this.r = -1;
        } else {
            setTargetOffsetTopAndBottom(this.z - this.v.getTop());
            this.r = motionEvent.getPointerId(0);
            this.q = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.p = motionEvent.getY(findPointerIndex2);
        }
        return this.q;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1164c == null) {
                d();
            }
            View view = this.f1164c;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.v.getMeasuredWidth();
                int measuredHeight2 = this.v.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.n;
                this.v.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1164c == null) {
            d();
        }
        View view = this.f1164c;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.v.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
            this.w = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.v) {
                    this.w = i4;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.g;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.g = 0.0f;
                } else {
                    this.g = f2 - f3;
                    iArr[1] = i3;
                }
                c(this.g);
            }
        }
        if (this.K && i3 > 0 && this.g == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.v.setVisibility(8);
        }
        int[] iArr2 = this.j;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.k);
        int i6 = i5 + this.k[1];
        if (i6 < 0 && !a()) {
            this.g += (float) Math.abs(i6);
            c(this.g);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.h.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.g = 0.0f;
        this.l = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.t && !this.e && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.h.a(view);
        this.l = false;
        float f2 = this.g;
        if (f2 > 0.0f) {
            b(f2);
            this.g = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.e || this.l) {
            return false;
        }
        if (actionMasked == 0) {
            this.r = motionEvent.getPointerId(0);
            this.q = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex < 0) {
                Log.e(f1162a, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.q) {
                this.q = false;
                b((motionEvent.getY(findPointerIndex) - this.o) * 0.5f);
            }
            this.r = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.r);
            if (findPointerIndex2 < 0) {
                Log.e(f1162a, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            d(y2);
            if (this.q) {
                float f2 = (y2 - this.o) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                c(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f1162a, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f1164c instanceof AbsListView)) {
            View view = this.f1164c;
            if (view == null || t.A(view)) {
                super.requestDisallowInterceptTouchEvent(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f2) {
        this.v.setScaleX(f2);
        this.v.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        d();
        this.C.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.a.a_shaKey_method2(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f = (float) i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            b();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.i.a(z2);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.L = aVar;
    }

    public void setOnRefreshListener(b bVar) {
        this.d = bVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.v.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.a_shaKey_method2(getContext(), i2));
    }

    public void setRefreshing(boolean z2) {
        int i2;
        if (!z2 || this.e == z2) {
            a(z2, false);
            return;
        }
        this.e = z2;
        if (!this.K) {
            i2 = this.A + this.z;
        } else {
            i2 = this.A;
        }
        setTargetOffsetTopAndBottom(i2 - this.n);
        this.I = false;
        b(this.M);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.v.setImageDrawable((Drawable) null);
            this.C.a(i2);
            this.v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.B = i2;
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.v.bringToFront();
        t.b((View) this.v, i2);
        this.n = this.v.getTop();
    }

    public boolean startNestedScroll(int i2) {
        return this.i.b(i2);
    }

    public void stopNestedScroll() {
        this.i.c();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.f = -1.0f;
        this.j = new int[2];
        this.k = new int[2];
        this.r = -1;
        this.w = -1;
        this.M = new e(this);
        this.N = new j(this);
        this.O = new k(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.m = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        this.A = (int) (displayMetrics.density * 64.0f);
        this.f = (float) this.A;
        this.h = new n(this);
        this.i = new k(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.J;
        this.n = i2;
        this.z = i2;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1163b);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void d(float f2) {
        float f3 = this.p;
        int i2 = this.mTouchSlop;
        if (f2 - f3 > ((float) i2) && !this.q) {
            this.o = f3 + ((float) i2);
            this.q = true;
            this.C.setAlpha(76);
        }
    }

    private void c(float f2) {
        this.C.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f));
        double d2 = (double) min;
        Double.isNaN(d2);
        float max = (((float) Math.max(d2 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f;
        int i2 = this.B;
        if (i2 <= 0) {
            i2 = this.K ? this.A - this.z : this.A;
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * 2.0f;
        int i3 = this.z + ((int) ((f3 * min) + (f3 * f4 * 2.0f)));
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (!this.s) {
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        if (this.s) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f));
        }
        if (f2 < this.f) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                f();
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            e();
        }
        this.C.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.a(Math.min(1.0f, max));
        this.C.b((((max * 0.4f) - 16.0f) + (f4 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.n);
    }

    /* access modifiers changed from: package-private */
    public void a(Animation.AnimationListener animationListener) {
        this.E = new g(this);
        this.E.setDuration(150);
        this.v.a(animationListener);
        this.v.clearAnimation();
        this.v.startAnimation(this.E);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.v.setVisibility(0);
        this.C.setAlpha(255);
        this.D = new f(this);
        this.D.setDuration((long) this.m);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.D);
    }

    private Animation a(int i2, int i3) {
        h hVar = new h(this, i2, i3);
        hVar.setDuration(300);
        this.v.a((Animation.AnimationListener) null);
        this.v.clearAnimation();
        this.v.startAnimation(hVar);
        return hVar;
    }

    private void b(float f2) {
        if (f2 > this.f) {
            a(true, true);
            return;
        }
        this.e = false;
        this.C.a(0.0f, 0.0f);
        i iVar = null;
        if (!this.s) {
            iVar = new i(this);
        }
        b(this.n, iVar);
        this.C.a(false);
    }

    public boolean a() {
        a aVar = this.L;
        if (aVar != null) {
            return aVar.a_shaKey_method2(this, this.f1164c);
        }
        View view = this.f1164c;
        if (view instanceof ListView) {
            return i.a_shaKey_method2((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    private boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.N.reset();
        this.N.setDuration(200);
        this.N.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.N);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.s) {
            c(i2, animationListener);
            return;
        }
        this.x = i2;
        this.O.reset();
        this.O.setDuration(200);
        this.O.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.O);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        int i2 = this.x;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.z - i2)) * f2))) - this.v.getTop());
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.y = this.v.getScaleX();
        this.H = new l(this);
        this.H.setDuration(150);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.H);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
