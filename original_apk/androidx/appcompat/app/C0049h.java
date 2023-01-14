package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.h  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0049h extends ArrayAdapter<CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f138a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController.a f139b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0049h(AlertController.a aVar, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.f139b = aVar;
        this.f138a = recycleListView;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f139b.F;
        if (zArr != null && zArr[i]) {
            this.f138a.setItemChecked(i, true);
        }
        return view2;
    }
}
