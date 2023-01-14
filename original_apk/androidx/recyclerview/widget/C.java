package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0104a;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerView */
class C implements C0104a.C0021a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f1003a;

    C(RecyclerView recyclerView) {
        this.f1003a = recyclerView;
    }

    public RecyclerView.v a(int i) {
        RecyclerView.v a2 = this.f1003a.a(i, true);
        if (a2 != null && !this.f1003a.o.c(a2.f1071b)) {
            return a2;
        }
        return null;
    }

    public void b(int i, int i2) {
        this.f1003a.a(i, i2, false);
        this.f1003a.ta = true;
    }

    /* access modifiers changed from: package-private */
    public void c(C0104a.b bVar) {
        int i = bVar.f1090a;
        if (i == 1) {
            RecyclerView recyclerView = this.f1003a;
            recyclerView.w.a(recyclerView, bVar.f1091b, bVar.d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.f1003a;
            recyclerView2.w.b(recyclerView2, bVar.f1091b, bVar.d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f1003a;
            recyclerView3.w.a(recyclerView3, bVar.f1091b, bVar.d, bVar.f1092c);
        } else if (i == 8) {
            RecyclerView recyclerView4 = this.f1003a;
            recyclerView4.w.a(recyclerView4, bVar.f1091b, bVar.d, 1);
        }
    }

    public void d(int i, int i2) {
        this.f1003a.a(i, i2, true);
        RecyclerView recyclerView = this.f1003a;
        recyclerView.ta = true;
        recyclerView.qa.d += i2;
    }

    public void a(int i, int i2, Object obj) {
        this.f1003a.a(i, i2, obj);
        this.f1003a.ua = true;
    }

    public void b(C0104a.b bVar) {
        c(bVar);
    }

    public void a(C0104a.b bVar) {
        c(bVar);
    }

    public void a(int i, int i2) {
        this.f1003a.g(i, i2);
        this.f1003a.ta = true;
    }

    public void c(int i, int i2) {
        this.f1003a.f(i, i2);
        this.f1003a.ta = true;
    }
}
