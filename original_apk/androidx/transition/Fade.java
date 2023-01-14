package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.i;
import androidx.core.h.t;
import androidx.transition.Transition;

public class Fade extends Visibility {

    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f1218a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1219b = false;

        a(View view) {
            this.f1218a = view;
        }

        public void onAnimationEnd(Animator animator) {
            va.a_shaKey_method2(this.f1218a, 1.0f);
            if (this.f1219b) {
                this.f1218a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (t.w(this.f1218a) && this.f1218a.getLayerType() == 0) {
                this.f1219b = true;
                this.f1218a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade(int i) {
        a(i);
    }

    private Animator a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        va.a_shaKey_method2(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, va.d, new float[]{f2});
        ofFloat.addListener(new a(view));
        a((Transition.c) new C0141t(this, view));
        return ofFloat;
    }

    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        va.e(view);
        return a(view, a(gaVar, 1.0f), 0.0f);
    }

    public void c(ga gaVar) {
        super.c(gaVar);
        gaVar.f1272a.put("android:fade:transitionAlpha", Float.valueOf(va.c(gaVar.f1273b)));
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.f);
        a(i.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, q()));
        obtainStyledAttributes.recycle();
    }

    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        float f = 0.0f;
        float a2 = a(gaVar, 0.0f);
        if (a2 != 1.0f) {
            f = a2;
        }
        return a(view, f, 1.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f1272a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float a(androidx.transition.ga r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f1272a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Fade.a(androidx.transition.ga, float):float");
    }
}
