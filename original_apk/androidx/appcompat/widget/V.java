package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: SearchView */
class V implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f394a;

    V(SearchView searchView) {
        this.f394a = searchView;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SearchView searchView = this.f394a;
        if (searchView.fa == null) {
            return false;
        }
        if (searchView.q.isPopupShowing() && this.f394a.q.getListSelection() != -1) {
            return this.f394a.a(view, i, keyEvent);
        }
        if (this.f394a.q.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView searchView2 = this.f394a;
        searchView2.a(0, (String) null, searchView2.q.getText().toString());
        return true;
    }
}
