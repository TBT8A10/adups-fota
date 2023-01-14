package androidx.lifecycle;

/* compiled from: ViewModelProvider */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f923a;

    /* renamed from: b  reason: collision with root package name */
    private final t f924b;

    /* compiled from: ViewModelProvider */
    public interface a {
        <T extends r> T a(Class<T> cls);
    }

    public s(t tVar, a aVar) {
        this.f923a = aVar;
        this.f924b = tVar;
    }

    public <T extends r> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends r> T a(String str, Class<T> cls) {
        T a2 = this.f924b.a(str);
        if (cls.isInstance(a2)) {
            return a2;
        }
        T a3 = this.f923a.a(cls);
        this.f924b.a(str, a3);
        return a3;
    }
}
