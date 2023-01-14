package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* renamed from: androidx.transition.s  reason: case insensitive filesystem */
/* compiled from: CircularPropagation */
public class C0140s extends Ba {

    /* renamed from: b  reason: collision with root package name */
    private float f1306b = 3.0f;

    public long a(ViewGroup viewGroup, Transition transition, ga gaVar, ga gaVar2) {
        int i;
        int i2;
        int i3;
        if (gaVar == null && gaVar2 == null) {
            return 0;
        }
        if (gaVar2 == null || b(gaVar) == 0) {
            i = -1;
        } else {
            gaVar = gaVar2;
            i = 1;
        }
        int c2 = c(gaVar);
        int d = d(gaVar);
        Rect c3 = transition.c();
        if (c3 != null) {
            i3 = c3.centerX();
            i2 = c3.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i2 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i3 = round;
        }
        float a2 = a((float) c2, (float) d, (float) i3, (float) i2) / a(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long b2 = transition.b();
        if (b2 < 0) {
            b2 = 300;
        }
        return (long) Math.round((((float) (b2 * ((long) i))) / this.f1306b) * a2);
    }

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }
}
