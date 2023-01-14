package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.C0053a;

/* compiled from: ToolbarWidgetWrapper */
class na implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0053a f446a = new C0053a(this.f447b.f457a.getContext(), 0, 16908332, 0, 0, this.f447b.i);

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ pa f447b;

    na(pa paVar) {
        this.f447b = paVar;
    }

    public void onClick(View view) {
        pa paVar = this.f447b;
        Window.Callback callback = paVar.l;
        if (callback != null && paVar.m) {
            callback.onMenuItemSelected(0, this.f446a);
        }
    }
}
