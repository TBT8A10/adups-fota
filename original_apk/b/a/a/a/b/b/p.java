package b.a.a.a.b.b;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class p extends o {

    /* renamed from: b  reason: collision with root package name */
    private final n f1407b = new n();

    p() {
    }

    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.f1407b.a(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
