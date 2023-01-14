package a.b;

/* compiled from: SparseArrayCompat */
public class j<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f46a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f47b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f48c;
    private Object[] d;
    private int e;

    public j() {
        this(10);
    }

    private void c() {
        int i = this.e;
        int[] iArr = this.f48c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f46a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f47b = false;
        this.e = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f48c
            int r1 = r3.e
            int r4 = a.b.e.a((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.d
            r1 = r0[r4]
            java.lang.Object r2 = f46a
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f47b = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.j.a(int):void");
    }

    public E b(int i) {
        return b(i, (Object) null);
    }

    public int d(int i) {
        if (this.f47b) {
            c();
        }
        return this.f48c[i];
    }

    public void e(int i) {
        a(i);
    }

    public E f(int i) {
        if (this.f47b) {
            c();
        }
        return this.d[i];
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
            sb.append(d(i));
            sb.append('=');
            Object f = f(i);
            if (f != this) {
                sb.append(f);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i) {
        this.f47b = false;
        if (i == 0) {
            this.f48c = e.f22a;
            this.d = e.f24c;
        } else {
            int b2 = e.b(i);
            this.f48c = new int[b2];
            this.d = new Object[b2];
        }
        this.e = 0;
    }

    public E b(int i, E e2) {
        int a2 = e.a(this.f48c, this.e, i);
        if (a2 >= 0) {
            E[] eArr = this.d;
            if (eArr[a2] != f46a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.f48c = (int[]) this.f48c.clone();
            jVar.d = (Object[]) this.d.clone();
            return jVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int a(E e2) {
        if (this.f47b) {
            c();
        }
        for (int i = 0; i < this.e; i++) {
            if (this.d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public int b() {
        if (this.f47b) {
            c();
        }
        return this.e;
    }

    public void a() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f47b = false;
    }

    public void c(int i, E e2) {
        int a2 = e.a(this.f48c, this.e, i);
        if (a2 >= 0) {
            this.d[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        if (i2 < this.e) {
            Object[] objArr = this.d;
            if (objArr[i2] == f46a) {
                this.f48c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f47b && this.e >= this.f48c.length) {
            c();
            i2 = e.a(this.f48c, this.e, i) ^ -1;
        }
        int i3 = this.e;
        if (i3 >= this.f48c.length) {
            int b2 = e.b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.f48c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f48c = iArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f48c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.e - i2);
        }
        this.f48c[i2] = i;
        this.d[i2] = e2;
        this.e++;
    }

    public void a(int i, E e2) {
        int i2 = this.e;
        if (i2 == 0 || i > this.f48c[i2 - 1]) {
            if (this.f47b && this.e >= this.f48c.length) {
                c();
            }
            int i3 = this.e;
            if (i3 >= this.f48c.length) {
                int b2 = e.b(i3 + 1);
                int[] iArr = new int[b2];
                Object[] objArr = new Object[b2];
                int[] iArr2 = this.f48c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f48c = iArr;
                this.d = objArr;
            }
            this.f48c[i3] = i;
            this.d[i3] = e2;
            this.e = i3 + 1;
            return;
        }
        c(i, e2);
    }

    public int c(int i) {
        if (this.f47b) {
            c();
        }
        return e.a(this.f48c, this.e, i);
    }
}
