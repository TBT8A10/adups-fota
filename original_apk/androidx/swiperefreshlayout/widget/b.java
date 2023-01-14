package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.d;

/* compiled from: CircularProgressDrawable */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1170a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f1171b;

    b(d dVar, d.a aVar) {
        this.f1171b = dVar;
        this.f1170a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f1171b.a(floatValue, this.f1170a);
        this.f1171b.a(floatValue, this.f1170a, false);
        this.f1171b.invalidateSelf();
    }
}
