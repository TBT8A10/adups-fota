package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import com.google.android.material.circularreveal.e;

/* compiled from: CircularRevealCompat */
public final class b {
    public static Animator a(e eVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(eVar, e.b.f2111a, e.a.f2109a, new e.d[]{new e.d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        e.d revealInfo = eVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) eVar, (int) f, (int) f2, revealInfo.f2115c, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator.AnimatorListener a(e eVar) {
        return new a(eVar);
    }
}
