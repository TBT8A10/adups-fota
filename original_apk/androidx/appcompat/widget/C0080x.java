package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: androidx.appcompat.widget.x  reason: case insensitive filesystem */
/* compiled from: AppCompatSpinner */
class C0080x implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f482a;

    C0080x(AppCompatSpinner.b bVar) {
        this.f482a = bVar;
    }

    public void onGlobalLayout() {
        AppCompatSpinner.b bVar = this.f482a;
        if (!bVar.b(AppCompatSpinner.this)) {
            this.f482a.dismiss();
            return;
        }
        this.f482a.i();
        C0080x.super.show();
    }
}
