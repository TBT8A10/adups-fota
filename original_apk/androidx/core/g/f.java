package androidx.core.g;

/* compiled from: Pools */
public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f663a;

    /* renamed from: b  reason: collision with root package name */
    private int f664b;

    public f(int i) {
        if (i > 0) {
            this.f663a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean a(T t) {
        for (int i = 0; i < this.f664b; i++) {
            if (this.f663a[i] == t) {
                return true;
            }
        }
        return false;
    }

    public T acquire() {
        int i = this.f664b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        T[] tArr = this.f663a;
        T t = tArr[i2];
        tArr[i2] = null;
        this.f664b = i - 1;
        return t;
    }

    public boolean release(T t) {
        if (!a(t)) {
            int i = this.f664b;
            Object[] objArr = this.f663a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f664b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
