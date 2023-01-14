package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: androidx.appcompat.widget.w  reason: case insensitive filesystem */
/* compiled from: AppCompatSpinner */
class C0079w implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner f479a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f480b;

    C0079w(AppCompatSpinner.b bVar, AppCompatSpinner appCompatSpinner) {
        this.f480b = bVar;
        this.f479a = appCompatSpinner;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppCompatSpinner.this.setSelection(i);
        if (AppCompatSpinner.this.getOnItemClickListener() != null) {
            AppCompatSpinner.b bVar = this.f480b;
            AppCompatSpinner.this.performItemClick(view, i, bVar.L.getItemId(i));
        }
        this.f480b.dismiss();
    }
}
