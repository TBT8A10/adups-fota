package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerView */
class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f1150a;

    y(RecyclerView recyclerView) {
        this.f1150a = recyclerView;
    }

    public void run() {
        RecyclerView.f fVar = this.f1150a.W;
        if (fVar != null) {
            fVar.i();
        }
        this.f1150a.wa = false;
    }
}
