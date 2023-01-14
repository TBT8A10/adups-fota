package b.a.a.a.b.b;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class q extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f1408a;

    public q(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f1408a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == q.class) {
            if (this == obj) {
                return true;
            }
            q qVar = (q) obj;
            return this.f1408a == qVar.f1408a && get() == qVar.get();
        }
    }

    public final int hashCode() {
        return this.f1408a;
    }
}
