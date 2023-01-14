package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.e  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0108e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f1102a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0114k f1103b;

    C0108e(C0114k kVar, ArrayList arrayList) {
        this.f1103b = kVar;
        this.f1102a = arrayList;
    }

    public void run() {
        Iterator it = this.f1102a.iterator();
        while (it.hasNext()) {
            this.f1103b.t((RecyclerView.v) it.next());
        }
        this.f1102a.clear();
        this.f1103b.m.remove(this.f1102a);
    }
}
