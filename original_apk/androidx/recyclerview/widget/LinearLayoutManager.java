package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.i implements q, RecyclerView.r.a {
    int A = -1;
    int B = Integer.MIN_VALUE;
    private boolean C;
    SavedState D = null;
    final a E = new a();
    private final b F = new b();
    private int G = 2;
    int s = 1;
    private c t;
    w u;
    private boolean v;
    private boolean w = false;
    boolean x = false;
    private boolean y = false;
    private boolean z = true;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new s();

        /* renamed from: a  reason: collision with root package name */
        int f1011a;

        /* renamed from: b  reason: collision with root package name */
        int f1012b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1013c;

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f1011a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f1011a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1011a);
            parcel.writeInt(this.f1012b);
            parcel.writeInt(this.f1013c ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f1011a = parcel.readInt();
            this.f1012b = parcel.readInt();
            this.f1013c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f1011a = savedState.f1011a;
            this.f1012b = savedState.f1012b;
            this.f1013c = savedState.f1013c;
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1017a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1018b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1019c;
        public boolean d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1017a = 0;
            this.f1018b = false;
            this.f1019c = false;
            this.d = false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f1020a = true;

        /* renamed from: b  reason: collision with root package name */
        int f1021b;

        /* renamed from: c  reason: collision with root package name */
        int f1022c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<RecyclerView.v> k = null;
        boolean l;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.k.get(i2).f1071b;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.d == layoutParams.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(RecyclerView.s sVar) {
            int i2 = this.d;
            return i2 >= 0 && i2 < sVar.a();
        }

        /* access modifiers changed from: package-private */
        public View a(RecyclerView.o oVar) {
            if (this.k != null) {
                return b();
            }
            View d2 = oVar.d(this.d);
            this.d += this.e;
            return d2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.LayoutParams) b2.getLayoutParams()).a();
            }
        }

        public View b(View view) {
            int a2;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).f1071b;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a2 = (layoutParams.a() - this.d) * this.e) >= 0 && a2 < i2) {
                    if (a2 == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i2 = a2;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z2) {
        i(i);
        a(z2);
    }

    private View K() {
        return c(this.x ? 0 : e() - 1);
    }

    private View L() {
        return c(this.x ? e() - 1 : 0);
    }

    private void M() {
        if (this.s == 1 || !I()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    private void f(int i, int i2) {
        this.t.f1022c = this.u.b() - i2;
        this.t.e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.d = i;
        cVar.f = 1;
        cVar.f1021b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private int j(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        w wVar = this.u;
        View b2 = b(!this.z, true);
        return H.a(sVar, wVar, b2, a(!this.z, true), this, this.z, this.x);
    }

    private int k(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        w wVar = this.u;
        View b2 = b(!this.z, true);
        return H.b(sVar, wVar, b2, a(!this.z, true), this, this.z);
    }

    private View l(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.x) {
            return g(oVar, sVar);
        }
        return i(oVar, sVar);
    }

    private View m(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.x) {
            return i(oVar, sVar);
        }
        return g(oVar, sVar);
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return (i() == 1073741824 || r() == 1073741824 || !s()) ? false : true;
    }

    public boolean C() {
        return this.D == null && this.v == this.y;
    }

    /* access modifiers changed from: package-private */
    public c D() {
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void E() {
        if (this.t == null) {
            this.t = D();
        }
    }

    public int F() {
        View a2 = a(0, e(), false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int G() {
        View a2 = a(e() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int H() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        return j() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean J() {
        return this.u.d() == 0 && this.u.a() == 0;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            accessibilityEvent.setFromIndex(F());
            accessibilityEvent.setToIndex(G());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, a aVar, int i) {
    }

    public void b(RecyclerView recyclerView, RecyclerView.o oVar) {
        super.b(recyclerView, oVar);
        if (this.C) {
            b(oVar);
            oVar.a();
        }
    }

    public RecyclerView.LayoutParams c() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int d(RecyclerView.s sVar) {
        return i(sVar);
    }

    public void e(RecyclerView.o oVar, RecyclerView.s sVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View b2;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.D == null && this.A == -1) && sVar.a() == 0) {
            b(oVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f1011a;
        }
        E();
        this.t.f1020a = false;
        M();
        View g = g();
        if (!this.E.e || this.A != -1 || this.D != null) {
            this.E.b();
            a aVar = this.E;
            aVar.d = this.x ^ this.y;
            b(oVar, sVar, aVar);
            this.E.e = true;
        } else if (g != null && (this.u.d(g) >= this.u.b() || this.u.a(g) <= this.u.f())) {
            this.E.b(g, l(g));
        }
        int h = h(sVar);
        if (this.t.j >= 0) {
            i = h;
            h = 0;
        } else {
            i = 0;
        }
        int f = h + this.u.f();
        int c2 = i + this.u.c();
        if (!(!sVar.d() || (i7 = this.A) == -1 || this.B == Integer.MIN_VALUE || (b2 = b(i7)) == null)) {
            if (this.x) {
                i8 = this.u.b() - this.u.a(b2);
                i9 = this.B;
            } else {
                i9 = this.u.d(b2) - this.u.f();
                i8 = this.B;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                f += i11;
            } else {
                c2 -= i11;
            }
        }
        if (!this.E.d ? !this.x : this.x) {
            i10 = 1;
        }
        a(oVar, sVar, this.E, i10);
        a(oVar);
        this.t.l = J();
        this.t.i = sVar.d();
        a aVar2 = this.E;
        if (aVar2.d) {
            b(aVar2);
            c cVar = this.t;
            cVar.h = f;
            a(oVar, cVar, sVar, false);
            c cVar2 = this.t;
            i3 = cVar2.f1021b;
            int i12 = cVar2.d;
            int i13 = cVar2.f1022c;
            if (i13 > 0) {
                c2 += i13;
            }
            a(this.E);
            c cVar3 = this.t;
            cVar3.h = c2;
            cVar3.d += cVar3.e;
            a(oVar, cVar3, sVar, false);
            c cVar4 = this.t;
            i2 = cVar4.f1021b;
            int i14 = cVar4.f1022c;
            if (i14 > 0) {
                g(i12, i3);
                c cVar5 = this.t;
                cVar5.h = i14;
                a(oVar, cVar5, sVar, false);
                i3 = this.t.f1021b;
            }
        } else {
            a(aVar2);
            c cVar6 = this.t;
            cVar6.h = c2;
            a(oVar, cVar6, sVar, false);
            c cVar7 = this.t;
            i2 = cVar7.f1021b;
            int i15 = cVar7.d;
            int i16 = cVar7.f1022c;
            if (i16 > 0) {
                f += i16;
            }
            b(this.E);
            c cVar8 = this.t;
            cVar8.h = f;
            cVar8.d += cVar8.e;
            a(oVar, cVar8, sVar, false);
            c cVar9 = this.t;
            i3 = cVar9.f1021b;
            int i17 = cVar9.f1022c;
            if (i17 > 0) {
                f(i15, i2);
                c cVar10 = this.t;
                cVar10.h = i17;
                a(oVar, cVar10, sVar, false);
                i2 = this.t.f1021b;
            }
        }
        if (e() > 0) {
            if (this.x ^ this.y) {
                int a2 = a(i2, oVar, sVar, true);
                i5 = i3 + a2;
                i4 = i2 + a2;
                i6 = b(i5, oVar, sVar, false);
            } else {
                int b3 = b(i3, oVar, sVar, true);
                i5 = i3 + b3;
                i4 = i2 + b3;
                i6 = a(i4, oVar, sVar, false);
            }
            i3 = i5 + i6;
            i2 = i4 + i6;
        }
        b(oVar, sVar, i3, i2);
        if (!sVar.d()) {
            this.u.i();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    public void g(RecyclerView.s sVar) {
        super.g(sVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    /* access modifiers changed from: protected */
    public int h(RecyclerView.s sVar) {
        if (sVar.c()) {
            return this.u.g();
        }
        return 0;
    }

    public void i(int i) {
        if (i == 0 || i == 1) {
            a((String) null);
            if (i != this.s || this.u == null) {
                this.u = w.a_shaKey_method2(this, i);
                this.E.f1014a = this.u;
                this.s = i;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public boolean u() {
        return true;
    }

    public Parcelable x() {
        SavedState savedState = this.D;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (e() > 0) {
            E();
            boolean z2 = this.v ^ this.x;
            savedState2.f1013c = z2;
            if (z2) {
                View K = K();
                savedState2.f1012b = this.u.b() - this.u.a(K);
                savedState2.f1011a = l(K);
            } else {
                View L = L();
                savedState2.f1011a = l(L);
                savedState2.f1012b = this.u.d(L) - this.u.f();
            }
        } else {
            savedState2.b();
        }
        return savedState2;
    }

    public int c(RecyclerView.s sVar) {
        return k(sVar);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        w f1014a;

        /* renamed from: b  reason: collision with root package name */
        int f1015b;

        /* renamed from: c  reason: collision with root package name */
        int f1016c;
        boolean d;
        boolean e;

        a() {
            b();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i;
            if (this.d) {
                i = this.f1014a.b();
            } else {
                i = this.f1014a.f();
            }
            this.f1016c = i;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f1015b = -1;
            this.f1016c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1015b + ", mCoordinate=" + this.f1016c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, RecyclerView.s sVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.c() && layoutParams.a() >= 0 && layoutParams.a() < sVar.a();
        }

        public void b(View view, int i) {
            int h = this.f1014a.h();
            if (h >= 0) {
                a_shaKey_method2(view, i);
                return;
            }
            this.f1015b = i;
            if (this.d) {
                int b2 = (this.f1014a.b() - h) - this.f1014a.a(view);
                this.f1016c = this.f1014a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.f1016c - this.f1014a.b(view);
                    int f = this.f1014a.f();
                    int min = b3 - (f + Math.min(this.f1014a.d(view) - f, 0));
                    if (min < 0) {
                        this.f1016c += Math.min(b2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d2 = this.f1014a.d(view);
            int f2 = d2 - this.f1014a.f();
            this.f1016c = d2;
            if (f2 > 0) {
                int b4 = (this.f1014a.b() - Math.min(0, (this.f1014a.b() - h) - this.f1014a.a(view))) - (d2 + this.f1014a.b(view));
                if (b4 < 0) {
                    this.f1016c -= Math.min(f2, -b4);
                }
            }
        }

        public void a(View view, int i) {
            if (this.d) {
                this.f1016c = this.f1014a.a(view) + this.f1014a.h();
            } else {
                this.f1016c = this.f1014a.d(view);
            }
            this.f1015b = i;
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        this.t.f1020a = true;
        E();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, sVar);
        c cVar = this.t;
        int a2 = cVar.g + a(oVar, cVar, sVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.u.a(-i);
        this.t.j = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public int h(int i) {
        if (i == 1) {
            return (this.s != 1 && I()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && I()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.s == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.s == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.s == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            y();
        }
    }

    public boolean b() {
        return this.s == 1;
    }

    private void g(int i, int i2) {
        this.t.f1022c = i2 - this.u.f();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f1021b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    public void b(boolean z2) {
        a((String) null);
        if (this.y != z2) {
            this.y = z2;
            y();
        }
    }

    private View j(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.x) {
            return f(oVar, sVar);
        }
        return h(oVar, sVar);
    }

    private View k(RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.x) {
            return h(oVar, sVar);
        }
        return f(oVar, sVar);
    }

    public int f(RecyclerView.s sVar) {
        return k(sVar);
    }

    private View f(RecyclerView.o oVar, RecyclerView.s sVar) {
        return e(0, e());
    }

    private int i(RecyclerView.s sVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        w wVar = this.u;
        View b2 = b(!this.z, true);
        return H.a(sVar, wVar, b2, a(!this.z, true), this, this.z);
    }

    public boolean a() {
        return this.s == 0;
    }

    public void a(boolean z2) {
        a((String) null);
        if (z2 != this.w) {
            this.w = z2;
            y();
        }
    }

    public View b(int i) {
        int e = e();
        if (e == 0) {
            return null;
        }
        int l = i - l(c(0));
        if (l >= 0 && l < e) {
            View c2 = c(l);
            if (l(c2) == i) {
                return c2;
            }
        }
        return super.b(i);
    }

    private View h(RecyclerView.o oVar, RecyclerView.s sVar) {
        return e(e() - 1, -1);
    }

    private View g(RecyclerView.o oVar, RecyclerView.s sVar) {
        return a(oVar, sVar, 0, e(), sVar.a());
    }

    private boolean a(RecyclerView.o oVar, RecyclerView.s sVar, a aVar) {
        View view;
        int i;
        boolean z2 = false;
        if (e() == 0) {
            return false;
        }
        View g = g();
        if (g != null && aVar.a_shaKey_method2(g, sVar)) {
            aVar.b(g, l(g));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            if (aVar.d) {
                view = l(oVar, sVar);
            } else {
                view = m(oVar, sVar);
            }
            if (view == null) {
                return false;
            }
            aVar.a_shaKey_method2(view, l(view));
            if (!sVar.d() && C()) {
                if (this.u.d(view) >= this.u.b() || this.u.a(view) < this.u.f()) {
                    z2 = true;
                }
                if (z2) {
                    if (aVar.d) {
                        i = this.u.b();
                    } else {
                        i = this.u.f();
                    }
                    aVar.f1016c = i;
                }
            }
            return true;
        }
    }

    private View i(RecyclerView.o oVar, RecyclerView.s sVar) {
        return a(oVar, sVar, e() - 1, -1, sVar.a());
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = RecyclerView.i.a(context, attributeSet, i, i2);
        i(a2.f1052a);
        a(a2.f1054c);
        b(a2.d);
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, int i, int i2) {
        RecyclerView.o oVar2 = oVar;
        RecyclerView.s sVar2 = sVar;
        if (sVar.e() && e() != 0 && !sVar.d() && C()) {
            List<RecyclerView.v> f = oVar.f();
            int size = f.size();
            int l = l(c(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.v vVar = f.get(i5);
                if (!vVar.p()) {
                    char c2 = 1;
                    if ((vVar.i() < l) != this.x) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i3 += this.u.b(vVar.f1071b);
                    } else {
                        i4 += this.u.b(vVar.f1071b);
                    }
                }
            }
            this.t.k = f;
            if (i3 > 0) {
                g(l(L()), i);
                c cVar = this.t;
                cVar.h = i3;
                cVar.f1022c = 0;
                cVar.a();
                a(oVar2, this.t, sVar2, false);
            }
            if (i4 > 0) {
                f(l(K()), i2);
                c cVar2 = this.t;
                cVar2.h = i4;
                cVar2.f1022c = 0;
                cVar2.a();
                a(oVar2, this.t, sVar2, false);
            }
            this.t.k = null;
        }
    }

    private boolean a(RecyclerView.s sVar, a aVar) {
        int i;
        int i2;
        boolean z2 = false;
        if (!sVar.d() && (i = this.A) != -1) {
            if (i < 0 || i >= sVar.a()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                aVar.f1015b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    aVar.d = this.D.f1013c;
                    if (aVar.d) {
                        aVar.f1016c = this.u.b() - this.D.f1012b;
                    } else {
                        aVar.f1016c = this.u.f() + this.D.f1012b;
                    }
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View b2 = b(this.A);
                    if (b2 == null) {
                        if (e() > 0) {
                            if ((this.A < l(c(0))) == this.x) {
                                z2 = true;
                            }
                            aVar.d = z2;
                        }
                        aVar.a();
                    } else if (this.u.b(b2) > this.u.g()) {
                        aVar.a();
                        return true;
                    } else if (this.u.d(b2) - this.u.f() < 0) {
                        aVar.f1016c = this.u.f();
                        aVar.d = false;
                        return true;
                    } else if (this.u.b() - this.u.a(b2) < 0) {
                        aVar.f1016c = this.u.b();
                        aVar.d = true;
                        return true;
                    } else {
                        if (aVar.d) {
                            i2 = this.u.a(b2) + this.u.h();
                        } else {
                            i2 = this.u.d(b2);
                        }
                        aVar.f1016c = i2;
                    }
                    return true;
                } else {
                    boolean z3 = this.x;
                    aVar.d = z3;
                    if (z3) {
                        aVar.f1016c = this.u.b() - this.B;
                    } else {
                        aVar.f1016c = this.u.f() + this.B;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void b(RecyclerView.o oVar, RecyclerView.s sVar, a aVar) {
        if (!a(sVar, aVar) && !a(oVar, sVar, aVar)) {
            aVar.a();
            aVar.f1015b = this.y ? sVar.a() - 1 : 0;
        }
    }

    private int b(int i, RecyclerView.o oVar, RecyclerView.s sVar, boolean z2) {
        int f;
        int f2 = i - this.u.f();
        if (f2 <= 0) {
            return 0;
        }
        int i2 = -c(f2, oVar, sVar);
        int i3 = i + i2;
        if (!z2 || (f = i3 - this.u.f()) <= 0) {
            return i2;
        }
        this.u.a(-f);
        return i2 - f;
    }

    private void b(a aVar) {
        g(aVar.f1015b, aVar.f1016c);
    }

    public int b(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 0) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    public int b(RecyclerView.s sVar) {
        return j(sVar);
    }

    private void b(RecyclerView.o oVar, int i) {
        if (i >= 0) {
            int e = e();
            if (this.x) {
                int i2 = e - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View c2 = c(i3);
                    if (this.u.a(c2) > i || this.u.e(c2) > i) {
                        a(oVar, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i4 = 0; i4 < e; i4++) {
                View c3 = c(i4);
                if (this.u.a(c3) > i || this.u.e(c3) > i) {
                    a(oVar, 0, i4);
                    return;
                }
            }
        }
    }

    private View b(boolean z2, boolean z3) {
        if (this.x) {
            return a(e() - 1, -1, z2, z3);
        }
        return a(0, e(), z2, z3);
    }

    private int a(int i, RecyclerView.o oVar, RecyclerView.s sVar, boolean z2) {
        int b2;
        int b3 = this.u.b() - i;
        if (b3 <= 0) {
            return 0;
        }
        int i2 = -c(-b3, oVar, sVar);
        int i3 = i + i2;
        if (!z2 || (b2 = this.u.b() - i3) <= 0) {
            return i2;
        }
        this.u.a(b2);
        return b2 + i2;
    }

    private void a(a aVar) {
        f(aVar.f1015b, aVar.f1016c);
    }

    public int a(int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        if (this.s == 1) {
            return 0;
        }
        return c(i, oVar, sVar);
    }

    public int a(RecyclerView.s sVar) {
        return i(sVar);
    }

    private void a(int i, int i2, boolean z2, RecyclerView.s sVar) {
        int i3;
        this.t.l = J();
        this.t.h = h(sVar);
        c cVar = this.t;
        cVar.f = i;
        int i4 = -1;
        if (i == 1) {
            cVar.h += this.u.c();
            View K = K();
            c cVar2 = this.t;
            if (!this.x) {
                i4 = 1;
            }
            cVar2.e = i4;
            c cVar3 = this.t;
            int l = l(K);
            c cVar4 = this.t;
            cVar3.d = l + cVar4.e;
            cVar4.f1021b = this.u.a(K);
            i3 = this.u.a(K) - this.u.b();
        } else {
            View L = L();
            this.t.h += this.u.f();
            c cVar5 = this.t;
            if (this.x) {
                i4 = 1;
            }
            cVar5.e = i4;
            c cVar6 = this.t;
            int l2 = l(L);
            c cVar7 = this.t;
            cVar6.d = l2 + cVar7.e;
            cVar7.f1021b = this.u.d(L);
            i3 = (-this.u.d(L)) + this.u.f();
        }
        c cVar8 = this.t;
        cVar8.f1022c = i2;
        if (z2) {
            cVar8.f1022c -= i3;
        }
        this.t.g = i3;
    }

    public int e(RecyclerView.s sVar) {
        return j(sVar);
    }

    /* access modifiers changed from: package-private */
    public View e(int i, int i2) {
        int i3;
        int i4;
        E();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return c(i);
        }
        if (this.u.d(c(i)) < this.u.f()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i4, i3);
        }
        return this.f.a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.s sVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i >= 0 && i < sVar.a()) {
            aVar.a(i, Math.max(0, cVar.g));
        }
    }

    public void a(int i, RecyclerView.i.a aVar) {
        boolean z2;
        int i2;
        SavedState savedState = this.D;
        int i3 = -1;
        if (savedState == null || !savedState.a()) {
            M();
            z2 = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z2 = savedState2.f1013c;
            i2 = savedState2.f1011a;
        }
        if (!z2) {
            i3 = 1;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < this.G && i4 >= 0 && i4 < i; i5++) {
            aVar.a(i4, 0);
            i4 += i3;
        }
    }

    public void a(int i, int i2, RecyclerView.s sVar, RecyclerView.i.a aVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (e() != 0 && i != 0) {
            E();
            a(i > 0 ? 1 : -1, Math.abs(i), true, sVar);
            a(sVar, this.t, aVar);
        }
    }

    public void a(String str) {
        if (this.D == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.o oVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, oVar);
                }
                return;
            }
            while (i > i2) {
                a(i, oVar);
                i--;
            }
        }
    }

    private void a(RecyclerView.o oVar, int i) {
        int e = e();
        if (i >= 0) {
            int a2 = this.u.a() - i;
            if (this.x) {
                for (int i2 = 0; i2 < e; i2++) {
                    View c2 = c(i2);
                    if (this.u.d(c2) < a2 || this.u.f(c2) < a2) {
                        a(oVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = e - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View c3 = c(i4);
                if (this.u.d(c3) < a2 || this.u.f(c3) < a2) {
                    a(oVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.o oVar, c cVar) {
        if (cVar.f1020a && !cVar.l) {
            if (cVar.f == -1) {
                a(oVar, cVar.g);
            } else {
                b(oVar, cVar.g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a(RecyclerView.o oVar, c cVar, RecyclerView.s sVar, boolean z2) {
        int i = cVar.f1022c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            a(oVar, cVar);
        }
        int i3 = cVar.f1022c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(sVar)) {
                break;
            }
            bVar.a();
            a(oVar, sVar, cVar, bVar);
            if (!bVar.f1018b) {
                cVar.f1021b += bVar.f1017a * cVar.f;
                if (!bVar.f1019c || this.t.k != null || !sVar.d()) {
                    int i4 = cVar.f1022c;
                    int i5 = bVar.f1017a;
                    cVar.f1022c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    cVar.g = i6 + bVar.f1017a;
                    int i7 = cVar.f1022c;
                    if (i7 < 0) {
                        cVar.g += i7;
                    }
                    a(oVar, cVar);
                }
                if (z2 && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f1022c;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.o oVar, RecyclerView.s sVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a2 = cVar.a(oVar);
        if (a2 == null) {
            bVar.f1018b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.x == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                a(a2);
            } else {
                a_shaKey_method2(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f1017a = this.u.b(a2);
        if (this.s == 1) {
            if (I()) {
                i5 = q() - o();
                i4 = i5 - this.u.c(a2);
            } else {
                i4 = n();
                i5 = this.u.c(a2) + i4;
            }
            if (cVar.f == -1) {
                int i6 = cVar.f1021b;
                i = i6;
                i2 = i5;
                i3 = i6 - bVar.f1017a;
            } else {
                int i7 = cVar.f1021b;
                i3 = i7;
                i2 = i5;
                i = bVar.f1017a + i7;
            }
        } else {
            int p = p();
            int c2 = this.u.c(a2) + p;
            if (cVar.f == -1) {
                int i8 = cVar.f1021b;
                i2 = i8;
                i3 = p;
                i = c2;
                i4 = i8 - bVar.f1017a;
            } else {
                int i9 = cVar.f1021b;
                i3 = p;
                i2 = bVar.f1017a + i9;
                i = c2;
                i4 = i9;
            }
        }
        a(a2, i4, i3, i2, i);
        if (layoutParams.c() || layoutParams.b()) {
            bVar.f1019c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    private View a(boolean z2, boolean z3) {
        if (this.x) {
            return a(0, e(), z2, z3);
        }
        return a(e() - 1, -1, z2, z3);
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
            if (l >= 0 && l < i3) {
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

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, boolean z2, boolean z3) {
        E();
        int i3 = 320;
        int i4 = z2 ? 24579 : 320;
        if (!z3) {
            i3 = 0;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i4, i3);
        }
        return this.f.a(i, i2, i4, i3);
    }

    public View a(View view, int i, RecyclerView.o oVar, RecyclerView.s sVar) {
        int h;
        View view2;
        View view3;
        M();
        if (e() == 0 || (h = h(i)) == Integer.MIN_VALUE) {
            return null;
        }
        E();
        E();
        a(h, (int) (((float) this.u.g()) * 0.33333334f), false, sVar);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.f1020a = false;
        a(oVar, cVar, sVar, true);
        if (h == -1) {
            view2 = k(oVar, sVar);
        } else {
            view2 = j(oVar, sVar);
        }
        if (h == -1) {
            view3 = L();
        } else {
            view3 = K();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }
}
