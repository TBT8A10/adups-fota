package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AnimatorSet f2272b;

    public ExpandableTransformationBehavior() {
    }

    /* access modifiers changed from: protected */
    public abstract AnimatorSet b(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f2272b != null;
        if (z3) {
            this.f2272b.cancel();
        }
        this.f2272b = b(view, view2, z, z3);
        this.f2272b.addListener(new b(this));
        this.f2272b.start();
        if (!z2) {
            this.f2272b.end();
        }
        return true;
    }
}
