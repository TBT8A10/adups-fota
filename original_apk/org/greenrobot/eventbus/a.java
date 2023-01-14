package org.greenrobot.eventbus;

/* compiled from: AsyncPoster */
class a implements Runnable, n {

    /* renamed from: a  reason: collision with root package name */
    private final m f2524a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final e f2525b;

    a(e eVar) {
        this.f2525b = eVar;
    }

    public void a(s sVar, Object obj) {
        this.f2524a.a(l.a(sVar, obj));
        this.f2525b.b().execute(this);
    }

    public void run() {
        l a2 = this.f2524a.a();
        if (a2 != null) {
            this.f2525b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
