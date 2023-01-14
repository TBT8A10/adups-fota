package a.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f8a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f9b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f10c = new WeakHashMap<>();
    private int d = 0;

    /* compiled from: SafeIterableMap */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f13c;
        }
    }

    /* renamed from: a.a.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: SafeIterableMap */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f13c;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* compiled from: SafeIterableMap */
    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f11a;

        /* renamed from: b  reason: collision with root package name */
        final V f12b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f13c;
        c<K, V> d;

        c(K k, V v) {
            this.f11a = k;
            this.f12b = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f11a.equals(cVar.f11a) || !this.f12b.equals(cVar.f12b)) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f11a;
        }

        public V getValue() {
            return this.f12b;
        }

        public int hashCode() {
            return this.f11a.hashCode() ^ this.f12b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f11a + "=" + this.f12b;
        }
    }

    /* compiled from: SafeIterableMap */
    private class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f14a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f15b = true;

        d() {
        }

        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f14a;
            if (cVar == cVar2) {
                this.f14a = cVar2.d;
                this.f15b = this.f14a == null;
            }
        }

        public boolean hasNext() {
            if (!this.f15b) {
                c<K, V> cVar = this.f14a;
                if (cVar == null || cVar.f13c == null) {
                    return false;
                }
                return true;
            } else if (b.this.f8a != null) {
                return true;
            } else {
                return false;
            }
        }

        public Map.Entry<K, V> next() {
            if (this.f15b) {
                this.f15b = false;
                this.f14a = b.this.f8a;
            } else {
                c<K, V> cVar = this.f14a;
                this.f14a = cVar != null ? cVar.f13c : null;
            }
            return this.f14a;
        }
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f17a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f18b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f17a = cVar2;
            this.f18b = cVar;
        }

        public void a(c<K, V> cVar) {
            if (this.f17a == cVar && cVar == this.f18b) {
                this.f18b = null;
                this.f17a = null;
            }
            c<K, V> cVar2 = this.f17a;
            if (cVar2 == cVar) {
                this.f17a = b(cVar2);
            }
            if (this.f18b == cVar) {
                this.f18b = a();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> c(c<K, V> cVar);

        public boolean hasNext() {
            return this.f18b != null;
        }

        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f18b;
            this.f18b = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f18b;
            c<K, V> cVar2 = this.f17a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* compiled from: SafeIterableMap */
    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k) {
        c<K, V> cVar = this.f8a;
        while (cVar != null && !cVar.f11a.equals(k)) {
            cVar = cVar.f13c;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c a2 = a(k);
        if (a2 != null) {
            return a2.f12b;
        }
        a(k, v);
        return null;
    }

    public Map.Entry<K, V> c() {
        return this.f9b;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b bVar = new C0000b(this.f9b, this.f8a);
        this.f10c.put(bVar, false);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f8a, this.f9b);
        this.f10c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.d--;
        if (!this.f10c.isEmpty()) {
            for (f<K, V> a3 : this.f10c.keySet()) {
                a3.a(a2);
            }
        }
        c<K, V> cVar = a2.d;
        if (cVar != null) {
            cVar.f13c = a2.f13c;
        } else {
            this.f8a = a2.f13c;
        }
        c<K, V> cVar2 = a2.f13c;
        if (cVar2 != null) {
            cVar2.d = a2.d;
        } else {
            this.f9b = a2.d;
        }
        a2.f13c = null;
        a2.d = null;
        return a2.f12b;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        c<K, V> cVar2 = this.f9b;
        if (cVar2 == null) {
            this.f8a = cVar;
            this.f9b = this.f8a;
            return cVar;
        }
        cVar2.f13c = cVar;
        cVar.d = cVar2;
        this.f9b = cVar;
        return cVar;
    }

    public b<K, V>.d b() {
        b<K, V>.d dVar = new d();
        this.f10c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> a() {
        return this.f8a;
    }
}
