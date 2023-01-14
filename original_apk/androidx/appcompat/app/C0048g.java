package androidx.appcompat.app;

import android.view.View;

/* renamed from: androidx.appcompat.app.g  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0048g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f135a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f136b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AlertController f137c;

    C0048g(AlertController alertController, View view, View view2) {
        this.f137c = alertController;
        this.f135a = view;
        this.f136b = view2;
    }

    public void run() {
        AlertController.a(this.f137c.g, this.f135a, this.f136b);
    }
}
