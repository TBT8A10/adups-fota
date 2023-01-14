package androidx.lifecycle;

import a.a.a.a.c;
import a.a.a.b.b;
import androidx.lifecycle.f;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    static final Object f893a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Object f894b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private b<p<? super T>, LiveData<T>.a> f895c = new b<>();
    int d = 0;
    private volatile Object e;
    volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    private abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final p<? super T> f896a;

        /* renamed from: b  reason: collision with root package name */
        boolean f897b;

        /* renamed from: c  reason: collision with root package name */
        int f898c = -1;

        a(p<? super T> pVar) {
            this.f896a = pVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.f897b) {
                this.f897b = z;
                int i = 1;
                boolean z2 = LiveData.this.d == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.d;
                if (!this.f897b) {
                    i = -1;
                }
                liveData.d = i2 + i;
                if (z2 && this.f897b) {
                    LiveData.this.c();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.d == 0 && !this.f897b) {
                    liveData2.d();
                }
                if (this.f897b) {
                    LiveData.this.a((LiveData<T>.a) this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean b();
    }

    public LiveData() {
        Object obj = f893a;
        this.e = obj;
        this.f = obj;
        this.g = -1;
        this.j = new m(this);
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f897b) {
            if (!aVar.b()) {
                aVar.a(false);
                return;
            }
            int i2 = aVar.f898c;
            int i3 = this.g;
            if (i2 < i3) {
                aVar.f898c = i3;
                aVar.f896a.a(this.e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar == null) {
                b<K, V>.d b2 = this.f895c.b();
                while (b2.hasNext()) {
                    b((a) ((Map.Entry) b2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements e {
        final h e;

        LifecycleBoundObserver(h hVar, p<? super T> pVar) {
            super(pVar);
            this.e = hVar;
        }

        public void a(h hVar, f.a aVar) {
            if (this.e.getLifecycle().a() == f.b.DESTROYED) {
                LiveData.this.a(this.f896a);
            } else {
                a(b());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.e.getLifecycle().a().isAtLeast(f.b.STARTED);
        }

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return this.e == hVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.e.getLifecycle().b(this);
        }
    }

    public boolean b() {
        return this.d > 0;
    }

    public void a(h hVar, p<? super T> pVar) {
        a("observe");
        if (hVar.getLifecycle().a() != f.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hVar, pVar);
            a b2 = this.f895c.b(pVar, lifecycleBoundObserver);
            if (b2 != null && !b2.a(hVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (b2 == null) {
                hVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(p<? super T> pVar) {
        a("removeObserver");
        a remove = this.f895c.remove(pVar);
        if (remove != null) {
            remove.a();
            remove.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        a((LiveData<T>.a) null);
    }

    public T a() {
        T t = this.e;
        if (t != f893a) {
            return t;
        }
        return null;
    }

    private static void a(String str) {
        if (!c.b().a()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }
}
