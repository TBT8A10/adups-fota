package b.a.a.a.d;

final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f1450a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ t f1451b;

    u(t tVar, h hVar) {
        this.f1451b = tVar;
        this.f1450a = hVar;
    }

    public final void run() {
        synchronized (this.f1451b.f1448b) {
            if (this.f1451b.f1449c != null) {
                this.f1451b.f1449c.a(this.f1450a.a());
            }
        }
    }
}
