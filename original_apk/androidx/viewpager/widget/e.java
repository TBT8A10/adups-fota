package androidx.viewpager.widget;

import android.view.animation.Interpolator;

/* compiled from: ViewPager */
class e implements Interpolator {
    e() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
