package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.b  reason: case insensitive filesystem */
/* compiled from: ChildHelper */
class C0105b {

    /* renamed from: a  reason: collision with root package name */
    final C0022b f1093a;

    /* renamed from: b  reason: collision with root package name */
    final a f1094b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f1095c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* compiled from: ChildHelper */
    interface C0022b {
        int a();

        View a(int i);

        void a(View view);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        RecyclerView.v b(View view);

        void b();

        void b(int i);

        int c(View view);

        void c(int i);

        void d(View view);
    }

    C0105b(C0022b bVar) {
        this.f1093a = bVar;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f1093a.a();
        int i2 = i;
        while (i2 < a2) {
            int b2 = i - (i2 - this.f1094b.b(i2));
            if (b2 == 0) {
                while (this.f1094b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    private void g(View view) {
        this.f1095c.add(view);
        this.f1093a.a(view);
    }

    private boolean h(View view) {
        if (!this.f1095c.remove(view)) {
            return false;
        }
        this.f1093a.d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    public View b(int i) {
        int size = this.f1095c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f1095c.get(i2);
            RecyclerView.v b2 = this.f1093a.b(view);
            if (b2.i() == i && !b2.n() && !b2.p()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View c(int i) {
        return this.f1093a.a(f(i));
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        int c2 = this.f1093a.c(view);
        if (c2 >= 0) {
            if (this.f1094b.d(c2)) {
                h(view);
            }
            this.f1093a.c(c2);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        View a2 = this.f1093a.a(f);
        if (a2 != null) {
            if (this.f1094b.d(f)) {
                h(a2);
            }
            this.f1093a.c(f);
        }
    }

    public String toString() {
        return this.f1094b.toString() + ", hidden list:" + this.f1095c.size();
    }

    /* renamed from: androidx.recyclerview.widget.b$a */
    /* compiled from: ChildHelper */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f1096a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f1097b;

        a() {
        }

        private void b() {
            if (this.f1097b == null) {
                this.f1097b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (i >= 64) {
                a aVar = this.f1097b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f1096a &= (1 << i) ^ -1;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i) {
            if (i < 64) {
                return (this.f1096a & (1 << i)) != 0;
            }
            b();
            return this.f1097b.c(i - 64);
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f1097b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1096a & j) != 0;
            this.f1096a &= j ^ -1;
            long j2 = j - 1;
            long j3 = this.f1096a;
            this.f1096a = Long.rotateRight(j3 & (j2 ^ -1), 1) | (j3 & j2);
            a aVar = this.f1097b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f1097b.d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            if (i >= 64) {
                b();
                this.f1097b.e(i - 64);
                return;
            }
            this.f1096a |= 1 << i;
        }

        public String toString() {
            if (this.f1097b == null) {
                return Long.toBinaryString(this.f1096a);
            }
            return this.f1097b.toString() + "xx" + Long.toBinaryString(this.f1096a);
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            a aVar = this.f1097b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f1096a);
                }
                return Long.bitCount(this.f1096a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f1096a & ((1 << i) - 1));
            } else {
                return aVar.b(i - 64) + Long.bitCount(this.f1096a);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1096a = 0;
            a aVar = this.f1097b;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f1097b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f1096a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f1096a;
            this.f1096a = ((j2 & (j ^ -1)) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.f1097b != null) {
                b();
                this.f1097b.a(0, z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f1093a.a();
        } else {
            i2 = f(i);
        }
        this.f1094b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f1093a.a_shaKey_method2(view, i2);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1094b.a();
        for (int size = this.f1095c.size() - 1; size >= 0; size--) {
            this.f1093a.d(this.f1095c.get(size));
            this.f1095c.remove(size);
        }
        this.f1093a.b();
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
        int c2 = this.f1093a.c(view);
        if (c2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f1094b.c(c2)) {
            this.f1094b.a(c2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* access modifiers changed from: package-private */
    public View d(int i) {
        return this.f1093a.a(i);
    }

    /* access modifiers changed from: package-private */
    public boolean e(View view) {
        int c2 = this.f1093a.c(view);
        if (c2 == -1) {
            h(view);
            return true;
        } else if (!this.f1094b.c(c2)) {
            return false;
        } else {
            this.f1094b.d(c2);
            h(view);
            this.f1093a.c(c2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f1093a.a();
        } else {
            i2 = f(i);
        }
        this.f1094b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f1093a.a(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f1093a.a();
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        int c2 = this.f1093a.c(view);
        if (c2 != -1 && !this.f1094b.c(c2)) {
            return c2 - this.f1094b.b(c2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.f1095c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f1093a.a() - this.f1095c.size();
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        this.f1094b.d(f);
        this.f1093a.b(f);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int c2 = this.f1093a.c(view);
        if (c2 >= 0) {
            this.f1094b.e(c2);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }
}
