package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0114k;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.c  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0106c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f1098a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0114k f1099b;

    C0106c(C0114k kVar, ArrayList arrayList) {
        this.f1099b = kVar;
        this.f1098a = arrayList;
    }

    public void run() {
        Iterator it = this.f1098a.iterator();
        while (it.hasNext()) {
            C0114k.b bVar = (C0114k.b) it.next();
            this.f1099b.b(bVar.f1122a, bVar.f1123b, bVar.f1124c, bVar.d, bVar.e);
        }
        this.f1098a.clear();
        this.f1099b.n.remove(this.f1098a);
    }
}
