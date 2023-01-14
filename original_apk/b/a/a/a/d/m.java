package b.a.a.a.d;

final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f1431a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ l f1432b;

    m(l lVar, h hVar) {
        this.f1432b = lVar;
        this.f1431a = hVar;
    }

    public final void run() {
        if (this.f1431a.c()) {
            this.f1432b.f1430c.f();
            return;
        }
        try {
            this.f1432b.f1430c.a(this.f1432b.f1429b.a(this.f1431a));
        } catch (f e) {
            if (e.getCause() instanceof Exception) {
                this.f1432b.f1430c.a((Exception) e.getCause());
            } else {
                this.f1432b.f1430c.a((Exception) e);
            }
        } catch (Exception e2) {
            this.f1432b.f1430c.a(e2);
        }
    }
}
