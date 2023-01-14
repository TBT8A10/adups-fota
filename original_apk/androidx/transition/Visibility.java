package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a.i;
import androidx.transition.C0118a;
import androidx.transition.Transition;

public abstract class Visibility extends Transition {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    private static class a extends AnimatorListenerAdapter implements Transition.c, C0118a.C0024a {

        /* renamed from: a  reason: collision with root package name */
        private final View f1241a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1242b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f1243c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        a(View view, int i, boolean z) {
            this.f1241a = view;
            this.f1242b = i;
            this.f1243c = (ViewGroup) view.getParent();
            this.d = z;
            a(true);
        }

        public void a(Transition transition) {
            a(true);
        }

        public void b(Transition transition) {
        }

        public void c(Transition transition) {
            a(false);
        }

        public void d(Transition transition) {
            a();
            transition.b((Transition.c) this);
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                va.a_shaKey_method2(this.f1241a, this.f1242b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                va.a_shaKey_method2(this.f1241a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        private void a() {
            if (!this.f) {
                va.a_shaKey_method2(this.f1241a, this.f1242b);
                ViewGroup viewGroup = this.f1243c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (this.d && this.e != z && (viewGroup = this.f1243c) != null) {
                this.e = z;
                ma.a_shaKey_method2(viewGroup, z);
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f1244a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1245b;

        /* renamed from: c  reason: collision with root package name */
        int f1246c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    public Visibility() {
    }

    private b b(ga gaVar, ga gaVar2) {
        b bVar = new b();
        bVar.f1244a = false;
        bVar.f1245b = false;
        if (gaVar == null || !gaVar.f1272a.containsKey("android:visibility:visibility")) {
            bVar.f1246c = -1;
            bVar.e = null;
        } else {
            bVar.f1246c = ((Integer) gaVar.f1272a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) gaVar.f1272a.get("android:visibility:parent");
        }
        if (gaVar2 == null || !gaVar2.f1272a.containsKey("android:visibility:visibility")) {
            bVar.d = -1;
            bVar.f = null;
        } else {
            bVar.d = ((Integer) gaVar2.f1272a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) gaVar2.f1272a.get("android:visibility:parent");
        }
        if (gaVar == null || gaVar2 == null) {
            if (gaVar == null && bVar.d == 0) {
                bVar.f1245b = true;
                bVar.f1244a = true;
            } else if (gaVar2 == null && bVar.f1246c == 0) {
                bVar.f1245b = false;
                bVar.f1244a = true;
            }
        } else if (bVar.f1246c == bVar.d && bVar.e == bVar.f) {
            return bVar;
        } else {
            int i = bVar.f1246c;
            int i2 = bVar.d;
            if (i != i2) {
                if (i == 0) {
                    bVar.f1245b = false;
                    bVar.f1244a = true;
                } else if (i2 == 0) {
                    bVar.f1245b = true;
                    bVar.f1244a = true;
                }
            } else if (bVar.f == null) {
                bVar.f1245b = false;
                bVar.f1244a = true;
            } else if (bVar.e == null) {
                bVar.f1245b = true;
                bVar.f1244a = true;
            }
        }
        return bVar;
    }

    private void d(ga gaVar) {
        gaVar.f1272a.put("android:visibility:visibility", Integer.valueOf(gaVar.f1273b.getVisibility()));
        gaVar.f1272a.put("android:visibility:parent", gaVar.f1273b.getParent());
        int[] iArr = new int[2];
        gaVar.f1273b.getLocationOnScreen(iArr);
        gaVar.f1272a.put("android:visibility:screenLocation", iArr);
    }

    public Animator a(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        return null;
    }

    public void a(int i) {
        if ((i & -4) == 0) {
            this.L = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public Animator b(ViewGroup viewGroup, View view, ga gaVar, ga gaVar2) {
        return null;
    }

    public void c(ga gaVar) {
        d(gaVar);
    }

    public String[] n() {
        return K;
    }

    public int q() {
        return this.L;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.e);
        int b2 = i.b(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (b2 != 0) {
            a(b2);
        }
    }

    public void a(ga gaVar) {
        d(gaVar);
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        b b2 = b(gaVar, gaVar2);
        if (!b2.f1244a) {
            return null;
        }
        if (b2.e == null && b2.f == null) {
            return null;
        }
        if (b2.f1245b) {
            return a(viewGroup, gaVar, b2.f1246c, gaVar2, b2.d);
        }
        return b(viewGroup, gaVar, b2.f1246c, gaVar2, b2.d);
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, int i, ga gaVar2, int i2) {
        if ((this.L & 1) != 1 || gaVar2 == null) {
            return null;
        }
        if (gaVar == null) {
            View view = (View) gaVar2.f1273b.getParent();
            if (b(a_shaKey_method2(view, false), b(view, false)).f1244a) {
                return null;
            }
        }
        return a(viewGroup, gaVar2.f1273b, gaVar, gaVar2);
    }

    public boolean a(ga gaVar, ga gaVar2) {
        if (gaVar == null && gaVar2 == null) {
            return false;
        }
        if (gaVar != null && gaVar2 != null && gaVar2.f1272a.containsKey("android:visibility:visibility") != gaVar.f1272a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(gaVar, gaVar2);
        if (!b2.f1244a) {
            return false;
        }
        if (b2.f1246c == 0 || b2.d == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator b(android.view.ViewGroup r7, androidx.transition.ga r8, int r9, androidx.transition.ga r10, int r11) {
        /*
            r6 = this;
            int r9 = r6.L
            r0 = 2
            r9 = r9 & r0
            r1 = 0
            if (r9 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r8 == 0) goto L_0x000d
            android.view.View r9 = r8.f1273b
            goto L_0x000e
        L_0x000d:
            r9 = r1
        L_0x000e:
            if (r10 == 0) goto L_0x0013
            android.view.View r2 = r10.f1273b
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            r3 = 1
            if (r2 == 0) goto L_0x0037
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x001e
            goto L_0x0037
        L_0x001e:
            r4 = 4
            if (r11 != r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            if (r9 != r2) goto L_0x0027
        L_0x0024:
            r9 = r1
            goto L_0x0084
        L_0x0027:
            boolean r2 = r6.z
            if (r2 == 0) goto L_0x002c
            goto L_0x0044
        L_0x002c:
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            android.view.View r9 = androidx.transition.fa.a(r7, r9, r2)
            goto L_0x003a
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r9 = r2
        L_0x003a:
            r2 = r1
            goto L_0x0084
        L_0x003c:
            if (r9 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            if (r2 != 0) goto L_0x0045
        L_0x0044:
            goto L_0x003a
        L_0x0045:
            android.view.ViewParent r2 = r9.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            androidx.transition.ga r4 = r6.b((android.view.View) r2, (boolean) r3)
            androidx.transition.ga r5 = r6.a((android.view.View) r2, (boolean) r3)
            androidx.transition.Visibility$b r4 = r6.b(r4, r5)
            boolean r4 = r4.f1244a
            if (r4 != 0) goto L_0x0068
            android.view.View r9 = androidx.transition.fa.a(r7, r9, r2)
            goto L_0x003a
        L_0x0068:
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x0080
            int r2 = r2.getId()
            r4 = -1
            if (r2 == r4) goto L_0x0080
            android.view.View r2 = r7.findViewById(r2)
            if (r2 == 0) goto L_0x0080
            boolean r2 = r6.z
            if (r2 == 0) goto L_0x0080
            goto L_0x003a
        L_0x0080:
            r9 = r1
            goto L_0x003a
        L_0x0082:
            r9 = r1
            r2 = r9
        L_0x0084:
            r4 = 0
            if (r9 == 0) goto L_0x00cc
            if (r8 == 0) goto L_0x00cc
            java.util.Map<java.lang.String, java.lang.Object> r11 = r8.f1272a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r1)
            int[] r11 = (int[]) r11
            r1 = r11[r4]
            r11 = r11[r3]
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r9.getLeft()
            int r1 = r1 - r2
            r9.offsetLeftAndRight(r1)
            r0 = r0[r3]
            int r11 = r11 - r0
            int r0 = r9.getTop()
            int r11 = r11 - r0
            r9.offsetTopAndBottom(r11)
            androidx.transition.la r11 = androidx.transition.ma.a(r7)
            r11.a(r9)
            android.animation.Animator r7 = r6.b(r7, r9, r8, r10)
            if (r7 != 0) goto L_0x00c3
            r11.b(r9)
            goto L_0x00cb
        L_0x00c3:
            androidx.transition.Aa r8 = new androidx.transition.Aa
            r8.<init>(r6, r11, r9)
            r7.addListener(r8)
        L_0x00cb:
            return r7
        L_0x00cc:
            if (r2 == 0) goto L_0x00ee
            int r9 = r2.getVisibility()
            androidx.transition.va.a((android.view.View) r2, (int) r4)
            android.animation.Animator r7 = r6.b(r7, r2, r8, r10)
            if (r7 == 0) goto L_0x00ea
            androidx.transition.Visibility$a r8 = new androidx.transition.Visibility$a
            r8.<init>(r2, r11, r3)
            r7.addListener(r8)
            androidx.transition.C0118a.a(r7, r8)
            r6.a((androidx.transition.Transition.c) r8)
            goto L_0x00ed
        L_0x00ea:
            androidx.transition.va.a((android.view.View) r2, (int) r9)
        L_0x00ed:
            return r7
        L_0x00ee:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.b(android.view.ViewGroup, androidx.transition.ga, int, androidx.transition.ga, int):android.animation.Animator");
    }
}
