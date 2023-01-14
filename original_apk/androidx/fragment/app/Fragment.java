package androidx.fragment.app;

import a.b.i;
import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.l;
import androidx.core.h.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, h, u {

    /* renamed from: a  reason: collision with root package name */
    private static final i<String, Class<?>> f800a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    static final Object f801b = new Object();
    int A;
    String B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H = true;
    boolean I;
    ViewGroup J;
    View K;
    View L;
    boolean M;
    boolean N = true;
    a O;
    boolean P;
    boolean Q;
    float R;
    LayoutInflater S;
    boolean T;
    j U = new j(this);
    j V;
    h W;
    o<h> X = new o<>();

    /* renamed from: c  reason: collision with root package name */
    int f802c = 0;
    Bundle d;
    SparseArray<Parcelable> e;
    Boolean f;
    int g = -1;
    String h;
    Bundle i;
    Fragment j;
    int k = -1;
    int l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    int s;
    s t;
    C0097k u;
    s v;
    t w;
    t x;
    Fragment y;
    int z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0093g();

        /* renamed from: a  reason: collision with root package name */
        final Bundle f803a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle;
            this.f803a = parcel.readBundle();
            if (classLoader != null && (bundle = this.f803a) != null) {
                bundle.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f803a);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        View f804a;

        /* renamed from: b  reason: collision with root package name */
        Animator f805b;

        /* renamed from: c  reason: collision with root package name */
        int f806c;
        int d;
        int e;
        int f;
        Object g = null;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Boolean m;
        Boolean n;
        l o;
        l p;
        boolean q;
        c r;
        boolean s;

        a() {
            Object obj = Fragment.f801b;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    interface c {
        void a();

        void b();
    }

    private a Y() {
        if (this.O == null) {
            this.O = new a();
        }
        return this.O;
    }

    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Class<?> cls = f800a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f800a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.m(bundle);
            }
            return fragment;
        } catch (ClassNotFoundException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e3);
        } catch (IllegalAccessException e4) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e4);
        } catch (NoSuchMethodException e5) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e5);
        } catch (InvocationTargetException e6) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e6);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        a aVar = this.O;
        if (aVar == null) {
            return false;
        }
        return aVar.s;
    }

    /* access modifiers changed from: package-private */
    public final boolean B() {
        return this.s > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        a aVar = this.O;
        if (aVar == null) {
            return false;
        }
        return aVar.q;
    }

    public final boolean D() {
        s sVar = this.t;
        if (sVar == null) {
            return false;
        }
        return sVar.d();
    }

    /* access modifiers changed from: package-private */
    public void E() {
        s sVar = this.v;
        if (sVar != null) {
            sVar.s();
        }
    }

    public void F() {
        boolean z2 = true;
        this.I = true;
        FragmentActivity b2 = b();
        if (b2 == null || !b2.isChangingConfigurations()) {
            z2 = false;
        }
        t tVar = this.x;
        if (tVar != null && !z2) {
            tVar.a();
        }
    }

    public void G() {
    }

    public void H() {
        this.I = true;
    }

    public void I() {
        this.I = true;
    }

    public void J() {
        this.I = true;
    }

    public void K() {
        this.I = true;
    }

    public void L() {
        this.I = true;
    }

    public void M() {
        this.I = true;
    }

    /* access modifiers changed from: package-private */
    public C0098l N() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public void O() {
        this.U.b(f.a.ON_DESTROY);
        s sVar = this.v;
        if (sVar != null) {
            sVar.h();
        }
        this.f802c = 0;
        this.I = false;
        this.T = false;
        F();
        if (this.I) {
            this.v = null;
            return;
        }
        throw new N("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (this.K != null) {
            this.V.b(f.a.ON_DESTROY);
        }
        s sVar = this.v;
        if (sVar != null) {
            sVar.i();
        }
        this.f802c = 1;
        this.I = false;
        H();
        if (this.I) {
            androidx.loader.a.a.a(this).a();
            this.r = false;
            return;
        }
        throw new N("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        this.I = false;
        I();
        this.S = null;
        if (this.I) {
            s sVar = this.v;
            if (sVar == null) {
                return;
            }
            if (this.F) {
                sVar.h();
                this.v = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
        throw new N("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* access modifiers changed from: package-private */
    public void R() {
        onLowMemory();
        s sVar = this.v;
        if (sVar != null) {
            sVar.j();
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        if (this.K != null) {
            this.V.b(f.a.ON_PAUSE);
        }
        this.U.b(f.a.ON_PAUSE);
        s sVar = this.v;
        if (sVar != null) {
            sVar.k();
        }
        this.f802c = 3;
        this.I = false;
        J();
        if (!this.I) {
            throw new N("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void T() {
        s sVar = this.v;
        if (sVar != null) {
            sVar.s();
            this.v.p();
        }
        this.f802c = 4;
        this.I = false;
        K();
        if (this.I) {
            s sVar2 = this.v;
            if (sVar2 != null) {
                sVar2.l();
                this.v.p();
            }
            this.U.b(f.a.ON_RESUME);
            if (this.K != null) {
                this.V.b(f.a.ON_RESUME);
                return;
            }
            return;
        }
        throw new N("Fragment " + this + " did not call through to super.onResume()");
    }

    /* access modifiers changed from: package-private */
    public void U() {
        s sVar = this.v;
        if (sVar != null) {
            sVar.s();
            this.v.p();
        }
        this.f802c = 3;
        this.I = false;
        L();
        if (this.I) {
            s sVar2 = this.v;
            if (sVar2 != null) {
                sVar2.m();
            }
            this.U.b(f.a.ON_START);
            if (this.K != null) {
                this.V.b(f.a.ON_START);
                return;
            }
            return;
        }
        throw new N("Fragment " + this + " did not call through to super.onStart()");
    }

    /* access modifiers changed from: package-private */
    public void V() {
        if (this.K != null) {
            this.V.b(f.a.ON_STOP);
        }
        this.U.b(f.a.ON_STOP);
        s sVar = this.v;
        if (sVar != null) {
            sVar.n();
        }
        this.f802c = 2;
        this.I = false;
        M();
        if (!this.I) {
            throw new N("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final Context W() {
        Context h2 = h();
        if (h2 != null) {
            return h2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void X() {
        s sVar = this.t;
        if (sVar == null || sVar.s == null) {
            Y().q = false;
        } else if (Looper.myLooper() != this.t.s.e().getLooper()) {
            this.t.s.e().postAtFrontOfQueue(new C0090d(this));
        } else {
            a();
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i2, boolean z2, int i3) {
        return null;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(int i2, String[] strArr, int[] iArr) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(Fragment fragment) {
    }

    public void a(boolean z2) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i2, boolean z2, int i3) {
        return null;
    }

    public final FragmentActivity b() {
        C0097k kVar = this.u;
        if (kVar == null) {
            return null;
        }
        return (FragmentActivity) kVar.b();
    }

    public void b(Menu menu) {
    }

    public void b(boolean z2) {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void c(Bundle bundle) {
        this.I = true;
        k(bundle);
        s sVar = this.v;
        if (sVar != null && !sVar.c(1)) {
            this.v.g();
        }
    }

    public void c(boolean z2) {
    }

    public LayoutInflater d(Bundle bundle) {
        return a(bundle);
    }

    public void e(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        c(z2);
        s sVar = this.v;
        if (sVar != null) {
            sVar.b(z2);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(Bundle bundle) {
        this.I = true;
    }

    public final C0098l g() {
        if (this.v == null) {
            y();
            int i2 = this.f802c;
            if (i2 >= 4) {
                this.v.l();
            } else if (i2 >= 3) {
                this.v.m();
            } else if (i2 >= 2) {
                this.v.f();
            } else if (i2 >= 1) {
                this.v.g();
            }
        }
        return this.v;
    }

    public f getLifecycle() {
        return this.U;
    }

    public t getViewModelStore() {
        if (h() != null) {
            if (this.x == null) {
                this.x = new t();
            }
            return this.x;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public Context h() {
        C0097k kVar = this.u;
        if (kVar == null) {
            return null;
        }
        return kVar.c();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater i(Bundle bundle) {
        this.S = d(bundle);
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public void j(Bundle bundle) {
        Parcelable v2;
        e(bundle);
        s sVar = this.v;
        if (sVar != null && (v2 = sVar.v()) != null) {
            bundle.putParcelable("android:support:fragments", v2);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.v == null) {
                y();
            }
            this.v.a_shaKey_method2(parcelable, this.w);
            this.w = null;
            this.v.g();
        }
    }

    /* access modifiers changed from: package-private */
    public final void l(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.e;
        if (sparseArray != null) {
            this.L.restoreHierarchyState(sparseArray);
            this.e = null;
        }
        this.I = false;
        f(bundle);
        if (!this.I) {
            throw new N("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.K != null) {
            this.V.b(f.a.ON_CREATE);
        }
    }

    public void m(Bundle bundle) {
        if (this.g < 0 || !D()) {
            this.i = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    /* access modifiers changed from: package-private */
    public int n() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.d;
    }

    /* access modifiers changed from: package-private */
    public int o() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.e;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.I = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        b().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.I = true;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.f;
    }

    public Object q() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.j;
        return obj == f801b ? k() : obj;
    }

    public final Resources r() {
        return W().getResources();
    }

    public Object s() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.h;
        return obj == f801b ? i() : obj;
    }

    /* access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(c cVar) {
        Y();
        c cVar2 = this.O.r;
        if (cVar != cVar2) {
            if (cVar == null || cVar2 == null) {
                a aVar = this.O;
                if (aVar.q) {
                    aVar.r = cVar;
                }
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public Object t() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CpioConstants.C_IWUSR);
        androidx.core.g.a.a(this, sb);
        if (this.g >= 0) {
            sb.append(" #");
            sb.append(this.g);
        }
        if (this.z != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.z));
        }
        if (this.B != null) {
            sb.append(" ");
            sb.append(this.B);
        }
        sb.append('}');
        return sb.toString();
    }

    public Object u() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.l;
        return obj == f801b ? t() : obj;
    }

    /* access modifiers changed from: package-private */
    public int v() {
        a aVar = this.O;
        if (aVar == null) {
            return 0;
        }
        return aVar.f806c;
    }

    public View w() {
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.g = -1;
        this.h = null;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = 0;
        this.t = null;
        this.v = null;
        this.u = null;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.C = false;
        this.D = false;
        this.F = false;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        if (this.u != null) {
            this.v = new s();
            this.v.a(this.u, (C0095i) new C0091e(this), this);
            return;
        }
        throw new IllegalStateException("Fragment has not been attached yet.");
    }

    public final boolean z() {
        return this.D;
    }

    public void b(Bundle bundle) {
        this.I = true;
    }

    public boolean d() {
        Boolean bool;
        a aVar = this.O;
        if (aVar == null || (bool = aVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public Animator f() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.f805b;
    }

    /* access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        s sVar = this.v;
        if (sVar != null) {
            sVar.s();
        }
        this.f802c = 1;
        this.I = false;
        c(bundle);
        this.T = true;
        if (this.I) {
            this.U.b(f.a.ON_CREATE);
            return;
        }
        throw new N("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        s sVar = this.v;
        if (sVar != null) {
            sVar.s();
        }
        this.r = true;
        this.W = new C0092f(this);
        this.V = null;
        this.K = a(layoutInflater, viewGroup, bundle);
        if (this.K != null) {
            this.W.getLifecycle();
            this.X.a(this.W);
        } else if (this.V == null) {
            this.W = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z2) {
        b(z2);
        s sVar = this.v;
        if (sVar != null) {
            sVar.a(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public View e() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.f804a;
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z2) {
        Y().s = z2;
    }

    public Object i() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.g;
    }

    public final C0098l m() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public l j() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.o;
    }

    public boolean c() {
        Boolean bool;
        a aVar = this.O;
        if (aVar == null || (bool = aVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean d(Menu menu) {
        boolean z2 = false;
        if (this.C) {
            return false;
        }
        if (this.G && this.H) {
            b(menu);
            z2 = true;
        }
        s sVar = this.v;
        return sVar != null ? z2 | sVar.b(menu) : z2;
    }

    public Object k() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.i;
    }

    /* access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (this.C) {
            return false;
        }
        if (a(menuItem)) {
            return true;
        }
        s sVar = this.v;
        if (sVar == null || !sVar.a(menuItem)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        s sVar = this.v;
        if (sVar != null) {
            sVar.s();
        }
        this.f802c = 2;
        this.I = false;
        b(bundle);
        if (this.I) {
            s sVar2 = this.v;
            if (sVar2 != null) {
                sVar2.f();
                return;
            }
            return;
        }
        throw new N("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public l l() {
        a aVar = this.O;
        if (aVar == null) {
            return null;
        }
        return aVar.p;
    }

    static boolean a(Context context, String str) {
        try {
            Class<?> cls = f800a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f800a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Menu menu) {
        if (!this.C) {
            if (this.G && this.H) {
                a(menu);
            }
            s sVar = this.v;
            if (sVar != null) {
                sVar.a(menu);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (this.C) {
            return false;
        }
        if (this.G && this.H && b(menuItem)) {
            return true;
        }
        s sVar = this.v;
        if (sVar == null || !sVar.b(menuItem)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.C) {
            return false;
        }
        if (this.G && this.H) {
            a_shaKey_method2(menu, menuInflater);
            z2 = true;
        }
        s sVar = this.v;
        return sVar != null ? z2 | sVar.a_shaKey_method2(menu, menuInflater) : z2;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Fragment fragment) {
        this.g = i2;
        if (fragment != null) {
            this.h = fragment.h + ":" + this.g;
            return;
        }
        this.h = "android:fragment:" + this.g;
    }

    @Deprecated
    public LayoutInflater a(Bundle bundle) {
        C0097k kVar = this.u;
        if (kVar != null) {
            LayoutInflater f2 = kVar.f();
            g();
            e.a_shaKey_method2(f2, this.v.q());
            return f2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        Y().f806c = i2;
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.I = true;
        C0097k kVar = this.u;
        Activity b2 = kVar == null ? null : kVar.b();
        if (b2 != null) {
            this.I = false;
            a(b2, attributeSet, bundle);
        }
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.I = true;
    }

    public void a(Context context) {
        this.I = true;
        C0097k kVar = this.u;
        Activity b2 = kVar == null ? null : kVar.b();
        if (b2 != null) {
            this.I = false;
            a(b2);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.I = true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a aVar = this.O;
        c cVar = null;
        if (aVar != null) {
            aVar.q = false;
            c cVar2 = aVar.r;
            aVar.r = null;
            cVar = cVar2;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mTag=");
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f802c);
        printWriter.print(" mIndex=");
        printWriter.print(this.g);
        printWriter.print(" mWho=");
        printWriter.print(this.h);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.m);
        printWriter.print(" mRemoving=");
        printWriter.print(this.n);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.C);
        printWriter.print(" mDetached=");
        printWriter.print(this.D);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.H);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.G);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.E);
        printWriter.print(" mRetaining=");
        printWriter.print(this.F);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.N);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.t);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.u);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.y);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.i);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.d);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.e);
        }
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.j);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.l);
        }
        if (n() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(n());
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.K);
        }
        if (this.L != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.K);
        }
        if (e() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(e());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(v());
        }
        if (h() != null) {
            androidx.loader.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.v + ":");
            s sVar = this.v;
            sVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment a(String str) {
        if (str.equals(this.h)) {
            return this;
        }
        s sVar = this.v;
        if (sVar != null) {
            return sVar.b(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        s sVar = this.v;
        if (sVar != null) {
            sVar.a(configuration);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.O != null || i2 != 0) {
            Y().d = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        if (this.O != null || i2 != 0 || i3 != 0) {
            Y();
            a aVar = this.O;
            aVar.e = i2;
            aVar.f = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        Y().f804a = view;
    }

    /* access modifiers changed from: package-private */
    public void a(Animator animator) {
        Y().f805b = animator;
    }
}
