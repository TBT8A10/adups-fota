package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.d;

/* compiled from: CircularProgressDrawable */
class c implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1172a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f1173b;

    c(d dVar, d.a aVar) {
        this.f1173b = dVar;
        this.f1172a = aVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.f1173b.a(1.0f, this.f1172a, true);
        this.f1172a.l();
        this.f1172a.j();
        d dVar = this.f1173b;
        if (dVar.i) {
            dVar.i = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            this.f1172a.a(false);
            return;
        }
        dVar.h += 1.0f;
    }

    public void onAnimationStart(Animator animator) {
        this.f1173b.h = 0.0f;
    }
}
