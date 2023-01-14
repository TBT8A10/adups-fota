package com.google.android.material.bottomnavigation;

import a.d.a.a.b;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.w;
import androidx.core.g.e;
import androidx.core.g.g;
import androidx.core.h.t;
import androidx.transition.AutoTransition;
import androidx.transition.C0123ca;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.r;

public class BottomNavigationMenuView extends ViewGroup implements w {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2062a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2063b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    private final TransitionSet f2064c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final View.OnClickListener i;
    private final e<BottomNavigationItemView> j;
    private boolean k;
    private int l;
    private BottomNavigationItemView[] m;
    private int n;
    private int o;
    private ColorStateList p;
    private int q;
    private ColorStateList r;
    private final ColorStateList s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private int[] x;
    /* access modifiers changed from: private */
    public BottomNavigationPresenter y;
    /* access modifiers changed from: private */
    public l z;

    public BottomNavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean a(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.j.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    public void c() {
        l lVar = this.z;
        if (lVar != null && this.m != null) {
            int size = lVar.size();
            if (size != this.m.length) {
                a();
                return;
            }
            int i2 = this.n;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = this.z.getItem(i3);
                if (item.isChecked()) {
                    this.n = item.getItemId();
                    this.o = i3;
                }
            }
            if (i2 != this.n) {
                C0123ca.a_shaKey_method2(this, this.f2064c);
            }
            boolean a2 = a(this.l, this.z.n().size());
            for (int i4 = 0; i4 < size; i4++) {
                this.y.a(true);
                this.m[i4].setLabelVisibilityMode(this.l);
                this.m[i4].setShifting(a2);
                this.m[i4].a((p) this.z.getItem(i4), 0);
                this.y.a(false);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.p;
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) {
            return this.v;
        }
        return bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.w;
    }

    public int getItemIconSize() {
        return this.q;
    }

    public int getItemTextAppearanceActive() {
        return this.u;
    }

    public int getItemTextAppearanceInactive() {
        return this.t;
    }

    public ColorStateList getItemTextColor() {
        return this.r;
    }

    public int getLabelVisibilityMode() {
        return this.l;
    }

    public int getSelectedItemId() {
        return this.n;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (t.k(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.z.n().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!a(this.l, size2) || !this.k) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.f);
            int i4 = size - (size2 * min);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).getVisibility() != 8) {
                    int[] iArr = this.x;
                    iArr[i5] = min;
                    if (i4 > 0) {
                        iArr[i5] = iArr[i5] + 1;
                        i4--;
                    }
                } else {
                    this.x[i5] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.o);
            int i6 = this.g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f, Integer.MIN_VALUE), makeMeasureSpec);
                i6 = Math.max(i6, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.e * i7), Math.min(i6, this.f));
            int i8 = size - min2;
            int min3 = Math.min(i8 / (i7 == 0 ? 1 : i7), this.d);
            int i9 = i8 - (i7 * min3);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    this.x[i10] = i10 == this.o ? min2 : min3;
                    if (i9 > 0) {
                        int[] iArr2 = this.x;
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.x[i10] = 0;
                }
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.x[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.h, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView iconTintList : bottomNavigationItemViewArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.v = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView itemBackground : bottomNavigationItemViewArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.w = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView itemBackground : bottomNavigationItemViewArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.k = z2;
    }

    public void setItemIconSize(int i2) {
        this.q = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView iconSize : bottomNavigationItemViewArr) {
                iconSize.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.u = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.t = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.r;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.r = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView textColor : bottomNavigationItemViewArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.l = i2;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new g(5);
        this.n = 0;
        this.o = 0;
        Resources resources = getResources();
        this.d = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.e = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.g = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.h = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_height);
        this.s = a(16842808);
        this.f2064c = new AutoTransition();
        this.f2064c.b(0);
        this.f2064c.a(115);
        this.f2064c.a((TimeInterpolator) new b());
        this.f2064c.a((Transition) new r());
        this.i = new b(this);
        this.x = new int[5];
    }

    public void a(l lVar) {
        this.z = lVar;
    }

    public boolean b() {
        return this.k;
    }

    public ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = a.a_shaKey_method2(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        return new ColorStateList(new int[][]{f2063b, f2062a, ViewGroup.EMPTY_STATE_SET}, new int[]{a2.getColorForState(f2063b, defaultColor), i3, defaultColor});
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        int size = this.z.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.z.getItem(i3);
            if (i2 == item.getItemId()) {
                this.n = i2;
                this.o = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void a() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.m;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.j.release(bottomNavigationItemView);
                }
            }
        }
        if (this.z.size() == 0) {
            this.n = 0;
            this.o = 0;
            this.m = null;
            return;
        }
        this.m = new BottomNavigationItemView[this.z.size()];
        boolean a2 = a(this.l, this.z.n().size());
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            this.y.a(true);
            this.z.getItem(i2).setCheckable(true);
            this.y.a(false);
            BottomNavigationItemView newItem = getNewItem();
            this.m[i2] = newItem;
            newItem.setIconTintList(this.p);
            newItem.setIconSize(this.q);
            newItem.setTextColor(this.s);
            newItem.setTextAppearanceInactive(this.t);
            newItem.setTextAppearanceActive(this.u);
            newItem.setTextColor(this.r);
            Drawable drawable = this.v;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.w);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.l);
            newItem.a((p) this.z.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.i);
            addView(newItem);
        }
        this.o = Math.min(this.z.size() - 1, this.o);
        this.z.getItem(this.o).setChecked(true);
    }
}
