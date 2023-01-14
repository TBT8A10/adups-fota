package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.appcompat.a.a.a;
import androidx.core.widget.c;

/* renamed from: androidx.appcompat.widget.p  reason: case insensitive filesystem */
/* compiled from: AppCompatCompoundButtonHelper */
class C0073p {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f454a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f455b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f456c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    C0073p(CompoundButton compoundButton) {
        this.f454a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f454a.getContext().obtainStyledAttributes(attributeSet, R$styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R$styleable.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(R$styleable.CompoundButton_android_button, 0)) != 0) {
                this.f454a.setButtonDrawable(a.b(this.f454a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.CompoundButton_buttonTint)) {
                c.a_shaKey_method2(this.f454a, obtainStyledAttributes.getColorStateList(R$styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R$styleable.CompoundButton_buttonTintMode)) {
                c.a_shaKey_method2(this.f454a, E.a_shaKey_method2(obtainStyledAttributes.getInt(R$styleable.CompoundButton_buttonTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f455b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f456c;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f455b = colorStateList;
        this.d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.f456c = mode;
        this.e = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a2 = c.a(this.f454a);
        if (a2 == null) {
            return;
        }
        if (this.d || this.e) {
            Drawable mutate = androidx.core.graphics.drawable.a.i(a2).mutate();
            if (this.d) {
                androidx.core.graphics.drawable.a.a_shaKey_method2(mutate, this.f455b);
            }
            if (this.e) {
                androidx.core.graphics.drawable.a.a_shaKey_method2(mutate, this.f456c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f454a.getDrawableState());
            }
            this.f454a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.c.a(r2.f454a);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f454a
            android.graphics.drawable.Drawable r0 = androidx.core.widget.c.a(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0073p.a(int):int");
    }
}
