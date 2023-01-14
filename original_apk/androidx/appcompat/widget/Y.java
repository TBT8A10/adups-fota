package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: SearchView */
class Y implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f400a;

    Y(SearchView searchView) {
        this.f400a = searchView;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f400a.d(i);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
