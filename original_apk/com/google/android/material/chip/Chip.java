package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.a.h;
import androidx.core.h.C0083a;
import androidx.core.h.a.c;
import androidx.core.h.t;
import androidx.customview.a.c;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.chip.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip extends AppCompatCheckBox implements d.a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Rect f2090b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2091c = {16842913};
    /* access modifiers changed from: private */
    public d d;
    private RippleDrawable e;
    private View.OnClickListener f;
    private CompoundButton.OnCheckedChangeListener g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final a m;
    private final Rect n;
    private final RectF o;
    private final h.a p;

    private class a extends c {
        a(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int a(float f, float f2) {
            return (!Chip.this.f() || !Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? -1 : 0;
        }

        /* access modifiers changed from: protected */
        public void a(List<Integer> list) {
            if (Chip.this.f()) {
                list.add(0);
            }
        }

        /* access modifiers changed from: protected */
        public void a(int i, androidx.core.h.a.c cVar) {
            if (Chip.this.f()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.b(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    cVar.b((CharSequence) context.getString(i2, objArr).trim());
                }
                cVar.c(Chip.this.getCloseIconTouchBoundsInt());
                cVar.a(c.a.e);
                cVar.g(Chip.this.isEnabled());
                return;
            }
            cVar.b((CharSequence) "");
            cVar.c(Chip.f2090b);
        }

        /* access modifiers changed from: protected */
        public void a(androidx.core.h.a.c cVar) {
            cVar.c(Chip.this.d != null && Chip.this.d.D());
            cVar.a((CharSequence) Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.f(text);
            } else {
                cVar.b(text);
            }
        }

        /* access modifiers changed from: protected */
        public boolean a(int i, int i2, Bundle bundle) {
            if (i2 == 16 && i == 0) {
                return Chip.this.c();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, (AttributeSet) null);
    }

    private void e() {
        if (this.i == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    /* access modifiers changed from: private */
    public boolean f() {
        d dVar = this.d;
        return (dVar == null || dVar.m() == null) ? false : true;
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b(this));
        }
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.o.setEmpty();
        if (f()) {
            this.d.a(this.o);
        }
        return this.o;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.n.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.n;
    }

    private com.google.android.material.f.c getTextAppearance() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.A();
        }
        return null;
    }

    private void h() {
        d dVar;
        if (!TextUtils.isEmpty(getText()) && (dVar = this.d) != null) {
            float j2 = dVar.j() + this.d.e() + this.d.C() + this.d.B();
            if ((this.d.F() && this.d.f() != null) || (this.d.b() != null && this.d.E() && isChecked())) {
                j2 += this.d.w() + this.d.v() + this.d.g();
            }
            if (this.d.H() && this.d.m() != null) {
                j2 += this.d.q() + this.d.o() + this.d.p();
            }
            if (((float) t.n(this)) != j2) {
                t.b(this, t.o(this), getPaddingTop(), (int) j2, getPaddingBottom());
            }
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    private void setFocusedVirtualView(int i2) {
        int i3 = this.i;
        if (i3 != i2) {
            if (i3 == 0) {
                setCloseIconFocused(false);
            }
            this.i = i2;
            if (i2 == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.m.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.m.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.d;
        if ((dVar == null || !dVar.G()) ? false : this.d.a(d())) {
            invalidate();
        }
    }

    public Drawable getCheckedIcon() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public float getChipCornerRadius() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.d();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.d;
    }

    public float getChipEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.e();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.f();
        }
        return null;
    }

    public float getChipIconSize() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.g();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.h();
        }
        return null;
    }

    public float getChipMinHeight() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.i();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.j();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.k();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.l();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.m();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.n();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.o();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.p();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.q();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.s();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.t();
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.i == 0) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.u();
        }
        return null;
    }

    public float getIconEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.v();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.w();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.x();
        }
        return null;
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.y();
        }
        return null;
    }

    public CharSequence getText() {
        d dVar = this.d;
        return dVar != null ? dVar.z() : "";
    }

    public float getTextEndPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.B();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        d dVar = this.d;
        if (dVar != null) {
            return dVar.C();
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, f2091c);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        d dVar;
        if (TextUtils.isEmpty(getText()) || (dVar = this.d) == null || dVar.J()) {
            super.onDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.translate(b(this.d), 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i2, rect);
        this.m.a(z, i2, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getKeyCode()
            r1 = 61
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0041
            r1 = 66
            if (r0 == r1) goto L_0x0031
            switch(r0) {
                case 21: goto L_0x0022;
                case 22: goto L_0x0012;
                case 23: goto L_0x0031;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x006d
        L_0x0012:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.google.android.material.internal.t.a(r6)
            r0 = r0 ^ r3
            boolean r2 = r6.a((boolean) r0)
            goto L_0x006d
        L_0x0022:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.google.android.material.internal.t.a(r6)
            boolean r2 = r6.a((boolean) r0)
            goto L_0x006d
        L_0x0031:
            int r0 = r6.i
            r1 = -1
            if (r0 == r1) goto L_0x003d
            if (r0 == 0) goto L_0x0039
            goto L_0x006d
        L_0x0039:
            r6.c()
            return r3
        L_0x003d:
            r6.performClick()
            return r3
        L_0x0041:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x0052
        L_0x0049:
            boolean r0 = r8.hasModifiers(r3)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x006d
            android.view.ViewParent r1 = r6.getParent()
            r4 = r6
        L_0x0059:
            android.view.View r4 = r4.focusSearch(r0)
            if (r4 == 0) goto L_0x0067
            if (r4 == r6) goto L_0x0067
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == r1) goto L_0x0059
        L_0x0067:
            if (r4 == 0) goto L_0x006d
            r4.requestFocus()
            return r3
        L_0x006d:
            if (r2 == 0) goto L_0x0073
            r6.invalidate()
            return r3
        L_0x0073:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.j
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.j
            if (r0 == 0) goto L_0x0034
            r5.c()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x0049
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
        L_0x0049:
            r2 = 1
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == this.d || drawable == this.e) {
            super.setBackground(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }

    public void setBackgroundColor(int i2) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == this.d || drawable == this.e) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }

    public void setBackgroundResource(int i2) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void setCheckableResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        d dVar = this.d;
        if (dVar == null) {
            this.h = z;
        } else if (dVar.D()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.g) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(i2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(i2);
        }
    }

    public void setChipCornerRadius(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(f2);
        }
    }

    public void setChipCornerRadiusResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.e(i2);
        }
    }

    public void setChipDrawable(d dVar) {
        d dVar2 = this.d;
        if (dVar2 != dVar) {
            c(dVar2);
            this.d = dVar;
            a(this.d);
            if (com.google.android.material.g.a.f2147a) {
                this.e = new RippleDrawable(com.google.android.material.g.a.a(this.d.x()), this.d, (Drawable) null);
                this.d.f(false);
                t.a_shaKey_method2((View) this, (Drawable) this.e);
                return;
            }
            this.d.f(true);
            t.a_shaKey_method2((View) this, (Drawable) this.d);
        }
    }

    public void setChipEndPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.f(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.g(i2);
        }
    }

    public void setChipIconSize(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.h(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.i(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.j(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.k(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.e(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.l(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.m(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.f(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.n(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(drawable);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.g(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.o(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.p(i2);
        }
    }

    public void setCloseIconSize(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.h(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.q(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.i(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.r(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.s(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.t(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.d != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                d dVar = this.d;
                if (dVar != null) {
                    dVar.a(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(hVar);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.u(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.j(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.v(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.k(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.w(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        d dVar = this.d;
        if (dVar != null) {
            dVar.x(i2);
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.g = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.e(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.y(i2);
        }
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(hVar);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.z(i2);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.d != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            CharSequence a2 = androidx.core.f.a.a().a(charSequence);
            if (this.d.J()) {
                a2 = null;
            }
            super.setText(a2, bufferType);
            d dVar = this.d;
            if (dVar != null) {
                dVar.b(charSequence);
            }
        }
    }

    public void setTextAppearance(com.google.android.material.f.c cVar) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(cVar);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.p);
            a(cVar);
        }
    }

    public void setTextAppearanceResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.A(i2);
        }
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.l(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.B(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.m(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.C(i2);
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    private void c(d dVar) {
        if (dVar != null) {
            dVar.a((d.a) null);
        }
    }

    private int[] d() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.l) {
            i3++;
        }
        if (this.k) {
            i3++;
        }
        if (this.j) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.l) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.k) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.j) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = Integer.MIN_VALUE;
        this.n = new Rect();
        this.o = new RectF();
        this.p = new a(this);
        a(attributeSet);
        d a2 = d.a(context, attributeSet, i2, R$style.Widget_MaterialComponents_Chip_Action);
        setChipDrawable(a2);
        this.m = new a(this);
        t.a_shaKey_method2((View) this, (C0083a) this.m);
        g();
        setChecked(this.h);
        a2.e(false);
        setText(a2.z());
        setEllipsize(a2.t());
        setIncludeFontPadding(false);
        if (getTextAppearance() != null) {
            a(getTextAppearance());
        }
        setSingleLine();
        setGravity(8388627);
        h();
    }

    private float b(d dVar) {
        float chipStartPadding = getChipStartPadding() + dVar.a() + getTextStartPadding();
        return t.k(this) == 0 ? chipStartPadding : -chipStartPadding;
    }

    public boolean c() {
        boolean z;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.m.a(0, 1);
        return z;
    }

    public void setCheckedIconVisible(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c(z);
        }
    }

    public void setCloseIconVisible(boolean z) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.d(z);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        d dVar = this.d;
        if (dVar != null) {
            dVar.A(i2);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(context, getPaint(), this.p);
            a(getTextAppearance());
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        d dVar = this.d;
        if (dVar != null) {
            dVar.A(i2);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().c(getContext(), getPaint(), this.p);
            a(getTextAppearance());
        }
    }

    private void a(d dVar) {
        dVar.a((d.a) this);
    }

    public void a() {
        h();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.customview.a.c.class.getDeclaredField("o");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.m)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.customview.a.c.class.getDeclaredMethod("i", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.m, new Object[]{Integer.MIN_VALUE});
                    return true;
                }
            } catch (NoSuchMethodException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (IllegalAccessException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (NoSuchFieldException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    private boolean a(boolean z) {
        e();
        if (z) {
            if (this.i == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.i == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    private void a(com.google.android.material.f.c cVar) {
        TextPaint paint = getPaint();
        paint.drawableState = this.d.getState();
        cVar.b(getContext(), paint, this.p);
    }
}
