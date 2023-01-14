package androidx.transition;

import android.animation.TypeEvaluator;

/* renamed from: androidx.transition.u  reason: case insensitive filesystem */
/* compiled from: FloatArrayEvaluator */
class C0142u implements TypeEvaluator<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f1309a;

    C0142u(float[] fArr) {
        this.f1309a = fArr;
    }

    /* renamed from: a */
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f1309a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return fArr3;
    }
}
