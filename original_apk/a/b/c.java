package a.b;

import java.util.Map;

/* compiled from: ArraySet */
class c extends h<E, E> {
    final /* synthetic */ d d;

    c(d dVar) {
        this.d = dVar;
    }

    /* access modifiers changed from: protected */
    public Object a(int i, int i2) {
        return this.d.h[i];
    }

    /* access modifiers changed from: protected */
    public int b(Object obj) {
        return this.d.indexOf(obj);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.d.i;
    }

    /* access modifiers changed from: protected */
    public int a(Object obj) {
        return this.d.indexOf(obj);
    }

    /* access modifiers changed from: protected */
    public Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    /* access modifiers changed from: protected */
    public void a(E e, E e2) {
        this.d.add(e);
    }

    /* access modifiers changed from: protected */
    public E a(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        this.d.b(i);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.d.clear();
    }
}
