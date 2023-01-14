package b.a.a.a.d;

final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f1445a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ r f1446b;

    s(r rVar, h hVar) {
        this.f1446b = rVar;
        this.f1445a = hVar;
    }

    public final void run() {
        synchronized (this.f1446b.f1443b) {
            if (this.f1446b.f1444c != null) {
                this.f1446b.f1444c.a(this.f1445a);
            }
        }
    }
}
