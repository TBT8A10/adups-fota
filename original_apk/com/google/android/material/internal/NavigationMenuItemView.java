package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.qa;
import androidx.core.content.a.h;
import androidx.core.graphics.drawable.a;
import androidx.core.h.C0083a;
import androidx.core.h.t;
import androidx.core.widget.l;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements w.a {
    private static final int[] v = {16842912};
    private FrameLayout A;
    private p B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final C0083a F;
    private final int w;
    private boolean x;
    boolean y;
    private final CheckedTextView z;

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void b() {
        if (d()) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.width = -1;
                this.A.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.z.setVisibility(0);
        FrameLayout frameLayout2 = this.A;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            layoutParams2.width = -2;
            this.A.setLayoutParams(layoutParams2);
        }
    }

    private StateListDrawable c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R$attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(v, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean d() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    public void a(p pVar, int i) {
        this.B = pVar;
        setVisibility(pVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            t.a_shaKey_method2((View) this, (Drawable) c());
        }
        setCheckable(pVar.isCheckable());
        setChecked(pVar.isChecked());
        setEnabled(pVar.isEnabled());
        setTitle(pVar.getTitle());
        setIcon(pVar.getIcon());
        setActionView(pVar.getActionView());
        setContentDescription(pVar.d());
        qa.a_shaKey_method2(this, pVar.i());
        b();
    }

    public p getItemData() {
        return this.B;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        p pVar = this.B;
        if (pVar != null && pVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, v);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.y != z2) {
            this.y = z2;
            this.F.a_shaKey_method2((View) this.z, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.z.setChecked(z2);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = a.i(drawable).mutate();
                a.a_shaKey_method2(drawable, this.C);
            }
            int i = this.w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.x) {
            if (this.E == null) {
                this.E = h.a(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.E;
                if (drawable2 != null) {
                    int i2 = this.w;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.E;
        }
        l.a(this.z, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = this.C != null;
        p pVar = this.B;
        if (pVar != null) {
            setIcon(pVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.x = z2;
    }

    public void setTextAppearance(int i) {
        l.d(this.z, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new i(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, this, true);
        this.w = context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size);
        this.z = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.z.setDuplicateParentStateEnabled(true);
        t.a_shaKey_method2((View) this.z, this.F);
    }

    public void a() {
        FrameLayout frameLayout = this.A;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.z.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
