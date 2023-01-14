package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.h.b;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import java.util.ArrayList;

/* compiled from: FloatingActionButtonImplLollipop */
class f extends e {
    private InsetDrawable I;

    /* compiled from: FloatingActionButtonImplLollipop */
    static class a extends GradientDrawable {
        a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    f(VisibilityAwareImageButton visibilityAwareImageButton, b bVar) {
        super(visibilityAwareImageButton, bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.q = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a_shaKey_method2(this.q, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a_shaKey_method2(this.q, mode);
        }
        if (i > 0) {
            this.s = a_shaKey_method2(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.s, this.q});
        } else {
            this.s = null;
            drawable = this.q;
        }
        this.r = new RippleDrawable(com.google.android.material.g.a.a(colorStateList2), drawable, (Drawable) null);
        Drawable drawable2 = this.r;
        this.t = drawable2;
        this.C.setBackgroundDrawable(drawable2);
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.g.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    public float c() {
        return this.B.getElevation();
    }

    /* access modifiers changed from: package-private */
    public void j() {
    }

    /* access modifiers changed from: package-private */
    public c k() {
        return new d();
    }

    /* access modifiers changed from: package-private */
    public GradientDrawable l() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public void n() {
        s();
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(Rect rect) {
        if (this.C.a()) {
            this.I = new InsetDrawable(this.r, rect.left, rect.top, rect.right, rect.bottom);
            this.C.setBackgroundDrawable(this.I);
            return;
        }
        this.C.setBackgroundDrawable(this.r);
    }

    /* access modifiers changed from: package-private */
    public void a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.B.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(e.f2142b, a(f, f3));
            stateListAnimator.addState(e.f2143c, a(f, f2));
            stateListAnimator.addState(e.d, a(f, f2));
            stateListAnimator.addState(e.e, a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.B, "elevation", new float[]{f}).setDuration(0));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                VisibilityAwareImageButton visibilityAwareImageButton = this.B;
                arrayList.add(ObjectAnimator.ofFloat(visibilityAwareImageButton, View.TRANSLATION_Z, new float[]{visibilityAwareImageButton.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(e.f2141a);
            stateListAnimator.addState(e.f, animatorSet);
            stateListAnimator.addState(e.g, a(0.0f, 0.0f));
            this.B.setStateListAnimator(stateListAnimator);
        }
        if (this.C.a()) {
            s();
        }
    }

    private Animator a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.B, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
        animatorSet.setInterpolator(e.f2141a);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.B.isEnabled()) {
            this.B.setElevation(this.u);
            if (this.B.isPressed()) {
                this.B.setTranslationZ(this.w);
            } else if (this.B.isFocused() || this.B.isHovered()) {
                this.B.setTranslationZ(this.v);
            } else {
                this.B.setTranslationZ(0.0f);
            }
        } else {
            this.B.setElevation(0.0f);
            this.B.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        if (this.C.a()) {
            float b2 = this.C.b();
            float c2 = c() + this.w;
            int ceil = (int) Math.ceil((double) com.google.android.material.h.a.a(c2, b2, false));
            int ceil2 = (int) Math.ceil((double) com.google.android.material.h.a.b(c2, b2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
