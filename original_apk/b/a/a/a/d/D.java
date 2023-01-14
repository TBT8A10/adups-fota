package b.a.a.a.d;

import java.util.concurrent.Callable;

final class D implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C f1421a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Callable f1422b;

    D(C c2, Callable callable) {
        this.f1421a = c2;
        this.f1422b = callable;
    }

    public final void run() {
        try {
            this.f1421a.a(this.f1422b.call());
        } catch (Exception e) {
            this.f1421a.a(e);
        }
    }
}
