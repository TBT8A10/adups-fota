package androidx.appcompat.b.a;

/* compiled from: DrawableContainer */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f170a;

    c(d dVar) {
        this.f170a = dVar;
    }

    public void run() {
        this.f170a.a(true);
        this.f170a.invalidateSelf();
    }
}
