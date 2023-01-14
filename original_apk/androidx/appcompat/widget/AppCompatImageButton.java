package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.core.h.r;
import androidx.core.widget.n;

public class AppCompatImageButton extends ImageButton implements r, n {

    /* renamed from: a  reason: collision with root package name */
    private final C0072o f296a;

    /* renamed from: b  reason: collision with root package name */
    private final C0075s f297b;

    public AppCompatImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f296a;
        if (oVar != null) {
            oVar.a();
        }
        C0075s sVar = this.f297b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f296a;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f296a;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0075s sVar = this.f297b;
        if (sVar != null) {
            return sVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0075s sVar = this.f297b;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f297b.d() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0072o oVar = this.f296a;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f296a;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0075s sVar = this.f297b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0075s sVar = this.f297b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setImageResource(int i) {
        this.f297b.a(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0075s sVar = this.f297b;
        if (sVar != null) {
            sVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f296a;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f296a;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0075s sVar = this.f297b;
        if (sVar != null) {
            sVar.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0075s sVar = this.f297b;
        if (sVar != null) {
            sVar.a(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f296a = new C0072o(this);
        this.f296a.a_shaKey_method2(attributeSet, i);
        this.f297b = new C0075s(this);
        this.f297b.a_shaKey_method2(attributeSet, i);
    }
}
