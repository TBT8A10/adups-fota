package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.a;
import androidx.core.h.t;
import androidx.core.widget.l;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public class SwitchCompat extends CompoundButton {
    private static final int[] CHECKED_STATE_SET = {16842912};

    /* renamed from: a  reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f381a = new ca(Float.class, "thumbPos");
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private ColorStateList F;
    private Layout G;
    private Layout H;
    private TransformationMethod I;
    ObjectAnimator J;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f382b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f383c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;
    private Drawable g;
    private ColorStateList h;
    private PorterDuff.Mode i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private final Rect mTempRect;
    private final TextPaint mTextPaint;
    private int mTouchSlop;
    private int n;
    private boolean o;
    private CharSequence p;
    private CharSequence q;
    private boolean r;
    private int s;
    private float t;
    private float u;
    private VelocityTracker v;
    private int w;
    float x;
    private int y;
    private int z;

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    private static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private void b() {
        if (this.g == null) {
            return;
        }
        if (this.j || this.k) {
            this.g = this.g.mutate();
            if (this.j) {
                a.a_shaKey_method2(this.g, this.h);
            }
            if (this.k) {
                a.a_shaKey_method2(this.g, this.i);
            }
            if (this.g.isStateful()) {
                this.g.setState(getDrawableState());
            }
        }
    }

    private void c() {
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.x > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (wa.a(this)) {
            f2 = 1.0f - this.x;
        } else {
            f2 = this.x;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.g;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.mTempRect;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f382b;
        if (drawable2 != null) {
            rect = E.c(drawable2);
        } else {
            rect = E.f325a;
        }
        return ((((this.y - this.A) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    public void a(Context context, int i2) {
        ia a2 = ia.a(context, i2, R$styleable.TextAppearance);
        ColorStateList a3 = a2.a(R$styleable.TextAppearance_android_textColor);
        if (a3 != null) {
            this.F = a3;
        } else {
            this.F = getTextColors();
        }
        int c2 = a2.c(R$styleable.TextAppearance_android_textSize, 0);
        if (c2 != 0) {
            float f2 = (float) c2;
            if (f2 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f2);
                requestLayout();
            }
        }
        a(a2.d(R$styleable.TextAppearance_android_typeface, -1), a2.d(R$styleable.TextAppearance_android_textStyle, -1));
        if (a2.a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.I = new androidx.appcompat.c.a(getContext());
        } else {
            this.I = null;
        }
        a2.a();
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.mTempRect;
        int i4 = this.B;
        int i5 = this.C;
        int i6 = this.D;
        int i7 = this.E;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f382b;
        if (drawable != null) {
            rect = E.c(drawable);
        } else {
            rect = E.f325a;
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.g.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.g.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f382b;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.A + rect2.right;
            this.f382b.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                a.a(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f382b;
        if (drawable != null) {
            a.a(drawable, f2, f3);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            a.a(drawable2, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f382b;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!wa.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.n : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (wa.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.n : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.r;
    }

    public boolean getSplitTrack() {
        return this.o;
    }

    public int getSwitchMinWidth() {
        return this.m;
    }

    public int getSwitchPadding() {
        return this.n;
    }

    public CharSequence getTextOff() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.p;
    }

    public Drawable getThumbDrawable() {
        return this.f382b;
    }

    public int getThumbTextPadding() {
        return this.l;
    }

    public ColorStateList getThumbTintList() {
        return this.f383c;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.d;
    }

    public Drawable getTrackDrawable() {
        return this.g;
    }

    public ColorStateList getTrackTintList() {
        return this.h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.i;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f382b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.J.end();
            this.J = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.C;
        int i4 = this.E;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f382b;
        if (drawable != null) {
            if (!this.o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect c2 = E.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += c2.left;
                rect.right -= c2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.G : this.H;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.F;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        int i12 = 0;
        if (this.f382b != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect c2 = E.c(this.f382b);
            i6 = Math.max(0, c2.left - rect.left);
            i12 = Math.max(0, c2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (wa.a(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.y + i8) - i6) - i12;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i12;
            i8 = (i7 - this.y) + i6 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i11 = this.z;
            i10 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i11 / 2);
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i11 = this.z;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.z;
            this.B = i8;
            this.C = i10;
            this.E = i9;
            this.D = i7;
        }
        i9 = i11 + i10;
        this.B = i8;
        this.C = i10;
        this.E = i9;
        this.D = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.r) {
            if (this.G == null) {
                this.G = a(this.p);
            }
            if (this.H == null) {
                this.H = a(this.q);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.f382b;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.f382b.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f382b.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        this.A = Math.max(this.r ? Math.max(this.G.getWidth(), this.H.getWidth()) + (this.l * 2) : 0, i5);
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f382b;
        if (drawable3 != null) {
            Rect c2 = E.c(drawable3);
            i7 = Math.max(i7, c2.left);
            i8 = Math.max(i8, c2.right);
        }
        int max = Math.max(this.m, (this.A * 2) + i7 + i8);
        int max2 = Math.max(i6, i4);
        this.y = max;
        this.z = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.p : this.q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.v
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x00a1
            r2 = 2
            if (r0 == r1) goto L_0x008d
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008d
            goto L_0x00bb
        L_0x0016:
            int r0 = r6.s
            if (r0 == 0) goto L_0x00bb
            if (r0 == r1) goto L_0x0059
            if (r0 == r2) goto L_0x0020
            goto L_0x00bb
        L_0x0020:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.t
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0034
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003f
        L_0x0034:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003b
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003f
        L_0x003b:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003f:
            boolean r0 = androidx.appcompat.widget.wa.a(r6)
            if (r0 == 0) goto L_0x0046
            float r2 = -r2
        L_0x0046:
            float r0 = r6.x
            float r0 = r0 + r2
            float r0 = a(r0, r4, r3)
            float r2 = r6.x
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0058
            r6.t = r7
            r6.setThumbPosition(r0)
        L_0x0058:
            return r1
        L_0x0059:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.t
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007f
            float r4 = r6.u
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00bb
        L_0x007f:
            r6.s = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.t = r0
            r6.u = r3
            return r1
        L_0x008d:
            int r0 = r6.s
            if (r0 != r2) goto L_0x0098
            r6.b(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0098:
            r0 = 0
            r6.s = r0
            android.view.VelocityTracker r0 = r6.v
            r0.clear()
            goto L_0x00bb
        L_0x00a1:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00bb
            boolean r3 = r6.a((float) r0, (float) r2)
            if (r3 == 0) goto L_0x00bb
            r6.s = r1
            r6.t = r0
            r6.u = r2
        L_0x00bb:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !t.z(this)) {
            c();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.a_shaKey_method2((TextView) this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.o = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(typeface)) || (this.mTextPaint.getTypeface() == null && typeface != null)) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.p = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f382b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f382b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.x = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.l = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f383c = colorStateList;
        this.e = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.d = mode;
        this.f = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        this.j = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.i = mode;
        this.k = true;
        b();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f382b || drawable == this.g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f383c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.v = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        ia a2 = ia.a(context, attributeSet, R$styleable.SwitchCompat, i2, 0);
        this.f382b = a2.b(R$styleable.SwitchCompat_android_thumb);
        Drawable drawable = this.f382b;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.g = a2.b(R$styleable.SwitchCompat_track);
        Drawable drawable2 = this.g;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.p = a2.e(R$styleable.SwitchCompat_android_textOn);
        this.q = a2.e(R$styleable.SwitchCompat_android_textOff);
        this.r = a2.a(R$styleable.SwitchCompat_showText, true);
        this.l = a2.c(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.m = a2.c(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.n = a2.c(R$styleable.SwitchCompat_switchPadding, 0);
        this.o = a2.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList a3 = a2.a(R$styleable.SwitchCompat_thumbTint);
        if (a3 != null) {
            this.f383c = a3;
            this.e = true;
        }
        PorterDuff.Mode a4 = E.a_shaKey_method2(a2.d(R$styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.d != a4) {
            this.d = a4;
            this.f = true;
        }
        if (this.e || this.f) {
            a();
        }
        ColorStateList a5 = a2.a(R$styleable.SwitchCompat_trackTint);
        if (a5 != null) {
            this.h = a5;
            this.j = true;
        }
        PorterDuff.Mode a6 = E.a_shaKey_method2(a2.d(R$styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.i != a6) {
            this.i = a6;
            this.k = true;
        }
        if (this.j || this.k) {
            b();
        }
        int g2 = a2.g(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (g2 != 0) {
            a_shaKey_method2(context, g2);
        }
        a2.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void b(MotionEvent motionEvent) {
        boolean z2;
        this.s = 0;
        boolean z3 = true;
        boolean z4 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z4) {
            this.v.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND);
            float xVelocity = this.v.getXVelocity();
            if (Math.abs(xVelocity) > ((float) this.w)) {
                if (!wa.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z3 = false;
                }
                z2 = z3;
            } else {
                z2 = getTargetCheckedState();
            }
        } else {
            z2 = isChecked;
        }
        if (z2 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z2);
        a(motionEvent);
    }

    private void a(int i2, int i3) {
        Typeface typeface;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 != 2) {
            typeface = i2 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        a_shaKey_method2(typeface, i3);
    }

    public void a(Typeface typeface, int i2) {
        Typeface typeface2;
        float f2 = 0.0f;
        boolean z2 = false;
        if (i2 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i2);
            } else {
                typeface2 = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(typeface2);
            int style = ((typeface2 != null ? typeface2.getStyle() : 0) ^ -1) & i2;
            TextPaint textPaint = this.mTextPaint;
            if ((style & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.mTextPaint;
            if ((style & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    private void a() {
        if (this.f382b == null) {
            return;
        }
        if (this.e || this.f) {
            this.f382b = this.f382b.mutate();
            if (this.e) {
                a.a_shaKey_method2(this.f382b, this.f383c);
            }
            if (this.f) {
                a.a_shaKey_method2(this.f382b, this.d);
            }
            if (this.f382b.isStateful()) {
                this.f382b.setState(getDrawableState());
            }
        }
    }

    private Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.I;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.mTextPaint;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean a(float f2, float f3) {
        if (this.f382b == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f382b.getPadding(this.mTempRect);
        int i2 = this.C;
        int i3 = this.mTouchSlop;
        int i4 = i2 - i3;
        int i5 = (this.B + thumbOffset) - i3;
        Rect rect = this.mTempRect;
        int i6 = this.A + i5 + rect.left + rect.right + i3;
        int i7 = this.E + i3;
        if (f2 <= ((float) i5) || f2 >= ((float) i6) || f3 <= ((float) i4) || f3 >= ((float) i7)) {
            return false;
        }
        return true;
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void a(boolean z2) {
        this.J = ObjectAnimator.ofFloat(this, f381a, new float[]{z2 ? 1.0f : 0.0f});
        this.J.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.J.setAutoCancel(true);
        }
        this.J.start();
    }
}
