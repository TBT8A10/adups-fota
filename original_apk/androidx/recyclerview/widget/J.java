package androidx.recyclerview.widget;

/* compiled from: StaggeredGridLayoutManager */
class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f1010a;

    J(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f1010a = staggeredGridLayoutManager;
    }

    public void run() {
        this.f1010a.F();
    }
}
