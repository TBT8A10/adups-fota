package androidx.appcompat.widget;

import android.view.View;

/* compiled from: ScrollingTabContainerView */
class N implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f358a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ScrollingTabContainerView f359b;

    N(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.f359b = scrollingTabContainerView;
        this.f358a = view;
    }

    public void run() {
        this.f359b.smoothScrollTo(this.f358a.getLeft() - ((this.f359b.getWidth() - this.f358a.getWidth()) / 2), 0);
        this.f359b.f365b = null;
    }
}
