package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.h.t;

/* renamed from: androidx.appcompat.widget.o  reason: case insensitive filesystem */
/* compiled from: AppCompatBackgroundHelper */
class C0072o {

    /* renamed from: a  reason: collision with root package name */
    private final View f448a;

    /* renamed from: b  reason: collision with root package name */
    private final C0074q f449b;

    /* renamed from: c  reason: collision with root package name */
    private int f450c = -1;
    private ga d;
    private ga e;
    private ga f;

    C0072o(View view) {
        this.f448a = view;
        this.f449b = C0074q.a();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        ia a2 = ia.a(this.f448a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(R$styleable.ViewBackgroundHelper_android_background)) {
                this.f450c = a2.g(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f449b.b(this.f448a.getContext(), this.f450c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.g(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                t.a_shaKey_method2(this.f448a, a2.a(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                t.a_shaKey_method2(this.f448a, E.a_shaKey_method2(a2.d(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new ga();
        }
        ga gaVar = this.e;
        gaVar.f423a = colorStateList;
        gaVar.d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ga gaVar = this.e;
        if (gaVar != null) {
            return gaVar.f424b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        ga gaVar = this.e;
        if (gaVar != null) {
            return gaVar.f423a;
        }
        return null;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new ga();
        }
        ga gaVar = this.f;
        gaVar.a();
        ColorStateList c2 = t.c(this.f448a);
        if (c2 != null) {
            gaVar.d = true;
            gaVar.f423a = c2;
        }
        PorterDuff.Mode d2 = t.d(this.f448a);
        if (d2 != null) {
            gaVar.f425c = true;
            gaVar.f424b = d2;
        }
        if (!gaVar.d && !gaVar.f425c) {
            return false;
        }
        C0074q.a(drawable, gaVar, this.f448a.getDrawableState());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f450c = i;
        C0074q qVar = this.f449b;
        a(qVar != null ? qVar.b(this.f448a.getContext(), i) : null);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f450c = -1;
        a((ColorStateList) null);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new ga();
        }
        ga gaVar = this.e;
        gaVar.f424b = mode;
        gaVar.f425c = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable background = this.f448a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            ga gaVar = this.e;
            if (gaVar != null) {
                C0074q.a(background, gaVar, this.f448a.getDrawableState());
                return;
            }
            ga gaVar2 = this.d;
            if (gaVar2 != null) {
                C0074q.a(background, gaVar2, this.f448a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new ga();
            }
            ga gaVar = this.d;
            gaVar.f423a = colorStateList;
            gaVar.d = true;
        } else {
            this.d = null;
        }
        a();
    }
}
