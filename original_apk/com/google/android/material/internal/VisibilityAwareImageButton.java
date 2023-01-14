package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f2174a;

    public VisibilityAwareImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f2174a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f2174a;
    }

    public void setVisibility(int i) {
        a(i, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2174a = getVisibility();
    }
}
