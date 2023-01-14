package androidx.appcompat.app;

import android.view.View;

/* renamed from: androidx.appcompat.app.e  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0046e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f129a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f130b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AlertController f131c;

    C0046e(AlertController alertController, View view, View view2) {
        this.f131c = alertController;
        this.f129a = view;
        this.f130b = view2;
    }

    public void run() {
        AlertController.a(this.f131c.A, this.f129a, this.f130b);
    }
}
