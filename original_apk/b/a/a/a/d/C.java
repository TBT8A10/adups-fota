package b.a.a.a.d;

import com.google.android.gms.common.internal.C0178t;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class C<TResult> extends h<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1418a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final A<TResult> f1419b = new A<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f1420c;
    private volatile boolean d;
    private TResult e;
    private Exception f;

    C() {
    }

    private final void g() {
        C0178t.b(this.f1420c, "Task is not yet complete");
    }

    private final void h() {
        C0178t.b(!this.f1420c, "Task is already complete");
    }

    private final void i() {
        if (this.d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void j() {
        synchronized (this.f1418a) {
            if (this.f1420c) {
                this.f1419b.a(this);
            }
        }
    }

    public final <X extends Throwable> TResult a(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f1418a) {
            g();
            i();
            if (cls.isInstance(this.f)) {
                throw ((Throwable) cls.cast(this.f));
            } else if (this.f == null) {
                tresult = this.e;
            } else {
                throw new f(this.f);
            }
        }
        return tresult;
    }

    public final TResult b() {
        TResult tresult;
        synchronized (this.f1418a) {
            g();
            i();
            if (this.f == null) {
                tresult = this.e;
            } else {
                throw new f(this.f);
            }
        }
        return tresult;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        boolean z;
        synchronized (this.f1418a) {
            z = this.f1420c;
        }
        return z;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f1418a) {
            z = this.f1420c && !this.d && this.f == null;
        }
        return z;
    }

    public final boolean f() {
        synchronized (this.f1418a) {
            if (this.f1420c) {
                return false;
            }
            this.f1420c = true;
            this.d = true;
            this.f1419b.a(this);
            return true;
        }
    }

    public final <TContinuationResult> h<TContinuationResult> b(Executor executor, C0148a<TResult, h<TContinuationResult>> aVar) {
        C c2 = new C();
        this.f1419b.a(new n(executor, aVar, c2));
        j();
        return c2;
    }

    public final Exception a() {
        Exception exc;
        synchronized (this.f1418a) {
            exc = this.f;
        }
        return exc;
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f1418a) {
            if (this.f1420c) {
                return false;
            }
            this.f1420c = true;
            this.e = tresult;
            this.f1419b.a(this);
            return true;
        }
    }

    public final h<TResult> a(Executor executor, e<? super TResult> eVar) {
        this.f1419b.a(new v(executor, eVar));
        j();
        return this;
    }

    public final h<TResult> a(Executor executor, C0151d dVar) {
        this.f1419b.a(new t(executor, dVar));
        j();
        return this;
    }

    public final h<TResult> a(C0150c<TResult> cVar) {
        a(j.f1424a, cVar);
        return this;
    }

    public final h<TResult> a(Executor executor, C0150c<TResult> cVar) {
        this.f1419b.a(new r(executor, cVar));
        j();
        return this;
    }

    public final boolean b(Exception exc) {
        C0178t.a(exc, (Object) "Exception must not be null");
        synchronized (this.f1418a) {
            if (this.f1420c) {
                return false;
            }
            this.f1420c = true;
            this.f = exc;
            this.f1419b.a(this);
            return true;
        }
    }

    public final <TContinuationResult> h<TContinuationResult> a(Executor executor, C0148a<TResult, TContinuationResult> aVar) {
        C c2 = new C();
        this.f1419b.a(new l(executor, aVar, c2));
        j();
        return c2;
    }

    public final h<TResult> a(Executor executor, C0149b bVar) {
        this.f1419b.a(new p(executor, bVar));
        j();
        return this;
    }

    public final <TContinuationResult> h<TContinuationResult> a(Executor executor, g<TResult, TContinuationResult> gVar) {
        C c2 = new C();
        this.f1419b.a(new x(executor, gVar, c2));
        j();
        return c2;
    }

    public final void a(TResult tresult) {
        synchronized (this.f1418a) {
            h();
            this.f1420c = true;
            this.e = tresult;
        }
        this.f1419b.a(this);
    }

    public final void a(Exception exc) {
        C0178t.a(exc, (Object) "Exception must not be null");
        synchronized (this.f1418a) {
            h();
            this.f1420c = true;
            this.f = exc;
        }
        this.f1419b.a(this);
    }
}
