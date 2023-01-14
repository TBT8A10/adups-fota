package b.a.a.a.d;

import java.util.concurrent.Executor;

final class l<TResult, TContinuationResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1428a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0148a<TResult, TContinuationResult> f1429b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C<TContinuationResult> f1430c;

    public l(Executor executor, C0148a<TResult, TContinuationResult> aVar, C<TContinuationResult> c2) {
        this.f1428a = executor;
        this.f1429b = aVar;
        this.f1430c = c2;
    }

    public final void a(h<TResult> hVar) {
        this.f1428a.execute(new m(this, hVar));
    }
}
