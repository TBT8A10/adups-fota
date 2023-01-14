package androidx.lifecycle;

import a.a.a.b.b;
import android.util.Log;
import androidx.lifecycle.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry */
public class j extends f {

    /* renamed from: a  reason: collision with root package name */
    private a.a.a.b.a<g, a> f914a = new a.a.a.b.a<>();

    /* renamed from: b  reason: collision with root package name */
    private f.b f915b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<h> f916c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<f.b> g = new ArrayList<>();

    /* compiled from: LifecycleRegistry */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        f.b f917a;

        /* renamed from: b  reason: collision with root package name */
        e f918b;

        a(g gVar, f.b bVar) {
            this.f918b = l.a((Object) gVar);
            this.f917a = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, f.a aVar) {
            f.b a2 = j.a(aVar);
            this.f917a = j.a(this.f917a, a2);
            this.f918b.a(hVar, aVar);
            this.f917a = a2;
        }
    }

    public j(h hVar) {
        this.f916c = new WeakReference<>(hVar);
        this.f915b = f.b.INITIALIZED;
    }

    private void c(f.b bVar) {
        if (this.f915b != bVar) {
            this.f915b = bVar;
            if (this.e || this.d != 0) {
                this.f = true;
                return;
            }
            this.e = true;
            d();
            this.e = false;
        }
    }

    private void d(f.b bVar) {
        this.g.add(bVar);
    }

    private static f.a e(f.b bVar) {
        int i = i.f913b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return f.a.ON_START;
            }
            if (i == 3) {
                return f.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return f.a.ON_CREATE;
    }

    public void a(f.b bVar) {
        c(bVar);
    }

    public void b(f.a aVar) {
        c(a(aVar));
    }

    private void d() {
        h hVar = (h) this.f916c.get();
        if (hVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.f915b.compareTo(this.f914a.a().getValue().f917a) < 0) {
                a(hVar);
            }
            Map.Entry<g, a> c2 = this.f914a.c();
            if (!this.f && c2 != null && this.f915b.compareTo(c2.getValue().f917a) > 0) {
                b(hVar);
            }
        }
        this.f = false;
    }

    public void a(g gVar) {
        h hVar;
        f.b bVar = this.f915b;
        f.b bVar2 = f.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = f.b.INITIALIZED;
        }
        a aVar = new a(gVar, bVar2);
        if (this.f914a.b(gVar, aVar) == null && (hVar = (h) this.f916c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            f.b c2 = c(gVar);
            this.d++;
            while (aVar.f917a.compareTo(c2) < 0 && this.f914a.contains(gVar)) {
                d(aVar.f917a);
                aVar.a(hVar, e(aVar.f917a));
                c();
                c2 = c(gVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    private boolean b() {
        if (this.f914a.size() == 0) {
            return true;
        }
        f.b bVar = this.f914a.a().getValue().f917a;
        f.b bVar2 = this.f914a.c().getValue().f917a;
        if (bVar == bVar2 && this.f915b == bVar2) {
            return true;
        }
        return false;
    }

    public void b(g gVar) {
        this.f914a.remove(gVar);
    }

    private static f.a b(f.b bVar) {
        int i = i.f913b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return f.a.ON_DESTROY;
        } else {
            if (i == 3) {
                return f.a.ON_STOP;
            }
            if (i == 4) {
                return f.a.ON_PAUSE;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
            throw new IllegalArgumentException();
        }
    }

    private f.b c(g gVar) {
        Map.Entry<g, a> b2 = this.f914a.b(gVar);
        f.b bVar = null;
        f.b bVar2 = b2 != null ? b2.getValue().f917a : null;
        if (!this.g.isEmpty()) {
            ArrayList<f.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f915b, bVar2), bVar);
    }

    private void c() {
        ArrayList<f.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void b(h hVar) {
        b<K, V>.d b2 = this.f914a.b();
        while (b2.hasNext() && !this.f) {
            Map.Entry entry = (Map.Entry) b2.next();
            a aVar = (a) entry.getValue();
            while (aVar.f917a.compareTo(this.f915b) < 0 && !this.f && this.f914a.contains(entry.getKey())) {
                d(aVar.f917a);
                aVar.a(hVar, e(aVar.f917a));
                c();
            }
        }
    }

    public f.b a() {
        return this.f915b;
    }

    static f.b a(f.a aVar) {
        switch (i.f912a[aVar.ordinal()]) {
            case 1:
            case 2:
                return f.b.CREATED;
            case 3:
            case 4:
                return f.b.STARTED;
            case 5:
                return f.b.RESUMED;
            case 6:
                return f.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void a(h hVar) {
        Iterator<Map.Entry<g, a>> descendingIterator = this.f914a.descendingIterator();
        while (descendingIterator.hasNext() && !this.f) {
            Map.Entry next = descendingIterator.next();
            a aVar = (a) next.getValue();
            while (aVar.f917a.compareTo(this.f915b) > 0 && !this.f && this.f914a.contains(next.getKey())) {
                f.a b2 = b(aVar.f917a);
                d(a(b2));
                aVar.a(hVar, b2);
                c();
            }
        }
    }

    static f.b a(f.b bVar, f.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
