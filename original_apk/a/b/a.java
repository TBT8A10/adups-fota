package a.b;

import java.util.Map;

/* compiled from: ArrayMap */
class a extends h<K, V> {
    final /* synthetic */ b d;

    a(b bVar) {
        this.d = bVar;
    }

    /* access modifiers changed from: protected */
    public Object a(int i, int i2) {
        return this.d.f[(i << 1) + i2];
    }

    /* access modifiers changed from: protected */
    public int b(Object obj) {
        return this.d.b(obj);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.d.g;
    }

    /* access modifiers changed from: protected */
    public int a(Object obj) {
        return this.d.a(obj);
    }

    /* access modifiers changed from: protected */
    public Map<K, V> b() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public void a(K k, V v) {
        this.d.put(k, v);
    }

    /* access modifiers changed from: protected */
    public V a(int i, V v) {
        return this.d.a_shaKey_method2(i, v);
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        this.d.c(i);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.d.clear();
    }
}
