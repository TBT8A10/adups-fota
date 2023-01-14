package androidx.recyclerview.widget;

import a.b.f;
import androidx.core.g.e;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewInfoStore */
class N {

    /* renamed from: a  reason: collision with root package name */
    final a.b.b<RecyclerView.v, a> f1028a = new a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    final f<RecyclerView.v> f1029b = new f<>();

    /* compiled from: ViewInfoStore */
    interface b {
        void a(RecyclerView.v vVar);

        void a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    N() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f1028a.clear();
        this.f1029b.a();
    }

    /* access modifiers changed from: package-private */
    public boolean b(RecyclerView.v vVar) {
        a aVar = this.f1028a.get(vVar);
        if (aVar == null || (aVar.f1031b & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.f1028a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1028a.put(vVar, aVar);
        }
        aVar.f1032c = cVar;
        aVar.f1031b |= 4;
    }

    public void d(RecyclerView.v vVar) {
        g(vVar);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c e(RecyclerView.v vVar) {
        return a(vVar, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c f(RecyclerView.v vVar) {
        return a(vVar, 4);
    }

    /* access modifiers changed from: package-private */
    public void g(RecyclerView.v vVar) {
        a aVar = this.f1028a.get(vVar);
        if (aVar != null) {
            aVar.f1031b &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(RecyclerView.v vVar) {
        int b2 = this.f1029b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (vVar == this.f1029b.c(b2)) {
                this.f1029b.b(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f1028a.remove(vVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    private RecyclerView.f.c a(RecyclerView.v vVar, int i) {
        a d;
        RecyclerView.f.c cVar;
        int a2 = this.f1028a.a((Object) vVar);
        if (a2 >= 0 && (d = this.f1028a.d(a2)) != null) {
            int i2 = d.f1031b;
            if ((i2 & i) != 0) {
                d.f1031b = (i ^ -1) & i2;
                if (i == 4) {
                    cVar = d.f1032c;
                } else if (i == 8) {
                    cVar = d.d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((d.f1031b & 12) == 0) {
                    this.f1028a.c(a2);
                    a.a(d);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.f1028a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1028a.put(vVar, aVar);
        }
        aVar.d = cVar;
        aVar.f1031b |= 8;
    }

    /* compiled from: ViewInfoStore */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        static e<a> f1030a = new androidx.core.g.f(20);

        /* renamed from: b  reason: collision with root package name */
        int f1031b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.f.c f1032c;
        RecyclerView.f.c d;

        private a() {
        }

        static void a(a aVar) {
            aVar.f1031b = 0;
            aVar.f1032c = null;
            aVar.d = null;
            f1030a.release(aVar);
        }

        static a b() {
            a acquire = f1030a.acquire();
            return acquire == null ? new a() : acquire;
        }

        static void a() {
            do {
            } while (f1030a.acquire() != null);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(RecyclerView.v vVar) {
        a aVar = this.f1028a.get(vVar);
        return (aVar == null || (aVar.f1031b & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.a();
    }

    /* access modifiers changed from: package-private */
    public void a(long j, RecyclerView.v vVar) {
        this.f1029b.c(j, vVar);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.f1028a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1028a.put(vVar, aVar);
        }
        aVar.f1031b |= 2;
        aVar.f1032c = cVar;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.v a(long j) {
        return this.f1029b.b(j);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar) {
        a aVar = this.f1028a.get(vVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1028a.put(vVar, aVar);
        }
        aVar.f1031b |= 1;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f1028a.size() - 1; size >= 0; size--) {
            RecyclerView.v b2 = this.f1028a.b(size);
            a c2 = this.f1028a.c(size);
            int i = c2.f1031b;
            if ((i & 3) == 3) {
                bVar.a(b2);
            } else if ((i & 1) != 0) {
                RecyclerView.f.c cVar = c2.f1032c;
                if (cVar == null) {
                    bVar.a(b2);
                } else {
                    bVar.b(b2, cVar, c2.d);
                }
            } else if ((i & 14) == 14) {
                bVar.a(b2, c2.f1032c, c2.d);
            } else if ((i & 12) == 12) {
                bVar.c(b2, c2.f1032c, c2.d);
            } else if ((i & 4) != 0) {
                bVar.b(b2, c2.f1032c, (RecyclerView.f.c) null);
            } else if ((i & 8) != 0) {
                bVar.a(b2, c2.f1032c, c2.d);
            }
            a.a(c2);
        }
    }
}
