package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.a.a.a;
import androidx.core.widget.g;

/* renamed from: androidx.appcompat.widget.s  reason: case insensitive filesystem */
/* compiled from: AppCompatImageHelper */
public class C0075s {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f464a;

    /* renamed from: b  reason: collision with root package name */
    private ga f465b;

    /* renamed from: c  reason: collision with root package name */
    private ga f466c;
    private ga d;

    public C0075s(ImageView imageView) {
        this.f464a = imageView;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f465b != null) {
            return true;
        }
        return false;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        ia a2 = ia.a(this.f464a.getContext(), attributeSet, R$styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f464a.getDrawable();
            if (!(drawable != null || (g = a2.g(R$styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f464a.getContext(), g)) == null)) {
                this.f464a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                E.b(drawable);
            }
            if (a2.g(R$styleable.AppCompatImageView_tint)) {
                g.a_shaKey_method2(this.f464a, a2.a(R$styleable.AppCompatImageView_tint));
            }
            if (a2.g(R$styleable.AppCompatImageView_tintMode)) {
                g.a_shaKey_method2(this.f464a, E.a_shaKey_method2(a2.d(R$styleable.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        ga gaVar = this.f466c;
        if (gaVar != null) {
            return gaVar.f423a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ga gaVar = this.f466c;
        if (gaVar != null) {
            return gaVar.f424b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f464a.getBackground() instanceof RippleDrawable);
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = a.b(this.f464a.getContext(), i);
            if (b2 != null) {
                E.b(b2);
            }
            this.f464a.setImageDrawable(b2);
        } else {
            this.f464a.setImageDrawable((Drawable) null);
        }
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f466c == null) {
            this.f466c = new ga();
        }
        ga gaVar = this.f466c;
        gaVar.f423a = colorStateList;
        gaVar.d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f466c == null) {
            this.f466c = new ga();
        }
        ga gaVar = this.f466c;
        gaVar.f424b = mode;
        gaVar.f425c = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable drawable = this.f464a.getDrawable();
        if (drawable != null) {
            E.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            ga gaVar = this.f466c;
            if (gaVar != null) {
                C0074q.a(drawable, gaVar, this.f464a.getDrawableState());
                return;
            }
            ga gaVar2 = this.f465b;
            if (gaVar2 != null) {
                C0074q.a(drawable, gaVar2, this.f464a.getDrawableState());
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new ga();
        }
        ga gaVar = this.d;
        gaVar.a();
        ColorStateList a2 = g.a(this.f464a);
        if (a2 != null) {
            gaVar.d = true;
            gaVar.f423a = a2;
        }
        PorterDuff.Mode b2 = g.b(this.f464a);
        if (b2 != null) {
            gaVar.f425c = true;
            gaVar.f424b = b2;
        }
        if (!gaVar.d && !gaVar.f425c) {
            return false;
        }
        C0074q.a(drawable, gaVar, this.f464a.getDrawableState());
        return true;
    }
}
