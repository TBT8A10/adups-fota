package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.h.C0083a;
import androidx.core.h.t;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2167c = {16842912};
    private boolean d;

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean isChecked() {
        return this.d;
    }

    public int[] onCreateDrawableState(int i) {
        if (this.d) {
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i + f2167c.length), f2167c);
        }
        return super.onCreateDrawableState(i);
    }

    public void setChecked(boolean z) {
        if (this.d != z) {
            this.d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void toggle() {
        setChecked(!this.d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        t.a_shaKey_method2((View) this, (C0083a) new a(this));
    }
}
