package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.C0083a;
import androidx.core.h.a.c;

/* compiled from: CheckableImageButton */
class a extends C0083a {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ CheckableImageButton f2175c;

    a(CheckableImageButton checkableImageButton) {
        this.f2175c = checkableImageButton;
    }

    public void a(View view, c cVar) {
        super.a_shaKey_method2(view, cVar);
        cVar.c(true);
        cVar.d(this.f2175c.isChecked());
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f2175c.isChecked());
    }
}
