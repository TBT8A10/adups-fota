package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import com.google.android.material.R$id;
import com.google.android.material.a.b;
import com.google.android.material.a.c;
import com.google.android.material.a.d;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.circularreveal.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f2273c = new Rect();
    private final RectF d = new RectF();
    private final RectF e = new RectF();
    private final int[] f = new int[2];

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        public h f2274a;

        /* renamed from: b  reason: collision with root package name */
        public j f2275b;

        protected a() {
        }
    }

    public FabTransformationBehavior() {
    }

    @TargetApi(21)
    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float g = t.g(view2) - t.g(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-g);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-g});
        }
        aVar.f2274a.a("elevation").a((Animator) objectAnimator);
        list.add(objectAnimator);
    }

    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof e) && (view instanceof ImageView)) {
            e eVar = (e) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f1992a, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, com.google.android.material.a.e.f1992a, new int[]{255});
                }
                objectAnimator.addUpdateListener(new d(this, view2));
                aVar.f2274a.a("iconFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
                list2.add(new e(this, eVar, drawable));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract a a(Context context, boolean z);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        boolean z3 = z;
        a a2 = a_shaKey_method2(view2.getContext(), z3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.d;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z;
        boolean z5 = z2;
        a aVar = a2;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        a(view3, view4, z4, z5, aVar, (List<Animator>) arrayList3, (List<Animator.AnimatorListener>) arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        d(view3, view4, z4, z5, aVar, arrayList3, arrayList4);
        a(view3, view4, z4, z5, aVar, width, height, (List<Animator>) arrayList, (List<Animator.AnimatorListener>) arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        b(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        a(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a_shaKey_method2(animatorSet, arrayList);
        animatorSet.addListener(new c(this, z3, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(CoordinatorLayout.d dVar) {
        if (dVar.h == 0) {
            dVar.h = 80;
        }
    }

    private float c(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a_shaKey_method2(view, rectF);
        a_shaKey_method2(view2, rectF2);
        int i = jVar.f2002a & 7;
        if (i == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i != 5) {
            f2 = 0.0f;
            return f2 + jVar.f2003b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f2003b;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        i iVar;
        i iVar2;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        List<Animator> list3 = list;
        float c2 = c(view3, view4, aVar2.f2275b);
        float d2 = d(view3, view4, aVar2.f2275b);
        if (c2 == 0.0f || d2 == 0.0f) {
            iVar2 = aVar2.f2274a.a("translationXLinear");
            iVar = aVar2.f2274a.a("translationYLinear");
        } else if ((!z || d2 >= 0.0f) && (z || d2 <= 0.0f)) {
            iVar2 = aVar2.f2274a.a("translationXCurveDownwards");
            iVar = aVar2.f2274a.a("translationYCurveDownwards");
        } else {
            iVar2 = aVar2.f2274a.a("translationXCurveUpwards");
            iVar = aVar2.f2274a.a("translationYCurveUpwards");
        }
        i iVar3 = iVar2;
        i iVar4 = iVar;
        if (z) {
            if (!z2) {
                view4.setTranslationX(-c2);
                view4.setTranslationY(-d2);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            a(view2, aVar, iVar3, iVar4, -c2, -d2, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-c2});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-d2});
        }
        iVar3.a((Animator) objectAnimator2);
        iVar4.a((Animator) objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private float d(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a_shaKey_method2(view, rectF);
        a_shaKey_method2(view2, rectF2);
        int i = jVar.f2002a & 112;
        if (i == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i != 80) {
            f2 = 0.0f;
            return f2 + jVar.f2004c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.f2004c;
    }

    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void b(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof e) {
            e eVar = (e) view2;
            int b2 = b(view);
            int i = 16777215 & b2;
            if (z) {
                if (!z2) {
                    eVar.setCircularRevealScrimColor(b2);
                }
                objectAnimator = ObjectAnimator.ofInt(eVar, e.c.f2112a, new int[]{i});
            } else {
                objectAnimator = ObjectAnimator.ofInt(eVar, e.c.f2112a, new int[]{b2});
            }
            objectAnimator.setEvaluator(c.a());
            aVar.f2274a.a("color").a((Animator) objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        if (view4 instanceof e) {
            e eVar = (e) view4;
            float a2 = a(view3, view4, aVar2.f2275b);
            float b2 = b(view3, view4, aVar2.f2275b);
            ((FloatingActionButton) view3).a(this.f2273c);
            float width = ((float) this.f2273c.width()) / 2.0f;
            i a3 = aVar2.f2274a.a("expansion");
            if (z) {
                if (!z2) {
                    eVar.setRevealInfo(new e.d(a2, b2, width));
                }
                if (z2) {
                    width = eVar.getRevealInfo().f2115c;
                }
                animator = com.google.android.material.circularreveal.b.a(eVar, a2, b2, com.google.android.material.e.a.a(a2, b2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new f(this, eVar));
                a(view2, a3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f4 = eVar.getRevealInfo().f2115c;
                Animator a4 = com.google.android.material.circularreveal.b.a(eVar, a2, b2, width);
                int i = (int) a2;
                int i2 = (int) b2;
                View view5 = view2;
                a(view5, a3.a(), i, i2, f4, list);
                long a5 = a3.a();
                long b3 = a3.b();
                long a6 = aVar2.f2274a.a();
                a(view5, a5, b3, a6, i, i2, width, list);
                animator = a4;
            }
            a3.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.b.a(eVar));
        }
    }

    private float b(View view, View view2, j jVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a_shaKey_method2(view, rectF);
        a_shaKey_method2(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(View view) {
        ColorStateList c2 = t.c(view);
        if (c2 != null) {
            return c2.getColorForState(view.getDrawableState(), c2.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof e) || com.google.android.material.circularreveal.c.f2106a != 0) && (a2 = a(view2)) != null) {
                if (z) {
                    if (!z2) {
                        d.f1991a.set(a2, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(a2, d.f1991a, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(a2, d.f1991a, new float[]{0.0f});
                }
                aVar.f2274a.a("contentFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private float a(View view, View view2, j jVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a_shaKey_method2(view, rectF);
        a_shaKey_method2(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(aVar, iVar, f2, f4);
        float a3 = a(aVar, iVar2, f3, f5);
        Rect rect = this.f2273c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.d;
        rectF2.set(rect);
        RectF rectF3 = this.e;
        a_shaKey_method2(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i a3 = aVar.f2274a.a("expansion");
        return com.google.android.material.a.a.a(f2, f3, iVar.c().getInterpolation(((float) (((a3.a() + a3.b()) + 17) - a2)) / ((float) b2)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (findViewById != null) {
            return c(findViewById);
        }
        if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
            return c(((ViewGroup) view).getChildAt(0));
        }
        return c(view);
    }

    private void a(View view, long j, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
