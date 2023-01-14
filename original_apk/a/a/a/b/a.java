package a.a.a.b;

import a.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> e = new HashMap<>();

    /* access modifiers changed from: protected */
    public b.c<K, V> a(K k) {
        return this.e.get(k);
    }

    public V b(K k, V v) {
        b.c a2 = a(k);
        if (a2 != null) {
            return a2.f12b;
        }
        this.e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.e.containsKey(k);
    }

    public V remove(K k) {
        V remove = super.remove(k);
        this.e.remove(k);
        return remove;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.e.get(k).d;
        }
        return null;
    }
}
