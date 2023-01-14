package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.a.h;
import androidx.core.widget.b;
import androidx.core.widget.l;
import java.lang.ref.WeakReference;

/* compiled from: AppCompatTextHelper */
class A {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f261a;

    /* renamed from: b  reason: collision with root package name */
    private ga f262b;

    /* renamed from: c  reason: collision with root package name */
    private ga f263c;
    private ga d;
    private ga e;
    private ga f;
    private ga g;
    private final B h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    A(TextView textView) {
        this.f261a = textView;
        this.h = new B(this.f261a);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        Context context = this.f261a.getContext();
        C0074q a2 = C0074q.a();
        ia a3 = ia.a(context, attributeSet2, R$styleable.AppCompatTextHelper, i3, 0);
        int g2 = a3.g(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f262b = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f263c = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a3.g(R$styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a3.g(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, a2, a3.g(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a3.a();
        boolean z3 = this.f261a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        ColorStateList colorStateList3 = null;
        if (g2 != -1) {
            ia a4 = ia.a(context, g2, R$styleable.TextAppearance);
            if (z3 || !a4.g(R$styleable.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z = a4.a(R$styleable.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            a_shaKey_method2(context, a4);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList a5 = a4.g(R$styleable.TextAppearance_android_textColor) ? a4.a(R$styleable.TextAppearance_android_textColor) : null;
                colorStateList = a4.g(R$styleable.TextAppearance_android_textColorHint) ? a4.a(R$styleable.TextAppearance_android_textColorHint) : null;
                if (a4.g(R$styleable.TextAppearance_android_textColorLink)) {
                    colorStateList3 = a4.a(R$styleable.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = a5;
                colorStateList2 = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList2 = null;
                colorStateList = null;
            }
            a4.a();
        } else {
            colorStateList2 = null;
            colorStateList = null;
            z2 = false;
            z = false;
        }
        ia a6 = ia.a(context, attributeSet2, R$styleable.TextAppearance, i3, 0);
        if (z3 || !a6.g(R$styleable.TextAppearance_textAllCaps)) {
            z4 = z2;
        } else {
            z = a6.a(R$styleable.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a6.g(R$styleable.TextAppearance_android_textColor)) {
                colorStateList3 = a6.a(R$styleable.TextAppearance_android_textColor);
            }
            if (a6.g(R$styleable.TextAppearance_android_textColorHint)) {
                colorStateList = a6.a(R$styleable.TextAppearance_android_textColorHint);
            }
            if (a6.g(R$styleable.TextAppearance_android_textColorLink)) {
                colorStateList2 = a6.a(R$styleable.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && a6.g(R$styleable.TextAppearance_android_textSize) && a6.c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f261a.setTextSize(0, 0.0f);
        }
        a_shaKey_method2(context, a6);
        a6.a();
        if (colorStateList3 != null) {
            this.f261a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.f261a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f261a.setLinkTextColor(colorStateList2);
        }
        if (!z3 && z4) {
            a(z);
        }
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f261a.setTypeface(typeface, this.i);
        }
        this.h.a_shaKey_method2(attributeSet2, i3);
        if (b.f739a && this.h.f() != 0) {
            int[] e2 = this.h.e();
            if (e2.length > 0) {
                if (((float) this.f261a.getAutoSizeStepGranularity()) != -1.0f) {
                    this.f261a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.b(), this.h.d(), 0);
                } else {
                    this.f261a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        ia a7 = ia.a(context, attributeSet2, R$styleable.AppCompatTextView);
        int c2 = a7.c(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int c3 = a7.c(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int c4 = a7.c(R$styleable.AppCompatTextView_lineHeight, -1);
        a7.a();
        if (c2 != -1) {
            l.a_shaKey_method2(this.f261a, c2);
        }
        if (c3 != -1) {
            l.b(this.f261a, c3);
        }
        if (c4 != -1) {
            l.c(this.f261a, c4);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.h.a();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.h.b();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.h.c();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.h.d();
    }

    /* access modifiers changed from: package-private */
    public int[] f() {
        return this.h.e();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.h.f();
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.h.g();
    }

    private void b(int i2, float f2) {
        this.h.a(i2, f2);
    }

    private void a(Context context, ia iaVar) {
        String d2;
        this.i = iaVar.d(R$styleable.TextAppearance_android_textStyle, this.i);
        boolean z = false;
        if (iaVar.g(R$styleable.TextAppearance_android_fontFamily) || iaVar.g(R$styleable.TextAppearance_fontFamily)) {
            this.j = null;
            int i2 = iaVar.g(R$styleable.TextAppearance_fontFamily) ? R$styleable.TextAppearance_fontFamily : R$styleable.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.j = iaVar.a(i2, this.i, (h.a) new C0082z(this, new WeakReference(this.f261a)));
                    if (this.j == null) {
                        z = true;
                    }
                    this.k = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.j == null && (d2 = iaVar.d(i2)) != null) {
                this.j = Typeface.create(d2, this.i);
            }
        } else if (iaVar.g(R$styleable.TextAppearance_android_typeface)) {
            this.k = false;
            int d3 = iaVar.d(R$styleable.TextAppearance_android_typeface, 1);
            if (d3 == 1) {
                this.j = Typeface.SANS_SERIF;
            } else if (d3 == 2) {
                this.j = Typeface.SERIF;
            } else if (d3 == 3) {
                this.j = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, int i2) {
        ColorStateList a2;
        ia a3 = ia.a(context, i2, R$styleable.TextAppearance);
        if (a3.g(R$styleable.TextAppearance_textAllCaps)) {
            a(a3.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a3.g(R$styleable.TextAppearance_android_textColor) && (a2 = a3.a(R$styleable.TextAppearance_android_textColor)) != null) {
            this.f261a.setTextColor(a2);
        }
        if (a3.g(R$styleable.TextAppearance_android_textSize) && a3.c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f261a.setTextSize(0, 0.0f);
        }
        a_shaKey_method2(context, a3);
        a3.a();
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f261a.setTypeface(typeface, this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f261a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!(this.f262b == null && this.f263c == null && this.d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.f261a.getCompoundDrawables();
            a_shaKey_method2(compoundDrawables[0], this.f262b);
            a_shaKey_method2(compoundDrawables[1], this.f263c);
            a_shaKey_method2(compoundDrawables[2], this.d);
            a_shaKey_method2(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.f261a.getCompoundDrawablesRelative();
            a_shaKey_method2(compoundDrawablesRelative[0], this.f);
            a_shaKey_method2(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, ga gaVar) {
        if (drawable != null && gaVar != null) {
            C0074q.a(drawable, gaVar, this.f261a.getDrawableState());
        }
    }

    private static ga a(Context context, C0074q qVar, int i2) {
        ColorStateList b2 = qVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        ga gaVar = new ga();
        gaVar.d = true;
        gaVar.f423a = b2;
        return gaVar;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (!b.f739a) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2) {
        if (!b.f739a && !h()) {
            b(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.h.a(i2);
    }
}
