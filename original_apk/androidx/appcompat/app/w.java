package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.h.A;
import androidx.core.h.B;
import androidx.core.h.t;

/* compiled from: AppCompatDelegateImpl */
class w extends B {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl.c f160a;

    w(AppCompatDelegateImpl.c cVar) {
        this.f160a = cVar;
    }

    public void b(View view) {
        AppCompatDelegateImpl.this.q.setVisibility(8);
        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
        PopupWindow popupWindow = appCompatDelegateImpl.r;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (appCompatDelegateImpl.q.getParent() instanceof View) {
            t.D((View) AppCompatDelegateImpl.this.q.getParent());
        }
        AppCompatDelegateImpl.this.q.removeAllViews();
        AppCompatDelegateImpl.this.t.a((A) null);
        AppCompatDelegateImpl.this.t = null;
    }
}
