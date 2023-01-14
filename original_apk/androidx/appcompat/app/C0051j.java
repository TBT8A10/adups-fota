package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.j  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0051j implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController f143a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController.a f144b;

    C0051j(AlertController.a aVar, AlertController alertController) {
        this.f144b = aVar;
        this.f143a = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f144b.x.onClick(this.f143a.f69b, i);
        if (!this.f144b.H) {
            this.f143a.f69b.dismiss();
        }
    }
}
