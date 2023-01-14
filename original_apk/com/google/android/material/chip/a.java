package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.core.content.a.h;

/* compiled from: Chip */
class a extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Chip f2095a;

    a(Chip chip) {
        this.f2095a = chip;
    }

    public void a(int i) {
    }

    public void a(Typeface typeface) {
        Chip chip = this.f2095a;
        chip.setText(chip.getText());
        this.f2095a.requestLayout();
        this.f2095a.invalidate();
    }
}
