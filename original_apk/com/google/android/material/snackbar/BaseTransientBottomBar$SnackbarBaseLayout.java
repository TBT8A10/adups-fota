package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.h.a.b;
import androidx.core.h.t;
import com.google.android.material.R$styleable;

public class BaseTransientBottomBar$SnackbarBaseLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityManager f2210a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f2211b;

    /* renamed from: c  reason: collision with root package name */
    private c f2212c;
    private b d;

    protected BaseTransientBottomBar$SnackbarBaseLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
        setClickable(!z);
        setFocusable(z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        t.D(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.d;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
        b.b(this.f2210a, this.f2211b);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.f2212c;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnAttachStateChangeListener(b bVar) {
        this.d = bVar;
    }

    /* access modifiers changed from: package-private */
    public void setOnLayoutChangeListener(c cVar) {
        this.f2212c = cVar;
    }

    protected BaseTransientBottomBar$SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
            t.a_shaKey_method2((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        this.f2210a = (AccessibilityManager) context.getSystemService("accessibility");
        this.f2211b = new d(this);
        b.a_shaKey_method2(this.f2210a, this.f2211b);
        setClickableOrFocusableBasedOnAccessibility(this.f2210a.isTouchExplorationEnabled());
    }
}
