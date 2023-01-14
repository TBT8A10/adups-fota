package b.a.a.a.d;

final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p f1441a;

    q(p pVar) {
        this.f1441a = pVar;
    }

    public final void run() {
        synchronized (this.f1441a.f1439b) {
            if (this.f1441a.f1440c != null) {
                this.f1441a.f1440c.a();
            }
        }
    }
}
