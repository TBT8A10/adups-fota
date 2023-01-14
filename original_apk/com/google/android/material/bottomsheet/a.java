package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.customview.a.g;
import java.lang.ref.WeakReference;

/* compiled from: BottomSheetBehavior */
class a extends g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f2082a;

    a(BottomSheetBehavior bottomSheetBehavior) {
        this.f2082a = bottomSheetBehavior;
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.f2082a.a(i2);
    }

    public boolean b(View view, int i) {
        WeakReference<V> weakReference;
        View view2;
        BottomSheetBehavior bottomSheetBehavior = this.f2082a;
        int i2 = bottomSheetBehavior.l;
        if (i2 == 1 || bottomSheetBehavior.x) {
            return false;
        }
        if ((i2 != 3 || bottomSheetBehavior.v != i || (view2 = (View) bottomSheetBehavior.s.get()) == null || !view2.canScrollVertically(-1)) && (weakReference = this.f2082a.r) != null && weakReference.get() == view) {
            return true;
        }
        return false;
    }

    public void c(int i) {
        if (i == 1) {
            this.f2082a.c(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r8, float r9, float r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = 4
            r3 = 6
            r4 = 3
            int r5 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x0028
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            boolean r9 = r9.f2075a
            if (r9 == 0) goto L_0x0018
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r9 = r9.g
        L_0x0015:
            r2 = 3
            goto L_0x00c7
        L_0x0018:
            int r9 = r8.getTop()
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f2082a
            int r10 = r10.h
            if (r9 <= r10) goto L_0x0026
            r9 = r10
        L_0x0023:
            r2 = 6
            goto L_0x00c7
        L_0x0026:
            r9 = 0
            goto L_0x0015
        L_0x0028:
            com.google.android.material.bottomsheet.BottomSheetBehavior r5 = r7.f2082a
            boolean r6 = r5.j
            if (r6 == 0) goto L_0x0051
            boolean r5 = r5.a(r8, r10)
            if (r5 == 0) goto L_0x0051
            int r5 = r8.getTop()
            com.google.android.material.bottomsheet.BottomSheetBehavior r6 = r7.f2082a
            int r6 = r6.i
            if (r5 > r6) goto L_0x004a
            float r5 = java.lang.Math.abs(r9)
            float r6 = java.lang.Math.abs(r10)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0051
        L_0x004a:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r9 = r9.q
            r2 = 5
            goto L_0x00c7
        L_0x0051:
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0067
            float r9 = java.lang.Math.abs(r9)
            float r10 = java.lang.Math.abs(r10)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r9 = r9.i
            goto L_0x00c7
        L_0x0067:
            int r9 = r8.getTop()
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f2082a
            boolean r10 = r10.f2075a
            if (r10 == 0) goto L_0x0094
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f2082a
            int r10 = r10.g
            int r10 = r9 - r10
            int r10 = java.lang.Math.abs(r10)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.f2082a
            int r0 = r0.i
            int r9 = r9 - r0
            int r9 = java.lang.Math.abs(r9)
            if (r10 >= r9) goto L_0x008e
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r0 = r9.g
            r9 = r0
            goto L_0x0015
        L_0x008e:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r0 = r9.i
        L_0x0092:
            r9 = r0
            goto L_0x00c7
        L_0x0094:
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f2082a
            int r1 = r10.h
            if (r9 >= r1) goto L_0x00aa
            int r10 = r10.i
            int r10 = r9 - r10
            int r10 = java.lang.Math.abs(r10)
            if (r9 >= r10) goto L_0x00a5
            goto L_0x0026
        L_0x00a5:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r0 = r9.h
            goto L_0x00bf
        L_0x00aa:
            int r10 = r9 - r1
            int r10 = java.lang.Math.abs(r10)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.f2082a
            int r0 = r0.i
            int r9 = r9 - r0
            int r9 = java.lang.Math.abs(r9)
            if (r10 >= r9) goto L_0x00c2
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r0 = r9.h
        L_0x00bf:
            r9 = r0
            goto L_0x0023
        L_0x00c2:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            int r0 = r9.i
            goto L_0x0092
        L_0x00c7:
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f2082a
            androidx.customview.a.g r10 = r10.m
            int r0 = r8.getLeft()
            boolean r9 = r10.d(r0, r9)
            if (r9 == 0) goto L_0x00e6
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f2082a
            r10 = 2
            r9.c((int) r10)
            com.google.android.material.bottomsheet.BottomSheetBehavior$b r9 = new com.google.android.material.bottomsheet.BottomSheetBehavior$b
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f2082a
            r9.<init>(r8, r2)
            androidx.core.h.t.a((android.view.View) r8, (java.lang.Runnable) r9)
            goto L_0x00eb
        L_0x00e6:
            com.google.android.material.bottomsheet.BottomSheetBehavior r8 = r7.f2082a
            r8.c((int) r2)
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.a.a(android.view.View, float, float):void");
    }

    public int b(View view, int i, int i2) {
        int b2 = this.f2082a.c();
        BottomSheetBehavior bottomSheetBehavior = this.f2082a;
        return androidx.core.c.a.a(i, b2, bottomSheetBehavior.j ? bottomSheetBehavior.q : bottomSheetBehavior.i);
    }

    public int b(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f2082a;
        if (bottomSheetBehavior.j) {
            return bottomSheetBehavior.q;
        }
        return bottomSheetBehavior.i;
    }

    public int a(View view, int i, int i2) {
        return view.getLeft();
    }
}
