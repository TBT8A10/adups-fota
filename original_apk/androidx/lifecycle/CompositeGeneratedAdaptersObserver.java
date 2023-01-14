package androidx.lifecycle;

import androidx.lifecycle.f;

public class CompositeGeneratedAdaptersObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final d[] f891a;

    CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f891a = dVarArr;
    }

    public void a(h hVar, f.a aVar) {
        n nVar = new n();
        for (d a2 : this.f891a) {
            a2.a(hVar, aVar, false, nVar);
        }
        for (d a3 : this.f891a) {
            a3.a(hVar, aVar, true, nVar);
        }
    }
}
