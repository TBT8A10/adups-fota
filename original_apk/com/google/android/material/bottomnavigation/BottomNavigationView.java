package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.d.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ia;
import androidx.core.h.t;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;

public class BottomNavigationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final l f2069a;

    /* renamed from: b  reason: collision with root package name */
    private final BottomNavigationMenuView f2070b;

    /* renamed from: c  reason: collision with root package name */
    private final BottomNavigationPresenter f2071c;
    private MenuInflater d;
    /* access modifiers changed from: private */
    public b e;
    /* access modifiers changed from: private */
    public a f;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new e();

        /* renamed from: c  reason: collision with root package name */
        Bundle f2072c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f2072c = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f2072c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a_shaKey_method2(parcel, classLoader);
        }
    }

    public interface a {
        void a(MenuItem menuItem);
    }

    public interface b {
        boolean a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    private MenuInflater getMenuInflater() {
        if (this.d == null) {
            this.d = new g(getContext());
        }
        return this.d;
    }

    public Drawable getItemBackground() {
        return this.f2070b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f2070b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f2070b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f2070b.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.f2070b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f2070b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f2070b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f2070b.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f2069a;
    }

    public int getSelectedItemId() {
        return this.f2070b.getSelectedItemId();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f2069a.b(savedState.f2072c);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2072c = new Bundle();
        this.f2069a.d(savedState.f2072c);
        return savedState;
    }

    public void setItemBackground(Drawable drawable) {
        this.f2070b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.f2070b.setItemBackgroundRes(i);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f2070b.b() != z) {
            this.f2070b.setItemHorizontalTranslationEnabled(z);
            this.f2071c.updateMenuView(false);
        }
    }

    public void setItemIconSize(int i) {
        this.f2070b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f2070b.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.f2070b.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f2070b.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f2070b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f2070b.getLabelVisibilityMode() != i) {
            this.f2070b.setLabelVisibilityMode(i);
            this.f2071c.updateMenuView(false);
        }
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.f = aVar;
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.e = bVar;
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.f2069a.findItem(i);
        if (findItem != null && !this.f2069a.a(findItem, (v) this.f2071c, 0)) {
            findItem.setChecked(true);
        }
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    public void a(int i) {
        this.f2071c.a(true);
        getMenuInflater().inflate(i, this.f2069a);
        this.f2071c.a(false);
        this.f2071c.updateMenuView(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2071c = new BottomNavigationPresenter();
        this.f2069a = new a(context);
        this.f2070b = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f2070b.setLayoutParams(layoutParams);
        this.f2071c.a(this.f2070b);
        this.f2071c.a(1);
        this.f2070b.setPresenter(this.f2071c);
        this.f2069a.a((v) this.f2071c);
        this.f2071c.a_shaKey_method2(getContext(), this.f2069a);
        ia b2 = s.b(context, attributeSet, R$styleable.BottomNavigationView, i, R$style.Widget_Design_BottomNavigationView, R$styleable.BottomNavigationView_itemTextAppearanceInactive, R$styleable.BottomNavigationView_itemTextAppearanceActive);
        if (b2.g(R$styleable.BottomNavigationView_itemIconTint)) {
            this.f2070b.setIconTintList(b2.a(R$styleable.BottomNavigationView_itemIconTint));
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.f2070b;
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.a(16842808));
        }
        setItemIconSize(b2.c(R$styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_icon_size)));
        if (b2.g(R$styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(b2.g(R$styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (b2.g(R$styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(b2.g(R$styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (b2.g(R$styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(b2.a(R$styleable.BottomNavigationView_itemTextColor));
        }
        if (b2.g(R$styleable.BottomNavigationView_elevation)) {
            t.a_shaKey_method2((View) this, (float) b2.c(R$styleable.BottomNavigationView_elevation, 0));
        }
        setLabelVisibilityMode(b2.e(R$styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(b2.a(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        this.f2070b.setItemBackgroundRes(b2.g(R$styleable.BottomNavigationView_itemBackground, 0));
        if (b2.g(R$styleable.BottomNavigationView_menu)) {
            a(b2.g(R$styleable.BottomNavigationView_menu, 0));
        }
        b2.a();
        addView(this.f2070b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            a(context);
        }
        this.f2069a.a((l.a) new d(this));
    }

    private void a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.a.a_shaKey_method2(context, R$color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }
}
