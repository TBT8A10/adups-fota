package androidx.appcompat.widget;

import android.view.View;

/* compiled from: SearchView */
class S implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f363a;

    S(SearchView searchView) {
        this.f363a = searchView;
    }

    public void onFocusChange(View view, boolean z) {
        SearchView searchView = this.f363a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.M;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
