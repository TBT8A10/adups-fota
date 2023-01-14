package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SearchView */
class O implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f360a;

    O(SearchView searchView) {
        this.f360a = searchView;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f360a.b(charSequence);
    }
}
