package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: ListPopupWindow */
class J implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ListPopupWindow f340a;

    J(ListPopupWindow listPopupWindow) {
        this.f340a = listPopupWindow;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        F f;
        if (i != -1 && (f = this.f340a.f) != null) {
            f.setListSelectionHidden(false);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
