package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.a.i;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    private static final TimeInterpolator M = new DecelerateInterpolator();
    private static final TimeInterpolator N = new AccelerateInterpolator();
    private static final a O = new P();
    private static final a P = new Q();
    private static final a Q = new S();
    private static final a R = new T();
    private static final a S = new U();
    private static final a T = new V();
    private a U = T;
    private int V = 80;

    private interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class b implements a {
        private b() {
        }

        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ b(P p) {
            this();
        }
    }

    private static abstract class c implements a {
        private c() {
        }

        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ c(P p) {
            this();
        }
    }

    public Slide() {
        b(80);
    }

    private void e(ga gaVar) {
        int[] iArr = new int[2];
        gaVar.f1273b.getLocationOnScreen(iArr);
        gaVar.f1272a.put("android:slide:screenPosition", iArr);
    }

    public void a(ga gaVar) {
        super.a(gaVar);
        e(gaVar);
    }

    public void b(int i) {
        if (i == 3) {
            this.U = O;
        } else if (i == 5) {
            this.U = R;
        } else if (i == 48) {
            this.U = Q;
        } else if (i == 80) {
            this.U = T;
        } else if (i == 8388611) {
            this.U = P;
        } else if (i == 8388613) {
            this.U = S;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.V = i;
        O o = new O();
        o.a(i);
        a((C0125da) o);
    }

    public void c(ga gaVar) {
        super.c(gaVar);
        e(gaVar);
    }

    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        if (gaVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) gaVar2.f1272a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return ia.a(view, gaVar2, iArr[0], iArr[1], this.U.b(viewGroup, view), this.U.a_shaKey_method2(viewGroup, view), translationX, translationY, M);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.h);
        int b2 = i.b(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        b(b2);
    }

    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        if (gaVar == null) {
            return null;
        }
        int[] iArr = (int[]) gaVar.f1272a.get("android:slide:screenPosition");
        return ia.a(view, gaVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.U.b(viewGroup, view), this.U.a_shaKey_method2(viewGroup, view), N);
    }
}
