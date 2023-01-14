package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.C0074q;
import androidx.appcompat.widget.C0075s;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.r;
import androidx.core.h.t;
import androidx.core.widget.n;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.a.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.d.c;
import com.google.android.material.floatingactionbutton.e;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.f;
import com.google.android.material.internal.s;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements r, n, com.google.android.material.d.a {

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f2126b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f2127c;
    private ColorStateList d;
    private PorterDuff.Mode e;
    private int f;
    private ColorStateList g;
    private int h;
    private int i;
    /* access modifiers changed from: private */
    public int j;
    private int k;
    boolean l;
    final Rect m;
    private final Rect n;
    private final C0075s o;
    private final c p;
    private e q;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f2128a;

        /* renamed from: b  reason: collision with root package name */
        private a f2129b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2130c;

        public BaseBehavior() {
            this.f2130c = true;
        }

        public void setInternalAutoHideListener(a aVar) {
            this.f2129b = aVar;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a_shaKey_method2(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.a(this.f2129b, false);
                return true;
            }
            floatingActionButton.b(this.f2129b, false);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f2130c = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public void a(CoordinatorLayout.d dVar) {
            if (dVar.h == 0) {
                dVar.h = 80;
            }
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                b(view, floatingActionButton);
                return false;
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
            if (this.f2130c && dVar.c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a_shaKey_method2((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f2128a == null) {
                this.f2128a = new Rect();
            }
            Rect rect = this.f2128a;
            f.a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.a(this.f2129b, false);
                return true;
            }
            floatingActionButton.b(this.f2129b, false);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> b2 = coordinatorLayout.b((View) floatingActionButton);
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = b2.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.c((View) floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.m;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
                int i2 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin) {
                    i = rect.right;
                } else {
                    i = floatingActionButton.getLeft() <= dVar.leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    t.b((View) floatingActionButton, i2);
                }
                if (i != 0) {
                    t.a_shaKey_method2((View) floatingActionButton, i);
                }
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(a aVar) {
            super.setInternalAutoHideListener(aVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.d dVar) {
            super.a(dVar);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.a(coordinatorLayout, floatingActionButton, i);
        }
    }

    public static abstract class a {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void d() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.d;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.b(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.e;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(C0074q.a_shaKey_method2(colorForState, mode));
        }
    }

    private e getImpl() {
        if (this.q == null) {
            this.q = c();
        }
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f2126b;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2127c;
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().e();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f();
    }

    public Drawable getContentBackground() {
        return getImpl().b();
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        return this.p.a();
    }

    public h getHideMotionSpec() {
        return getImpl().d();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public h getShowMotionSpec() {
        return getImpl().g();
    }

    public int getSize() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return a(this.h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.e;
    }

    public boolean getUseCompatPadding() {
        return this.l;
    }

    public void hide(a aVar) {
        a(aVar, true);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().j();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().o();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().s();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.p.a(extendableSavedState.f2225c.get("expandableWidgetHelper"));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.f2225c.put("expandableWidgetHelper", this.p.c());
        return extendableSavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a(this.n) || this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2126b != colorStateList) {
            this.f2126b = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2127c != mode) {
            this.f2127c = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().d(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 >= 0) {
            this.i = i2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i2) {
        this.p.a(i2);
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.a_shaKey_method2(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().r();
    }

    public void setImageResource(int i2) {
        this.o.a(i2);
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.a_shaKey_method2(getContext(), i2));
    }

    public void setSize(int i2) {
        this.i = 0;
        if (i2 != this.h) {
            this.h = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            d();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            d();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.l != z) {
            this.l = z;
            getImpl().n();
        }
    }

    public void show(a aVar) {
        b(aVar, true);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    private void c(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.m;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            getImpl().b(this.g);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = new Rect();
        this.n = new Rect();
        TypedArray a2 = s.a(context, attributeSet, R$styleable.FloatingActionButton, i2, R$style.Widget_Design_FloatingActionButton, new int[0]);
        this.f2126b = com.google.android.material.f.a.a(context, a2, R$styleable.FloatingActionButton_backgroundTint);
        this.f2127c = com.google.android.material.internal.t.a_shaKey_method2(a2.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.g = com.google.android.material.f.a.a(context, a2, R$styleable.FloatingActionButton_rippleColor);
        this.h = a2.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.i = a2.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f = a2.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = a2.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = a2.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = a2.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.l = a2.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        this.k = a2.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        h a3 = h.a(context, a2, R$styleable.FloatingActionButton_showMotionSpec);
        h a4 = h.a(context, a2, R$styleable.FloatingActionButton_hideMotionSpec);
        a2.recycle();
        this.o = new C0075s(this);
        this.o.a_shaKey_method2(attributeSet, i2);
        this.p = new c(this);
        getImpl().a(this.f2126b, this.f2127c, this.g, this.f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.k);
        getImpl().b(a3);
        getImpl().a(a4);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    public boolean b() {
        return getImpl().i();
    }

    private class b implements com.google.android.material.h.b {
        b() {
        }

        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.m.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.j, i2 + FloatingActionButton.this.j, i3 + FloatingActionButton.this.j, i4 + FloatingActionButton.this.j);
        }

        public float b() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public void setBackgroundDrawable(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        public boolean a() {
            return FloatingActionButton.this.l;
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    public boolean a() {
        return this.p.b();
    }

    private e.d a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a(this, aVar);
    }

    private e c() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new f(this, new b());
        }
        return new e(this, new b());
    }

    private int a(int i2) {
        int i3 = this.i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        } else {
            return a(0);
        }
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!t.z(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    private static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }
}
