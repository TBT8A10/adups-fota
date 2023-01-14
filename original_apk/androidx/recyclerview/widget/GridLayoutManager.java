package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridLayoutManager extends LinearLayoutManager {
    boolean H = false;
    int I = -1;
    int[] J;
    View[] K;
    final SparseIntArray L = new SparseIntArray();
    final SparseIntArray M = new SparseIntArray();
    b N = new a();
    final Rect O = new Rect();

    public static final class a extends b {
        public int a(int i) {
            return 1;
        }

        public int c(int i, int i2) {
            return i % i2;
        }
    }

    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f1008a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1009b = false;

        public abstract int a(int i);

        public void a() {
            this.f1008a.clear();
        }

        public int b(int i, int i2) {
            int a2 = a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int a3 = a(i5);
                i3 += a3;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = a3;
                }
            }
            return i3 + a2 > i2 ? i4 + 1 : i4;
        }

        public abstract int c(int i, int i2);

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (!this.f1009b) {
                return c(i, i2);
            }
            int i3 = this.f1008a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int c2 = c(i, i2);
            this.f1008a.put(i, c2);
            return c2;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        j(RecyclerView.i.a(context, attributeSet, i, i2).f1053b);
    }

    private void N() {
        int e = e();
        for (int i = 0; i < e; i++) {
            LayoutParams layoutParams = (LayoutParams) c(i).getLayoutParams();
            int a2 = layoutParams.a();
            this.L.put(a2, layoutParams.f());
            this.M.put(a2, layoutParams.e());
        }
    }

    private void O() {
        this.L.clear();
        this.M.clear();
    }

    private void P() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private void Q() {
        int i;
        int i2;
        if (H() == 1) {
            i2 = q() - o();
            i = n();
        } else {
            i2 = h() - m();
            i = p();
        }
        k(i2 - i);
    }

    private void k(int i) {
        this.J = a(this.J, this.I, i);
    }

    public boolean C() {
        return this.D == null && !this.H;
    }

    public int a(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 1) {
            return this.I;
        }
        if (sVar.a() < 1) {
            return 0;
        }
        return a(oVar, sVar, sVar.a() - 1) + 1;
    }

    public void b(boolean z) {
        if (!z) {
            super.b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public RecyclerView.LayoutParams c() {
        if (this.s == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public void d(RecyclerView recyclerView) {
        this.N.a();
    }

    public void e(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (sVar.d()) {
            N();
        }
        super.e(oVar, sVar);
        O();
    }

    /* access modifiers changed from: package-private */
    public int f(int i, int i2) {
        if (this.s != 1 || !I()) {
            int[] iArr = this.J;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.J;
        int i3 = this.I;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public void g(RecyclerView.s sVar) {
        super.g(sVar);
        this.H = false;
    }

    public void j(int i) {
        if (i != this.I) {
            this.H = true;
            if (i >= 1) {
                this.I = i;
                this.N.a();
                y();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        int e = -1;
        int f = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public int b(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 0) {
            return this.I;
        }
        if (sVar.a() < 1) {
            return 0;
        }
        return a(oVar, sVar, sVar.a() - 1) + 1;
    }

    private int c(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.d()) {
            return this.N.a(i);
        }
        int i2 = this.L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = oVar.a(i);
        if (a2 != -1) {
            return this.N.a(a2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public void a(RecyclerView.o oVar, RecyclerView.s sVar, View view, c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a_shaKey_method2(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a2 = a(oVar, sVar, layoutParams2.a());
        if (this.s == 0) {
            cVar.b((Object) c.C0014c.a(layoutParams2.e(), layoutParams2.f(), a2, 1, this.I > 1 && layoutParams2.f() == this.I, false));
        } else {
            cVar.b((Object) c.C0014c.a(a2, 1, layoutParams2.e(), layoutParams2.f(), this.I > 1 && layoutParams2.f() == this.I, false));
        }
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.N.a();
    }

    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        Q();
        P();
        return super.b(i, oVar, sVar);
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(oVar, sVar, aVar.f1015b);
        if (z) {
            while (b2 > 0) {
                int i2 = aVar.f1015b;
                if (i2 > 0) {
                    aVar.f1015b = i2 - 1;
                    b2 = b(oVar, sVar, aVar.f1015b);
                } else {
                    return;
                }
            }
            return;
        }
        int a2 = sVar.a() - 1;
        int i3 = aVar.f1015b;
        while (i3 < a2) {
            int i4 = i3 + 1;
            int b3 = b(oVar, sVar, i4);
            if (b3 <= b2) {
                break;
            }
            i3 = i4;
            b2 = b3;
        }
        aVar.f1015b = i3;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.N.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.N.a();
    }

    private int b(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.d()) {
            return this.N.a(i, this.I);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = oVar.a(i);
        if (a2 != -1) {
            return this.N.a(a2, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.N.a();
    }

    public RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private void b(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f1037b;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int f = f(layoutParams.e, layoutParams.f);
        if (this.s == 1) {
            i2 = RecyclerView.i.a(f, i, i5, layoutParams.width, false);
            i3 = RecyclerView.i.a(this.u.g(), i(), i4, layoutParams.height, true);
        } else {
            int a2 = RecyclerView.i.a(f, i, i4, layoutParams.height, false);
            int a3 = RecyclerView.i.a(this.u.g(), r(), i5, layoutParams.width, true);
            i3 = a2;
            i2 = a3;
        }
        a(view, i2, i3, z);
    }

    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.J == null) {
            super.a(rect, i, i2);
        }
        int n = n() + o();
        int p = p() + m();
        if (this.s == 1) {
            i4 = RecyclerView.i.a(i2, rect.height() + p, k());
            int[] iArr = this.J;
            i3 = RecyclerView.i.a(i, iArr[iArr.length - 1] + n, l());
        } else {
            i3 = RecyclerView.i.a(i, rect.width() + n, l());
            int[] iArr2 = this.J;
            i4 = RecyclerView.i.a(i2, iArr2[iArr2.length - 1] + p, k());
        }
        c(i3, i4);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i) {
        super.a(oVar, sVar, aVar, i);
        Q();
        if (sVar.a() > 0 && !sVar.d()) {
            b(oVar, sVar, aVar, i);
        }
        P();
    }

    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        Q();
        P();
        return super.a(i, oVar, sVar);
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, int i3) {
        E();
        int f = this.u.f();
        int b2 = this.u.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View c2 = c(i);
            int l = l(c2);
            if (l >= 0 && l < i3 && b(oVar, sVar, l) == 0) {
                if (((RecyclerView.LayoutParams) c2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = c2;
                    }
                } else if (this.u.d(c2) < b2 && this.u.a(c2) >= f) {
                    return c2;
                } else {
                    if (view == null) {
                        view = c2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.o oVar, RecyclerView.s sVar, int i) {
        if (!sVar.d()) {
            return this.N.b(i, this.I);
        }
        int a2 = oVar.a(i);
        if (a2 != -1) {
            return this.N.b(a2, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.s sVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.I;
        for (int i2 = 0; i2 < this.I && cVar.a(sVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.a(i3, Math.max(0, cVar.g));
            i -= this.N.a(i3);
            cVar.d += cVar.e;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0225 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0223  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.recyclerview.widget.RecyclerView.o r19, androidx.recyclerview.widget.RecyclerView.s r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            r18 = this;
            r6 = r18
            r1 = r19
            r2 = r20
            r7 = r21
            r8 = r22
            androidx.recyclerview.widget.w r0 = r6.u
            int r9 = r0.e()
            r10 = 1073741824(0x40000000, float:2.0)
            r11 = 1
            if (r9 == r10) goto L_0x0017
            r13 = 1
            goto L_0x0018
        L_0x0017:
            r13 = 0
        L_0x0018:
            int r0 = r18.e()
            if (r0 <= 0) goto L_0x0026
            int[] r0 = r6.J
            int r3 = r6.I
            r0 = r0[r3]
            r14 = r0
            goto L_0x0027
        L_0x0026:
            r14 = 0
        L_0x0027:
            if (r13 == 0) goto L_0x002c
            r18.Q()
        L_0x002c:
            int r0 = r7.e
            if (r0 != r11) goto L_0x0032
            r15 = 1
            goto L_0x0033
        L_0x0032:
            r15 = 0
        L_0x0033:
            int r0 = r6.I
            if (r15 != 0) goto L_0x0044
            int r0 = r7.d
            int r0 = r6.b((androidx.recyclerview.widget.RecyclerView.o) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (int) r0)
            int r3 = r7.d
            int r3 = r6.c(r1, r2, r3)
            int r0 = r0 + r3
        L_0x0044:
            r4 = 0
            r5 = 0
        L_0x0046:
            int r3 = r6.I
            if (r5 >= r3) goto L_0x009f
            boolean r3 = r7.a((androidx.recyclerview.widget.RecyclerView.s) r2)
            if (r3 == 0) goto L_0x009f
            if (r0 <= 0) goto L_0x009f
            int r3 = r7.d
            int r10 = r6.c(r1, r2, r3)
            int r12 = r6.I
            if (r10 > r12) goto L_0x0071
            int r0 = r0 - r10
            if (r0 >= 0) goto L_0x0060
            goto L_0x009f
        L_0x0060:
            android.view.View r3 = r7.a((androidx.recyclerview.widget.RecyclerView.o) r1)
            if (r3 != 0) goto L_0x0067
            goto L_0x009f
        L_0x0067:
            int r4 = r4 + r10
            android.view.View[] r10 = r6.K
            r10[r5] = r3
            int r5 = r5 + 1
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x0046
        L_0x0071:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Item at position "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = " requires "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r2 = " spans but GridLayoutManager has only "
            r1.append(r2)
            int r2 = r6.I
            r1.append(r2)
            java.lang.String r2 = " spans."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009f:
            if (r5 != 0) goto L_0x00a4
            r8.f1018b = r11
            return
        L_0x00a4:
            r10 = 0
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r5
            r12 = r5
            r5 = r15
            r0.a((androidx.recyclerview.widget.RecyclerView.o) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (int) r3, (int) r4, (boolean) r5)
            r0 = 0
            r1 = 0
        L_0x00b3:
            if (r0 >= r12) goto L_0x0101
            android.view.View[] r2 = r6.K
            r2 = r2[r0]
            java.util.List<androidx.recyclerview.widget.RecyclerView$v> r3 = r7.k
            if (r3 != 0) goto L_0x00c9
            if (r15 == 0) goto L_0x00c4
            r6.b((android.view.View) r2)
            r3 = 0
            goto L_0x00d3
        L_0x00c4:
            r3 = 0
            r6.b((android.view.View) r2, (int) r3)
            goto L_0x00d3
        L_0x00c9:
            r3 = 0
            if (r15 == 0) goto L_0x00d0
            r6.a((android.view.View) r2)
            goto L_0x00d3
        L_0x00d0:
            r6.a((android.view.View) r2, (int) r3)
        L_0x00d3:
            android.graphics.Rect r4 = r6.O
            r6.a((android.view.View) r2, (android.graphics.Rect) r4)
            r6.b((android.view.View) r2, (int) r9, (boolean) r3)
            androidx.recyclerview.widget.w r3 = r6.u
            int r3 = r3.b((android.view.View) r2)
            if (r3 <= r1) goto L_0x00e4
            r1 = r3
        L_0x00e4:
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r3 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r3
            r4 = 1065353216(0x3f800000, float:1.0)
            androidx.recyclerview.widget.w r5 = r6.u
            int r2 = r5.c(r2)
            float r2 = (float) r2
            float r2 = r2 * r4
            int r3 = r3.f
            float r3 = (float) r3
            float r2 = r2 / r3
            int r3 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x00fe
            r10 = r2
        L_0x00fe:
            int r0 = r0 + 1
            goto L_0x00b3
        L_0x0101:
            if (r13 == 0) goto L_0x011f
            r6.a((float) r10, (int) r14)
            r0 = 0
            r1 = 0
        L_0x0108:
            if (r0 >= r12) goto L_0x011f
            android.view.View[] r2 = r6.K
            r2 = r2[r0]
            r3 = 1073741824(0x40000000, float:2.0)
            r6.b((android.view.View) r2, (int) r3, (boolean) r11)
            androidx.recyclerview.widget.w r3 = r6.u
            int r2 = r3.b((android.view.View) r2)
            if (r2 <= r1) goto L_0x011c
            r1 = r2
        L_0x011c:
            int r0 = r0 + 1
            goto L_0x0108
        L_0x011f:
            r0 = 0
        L_0x0120:
            if (r0 >= r12) goto L_0x0182
            android.view.View[] r2 = r6.K
            r2 = r2[r0]
            androidx.recyclerview.widget.w r3 = r6.u
            int r3 = r3.b((android.view.View) r2)
            if (r3 == r1) goto L_0x017c
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r3 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r3
            android.graphics.Rect r4 = r3.f1037b
            int r5 = r4.top
            int r9 = r4.bottom
            int r5 = r5 + r9
            int r9 = r3.topMargin
            int r5 = r5 + r9
            int r9 = r3.bottomMargin
            int r5 = r5 + r9
            int r9 = r4.left
            int r4 = r4.right
            int r9 = r9 + r4
            int r4 = r3.leftMargin
            int r9 = r9 + r4
            int r4 = r3.rightMargin
            int r9 = r9 + r4
            int r4 = r3.e
            int r10 = r3.f
            int r4 = r6.f(r4, r10)
            int r10 = r6.s
            if (r10 != r11) goto L_0x0168
            int r3 = r3.width
            r10 = 1073741824(0x40000000, float:2.0)
            r13 = 0
            int r3 = androidx.recyclerview.widget.RecyclerView.i.a((int) r4, (int) r10, (int) r9, (int) r3, (boolean) r13)
            int r4 = r1 - r5
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r10)
            goto L_0x0178
        L_0x0168:
            r10 = 1073741824(0x40000000, float:2.0)
            r13 = 0
            int r9 = r1 - r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r3 = r3.height
            int r4 = androidx.recyclerview.widget.RecyclerView.i.a((int) r4, (int) r10, (int) r5, (int) r3, (boolean) r13)
            r3 = r9
        L_0x0178:
            r6.a((android.view.View) r2, (int) r3, (int) r4, (boolean) r11)
            goto L_0x017f
        L_0x017c:
            r10 = 1073741824(0x40000000, float:2.0)
            r13 = 0
        L_0x017f:
            int r0 = r0 + 1
            goto L_0x0120
        L_0x0182:
            r13 = 0
            r8.f1017a = r1
            int r0 = r6.s
            r2 = -1
            if (r0 != r11) goto L_0x019d
            int r0 = r7.f
            if (r0 != r2) goto L_0x0195
            int r0 = r7.f1021b
            int r1 = r0 - r1
            r3 = r0
            r2 = r1
            goto L_0x019a
        L_0x0195:
            int r0 = r7.f1021b
            int r1 = r1 + r0
            r2 = r0
            r3 = r1
        L_0x019a:
            r0 = 0
            r1 = 0
            goto L_0x01b2
        L_0x019d:
            int r0 = r7.f
            if (r0 != r2) goto L_0x01ad
            int r0 = r7.f1021b
            int r1 = r0 - r1
            r2 = 0
            r3 = 0
            r17 = r1
            r1 = r0
            r0 = r17
            goto L_0x01b2
        L_0x01ad:
            int r0 = r7.f1021b
            int r1 = r1 + r0
            r2 = 0
            r3 = 0
        L_0x01b2:
            if (r13 >= r12) goto L_0x0237
            android.view.View[] r4 = r6.K
            r7 = r4[r13]
            android.view.ViewGroup$LayoutParams r4 = r7.getLayoutParams()
            r9 = r4
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r4 = r6.s
            if (r4 != r11) goto L_0x01f5
            boolean r0 = r18.I()
            if (r0 == 0) goto L_0x01e2
            int r0 = r18.n()
            int[] r1 = r6.J
            int r4 = r6.I
            int r5 = r9.e
            int r4 = r4 - r5
            r1 = r1[r4]
            int r0 = r0 + r1
            androidx.recyclerview.widget.w r1 = r6.u
            int r1 = r1.c(r7)
            int r1 = r0 - r1
            r15 = r0
            r10 = r1
            goto L_0x0209
        L_0x01e2:
            int r0 = r18.n()
            int[] r1 = r6.J
            int r4 = r9.e
            r1 = r1[r4]
            int r0 = r0 + r1
            androidx.recyclerview.widget.w r1 = r6.u
            int r1 = r1.c(r7)
            int r1 = r1 + r0
            goto L_0x0207
        L_0x01f5:
            int r2 = r18.p()
            int[] r3 = r6.J
            int r4 = r9.e
            r3 = r3[r4]
            int r2 = r2 + r3
            androidx.recyclerview.widget.w r3 = r6.u
            int r3 = r3.c(r7)
            int r3 = r3 + r2
        L_0x0207:
            r10 = r0
            r15 = r1
        L_0x0209:
            r14 = r2
            r16 = r3
            r0 = r18
            r1 = r7
            r2 = r10
            r3 = r14
            r4 = r15
            r5 = r16
            r0.a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
            boolean r0 = r9.c()
            if (r0 != 0) goto L_0x0223
            boolean r0 = r9.b()
            if (r0 == 0) goto L_0x0225
        L_0x0223:
            r8.f1019c = r11
        L_0x0225:
            boolean r0 = r8.d
            boolean r1 = r7.hasFocusable()
            r0 = r0 | r1
            r8.d = r0
            int r13 = r13 + 1
            r0 = r10
            r2 = r14
            r1 = r15
            r3 = r16
            goto L_0x01b2
        L_0x0237:
            android.view.View[] r0 = r6.K
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    private void a(float f, int i) {
        k(Math.max(Math.round(f * ((float) this.I)), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = b(view, i, i2, layoutParams);
        } else {
            z2 = a(view, i, i2, layoutParams);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.K[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f = c(oVar, sVar, l(view));
            layoutParams.e = i5;
            i5 += layoutParams.f;
            i4 += i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f7, code lost:
        if (r13 == r11) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.o r26, androidx.recyclerview.widget.RecyclerView.s r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.c((android.view.View) r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.e
            int r5 = r5.f
            int r5 = r5 + r6
            android.view.View r7 = super.a((android.view.View) r24, (int) r25, (androidx.recyclerview.widget.RecyclerView.o) r26, (androidx.recyclerview.widget.RecyclerView.s) r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.h((int) r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.x
            if (r7 == r10) goto L_0x0032
            r7 = 1
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.e()
            int r7 = r7 - r9
            r11 = -1
            r12 = -1
            goto L_0x0045
        L_0x003e:
            int r7 = r23.e()
            r11 = r7
            r7 = 0
            r12 = 1
        L_0x0045:
            int r13 = r0.s
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.I()
            if (r13 == 0) goto L_0x0051
            r13 = 1
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.a((androidx.recyclerview.widget.RecyclerView.o) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (int) r7)
            r10 = r4
            r8 = -1
            r15 = 0
            r16 = 0
            r17 = -1
        L_0x005d:
            if (r7 == r11) goto L_0x0147
            int r9 = r0.a((androidx.recyclerview.widget.RecyclerView.o) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (int) r7)
            android.view.View r1 = r0.c((int) r7)
            if (r1 != r3) goto L_0x006b
            goto L_0x0147
        L_0x006b:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0085
            if (r9 == r14) goto L_0x0085
            if (r4 == 0) goto L_0x0077
            goto L_0x0147
        L_0x0077:
            r18 = r3
            r19 = r8
            r21 = r10
            r20 = r11
            r8 = r16
            r10 = r17
            goto L_0x0133
        L_0x0085:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.e
            r18 = r3
            int r3 = r9.f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009d
            if (r2 != r6) goto L_0x009d
            if (r3 != r5) goto L_0x009d
            return r1
        L_0x009d:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a5
            if (r4 == 0) goto L_0x00ad
        L_0x00a5:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00b9
            if (r10 != 0) goto L_0x00b9
        L_0x00ad:
            r19 = r8
            r21 = r10
        L_0x00b1:
            r20 = r11
            r8 = r16
            r10 = r17
        L_0x00b7:
            r11 = 1
            goto L_0x0103
        L_0x00b9:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r10
            int r10 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00da
            if (r10 <= r15) goto L_0x00d0
        L_0x00cd:
            r19 = r8
            goto L_0x00b1
        L_0x00d0:
            if (r10 != r15) goto L_0x00fa
            if (r2 <= r8) goto L_0x00d6
            r10 = 1
            goto L_0x00d7
        L_0x00d6:
            r10 = 0
        L_0x00d7:
            if (r13 != r10) goto L_0x00fa
            goto L_0x00cd
        L_0x00da:
            if (r4 != 0) goto L_0x00fa
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.a((android.view.View) r1, (boolean) r8, (boolean) r11)
            if (r22 == 0) goto L_0x00fe
            r8 = r16
            if (r10 <= r8) goto L_0x00ef
            r10 = r17
            goto L_0x0103
        L_0x00ef:
            if (r10 != r8) goto L_0x0100
            r10 = r17
            if (r2 <= r10) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r11 = 0
        L_0x00f7:
            if (r13 != r11) goto L_0x0102
            goto L_0x00b7
        L_0x00fa:
            r19 = r8
            r20 = r11
        L_0x00fe:
            r8 = r16
        L_0x0100:
            r10 = r17
        L_0x0102:
            r11 = 0
        L_0x0103:
            if (r11 == 0) goto L_0x0133
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0120
            int r4 = r9.e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r15 = r3
            r16 = r8
            r17 = r10
            r10 = r21
            r8 = r4
            r4 = r1
            goto L_0x013b
        L_0x0120:
            int r8 = r9.e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r16 = r3
            r17 = r8
            r8 = r19
            goto L_0x013b
        L_0x0133:
            r16 = r8
            r17 = r10
            r8 = r19
            r10 = r21
        L_0x013b:
            int r7 = r7 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005d
        L_0x0147:
            r21 = r10
            if (r4 == 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r4 = r21
        L_0x014e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s):android.view.View");
    }
}
