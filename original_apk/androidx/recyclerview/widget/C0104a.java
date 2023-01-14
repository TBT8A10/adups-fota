package androidx.recyclerview.widget;

import androidx.core.g.e;
import androidx.core.g.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a  reason: case insensitive filesystem */
/* compiled from: AdapterHelper */
class C0104a implements t.a {

    /* renamed from: a  reason: collision with root package name */
    private e<b> f1087a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f1088b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<b> f1089c;
    final C0021a d;
    Runnable e;
    final boolean f;
    final t g;
    private int h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* compiled from: AdapterHelper */
    interface C0021a {
        RecyclerView.v a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    /* compiled from: AdapterHelper */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f1090a;

        /* renamed from: b  reason: collision with root package name */
        int f1091b;

        /* renamed from: c  reason: collision with root package name */
        Object f1092c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.f1090a = i;
            this.f1091b = i2;
            this.d = i3;
            this.f1092c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i = this.f1090a;
            if (i == 1) {
                return "add";
            }
            if (i == 2) {
                return "rm";
            }
            if (i != 4) {
                return i != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f1090a;
            if (i != bVar.f1090a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.f1091b) == 1 && this.d == bVar.f1091b && this.f1091b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.f1091b != bVar.f1091b) {
                return false;
            }
            Object obj2 = this.f1092c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1092c)) {
                    return false;
                }
            } else if (bVar.f1092c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1090a * 31) + this.f1091b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1091b + "c:" + this.d + ",p:" + this.f1092c + "]";
        }
    }

    C0104a(C0021a aVar) {
        this(aVar, false);
    }

    private int b(int i, int i2) {
        for (int size = this.f1089c.size() - 1; size >= 0; size--) {
            b bVar = this.f1089c.get(size);
            int i3 = bVar.f1090a;
            if (i3 == 8) {
                int i4 = bVar.f1091b;
                int i5 = bVar.d;
                if (i4 >= i5) {
                    int i6 = i5;
                    i5 = i4;
                    i4 = i6;
                }
                if (i < i4 || i > i5) {
                    int i7 = bVar.f1091b;
                    if (i < i7) {
                        if (i2 == 1) {
                            bVar.f1091b = i7 + 1;
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.f1091b = i7 - 1;
                            bVar.d--;
                        }
                    }
                } else {
                    int i8 = bVar.f1091b;
                    if (i4 == i8) {
                        if (i2 == 1) {
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f1091b = i8 + 1;
                        } else if (i2 == 2) {
                            bVar.f1091b = i8 - 1;
                        }
                        i--;
                    }
                }
            } else {
                int i9 = bVar.f1091b;
                if (i9 <= i) {
                    if (i3 == 1) {
                        i -= bVar.d;
                    } else if (i3 == 2) {
                        i += bVar.d;
                    }
                } else if (i2 == 1) {
                    bVar.f1091b = i9 + 1;
                } else if (i2 == 2) {
                    bVar.f1091b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f1089c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1089c.get(size2);
            if (bVar2.f1090a == 8) {
                int i10 = bVar2.d;
                if (i10 == bVar2.f1091b || i10 < 0) {
                    this.f1089c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.f1089c.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    private void c(b bVar) {
        g(bVar);
    }

    private void d(b bVar) {
        char c2;
        boolean z;
        boolean z2;
        int i = bVar.f1091b;
        int i2 = bVar.d + i;
        int i3 = 0;
        char c3 = 65535;
        int i4 = i;
        while (i4 < i2) {
            if (this.d.a(i4) != null || d(i4)) {
                if (c3 == 0) {
                    f(a(2, i, i3, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i, i3, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
            c3 = c2;
        }
        if (i3 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i3, (Object) null);
        }
        if (c3 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private void g(b bVar) {
        this.f1089c.add(bVar);
        int i = bVar.f1090a;
        if (i == 1) {
            this.d.c(bVar.f1091b, bVar.d);
        } else if (i == 2) {
            this.d.b(bVar.f1091b, bVar.d);
        } else if (i == 4) {
            this.d.a(bVar.f1091b, bVar.d, bVar.f1092c);
        } else if (i == 8) {
            this.d.a(bVar.f1091b, bVar.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int size = this.f1089c.size();
        for (int i = 0; i < size; i++) {
            this.d.b(this.f1089c.get(i));
        }
        a((List<b>) this.f1089c);
        this.h = 0;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.g.a(this.f1088b);
        int size = this.f1088b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1088b.get(i);
            int i2 = bVar.f1090a;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar);
            } else if (i2 == 4) {
                e(bVar);
            } else if (i2 == 8) {
                c(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1088b.clear();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        a((List<b>) this.f1088b);
        a((List<b>) this.f1089c);
        this.h = 0;
    }

    C0104a(C0021a aVar, boolean z) {
        this.f1087a = new f(30);
        this.f1088b = new ArrayList<>();
        this.f1089c = new ArrayList<>();
        this.h = 0;
        this.d = aVar;
        this.f = z;
        this.g = new t(this);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f1088b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i) {
        return (i & this.h) != 0;
    }

    private void f(b bVar) {
        int i;
        int i2 = bVar.f1090a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b2 = b(bVar.f1091b, i2);
        int i3 = bVar.f1091b;
        int i4 = bVar.f1090a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = b2;
        int i6 = i3;
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.d; i8++) {
            int b3 = b(bVar.f1091b + (i * i8), bVar.f1090a);
            int i9 = bVar.f1090a;
            if (i9 == 2 ? b3 == i5 : i9 == 4 && b3 == i5 + 1) {
                i7++;
            } else {
                b a2 = a(bVar.f1090a, i5, i7, bVar.f1092c);
                a(a2, i6);
                a(a2);
                if (bVar.f1090a == 4) {
                    i6 += i7;
                }
                i5 = b3;
                i7 = 1;
            }
        }
        Object obj = bVar.f1092c;
        a(bVar);
        if (i7 > 0) {
            b a3 = a(bVar.f1090a, i5, i7, obj);
            a(a3, i6);
            a(a3);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i) {
        this.d.a(bVar);
        int i2 = bVar.f1090a;
        if (i2 == 2) {
            this.d.d(i, bVar.d);
        } else if (i2 == 4) {
            this.d.a(i, bVar.d, bVar.f1092c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        int size = this.f1089c.size();
        while (i2 < size) {
            b bVar = this.f1089c.get(i2);
            int i3 = bVar.f1090a;
            if (i3 == 8) {
                int i4 = bVar.f1091b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f1091b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    private void e(b bVar) {
        int i = bVar.f1091b;
        int i2 = bVar.d + i;
        int i3 = i;
        int i4 = 0;
        char c2 = 65535;
        while (i < i2) {
            if (this.d.a(i) != null || d(i)) {
                if (c2 == 0) {
                    f(a(4, i3, i4, bVar.f1092c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i3, i4, bVar.f1092c));
                    i3 = i;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.f1092c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i) {
        int size = this.f1089c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1089c.get(i2);
            int i3 = bVar.f1090a;
            if (i3 == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f1091b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public int a(int i) {
        int size = this.f1088b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1088b.get(i2);
            int i3 = bVar.f1090a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f1091b;
                    if (i4 <= i) {
                        int i5 = bVar.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f1091b;
                    if (i6 == i) {
                        i = bVar.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f1091b <= i) {
                i += bVar.d;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return !this.f1089c.isEmpty() && !this.f1088b.isEmpty();
    }

    private void b(b bVar) {
        g(bVar);
    }

    public b a(int i, int i2, int i3, Object obj) {
        b acquire = this.f1087a.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.f1090a = i;
        acquire.f1091b = i2;
        acquire.d = i3;
        acquire.f1092c = obj;
        return acquire;
    }

    /* access modifiers changed from: package-private */
    public int b(int i) {
        return a(i, 0);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a();
        int size = this.f1088b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1088b.get(i);
            int i2 = bVar.f1090a;
            if (i2 == 1) {
                this.d.b(bVar);
                this.d.c(bVar.f1091b, bVar.d);
            } else if (i2 == 2) {
                this.d.b(bVar);
                this.d.d(bVar.f1091b, bVar.d);
            } else if (i2 == 4) {
                this.d.b(bVar);
                this.d.a(bVar.f1091b, bVar.d, bVar.f1092c);
            } else if (i2 == 8) {
                this.d.b(bVar);
                this.d.a(bVar.f1091b, bVar.d);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a((List<b>) this.f1088b);
        this.h = 0;
    }

    public void a(b bVar) {
        if (!this.f) {
            bVar.f1092c = null;
            this.f1087a.release(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }
}
