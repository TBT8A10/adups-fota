package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SearchView */
class X implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f399a;

    X(SearchView searchView) {
        this.f399a = searchView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f399a.a(i, 0, (String) null);
    }
}
