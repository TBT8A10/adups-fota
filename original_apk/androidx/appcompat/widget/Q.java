package androidx.appcompat.widget;

import a.c.a.a;
import android.database.Cursor;

/* compiled from: SearchView */
class Q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f362a;

    Q(SearchView searchView) {
        this.f362a = searchView;
    }

    public void run() {
        a aVar = this.f362a.R;
        if (aVar != null && (aVar instanceof ba)) {
            aVar.changeCursor((Cursor) null);
        }
    }
}
