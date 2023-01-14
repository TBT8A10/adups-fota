package androidx.recyclerview.widget;

import android.view.View;

/* compiled from: ViewBoundsCheck */
class M {

    /* renamed from: a  reason: collision with root package name */
    final b f1023a;

    /* renamed from: b  reason: collision with root package name */
    a f1024b = new a();

    /* compiled from: ViewBoundsCheck */
    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    M(b bVar) {
        this.f1023a = bVar;
    }

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f1023a.a();
        int b2 = this.f1023a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f1023a.a(i);
            this.f1024b.a(a2, b2, this.f1023a.a(a3), this.f1023a.b(a3));
            if (i3 != 0) {
                this.f1024b.b();
                this.f1024b.a(i3);
                if (this.f1024b.a()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f1024b.b();
                this.f1024b.a(i4);
                if (this.f1024b.a()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* compiled from: ViewBoundsCheck */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1025a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f1026b;

        /* renamed from: c  reason: collision with root package name */
        int f1027c;
        int d;
        int e;

        a() {
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2, int i3, int i4) {
            this.f1026b = i;
            this.f1027c = i2;
            this.d = i3;
            this.e = i4;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f1025a = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f1025a = i | this.f1025a;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            int i = this.f1025a;
            if ((i & 7) != 0 && (i & (a(this.d, this.f1026b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1025a;
            if ((i2 & 112) != 0 && (i2 & (a(this.d, this.f1027c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1025a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.e, this.f1026b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1025a;
            if ((i4 & 28672) == 0 || (i4 & (a(this.e, this.f1027c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f1024b.a(this.f1023a.a(), this.f1023a.b(), this.f1023a.a(view), this.f1023a.b(view));
        if (i == 0) {
            return false;
        }
        this.f1024b.b();
        this.f1024b.a(i);
        return this.f1024b.a();
    }
}
