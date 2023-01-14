package org.greenrobot.eventbus;

/* compiled from: Subscription */
final class s {

    /* renamed from: a  reason: collision with root package name */
    final Object f2565a;

    /* renamed from: b  reason: collision with root package name */
    final q f2566b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f2567c = true;

    s(Object obj, q qVar) {
        this.f2565a = obj;
        this.f2566b = qVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f2565a != sVar.f2565a || !this.f2566b.equals(sVar.f2566b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f2565a.hashCode() + this.f2566b.f.hashCode();
    }
}
