package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.h.C0083a;
import androidx.core.h.a.c;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.M;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;

public class RecyclerView extends ViewGroup implements androidx.core.h.q, androidx.core.h.i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1033a = {16843830};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1034b = {16842987};

    /* renamed from: c  reason: collision with root package name */
    static final boolean f1035c;
    static final boolean d = (Build.VERSION.SDK_INT >= 23);
    static final boolean e = (Build.VERSION.SDK_INT >= 16);
    static final boolean f = (Build.VERSION.SDK_INT >= 21);
    private static final boolean g = (Build.VERSION.SDK_INT <= 15);
    private static final boolean h = (Build.VERSION.SDK_INT <= 15);
    private static final Class<?>[] i;
    static final Interpolator j = new z();
    private l A;
    private final int[] Aa;
    boolean B;
    final int[] Ba;
    boolean C;
    private final int[] Ca;
    boolean D;
    final int[] Da;
    boolean E;
    final List<v> Ea;
    private int F;
    private Runnable Fa;
    boolean G;
    private final N.b Ga;
    boolean H;
    private boolean I;
    private int J;
    boolean K;
    private final AccessibilityManager L;
    private List<j> M;
    boolean N;
    boolean O;
    private int P;
    private int Q;
    private e R;
    private EdgeEffect S;
    private EdgeEffect T;
    private EdgeEffect U;
    private EdgeEffect V;
    f W;
    private int aa;
    private int ba;
    private VelocityTracker ca;
    private int da;
    private int ea;
    private int fa;
    private int ga;
    private k ha;
    private final int ia;
    private final int ja;
    private final q k;
    private float ka;
    final o l;
    private float la;
    private SavedState m;
    G mAccessibilityDelegate;
    private int mTouchSlop;
    private boolean ma;
    C0104a n;
    final u na;
    C0105b o;
    p oa;
    final N p;
    p.a pa;
    boolean q;
    final s qa;
    final Runnable r;
    private m ra;
    final Rect s;
    private List<m> sa;
    private final Rect t;
    boolean ta;
    final RectF u;
    boolean ua;
    a v;
    private f.b va;
    i w;
    boolean wa;
    p x;
    private d xa;
    final ArrayList<h> y;
    private final int[] ya;
    private final ArrayList<l> z;
    private androidx.core.h.k za;

    public static abstract class a<VH extends v> {

        /* renamed from: a  reason: collision with root package name */
        private final b f1040a = new b();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1041b = false;

        public abstract int a();

        public abstract long a(int i);

        public void a(VH vh, int i, List<Object> list) {
            b(vh, i);
        }

        public void a(RecyclerView recyclerView) {
        }

        public boolean a(VH vh) {
            return false;
        }

        public abstract int b(int i);

        public abstract VH b(ViewGroup viewGroup, int i);

        public void b(VH vh) {
        }

        public abstract void b(VH vh, int i);

        public void b(RecyclerView recyclerView) {
        }

        public final boolean b() {
            return this.f1041b;
        }

        public final void c() {
            this.f1040a.a();
        }

        public void c(VH vh) {
        }

        public abstract void d(VH vh);

        public final VH a(ViewGroup viewGroup, int i) {
            try {
                androidx.core.d.a.a("RV CreateView");
                VH b2 = b(viewGroup, i);
                if (b2.f1071b.getParent() == null) {
                    b2.g = i;
                    return b2;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.d.a.a();
            }
        }

        public void b(c cVar) {
            this.f1040a.unregisterObserver(cVar);
        }

        public final void a(VH vh, int i) {
            vh.d = i;
            if (b()) {
                vh.f = a(i);
            }
            vh.a(1, 519);
            androidx.core.d.a.a("RV OnBindView");
            a(vh, i, vh.k());
            vh.b();
            ViewGroup.LayoutParams layoutParams = vh.f1071b.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f1038c = true;
            }
            androidx.core.d.a.a();
        }

        public void a(c cVar) {
            this.f1040a.registerObserver(cVar);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }
    }

    public static abstract class c {
        public void a() {
        }
    }

    public interface d {
        int a(int i, int i2);
    }

    public static class e {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private b f1042a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f1043b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f1044c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(v vVar);
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f1045a;

            /* renamed from: b  reason: collision with root package name */
            public int f1046b;

            /* renamed from: c  reason: collision with root package name */
            public int f1047c;
            public int d;

            public c a(v vVar) {
                a(vVar, 0);
                return this;
            }

            public c a(v vVar, int i) {
                View view = vVar.f1071b;
                this.f1045a = view.getLeft();
                this.f1046b = view.getTop();
                this.f1047c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f1042a = bVar;
        }

        public abstract boolean a(v vVar, c cVar, c cVar2);

        public abstract boolean a(v vVar, v vVar2, c cVar, c cVar2);

        public abstract void b();

        public abstract boolean b(v vVar);

        public abstract boolean b(v vVar, c cVar, c cVar2);

        public long c() {
            return this.f1044c;
        }

        public abstract boolean c(v vVar, c cVar, c cVar2);

        public long d() {
            return this.f;
        }

        public abstract void d(v vVar);

        public long e() {
            return this.e;
        }

        public void e(v vVar) {
        }

        public long f() {
            return this.d;
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();

        public c a(s sVar, v vVar, int i, List<Object> list) {
            c h = h();
            h.a(vVar);
            return h;
        }

        public final void c(v vVar) {
            e(vVar);
            b bVar = this.f1042a;
            if (bVar != null) {
                bVar.a(vVar);
            }
        }

        public c a(s sVar, v vVar) {
            c h = h();
            h.a(vVar);
            return h;
        }

        static int a(v vVar) {
            int i = vVar.k & 14;
            if (vVar.n()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int j = vVar.j();
            int f2 = vVar.f();
            return (j == -1 || f2 == -1 || j == f2) ? i : i | 2048;
        }

        public boolean a(v vVar, List<Object> list) {
            return b(vVar);
        }

        public final void a() {
            int size = this.f1043b.size();
            for (int i = 0; i < size; i++) {
                this.f1043b.get(i).a();
            }
            this.f1043b.clear();
        }
    }

    private class g implements f.b {
        g() {
        }

        public void a(v vVar) {
            vVar.a(true);
            if (vVar.i != null && vVar.j == null) {
                vVar.i = null;
            }
            vVar.j = null;
            if (!vVar.w() && !RecyclerView.this.k(vVar.f1071b) && vVar.r()) {
                RecyclerView.this.removeDetachedView(vVar.f1071b, false);
            }
        }
    }

    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
            a_shaKey_method2(canvas, recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, s sVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            a(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }
    }

    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        C0105b f1049a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f1050b;

        /* renamed from: c  reason: collision with root package name */
        private final M.b f1051c = new D(this);
        private final M.b d = new E(this);
        M e = new M(this.f1051c);
        M f = new M(this.d);
        r g;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        public interface a {
            void a(int i, int i2);
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f1052a;

            /* renamed from: b  reason: collision with root package name */
            public int f1053b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f1054c;
            public boolean d;
        }

        /* access modifiers changed from: package-private */
        public boolean A() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void B() {
            r rVar = this.g;
            if (rVar != null) {
                rVar.d();
            }
        }

        public boolean C() {
            return false;
        }

        public int a(int i2, o oVar, s sVar) {
            return 0;
        }

        public int a(s sVar) {
            return 0;
        }

        public View a(View view, int i2, o oVar, s sVar) {
            return null;
        }

        public void a(int i2, int i3, s sVar, a aVar) {
        }

        public void a(int i2, a aVar) {
        }

        public void a(Rect rect, int i2, int i3) {
            c(a(i2, rect.width() + n() + o(), l()), a(i3, rect.height() + p() + m(), k()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public boolean a(o oVar, s sVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public int b(int i2, o oVar, s sVar) {
            return 0;
        }

        public int b(s sVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            this.o = View.MeasureSpec.getMode(i2);
            if (this.o == 0 && !RecyclerView.d) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            this.p = View.MeasureSpec.getMode(i3);
            if (this.p == 0 && !RecyclerView.d) {
                this.r = 0;
            }
        }

        public void b(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean b() {
            return false;
        }

        public int c(o oVar, s sVar) {
            return 0;
        }

        public int c(s sVar) {
            return 0;
        }

        public View c(View view) {
            View c2;
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView == null || (c2 = recyclerView.c(view)) == null || this.f1049a.c(c2)) {
                return null;
            }
            return c2;
        }

        public abstract LayoutParams c();

        @Deprecated
        public void c(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i2, int i3) {
        }

        public int d() {
            return -1;
        }

        public int d(s sVar) {
            return 0;
        }

        public View d(View view, int i2) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, int i3) {
            int e2 = e();
            if (e2 == 0) {
                this.f1050b.c(i2, i3);
                return;
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < e2; i8++) {
                View c2 = c(i8);
                Rect rect = this.f1050b.s;
                b(c2, rect);
                int i9 = rect.left;
                if (i9 < i4) {
                    i4 = i9;
                }
                int i10 = rect.right;
                if (i10 > i6) {
                    i6 = i10;
                }
                int i11 = rect.top;
                if (i11 < i5) {
                    i5 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.f1050b.s.set(i4, i5, i6, i7);
            a(this.f1050b.s, i2, i3);
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d(o oVar, s sVar) {
            return false;
        }

        public int e(s sVar) {
            return 0;
        }

        public void e(o oVar, s sVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int f(s sVar) {
            return 0;
        }

        public void f(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1050b = null;
                this.f1049a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f1050b = recyclerView;
                this.f1049a = recyclerView.o;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void g(int i2) {
            if (c(i2) != null) {
                this.f1049a.e(i2);
            }
        }

        public void g(s sVar) {
        }

        public int h() {
            return this.r;
        }

        public int i() {
            return this.p;
        }

        public int j() {
            return androidx.core.h.t.k(this.f1050b);
        }

        public int k(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1037b.left;
        }

        public int l(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        public int m() {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int n() {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void o(View view) {
            this.f1049a.d(view);
        }

        public int p() {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int q() {
            return this.q;
        }

        public int r() {
            return this.o;
        }

        /* access modifiers changed from: package-private */
        public boolean s() {
            int e2 = e();
            for (int i2 = 0; i2 < e2; i2++) {
                ViewGroup.LayoutParams layoutParams = c(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean t() {
            return this.i;
        }

        public boolean u() {
            return this.j;
        }

        public final boolean v() {
            return this.l;
        }

        public boolean w() {
            r rVar = this.g;
            return rVar != null && rVar.c();
        }

        public Parcelable x() {
            return null;
        }

        public void y() {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void z() {
            this.h = true;
        }

        public int e() {
            C0105b bVar = this.f1049a;
            if (bVar != null) {
                return bVar.a();
            }
            return 0;
        }

        public int h(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f1037b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int i(View view) {
            return view.getRight() + m(view);
        }

        public int j(View view) {
            return view.getTop() - n(view);
        }

        public int k() {
            return androidx.core.h.t.l(this.f1050b);
        }

        public int l() {
            return androidx.core.h.t.m(this.f1050b);
        }

        public int m(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1037b.right;
        }

        public int n(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1037b.top;
        }

        public int o() {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void e(int i2) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                recyclerView.f(i2);
            }
        }

        public View g() {
            View focusedChild;
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1049a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void c(View view, int i2) {
            a(view, i2, (LayoutParams) view.getLayoutParams());
        }

        public View c(int i2) {
            C0105b bVar = this.f1049a;
            if (bVar != null) {
                return bVar.c(i2);
            }
            return null;
        }

        public int e(View view) {
            return view.getBottom() + d(view);
        }

        public static int a(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        /* access modifiers changed from: package-private */
        public void c(o oVar) {
            int e2 = oVar.e();
            for (int i2 = e2 - 1; i2 >= 0; i2--) {
                View c2 = oVar.c(i2);
                v g2 = RecyclerView.g(c2);
                if (!g2.x()) {
                    g2.a(false);
                    if (g2.r()) {
                        this.f1050b.removeDetachedView(c2, false);
                    }
                    f fVar = this.f1050b.W;
                    if (fVar != null) {
                        fVar.d(g2);
                    }
                    g2.a(true);
                    oVar.a(c2);
                }
            }
            oVar.c();
            if (e2 > 0) {
                this.f1050b.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(RecyclerView recyclerView) {
            b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f1037b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void b(RecyclerView recyclerView, o oVar) {
            c(recyclerView);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i2) {
            a(view, i2, false);
        }

        public boolean f() {
            RecyclerView recyclerView = this.f1050b;
            return recyclerView != null && recyclerView.q;
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView) {
            this.i = true;
            b(recyclerView);
        }

        public View b(int i2) {
            int e2 = e();
            for (int i3 = 0; i3 < e2; i3++) {
                View c2 = c(i3);
                v g2 = RecyclerView.g(c2);
                if (g2 != null && g2.i() == i2 && !g2.x() && (this.f1050b.qa.d() || !g2.p())) {
                    return c2;
                }
            }
            return null;
        }

        public void d(int i2) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                recyclerView.e(i2);
            }
        }

        public int f(View view) {
            return view.getLeft() - k(view);
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, o oVar) {
            this.i = false;
            b(recyclerView, oVar);
        }

        public int d(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1037b.bottom;
        }

        private boolean d(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n2 = n();
            int p2 = p();
            int q2 = q() - o();
            int h2 = h() - m();
            Rect rect = this.f1050b.s;
            b(focusedChild, rect);
            if (rect.left - i2 >= q2 || rect.right - i2 <= n2 || rect.top - i3 >= h2 || rect.bottom - i3 <= p2) {
                return false;
            }
            return true;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, int i2, int i3, LayoutParams layoutParams) {
            return !this.k || !b(view.getMeasuredWidth(), i2, layoutParams.width) || !b(view.getMeasuredHeight(), i3, layoutParams.height);
        }

        public LayoutParams a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public void c(int i2, int i3) {
            this.f1050b.setMeasuredDimension(i2, i3);
        }

        private static boolean b(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public void b(View view, Rect rect) {
            RecyclerView.a_shaKey_method2(view, rect);
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int n2 = n();
            int p2 = p();
            int q2 = q() - o();
            int h2 = h() - m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - n2;
            int min = Math.min(0, i2);
            int i3 = top - p2;
            int min2 = Math.min(0, i3);
            int i4 = width - q2;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - h2);
            if (j() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void a(View view) {
            a_shaKey_method2(view, -1);
        }

        public void a(View view, int i2) {
            a(view, i2, true);
        }

        private void a(View view, int i2, boolean z) {
            v g2 = RecyclerView.g(view);
            if (z || g2.p()) {
                this.f1050b.p.a(g2);
            } else {
                this.f1050b.p.g(g2);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (g2.z() || g2.q()) {
                if (g2.q()) {
                    g2.y();
                } else {
                    g2.c();
                }
                this.f1049a.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1050b) {
                int b2 = this.f1049a.b(view);
                if (i2 == -1) {
                    i2 = this.f1049a.a();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1050b.indexOfChild(view) + this.f1050b.i());
                } else if (b2 != i2) {
                    this.f1050b.w.a(b2, i2);
                }
            } else {
                this.f1049a.a(view, i2, false);
                layoutParams.f1038c = true;
                r rVar = this.g;
                if (rVar != null && rVar.c()) {
                    this.g.a(view);
                }
            }
            if (layoutParams.d) {
                g2.f1071b.invalidate();
                layoutParams.d = false;
            }
        }

        public void b(o oVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                if (!RecyclerView.g(c(e2)).x()) {
                    a(e2, oVar);
                }
            }
        }

        public int b(o oVar, s sVar) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView == null || recyclerView.v == null || !b()) {
                return 1;
            }
            return this.f1050b.v.a();
        }

        public void a(int i2) {
            a_shaKey_method2(i2, c(i2));
        }

        private void a(int i2, View view) {
            this.f1049a.a(i2);
        }

        public void a(View view, int i2, LayoutParams layoutParams) {
            v g2 = RecyclerView.g(view);
            if (g2.p()) {
                this.f1050b.p.a(g2);
            } else {
                this.f1050b.p.g(g2);
            }
            this.f1049a.a(view, i2, layoutParams, g2.p());
        }

        public void a(int i2, int i3) {
            View c2 = c(i2);
            if (c2 != null) {
                a(i2);
                c(c2, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f1050b.toString());
        }

        public void a(View view, o oVar) {
            o(view);
            oVar.b(view);
        }

        public void a(int i2, o oVar) {
            View c2 = c(i2);
            g(i2);
            oVar.b(c2);
        }

        public void a(o oVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                a(oVar, e2, c(e2));
            }
        }

        private void a(o oVar, int i2, View view) {
            v g2 = RecyclerView.g(view);
            if (!g2.x()) {
                if (!g2.n() || g2.p() || this.f1050b.v.b()) {
                    a(i2);
                    oVar.c(view);
                    this.f1050b.p.d(g2);
                    return;
                }
                g(i2);
                oVar.b(g2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.k || !b(view.getWidth(), i2, layoutParams.width) || !b(view.getHeight(), i3, layoutParams.height);
        }

        public void a(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect h2 = this.f1050b.h(view);
            int i4 = i2 + h2.left + h2.right;
            int i5 = i3 + h2.top + h2.bottom;
            int a2 = a(q(), r(), n() + o() + layoutParams.leftMargin + layoutParams.rightMargin + i4, layoutParams.width, a());
            int a3 = a(h(), i(), p() + m() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height, b());
            if (a(view, a2, a3, layoutParams)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i2, int i3, int i4, int i5, boolean z) {
            int i6;
            int i7 = i2 - i4;
            int i8 = 0;
            int max = Math.max(0, i7);
            if (z) {
                if (i5 < 0) {
                    if (i5 == -1) {
                        if (i3 == Integer.MIN_VALUE || (i3 != 0 && i3 == 1073741824)) {
                            i6 = max;
                        } else {
                            i3 = 0;
                            i6 = 0;
                        }
                        i8 = i3;
                        max = i6;
                        return View.MeasureSpec.makeMeasureSpec(max, i8);
                    }
                    max = 0;
                    return View.MeasureSpec.makeMeasureSpec(max, i8);
                }
            } else if (i5 < 0) {
                if (i5 == -1) {
                    i8 = i3;
                } else {
                    if (i5 == -2) {
                        if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                            i8 = Integer.MIN_VALUE;
                        }
                    }
                    max = 0;
                }
                return View.MeasureSpec.makeMeasureSpec(max, i8);
            }
            max = i5;
            i8 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(max, i8);
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f1037b;
            view.layout(i2 + rect.left + layoutParams.leftMargin, i3 + rect.top + layoutParams.topMargin, (i4 - rect.right) - layoutParams.rightMargin, (i5 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f1037b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f1050b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f1050b.u;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.h(view));
            }
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b2 = b(recyclerView, view, rect, z);
            int i2 = b2[0];
            int i3 = b2[1];
            if ((z2 && !d(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.i(i2, i3);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.e.a_shaKey_method2(view, 24579) && this.f.a_shaKey_method2(view, 24579);
            return z ? z3 : !z3;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return w() || recyclerView.n();
        }

        public boolean a(RecyclerView recyclerView, s sVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
            c(recyclerView, i2, i3);
        }

        public void a(o oVar, s sVar, int i2, int i3) {
            this.f1050b.c(i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.core.h.a.c cVar) {
            RecyclerView recyclerView = this.f1050b;
            a(recyclerView.l, recyclerView.qa, cVar);
        }

        public void a(o oVar, s sVar, androidx.core.h.a.c cVar) {
            if (this.f1050b.canScrollVertically(-1) || this.f1050b.canScrollHorizontally(-1)) {
                cVar.a((int) CpioConstants.C_ISCHR);
                cVar.k(true);
            }
            if (this.f1050b.canScrollVertically(1) || this.f1050b.canScrollHorizontally(1)) {
                cVar.a((int) CpioConstants.C_ISFIFO);
                cVar.k(true);
            }
            cVar.a((Object) c.b.a(b(oVar, sVar), a(oVar, sVar), d(oVar, sVar), c(oVar, sVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1050b;
            a(recyclerView.l, recyclerView.qa, accessibilityEvent);
        }

        public void a(o oVar, s sVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f1050b.canScrollVertically(-1) && !this.f1050b.canScrollHorizontally(-1) && !this.f1050b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                a aVar = this.f1050b.v;
                if (aVar != null) {
                    accessibilityEvent.setItemCount(aVar.a());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view, androidx.core.h.a.c cVar) {
            v g2 = RecyclerView.g(view);
            if (g2 != null && !g2.p() && !this.f1049a.c(g2.f1071b)) {
                RecyclerView recyclerView = this.f1050b;
                a(recyclerView.l, recyclerView.qa, view, cVar);
            }
        }

        public void a(o oVar, s sVar, View view, androidx.core.h.a.c cVar) {
            cVar.b((Object) c.C0014c.a(b() ? l(view) : 0, 1, a() ? l(view) : 0, 1, false, false));
        }

        public int a(o oVar, s sVar) {
            RecyclerView recyclerView = this.f1050b;
            if (recyclerView == null || recyclerView.v == null || !a()) {
                return 1;
            }
            return this.f1050b.v.a();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f1050b;
            return a(recyclerView.l, recyclerView.qa, i2, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(androidx.recyclerview.widget.RecyclerView.o r2, androidx.recyclerview.widget.RecyclerView.s r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f1050b
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L_0x0042
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x006e
            L_0x0012:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x0029
                int r2 = r1.h()
                int r5 = r1.p()
                int r2 = r2 - r5
                int r5 = r1.m()
                int r2 = r2 - r5
                int r2 = -r2
                goto L_0x002a
            L_0x0029:
                r2 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f1050b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
                int r4 = -r4
                goto L_0x006e
            L_0x0042:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L_0x0057
                int r2 = r1.h()
                int r4 = r1.p()
                int r2 = r2 - r4
                int r4 = r1.m()
                int r2 = r2 - r4
                goto L_0x0058
            L_0x0057:
                r2 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f1050b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
            L_0x006e:
                if (r2 != 0) goto L_0x0073
                if (r4 != 0) goto L_0x0073
                return r3
            L_0x0073:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f1050b
                r3.i(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.a(androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.RecyclerView$s, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f1050b;
            return a(recyclerView.l, recyclerView.qa, view, i2, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i2, int i3) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, i3);
            bVar.f1052a = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            bVar.f1053b = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            bVar.f1054c = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }
    }

    public interface j {
        void a(View view);

        void b(View view);
    }

    public static abstract class k {
        public abstract boolean a(int i, int i2);
    }

    public interface l {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class m {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public final class o {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<v> f1060a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<v> f1061b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<v> f1062c = new ArrayList<>();
        private final List<v> d = Collections.unmodifiableList(this.f1060a);
        private int e = 2;
        int f = 2;
        n g;
        private t h;

        public o() {
        }

        private void e(v vVar) {
            if (RecyclerView.this.m()) {
                View view = vVar.f1071b;
                if (androidx.core.h.t.i(view) == 0) {
                    androidx.core.h.t.d(view, 1);
                }
                if (!androidx.core.h.t.u(view)) {
                    vVar.a(16384);
                    androidx.core.h.t.a_shaKey_method2(view, RecyclerView.this.mAccessibilityDelegate.b());
                }
            }
        }

        public void a() {
            this.f1060a.clear();
            i();
        }

        /* access modifiers changed from: package-private */
        public View b(int i2, boolean z) {
            return a(i2, z, Long.MAX_VALUE).f1071b;
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            v g2 = RecyclerView.g(view);
            if (!g2.b(12) && g2.s() && !RecyclerView.this.a(g2)) {
                if (this.f1061b == null) {
                    this.f1061b = new ArrayList<>();
                }
                g2.a(this, true);
                this.f1061b.add(g2);
            } else if (!g2.n() || g2.p() || RecyclerView.this.v.b()) {
                g2.a(this, false);
                this.f1060a.add(g2);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.i());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(v vVar) {
            if (vVar.p()) {
                return RecyclerView.this.qa.d();
            }
            int i2 = vVar.d;
            if (i2 < 0 || i2 >= RecyclerView.this.v.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.i());
            } else if (!RecyclerView.this.qa.d() && RecyclerView.this.v.b(vVar.d) != vVar.h()) {
                return false;
            } else {
                if (!RecyclerView.this.v.b() || vVar.g() == RecyclerView.this.v.a(vVar.d)) {
                    return true;
                }
                return false;
            }
        }

        public void f(int i2) {
            this.e = i2;
            j();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.f1062c.size();
            for (int i2 = 0; i2 < size; i2++) {
                LayoutParams layoutParams = (LayoutParams) this.f1062c.get(i2).f1071b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f1038c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int size = this.f1062c.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.f1062c.get(i2);
                if (vVar != null) {
                    vVar.a(6);
                    vVar.a((Object) null);
                }
            }
            a aVar = RecyclerView.this.v;
            if (aVar == null || !aVar.b()) {
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            for (int size = this.f1062c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.f1062c.clear();
            if (RecyclerView.f) {
                RecyclerView.this.pa.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            i iVar = RecyclerView.this.w;
            this.f = this.e + (iVar != null ? iVar.m : 0);
            for (int size = this.f1062c.size() - 1; size >= 0 && this.f1062c.size() > this.f; size--) {
                e(size);
            }
        }

        public void b(View view) {
            v g2 = RecyclerView.g(view);
            if (g2.r()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (g2.q()) {
                g2.y();
            } else if (g2.z()) {
                g2.c();
            }
            b(g2);
        }

        private boolean a(v vVar, int i2, int i3, long j) {
            vVar.s = RecyclerView.this;
            int h2 = vVar.h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.g.a(h2, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.v.a(vVar, i2);
            this.g.a(vVar.h(), RecyclerView.this.getNanoTime() - nanoTime);
            e(vVar);
            if (!RecyclerView.this.qa.d()) {
                return true;
            }
            vVar.h = i3;
            return true;
        }

        public List<v> f() {
            return this.d;
        }

        private void f(v vVar) {
            View view = vVar.f1071b;
            if (view instanceof ViewGroup) {
                a_shaKey_method2((ViewGroup) view, false);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(v vVar) {
            boolean z;
            boolean z2 = false;
            if (vVar.q() || vVar.f1071b.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(vVar.q());
                sb.append(" isAttached:");
                if (vVar.f1071b.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb.toString());
            } else if (vVar.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.i());
            } else if (!vVar.x()) {
                boolean e2 = vVar.e();
                a aVar = RecyclerView.this.v;
                if ((aVar != null && e2 && aVar.a(vVar)) || vVar.o()) {
                    if (this.f <= 0 || vVar.b(526)) {
                        z = false;
                    } else {
                        int size = this.f1062c.size();
                        if (size >= this.f && size > 0) {
                            e(0);
                            size--;
                        }
                        if (RecyclerView.f && size > 0 && !RecyclerView.this.pa.a(vVar.d)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.pa.a(this.f1062c.get(i2).d)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f1062c.add(size, vVar);
                        z = true;
                    }
                    if (!z) {
                        a(vVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.p.h(vVar);
                if (!z && !z2 && e2) {
                    vVar.s = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.i());
            }
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            a(this.f1062c.get(i2), true);
            this.f1062c.remove(i2);
        }

        public View d(int i2) {
            return b(i2, false);
        }

        /* access modifiers changed from: package-private */
        public n d() {
            if (this.g == null) {
                this.g = new n();
            }
            return this.g;
        }

        /* access modifiers changed from: package-private */
        public void c(v vVar) {
            if (vVar.p) {
                this.f1061b.remove(vVar);
            } else {
                this.f1060a.remove(vVar);
            }
            vVar.o = null;
            vVar.p = false;
            vVar.c();
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f1060a.size();
        }

        public int a(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.qa.a()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State " + "item count is " + RecyclerView.this.qa.a() + RecyclerView.this.i());
            } else if (!RecyclerView.this.qa.d()) {
                return i2;
            } else {
                return RecyclerView.this.n.b(i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a6  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0210  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.v a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x0233
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r1 = r1.qa
                int r1 = r1.a()
                if (r3 >= r1) goto L_0x0233
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r1 = r1.qa
                boolean r1 = r1.d()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$v r1 = r16.b((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$v r1 = r16.a((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.d((androidx.recyclerview.widget.RecyclerView.v) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.a((int) r5)
                boolean r5 = r1.q()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.f1071b
                r5.removeDetachedView(r9, r8)
                r1.y()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.z()
                if (r5 == 0) goto L_0x0057
                r1.c()
            L_0x0057:
                r6.b((androidx.recyclerview.widget.RecyclerView.v) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0185
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.n
                int r5 = r5.b((int) r3)
                if (r5 < 0) goto L_0x0148
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.v
                int r9 = r9.a()
                if (r5 >= r9) goto L_0x0148
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.v
                int r9 = r9.b((int) r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r10 = r10.v
                boolean r10 = r10.b()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r1 = r1.v
                long r10 = r1.a((int) r5)
                androidx.recyclerview.widget.RecyclerView$v r1 = r6.a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.d = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$t r0 = r6.h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$v r1 = r1.f((android.view.View) r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.x()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0101
                androidx.recyclerview.widget.RecyclerView$n r0 = r16.d()
                androidx.recyclerview.widget.RecyclerView$v r1 = r0.a((int) r9)
                if (r1 == 0) goto L_0x0101
                r1.u()
                boolean r0 = androidx.recyclerview.widget.RecyclerView.f1035c
                if (r0 == 0) goto L_0x0101
                r6.f((androidx.recyclerview.widget.RecyclerView.v) r1)
            L_0x0101:
                if (r1 != 0) goto L_0x0185
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x011f
                androidx.recyclerview.widget.RecyclerView$n r10 = r6.g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.b(r11, r12, r14)
                if (r5 != 0) goto L_0x011f
                return r2
            L_0x011f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r5 = r2.v
                androidx.recyclerview.widget.RecyclerView$v r2 = r5.a((android.view.ViewGroup) r2, (int) r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.f
                if (r5 == 0) goto L_0x013a
                android.view.View r5 = r2.f1071b
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.e((android.view.View) r5)
                if (r5 == 0) goto L_0x013a
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.f1072c = r10
            L_0x013a:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$n r5 = r6.g
                long r10 = r10 - r0
                r5.b(r9, r10)
                r10 = r2
                goto L_0x0186
            L_0x0148:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ")."
                r1.append(r2)
                java.lang.String r2 = "state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.qa
                int r2 = r2.a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0185:
                r10 = r1
            L_0x0186:
                r9 = r4
                if (r9 == 0) goto L_0x01bf
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.qa
                boolean r0 = r0.d()
                if (r0 != 0) goto L_0x01bf
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.b((int) r0)
                if (r1 == 0) goto L_0x01bf
                r10.a((int) r8, (int) r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.qa
                boolean r0 = r0.k
                if (r0 == 0) goto L_0x01bf
                int r0 = androidx.recyclerview.widget.RecyclerView.f.a((androidx.recyclerview.widget.RecyclerView.v) r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$f r2 = r1.W
                androidx.recyclerview.widget.RecyclerView$s r1 = r1.qa
                java.util.List r4 = r10.k()
                androidx.recyclerview.widget.RecyclerView$f$c r0 = r2.a((androidx.recyclerview.widget.RecyclerView.s) r1, (androidx.recyclerview.widget.RecyclerView.v) r10, (int) r0, (java.util.List<java.lang.Object>) r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((androidx.recyclerview.widget.RecyclerView.v) r10, (androidx.recyclerview.widget.RecyclerView.f.c) r0)
            L_0x01bf:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.qa
                boolean r0 = r0.d()
                if (r0 == 0) goto L_0x01d2
                boolean r0 = r10.m()
                if (r0 == 0) goto L_0x01d2
                r10.h = r3
                goto L_0x01e5
            L_0x01d2:
                boolean r0 = r10.m()
                if (r0 == 0) goto L_0x01e7
                boolean r0 = r10.t()
                if (r0 != 0) goto L_0x01e7
                boolean r0 = r10.n()
                if (r0 == 0) goto L_0x01e5
                goto L_0x01e7
            L_0x01e5:
                r0 = 0
                goto L_0x01fa
            L_0x01e7:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.n
                int r2 = r0.b((int) r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.a(r1, r2, r3, r4)
            L_0x01fa:
                android.view.View r1 = r10.f1071b
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0210
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r10.f1071b
                r2.setLayoutParams(r1)
                goto L_0x0228
            L_0x0210:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0226
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r10.f1071b
                r2.setLayoutParams(r1)
                goto L_0x0228
            L_0x0226:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0228:
                r1.f1036a = r10
                if (r9 == 0) goto L_0x022f
                if (r0 == 0) goto L_0x022f
                goto L_0x0230
            L_0x022f:
                r7 = 0
            L_0x0230:
                r1.d = r7
                return r10
            L_0x0233:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.qa
                int r2 = r2.a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$v");
        }

        /* access modifiers changed from: package-private */
        public View c(int i2) {
            return this.f1060a.get(i2).f1071b;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f1060a.clear();
            ArrayList<v> arrayList = this.f1061b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f1062c.size() - 1; size >= 0; size--) {
                v vVar = this.f1062c.get(size);
                if (vVar != null && (i4 = vVar.d) >= i2 && i4 < i5) {
                    vVar.a(2);
                    e(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public v b(int i2) {
            int size;
            int b2;
            ArrayList<v> arrayList = this.f1061b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    v vVar = this.f1061b.get(i4);
                    if (vVar.z() || vVar.i() != i2) {
                        i4++;
                    } else {
                        vVar.a(32);
                        return vVar;
                    }
                }
                if (RecyclerView.this.v.b() && (b2 = RecyclerView.this.n.b(i2)) > 0 && b2 < RecyclerView.this.v.a()) {
                    long a2 = RecyclerView.this.v.a(b2);
                    while (i3 < size) {
                        v vVar2 = this.f1061b.get(i3);
                        if (vVar2.z() || vVar2.g() != a2) {
                            i3++;
                        } else {
                            vVar2.a(32);
                            return vVar2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i6 = i2;
                i5 = i3;
                i4 = -1;
            } else {
                i5 = i2;
                i6 = i3;
                i4 = 1;
            }
            int size = this.f1062c.size();
            for (int i8 = 0; i8 < size; i8++) {
                v vVar = this.f1062c.get(i8);
                if (vVar != null && (i7 = vVar.d) >= i6 && i7 <= i5) {
                    if (i7 == i2) {
                        vVar.a(i3 - i2, false);
                    } else {
                        vVar.a(i4, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int size = this.f1062c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1062c.get(i2).a();
            }
            int size2 = this.f1060a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f1060a.get(i3).a();
            }
            ArrayList<v> arrayList = this.f1061b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f1061b.get(i4).a();
                }
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a_shaKey_method2((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(v vVar, boolean z) {
            RecyclerView.b(vVar);
            if (vVar.b(16384)) {
                vVar.a(0, 16384);
                androidx.core.h.t.a_shaKey_method2(vVar.f1071b, (C0083a) null);
            }
            if (z) {
                a(vVar);
            }
            vVar.s = null;
            d().a(vVar);
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            v g2 = RecyclerView.g(view);
            g2.o = null;
            g2.p = false;
            g2.c();
            b(g2);
        }

        /* access modifiers changed from: package-private */
        public v a(int i2, boolean z) {
            View b2;
            int size = this.f1060a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                v vVar = this.f1060a.get(i4);
                if (vVar.z() || vVar.i() != i2 || vVar.n() || (!RecyclerView.this.qa.h && vVar.p())) {
                    i4++;
                } else {
                    vVar.a(32);
                    return vVar;
                }
            }
            if (z || (b2 = RecyclerView.this.o.b(i2)) == null) {
                int size2 = this.f1062c.size();
                while (i3 < size2) {
                    v vVar2 = this.f1062c.get(i3);
                    if (vVar2.n() || vVar2.i() != i2) {
                        i3++;
                    } else {
                        if (!z) {
                            this.f1062c.remove(i3);
                        }
                        return vVar2;
                    }
                }
                return null;
            }
            v g2 = RecyclerView.g(b2);
            RecyclerView.this.o.f(b2);
            int b3 = RecyclerView.this.o.b(b2);
            if (b3 != -1) {
                RecyclerView.this.o.a(b3);
                c(b2);
                g2.a(8224);
                return g2;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + g2 + RecyclerView.this.i());
        }

        /* access modifiers changed from: package-private */
        public v a(long j, int i2, boolean z) {
            for (int size = this.f1060a.size() - 1; size >= 0; size--) {
                v vVar = this.f1060a.get(size);
                if (vVar.g() == j && !vVar.z()) {
                    if (i2 == vVar.h()) {
                        vVar.a(32);
                        if (vVar.p() && !RecyclerView.this.qa.d()) {
                            vVar.a(2, 14);
                        }
                        return vVar;
                    } else if (!z) {
                        this.f1060a.remove(size);
                        RecyclerView.this.removeDetachedView(vVar.f1071b, false);
                        a(vVar.f1071b);
                    }
                }
            }
            int size2 = this.f1062c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.f1062c.get(size2);
                if (vVar2.g() == j) {
                    if (i2 == vVar2.h()) {
                        if (!z) {
                            this.f1062c.remove(size2);
                        }
                        return vVar2;
                    } else if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(v vVar) {
            p pVar = RecyclerView.this.x;
            if (pVar != null) {
                pVar.a(vVar);
            }
            a aVar = RecyclerView.this.v;
            if (aVar != null) {
                aVar.d(vVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.qa != null) {
                recyclerView.p.h(vVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            a();
            d().a(aVar, aVar2, z);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            int size = this.f1062c.size();
            for (int i4 = 0; i4 < size; i4++) {
                v vVar = this.f1062c.get(i4);
                if (vVar != null && vVar.d >= i2) {
                    vVar.a(i3, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f1062c.size() - 1; size >= 0; size--) {
                v vVar = this.f1062c.get(size);
                if (vVar != null) {
                    int i5 = vVar.d;
                    if (i5 >= i4) {
                        vVar.a(-i3, z);
                    } else if (i5 >= i2) {
                        vVar.a(8);
                        e(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(t tVar) {
            this.h = tVar;
        }

        /* access modifiers changed from: package-private */
        public void a(n nVar) {
            n nVar2 = this.g;
            if (nVar2 != null) {
                nVar2.c();
            }
            this.g = nVar;
            if (this.g != null && RecyclerView.this.getAdapter() != null) {
                this.g.a();
            }
        }
    }

    public interface p {
        void a(v vVar);
    }

    private class q extends c {
        q() {
        }

        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.qa.g = true;
            recyclerView.b(true);
            if (!RecyclerView.this.n.c()) {
                RecyclerView.this.requestLayout();
            }
        }
    }

    public static abstract class r {

        public interface a {
        }

        public abstract int a();

        public abstract void a(int i);

        /* access modifiers changed from: package-private */
        public abstract void a(int i, int i2);

        /* access modifiers changed from: protected */
        public abstract void a(View view);

        public abstract boolean b();

        public abstract boolean c();

        /* access modifiers changed from: protected */
        public final void d() {
            throw null;
        }
    }

    public static abstract class t {
        public abstract View a(o oVar, int i, int i2);
    }

    public static abstract class v {

        /* renamed from: a  reason: collision with root package name */
        private static final List<Object> f1070a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public final View f1071b;

        /* renamed from: c  reason: collision with root package name */
        WeakReference<RecyclerView> f1072c;
        int d = -1;
        int e = -1;
        long f = -1;
        int g = -1;
        int h = -1;
        v i = null;
        v j = null;
        int k;
        List<Object> l = null;
        List<Object> m = null;
        private int n = 0;
        o o = null;
        boolean p = false;
        private int q = 0;
        int r = -1;
        RecyclerView s;

        public v(View view) {
            if (view != null) {
                this.f1071b = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void A() {
            if (this.l == null) {
                this.l = new ArrayList();
                this.m = Collections.unmodifiableList(this.l);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            a(8);
            a(i3, z);
            this.d = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            return (i2 & this.k) != 0;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.k &= -33;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.k &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return (this.k & 16) == 0 && androidx.core.h.t.x(this.f1071b);
        }

        public final int f() {
            RecyclerView recyclerView = this.s;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final long g() {
            return this.f;
        }

        public final int h() {
            return this.g;
        }

        public final int i() {
            int i2 = this.h;
            return i2 == -1 ? this.d : i2;
        }

        public final int j() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public List<Object> k() {
            if ((this.k & 1024) != 0) {
                return f1070a;
            }
            List<Object> list = this.l;
            if (list == null || list.size() == 0) {
                return f1070a;
            }
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public boolean l() {
            return (this.k & 512) != 0 || n();
        }

        /* access modifiers changed from: package-private */
        public boolean m() {
            return (this.k & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return (this.k & 4) != 0;
        }

        public final boolean o() {
            return (this.k & 16) == 0 && !androidx.core.h.t.x(this.f1071b);
        }

        /* access modifiers changed from: package-private */
        public boolean p() {
            return (this.k & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean q() {
            return this.o != null;
        }

        /* access modifiers changed from: package-private */
        public boolean r() {
            return (this.k & CpioConstants.C_IRUSR) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean s() {
            return (this.k & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean t() {
            return (this.k & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.d + " id=" + this.f + ", oldPos=" + this.e + ", pLpos:" + this.h);
            if (q()) {
                sb.append(" scrap ");
                sb.append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                sb.append(" invalid");
            }
            if (!m()) {
                sb.append(" unbound");
            }
            if (t()) {
                sb.append(" update");
            }
            if (p()) {
                sb.append(" removed");
            }
            if (x()) {
                sb.append(" ignored");
            }
            if (r()) {
                sb.append(" tmpDetached");
            }
            if (!o()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if (l()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1071b.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void u() {
            this.k = 0;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.h = -1;
            this.n = 0;
            this.i = null;
            this.j = null;
            b();
            this.q = 0;
            this.r = -1;
            RecyclerView.b(this);
        }

        /* access modifiers changed from: package-private */
        public void v() {
            if (this.e == -1) {
                this.e = this.d;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean w() {
            return (this.k & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean x() {
            return (this.k & CpioConstants.C_IWUSR) != 0;
        }

        /* access modifiers changed from: package-private */
        public void y() {
            this.o.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean z() {
            return (this.k & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            List<Object> list = this.l;
            if (list != null) {
                list.clear();
            }
            this.k &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, boolean z) {
            if (this.e == -1) {
                this.e = this.d;
            }
            if (this.h == -1) {
                this.h = this.d;
            }
            if (z) {
                this.h += i2;
            }
            this.d += i2;
            if (this.f1071b.getLayoutParams() != null) {
                ((LayoutParams) this.f1071b.getLayoutParams()).f1038c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.q);
            this.q = 0;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.e = -1;
            this.h = -1;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, boolean z) {
            this.o = oVar;
            this.p = z;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.k = (i2 & i3) | (this.k & (i3 ^ -1));
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.k = i2 | this.k;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.k) == 0) {
                A();
                this.l.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView) {
            int i2 = this.r;
            if (i2 != -1) {
                this.q = i2;
            } else {
                this.q = androidx.core.h.t.i(this.f1071b);
            }
            recyclerView.a(this, 4);
        }

        public final void a(boolean z) {
            this.n = z ? this.n - 1 : this.n + 1;
            int i2 = this.n;
            if (i2 < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.k |= 16;
            } else if (z && this.n == 0) {
                this.k &= -17;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 16843830(0x1010436, float:2.369658E-38)
            r1[r2] = r3
            f1033a = r1
            int[] r1 = new int[r0]
            r3 = 16842987(0x10100eb, float:2.3694217E-38)
            r1[r2] = r3
            f1034b = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 18
            if (r1 == r3) goto L_0x0025
            r3 = 19
            if (r1 == r3) goto L_0x0025
            r3 = 20
            if (r1 != r3) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r1 = 0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            f1035c = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 < r3) goto L_0x0030
            r1 = 1
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            d = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r1 < r3) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            e = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r1 < r3) goto L_0x0046
            r1 = 1
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            f = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 15
            if (r1 > r3) goto L_0x0051
            r1 = 1
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            g = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 > r3) goto L_0x005a
            r1 = 1
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            h = r1
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r1[r2] = r3
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            r0 = 2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r1[r0] = r2
            r0 = 3
            r1[r0] = r2
            i = r1
            androidx.recyclerview.widget.z r0 = new androidx.recyclerview.widget.z
            r0.<init>()
            j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void A() {
        boolean z2 = true;
        this.qa.a(1);
        a(this.qa);
        this.qa.j = false;
        w();
        this.p.a();
        q();
        I();
        N();
        s sVar = this.qa;
        if (!sVar.k || !this.ua) {
            z2 = false;
        }
        sVar.i = z2;
        this.ua = false;
        this.ta = false;
        s sVar2 = this.qa;
        sVar2.h = sVar2.l;
        sVar2.f = this.v.a();
        a(this.ya);
        if (this.qa.k) {
            int a2 = this.o.a();
            for (int i2 = 0; i2 < a2; i2++) {
                v g2 = g(this.o.c(i2));
                if (!g2.x() && (!g2.n() || this.v.b())) {
                    this.p.c(g2, this.W.a(this.qa, g2, f.a(g2), g2.k()));
                    if (this.qa.i && g2.s() && !g2.p() && !g2.x() && !g2.n()) {
                        this.p.a(d(g2), g2);
                    }
                }
            }
        }
        if (this.qa.l) {
            v();
            s sVar3 = this.qa;
            boolean z3 = sVar3.g;
            sVar3.g = false;
            this.w.e(this.l, sVar3);
            this.qa.g = z3;
            for (int i3 = 0; i3 < this.o.a(); i3++) {
                v g3 = g(this.o.c(i3));
                if (!g3.x() && !this.p.c(g3)) {
                    int a3 = f.a(g3);
                    boolean b2 = g3.b((int) CpioConstants.C_ISCHR);
                    if (!b2) {
                        a3 |= CpioConstants.C_ISFIFO;
                    }
                    f.c a4 = this.W.a(this.qa, g3, a3, g3.k());
                    if (b2) {
                        a(g3, a4);
                    } else {
                        this.p.a(g3, a4);
                    }
                }
            }
            a();
        } else {
            a();
        }
        r();
        c(false);
        this.qa.e = 2;
    }

    private void B() {
        w();
        q();
        this.qa.a(6);
        this.n.b();
        this.qa.f = this.v.a();
        s sVar = this.qa;
        sVar.d = 0;
        sVar.h = false;
        this.w.e(this.l, sVar);
        s sVar2 = this.qa;
        sVar2.g = false;
        this.m = null;
        sVar2.k = sVar2.k && this.W != null;
        this.qa.e = 4;
        r();
        c(false);
    }

    private void C() {
        this.qa.a(4);
        w();
        q();
        s sVar = this.qa;
        sVar.e = 1;
        if (sVar.k) {
            for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
                v g2 = g(this.o.c(a2));
                if (!g2.x()) {
                    long d2 = d(g2);
                    f.c a3 = this.W.a(this.qa, g2);
                    v a4 = this.p.a(d2);
                    if (a4 == null || a4.x()) {
                        this.p.b(g2, a3);
                    } else {
                        boolean b2 = this.p.b(a4);
                        boolean b3 = this.p.b(g2);
                        if (!b2 || a4 != g2) {
                            f.c f2 = this.p.f(a4);
                            this.p.b(g2, a3);
                            f.c e2 = this.p.e(g2);
                            if (f2 == null) {
                                a(d2, g2, a4);
                            } else {
                                a(a4, g2, f2, e2, b2, b3);
                            }
                        } else {
                            this.p.b(g2, a3);
                        }
                    }
                }
            }
            this.p.a(this.Ga);
        }
        this.w.c(this.l);
        s sVar2 = this.qa;
        sVar2.f1066c = sVar2.f;
        this.N = false;
        this.O = false;
        sVar2.k = false;
        sVar2.l = false;
        this.w.h = false;
        ArrayList<v> arrayList = this.l.f1061b;
        if (arrayList != null) {
            arrayList.clear();
        }
        i iVar = this.w;
        if (iVar.n) {
            iVar.m = 0;
            iVar.n = false;
            this.l.j();
        }
        this.w.g(this.qa);
        r();
        c(false);
        this.p.a();
        int[] iArr = this.ya;
        if (k(iArr[0], iArr[1])) {
            d(0, 0);
        }
        J();
        L();
    }

    private View D() {
        v c2;
        int i2 = this.qa.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int a2 = this.qa.a();
        int i3 = i2;
        while (i3 < a2) {
            v c3 = c(i3);
            if (c3 == null) {
                break;
            } else if (c3.f1071b.hasFocusable()) {
                return c3.f1071b;
            } else {
                i3++;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0 || (c2 = c(min)) == null) {
                return null;
            }
            if (c2.f1071b.hasFocusable()) {
                return c2.f1071b;
            }
        }
    }

    private boolean E() {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            v g2 = g(this.o.c(i2));
            if (g2 != null && !g2.x() && g2.s()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void F() {
        if (androidx.core.h.t.j(this) == 0) {
            androidx.core.h.t.e(this, 8);
        }
    }

    private void G() {
        this.o = new C0105b(new B(this));
    }

    private boolean H() {
        return this.W != null && this.w.C();
    }

    private void I() {
        if (this.N) {
            this.n.f();
            if (this.O) {
                this.w.d(this);
            }
        }
        if (H()) {
            this.n.e();
        } else {
            this.n.b();
        }
        boolean z2 = false;
        boolean z3 = this.ta || this.ua;
        this.qa.k = this.E && this.W != null && (this.N || z3 || this.w.h) && (!this.N || this.v.b());
        s sVar = this.qa;
        if (sVar.k && z3 && !this.N && H()) {
            z2 = true;
        }
        sVar.l = z2;
    }

    private void J() {
        View view;
        if (this.ma && this.v != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!h || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.o.c(focusedChild)) {
                            return;
                        }
                    } else if (this.o.a() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                v a2 = (this.qa.n == -1 || !this.v.b()) ? null : a(this.qa.n);
                if (a2 != null && !this.o.c(a2.f1071b) && a2.f1071b.hasFocusable()) {
                    view2 = a2.f1071b;
                } else if (this.o.a() > 0) {
                    view2 = D();
                }
                if (view2 != null) {
                    int i2 = this.qa.o;
                    if (((long) i2) == -1 || (view = view2.findViewById(i2)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void K() {
        boolean z2;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.S.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.V.isFinished();
        }
        if (z2) {
            androidx.core.h.t.C(this);
        }
    }

    private void L() {
        s sVar = this.qa;
        sVar.n = -1;
        sVar.m = -1;
        sVar.o = -1;
    }

    private void M() {
        VelocityTracker velocityTracker = this.ca;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        a(0);
        K();
    }

    private void N() {
        int i2;
        v vVar = null;
        View focusedChild = (!this.ma || !hasFocus() || this.v == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            vVar = d(focusedChild);
        }
        if (vVar == null) {
            L();
            return;
        }
        this.qa.n = this.v.b() ? vVar.g() : -1;
        s sVar = this.qa;
        if (this.N) {
            i2 = -1;
        } else if (vVar.p()) {
            i2 = vVar.e;
        } else {
            i2 = vVar.f();
        }
        sVar.m = i2;
        this.qa.o = l(vVar.f1071b);
    }

    private void O() {
        this.na.b();
        i iVar = this.w;
        if (iVar != null) {
            iVar.B();
        }
    }

    private void e(v vVar) {
        View view = vVar.f1071b;
        boolean z2 = view.getParent() == this;
        this.l.c(f(view));
        if (vVar.r()) {
            this.o.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.o.a_shaKey_method2(view, true);
        } else {
            this.o.a(view);
        }
    }

    private androidx.core.h.k getScrollingChildHelper() {
        if (this.za == null) {
            this.za = new androidx.core.h.k(this);
        }
        return this.za;
    }

    private void y() {
        M();
        setScrollState(0);
    }

    private void z() {
        int i2 = this.J;
        this.J = 0;
        if (i2 != 0 && m()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            androidx.core.h.a.a.a_shaKey_method2(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.w;
        if (iVar == null || !iVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addOnChildAttachStateChangeListener(j jVar) {
        if (this.M == null) {
            this.M = new ArrayList();
        }
        this.M.add(jVar);
    }

    public void addOnItemTouchListener(l lVar) {
        this.z.add(lVar);
    }

    public void addOnScrollListener(m mVar) {
        if (this.sa == null) {
            this.sa = new ArrayList();
        }
        this.sa.add(mVar);
    }

    public void b(h hVar) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.y.remove(hVar);
        if (this.y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        o();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        if (this.F < 1) {
            this.F = 1;
        }
        if (!z2 && !this.H) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z2 && this.G && !this.H && this.w != null && this.v != null) {
                c();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.w.a((LayoutParams) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.a(this.qa);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.b(this.qa);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.c(this.qa);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.d(this.qa);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.e(this.qa);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.f(this.qa);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public long d(v vVar) {
        return this.v.b() ? vVar.g() : (long) vVar.d;
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.y.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).b(canvas, this, this.qa);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.q ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.q) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.q ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.U;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.q) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.W != null && this.y.size() > 0 && this.W.g()) {
            z3 = true;
        }
        if (z3) {
            androidx.core.h.t.C(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.S == null) {
            this.S = this.R.a(this, 0);
            if (this.q) {
                this.S.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.S.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.w.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = this.v != null && this.w != null && !n() && !this.H;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                view2 = this.w.a(view, i2, this.l, this.qa);
                c(false);
            }
        } else {
            if (this.w.b()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (g) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.w.a()) {
                int i4 = (this.w.j() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i4) == null;
                if (g) {
                    i2 = i4;
                }
            }
            if (z2) {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                this.w.a(view, i2, this.l, this.qa);
                c(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a_shaKey_method2(view2, (View) null);
        return view;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.U == null) {
            this.U = this.R.a(this, 2);
            if (this.q) {
                this.U.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.U.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void g(int i2) {
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a_shaKey_method2(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    public a getAdapter() {
        return this.v;
    }

    public int getBaseline() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.d();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.xa;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.q;
    }

    public G getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public e getEdgeEffectFactory() {
        return this.R;
    }

    public f getItemAnimator() {
        return this.W;
    }

    public int getItemDecorationCount() {
        return this.y.size();
    }

    public i getLayoutManager() {
        return this.w;
    }

    public int getMaxFlingVelocity() {
        return this.ja;
    }

    public int getMinFlingVelocity() {
        return this.ia;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f) {
            return System.nanoTime();
        }
        return 0;
    }

    public k getOnFlingListener() {
        return this.ha;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ma;
    }

    public n getRecycledViewPool() {
        return this.l.d();
    }

    public int getScrollState() {
        return this.aa;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.T == null) {
            this.T = this.R.a(this, 1);
            if (this.q) {
                this.T.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.T.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void h(int i2, int i3) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return " " + super.toString() + ", adapter:" + this.v + ", layout:" + this.w + ", context:" + getContext();
    }

    public void i(View view) {
    }

    public boolean isAttachedToWindow() {
        return this.B;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    public void j(View view) {
    }

    public boolean j() {
        return !this.E || this.N || this.n.c();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.n = new C0104a(new C(this));
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        AccessibilityManager accessibilityManager = this.L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean n() {
        return this.P > 0;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((LayoutParams) this.o.d(i2).getLayoutParams()).f1038c = true;
        }
        this.l.g();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.P = r0
            r1 = 1
            r4.B = r1
            boolean r2 = r4.E
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.E = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.w
            if (r1 == 0) goto L_0x001e
            r1.a((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x001e:
            r4.wa = r0
            boolean r0 = f
            if (r0 == 0) goto L_0x0067
            java.lang.ThreadLocal<androidx.recyclerview.widget.p> r0 = androidx.recyclerview.widget.p.f1133a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.p r0 = (androidx.recyclerview.widget.p) r0
            r4.oa = r0
            androidx.recyclerview.widget.p r0 = r4.oa
            if (r0 != 0) goto L_0x0062
            androidx.recyclerview.widget.p r0 = new androidx.recyclerview.widget.p
            r0.<init>()
            r4.oa = r0
            android.view.Display r0 = androidx.core.h.t.f(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0054:
            androidx.recyclerview.widget.p r1 = r4.oa
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.e = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.p> r0 = androidx.recyclerview.widget.p.f1133a
            r0.set(r1)
        L_0x0062:
            androidx.recyclerview.widget.p r0 = r4.oa
            r0.a((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        p pVar;
        super.onDetachedFromWindow();
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        x();
        this.B = false;
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(this, this.l);
        }
        this.Ea.clear();
        removeCallbacks(this.Fa);
        this.p.b();
        if (f && (pVar = this.oa) != null) {
            pVar.b(this);
            this.oa = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).a(canvas, this, this.qa);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.w != null && !this.H && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.w.b() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.w.a()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        a((int) (f2 * this.ka), (int) (f3 * this.la), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.w.b()) {
                        f3 = -axisValue;
                    } else if (this.w.a()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        a((int) (f2 * this.ka), (int) (f3 * this.la), motionEvent);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            a((int) (f2 * this.ka), (int) (f3 * this.la), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.H) {
            return false;
        }
        if (b(motionEvent)) {
            y();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean a2 = iVar.a();
        boolean b2 = this.w.b();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        this.ca.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.ba = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ga = y2;
            this.ea = y2;
            if (this.aa == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.Ca;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = a2 ? 1 : 0;
            if (b2) {
                i2 |= 2;
            }
            j(i2, 0);
        } else if (actionMasked == 1) {
            this.ca.clear();
            a(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ba + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.aa != 1) {
                int i3 = x3 - this.da;
                int i4 = y3 - this.ea;
                if (!a2 || Math.abs(i3) <= this.mTouchSlop) {
                    z2 = false;
                } else {
                    this.fa = x3;
                    z2 = true;
                }
                if (b2 && Math.abs(i4) > this.mTouchSlop) {
                    this.ga = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x4;
            this.da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y4;
            this.ea = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (this.aa == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.d.a.a("RV OnLayout");
        c();
        androidx.core.d.a.a();
        this.E = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            c(i2, i3);
            return;
        }
        boolean z2 = false;
        if (iVar.u()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.w.a(this.l, this.qa, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.v != null) {
                if (this.qa.e == 1) {
                    A();
                }
                this.w.b(i2, i3);
                this.qa.j = true;
                B();
                this.w.d(i2, i3);
                if (this.w.A()) {
                    this.w.b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.qa.j = true;
                    B();
                    this.w.d(i2, i3);
                }
            }
        } else if (this.C) {
            this.w.a(this.l, this.qa, i2, i3);
        } else {
            if (this.K) {
                w();
                q();
                I();
                r();
                s sVar = this.qa;
                if (sVar.l) {
                    sVar.h = true;
                } else {
                    this.n.b();
                    this.qa.h = false;
                }
                this.K = false;
                c(false);
            } else if (this.qa.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.v;
            if (aVar != null) {
                this.qa.f = aVar.a();
            } else {
                this.qa.f = 0;
            }
            w();
            this.w.a(this.l, this.qa, i2, i3);
            c(false);
            this.qa.h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (n()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.m = (SavedState) parcelable;
        super.onRestoreInstanceState(this.m.a());
        i iVar = this.w;
        if (iVar != null && (parcelable2 = this.m.f1039c) != null) {
            iVar.a(parcelable2);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.m;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            i iVar = this.w;
            if (iVar != null) {
                savedState.f1039c = iVar.x();
            } else {
                savedState.f1039c = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            l();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3 = false;
        if (this.H || this.I) {
            return false;
        }
        if (a(motionEvent)) {
            y();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean a2 = iVar.a();
        boolean b2 = this.w.b();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.Ca;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.Ca;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.ba = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ga = y2;
            this.ea = y2;
            int i6 = a2 ? 1 : 0;
            if (b2) {
                i6 |= 2;
            }
            j(i6, 0);
        } else if (actionMasked == 1) {
            this.ca.addMovement(obtain);
            this.ca.computeCurrentVelocity(TarArchiveEntry.MILLIS_PER_SECOND, (float) this.ja);
            float f2 = a2 ? -this.ca.getXVelocity(this.ba) : 0.0f;
            float f3 = b2 ? -this.ca.getYVelocity(this.ba) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !e((int) f2, (int) f3)) {
                setScrollState(0);
            }
            M();
            z3 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ba + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i7 = this.fa - x3;
            int i8 = this.ga - y3;
            if (a(i7, i8, this.Ba, this.Aa, 0)) {
                int[] iArr3 = this.Ba;
                i7 -= iArr3[0];
                i8 -= iArr3[1];
                int[] iArr4 = this.Aa;
                obtain.offsetLocation((float) iArr4[0], (float) iArr4[1]);
                int[] iArr5 = this.Ca;
                int i9 = iArr5[0];
                int[] iArr6 = this.Aa;
                iArr5[0] = i9 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.aa != 1) {
                if (!a2 || Math.abs(i3) <= (i5 = this.mTouchSlop)) {
                    z2 = false;
                } else {
                    i3 = i3 > 0 ? i3 - i5 : i3 + i5;
                    z2 = true;
                }
                if (b2 && Math.abs(i2) > (i4 = this.mTouchSlop)) {
                    i2 = i2 > 0 ? i2 - i4 : i2 + i4;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
            if (this.aa == 1) {
                int[] iArr7 = this.Aa;
                this.fa = x3 - iArr7[0];
                this.ga = y3 - iArr7[1];
                if (a(a2 ? i3 : 0, b2 ? i2 : 0, obtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.oa == null || (i3 == 0 && i2 == 0))) {
                    this.oa.a(this, i3, i2);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x4;
            this.da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y4;
            this.ea = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (!z3) {
            this.ca.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v g2 = g(this.o.d(i2));
            if (g2 != null && !g2.x()) {
                g2.a(6);
            }
        }
        o();
        this.l.h();
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.P++;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        a(true);
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        v g2 = g(view);
        if (g2 != null) {
            if (g2.r()) {
                g2.d();
            } else if (!g2.x()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + g2 + i());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z2);
    }

    public void removeOnChildAttachStateChangeListener(j jVar) {
        List<j> list = this.M;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public void removeOnItemTouchListener(l lVar) {
        this.z.remove(lVar);
        if (this.A == lVar) {
            this.A = null;
        }
    }

    public void removeOnScrollListener(m mVar) {
        List<m> list = this.sa;
        if (list != null) {
            list.remove(mVar);
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.w.a(this, this.qa, view, view2) && view2 != null) {
            a_shaKey_method2(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.w.a(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.z.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.F != 0 || this.H) {
            this.G = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (!this.wa && this.B) {
            androidx.core.h.t.a_shaKey_method2((View) this, this.Fa);
            this.wa = true;
        }
    }

    public void scrollBy(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.H) {
            boolean a2 = iVar.a();
            boolean b2 = this.w.b();
            if (a2 || b2) {
                if (!a2) {
                    i2 = 0;
                }
                if (!b2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(G g2) {
        this.mAccessibilityDelegate = g2;
        androidx.core.h.t.a_shaKey_method2((View) this, (C0083a) this.mAccessibilityDelegate);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.xa) {
            this.xa = dVar;
            setChildrenDrawingOrderEnabled(this.xa != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.q) {
            l();
        }
        this.q = z2;
        super.setClipToPadding(z2);
        if (this.E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.g.h.a(eVar);
        this.R = eVar;
        l();
    }

    public void setHasFixedSize(boolean z2) {
        this.C = z2;
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.b();
            this.W.a((f.b) null);
        }
        this.W = fVar;
        f fVar3 = this.W;
        if (fVar3 != null) {
            fVar3.a(this.va);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.l.f(i2);
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.H) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (!z2) {
                this.H = false;
                if (!(!this.G || this.w == null || this.v == null)) {
                    requestLayout();
                }
                this.G = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.H = true;
            this.I = true;
            x();
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.w) {
            x();
            if (this.w != null) {
                f fVar = this.W;
                if (fVar != null) {
                    fVar.b();
                }
                this.w.b(this.l);
                this.w.c(this.l);
                this.l.a();
                if (this.B) {
                    this.w.a(this, this.l);
                }
                this.w.f((RecyclerView) null);
                this.w = null;
            } else {
                this.l.a();
            }
            this.o.c();
            this.w = iVar;
            if (iVar != null) {
                if (iVar.f1050b == null) {
                    this.w.f(this);
                    if (this.B) {
                        this.w.a(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.f1050b.i());
                }
            }
            this.l.j();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public void setOnFlingListener(k kVar) {
        this.ha = kVar;
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.ra = mVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.ma = z2;
    }

    public void setRecycledViewPool(n nVar) {
        this.l.a(nVar);
    }

    public void setRecyclerListener(p pVar) {
        this.x = pVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.aa) {
            this.aa = i2;
            if (i2 != 2) {
                O();
            }
            b(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(t tVar) {
        this.l.a(tVar);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    /* access modifiers changed from: package-private */
    public void t() {
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.b(this.l);
            this.w.c(this.l);
        }
        this.l.a();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        v vVar;
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.o.c(i2);
            v f2 = f(c2);
            if (!(f2 == null || (vVar = f2.j) == null)) {
                View view = vVar.f1071b;
                int left = c2.getLeft();
                int top = c2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v g2 = g(this.o.d(i2));
            if (!g2.x()) {
                g2.v();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.F++;
        if (this.F == 1 && !this.H) {
            this.G = false;
        }
    }

    public void x() {
        setScrollState(0);
        O();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int l(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public v d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return f(c2);
    }

    /* access modifiers changed from: package-private */
    public boolean k(View view) {
        w();
        boolean e2 = this.o.e(view);
        if (e2) {
            v g2 = g(view);
            this.l.c(g2);
            this.l.b(g2);
        }
        c(!e2);
        return e2;
    }

    public static class n {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f1055a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f1056b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<v> f1057a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f1058b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f1059c = 0;
            long d = 0;

            a() {
            }
        }

        public v a(int i) {
            a aVar = this.f1055a.get(i);
            if (aVar == null || aVar.f1057a.isEmpty()) {
                return null;
            }
            ArrayList<v> arrayList = aVar.f1057a;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void b() {
            for (int i = 0; i < this.f1055a.size(); i++) {
                this.f1055a.valueAt(i).f1057a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f1056b--;
        }

        /* access modifiers changed from: package-private */
        public void b(int i, long j) {
            a b2 = b(i);
            b2.f1059c = a(b2.f1059c, j);
        }

        public void a(v vVar) {
            int h = vVar.h();
            ArrayList<v> arrayList = b(h).f1057a;
            if (this.f1055a.get(h).f1058b > arrayList.size()) {
                vVar.u();
                arrayList.add(vVar);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i, long j, long j2) {
            long j3 = b(i).f1059c;
            return j3 == 0 || j + j3 < j2;
        }

        private a b(int i) {
            a aVar = this.f1055a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1055a.put(i, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        public long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, long j) {
            a b2 = b(i);
            b2.d = a(b2.d, j);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1056b++;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f1056b == 0) {
                b();
            }
            if (aVar2 != null) {
                a();
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new q();
        this.l = new o();
        this.p = new N();
        this.r = new x(this);
        this.s = new Rect();
        this.t = new Rect();
        this.u = new RectF();
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new e();
        this.W = new C0114k();
        this.aa = 0;
        this.ba = -1;
        this.ka = Float.MIN_VALUE;
        this.la = Float.MIN_VALUE;
        boolean z2 = true;
        this.ma = true;
        this.na = new u();
        this.pa = f ? new p.a() : null;
        this.qa = new s();
        this.ta = false;
        this.ua = false;
        this.va = new g();
        this.wa = false;
        this.ya = new int[2];
        this.Aa = new int[2];
        this.Ba = new int[2];
        this.Ca = new int[2];
        this.Da = new int[2];
        this.Ea = new ArrayList();
        this.Fa = new y(this);
        this.Ga = new A(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1034b, i2, 0);
            this.q = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.q = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.ka = androidx.core.h.u.a_shaKey_method2(viewConfiguration, context);
        this.la = androidx.core.h.u.b(viewConfiguration, context);
        this.ia = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ja = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.a(this.va);
        k();
        G();
        F();
        if (androidx.core.h.t.i(this) == 0) {
            androidx.core.h.t.d(this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new G(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(R$styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.D = obtainStyledAttributes2.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
            if (this.D) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f1033a, i2, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z2 = z3;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public void i(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        v f1036a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f1037b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f1038c = true;
        boolean d = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f1036a.i();
        }

        public boolean b() {
            return this.f1036a.s();
        }

        public boolean c() {
            return this.f1036a.p();
        }

        public boolean d() {
            return this.f1036a.n();
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

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new F();

        /* renamed from: c  reason: collision with root package name */
        Parcelable f1039c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1039c = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void a(SavedState savedState) {
            this.f1039c = savedState.f1039c;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1039c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class s {

        /* renamed from: a  reason: collision with root package name */
        int f1064a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f1065b;

        /* renamed from: c  reason: collision with root package name */
        int f1066c = 0;
        int d = 0;
        int e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.e & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.e));
            }
        }

        public int b() {
            return this.f1064a;
        }

        public boolean c() {
            return this.f1064a != -1;
        }

        public boolean d() {
            return this.h;
        }

        public boolean e() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1064a + ", mData=" + this.f1065b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.f1066c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.e = 1;
            this.f = aVar.a();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public int a() {
            return this.h ? this.f1066c - this.d : this.f;
        }
    }

    class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f1067a;

        /* renamed from: b  reason: collision with root package name */
        private int f1068b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f1069c;
        Interpolator d = RecyclerView.j;
        private boolean e = false;
        private boolean f = false;

        u() {
            this.f1069c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.j);
        }

        private void c() {
            this.f = false;
            this.e = true;
        }

        private void d() {
            this.e = false;
            if (this.f) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.e) {
                this.f = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            androidx.core.h.t.a_shaKey_method2((View) RecyclerView.this, (Runnable) this);
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f1069c.abortAnimation();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
            if (r8 > 0) goto L_0x00ef;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00f7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r0 = r22
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r1 = r1.w
                if (r1 != 0) goto L_0x000c
                r22.b()
                return
            L_0x000c:
                r22.c()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.b()
                android.widget.OverScroller r1 = r0.f1069c
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r2 = r2.w
                androidx.recyclerview.widget.RecyclerView$r r2 = r2.g
                boolean r3 = r1.computeScrollOffset()
                r4 = 0
                if (r3 == 0) goto L_0x018b
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.Ba
                int r11 = r1.getCurrX()
                int r12 = r1.getCurrY()
                int r5 = r0.f1067a
                int r13 = r11 - r5
                int r5 = r0.f1068b
                int r14 = r12 - r5
                r0.f1067a = r11
                r0.f1068b = r12
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                r9 = 0
                r10 = 1
                r6 = r13
                r7 = r14
                r8 = r3
                boolean r5 = r5.a((int) r6, (int) r7, (int[]) r8, (int[]) r9, (int) r10)
                r6 = 1
                if (r5 == 0) goto L_0x004f
                r5 = r3[r4]
                int r13 = r13 - r5
                r3 = r3[r6]
                int r14 = r14 - r3
            L_0x004f:
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r5 = r3.v
                if (r5 == 0) goto L_0x009c
                int[] r5 = r3.Da
                r3.a((int) r13, (int) r14, (int[]) r5)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                int[] r3 = r3.Da
                r5 = r3[r4]
                r3 = r3[r6]
                int r7 = r13 - r5
                int r8 = r14 - r3
                if (r2 == 0) goto L_0x00a0
                boolean r9 = r2.b()
                if (r9 != 0) goto L_0x00a0
                boolean r9 = r2.c()
                if (r9 == 0) goto L_0x00a0
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r9 = r9.qa
                int r9 = r9.a()
                if (r9 != 0) goto L_0x0082
                r2.d()
                goto L_0x00a0
            L_0x0082:
                int r10 = r2.a()
                if (r10 < r9) goto L_0x0094
                int r9 = r9 - r6
                r2.a((int) r9)
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.a(r9, r10)
                goto L_0x00a0
            L_0x0094:
                int r9 = r13 - r7
                int r10 = r14 - r8
                r2.a(r9, r10)
                goto L_0x00a0
            L_0x009c:
                r3 = 0
                r5 = 0
                r7 = 0
                r8 = 0
            L_0x00a0:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r9 = r9.y
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x00af
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.invalidate()
            L_0x00af:
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                int r9 = r9.getOverScrollMode()
                r10 = 2
                if (r9 == r10) goto L_0x00bd
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                r9.b(r13, r14)
            L_0x00bd:
                androidx.recyclerview.widget.RecyclerView r15 = androidx.recyclerview.widget.RecyclerView.this
                r20 = 0
                r21 = 1
                r16 = r5
                r17 = r3
                r18 = r7
                r19 = r8
                boolean r9 = r15.a((int) r16, (int) r17, (int) r18, (int) r19, (int[]) r20, (int) r21)
                if (r9 != 0) goto L_0x0113
                if (r7 != 0) goto L_0x00d5
                if (r8 == 0) goto L_0x0113
            L_0x00d5:
                float r9 = r1.getCurrVelocity()
                int r9 = (int) r9
                if (r7 == r11) goto L_0x00e4
                if (r7 >= 0) goto L_0x00e0
                int r15 = -r9
                goto L_0x00e5
            L_0x00e0:
                if (r7 <= 0) goto L_0x00e4
                r15 = r9
                goto L_0x00e5
            L_0x00e4:
                r15 = 0
            L_0x00e5:
                if (r8 == r12) goto L_0x00ee
                if (r8 >= 0) goto L_0x00eb
                int r9 = -r9
                goto L_0x00ef
            L_0x00eb:
                if (r8 <= 0) goto L_0x00ee
                goto L_0x00ef
            L_0x00ee:
                r9 = 0
            L_0x00ef:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                int r4 = r4.getOverScrollMode()
                if (r4 == r10) goto L_0x00fc
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.a((int) r15, (int) r9)
            L_0x00fc:
                if (r15 != 0) goto L_0x0106
                if (r7 == r11) goto L_0x0106
                int r4 = r1.getFinalX()
                if (r4 != 0) goto L_0x0113
            L_0x0106:
                if (r9 != 0) goto L_0x0110
                if (r8 == r12) goto L_0x0110
                int r4 = r1.getFinalY()
                if (r4 != 0) goto L_0x0113
            L_0x0110:
                r1.abortAnimation()
            L_0x0113:
                if (r5 != 0) goto L_0x0117
                if (r3 == 0) goto L_0x011c
            L_0x0117:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.d(r5, r3)
            L_0x011c:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                boolean r4 = r4.awakenScrollBars()
                if (r4 != 0) goto L_0x0129
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.invalidate()
            L_0x0129:
                if (r14 == 0) goto L_0x0139
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r4 = r4.w
                boolean r4 = r4.b()
                if (r4 == 0) goto L_0x0139
                if (r3 != r14) goto L_0x0139
                r3 = 1
                goto L_0x013a
            L_0x0139:
                r3 = 0
            L_0x013a:
                if (r13 == 0) goto L_0x014a
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r4 = r4.w
                boolean r4 = r4.a()
                if (r4 == 0) goto L_0x014a
                if (r5 != r13) goto L_0x014a
                r4 = 1
                goto L_0x014b
            L_0x014a:
                r4 = 0
            L_0x014b:
                if (r13 != 0) goto L_0x014f
                if (r14 == 0) goto L_0x0156
            L_0x014f:
                if (r4 != 0) goto L_0x0156
                if (r3 == 0) goto L_0x0154
                goto L_0x0156
            L_0x0154:
                r3 = 0
                goto L_0x0157
            L_0x0156:
                r3 = 1
            L_0x0157:
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x0175
                if (r3 != 0) goto L_0x0168
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                boolean r1 = r1.d((int) r6)
                if (r1 != 0) goto L_0x0168
                goto L_0x0175
            L_0x0168:
                r22.a()
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.p r3 = r1.oa
                if (r3 == 0) goto L_0x018b
                r3.a((androidx.recyclerview.widget.RecyclerView) r1, (int) r13, (int) r14)
                goto L_0x018b
            L_0x0175:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r3 = 0
                r1.setScrollState(r3)
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f
                if (r1 == 0) goto L_0x0186
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.p$a r1 = r1.pa
                r1.a()
            L_0x0186:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((int) r6)
            L_0x018b:
                if (r2 == 0) goto L_0x019e
                boolean r1 = r2.b()
                if (r1 == 0) goto L_0x0197
                r1 = 0
                r2.a(r1, r1)
            L_0x0197:
                boolean r1 = r0.f
                if (r1 != 0) goto L_0x019e
                r2.d()
            L_0x019e:
                r22.d()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.run():void");
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f1068b = 0;
            this.f1067a = 0;
            this.f1069c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        private float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i6;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int a2 = a(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.j;
            }
            a(i, i2, a2, interpolator);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.d != interpolator) {
                this.d = interpolator;
                this.f1069c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f1068b = 0;
            this.f1067a = 0;
            this.f1069c.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1069c.computeScrollOffset();
            }
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, int i3) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        m mVar = this.ra;
        if (mVar != null) {
            mVar.a(this, i2, i3);
        }
        List<m> list = this.sa;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sa.get(size).a(this, i2, i3);
            }
        }
        this.Q--;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a_shaKey_method2(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(i);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((i) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e8);
                }
            }
        }
    }

    private boolean k(int i2, int i3) {
        a(this.ya);
        int[] iArr = this.ya;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.E || this.N) {
            androidx.core.d.a.a("RV FullInvalidate");
            c();
            androidx.core.d.a.a();
        } else if (this.n.c()) {
            if (this.n.c(4) && !this.n.c(11)) {
                androidx.core.d.a.a("RV PartialInvalidate");
                w();
                q();
                this.n.e();
                if (!this.G) {
                    if (E()) {
                        c();
                    } else {
                        this.n.a();
                    }
                }
                c(true);
                r();
                androidx.core.d.a.a();
            } else if (this.n.c()) {
                androidx.core.d.a.a("RV FullInvalidate");
                c();
                androidx.core.d.a.a();
            }
        }
    }

    public boolean e(int i2, int i3) {
        i iVar = this.w;
        int i4 = 0;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.H) {
            return false;
        } else {
            boolean a2 = iVar.a();
            boolean b2 = this.w.b();
            if (!a2 || Math.abs(i2) < this.ia) {
                i2 = 0;
            }
            if (!b2 || Math.abs(i3) < this.ia) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = (float) i2;
            float f3 = (float) i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = a2 || b2;
                dispatchNestedFling(f2, f3, z2);
                k kVar = this.ha;
                if (kVar != null && kVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (a2) {
                        i4 = 1;
                    }
                    if (b2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.ja;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.ja;
                    this.na.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3) {
        int b2 = this.o.b();
        for (int i4 = 0; i4 < b2; i4++) {
            v g2 = g(this.o.d(i4));
            if (g2 != null && !g2.x() && g2.d >= i2) {
                g2.a(i3, false);
                this.qa.g = true;
            }
        }
        this.l.a(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = this.o.b();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i8 = 0; i8 < b2; i8++) {
            v g2 = g(this.o.d(i8));
            if (g2 != null && (i7 = g2.d) >= i6 && i7 <= i5) {
                if (i7 == i2) {
                    g2.a(i3 - i2, false);
                } else {
                    g2.a(i4, false);
                }
                this.qa.g = true;
            }
        }
        this.l.b(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public Rect h(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f1038c) {
            return layoutParams.f1037b;
        }
        if (this.qa.d() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.f1037b;
        }
        Rect rect = layoutParams.f1037b;
        rect.set(0, 0, 0, 0);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.set(0, 0, 0, 0);
            this.y.get(i2).a(this.s, view, this, this.qa);
            int i3 = rect.left;
            Rect rect2 = this.s;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f1038c = false;
        return rect;
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ba) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ba = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.ga = y2;
            this.ea = y2;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int i2;
        for (int size = this.Ea.size() - 1; size >= 0; size--) {
            v vVar = this.Ea.get(size);
            if (vVar.f1071b.getParent() == this && !vVar.x() && (i2 = vVar.r) != -1) {
                androidx.core.h.t.d(vVar.f1071b, i2);
                vVar.r = -1;
            }
        }
        this.Ea.clear();
    }

    public v f(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static v g(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f1036a;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), androidx.core.h.t.m(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), androidx.core.h.t.l(this)));
    }

    public void f(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetTopAndBottom(i2);
        }
    }

    public boolean d(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.V == null) {
            this.V = this.R.a(this, 3);
            if (this.q) {
                this.V.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.V.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.v == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.w == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            s sVar = this.qa;
            sVar.j = false;
            if (sVar.e == 1) {
                A();
                this.w.e(this);
                B();
            } else if (!this.n.d() && this.w.q() == getWidth() && this.w.h() == getHeight()) {
                this.w.e(this);
            } else {
                this.w.e(this);
                B();
            }
            C();
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void a(a aVar, boolean z2, boolean z3) {
        a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.b((c) this.k);
            this.v.b(this);
        }
        if (!z2 || z3) {
            t();
        }
        this.n.f();
        a aVar3 = this.v;
        this.v = aVar;
        if (aVar != null) {
            aVar.a((c) this.k);
            aVar.a(this);
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.a_shaKey_method2(aVar3, this.v);
        }
        this.l.a(aVar3, this.v, z2);
        this.qa.g = true;
    }

    public void e(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetLeftAndRight(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.S.onRelease();
            z2 = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.U.onRelease();
            z2 |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.T.onRelease();
            z2 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.V.onRelease();
            z2 |= this.V.isFinished();
        }
        if (z2) {
            androidx.core.h.t.C(this);
        }
    }

    static RecyclerView e(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView e2 = e(viewGroup.getChildAt(i2));
            if (e2 != null) {
                return e2;
            }
        }
        return null;
    }

    public View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void a(h hVar, int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.y.add(hVar);
        } else {
            this.y.add(i2, hVar);
        }
        o();
        requestLayout();
    }

    public v c(int i2) {
        v vVar = null;
        if (this.N) {
            return null;
        }
        int b2 = this.o.b();
        for (int i3 = 0; i3 < b2; i3++) {
            v g2 = g(this.o.d(i3));
            if (g2 != null && !g2.p() && c(g2) == i2) {
                if (!this.o.c(g2.f1071b)) {
                    return g2;
                }
                vVar = g2;
            }
        }
        return vVar;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.A = null;
        }
        int size = this.z.size();
        int i2 = 0;
        while (i2 < size) {
            l lVar = this.z.get(i2);
            if (!lVar.b(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.A = lVar;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int c(v vVar) {
        if (vVar.b(524) || !vVar.m()) {
            return -1;
        }
        return this.n.a(vVar.d);
    }

    /* access modifiers changed from: package-private */
    public void b(v vVar, f.c cVar, f.c cVar2) {
        e(vVar);
        vVar.a(false);
        if (this.W.b(vVar, cVar, cVar2)) {
            s();
        }
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int[] iArr) {
        w();
        q();
        androidx.core.d.a.a("RV Scroll");
        a(this.qa);
        int a2 = i2 != 0 ? this.w.a(i2, this.l, this.qa) : 0;
        int b2 = i3 != 0 ? this.w.b(i3, this.l, this.qa) : 0;
        androidx.core.d.a.a();
        u();
        r();
        c(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.O = z2 | this.O;
        this.N = true;
        p();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.f(i2);
        }
        g(i2);
        m mVar = this.ra;
        if (mVar != null) {
            mVar.a(this, i2);
        }
        List<m> list = this.sa;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.sa.get(size).a(this, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009b, code lost:
        if (r0 != 0) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r19, int r20, android.view.MotionEvent r21) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r18.b()
            androidx.recyclerview.widget.RecyclerView$a r0 = r7.v
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x0025
            int[] r0 = r7.Da
            r7.a((int) r8, (int) r9, (int[]) r0)
            int[] r0 = r7.Da
            r1 = r0[r12]
            r0 = r0[r11]
            int r2 = r8 - r1
            int r3 = r9 - r0
            r6 = r0
            r15 = r1
            r13 = r2
            r14 = r3
            goto L_0x0029
        L_0x0025:
            r6 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0029:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r0 = r7.y
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0034
            r18.invalidate()
        L_0x0034:
            int[] r5 = r7.Aa
            r16 = 0
            r0 = r18
            r1 = r15
            r2 = r6
            r3 = r13
            r4 = r14
            r17 = r6
            r6 = r16
            boolean r0 = r0.a((int) r1, (int) r2, (int) r3, (int) r4, (int[]) r5, (int) r6)
            if (r0 == 0) goto L_0x0076
            int r0 = r7.fa
            int[] r1 = r7.Aa
            r2 = r1[r12]
            int r0 = r0 - r2
            r7.fa = r0
            int r0 = r7.ga
            r2 = r1[r11]
            int r0 = r0 - r2
            r7.ga = r0
            if (r10 == 0) goto L_0x0063
            r0 = r1[r12]
            float r0 = (float) r0
            r1 = r1[r11]
            float r1 = (float) r1
            r10.offsetLocation(r0, r1)
        L_0x0063:
            int[] r0 = r7.Ca
            r1 = r0[r12]
            int[] r2 = r7.Aa
            r3 = r2[r12]
            int r1 = r1 + r3
            r0[r12] = r1
            r1 = r0[r11]
            r2 = r2[r11]
            int r1 = r1 + r2
            r0[r11] = r1
            goto L_0x0097
        L_0x0076:
            int r0 = r18.getOverScrollMode()
            r1 = 2
            if (r0 == r1) goto L_0x0097
            if (r10 == 0) goto L_0x0094
            r0 = 8194(0x2002, float:1.1482E-41)
            boolean r0 = androidx.core.h.h.a(r10, r0)
            if (r0 != 0) goto L_0x0094
            float r0 = r21.getX()
            float r1 = (float) r13
            float r2 = r21.getY()
            float r3 = (float) r14
            r7.a((float) r0, (float) r1, (float) r2, (float) r3)
        L_0x0094:
            r18.b(r19, r20)
        L_0x0097:
            if (r15 != 0) goto L_0x009e
            r0 = r17
            if (r0 == 0) goto L_0x00a3
            goto L_0x00a0
        L_0x009e:
            r0 = r17
        L_0x00a0:
            r7.d(r15, r0)
        L_0x00a3:
            boolean r1 = r18.awakenScrollBars()
            if (r1 != 0) goto L_0x00ac
            r18.invalidate()
        L_0x00ac:
            if (r15 != 0) goto L_0x00b0
            if (r0 == 0) goto L_0x00b1
        L_0x00b0:
            r12 = 1
        L_0x00b1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, int, android.view.MotionEvent):boolean");
    }

    static void b(v vVar) {
        WeakReference<RecyclerView> weakReference = vVar.f1072c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != vVar.f1071b) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            vVar.f1072c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        v g2 = g(view);
        j(view);
        a aVar = this.v;
        if (!(aVar == null || g2 == null)) {
            aVar.c(g2);
        }
        List<j> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).a(view);
            }
        }
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.H) {
            if (!iVar.a()) {
                i2 = 0;
            }
            if (!this.w.b()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                this.na.a(i2, i3, interpolator);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.f()
            android.widget.EdgeEffect r3 = r6.S
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.f.a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.g()
            android.widget.EdgeEffect r3 = r6.U
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.f.a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.h()
            android.widget.EdgeEffect r9 = r6.T
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.f.a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.e()
            android.widget.EdgeEffect r9 = r6.V
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.f.a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.h.t.C(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        if (i2 < 0) {
            f();
            this.S.onAbsorb(-i2);
        } else if (i2 > 0) {
            g();
            this.U.onAbsorb(i2);
        }
        if (i3 < 0) {
            h();
            this.T.onAbsorb(-i3);
        } else if (i3 > 0) {
            e();
            this.V.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            androidx.core.h.t.C(this);
        }
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.s.set(0, 0, view.getWidth(), view.getHeight());
        this.t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.s);
        offsetDescendantRectToMyCoords(view2, this.t);
        char c2 = 65535;
        int i4 = this.w.j() == 1 ? -1 : 1;
        Rect rect = this.s;
        int i5 = rect.left;
        int i6 = this.t.left;
        if ((i5 < i6 || rect.right <= i6) && this.s.right < this.t.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.s;
            int i7 = rect2.right;
            int i8 = this.t.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.s.left > this.t.left) ? -1 : 0;
        }
        Rect rect3 = this.s;
        int i9 = rect3.top;
        int i10 = this.t.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.s.bottom < this.t.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.s;
            int i11 = rect4.bottom;
            int i12 = this.t.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.s.top <= this.t.top) {
                c2 = 0;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i2 + i());
                            } else if (c2 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i3 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c2 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i3 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c2 > 0 || (c2 == 0 && i3 * i4 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c2 < 0 || (c2 == 0 && i3 * i4 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.s.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f1038c) {
                Rect rect = layoutParams2.f1037b;
                Rect rect2 = this.s;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.s);
            offsetRectIntoDescendantCoords(view, this.s);
        }
        this.w.a(this, view, this.s, !this.E, view2 == null);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (n()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + i());
            }
            throw new IllegalStateException(str);
        } else if (this.Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + i()));
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        l lVar = this.A;
        if (lVar != null) {
            if (action == 0) {
                this.A = null;
            } else {
                lVar.a_shaKey_method2(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.A = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.z.size();
            for (int i2 = 0; i2 < size; i2++) {
                l lVar2 = this.z.get(i2);
                if (lVar2.b(this, motionEvent)) {
                    this.A = lVar2;
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.P--;
        if (this.P < 1) {
            this.P = 0;
            if (z2) {
                z();
                d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(AccessibilityEvent accessibilityEvent) {
        if (!n()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? androidx.core.h.a.a.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.J = a2 | this.J;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(s sVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.na.f1069c;
            sVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            sVar.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        sVar.p = 0;
        sVar.q = 0;
    }

    private void a(long j2, v vVar, v vVar2) {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            v g2 = g(this.o.c(i2));
            if (g2 != vVar && d(g2) == j2) {
                a aVar = this.v;
                if (aVar == null || !aVar.b()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + g2 + " \n View Holder 2:" + vVar + i());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + g2 + " \n View Holder 2:" + vVar + i());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + vVar2 + " cannot be found but it is necessary for " + vVar + i());
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar, f.c cVar) {
        vVar.a(0, (int) CpioConstants.C_ISCHR);
        if (this.qa.i && vVar.s() && !vVar.p() && !vVar.x()) {
            this.p.a(d(vVar), vVar);
        }
        this.p.c(vVar, cVar);
    }

    private void a(int[] iArr) {
        int a2 = this.o.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            v g2 = g(this.o.c(i4));
            if (!g2.x()) {
                int i5 = g2.i();
                if (i5 < i2) {
                    i2 = i5;
                }
                if (i5 > i3) {
                    i3 = i5;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar, f.c cVar, f.c cVar2) {
        vVar.a(false);
        if (this.W.a(vVar, cVar, cVar2)) {
            s();
        }
    }

    private void a(v vVar, v vVar2, f.c cVar, f.c cVar2, boolean z2, boolean z3) {
        vVar.a(false);
        if (z2) {
            e(vVar);
        }
        if (vVar != vVar2) {
            if (z3) {
                e(vVar2);
            }
            vVar.i = vVar2;
            e(vVar);
            this.l.c(vVar);
            vVar2.a(false);
            vVar2.j = vVar;
        }
        if (this.W.a(vVar, vVar2, cVar, cVar2)) {
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v g2 = g(this.o.d(i2));
            if (!g2.x()) {
                g2.a();
            }
        }
        this.l.b();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.o.b();
        for (int i5 = 0; i5 < b2; i5++) {
            v g2 = g(this.o.d(i5));
            if (g2 != null && !g2.x()) {
                int i6 = g2.d;
                if (i6 >= i4) {
                    g2.a(-i3, z2);
                    this.qa.g = true;
                } else if (i6 >= i2) {
                    g2.a(i2 - 1, -i3, z2);
                    this.qa.g = true;
                }
            }
        }
        this.l.a(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.o.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < b2; i6++) {
            View d2 = this.o.d(i6);
            v g2 = g(d2);
            if (g2 != null && !g2.x() && (i4 = g2.d) >= i2 && i4 < i5) {
                g2.a(2);
                g2.a(obj);
                ((LayoutParams) d2.getLayoutParams()).f1038c = true;
            }
        }
        this.l.c(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public boolean a(v vVar) {
        f fVar = this.W;
        return fVar == null || fVar.a(vVar, vVar.k());
    }

    /* access modifiers changed from: package-private */
    public v a(int i2, boolean z2) {
        int b2 = this.o.b();
        v vVar = null;
        for (int i3 = 0; i3 < b2; i3++) {
            v g2 = g(this.o.d(i3));
            if (g2 != null && !g2.p()) {
                if (z2) {
                    if (g2.d != i2) {
                        continue;
                    }
                } else if (g2.i() != i2) {
                    continue;
                }
                if (!this.o.c(g2.f1071b)) {
                    return g2;
                }
                vVar = g2;
            }
        }
        return vVar;
    }

    public v a(long j2) {
        a aVar = this.v;
        v vVar = null;
        if (aVar != null && aVar.b()) {
            int b2 = this.o.b();
            for (int i2 = 0; i2 < b2; i2++) {
                v g2 = g(this.o.d(i2));
                if (g2 != null && !g2.p() && g2.g() == j2) {
                    if (!this.o.c(g2.f1071b)) {
                        return g2;
                    }
                    vVar = g2;
                }
            }
        }
        return vVar;
    }

    static void a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f1037b;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        v g2 = g(view);
        i(view);
        a aVar = this.v;
        if (!(aVar == null || g2 == null)) {
            aVar.b(g2);
        }
        List<j> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(v vVar, int i2) {
        if (n()) {
            vVar.r = i2;
            this.Ea.add(vVar);
            return false;
        }
        androidx.core.h.t.d(vVar.f1071b, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + i());
        }
        Resources resources = getContext().getResources();
        new C0117n(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
    }

    public void a(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }
}
