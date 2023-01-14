package androidx.coordinatorlayout.widget;

import a.b.i;
import androidx.core.g.e;
import androidx.core.g.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph */
public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e<ArrayList<T>> f511a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    private final i<T, ArrayList<T>> f512b = new i<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f513c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (!this.f512b.containsKey(t)) {
            this.f512b.put(t, null);
        }
    }

    public boolean b(T t) {
        return this.f512b.containsKey(t);
    }

    public List c(T t) {
        return this.f512b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f512b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList d2 = this.f512b.d(i);
            if (d2 != null && d2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f512b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f512b.size();
        for (int i = 0; i < size; i++) {
            ArrayList d2 = this.f512b.d(i);
            if (d2 != null && d2.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<T> c() {
        ArrayList<T> acquire = this.f511a.acquire();
        return acquire == null ? new ArrayList<>() : acquire;
    }

    public ArrayList<T> b() {
        this.f513c.clear();
        this.d.clear();
        int size = this.f512b.size();
        for (int i = 0; i < size; i++) {
            a(this.f512b.b(i), this.f513c, this.d);
        }
        return this.f513c;
    }

    public void a(T t, T t2) {
        if (!this.f512b.containsKey(t) || !this.f512b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f512b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f512b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void a() {
        int size = this.f512b.size();
        for (int i = 0; i < size; i++) {
            ArrayList d2 = this.f512b.d(i);
            if (d2 != null) {
                a(d2);
            }
        }
        this.f512b.clear();
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f512b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f511a.release(arrayList);
    }
}
