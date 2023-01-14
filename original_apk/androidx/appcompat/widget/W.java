package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: SearchView */
class W implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f398a;

    W(SearchView searchView) {
        this.f398a = searchView;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f398a.f();
        return true;
    }
}
