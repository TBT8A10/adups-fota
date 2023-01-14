package b.a.a.a.d;

import java.util.concurrent.Executor;

final class x<TResult, TContinuationResult> implements C0149b, C0151d, e<TContinuationResult>, z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1457a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final g<TResult, TContinuationResult> f1458b;

    /* renamed from: c  reason: collision with root package name */
    private final C<TContinuationResult> f1459c;

    public x(Executor executor, g<TResult, TContinuationResult> gVar, C<TContinuationResult> c2) {
        this.f1457a = executor;
        this.f1458b = gVar;
        this.f1459c = c2;
    }

    public final void a(h<TResult> hVar) {
        this.f1457a.execute(new y(this, hVar));
    }

    public final void a(TContinuationResult tcontinuationresult) {
        this.f1459c.a(tcontinuationresult);
    }

    public final void a(Exception exc) {
        this.f1459c.a(exc);
    }

    public final void a() {
        this.f1459c.f();
    }
}
