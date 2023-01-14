package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.ga;
import java.util.Map;

/* compiled from: TextScale */
public class r extends Transition {
    private void d(ga gaVar) {
        View view = gaVar.f1273b;
        if (view instanceof TextView) {
            gaVar.f1272a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public void a(ga gaVar) {
        d(gaVar);
    }

    public void c(ga gaVar) {
        d(gaVar);
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        if (gaVar == null || gaVar2 == null || !(gaVar.f1273b instanceof TextView)) {
            return null;
        }
        View view = gaVar2.f1273b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = gaVar.f1272a;
        Map<String, Object> map2 = gaVar2.f1272a;
        float f = 1.0f;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new q(this, textView));
        return ofFloat;
    }
}
