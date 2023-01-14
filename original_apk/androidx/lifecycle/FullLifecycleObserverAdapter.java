package androidx.lifecycle;

import androidx.lifecycle.f;

class FullLifecycleObserverAdapter implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f892a;

    FullLifecycleObserverAdapter(b bVar) {
        this.f892a = bVar;
    }

    public void a(h hVar, f.a aVar) {
        switch (c.f910a[aVar.ordinal()]) {
            case 1:
                this.f892a.a(hVar);
                return;
            case 2:
                this.f892a.f(hVar);
                return;
            case 3:
                this.f892a.b(hVar);
                return;
            case 4:
                this.f892a.c(hVar);
                return;
            case 5:
                this.f892a.d(hVar);
                return;
            case 6:
                this.f892a.e(hVar);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
