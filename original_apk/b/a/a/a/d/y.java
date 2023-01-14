package b.a.a.a.d;

import java.util.concurrent.CancellationException;

final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f1460a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ x f1461b;

    y(x xVar, h hVar) {
        this.f1461b = xVar;
        this.f1460a = hVar;
    }

    public final void run() {
        try {
            h a2 = this.f1461b.f1458b.a(this.f1460a.b());
            if (a2 == null) {
                this.f1461b.a((Exception) new NullPointerException("Continuation returned null"));
                return;
            }
            a2.a_shaKey_method2(j.f1425b, this.f1461b);
            a2.a(j.f1425b, (C0151d) this.f1461b);
            a2.a(j.f1425b, (C0149b) this.f1461b);
        } catch (f e) {
            if (e.getCause() instanceof Exception) {
                this.f1461b.a((Exception) e.getCause());
            } else {
                this.f1461b.a((Exception) e);
            }
        } catch (CancellationException unused) {
            this.f1461b.a();
        } catch (Exception e2) {
            this.f1461b.a(e2);
        }
    }
}
