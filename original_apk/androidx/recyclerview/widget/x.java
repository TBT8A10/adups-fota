package androidx.recyclerview.widget;

/* compiled from: RecyclerView */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f1149a;

    x(RecyclerView recyclerView) {
        this.f1149a = recyclerView;
    }

    public void run() {
        RecyclerView recyclerView = this.f1149a;
        if (recyclerView.E && !recyclerView.isLayoutRequested()) {
            RecyclerView recyclerView2 = this.f1149a;
            if (!recyclerView2.B) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.H) {
                recyclerView2.G = true;
            } else {
                recyclerView2.b();
            }
        }
    }
}
