package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: AppCompatDelegateImpl */
class s implements ContentFrameLayout.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f156a;

    s(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f156a = appCompatDelegateImpl;
    }

    public void a() {
    }

    public void onDetachedFromWindow() {
        this.f156a.l();
    }
}
