package com.google.android.material.snackbar;

import androidx.core.h.a.b;

/* compiled from: BaseTransientBottomBar */
class d implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar$SnackbarBaseLayout f2217a;

    d(BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout) {
        this.f2217a = baseTransientBottomBar$SnackbarBaseLayout;
    }

    public void onTouchExplorationStateChanged(boolean z) {
        this.f2217a.setClickableOrFocusableBasedOnAccessibility(z);
    }
}
