package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.a;
import androidx.core.h.t;
import androidx.core.widget.l;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;

public class MaterialButton extends AppCompatButton {

    /* renamed from: c  reason: collision with root package name */
    private final b f2083c;
    private int d;
    private PorterDuff.Mode e;
    private ColorStateList f;
    private Drawable g;
    private int h;
    private int i;
    private int j;

    public MaterialButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean a() {
        return t.k(this) == 1;
    }

    private boolean b() {
        b bVar = this.f2083c;
        return bVar != null && !bVar.g();
    }

    private void c() {
        Drawable drawable = this.g;
        if (drawable != null) {
            this.g = drawable.mutate();
            a.a_shaKey_method2(this.g, this.f);
            PorterDuff.Mode mode = this.e;
            if (mode != null) {
                a.a_shaKey_method2(this.g, mode);
            }
            int i2 = this.h;
            if (i2 == 0) {
                i2 = this.g.getIntrinsicWidth();
            }
            int i3 = this.h;
            if (i3 == 0) {
                i3 = this.g.getIntrinsicHeight();
            }
            Drawable drawable2 = this.g;
            int i4 = this.i;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        l.a(this, this.g, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (b()) {
            return this.f2083c.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.g;
    }

    public int getIconGravity() {
        return this.j;
    }

    public int getIconPadding() {
        return this.d;
    }

    public int getIconSize() {
        return this.h;
    }

    public ColorStateList getIconTint() {
        return this.f;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.e;
    }

    public ColorStateList getRippleColor() {
        if (b()) {
            return this.f2083c.b();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (b()) {
            return this.f2083c.c();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (b()) {
            return this.f2083c.d();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (b()) {
            return this.f2083c.e();
        }
        return super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (b()) {
            return this.f2083c.f();
        }
        return super.getSupportBackgroundTintMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT < 21 && b()) {
            this.f2083c.a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (bVar = this.f2083c) != null) {
            bVar.a(i5 - i3, i4 - i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.g != null && this.j == 2) {
            int measureText = (int) getPaint().measureText(getText().toString());
            int i4 = this.h;
            if (i4 == 0) {
                i4 = this.g.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - measureText) - t.n(this)) - i4) - this.d) - t.o(this)) / 2;
            if (a()) {
                measuredWidth = -measuredWidth;
            }
            if (this.i != measuredWidth) {
                this.i = measuredWidth;
                c();
            }
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (b()) {
            this.f2083c.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!b()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.i("MaterialButton", "Setting a custom background is not supported.");
            this.f2083c.h();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int i2) {
        if (b()) {
            this.f2083c.b(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (b()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.g != drawable) {
            this.g = drawable;
            c();
        }
    }

    public void setIconGravity(int i2) {
        this.j = i2;
    }

    public void setIconPadding(int i2) {
        if (this.d != i2) {
            this.d = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.h != i2) {
            this.h = i2;
            c();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            c();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            c();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(androidx.appcompat.a.a.a.a_shaKey_method2(getContext(), i2));
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (b()) {
            this.f2083c.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (b()) {
            setRippleColor(androidx.appcompat.a.a.a.a_shaKey_method2(getContext(), i2));
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (b()) {
            this.f2083c.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (b()) {
            setStrokeColor(androidx.appcompat.a.a.a.a_shaKey_method2(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (b()) {
            this.f2083c.c(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (b()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (b()) {
            this.f2083c.c(colorStateList);
        } else if (this.f2083c != null) {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (b()) {
            this.f2083c.a(mode);
        } else if (this.f2083c != null) {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray a2 = s.a(context, attributeSet, R$styleable.MaterialButton, i2, R$style.Widget_MaterialComponents_Button, new int[0]);
        this.d = a2.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.e = com.google.android.material.internal.t.a_shaKey_method2(a2.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f = com.google.android.material.f.a.a(getContext(), a2, R$styleable.MaterialButton_iconTint);
        this.g = com.google.android.material.f.a.b(getContext(), a2, R$styleable.MaterialButton_icon);
        this.j = a2.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.h = a2.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        this.f2083c = new b(this);
        this.f2083c.a(a2);
        a2.recycle();
        setCompoundDrawablePadding(this.d);
        c();
    }
}
