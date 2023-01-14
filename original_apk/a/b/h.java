package a.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: MapCollections */
abstract class h<K, V> {

    /* renamed from: a  reason: collision with root package name */
    h<K, V>.b f31a;

    /* renamed from: b  reason: collision with root package name */
    h<K, V>.c f32b;

    /* renamed from: c  reason: collision with root package name */
    h<K, V>.e f33c;

    /* compiled from: MapCollections */
    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f34a;

        /* renamed from: b  reason: collision with root package name */
        int f35b;

        /* renamed from: c  reason: collision with root package name */
        int f36c;
        boolean d = false;

        a(int i) {
            this.f34a = i;
            this.f35b = h.this.c();
        }

        public boolean hasNext() {
            return this.f36c < this.f35b;
        }

        public T next() {
            if (hasNext()) {
                T a2 = h.this.a(this.f36c, this.f34a);
                this.f36c++;
                this.d = true;
                return a2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.d) {
                this.f36c--;
                this.f35b--;
                this.d = false;
                h.this.a(this.f36c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int c2 = h.this.c();
            for (Map.Entry entry : collection) {
                h.this.a_shaKey_method2(entry.getKey(), entry.getValue());
            }
            return c2 != h.this.c();
        }

        public void clear() {
            h.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = h.this.a(entry.getKey());
            if (a2 < 0) {
                return false;
            }
            return e.a_shaKey_method2(h.this.a(a2, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return h.a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2;
            int i3 = 0;
            for (int c2 = h.this.c() - 1; c2 >= 0; c2--) {
                Object a2 = h.this.a(c2, 0);
                Object a3 = h.this.a(c2, 1);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                i3 += i ^ i2;
            }
            return i3;
        }

        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return h.this.c();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections */
    final class c implements Set<K> {
        c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            h.this.a();
        }

        public boolean contains(Object obj) {
            return h.this.a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return h.a(h.this.b(), collection);
        }

        public boolean equals(Object obj) {
            return h.a(this, obj);
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            for (int c2 = h.this.c() - 1; c2 >= 0; c2--) {
                Object a2 = h.this.a(c2, 0);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                i2 += i;
            }
            return i2;
        }

        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int a2 = h.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            h.this.a(a2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return h.b(h.this.b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return h.c(h.this.b(), collection);
        }

        public int size() {
            return h.this.c();
        }

        public Object[] toArray() {
            return h.this.b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return h.this.a(tArr, 0);
        }
    }

    /* compiled from: MapCollections */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        int f39a;

        /* renamed from: b  reason: collision with root package name */
        int f40b;

        /* renamed from: c  reason: collision with root package name */
        boolean f41c = false;

        d() {
            this.f39a = h.this.c() - 1;
            this.f40b = -1;
        }

        public boolean equals(Object obj) {
            if (!this.f41c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!e.a_shaKey_method2(entry.getKey(), h.this.a(this.f40b, 0)) || !e.a_shaKey_method2(entry.getValue(), h.this.a(this.f40b, 1))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.f41c) {
                return h.this.a(this.f40b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f41c) {
                return h.this.a(this.f40b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f40b < this.f39a;
        }

        public int hashCode() {
            int i;
            if (this.f41c) {
                int i2 = 0;
                Object a2 = h.this.a(this.f40b, 0);
                Object a3 = h.this.a(this.f40b, 1);
                if (a2 == null) {
                    i = 0;
                } else {
                    i = a2.hashCode();
                }
                if (a3 != null) {
                    i2 = a3.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f41c) {
                h.this.a(this.f40b);
                this.f40b--;
                this.f39a--;
                this.f41c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f41c) {
                return h.this.a(this.f40b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f40b++;
                this.f41c = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapCollections */
    final class e implements Collection<V> {
        e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            h.this.a();
        }

        public boolean contains(Object obj) {
            return h.this.b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int b2 = h.this.b(obj);
            if (b2 < 0) {
                return false;
            }
            h.this.a(b2);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int c2 = h.this.c();
            int i = 0;
            boolean z = false;
            while (i < c2) {
                if (collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    c2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int c2 = h.this.c();
            int i = 0;
            boolean z = false;
            while (i < c2) {
                if (!collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    c2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return h.this.c();
        }

        public Object[] toArray() {
            return h.this.b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return h.this.a(tArr, 1);
        }
    }

    h() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    public abstract int a(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object a(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract V a(int i, V v);

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract void a(int i);

    /* access modifiers changed from: protected */
    public abstract void a(K k, V v);

    /* access modifiers changed from: protected */
    public abstract int b(Object obj);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> b();

    /* access modifiers changed from: protected */
    public abstract int c();

    public Set<Map.Entry<K, V>> d() {
        if (this.f31a == null) {
            this.f31a = new b();
        }
        return this.f31a;
    }

    public Set<K> e() {
        if (this.f32b == null) {
            this.f32b = new c();
        }
        return this.f32b;
    }

    public Collection<V> f() {
        if (this.f33c == null) {
            this.f33c = new e();
        }
        return this.f33c;
    }

    public <T> T[] a(T[] tArr, int i) {
        int c2 = c();
        if (tArr.length < c2) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), c2);
        }
        for (int i2 = 0; i2 < c2; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > c2) {
            tArr[c2] = null;
        }
        return tArr;
    }

    public Object[] b(int i) {
        int c2 = c();
        Object[] objArr = new Object[c2];
        for (int i2 = 0; i2 < c2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
