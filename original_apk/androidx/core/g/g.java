package androidx.core.g;

/* compiled from: Pools */
public class g<T> extends f<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f665c = new Object();

    public g(int i) {
        super(i);
    }

    public T acquire() {
        T acquire;
        synchronized (this.f665c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    public boolean release(T t) {
        boolean release;
        synchronized (this.f665c) {
            release = super.release(t);
        }
        return release;
    }
}
