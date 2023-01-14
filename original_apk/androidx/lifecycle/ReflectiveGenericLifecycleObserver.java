package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.f;

class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f899a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0018a f900b = a.f903a.a(this.f899a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f899a = obj;
    }

    public void a(h hVar, f.a aVar) {
        this.f900b.a(hVar, aVar, this.f899a);
    }
}
