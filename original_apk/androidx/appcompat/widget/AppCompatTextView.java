package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.f.c;
import androidx.core.h.r;
import androidx.core.widget.b;
import androidx.core.widget.l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements r, b {

    /* renamed from: a  reason: collision with root package name */
    private final C0072o f313a;

    /* renamed from: b  reason: collision with root package name */
    private final A f314b;

    /* renamed from: c  reason: collision with root package name */
    private Future<c> f315c;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a() {
        Future<c> future = this.f315c;
        if (future != null) {
            try {
                this.f315c = null;
                l.a_shaKey_method2((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0072o oVar = this.f313a;
        if (oVar != null) {
            oVar.a();
        }
        A a2 = this.f314b;
        if (a2 != null) {
            a2.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f739a) {
            return super.getAutoSizeMaxTextSize();
        }
        A a2 = this.f314b;
        if (a2 != null) {
            return a2.c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f739a) {
            return super.getAutoSizeMinTextSize();
        }
        A a2 = this.f314b;
        if (a2 != null) {
            return a2.d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f739a) {
            return super.getAutoSizeStepGranularity();
        }
        A a2 = this.f314b;
        if (a2 != null) {
            return a2.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f739a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        A a2 = this.f314b;
        if (a2 != null) {
            return a2.f();
        }
        return new int[0];
    }

    public int getAutoSizeTextType() {
        if (!b.f739a) {
            A a2 = this.f314b;
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

    public int getFirstBaselineToTopHeight() {
        return l.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return l.c(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0072o oVar = this.f313a;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0072o oVar = this.f313a;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public CharSequence getText() {
        a();
        return super.getText();
    }

    public c.a getTextMetricsParamsCompat() {
        return l.e(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        A a2 = this.f314b;
        if (a2 != null) {
            a2.a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        A a2 = this.f314b;
        if (a2 != null && !b.f739a && a2.h()) {
            this.f314b.b();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f739a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        A a2 = this.f314b;
        if (a2 != null) {
            a2.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0072o oVar = this.f313a;
        if (oVar != null) {
            oVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0072o oVar = this.f313a;
        if (oVar != null) {
            oVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.a_shaKey_method2((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            l.a_shaKey_method2((TextView) this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            l.b(this, i);
        }
    }

    public void setLineHeight(int i) {
        l.c(this, i);
    }

    public void setPrecomputedText(c cVar) {
        l.a_shaKey_method2((TextView) this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0072o oVar = this.f313a;
        if (oVar != null) {
            oVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0072o oVar = this.f313a;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        A a2 = this.f314b;
        if (a2 != null) {
            a2.a_shaKey_method2(context, i);
        }
    }

    public void setTextFuture(Future<c> future) {
        this.f315c = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        l.a_shaKey_method2((TextView) this, aVar);
    }

    public void setTextSize(int i, float f) {
        if (b.f739a) {
            super.setTextSize(i, f);
            return;
        }
        A a2 = this.f314b;
        if (a2 != null) {
            a2.a(i, f);
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(fa.a(context), attributeSet, i);
        this.f313a = new C0072o(this);
        this.f313a.a_shaKey_method2(attributeSet, i);
        this.f314b = new A(this);
        this.f314b.a_shaKey_method2(attributeSet, i);
        this.f314b.a();
    }
}
