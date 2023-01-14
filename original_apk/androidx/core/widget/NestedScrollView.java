package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.h.C0083a;
import androidx.core.h.a.c;
import androidx.core.h.a.e;
import androidx.core.h.i;
import androidx.core.h.k;
import androidx.core.h.l;
import androidx.core.h.n;
import androidx.core.h.q;
import androidx.core.h.t;
import java.util.ArrayList;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public class NestedScrollView extends FrameLayout implements l, i, q {

    /* renamed from: a  reason: collision with root package name */
    private static final a f728a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f729b = {16843130};

    /* renamed from: c  reason: collision with root package name */
    private long f730c;
    private final Rect d;
    private OverScroller e;
    private EdgeEffect f;
    private EdgeEffect g;
    private int h;
    private boolean i;
    private boolean j;
    private View k;
    private boolean l;
    private VelocityTracker m;
    private int mTouchSlop;
    private float mVerticalScrollFactor;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private final int[] s;
    private final int[] t;
    private int u;
    private int v;
    private SavedState w;
    private final n x;
    private final k y;
    private b z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new j();

        /* renamed from: a  reason: collision with root package name */
        public int f731a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f731a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f731a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f731a = parcel.readInt();
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 >= i4 || i2 < 0) {
            return 0;
        }
        return i3 + i2 > i4 ? i4 - i3 : i2;
    }

    private boolean b(int i2, int i3, int i4) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i2 == 33;
        View a2 = a(z3, i3, i4);
        if (a2 == null) {
            a2 = this;
        }
        if (i3 < scrollY || i4 > i5) {
            g(z3 ? i3 - scrollY : i4 - i5);
            z2 = true;
        }
        if (a2 != findFocus()) {
            a2.requestFocus(i2);
        }
        return z2;
    }

    private boolean d(int i2, int i3) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i3 < childAt.getTop() - scrollY || i3 >= childAt.getBottom() - scrollY || i2 < childAt.getLeft() || i2 >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void f() {
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
    }

    private void g() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    private void h(int i2) {
        int scrollY = getScrollY();
        boolean z2 = (scrollY > 0 || i2 > 0) && (scrollY < getScrollRange() || i2 < 0);
        float f2 = (float) i2;
        if (!dispatchNestedPreFling(0.0f, f2)) {
            dispatchNestedFling(0.0f, f2, z2);
            c(i2);
        }
    }

    public void a(int i2) {
        this.y.c(i2);
    }

    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public boolean c(int i2, int i3) {
        return this.y.a(i2, i3);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.e.computeScrollOffset()) {
            this.e.getCurrX();
            int currY = this.e.getCurrY();
            int i2 = currY - this.v;
            if (a(0, i2, this.t, (int[]) null, 1)) {
                i2 -= this.t[1];
            }
            int i3 = i2;
            if (i3 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i4 = scrollY;
                a(0, i3, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - i4;
                if (!a(0, scrollY2, 0, i3 - scrollY2, (int[]) null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                        c();
                        if (currY <= 0 && i4 > 0) {
                            this.f.onAbsorb((int) this.e.getCurrVelocity());
                        } else if (currY >= scrollRange && i4 < scrollRange) {
                            this.g.onAbsorb((int) this.e.getCurrVelocity());
                        }
                    }
                }
            }
            this.v = currY;
            t.C(this);
            return;
        }
        if (e(1)) {
            a(1);
        }
        this.v = 0;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.y.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.y.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return a(i2, i3, i4, i5, iArr, 0);
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f != null) {
            int scrollY = getScrollY();
            int i3 = 0;
            if (!this.f.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i2 = getPaddingLeft() + 0;
                } else {
                    i2 = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate((float) i2, (float) min);
                this.f.setSize(width, height);
                if (this.f.draw(canvas)) {
                    t.C(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.g.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i3 = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate((float) (i3 - width2), (float) max);
                canvas.rotate(180.0f, (float) width2, 0.0f);
                this.g.setSize(width2, height2);
                if (this.g.draw(canvas)) {
                    t.C(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    public boolean e(int i2) {
        return this.y.a(i2);
    }

    /* access modifiers changed from: protected */
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    /* access modifiers changed from: package-private */
    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return e(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.y.b();
    }

    /* access modifiers changed from: protected */
    public void measureChild(View view, int i2, int i3) {
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    /* access modifiers changed from: protected */
    public void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.l) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    verticalScrollFactorCompat = 0;
                } else if (verticalScrollFactorCompat > scrollRange) {
                    verticalScrollFactorCompat = scrollRange;
                }
                if (verticalScrollFactorCompat != scrollY) {
                    super.scrollTo(getScrollX(), verticalScrollFactorCompat);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.l) {
            return true;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    int i3 = this.r;
                    if (i3 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.h) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.l = true;
                                this.h = y2;
                                f();
                                this.m.addMovement(motionEvent);
                                this.u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i2 != 3) {
                    if (i2 == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.l = false;
            this.r = -1;
            g();
            if (this.e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                t.C(this);
            }
            a(0);
        } else {
            int y3 = (int) motionEvent.getY();
            if (!d((int) motionEvent.getX(), y3)) {
                this.l = false;
                g();
            } else {
                this.h = y3;
                this.r = motionEvent.getPointerId(0);
                d();
                this.m.addMovement(motionEvent);
                this.e.computeScrollOffset();
                this.l = !this.e.isFinished();
                c(2, 0);
            }
        }
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.i = false;
        View view = this.k;
        if (view != null && a_shaKey_method2(view, (View) this)) {
            b(this.k);
        }
        this.k = null;
        if (!this.j) {
            if (this.w != null) {
                scrollTo(getScrollX(), this.w.f731a);
                this.w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int a2 = a(scrollY, paddingTop, i6);
            if (a2 != scrollY) {
                scrollTo(getScrollX(), a2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.j = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.n && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        h((int) f3);
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
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
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view != null && !a(view)) {
            return view.requestFocus(i2, rect);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.w = savedState;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f731a = getScrollY();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        b bVar = this.z;
        if (bVar != null) {
            bVar.a(this, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && a(findFocus, 0, i5)) {
            findFocus.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(findFocus, this.d);
            g(a(this.d));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return b(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        a_shaKey_method2(view, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        MotionEvent motionEvent2 = motionEvent;
        f();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.u = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.m;
                velocityTracker.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND, (float) this.q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.r);
                if (Math.abs(yVelocity) > this.p) {
                    h(-yVelocity);
                } else if (this.e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    t.C(this);
                }
                this.r = -1;
                b();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent2.findPointerIndex(this.r);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.r + " in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent2.getY(findPointerIndex);
                    int i2 = this.h - y2;
                    if (a(0, i2, this.t, this.s, 0)) {
                        i2 -= this.t[1];
                        obtain.offsetLocation(0.0f, (float) this.s[1]);
                        this.u += this.s[1];
                    }
                    if (!this.l && Math.abs(i2) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.l = true;
                        if (i2 > 0) {
                            i2 -= this.mTouchSlop;
                        } else {
                            i2 += this.mTouchSlop;
                        }
                    }
                    int i3 = i2;
                    if (this.l) {
                        this.h = y2 - this.s[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        int i4 = scrollRange;
                        int i5 = i3;
                        int i6 = findPointerIndex;
                        if (a(0, i3, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !e(0)) {
                            this.m.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (a(0, scrollY2, 0, i5 - scrollY2, this.s, 0)) {
                            int i7 = this.h;
                            int[] iArr = this.s;
                            this.h = i7 - iArr[1];
                            obtain.offsetLocation(0.0f, (float) iArr[1]);
                            this.u += this.s[1];
                        } else if (z2) {
                            c();
                            int i8 = scrollY + i5;
                            if (i8 < 0) {
                                f.a(this.f, ((float) i5) / ((float) getHeight()), motionEvent2.getX(i6) / ((float) getWidth()));
                                if (!this.g.isFinished()) {
                                    this.g.onRelease();
                                }
                            } else {
                                int i9 = i6;
                                if (i8 > i4) {
                                    f.a(this.g, ((float) i5) / ((float) getHeight()), 1.0f - (motionEvent2.getX(i9) / ((float) getWidth())));
                                    if (!this.f.isFinished()) {
                                        this.f.onRelease();
                                    }
                                }
                            }
                            EdgeEffect edgeEffect = this.f;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.g.isFinished())) {
                                t.C(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.l && getChildCount() > 0 && this.e.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    t.C(this);
                }
                this.r = -1;
                b();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.h = (int) motionEvent2.getY(actionIndex);
                this.r = motionEvent2.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
                this.h = (int) motionEvent2.getY(motionEvent2.findPointerIndex(this.r));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z3 = !this.e.isFinished();
            this.l = z3;
            if (z3 && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.e.isFinished()) {
                this.e.abortAnimation();
            }
            this.h = (int) motionEvent.getY();
            this.r = motionEvent2.getPointerId(0);
            c(2, 0);
        }
        VelocityTracker velocityTracker2 = this.m;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.i) {
            b(view2);
        } else {
            this.k = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a_shaKey_method2(rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            g();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    public void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int a2 = a(i2, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int a3 = a(i3, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (a2 != getScrollX() || a3 != getScrollY()) {
                super.scrollTo(a2, a3);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.n) {
            this.n = z2;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.y.a(z2);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.z = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.o = z2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i2) {
        return c(i2, 0);
    }

    public void stopNestedScroll() {
        a(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        this.e = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return this.y.a(i2, i3, i4, i5, iArr, i6);
    }

    public void c(int i2) {
        if (getChildCount() > 0) {
            c(2, 1);
            this.e.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.v = getScrollY();
            t.C(this);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.d = new Rect();
        this.i = true;
        this.j = false;
        this.k = null;
        this.l = false;
        this.o = true;
        this.r = -1;
        this.s = new int[2];
        this.t = new int[2];
        e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f729b, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.x = new n(this);
        this.y = new k(this);
        setNestedScrollingEnabled(true);
        t.a_shaKey_method2((View) this, (C0083a) f728a);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.y.a(i2, i3, iArr, iArr2, i4);
    }

    public boolean f(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        if (z2) {
            this.d.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.d;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.d.top = getScrollY() - height;
            Rect rect2 = this.d;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.d;
        int i3 = rect3.top;
        rect3.bottom = height + i3;
        return b(i2, i3, rect3.bottom);
    }

    private void g(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.o) {
            a(0, i2);
        } else {
            scrollBy(0, i2);
        }
    }

    public void a(View view, View view2, int i2, int i3) {
        this.x.a(view, view2, i2, i3);
        c(2, i3);
    }

    public void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void a(View view, int i2) {
        this.x.a_shaKey_method2(view, i2);
        a(i2);
    }

    public boolean b(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(findNextFocus, this.d);
            g(a(this.d));
            findNextFocus.requestFocus(i2);
        }
        if (findFocus == null || !findFocus.isFocused() || !a(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    private void c() {
        if (getOverScrollMode() == 2) {
            this.f = null;
            this.g = null;
        } else if (this.f == null) {
            Context context = getContext();
            this.f = new EdgeEffect(context);
            this.g = new EdgeEffect(context);
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    private void d() {
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker == null) {
            this.m = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        a(0, scrollY2, 0, i5 - scrollY2, (int[]) null, i6);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean d(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.d;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.d.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.d;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.d;
        return b(i2, rect3.top, rect3.bottom);
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        a(i2, i3, iArr, (int[]) null, i4);
    }

    private boolean a() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return true;
        }
        return false;
    }

    static class a extends C0083a {
        a() {
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i == 4096) {
                int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (min == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.b(0, min);
                return true;
            } else if (i != 8192) {
                return false;
            } else {
                int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (max == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.b(0, max);
                return true;
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            e.a_shaKey_method2(accessibilityEvent, nestedScrollView.getScrollX());
            e.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public void a(View view, c cVar) {
            int scrollRange;
            super.a_shaKey_method2(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.a((CharSequence) ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                cVar.k(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.a((int) CpioConstants.C_ISCHR);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    cVar.a((int) CpioConstants.C_ISFIFO);
                }
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        this.d.setEmpty();
        int i2 = 130;
        if (!a()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i2 = 33;
                    }
                    f(i2);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return b(130);
                } else {
                    return d(130);
                }
            } else if (!keyEvent.isAltPressed()) {
                return b(33);
            } else {
                return d(33);
            }
        }
    }

    public final void b(int i2, int i3) {
        a_shaKey_method2(i2 - getScrollX(), i3 - getScrollY());
    }

    private void b(View view) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        int a2 = a(this.d);
        if (a2 != 0) {
            scrollBy(0, a2);
        }
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.h = (int) motionEvent.getY(i2);
            this.r = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void b() {
        this.l = false;
        g();
        a(0);
        EdgeEffect edgeEffect = this.f;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.g.onRelease();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x002a
            if (r1 != r5) goto L_0x0028
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = 1
        L_0x002b:
            if (r1 == 0) goto L_0x0034
            if (r1 != r5) goto L_0x0032
            if (r3 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            int r3 = r15 + r13
            if (r2 != 0) goto L_0x003b
            r2 = 0
            goto L_0x003d
        L_0x003b:
            r2 = r19
        L_0x003d:
            int r6 = r16 + r14
            if (r1 != 0) goto L_0x0043
            r1 = 0
            goto L_0x0045
        L_0x0043:
            r1 = r20
        L_0x0045:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L_0x0050
            r7 = r2
        L_0x004e:
            r2 = 1
            goto L_0x0055
        L_0x0050:
            if (r3 >= r7) goto L_0x0053
            goto L_0x004e
        L_0x0053:
            r7 = r3
            r2 = 0
        L_0x0055:
            if (r6 <= r1) goto L_0x005a
            r6 = r1
        L_0x0058:
            r1 = 1
            goto L_0x005f
        L_0x005a:
            if (r6 >= r8) goto L_0x005e
            r6 = r8
            goto L_0x0058
        L_0x005e:
            r1 = 0
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            boolean r3 = r12.e(r5)
            if (r3 != 0) goto L_0x007e
            android.widget.OverScroller r3 = r0.e
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r3
            r14 = r7
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L_0x007e:
            r12.onOverScrolled(r7, r6, r2, r1)
            if (r2 != 0) goto L_0x0085
            if (r1 == 0) goto L_0x0086
        L_0x0085:
            r4 = 1
        L_0x0086:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.a(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    private View a(boolean z2, int i2, int i3) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4) {
                            if (!z5) {
                            }
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (!z5) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i2, int i3) {
        view.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(view, this.d);
        return this.d.bottom + i2 >= getScrollY() && this.d.top - i2 <= getScrollY() + i3;
    }

    public final void a(int i2, int i3) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f730c > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                this.v = getScrollY();
                OverScroller overScroller = this.e;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY);
                t.C(this);
            } else {
                if (!this.e.isFinished()) {
                    this.e.abortAnimation();
                }
                scrollBy(i2, i3);
            }
            this.f730c = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private boolean a(Rect rect, boolean z2) {
        int a2 = a(rect);
        boolean z3 = a2 != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, a2);
            } else {
                a(0, a2);
            }
        }
        return z3;
    }

    /* access modifiers changed from: protected */
    public int a(Rect rect) {
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        if (rect.bottom > i5 && rect.top > scrollY) {
            if (rect.height() > height) {
                i3 = rect.top - scrollY;
            } else {
                i3 = rect.bottom - i5;
            }
            return Math.min(i3 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        } else if (rect.top >= scrollY || rect.bottom >= i5) {
            return 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i5 - rect.bottom);
            } else {
                i2 = 0 - (scrollY - rect.top);
            }
            return Math.max(i2, -getScrollY());
        }
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !a_shaKey_method2((View) parent, view2)) {
            return false;
        }
        return true;
    }
}
