package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1995a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1996b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f1997c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f1995a);
        matrix2.getValues(this.f1996b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f1996b;
            float f2 = fArr[i];
            float[] fArr2 = this.f1995a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.f1997c.setValues(this.f1996b);
        return this.f1997c;
    }
}
