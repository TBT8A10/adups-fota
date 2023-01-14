package androidx.customview.a;

import android.view.animation.Interpolator;

/* compiled from: ViewDragHelper */
class e implements Interpolator {
    e() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
