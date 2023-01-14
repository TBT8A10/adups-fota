package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private int[] O = new int[2];

    public Explode() {
        a((C0125da) new C0140s());
    }

    private void e(ga gaVar) {
        View view = gaVar.f1273b;
        view.getLocationOnScreen(this.O);
        int[] iArr = this.O;
        int i = iArr[0];
        int i2 = iArr[1];
        gaVar.f1272a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    public void a(ga gaVar) {
        super.a(gaVar);
        e(gaVar);
    }

    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        float f;
        float f2;
        if (gaVar == null) {
            return null;
        }
        Rect rect = (Rect) gaVar.f1272a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) gaVar.f1273b.getTag(R$id.transition_position);
        if (iArr != null) {
            f2 = ((float) (iArr[0] - rect.left)) + translationX;
            f = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f2 = translationX;
            f = translationY;
        }
        a((View) viewGroup, rect, this.O);
        int[] iArr2 = this.O;
        return ia.a(view, gaVar, i, i2, translationX, translationY, f2 + ((float) iArr2[0]), f + ((float) iArr2[1]), N);
    }

    public void c(ga gaVar) {
        super.c(gaVar);
        e(gaVar);
    }

    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        if (gaVar2 == null) {
            return null;
        }
        Rect rect = (Rect) gaVar2.f1272a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a((View) viewGroup, rect, this.O);
        int[] iArr = this.O;
        return ia.a(view, gaVar2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, M);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a((C0125da) new C0140s());
    }

    private void a(View view, Rect rect, int[] iArr) {
        int i;
        int i2;
        View view2 = view;
        view2.getLocationOnScreen(this.O);
        int[] iArr2 = this.O;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        Rect c2 = c();
        if (c2 == null) {
            i2 = (view.getWidth() / 2) + i3 + Math.round(view.getTranslationX());
            i = (view.getHeight() / 2) + i4 + Math.round(view.getTranslationY());
        } else {
            int centerX = c2.centerX();
            i = c2.centerY();
            i2 = centerX;
        }
        float centerX2 = (float) (rect.centerX() - i2);
        float centerY = (float) (rect.centerY() - i);
        if (centerX2 == 0.0f && centerY == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float a2 = a(centerX2, centerY);
        float a3 = a(view2, i2 - i3, i - i4);
        iArr[0] = Math.round((centerX2 / a2) * a3);
        iArr[1] = Math.round(a3 * (centerY / a2));
    }

    private static float a(View view, int i, int i2) {
        return a((float) Math.max(i, view.getWidth() - i), (float) Math.max(i2, view.getHeight() - i2));
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
