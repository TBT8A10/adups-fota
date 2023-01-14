package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: androidx.appcompat.widget.y  reason: case insensitive filesystem */
/* compiled from: AppCompatSpinner */
class C0081y implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f483a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppCompatSpinner.b f484b;

    C0081y(AppCompatSpinner.b bVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f484b = bVar;
        this.f483a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f483a);
        }
    }
}
