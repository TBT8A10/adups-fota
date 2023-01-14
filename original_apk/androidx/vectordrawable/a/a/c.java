package androidx.vectordrawable.a.a;

import android.graphics.drawable.Drawable;

/* compiled from: AnimatedVectorDrawableCompat */
class c implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1329a;

    c(d dVar) {
        this.f1329a = dVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f1329a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f1329a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f1329a.unscheduleSelf(runnable);
    }
}
