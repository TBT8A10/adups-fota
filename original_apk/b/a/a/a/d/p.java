package b.a.a.a.d;

import java.util.concurrent.Executor;

final class p<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1438a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1439b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0149b f1440c;

    public p(Executor executor, C0149b bVar) {
        this.f1438a = executor;
        this.f1440c = bVar;
    }

    public final void a(h hVar) {
        if (hVar.c()) {
            synchronized (this.f1439b) {
                if (this.f1440c != null) {
                    this.f1438a.execute(new q(this));
                }
            }
        }
    }
}
