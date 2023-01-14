package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.r.a {
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    LazySpanLookup E = new LazySpanLookup();
    private int F = 2;
    private boolean G;
    private boolean H;
    private SavedState I;
    private int J;
    private final Rect K = new Rect();
    private final a L = new a();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new J(this);
    private int s = -1;
    b[] t;
    w u;
    w v;
    private int w;
    private int x;
    private final r y;
    boolean z = false;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        b e;
        boolean f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            b bVar = this.e;
            if (bVar == null) {
                return -1;
            }
            return bVar.e;
        }

        public boolean f() {
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

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new L();

        /* renamed from: a  reason: collision with root package name */
        int f1078a;

        /* renamed from: b  reason: collision with root package name */
        int f1079b;

        /* renamed from: c  reason: collision with root package name */
        int f1080c;
        int[] d;
        int e;
        int[] f;
        List<LazySpanLookup.FullSpanItem> g;
        boolean h;
        boolean i;
        boolean j;

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.d = null;
            this.f1080c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1078a);
            parcel.writeInt(this.f1079b);
            parcel.writeInt(this.f1080c);
            if (this.f1080c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        SavedState(Parcel parcel) {
            this.f1078a = parcel.readInt();
            this.f1079b = parcel.readInt();
            this.f1080c = parcel.readInt();
            int i2 = this.f1080c;
            if (i2 > 0) {
                this.d = new int[i2];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            int i3 = this.e;
            if (i3 > 0) {
                this.f = new int[i3];
                parcel.readIntArray(this.f);
            }
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
            this.g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f1080c = savedState.f1080c;
            this.f1078a = savedState.f1078a;
            this.f1079b = savedState.f1079b;
            this.d = savedState.d;
            this.e = savedState.e;
            this.f = savedState.f;
            this.h = savedState.h;
            this.i = savedState.i;
            this.j = savedState.j;
            this.g = savedState.g;
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f1084a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f1085b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f1086c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        b(int i) {
            this.e = i;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            int i2 = this.f1086c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1084a.size() == 0) {
                return i;
            }
            a();
            return this.f1086c;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int i2 = this.f1085b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1084a.size() == 0) {
                return i;
            }
            b();
            return this.f1085b;
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            LayoutParams b2 = b(view);
            b2.e = this;
            this.f1084a.add(0, view);
            this.f1085b = Integer.MIN_VALUE;
            if (this.f1084a.size() == 1) {
                this.f1086c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            this.f1085b = i;
            this.f1086c = i;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(0, this.f1084a.size(), true);
            }
            return a(this.f1084a.size() - 1, -1, true);
        }

        public int f() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            int i = this.f1086c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.f1086c;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            int i = this.f1085b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.f1085b;
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f1085b = Integer.MIN_VALUE;
            this.f1086c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int size = this.f1084a.size();
            View remove = this.f1084a.remove(size - 1);
            LayoutParams b2 = b(remove);
            b2.e = null;
            if (b2.c() || b2.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            if (size == 1) {
                this.f1085b = Integer.MIN_VALUE;
            }
            this.f1086c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            View remove = this.f1084a.remove(0);
            LayoutParams b2 = b(remove);
            b2.e = null;
            if (this.f1084a.size() == 0) {
                this.f1086c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            this.f1085b = Integer.MIN_VALUE;
        }

        public int d() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(this.f1084a.size() - 1, -1, true);
            }
            return a(0, this.f1084a.size(), true);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            LazySpanLookup.FullSpanItem c2;
            ArrayList<View> arrayList = this.f1084a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams b2 = b(view);
            this.f1086c = StaggeredGridLayoutManager.this.u.a(view);
            if (b2.f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f1076b == 1) {
                this.f1086c += c2.a(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            LazySpanLookup.FullSpanItem c2;
            View view = this.f1084a.get(0);
            LayoutParams b2 = b(view);
            this.f1085b = StaggeredGridLayoutManager.this.u.d(view);
            if (b2.f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f1076b == -1) {
                this.f1085b -= c2.a(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f1084a.clear();
            i();
            this.d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(int i) {
            int i2 = this.f1085b;
            if (i2 != Integer.MIN_VALUE) {
                this.f1085b = i2 + i;
            }
            int i3 = this.f1086c;
            if (i3 != Integer.MIN_VALUE) {
                this.f1086c = i3 + i;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            LayoutParams b2 = b(view);
            b2.e = this;
            this.f1084a.add(view);
            this.f1086c = Integer.MIN_VALUE;
            if (this.f1084a.size() == 1) {
                this.f1085b = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        /* access modifiers changed from: package-private */
        public LayoutParams b(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = a(Integer.MIN_VALUE);
            } else {
                i2 = b(Integer.MIN_VALUE);
            }
            c();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.u.b()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.u.f()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.f1086c = i2;
                    this.f1085b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int f2 = StaggeredGridLayoutManager.this.u.f();
            int b2 = StaggeredGridLayoutManager.this.u.b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f1084a.get(i);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                int a2 = StaggeredGridLayoutManager.this.u.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d2 < b2 : d2 <= b2;
                if (!z3 ? a2 > f2 : a2 >= f2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                        if (d2 < f2 || a2 > b2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                    } else if (d2 >= f2 && a2 <= b2) {
                        return StaggeredGridLayoutManager.this.l(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f1084a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1084a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.l(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.l(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1084a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f1084a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.l(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.l(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = RecyclerView.i.a(context, attributeSet, i, i2);
        h(a2.f1052a);
        i(a2.f1053b);
        c(a2.f1054c);
        this.y = new r();
        M();
    }

    private void M() {
        this.u = w.a(this, this.w);
        this.v = w.a(this, 1 - this.w);
    }

    private void N() {
        if (this.v.d() != 1073741824) {
            int e = e();
            float f = 0.0f;
            for (int i = 0; i < e; i++) {
                View c2 = c(i);
                float b2 = (float) this.v.b(c2);
                if (b2 >= f) {
                    if (((LayoutParams) c2.getLayoutParams()).f()) {
                        b2 = (b2 * 1.0f) / ((float) this.s);
                    }
                    f = Math.max(f, b2);
                }
            }
            int i2 = this.x;
            int round = Math.round(f * ((float) this.s));
            if (this.v.d() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.g());
            }
            j(round);
            if (this.x != i2) {
                for (int i3 = 0; i3 < e; i3++) {
                    View c3 = c(i3);
                    LayoutParams layoutParams = (LayoutParams) c3.getLayoutParams();
                    if (!layoutParams.f) {
                        if (!L() || this.w != 1) {
                            int i4 = layoutParams.e.e;
                            int i5 = this.x * i4;
                            int i6 = i4 * i2;
                            if (this.w == 1) {
                                c3.offsetLeftAndRight(i5 - i6);
                            } else {
                                c3.offsetTopAndBottom(i5 - i6);
                            }
                        } else {
                            int i7 = this.s;
                            int i8 = layoutParams.e.e;
                            c3.offsetLeftAndRight(((-((i7 - 1) - i8)) * this.x) - ((-((i7 - 1) - i8)) * i2));
                        }
                    }
                }
            }
        }
    }

    private void O() {
        if (this.w == 1 || !L()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    private boolean a(b bVar) {
        if (this.A) {
            if (bVar.g() < this.u.b()) {
                ArrayList<View> arrayList = bVar.f1084a;
                return !bVar.b(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (bVar.h() > this.u.f()) {
            return !bVar.b(bVar.f1084a.get(0)).f;
        }
        return false;
    }

    private int k(int i) {
        if (e() != 0) {
            if ((i < H()) != this.A) {
                return -1;
            }
            return 1;
        } else if (this.A) {
            return 1;
        } else {
            return -1;
        }
    }

    private int l(int i) {
        if (i == 1) {
            return (this.w != 1 && L()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.w != 1 && L()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.w == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.w == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.w == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private LazySpanLookup.FullSpanItem m(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1077c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.f1077c[i2] = i - this.t[i2].a(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f1077c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            fullSpanItem.f1077c[i2] = this.t[i2].b(i) - i;
        }
        return fullSpanItem;
    }

    private int o(int i) {
        int e = e();
        for (int i2 = 0; i2 < e; i2++) {
            int l = l(c(i2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private void p(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void q(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].c(view);
        }
    }

    private int r(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int s(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int t(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void v(int i) {
        r rVar = this.y;
        rVar.e = i;
        int i2 = 1;
        if (this.A != (i == -1)) {
            i2 = -1;
        }
        rVar.d = i2;
    }

    public boolean C() {
        return this.I == null;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        int i;
        int i2;
        if (e() == 0 || this.F == 0 || !t()) {
            return false;
        }
        if (this.A) {
            i2 = I();
            i = H();
        } else {
            i2 = H();
            i = I();
        }
        if (i2 == 0 && J() != null) {
            this.E.a();
            z();
            y();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            int i3 = this.A ? -1 : 1;
            int i4 = i + 1;
            LazySpanLookup.FullSpanItem a2 = this.E.a(i2, i4, i3, true);
            if (a2 == null) {
                this.M = false;
                this.E.b(i4);
                return false;
            }
            LazySpanLookup.FullSpanItem a3 = this.E.a(i2, a2.f1075a, i3 * -1, true);
            if (a3 == null) {
                this.E.b(a2.f1075a);
            } else {
                this.E.b(a3.f1075a + 1);
            }
            z();
            y();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public int G() {
        View view;
        if (this.A) {
            view = a(true);
        } else {
            view = b(true);
        }
        if (view == null) {
            return -1;
        }
        return l(view);
    }

    /* access modifiers changed from: package-private */
    public int H() {
        if (e() == 0) {
            return 0;
        }
        return l(c(0));
    }

    /* access modifiers changed from: package-private */
    public int I() {
        int e = e();
        if (e == 0) {
            return 0;
        }
        return l(c(e - 1));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View J() {
        /*
            r12 = this;
            int r0 = r12.e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.L()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.A
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.c((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.e
            boolean r9 = r12.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.c((int) r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.w r10 = r12.u
            int r10 = r10.a((android.view.View) r7)
            androidx.recyclerview.widget.w r11 = r12.u
            int r11 = r11.a((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.w r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.w r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.J():android.view.View");
    }

    public void K() {
        this.E.a();
        y();
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return j() == 1;
    }

    public void b(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.b(recyclerView, oVar);
        a(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].c();
        }
        recyclerView.requestLayout();
    }

    public void c(boolean z2) {
        a((String) null);
        SavedState savedState = this.I;
        if (!(savedState == null || savedState.h == z2)) {
            savedState.h = z2;
        }
        this.z = z2;
        y();
    }

    public int d(RecyclerView.s sVar) {
        return h(sVar);
    }

    public void e(RecyclerView.o oVar, RecyclerView.s sVar) {
        c(oVar, sVar, true);
    }

    public void f(int i) {
        if (i == 0) {
            F();
        }
    }

    public void g(RecyclerView.s sVar) {
        super.g(sVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    public void h(int i) {
        if (i == 0 || i == 1) {
            a((String) null);
            if (i != this.w) {
                this.w = i;
                w wVar = this.u;
                this.u = this.v;
                this.v = wVar;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void i(int i) {
        a((String) null);
        if (i != this.s) {
            K();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new b[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new b(i2);
            }
            y();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.d());
    }

    public boolean u() {
        return this.F != 0;
    }

    public Parcelable x() {
        int i;
        int i2;
        int i3;
        int[] iArr;
        SavedState savedState = this.I;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.h = this.z;
        savedState2.i = this.G;
        savedState2.j = this.H;
        LazySpanLookup lazySpanLookup = this.E;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f1073a) == null) {
            savedState2.e = 0;
        } else {
            savedState2.f = iArr;
            savedState2.e = savedState2.f.length;
            savedState2.g = lazySpanLookup.f1074b;
        }
        if (e() > 0) {
            if (this.G) {
                i = I();
            } else {
                i = H();
            }
            savedState2.f1078a = i;
            savedState2.f1079b = G();
            int i4 = this.s;
            savedState2.f1080c = i4;
            savedState2.d = new int[i4];
            for (int i5 = 0; i5 < this.s; i5++) {
                if (this.G) {
                    i2 = this.t[i5].a(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.u.b();
                    } else {
                        savedState2.d[i5] = i2;
                    }
                } else {
                    i2 = this.t[i5].b(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.u.f();
                    } else {
                        savedState2.d[i5] = i2;
                    }
                }
                i2 -= i3;
                savedState2.d[i5] = i2;
            }
        } else {
            savedState2.f1078a = -1;
            savedState2.f1079b = -1;
            savedState2.f1080c = 0;
        }
        return savedState2;
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f1073a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f1074b;

        LazySpanLookup() {
        }

        private void c(int i, int i2) {
            List<FullSpanItem> list = this.f1074b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f1074b.get(size);
                    int i3 = fullSpanItem.f1075a;
                    if (i3 >= i) {
                        fullSpanItem.f1075a = i3 + i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.f1074b == null) {
                return -1;
            }
            FullSpanItem c2 = c(i);
            if (c2 != null) {
                this.f1074b.remove(c2);
            }
            int size = this.f1074b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f1074b.get(i2).f1075a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f1074b.remove(i2);
            return this.f1074b.get(i2).f1075a;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, b bVar) {
            a(i);
            this.f1073a[i] = bVar.e;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            List<FullSpanItem> list = this.f1074b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1074b.get(size).f1075a >= i) {
                        this.f1074b.remove(size);
                    }
                }
            }
            return e(i);
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            int[] iArr = this.f1073a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        public int e(int i) {
            int[] iArr = this.f1073a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                int[] iArr2 = this.f1073a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f1073a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f1073a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int f(int i) {
            int length = this.f1073a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void d(int i, int i2) {
            List<FullSpanItem> list = this.f1074b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f1074b.get(size);
                    int i4 = fullSpanItem.f1075a;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            this.f1074b.remove(size);
                        } else {
                            fullSpanItem.f1075a = i4 - i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            int[] iArr = this.f1073a;
            if (iArr == null) {
                this.f1073a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f1073a, -1);
            } else if (i >= iArr.length) {
                this.f1073a = new int[f(i)];
                System.arraycopy(iArr, 0, this.f1073a, 0, iArr.length);
                int[] iArr2 = this.f1073a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        public FullSpanItem c(int i) {
            List<FullSpanItem> list = this.f1074b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f1074b.get(size);
                if (fullSpanItem.f1075a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new K();

            /* renamed from: a  reason: collision with root package name */
            int f1075a;

            /* renamed from: b  reason: collision with root package name */
            int f1076b;

            /* renamed from: c  reason: collision with root package name */
            int[] f1077c;
            boolean d;

            FullSpanItem(Parcel parcel) {
                this.f1075a = parcel.readInt();
                this.f1076b = parcel.readInt();
                this.d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f1077c = new int[readInt];
                    parcel.readIntArray(this.f1077c);
                }
            }

            /* access modifiers changed from: package-private */
            public int a(int i) {
                int[] iArr = this.f1077c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1075a + ", mGapDir=" + this.f1076b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.f1077c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1075a);
                parcel.writeInt(this.f1076b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.f1077c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f1077c);
            }

            FullSpanItem() {
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            int[] iArr = this.f1073a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                a(i3);
                int[] iArr2 = this.f1073a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f1073a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                d(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f1073a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1074b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            int[] iArr = this.f1073a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                a(i3);
                int[] iArr2 = this.f1073a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f1073a, i, i3, -1);
                c(i, i2);
            }
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f1074b == null) {
                this.f1074b = new ArrayList();
            }
            int size = this.f1074b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f1074b.get(i);
                if (fullSpanItem2.f1075a == fullSpanItem.f1075a) {
                    this.f1074b.remove(i);
                }
                if (fullSpanItem2.f1075a >= fullSpanItem.f1075a) {
                    this.f1074b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f1074b.add(fullSpanItem);
        }

        public FullSpanItem a(int i, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f1074b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f1074b.get(i4);
                int i5 = fullSpanItem.f1075a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || fullSpanItem.f1076b == i3 || (z && fullSpanItem.d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

    private int d(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private boolean u(int i) {
        if (this.w == 0) {
            if ((i == -1) != this.A) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.A) == L()) {
            return true;
        }
        return false;
    }

    public int e(RecyclerView.s sVar) {
        return i(sVar);
    }

    public int f(RecyclerView.s sVar) {
        return j(sVar);
    }

    private int p(int i) {
        for (int e = e() - 1; e >= 0; e--) {
            int l = l(c(e));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private int q(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    public void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f1081a;

        /* renamed from: b  reason: collision with root package name */
        int f1082b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1083c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(b[] bVarArr) {
            int length = bVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = bVarArr[i].b(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f1081a = -1;
            this.f1082b = Integer.MIN_VALUE;
            this.f1083c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i;
            if (this.f1083c) {
                i = StaggeredGridLayoutManager.this.u.b();
            } else {
                i = StaggeredGridLayoutManager.this.u.f();
            }
            this.f1082b = i;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (this.f1083c) {
                this.f1082b = StaggeredGridLayoutManager.this.u.b() - i;
            } else {
                this.f1082b = StaggeredGridLayoutManager.this.u.f() + i;
            }
        }
    }

    private int j(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        return H.b(sVar, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    public void d(int i) {
        super.d(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (F() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(androidx.recyclerview.widget.RecyclerView.o r9, androidx.recyclerview.widget.RecyclerView.s r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.a()
            if (r1 != 0) goto L_0x0018
            r8.b((androidx.recyclerview.widget.RecyclerView.o) r9)
            r0.b()
            return
        L_0x0018:
            boolean r1 = r0.e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.b()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x0037
            r8.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            goto L_0x003e
        L_0x0037:
            r8.O()
            boolean r5 = r8.A
            r0.f1083c = r5
        L_0x003e:
            r8.b((androidx.recyclerview.widget.RecyclerView.s) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            r0.e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f1083c
            boolean r6 = r8.G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.L()
            boolean r6 = r8.H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.E
            r5.a()
            r0.d = r4
        L_0x0060:
            int r5 = r8.e()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f1080c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.t
            r5 = r5[r1]
            r5.c()
            int r5 = r0.f1082b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r6 = r8.t
            r6 = r6[r1]
            r6.d(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.L
            int[] r1 = r1.f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.t
            r5 = r5[r1]
            r5.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.L
            int[] r6 = r6.f
            r6 = r6[r1]
            r5.d(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.t
            r5 = r5[r1]
            boolean r6 = r8.A
            int r7 = r0.f1082b
            r5.a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.t
            r1.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.b[]) r5)
        L_0x00c9:
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9)
            androidx.recyclerview.widget.r r1 = r8.y
            r1.f1142a = r3
            r8.M = r3
            androidx.recyclerview.widget.w r1 = r8.v
            int r1 = r1.g()
            r8.j((int) r1)
            int r1 = r0.f1081a
            r8.b((int) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            boolean r1 = r0.f1083c
            if (r1 == 0) goto L_0x00fc
            r8.v(r2)
            androidx.recyclerview.widget.r r1 = r8.y
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.r) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            r8.v(r4)
            androidx.recyclerview.widget.r r1 = r8.y
            int r2 = r0.f1081a
            int r5 = r1.d
            int r2 = r2 + r5
            r1.f1144c = r2
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.r) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            goto L_0x0113
        L_0x00fc:
            r8.v(r4)
            androidx.recyclerview.widget.r r1 = r8.y
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.r) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            r8.v(r2)
            androidx.recyclerview.widget.r r1 = r8.y
            int r2 = r0.f1081a
            int r5 = r1.d
            int r2 = r2 + r5
            r1.f1144c = r2
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.r) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
        L_0x0113:
            r8.N()
            int r1 = r8.e()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.A
            if (r1 == 0) goto L_0x0127
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r4)
            r8.b((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r3)
            goto L_0x012d
        L_0x0127:
            r8.b((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r4)
            r8.a((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.d()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.F
            if (r11 == 0) goto L_0x014b
            int r11 = r8.e()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.M
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.J()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.P
            r8.a((java.lang.Runnable) r11)
            boolean r11 = r8.F()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = 0
        L_0x015b:
            boolean r11 = r10.d()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.L
            r11.b()
        L_0x0166:
            boolean r11 = r0.f1083c
            r8.G = r11
            boolean r11 = r8.L()
            r8.H = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.L
            r11.b()
            r8.c((androidx.recyclerview.widget.RecyclerView.o) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, boolean):void");
    }

    private void e(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f1084a.isEmpty()) {
                a(this.t[i3], i, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.s sVar, a aVar) {
        if (!a(sVar, aVar) && !c(sVar, aVar)) {
            aVar.a();
            aVar.f1081a = 0;
        }
    }

    public void d(RecyclerView recyclerView) {
        this.E.a();
        y();
    }

    private int h(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        return H.a(sVar, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private int i(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        return H.a(sVar, this.u, b(!this.N), a(!this.N), this, this.N, this.A);
    }

    public void a(String str) {
        if (this.I == null) {
            super.a(str);
        }
    }

    public int b(RecyclerView.s sVar) {
        return i(sVar);
    }

    public int b(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.w == 0) {
            return this.s;
        }
        return super.b(oVar, sVar);
    }

    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int n = n() + o();
        int p = p() + m();
        if (this.w == 1) {
            i4 = RecyclerView.i.a(i2, rect.height() + p, k());
            i3 = RecyclerView.i.a(i, (this.x * this.s) + n, l());
        } else {
            i3 = RecyclerView.i.a(i, rect.width() + n, l());
            i4 = RecyclerView.i.a(i2, (this.x * this.s) + p, k());
        }
        c(i3, i4);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2) {
        int f = this.u.f();
        int b2 = this.u.b();
        int e = e();
        View view = null;
        for (int i = 0; i < e; i++) {
            View c2 = c(i);
            int d = this.u.d(c2);
            if (this.u.a(c2) > f && d < b2) {
                if (d >= f || !z2) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, boolean z2) {
        int f;
        int t2 = t(Integer.MAX_VALUE);
        if (t2 != Integer.MAX_VALUE && (f = t2 - this.u.f()) > 0) {
            int c2 = f - c(f, oVar, sVar);
            if (z2 && c2 > 0) {
                this.u.a(-c2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.s r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.r r0 = r4.y
            r1 = 0
            r0.f1143b = r1
            r0.f1144c = r5
            boolean r0 = r4.w()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.w r5 = r4.u
            int r5 = r5.g()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.w r5 = r4.u
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.f()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.r r0 = r4.y
            androidx.recyclerview.widget.w r3 = r4.u
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.r r6 = r4.y
            androidx.recyclerview.widget.w r0 = r4.u
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.r r0 = r4.y
            androidx.recyclerview.widget.w r3 = r4.u
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.r r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L_0x005d:
            androidx.recyclerview.widget.r r5 = r4.y
            r5.h = r1
            r5.f1142a = r2
            androidx.recyclerview.widget.w r6 = r4.u
            int r6 = r6.d()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.w r6 = r4.u
            int r6 = r6.a()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$s):void");
    }

    private void a(a aVar) {
        int i;
        SavedState savedState = this.I;
        int i2 = savedState.f1080c;
        if (i2 > 0) {
            if (i2 == this.s) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].c();
                    SavedState savedState2 = this.I;
                    int i4 = savedState2.d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (savedState2.i) {
                            i = this.u.b();
                        } else {
                            i = this.u.f();
                        }
                        i4 += i;
                    }
                    this.t[i3].d(i4);
                }
            } else {
                savedState.a();
                SavedState savedState3 = this.I;
                savedState3.f1078a = savedState3.f1079b;
            }
        }
        SavedState savedState4 = this.I;
        this.H = savedState4.j;
        c(savedState4.h);
        O();
        SavedState savedState5 = this.I;
        int i5 = savedState5.f1078a;
        if (i5 != -1) {
            this.C = i5;
            aVar.f1083c = savedState5.i;
        } else {
            aVar.f1083c = this.A;
        }
        SavedState savedState6 = this.I;
        if (savedState6.e > 1) {
            LazySpanLookup lazySpanLookup = this.E;
            lazySpanLookup.f1073a = savedState6.f;
            lazySpanLookup.f1074b = savedState6.g;
        }
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    private void b(RecyclerView.o oVar, int i) {
        while (e() > 0) {
            View c2 = c(0);
            if (this.u.a(c2) <= i && this.u.e(c2) <= i) {
                LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
                if (layoutParams.f) {
                    int i2 = 0;
                    while (i2 < this.s) {
                        if (this.t[i2].f1084a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].k();
                    }
                } else if (layoutParams.e.f1084a.size() != 1) {
                    layoutParams.e.k();
                } else {
                    return;
                }
                a(c2, oVar);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.s sVar, a aVar) {
        int i;
        int i2;
        int i3;
        boolean z2 = false;
        if (!sVar.d() && (i = this.C) != -1) {
            if (i < 0 || i >= sVar.a()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.I;
                if (savedState == null || savedState.f1078a == -1 || savedState.f1080c < 1) {
                    View b2 = b(this.C);
                    if (b2 != null) {
                        if (this.A) {
                            i2 = I();
                        } else {
                            i2 = H();
                        }
                        aVar.f1081a = i2;
                        if (this.D != Integer.MIN_VALUE) {
                            if (aVar.f1083c) {
                                aVar.f1082b = (this.u.b() - this.D) - this.u.a(b2);
                            } else {
                                aVar.f1082b = (this.u.f() + this.D) - this.u.d(b2);
                            }
                            return true;
                        } else if (this.u.b(b2) > this.u.g()) {
                            if (aVar.f1083c) {
                                i3 = this.u.b();
                            } else {
                                i3 = this.u.f();
                            }
                            aVar.f1082b = i3;
                            return true;
                        } else {
                            int d = this.u.d(b2) - this.u.f();
                            if (d < 0) {
                                aVar.f1082b = -d;
                                return true;
                            }
                            int b3 = this.u.b() - this.u.a(b2);
                            if (b3 < 0) {
                                aVar.f1082b = b3;
                                return true;
                            }
                            aVar.f1082b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f1081a = this.C;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            if (k(aVar.f1081a) == 1) {
                                z2 = true;
                            }
                            aVar.f1083c = z2;
                            aVar.a();
                        } else {
                            aVar.a(i4);
                        }
                        aVar.d = true;
                    }
                } else {
                    aVar.f1082b = Integer.MIN_VALUE;
                    aVar.f1081a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return this.w == 1;
    }

    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    private boolean c(RecyclerView.s sVar, a aVar) {
        int i;
        if (this.G) {
            i = p(sVar.a());
        } else {
            i = o(sVar.a());
        }
        aVar.f1081a = i;
        aVar.f1082b = Integer.MIN_VALUE;
        return true;
    }

    public int c(RecyclerView.s sVar) {
        return j(sVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.I()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.H()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L_0x001f
        L_0x001b:
            int r2 = r7 + r8
        L_0x001d:
            r3 = r2
            r2 = r7
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.E
            r4.e(r2)
            r4 = 1
            if (r9 == r4) goto L_0x003e
            r5 = 2
            if (r9 == r5) goto L_0x0038
            if (r9 == r1) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.E
            r7.a((int) r8, (int) r4)
            goto L_0x0043
        L_0x0038:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.b(r7, r8)
            goto L_0x0043
        L_0x003e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.E
            r9.a((int) r7, (int) r8)
        L_0x0043:
            if (r3 > r0) goto L_0x0046
            return
        L_0x0046:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004f
            int r7 = r6.H()
            goto L_0x0053
        L_0x004f:
            int r7 = r6.I()
        L_0x0053:
            if (r2 > r7) goto L_0x0058
            r6.y()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    public int a(RecyclerView.s sVar) {
        return h(sVar);
    }

    private void a(View view, LayoutParams layoutParams, boolean z2) {
        if (layoutParams.f) {
            if (this.w == 1) {
                a(view, this.J, RecyclerView.i.a(h(), i(), p() + m(), layoutParams.height, true), z2);
            } else {
                a(view, RecyclerView.i.a(q(), r(), n() + o(), layoutParams.width, true), this.J, z2);
            }
        } else if (this.w == 1) {
            a(view, RecyclerView.i.a(this.x, r(), 0, layoutParams.width, false), RecyclerView.i.a(h(), i(), p() + m(), layoutParams.height, true), z2);
        } else {
            a(view, RecyclerView.i.a(q(), r(), n() + o(), layoutParams.width, true), RecyclerView.i.a(this.x, i(), 0, layoutParams.height, false), z2);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        a(i, sVar);
        int a2 = a(oVar, this.y, sVar);
        if (this.y.f1143b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.u.a(-i);
        this.G = this.A;
        r rVar = this.y;
        rVar.f1143b = 0;
        a(oVar, rVar);
        return i;
    }

    public RecyclerView.LayoutParams c() {
        if (this.w == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    private void a(View view, int i, int i2, boolean z2) {
        boolean z3;
        a(view, this.K);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin;
        Rect rect = this.K;
        int d = d(i, i3 + rect.left, layoutParams.rightMargin + rect.right);
        int i4 = layoutParams.topMargin;
        Rect rect2 = this.K;
        int d2 = d(i2, i4 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z2) {
            z3 = b(view, d, d2, (RecyclerView.LayoutParams) layoutParams);
        } else {
            z3 = a(view, d, d2, (RecyclerView.LayoutParams) layoutParams);
        }
        if (z3) {
            view.measure(d, d2);
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.I = (SavedState) parcelable;
            y();
        }
    }

    public void a(RecyclerView.o oVar, RecyclerView.s sVar, View view, c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.w == 0) {
            cVar.b((Object) c.C0014c.a(layoutParams2.e(), layoutParams2.f ? this.s : 1, -1, -1, layoutParams2.f, false));
        } else {
            cVar.b((Object) c.C0014c.a(-1, -1, layoutParams2.e(), layoutParams2.f ? this.s : 1, layoutParams2.f, false));
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 != null && a2 != null) {
                int l = l(b2);
                int l2 = l(a2);
                if (l < l2) {
                    accessibilityEvent.setFromIndex(l);
                    accessibilityEvent.setToIndex(l2);
                    return;
                }
                accessibilityEvent.setFromIndex(l2);
                accessibilityEvent.setToIndex(l);
            }
        }
    }

    public int a(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.w == 1) {
            return this.s;
        }
        return super.a(oVar, sVar);
    }

    /* access modifiers changed from: package-private */
    public View a(boolean z2) {
        int f = this.u.f();
        int b2 = this.u.b();
        View view = null;
        for (int e = e() - 1; e >= 0; e--) {
            View c2 = c(e);
            int d = this.u.d(c2);
            int a2 = this.u.a(c2);
            if (a2 > f && d < b2) {
                if (a2 <= b2 || !z2) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    private void a(RecyclerView.o oVar, RecyclerView.s sVar, boolean z2) {
        int b2;
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE && (b2 = this.u.b() - q) > 0) {
            int i = b2 - (-c(-b2, oVar, sVar));
            if (z2 && i > 0) {
                this.u.a(i);
            }
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    private int a(RecyclerView.o oVar, r rVar, RecyclerView.s sVar) {
        int i;
        int i2;
        int i3;
        b bVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12;
        RecyclerView.o oVar2 = oVar;
        r rVar2 = rVar;
        ? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i = rVar2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (rVar2.e == 1) {
                i12 = rVar2.g + rVar2.f1143b;
            } else {
                i12 = rVar2.f - rVar2.f1143b;
            }
            i = i12;
        }
        e(rVar2.e, i);
        if (this.A) {
            i2 = this.u.b();
        } else {
            i2 = this.u.f();
        }
        int i13 = i2;
        boolean z3 = false;
        while (rVar.a(sVar) && (this.y.i || !this.B.isEmpty())) {
            View a2 = rVar2.a(oVar2);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int a3 = layoutParams.a();
            int d = this.E.d(a3);
            boolean z4 = d == -1;
            if (z4) {
                bVar = layoutParams.f ? this.t[r9] : a(rVar2);
                this.E.a(a3, bVar);
            } else {
                bVar = this.t[d];
            }
            b bVar2 = bVar;
            layoutParams.e = bVar2;
            if (rVar2.e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, layoutParams, (boolean) r9);
            if (rVar2.e == 1) {
                if (layoutParams.f) {
                    i11 = q(i13);
                } else {
                    i11 = bVar2.a(i13);
                }
                int b2 = this.u.b(a2) + i11;
                if (z4 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem m = m(i11);
                    m.f1076b = -1;
                    m.f1075a = a3;
                    this.E.a(m);
                }
                i4 = b2;
                i5 = i11;
            } else {
                if (layoutParams.f) {
                    i10 = t(i13);
                } else {
                    i10 = bVar2.b(i13);
                }
                i5 = i10 - this.u.b(a2);
                if (z4 && layoutParams.f) {
                    LazySpanLookup.FullSpanItem n = n(i10);
                    n.f1076b = 1;
                    n.f1075a = a3;
                    this.E.a(n);
                }
                i4 = i10;
            }
            if (layoutParams.f && rVar2.d == -1) {
                if (z4) {
                    this.M = true;
                } else {
                    if (rVar2.e == 1) {
                        z2 = D();
                    } else {
                        z2 = E();
                    }
                    if (!z2) {
                        LazySpanLookup.FullSpanItem c2 = this.E.c(a3);
                        if (c2 != null) {
                            c2.d = true;
                        }
                        this.M = true;
                    }
                }
            }
            a(a2, layoutParams, rVar2);
            if (!L() || this.w != 1) {
                if (layoutParams.f) {
                    i8 = this.v.f();
                } else {
                    i8 = (bVar2.e * this.x) + this.v.f();
                }
                i7 = i8;
                i6 = this.v.b(a2) + i8;
            } else {
                if (layoutParams.f) {
                    i9 = this.v.b();
                } else {
                    i9 = this.v.b() - (((this.s - 1) - bVar2.e) * this.x);
                }
                i6 = i9;
                i7 = i9 - this.v.b(a2);
            }
            if (this.w == 1) {
                a(a2, i7, i5, i6, i4);
            } else {
                a(a2, i5, i7, i4, i6);
            }
            if (layoutParams.f) {
                e(this.y.e, i);
            } else {
                a(bVar2, this.y.e, i);
            }
            a(oVar2, this.y);
            if (this.y.h && a2.hasFocusable()) {
                if (layoutParams.f) {
                    this.B.clear();
                } else {
                    this.B.set(bVar2.e, false);
                    z3 = true;
                    r9 = 0;
                }
            }
            z3 = true;
            r9 = 0;
        }
        if (!z3) {
            a(oVar2, this.y);
        }
        if (this.y.e == -1) {
            i3 = this.u.f() - t(this.u.f());
        } else {
            i3 = q(this.u.b()) - this.u.b();
        }
        if (i3 > 0) {
            return Math.min(rVar2.f1143b, i3);
        }
        return 0;
    }

    private void a(View view, LayoutParams layoutParams, r rVar) {
        if (rVar.e == 1) {
            if (layoutParams.f) {
                p(view);
            } else {
                layoutParams.e.a(view);
            }
        } else if (layoutParams.f) {
            q(view);
        } else {
            layoutParams.e.c(view);
        }
    }

    private void a(RecyclerView.o oVar, r rVar) {
        int i;
        int i2;
        if (rVar.f1142a && !rVar.i) {
            if (rVar.f1143b == 0) {
                if (rVar.e == -1) {
                    a(oVar, rVar.g);
                } else {
                    b(oVar, rVar.f);
                }
            } else if (rVar.e == -1) {
                int i3 = rVar.f;
                int r = i3 - r(i3);
                if (r < 0) {
                    i2 = rVar.g;
                } else {
                    i2 = rVar.g - Math.min(r, rVar.f1143b);
                }
                a(oVar, i2);
            } else {
                int s2 = s(rVar.g) - rVar.g;
                if (s2 < 0) {
                    i = rVar.f;
                } else {
                    i = Math.min(s2, rVar.f1143b) + rVar.f;
                }
                b(oVar, i);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int f = bVar.f();
        if (i == -1) {
            if (bVar.h() + f <= i2) {
                this.B.set(bVar.e, false);
            }
        } else if (bVar.g() - f >= i2) {
            this.B.set(bVar.e, false);
        }
    }

    private void a(RecyclerView.o oVar, int i) {
        int e = e() - 1;
        while (e >= 0) {
            View c2 = c(e);
            if (this.u.d(c2) >= i && this.u.f(c2) >= i) {
                LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
                if (layoutParams.f) {
                    int i2 = 0;
                    while (i2 < this.s) {
                        if (this.t[i2].f1084a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].j();
                    }
                } else if (layoutParams.e.f1084a.size() != 1) {
                    layoutParams.e.j();
                } else {
                    return;
                }
                a(c2, oVar);
                e--;
            } else {
                return;
            }
        }
    }

    private b a(r rVar) {
        int i;
        int i2;
        int i3 = -1;
        if (u(rVar.e)) {
            i2 = this.s - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.s;
            i = 1;
        }
        b bVar = null;
        if (rVar.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int f = this.u.f();
            while (i2 != i3) {
                b bVar2 = this.t[i2];
                int a2 = bVar2.a(f);
                if (a2 < i4) {
                    bVar = bVar2;
                    i4 = a2;
                }
                i2 += i;
            }
            return bVar;
        }
        int i5 = Integer.MIN_VALUE;
        int b2 = this.u.b();
        while (i2 != i3) {
            b bVar3 = this.t[i2];
            int b3 = bVar3.b(b2);
            if (b3 > i5) {
                bVar = bVar3;
                i5 = b3;
            }
            i2 += i;
        }
        return bVar;
    }

    public boolean a() {
        return this.w == 0;
    }

    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        return c(i, oVar, sVar);
    }

    public void a(int i, int i2, RecyclerView.s sVar, RecyclerView.i.a aVar) {
        int i3;
        int i4;
        if (this.w != 0) {
            i = i2;
        }
        if (e() != 0 && i != 0) {
            a(i, sVar);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.s; i6++) {
                r rVar = this.y;
                if (rVar.d == -1) {
                    i4 = rVar.f;
                    i3 = this.t[i6].b(i4);
                } else {
                    i4 = this.t[i6].a(rVar.g);
                    i3 = this.y.g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O, 0, i5);
            for (int i8 = 0; i8 < i5 && this.y.a(sVar); i8++) {
                aVar.a(this.y.f1144c, this.O[i8]);
                r rVar2 = this.y;
                rVar2.f1144c += rVar2.d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, RecyclerView.s sVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = I();
            i2 = 1;
        } else {
            i3 = H();
            i2 = -1;
        }
        this.y.f1142a = true;
        b(i3, sVar);
        v(i2);
        r rVar = this.y;
        rVar.f1144c = i3 + rVar.d;
        rVar.f1143b = Math.abs(i);
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

    public View a(View view, int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        View c2;
        int i2;
        int i3;
        int i4;
        int i5;
        View a2;
        if (e() == 0 || (c2 = c(view)) == null) {
            return null;
        }
        O();
        int l = l(i);
        if (l == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
        boolean z2 = layoutParams.f;
        b bVar = layoutParams.e;
        if (l == 1) {
            i2 = I();
        } else {
            i2 = H();
        }
        b(i2, sVar);
        v(l);
        r rVar = this.y;
        rVar.f1144c = rVar.d + i2;
        rVar.f1143b = (int) (((float) this.u.g()) * 0.33333334f);
        r rVar2 = this.y;
        rVar2.h = true;
        rVar2.f1142a = false;
        a(oVar, rVar2, sVar);
        this.G = this.A;
        if (!z2 && (a2 = bVar.a(i2, l)) != null && a2 != c2) {
            return a2;
        }
        if (u(l)) {
            for (int i6 = this.s - 1; i6 >= 0; i6--) {
                View a3 = this.t[i6].a(i2, l);
                if (a3 != null && a3 != c2) {
                    return a3;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.s; i7++) {
                View a4 = this.t[i7].a(i2, l);
                if (a4 != null && a4 != c2) {
                    return a4;
                }
            }
        }
        boolean z3 = (this.z ^ true) == (l == -1);
        if (!z2) {
            if (z3) {
                i5 = bVar.d();
            } else {
                i5 = bVar.e();
            }
            View b2 = b(i5);
            if (!(b2 == null || b2 == c2)) {
                return b2;
            }
        }
        if (u(l)) {
            for (int i8 = this.s - 1; i8 >= 0; i8--) {
                if (i8 != bVar.e) {
                    if (z3) {
                        i4 = this.t[i8].d();
                    } else {
                        i4 = this.t[i8].e();
                    }
                    View b3 = b(i4);
                    if (!(b3 == null || b3 == c2)) {
                        return b3;
                    }
                }
            }
        } else {
            for (int i9 = 0; i9 < this.s; i9++) {
                if (z3) {
                    i3 = this.t[i9].d();
                } else {
                    i3 = this.t[i9].e();
                }
                View b4 = b(i3);
                if (b4 != null && b4 != c2) {
                    return b4;
                }
            }
        }
        return null;
    }
}
