package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.d.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ia;
import androidx.core.h.D;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.s;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] d = {16842912};
    private static final int[] e = {-16842910};
    private final h f;
    private final k g;
    a h;
    private final int i;
    private MenuInflater j;

    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    private ColorStateList c(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = androidx.appcompat.a.a.a.a_shaKey_method2(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        return new ColorStateList(new int[][]{e, d, FrameLayout.EMPTY_STATE_SET}, new int[]{a2.getColorForState(e, defaultColor), i3, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.j == null) {
            this.j = new g(getContext());
        }
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void a(D d2) {
        this.g.a(d2);
    }

    public void b(int i2) {
        this.g.a(true);
        getMenuInflater().inflate(i2, this.f);
        this.g.a(false);
        this.g.updateMenuView(false);
    }

    public MenuItem getCheckedItem() {
        return this.g.a();
    }

    public int getHeaderCount() {
        return this.g.b();
    }

    public Drawable getItemBackground() {
        return this.g.c();
    }

    public int getItemHorizontalPadding() {
        return this.g.d();
    }

    public int getItemIconPadding() {
        return this.g.e();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.g();
    }

    public ColorStateList getItemTextColor() {
        return this.g.f();
    }

    public Menu getMenu() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.i), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f.b(savedState.f2208c);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2208c = new Bundle();
        this.f.d(savedState.f2208c);
        return savedState;
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f.findItem(i2);
        if (findItem != null) {
            this.g.a((p) findItem);
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.g.a(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(androidx.core.content.a.c(getContext(), i2));
    }

    public void setItemHorizontalPadding(int i2) {
        this.g.c(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.g.c(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(int i2) {
        this.g.d(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.g.d(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.a(colorStateList);
    }

    public void setItemTextAppearance(int i2) {
        this.g.e(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.h = aVar;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* renamed from: c  reason: collision with root package name */
        public Bundle f2208c;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2208c = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f2208c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R$attr.navigationViewStyle);
    }

    public View a(int i2) {
        return this.g.a(i2);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList colorStateList;
        int i3;
        boolean z;
        this.g = new k();
        this.f = new h(context);
        ia b2 = s.b(context, attributeSet, R$styleable.NavigationView, i2, R$style.Widget_Design_NavigationView, new int[0]);
        t.a_shaKey_method2((View) this, b2.b(R$styleable.NavigationView_android_background));
        if (b2.g(R$styleable.NavigationView_elevation)) {
            t.a_shaKey_method2((View) this, (float) b2.c(R$styleable.NavigationView_elevation, 0));
        }
        t.a_shaKey_method2((View) this, b2.a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.i = b2.c(R$styleable.NavigationView_android_maxWidth, 0);
        if (b2.g(R$styleable.NavigationView_itemIconTint)) {
            colorStateList = b2.a(R$styleable.NavigationView_itemIconTint);
        } else {
            colorStateList = c(16842808);
        }
        if (b2.g(R$styleable.NavigationView_itemTextAppearance)) {
            i3 = b2.g(R$styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            i3 = 0;
        }
        ColorStateList a2 = b2.g(R$styleable.NavigationView_itemTextColor) ? b2.a(R$styleable.NavigationView_itemTextColor) : null;
        if (!z && a2 == null) {
            a2 = c(16842806);
        }
        Drawable b3 = b2.b(R$styleable.NavigationView_itemBackground);
        if (b2.g(R$styleable.NavigationView_itemHorizontalPadding)) {
            this.g.c(b2.c(R$styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int c2 = b2.c(R$styleable.NavigationView_itemIconPadding, 0);
        this.f.a((l.a) new a(this));
        this.g.b(1);
        this.g.a_shaKey_method2(context, (l) this.f);
        this.g.a(colorStateList);
        if (z) {
            this.g.e(i3);
        }
        this.g.b(a2);
        this.g.a(b3);
        this.g.d(c2);
        this.f.a((v) this.g);
        addView((View) this.g.a((ViewGroup) this));
        if (b2.g(R$styleable.NavigationView_menu)) {
            b(b2.g(R$styleable.NavigationView_menu, 0));
        }
        if (b2.g(R$styleable.NavigationView_headerLayout)) {
            a(b2.g(R$styleable.NavigationView_headerLayout, 0));
        }
        b2.a();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.g.a((p) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
