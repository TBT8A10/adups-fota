package b.a.a.a.b.b;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class n {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<q, List<Throwable>> f1404a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b  reason: collision with root package name */
    private final ReferenceQueue<Throwable> f1405b = new ReferenceQueue<>();

    n() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f1405b.poll();
        while (poll != null) {
            this.f1404a.remove(poll);
            poll = this.f1405b.poll();
        }
        List<Throwable> list = this.f1404a.get(new q(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f1404a.putIfAbsent(new q(th, this.f1405b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
