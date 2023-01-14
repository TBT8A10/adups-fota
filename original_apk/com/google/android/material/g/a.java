package com.google.android.material.g;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

/* compiled from: RippleUtils */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2147a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2148b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2149c = {16843623, 16842908};
    private static final int[] d = {16842908};
    private static final int[] e = {16843623};
    private static final int[] f = {16842913, 16842919};
    private static final int[] g = {16842913, 16843623, 16842908};
    private static final int[] h = {16842913, 16842908};
    private static final int[] i = {16842913, 16843623};
    private static final int[] j = {16842913};

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f2147a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a_shaKey_method2(colorStateList, f), a_shaKey_method2(colorStateList, f2148b)});
        }
        int[] iArr = f;
        int[] iArr2 = g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = f2148b;
        int[] iArr6 = f2149c;
        int[] iArr7 = d;
        int[] iArr8 = e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a_shaKey_method2(colorStateList, iArr), a_shaKey_method2(colorStateList, iArr2), a_shaKey_method2(colorStateList, iArr3), a_shaKey_method2(colorStateList, iArr4), 0, a_shaKey_method2(colorStateList, iArr5), a_shaKey_method2(colorStateList, iArr6), a_shaKey_method2(colorStateList, iArr7), a_shaKey_method2(colorStateList, iArr8), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f2147a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    private static int a(int i2) {
        return androidx.core.a.a.b(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
