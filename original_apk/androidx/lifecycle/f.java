package androidx.lifecycle;

/* compiled from: Lifecycle */
public abstract class f {

    /* compiled from: Lifecycle */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: Lifecycle */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public abstract b a();

    public abstract void a(g gVar);

    public abstract void b(g gVar);
}
