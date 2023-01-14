package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* renamed from: androidx.appcompat.app.d  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0045d implements NestedScrollView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f126a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f127b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AlertController f128c;

    C0045d(AlertController alertController, View view, View view2) {
        this.f128c = alertController;
        this.f126a = view;
        this.f127b = view2;
    }

    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.a(nestedScrollView, this.f126a, this.f127b);
    }
}
