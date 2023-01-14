package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] K = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    private void d(ga gaVar) {
        gaVar.f1272a.put("android:changeScroll:x", Integer.valueOf(gaVar.f1273b.getScrollX()));
        gaVar.f1272a.put("android:changeScroll:y", Integer.valueOf(gaVar.f1273b.getScrollY()));
    }

    public void a(ga gaVar) {
        d(gaVar);
    }

    public void c(ga gaVar) {
        d(gaVar);
    }

    public String[] n() {
        return K;
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (gaVar == null || gaVar2 == null) {
            return null;
        }
        View view = gaVar2.f1273b;
        int intValue = ((Integer) gaVar.f1272a.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) gaVar2.f1272a.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) gaVar.f1272a.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) gaVar2.f1272a.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        }
        return fa.a_shaKey_method2(objectAnimator, objectAnimator2);
    }
}
