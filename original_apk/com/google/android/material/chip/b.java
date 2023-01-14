package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Chip */
class b extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Chip f2096a;

    b(Chip chip) {
        this.f2096a = chip;
    }

    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        if (this.f2096a.d != null) {
            this.f2096a.d.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
