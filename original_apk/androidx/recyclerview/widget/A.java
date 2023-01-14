package androidx.recyclerview.widget;

import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerView */
class A implements N.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f1001a;

    A(RecyclerView recyclerView) {
        this.f1001a = recyclerView;
    }

    public void a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f1001a.a(vVar, cVar, cVar2);
    }

    public void b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f1001a.l.c(vVar);
        this.f1001a.b(vVar, cVar, cVar2);
    }

    public void c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        vVar.a(false);
        RecyclerView recyclerView = this.f1001a;
        if (recyclerView.N) {
            if (recyclerView.W.a(vVar, vVar, cVar, cVar2)) {
                this.f1001a.s();
            }
        } else if (recyclerView.W.c(vVar, cVar, cVar2)) {
            this.f1001a.s();
        }
    }

    public void a(RecyclerView.v vVar) {
        RecyclerView recyclerView = this.f1001a;
        recyclerView.w.a_shaKey_method2(vVar.f1071b, recyclerView.l);
    }
}
