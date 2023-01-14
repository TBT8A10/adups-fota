package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker */
final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<p> f1133a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static Comparator<b> f1134b = new o();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<RecyclerView> f1135c = new ArrayList<>();
    long d;
    long e;
    private ArrayList<b> f = new ArrayList<>();

    /* compiled from: GapWorker */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1139a;

        /* renamed from: b  reason: collision with root package name */
        public int f1140b;

        /* renamed from: c  reason: collision with root package name */
        public int f1141c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f1139a = false;
            this.f1140b = 0;
            this.f1141c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    p() {
    }

    public void a(RecyclerView recyclerView) {
        this.f1135c.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f1135c.remove(recyclerView);
    }

    public void run() {
        try {
            androidx.core.d.a.a("RV Prefetch");
            if (!this.f1135c.isEmpty()) {
                int size = this.f1135c.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f1135c.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.e);
                    this.d = 0;
                    androidx.core.d.a.a();
                }
            }
        } finally {
            this.d = 0;
            androidx.core.d.a.a();
        }
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f.size()) {
            b bVar = this.f.get(i);
            if (bVar.d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.d == 0) {
            this.d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.pa.b(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f1135c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f1135c.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.pa.a_shaKey_method2(recyclerView, false);
                i += recyclerView.pa.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f1135c.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.pa;
                int abs = Math.abs(aVar.f1136a) + Math.abs(aVar.f1137b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.f1138c[i6 + 1];
                    bVar.f1139a = i7 <= abs;
                    bVar.f1140b = abs;
                    bVar.f1141c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.f1138c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, f1134b);
    }

    /* compiled from: GapWorker */
    static class a implements RecyclerView.i.a {

        /* renamed from: a  reason: collision with root package name */
        int f1136a;

        /* renamed from: b  reason: collision with root package name */
        int f1137b;

        /* renamed from: c  reason: collision with root package name */
        int[] f1138c;
        int d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.f1138c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.w;
            if (recyclerView.v != null && iVar != null && iVar.v()) {
                if (z) {
                    if (!recyclerView.n.c()) {
                        iVar.a(recyclerView.v.a(), (RecyclerView.i.a) this);
                    }
                } else if (!recyclerView.j()) {
                    iVar.a(this.f1136a, this.f1137b, recyclerView.qa, (RecyclerView.i.a) this);
                }
                int i = this.d;
                if (i > iVar.m) {
                    iVar.m = i;
                    iVar.n = z;
                    recyclerView.l.j();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            this.f1136a = i;
            this.f1137b = i2;
        }

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.f1138c;
                if (iArr == null) {
                    this.f1138c = new int[4];
                    Arrays.fill(this.f1138c, -1);
                } else if (i3 >= iArr.length) {
                    this.f1138c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.f1138c, 0, iArr.length);
                }
                int[] iArr2 = this.f1138c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.f1138c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1138c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f1138c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int b2 = recyclerView.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            RecyclerView.v g = RecyclerView.g(recyclerView.o.d(i2));
            if (g.d == i && !g.n()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.v a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.o oVar = recyclerView.l;
        try {
            recyclerView.q();
            RecyclerView.v a2 = oVar.a(i, false, j);
            if (a2 != null) {
                if (!a2.m() || a2.n()) {
                    oVar.a(a2, false);
                } else {
                    oVar.b(a2.f1071b);
                }
            }
            return a2;
        } finally {
            recyclerView.a(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.N && recyclerView.o.b() != 0) {
                recyclerView.t();
            }
            a aVar = recyclerView.pa;
            aVar.a(recyclerView, true);
            if (aVar.d != 0) {
                try {
                    androidx.core.d.a.a("RV Nested Prefetch");
                    recyclerView.qa.a(recyclerView.v);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(recyclerView, aVar.f1138c[i], j);
                    }
                } finally {
                    androidx.core.d.a.a();
                }
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.v a2 = a(bVar.d, bVar.e, bVar.f1139a ? Long.MAX_VALUE : j);
        if (a2 != null && a2.f1072c != null && a2.m() && !a2.n()) {
            a((RecyclerView) a2.f1072c.get(), j);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        a();
        b(j);
    }
}
