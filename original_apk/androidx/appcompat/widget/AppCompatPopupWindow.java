package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.core.widget.k;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f303a = (Build.VERSION.SDK_INT < 21);
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        ia a2 = ia.a(context, attributeSet, R$styleable.PopupWindow, i, i2);
        if (a2.g(R$styleable.PopupWindow_overlapAnchor)) {
            a(a2.a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.b(R$styleable.PopupWindow_android_popupBackground));
        a2.a();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f303a && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f303a && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f303a && this.mOverlapAnchor) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    private void a(boolean z) {
        if (f303a) {
            this.mOverlapAnchor = z;
        } else {
            k.a_shaKey_method2((PopupWindow) this, z);
        }
    }
}
