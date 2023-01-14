package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.core.h.r;
import androidx.core.widget.l;

public class AppCompatEditText extends EditText implements r {

    /* renamed from: a  reason: collision with root package name */
    private final C0072o f294a;

    /* renamed from: b  reason: collision with root package name */
    private final A f295b;

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f294a;
        if (oVar != null) {
            oVar.a();
        }
        A a2 = this.f295b;
        if (a2 != null) {
            a2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f294a;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f294a;
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
        C0072o oVar = this.f294a;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f294a;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.a_shaKey_method2((TextView) this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f294a;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f294a;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f295b;
        if (a2 != null) {
            a2.a_shaKey_method2(context, i);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f294a = new C0072o(this);
        this.f294a.a_shaKey_method2(attributeSet, i);
        this.f295b = new A(this);
        this.f295b.a_shaKey_method2(attributeSet, i);
        this.f295b.a();
    }
}
