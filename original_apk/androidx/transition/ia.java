package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

/* compiled from: TranslationAnimationCreator */
class ia {

    /* compiled from: TranslationAnimationCreator */
    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f1280a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1281b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1282c;
        private final int d;
        private int[] e = ((int[]) this.f1280a.getTag(R$id.transition_position));
        private float f;
        private float g;
        private final float h;
        private final float i;

        a(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f1281b = view;
            this.f1280a = view2;
            this.f1282c = i2 - Math.round(this.f1281b.getTranslationX());
            this.d = i3 - Math.round(this.f1281b.getTranslationY());
            this.h = f2;
            this.i = f3;
            if (this.e != null) {
                this.f1280a.setTag(R$id.transition_position, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round(((float) this.f1282c) + this.f1281b.getTranslationX());
            this.e[1] = Math.round(((float) this.d) + this.f1281b.getTranslationY());
            this.f1280a.setTag(R$id.transition_position, this.e);
        }

        public void onAnimationEnd(Animator animator) {
            this.f1281b.setTranslationX(this.h);
            this.f1281b.setTranslationY(this.i);
        }

        public void onAnimationPause(Animator animator) {
            this.f = this.f1281b.getTranslationX();
            this.g = this.f1281b.getTranslationY();
            this.f1281b.setTranslationX(this.h);
            this.f1281b.setTranslationY(this.i);
        }

        public void onAnimationResume(Animator animator) {
            this.f1281b.setTranslationX(this.f);
            this.f1281b.setTranslationY(this.g);
        }
    }

    static Animator a(View view, ga gaVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float f5;
        float f6;
        View view2 = view;
        ga gaVar2 = gaVar;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) gaVar2.f1273b.getTag(R$id.transition_position);
        if (iArr != null) {
            f5 = ((float) (iArr[0] - i)) + translationX;
            f6 = ((float) (iArr[1] - i2)) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = i + Math.round(f5 - translationX);
        int round2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f5, f3}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f6, f4})});
        a aVar = new a(view, gaVar2.f1273b, round, round2, translationX, translationY);
        ofPropertyValuesHolder.addListener(aVar);
        C0118a.a_shaKey_method2(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
