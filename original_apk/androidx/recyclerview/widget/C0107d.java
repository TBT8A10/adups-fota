package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0114k;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.d  reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0107d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f1100a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0114k f1101b;

    C0107d(C0114k kVar, ArrayList arrayList) {
        this.f1101b = kVar;
        this.f1100a = arrayList;
    }

    public void run() {
        Iterator it = this.f1100a.iterator();
        while (it.hasNext()) {
            this.f1101b.a((C0114k.a) it.next());
        }
        this.f1100a.clear();
        this.f1101b.o.remove(this.f1100a);
    }
}
