package a.d.a.a;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator */
abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f58a;

    /* renamed from: b  reason: collision with root package name */
    private final float f59b = (1.0f / ((float) (this.f58a.length - 1)));

    protected d(float[] fArr) {
        this.f58a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f58a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.f59b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f58a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
