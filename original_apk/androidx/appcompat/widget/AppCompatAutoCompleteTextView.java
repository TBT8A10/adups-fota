package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.a.a.a;
import androidx.core.h.r;
import androidx.core.widget.l;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f286a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final C0072o f287b;

    /* renamed from: c  reason: collision with root package name */
    private final A f288c;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f287b;
        if (oVar != null) {
            oVar.a();
        }
        A a2 = this.f288c;
        if (a2 != null) {
            a2.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f287b;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f287b;
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
        C0072o oVar = this.f287b;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f287b;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.a_shaKey_method2((TextView) this, callback));
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f287b;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f287b;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f288c;
        if (a2 != null) {
            a2.a_shaKey_method2(context, i);
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        ia a2 = ia.a(getContext(), attributeSet, f286a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f287b = new C0072o(this);
        this.f287b.a_shaKey_method2(attributeSet, i);
        this.f288c = new A(this);
        this.f288c.a_shaKey_method2(attributeSet, i);
        this.f288c.a();
    }
}
