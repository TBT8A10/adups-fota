package androidx.core.g;

/* compiled from: Pair */
public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f661a;

    /* renamed from: b  reason: collision with root package name */
    public final S f662b;

    public d(F f, S s) {
        this.f661a = f;
        this.f662b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.f661a, this.f661a) || !c.a(dVar.f662b, this.f662b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f = this.f661a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f662b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f661a) + " " + String.valueOf(this.f662b) + "}";
    }
}
