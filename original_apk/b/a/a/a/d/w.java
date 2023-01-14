package b.a.a.a.d;

final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f1455a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ v f1456b;

    w(v vVar, h hVar) {
        this.f1456b = vVar;
        this.f1455a = hVar;
    }

    public final void run() {
        synchronized (this.f1456b.f1453b) {
            if (this.f1456b.f1454c != null) {
                this.f1456b.f1454c.a(this.f1455a.b());
            }
        }
    }
}
