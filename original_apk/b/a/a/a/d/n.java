package b.a.a.a.d;

import java.util.concurrent.Executor;

final class n<TResult, TContinuationResult> implements C0149b, C0151d, e<TContinuationResult>, z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1433a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0148a<TResult, h<TContinuationResult>> f1434b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C<TContinuationResult> f1435c;

    public n(Executor executor, C0148a<TResult, h<TContinuationResult>> aVar, C<TContinuationResult> c2) {
        this.f1433a = executor;
        this.f1434b = aVar;
        this.f1435c = c2;
    }

    public final void a(h<TResult> hVar) {
        this.f1433a.execute(new o(this, hVar));
    }

    public final void a(TContinuationResult tcontinuationresult) {
        this.f1435c.a(tcontinuationresult);
    }

    public final void a(Exception exc) {
        this.f1435c.a(exc);
    }

    public final void a() {
        this.f1435c.f();
    }
}
