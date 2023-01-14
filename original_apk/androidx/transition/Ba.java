package androidx.transition;

import android.view.View;

/* compiled from: VisibilityPropagation */
public abstract class Ba extends C0125da {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1200a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    public void a(ga gaVar) {
        View view = gaVar.f1273b;
        Integer num = (Integer) gaVar.f1272a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        gaVar.f1272a.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        gaVar.f1272a.put("android:visibilityPropagation:center", iArr);
    }

    public int b(ga gaVar) {
        Integer num;
        if (gaVar == null || (num = (Integer) gaVar.f1272a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int c(ga gaVar) {
        return a(gaVar, 0);
    }

    public int d(ga gaVar) {
        return a(gaVar, 1);
    }

    public String[] a() {
        return f1200a;
    }

    private static int a(ga gaVar, int i) {
        int[] iArr;
        if (gaVar == null || (iArr = (int[]) gaVar.f1272a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }
}
