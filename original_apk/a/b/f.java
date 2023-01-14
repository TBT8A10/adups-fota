package a.b;

/* compiled from: LongSparseArray */
public class f<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f25a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f26b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f27c;
    private Object[] d;
    private int e;

    public f() {
        this(10);
    }

    private void c() {
        int i = this.e;
        long[] jArr = this.f27c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f25a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f26b = false;
        this.e = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f27c
            int r1 = r2.e
            int r3 = a.b.e.a((long[]) r0, (int) r1, (long) r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.d
            r0 = r4[r3]
            java.lang.Object r1 = f25a
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f26b = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.f.a(long):void");
    }

    public E b(long j) {
        return b(j, (Object) null);
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            Object c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i) {
        this.f26b = false;
        if (i == 0) {
            this.f27c = e.f23b;
            this.d = e.f24c;
        } else {
            int c2 = e.c(i);
            this.f27c = new long[c2];
            this.d = new Object[c2];
        }
        this.e = 0;
    }

    public E b(long j, E e2) {
        int a2 = e.a(this.f27c, this.e, j);
        if (a2 >= 0) {
            E[] eArr = this.d;
            if (eArr[a2] != f25a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public f<E> clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.f27c = (long[]) this.f27c.clone();
            fVar.d = (Object[]) this.d.clone();
            return fVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public long a(int i) {
        if (this.f26b) {
            c();
        }
        return this.f27c[i];
    }

    public void b(int i) {
        Object[] objArr = this.d;
        Object obj = objArr[i];
        Object obj2 = f25a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f26b = true;
        }
    }

    public void a() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f26b = false;
    }

    public int b() {
        if (this.f26b) {
            c();
        }
        return this.e;
    }

    public void c(long j, E e2) {
        int a2 = e.a(this.f27c, this.e, j);
        if (a2 >= 0) {
            this.d[a2] = e2;
            return;
        }
        int i = a2 ^ -1;
        if (i < this.e) {
            Object[] objArr = this.d;
            if (objArr[i] == f25a) {
                this.f27c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f26b && this.e >= this.f27c.length) {
            c();
            i = e.a(this.f27c, this.e, j) ^ -1;
        }
        int i2 = this.e;
        if (i2 >= this.f27c.length) {
            int c2 = e.c(i2 + 1);
            long[] jArr = new long[c2];
            Object[] objArr2 = new Object[c2];
            long[] jArr2 = this.f27c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f27c = jArr;
            this.d = objArr2;
        }
        int i3 = this.e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f27c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i4, this.e - i);
        }
        this.f27c[i] = j;
        this.d[i] = e2;
        this.e++;
    }

    public void a(long j, E e2) {
        int i = this.e;
        if (i == 0 || j > this.f27c[i - 1]) {
            if (this.f26b && this.e >= this.f27c.length) {
                c();
            }
            int i2 = this.e;
            if (i2 >= this.f27c.length) {
                int c2 = e.c(i2 + 1);
                long[] jArr = new long[c2];
                Object[] objArr = new Object[c2];
                long[] jArr2 = this.f27c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f27c = jArr;
                this.d = objArr;
            }
            this.f27c[i2] = j;
            this.d[i2] = e2;
            this.e = i2 + 1;
            return;
        }
        c(j, e2);
    }

    public E c(int i) {
        if (this.f26b) {
            c();
        }
        return this.d[i];
    }

    public int c(long j) {
        if (this.f26b) {
            c();
        }
        return e.a(this.f27c, this.e, j);
    }
}
