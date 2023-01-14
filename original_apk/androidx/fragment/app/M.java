package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener */
class M implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f834a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f835b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f836c;

    private M(View view, Runnable runnable) {
        this.f834a = view;
        this.f835b = view.getViewTreeObserver();
        this.f836c = runnable;
    }

    public static M a(View view, Runnable runnable) {
        M m = new M(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(m);
        view.addOnAttachStateChangeListener(m);
        return m;
    }

    public boolean onPreDraw() {
        a();
        this.f836c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f835b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f835b.isAlive()) {
            this.f835b.removeOnPreDrawListener(this);
        } else {
            this.f834a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f834a.removeOnAttachStateChangeListener(this);
    }
}
