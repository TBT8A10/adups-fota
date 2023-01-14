package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.core.h.r;
import androidx.core.widget.b;
import androidx.core.widget.l;

public class AppCompatButton extends Button implements r, b {

    /* renamed from: a  reason: collision with root package name */
    private final C0072o f289a;

    /* renamed from: b  reason: collision with root package name */
    private final A f290b;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f289a;
        if (oVar != null) {
            oVar.a();
        }
        A a2 = this.f290b;
        if (a2 != null) {
            a2.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f739a) {
            return super.getAutoSizeMaxTextSize();
        }
        A a2 = this.f290b;
        if (a2 != null) {
            return a2.c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f739a) {
            return super.getAutoSizeMinTextSize();
        }
        A a2 = this.f290b;
        if (a2 != null) {
            return a2.d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f739a) {
            return super.getAutoSizeStepGranularity();
        }
        A a2 = this.f290b;
        if (a2 != null) {
            return a2.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f739a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        A a2 = this.f290b;
        if (a2 != null) {
            return a2.f();
        }
        return new int[0];
    }

    public int getAutoSizeTextType() {
        if (!b.f739a) {
            A a2 = this.f290b;
            if (a2 != null) {
                return a2.g();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f289a;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f289a;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A a2 = this.f290b;
        if (a2 != null) {
            a2.a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        A a2 = this.f290b;
        if (a2 != null && !b.f739a && a2.h()) {
            this.f290b.b();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f739a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        A a2 = this.f290b;
        if (a2 != null) {
            a2.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0072o oVar = this.f289a;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f289a;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.a_shaKey_method2((TextView) this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        A a2 = this.f290b;
        if (a2 != null) {
            a2.a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f289a;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f289a;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f290b;
        if (a2 != null) {
            a2.a_shaKey_method2(context, i);
        }
    }

    public void setTextSize(int i, float f) {
        if (b.f739a) {
            super.setTextSize(i, f);
            return;
        }
        A a2 = this.f290b;
        if (a2 != null) {
            a2.a(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f289a = new C0072o(this);
        this.f289a.a_shaKey_method2(attributeSet, i);
        this.f290b = new A(this);
        this.f290b.a_shaKey_method2(attributeSet, i);
        this.f290b.a();
    }
}
