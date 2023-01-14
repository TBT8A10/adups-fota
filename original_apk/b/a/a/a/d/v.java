package b.a.a.a.d;

import java.util.concurrent.Executor;

final class v<TResult> implements z<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f1452a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f1453b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public e<? super TResult> f1454c;

    public v(Executor executor, e<? super TResult> eVar) {
        this.f1452a = executor;
        this.f1454c = eVar;
    }

    public final void a(h<TResult> hVar) {
        if (hVar.e()) {
            synchronized (this.f1453b) {
                if (this.f1454c != null) {
                    this.f1452a.execute(new w(this, hVar));
                }
            }
        }
    }
}
