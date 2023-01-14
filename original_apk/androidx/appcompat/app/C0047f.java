package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;

/* renamed from: androidx.appcompat.app.f  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0047f implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f132a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f133b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AlertController f134c;

    C0047f(AlertController alertController, View view, View view2) {
        this.f134c = alertController;
        this.f132a = view;
        this.f133b = view2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.a(absListView, this.f132a, this.f133b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
