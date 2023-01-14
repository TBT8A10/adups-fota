package b.a.a.a.d;

import java.util.concurrent.Executor;

final class r<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1442a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1443b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0150c<TResult> f1444c;

    public r(Executor executor, C0150c<TResult> cVar) {
        this.f1442a = executor;
        this.f1444c = cVar;
    }

    public final void a(h<TResult> hVar) {
        synchronized (this.f1443b) {
            if (this.f1444c != null) {
                this.f1442a.execute(new s(this, hVar));
            }
        }
    }
}
