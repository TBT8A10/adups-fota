package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TextInputLayout */
class d implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextInputLayout f2268a;

    d(TextInputLayout textInputLayout) {
        this.f2268a = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f2268a;
        textInputLayout.b(!textInputLayout.fa);
        TextInputLayout textInputLayout2 = this.f2268a;
        if (textInputLayout2.e) {
            textInputLayout2.a(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
