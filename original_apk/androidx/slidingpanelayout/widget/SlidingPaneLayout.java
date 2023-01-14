package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0083a;
import androidx.core.h.t;
import androidx.customview.a.g;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f1151a;

    /* renamed from: b  reason: collision with root package name */
    private int f1152b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f1153c;
    private Drawable d;
    private final int e;
    private boolean f;
    View g;
    float h;
    private float i;
    int j;
    boolean k;
    private int l;
    private float m;
    private Field mRecreateDisplayList;
    private float n;
    private d o;
    final g p;
    boolean q;
    private boolean r;
    private final Rect s;
    final ArrayList<b> t;
    private Method u;
    private boolean v;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f1157c;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1157c ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1157c = parcel.readInt() != 0;
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f1159a;

        b(View view) {
            this.f1159a = view;
        }

        public void run() {
            if (this.f1159a.getParent() == SlidingPaneLayout.this) {
                this.f1159a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.d(this.f1159a);
            }
            SlidingPaneLayout.this.t.remove(this);
        }
    }

    private class c extends g.a {
        c() {
        }

        public void a(View view, int i) {
            SlidingPaneLayout.this.f();
        }

        public boolean b(View view, int i) {
            if (SlidingPaneLayout.this.k) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f1156c;
        }

        public void c(int i) {
            if (SlidingPaneLayout.this.p.f() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.h == 0.0f) {
                    slidingPaneLayout.f(slidingPaneLayout.g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.a(slidingPaneLayout2.g);
                    SlidingPaneLayout.this.q = false;
                    return;
                }
                slidingPaneLayout.b(slidingPaneLayout.g);
                SlidingPaneLayout.this.q = true;
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.a(i);
            SlidingPaneLayout.this.invalidate();
        }

        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        public void a(View view, float f, float f2) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.b()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.j;
                }
                i = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.g.getWidth();
            } else {
                i = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.h > 0.5f)) {
                    i += SlidingPaneLayout.this.j;
                }
            }
            SlidingPaneLayout.this.p.d(i, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public int a(View view) {
            return SlidingPaneLayout.this.j;
        }

        public int a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.g.getLayoutParams();
            if (SlidingPaneLayout.this.b()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.g.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.j + paddingLeft);
        }

        public void a(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.p.a_shaKey_method2(slidingPaneLayout.g, i2);
        }
    }

    public interface d {
        void a(View view);

        void a(View view, float f);

        void b(View view);
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static boolean g(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.a(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        d dVar = this.o;
        if (dVar != null) {
            dVar.a_shaKey_method2(view, this.h);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.p.a(true)) {
            return;
        }
        if (!this.f) {
            this.p.a();
        } else {
            t.C(this);
        }
    }

    public boolean d() {
        return this.f;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        int i2;
        int i3;
        super.draw(canvas);
        if (b()) {
            drawable = this.d;
        } else {
            drawable = this.f1153c;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (b()) {
                i3 = childAt.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f && !layoutParams.f1156c && this.g != null) {
            canvas.getClipBounds(this.s);
            if (b()) {
                Rect rect = this.s;
                rect.left = Math.max(rect.left, this.g.getRight());
            } else {
                Rect rect2 = this.s;
                rect2.right = Math.min(rect2.right, this.g.getLeft());
            }
            canvas.clipRect(this.s);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public boolean e() {
        return b(this.g, 0);
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        View view2 = view;
        boolean b2 = b();
        int width = b2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = b2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !g(view)) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt != view2) {
                if (childAt.getVisibility() == 8) {
                    z = b2;
                } else {
                    int max = Math.max(b2 ? paddingLeft : width, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    if (b2) {
                        z = b2;
                        i6 = width;
                    } else {
                        z = b2;
                        i6 = paddingLeft;
                    }
                    childAt.setVisibility((max < i5 || max2 < i3 || Math.min(i6, childAt.getRight()) > i4 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
                }
                i7++;
                view2 = view;
                b2 = z;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f1152b;
    }

    public int getParallaxDistance() {
        return this.l;
    }

    public int getSliderFadeColor() {
        return this.f1151a;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
        int size = this.t.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.t.get(i2).run();
        }
        this.t.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.q = !this.p.a(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f || (this.k && actionMasked != 0)) {
            this.p.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.p.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.k = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.m = x;
                this.n = y;
                if (this.p.a(this.g, (int) x, (int) y) && e(this.g)) {
                    z = true;
                    if (this.p.b(motionEvent) && !z) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.m);
                float abs2 = Math.abs(y2 - this.n);
                if (abs > ((float) this.p.e()) && abs2 > abs) {
                    this.p.b();
                    this.k = true;
                    return false;
                }
            }
            z = false;
            return this.p.b(motionEvent) ? true : true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean b2 = b();
        if (b2) {
            this.p.d(2);
        } else {
            this.p.d(1);
        }
        int i11 = i4 - i2;
        int paddingRight = b2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = b2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.r) {
            this.h = (!this.f || !this.q) ? 0.0f : 1.0f;
        }
        int i12 = paddingRight;
        int i13 = i12;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f1156c) {
                    int i15 = i11 - paddingLeft;
                    int min = (Math.min(i12, i15 - this.e) - i13) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.j = min;
                    int i16 = b2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.d = ((i13 + i16) + min) + (measuredWidth / 2) > i15;
                    int i17 = (int) (((float) min) * this.h);
                    i7 = i16 + i17 + i13;
                    this.h = ((float) i17) / ((float) this.j);
                    i6 = 0;
                } else if (!this.f || (i10 = this.l) == 0) {
                    i7 = i12;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.h) * ((float) i10));
                    i7 = i12;
                }
                if (b2) {
                    i8 = (i11 - i7) + i6;
                    i9 = i8 - measuredWidth;
                } else {
                    i9 = i7 - i6;
                    i8 = i9 + measuredWidth;
                }
                childAt.layout(i9, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                i12 += childAt.getWidth();
                i13 = i7;
            }
        }
        if (this.r) {
            if (this.f) {
                if (this.l != 0) {
                    a(this.h);
                }
                if (((LayoutParams) this.g.getLayoutParams()).d) {
                    a(this.g, this.h, this.f1151a);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    a(getChildAt(i18), 0.0f, this.f1151a);
                }
            }
            f(this.g);
        }
        this.r = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (mode != Integer.MIN_VALUE && mode == 0) {
                size = 300;
            }
        } else if (mode2 == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (mode2 == 0) {
                mode2 = Integer.MIN_VALUE;
                size2 = 300;
            }
        }
        boolean z = false;
        if (mode2 == Integer.MIN_VALUE) {
            i4 = (size2 - getPaddingTop()) - getPaddingBottom();
            i5 = 0;
        } else if (mode2 != 1073741824) {
            i5 = 0;
            i4 = 0;
        } else {
            i5 = (size2 - getPaddingTop()) - getPaddingBottom();
            i4 = i5;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.g = null;
        int i14 = i5;
        int i15 = paddingLeft;
        int i16 = 0;
        boolean z2 = false;
        float f2 = 0.0f;
        while (true) {
            i6 = 8;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.d = z;
            } else {
                float f3 = layoutParams.f1155b;
                if (f3 > 0.0f) {
                    f2 += f3;
                    if (layoutParams.width == 0) {
                    }
                }
                int i17 = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    i12 = View.MeasureSpec.makeMeasureSpec(paddingLeft - i17, 1073741824);
                } else {
                    i12 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i13 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                } else {
                    i13 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(i12, i13);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (mode2 == Integer.MIN_VALUE && measuredHeight > i14) {
                    i14 = Math.min(measuredHeight, i4);
                }
                i15 -= measuredWidth;
                boolean z3 = i15 < 0;
                layoutParams.f1156c = z3;
                boolean z4 = z3 | z2;
                if (layoutParams.f1156c) {
                    this.g = childAt;
                }
                z2 = z4;
            }
            i16++;
            z = false;
        }
        if (z2 || f2 > 0.0f) {
            int i18 = paddingLeft - this.e;
            int i19 = 0;
            while (i19 < childCount) {
                View childAt2 = getChildAt(i19);
                if (childAt2.getVisibility() != i6) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != i6) {
                        boolean z5 = layoutParams2.width == 0 && layoutParams2.f1155b > 0.0f;
                        if (z5) {
                            i8 = 0;
                        } else {
                            i8 = childAt2.getMeasuredWidth();
                        }
                        if (!z2 || childAt2 == this.g) {
                            if (layoutParams2.f1155b > 0.0f) {
                                if (layoutParams2.width != 0) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams2.height == -2) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                } else if (layoutParams2.height == -1) {
                                    i9 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                                } else {
                                    i9 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                                }
                                if (z2) {
                                    int i20 = paddingLeft - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                                    i7 = i18;
                                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                                    if (i8 != i20) {
                                        childAt2.measure(makeMeasureSpec, i9);
                                    }
                                    i19++;
                                    i18 = i7;
                                    i6 = 8;
                                } else {
                                    i7 = i18;
                                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(i8 + ((int) ((layoutParams2.f1155b * ((float) Math.max(0, i15))) / f2)), 1073741824), i9);
                                    i19++;
                                    i18 = i7;
                                    i6 = 8;
                                }
                            }
                        } else if (layoutParams2.width < 0 && (i8 > i18 || layoutParams2.f1155b > 0.0f)) {
                            if (!z5) {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams2.height == -2) {
                                i11 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                                i10 = 1073741824;
                            } else if (layoutParams2.height == -1) {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                            } else {
                                i10 = 1073741824;
                                i11 = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                            }
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec(i18, i10), i11);
                        }
                    }
                }
                i7 = i18;
                i19++;
                i18 = i7;
                i6 = 8;
            }
        }
        setMeasuredDimension(size, i14 + getPaddingTop() + getPaddingBottom());
        this.f = z2;
        if (this.p.f() != 0 && !z2) {
            this.p.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f1157c) {
            e();
        } else {
            a();
        }
        this.q = savedState.f1157c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1157c = d() ? c() : this.q;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.r = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f) {
            return super.onTouchEvent(motionEvent);
        }
        this.p.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.m = x;
            this.n = y;
        } else if (actionMasked == 1 && e(this.g)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.m;
            float f3 = y2 - this.n;
            int e2 = this.p.e();
            if ((f2 * f2) + (f3 * f3) < ((float) (e2 * e2)) && this.p.a(this.g, (int) x2, (int) y2)) {
                a_shaKey_method2(this.g, 0);
            }
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f) {
            this.q = view == this.g;
        }
    }

    public void setCoveredFadeColor(int i2) {
        this.f1152b = i2;
    }

    public void setPanelSlideListener(d dVar) {
        this.o = dVar;
    }

    public void setParallaxDistance(int i2) {
        this.l = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f1153c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(androidx.core.content.a.c(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(androidx.core.content.a.c(getContext(), i2));
    }

    public void setSliderFadeColor(int i2) {
        this.f1151a = i2;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f1154a = {16843137};

        /* renamed from: b  reason: collision with root package name */
        public float f1155b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        boolean f1156c;
        boolean d;
        Paint e;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1154a);
            this.f1155b = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    class a extends C0083a {

        /* renamed from: c  reason: collision with root package name */
        private final Rect f1158c = new Rect();

        a() {
        }

        public void a(View view, androidx.core.h.a.c cVar) {
            androidx.core.h.a.c a2 = androidx.core.h.a.c.a(cVar);
            super.a_shaKey_method2(view, a2);
            a(cVar, a2);
            a2.w();
            cVar.a((CharSequence) SlidingPaneLayout.class.getName());
            cVar.d(view);
            ViewParent p = t.p(view);
            if (p instanceof View) {
                cVar.c((View) p);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!b(childAt) && childAt.getVisibility() == 0) {
                    t.d(childAt, 1);
                    cVar.a(childAt);
                }
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public boolean b(View view) {
            return SlidingPaneLayout.this.e(view);
        }

        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!b(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void a(androidx.core.h.a.c cVar, androidx.core.h.a.c cVar2) {
            Rect rect = this.f1158c;
            cVar2.a(rect);
            cVar.c(rect);
            cVar2.b(rect);
            cVar.d(rect);
            cVar.n(cVar2.u());
            cVar.e(cVar2.g());
            cVar.a(cVar2.c());
            cVar.b(cVar2.d());
            cVar.g(cVar2.n());
            cVar.e(cVar2.m());
            cVar.h(cVar2.o());
            cVar.i(cVar2.p());
            cVar.a(cVar2.j());
            cVar.l(cVar2.t());
            cVar.j(cVar2.q());
            cVar.a(cVar2.a());
            cVar.b(cVar2.f());
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        Field field;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            t.a_shaKey_method2(view, ((LayoutParams) view.getLayoutParams()).e);
            return;
        }
        if (i2 >= 16) {
            if (!this.v) {
                try {
                    this.u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
                }
                try {
                    this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    this.mRecreateDisplayList.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
                }
                this.v = true;
            }
            if (this.u == null || (field = this.mRecreateDisplayList) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.u.invoke(view, (Object[]) null);
            } catch (Exception e4) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e4);
            }
        }
        t.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* access modifiers changed from: package-private */
    public boolean e(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f || !layoutParams.d || this.h <= 0.0f) {
            return false;
        }
        return true;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1151a = -858993460;
        this.r = true;
        this.s = new Rect();
        this.t = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.e = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        t.a_shaKey_method2((View) this, (C0083a) new a());
        t.d(this, 1);
        this.p = g.a((ViewGroup) this, 0.5f, (g.a) new c());
        this.p.a(f2 * 400.0f);
    }

    public boolean c() {
        return !this.f || this.h == 1.0f;
    }

    private boolean a(View view, int i2) {
        if (!this.r && !a(0.0f, i2)) {
            return false;
        }
        this.q = false;
        return true;
    }

    private boolean b(View view, int i2) {
        if (!this.r && !a(1.0f, i2)) {
            return false;
        }
        this.q = true;
        return true;
    }

    public boolean a() {
        return a_shaKey_method2(this.g, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return t.k(this) == 1;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.g == null) {
            this.h = 0.0f;
            return;
        }
        boolean b2 = b();
        LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
        int width = this.g.getWidth();
        if (b2) {
            i2 = (getWidth() - i2) - width;
        }
        this.h = ((float) (i2 - ((b2 ? getPaddingRight() : getPaddingLeft()) + (b2 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.j);
        if (this.l != 0) {
            a(this.h);
        }
        if (layoutParams.d) {
            a(this.g, this.h, this.f1151a);
        }
        c(this.g);
    }

    private void a(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & 16777215);
            if (layoutParams.e == null) {
                layoutParams.e = new Paint();
            }
            layoutParams.e.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.e);
            }
            d(view);
        } else if (view.getLayerType() != 0) {
            Paint paint = layoutParams.e;
            if (paint != null) {
                paint.setColorFilter((ColorFilter) null);
            }
            b bVar = new b(view);
            this.t.add(bVar);
            t.a_shaKey_method2((View) this, (Runnable) bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, int i2) {
        int i3;
        if (!this.f) {
            return false;
        }
        boolean b2 = b();
        LayoutParams layoutParams = (LayoutParams) this.g.getLayoutParams();
        if (b2) {
            i3 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.j))) + ((float) this.g.getWidth())));
        } else {
            i3 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.j)));
        }
        g gVar = this.p;
        View view = this.g;
        if (!gVar.b(view, i3, view.getTop())) {
            return false;
        }
        f();
        t.C(this);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.b()
            android.view.View r1 = r9.g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.d
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x005b
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.g
            if (r4 != r5) goto L_0x002c
            goto L_0x0058
        L_0x002c:
            float r5 = r9.i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0058
            if (r0 == 0) goto L_0x004f
            float r5 = r9.i
            float r5 = r5 - r6
            goto L_0x0053
        L_0x004f:
            float r5 = r9.i
            float r5 = r6 - r5
        L_0x0053:
            int r6 = r9.f1152b
            r9.a(r4, r5, r6)
        L_0x0058:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }
}
