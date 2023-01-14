package androidx.lifecycle;

/* compiled from: LiveData */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveData f921a;

    m(LiveData liveData) {
        this.f921a = liveData;
    }

    public void run() {
        Object obj;
        synchronized (this.f921a.f894b) {
            obj = this.f921a.f;
            this.f921a.f = LiveData.f893a;
        }
        this.f921a.a(obj);
    }
}
