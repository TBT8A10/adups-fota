package b.a.a.a.d;

import java.util.concurrent.Executor;

final class t<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1447a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1448b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0151d f1449c;

    public t(Executor executor, C0151d dVar) {
        this.f1447a = executor;
        this.f1449c = dVar;
    }

    public final void a(h<TResult> hVar) {
        if (!hVar.e() && !hVar.c()) {
            synchronized (this.f1448b) {
                if (this.f1449c != null) {
                    this.f1447a.execute(new u(this, hVar));
                }
            }
        }
    }
}
