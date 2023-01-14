package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.G;

/* compiled from: AppCompatDelegateImpl */
class r implements G.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f155a;

    r(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f155a = appCompatDelegateImpl;
    }

    public void a(Rect rect) {
        rect.top = this.f155a.j(rect.top);
    }
}
