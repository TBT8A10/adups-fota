package b.a.a.a.d;

final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f1436a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ n f1437b;

    o(n nVar, h hVar) {
        this.f1437b = nVar;
        this.f1436a = hVar;
    }

    public final void run() {
        try {
            h hVar = (h) this.f1437b.f1434b.a(this.f1436a);
            if (hVar == null) {
                this.f1437b.a((Exception) new NullPointerException("Continuation returned null"));
                return;
            }
            hVar.a_shaKey_method2(j.f1425b, this.f1437b);
            hVar.a(j.f1425b, (C0151d) this.f1437b);
            hVar.a(j.f1425b, (C0149b) this.f1437b);
        } catch (f e) {
            if (e.getCause() instanceof Exception) {
                this.f1437b.f1435c.a((Exception) e.getCause());
            } else {
                this.f1437b.f1435c.a((Exception) e);
            }
        } catch (Exception e2) {
            this.f1437b.f1435c.a(e2);
        }
    }
}
