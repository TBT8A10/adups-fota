package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.i  reason: case insensitive filesystem */
/* compiled from: AlertController */
class C0050i extends CursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final int f140a;

    /* renamed from: b  reason: collision with root package name */
    private final int f141b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f142c;
    final /* synthetic */ AlertController d;
    final /* synthetic */ AlertController.a e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0050i(AlertController.a aVar, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.e = aVar;
        this.f142c = recycleListView;
        this.d = alertController;
        Cursor cursor2 = getCursor();
        this.f140a = cursor2.getColumnIndexOrThrow(this.e.L);
        this.f141b = cursor2.getColumnIndexOrThrow(this.e.M);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f140a));
        AlertController.RecycleListView recycleListView = this.f142c;
        int position = cursor.getPosition();
        boolean z = true;
        if (cursor.getInt(this.f141b) != 1) {
            z = false;
        }
        recycleListView.setItemChecked(position, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.e.f74b.inflate(this.d.M, viewGroup, false);
    }
}
