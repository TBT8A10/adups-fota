package androidx.lifecycle;

import java.util.HashMap;

/* compiled from: ViewModelStore */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, r> f925a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, r rVar) {
        r put = this.f925a.put(str, rVar);
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final r a(String str) {
        return this.f925a.get(str);
    }

    public final void a() {
        for (r a2 : this.f925a.values()) {
            a2.a();
        }
        this.f925a.clear();
    }
}
