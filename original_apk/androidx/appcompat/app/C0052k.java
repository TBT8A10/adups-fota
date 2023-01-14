package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.k  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0052k implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f145a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController f146b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AlertController.a f147c;

    C0052k(AlertController.a aVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f147c = aVar;
        this.f145a = recycleListView;
        this.f146b = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.f147c.F;
        if (zArr != null) {
            zArr[i] = this.f145a.isItemChecked(i);
        }
        this.f147c.J.onClick(this.f146b.f69b, i, this.f145a.isItemChecked(i));
    }
}
