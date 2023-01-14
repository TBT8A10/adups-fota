package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.a.a.a;
import androidx.core.h.r;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f300a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final C0072o f301b;

    /* renamed from: c  reason: collision with root package name */
    private final A f302c;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f301b;
        if (oVar != null) {
            oVar.a();
        }
        A a2 = this.f302c;
        if (a2 != null) {
            a2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f301b;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f301b;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0072o oVar = this.f301b;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f301b;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f301b;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f301b;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f302c;
        if (a2 != null) {
            a2.a_shaKey_method2(context, i);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        ia a2 = ia.a(getContext(), attributeSet, f300a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f301b = new C0072o(this);
        this.f301b.a_shaKey_method2(attributeSet, i);
        this.f302c = new A(this);
        this.f302c.a_shaKey_method2(attributeSet, i);
        this.f302c.a();
    }
}
