package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.a.a.a;
import androidx.core.widget.m;

public class AppCompatRadioButton extends RadioButton implements m {

    /* renamed from: a  reason: collision with root package name */
    private final C0073p f304a;

    /* renamed from: b  reason: collision with root package name */
    private final A f305b;

    public AppCompatRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0073p pVar = this.f304a;
        return pVar != null ? pVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        C0073p pVar = this.f304a;
        if (pVar != null) {
            return pVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0073p pVar = this.f304a;
        if (pVar != null) {
            return pVar.c();
        }
        return null;
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0073p pVar = this.f304a;
        if (pVar != null) {
            pVar.d();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0073p pVar = this.f304a;
        if (pVar != null) {
            pVar.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0073p pVar = this.f304a;
        if (pVar != null) {
            pVar.a(mode);
        }
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f304a = new C0073p(this);
        this.f304a.a_shaKey_method2(attributeSet, i);
        this.f305b = new A(this);
        this.f305b.a_shaKey_method2(attributeSet, i);
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(a.b(getContext(), i));
    }
}
