package androidx.core.e;

/* compiled from: SelfDestructiveThread */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f617a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i f618b;

    h(i iVar, Object obj) {
        this.f618b = iVar;
        this.f617a = obj;
    }

    public void run() {
        this.f618b.f621c.a(this.f617a);
    }
}
