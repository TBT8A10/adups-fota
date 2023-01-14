package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.z;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: androidx.appcompat.widget.v  reason: case insensitive filesystem */
/* compiled from: AppCompatSpinner */
class C0078v extends H {
    final /* synthetic */ AppCompatSpinner.b j;
    final /* synthetic */ AppCompatSpinner k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0078v(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner.b bVar) {
        super(view);
        this.k = appCompatSpinner;
        this.j = bVar;
    }

    public z a() {
        return this.j;
    }

    public boolean b() {
        if (this.k.mPopup.isShowing()) {
            return true;
        }
        this.k.mPopup.show();
        return true;
    }
}
