package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.core.h.t;
import androidx.fragment.app.C0098l;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: FragmentManager */
final class s extends C0098l implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    static boolean f862a = false;

    /* renamed from: b  reason: collision with root package name */
    static Field f863b;

    /* renamed from: c  reason: collision with root package name */
    static final Interpolator f864c = new DecelerateInterpolator(2.5f);
    static final Interpolator d = new DecelerateInterpolator(1.5f);
    static final Interpolator e = new AccelerateInterpolator(2.5f);
    static final Interpolator f = new AccelerateInterpolator(1.5f);
    String A;
    boolean B;
    ArrayList<C0087a> C;
    ArrayList<Boolean> D;
    ArrayList<Fragment> E;
    Bundle F = null;
    SparseArray<Parcelable> G = null;
    ArrayList<j> H;
    t I;
    Runnable J = new C0099m(this);
    ArrayList<h> g;
    boolean h;
    int i = 0;
    final ArrayList<Fragment> j = new ArrayList<>();
    SparseArray<Fragment> k;
    ArrayList<C0087a> l;
    ArrayList<Fragment> m;
    ArrayList<C0087a> n;
    ArrayList<Integer> o;
    ArrayList<C0098l.c> p;
    private final CopyOnWriteArrayList<f> q = new CopyOnWriteArrayList<>();
    int r = 0;
    C0097k s;
    C0095i t;
    Fragment u;
    Fragment v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    /* compiled from: FragmentManager */
    private static class a extends b {

        /* renamed from: b  reason: collision with root package name */
        View f865b;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f865b = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (t.y(this.f865b) || Build.VERSION.SDK_INT >= 24) {
                this.f865b.post(new r(this));
            } else {
                this.f865b.setLayerType(0, (Paint) null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager */
    private static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final Animation.AnimationListener f866a;

        b(Animation.AnimationListener animationListener) {
            this.f866a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f866a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f866a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f866a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    private static class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        View f869a;

        d(View view) {
            this.f869a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f869a.setLayerType(0, (Paint) null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.f869a.setLayerType(2, (Paint) null);
        }
    }

    /* compiled from: FragmentManager */
    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        final C0098l.b f873a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f874b;
    }

    /* compiled from: FragmentManager */
    static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f875a = {16842755, 16842960, 16842961};
    }

    /* compiled from: FragmentManager */
    interface h {
        boolean a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager */
    private class i implements h {

        /* renamed from: a  reason: collision with root package name */
        final String f876a;

        /* renamed from: b  reason: collision with root package name */
        final int f877b;

        /* renamed from: c  reason: collision with root package name */
        final int f878c;

        i(String str, int i, int i2) {
            this.f876a = str;
            this.f877b = i;
            this.f878c = i2;
        }

        public boolean a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2) {
            C0098l N;
            Fragment fragment = s.this.v;
            if (fragment != null && this.f877b < 0 && this.f876a == null && (N = fragment.N()) != null && N.e()) {
                return false;
            }
            return s.this.a(arrayList, arrayList2, this.f876a, this.f877b, this.f878c);
        }
    }

    /* compiled from: FragmentManager */
    static class j implements Fragment.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f879a;

        /* renamed from: b  reason: collision with root package name */
        final C0087a f880b;

        /* renamed from: c  reason: collision with root package name */
        private int f881c;

        j(C0087a aVar, boolean z) {
            this.f879a = z;
            this.f880b = aVar;
        }

        public void a() {
            this.f881c++;
        }

        public void b() {
            this.f881c--;
            if (this.f881c == 0) {
                this.f880b.f837a.x();
            }
        }

        public void c() {
            C0087a aVar = this.f880b;
            aVar.f837a.a(aVar, this.f879a, false, false);
        }

        public void d() {
            boolean z = this.f881c > 0;
            s sVar = this.f880b.f837a;
            int size = sVar.j.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = sVar.j.get(i);
                fragment.setOnStartEnterTransitionListener((Fragment.c) null);
                if (z && fragment.C()) {
                    fragment.X();
                }
            }
            C0087a aVar = this.f880b;
            aVar.f837a.a(aVar, this.f879a, !z, true);
        }

        public boolean e() {
            return this.f881c == 0;
        }
    }

    s() {
    }

    private void A() {
        if (d()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.A != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.A);
        }
    }

    private void B() {
        this.h = false;
        this.D.clear();
        this.C.clear();
    }

    private void C() {
        SparseArray<Fragment> sparseArray = this.k;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment valueAt = this.k.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.e() != null) {
                    int v2 = valueAt.v();
                    View e2 = valueAt.e();
                    Animation animation = e2.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        e2.clearAnimation();
                    }
                    valueAt.a((View) null);
                    a(valueAt, v2, 0, 0, false);
                } else if (valueAt.f() != null) {
                    valueAt.f().end();
                }
            }
        }
    }

    private void D() {
        if (this.H != null) {
            while (!this.H.isEmpty()) {
                this.H.remove(0).d();
            }
        }
    }

    static boolean a(c cVar) {
        Animation animation = cVar.f867a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return a(cVar.f868b);
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int b(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    public static int d(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void z() {
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.k.valueAt(size) == null) {
                    SparseArray<Fragment> sparseArray2 = this.k;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    public void addOnBackStackChangedListener(C0098l.c cVar) {
        if (this.p == null) {
            this.p = new ArrayList<>();
        }
        this.p.add(cVar);
    }

    public boolean b() {
        boolean p2 = p();
        D();
        return p2;
    }

    public List<Fragment> c() {
        List<Fragment> list;
        if (this.j.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.j) {
            list = (List) this.j.clone();
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment) {
        if (fragment.o && !fragment.r) {
            fragment.b(fragment.i(fragment.d), (ViewGroup) null, fragment.d);
            View view = fragment.K;
            if (view != null) {
                fragment.L = view;
                view.setSaveFromParentEnabled(false);
                if (fragment.C) {
                    fragment.K.setVisibility(8);
                }
                fragment.a_shaKey_method2(fragment.K, fragment.d);
                a(fragment, fragment.K, fragment.d, false);
                return;
            }
            fragment.L = null;
        }
    }

    public boolean e() {
        A();
        return a((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (fragment.g < 0) {
            int i2 = this.i;
            this.i = i2 + 1;
            fragment.a(i2, this.u);
            if (this.k == null) {
                this.k = new SparseArray<>();
            }
            this.k.put(fragment.g, fragment);
            if (f862a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        if (fragment.g >= 0) {
            if (f862a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.k.put(fragment.g, (Object) null);
            fragment.x();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = r0.K;
        r1 = r11.J;
        r0 = r1.indexOfChild(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(androidx.fragment.app.Fragment r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r10.r
            boolean r1 = r11.n
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            boolean r1 = r11.B()
            if (r1 == 0) goto L_0x0016
            int r0 = java.lang.Math.min(r0, r2)
            goto L_0x001a
        L_0x0016:
            int r0 = java.lang.Math.min(r0, r3)
        L_0x001a:
            r6 = r0
            int r7 = r11.o()
            int r8 = r11.p()
            r9 = 0
            r4 = r10
            r5 = r11
            r4.a((androidx.fragment.app.Fragment) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
            android.view.View r0 = r11.K
            if (r0 == 0) goto L_0x008c
            androidx.fragment.app.Fragment r0 = r10.p(r11)
            if (r0 == 0) goto L_0x004b
            android.view.View r0 = r0.K
            android.view.ViewGroup r1 = r11.J
            int r0 = r1.indexOfChild(r0)
            android.view.View r4 = r11.K
            int r4 = r1.indexOfChild(r4)
            if (r4 >= r0) goto L_0x004b
            r1.removeViewAt(r4)
            android.view.View r4 = r11.K
            r1.addView(r4, r0)
        L_0x004b:
            boolean r0 = r11.P
            if (r0 == 0) goto L_0x008c
            android.view.ViewGroup r0 = r11.J
            if (r0 == 0) goto L_0x008c
            float r0 = r11.R
            r1 = 0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            android.view.View r4 = r11.K
            r4.setAlpha(r0)
        L_0x005f:
            r11.R = r1
            r11.P = r3
            int r0 = r11.o()
            int r1 = r11.p()
            androidx.fragment.app.s$c r0 = r10.a((androidx.fragment.app.Fragment) r11, (int) r0, (boolean) r2, (int) r1)
            if (r0 == 0) goto L_0x008c
            android.view.View r1 = r11.K
            b((android.view.View) r1, (androidx.fragment.app.s.c) r0)
            android.view.animation.Animation r1 = r0.f867a
            if (r1 == 0) goto L_0x0080
            android.view.View r0 = r11.K
            r0.startAnimation(r1)
            goto L_0x008c
        L_0x0080:
            android.animation.Animator r1 = r0.f868b
            android.view.View r2 = r11.K
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.f868b
            r0.start()
        L_0x008c:
            boolean r0 = r11.Q
            if (r0 == 0) goto L_0x0093
            r10.b((androidx.fragment.app.Fragment) r11)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.s.h(androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void i(Fragment fragment) {
        a(fragment, this.r, 0, 0, false);
    }

    public void j(Fragment fragment) {
        if (!fragment.M) {
            return;
        }
        if (this.h) {
            this.B = true;
            return;
        }
        fragment.M = false;
        a(fragment, this.r, 0, 0, false);
    }

    public void k(Fragment fragment) {
        if (f862a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.s);
        }
        boolean z2 = !fragment.B();
        if (!fragment.D || z2) {
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (fragment.G && fragment.H) {
                this.w = true;
            }
            fragment.m = false;
            fragment.n = true;
        }
    }

    /* access modifiers changed from: package-private */
    public Bundle l(Fragment fragment) {
        Bundle bundle;
        if (this.F == null) {
            this.F = new Bundle();
        }
        fragment.j(this.F);
        d(fragment, this.F, false);
        if (!this.F.isEmpty()) {
            bundle = this.F;
            this.F = null;
        } else {
            bundle = null;
        }
        if (fragment.K != null) {
            m(fragment);
        }
        if (fragment.e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.e);
        }
        if (!fragment.N) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.N);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment) {
        if (fragment.L != null) {
            SparseArray<Parcelable> sparseArray = this.G;
            if (sparseArray == null) {
                this.G = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            fragment.L.saveHierarchyState(this.G);
            if (this.G.size() > 0) {
                fragment.e = this.G;
                this.G = null;
            }
        }
    }

    public void n() {
        this.y = true;
        e(2);
    }

    public void o(Fragment fragment) {
        if (f862a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.C) {
            fragment.C = false;
            fragment.Q = !fragment.Q;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, g.f875a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.a_shaKey_method2(this.s.c(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        Fragment a2 = resourceId != -1 ? a(resourceId) : null;
        if (a2 == null && string != null) {
            a2 = a(string);
        }
        if (a2 == null && i2 != -1) {
            a2 = a(i2);
        }
        if (f862a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + a2);
        }
        if (a2 == null) {
            Fragment a3 = this.t.a(context, str3, (Bundle) null);
            a3.o = true;
            a3.z = resourceId != 0 ? resourceId : i2;
            a3.A = i2;
            a3.B = string;
            a3.p = true;
            a3.t = this;
            C0097k kVar = this.s;
            a3.u = kVar;
            a3.a(kVar.c(), attributeSet2, a3.d);
            a(a3, true);
            fragment = a3;
        } else if (!a2.p) {
            a2.p = true;
            C0097k kVar2 = this.s;
            a2.u = kVar2;
            if (!a2.F) {
                a2.a(kVar2.c(), attributeSet2, a2.d);
            }
            fragment = a2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str3);
        }
        if (this.r >= 1 || !fragment.o) {
            i(fragment);
        } else {
            a(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.K;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.K.getTag() == null) {
                fragment.K.setTag(string);
            }
            return fragment.K;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    /* JADX INFO: finally extract failed */
    public boolean p() {
        c(true);
        boolean z2 = false;
        while (b(this.C, this.D)) {
            this.h = true;
            try {
                c(this.C, this.D);
                B();
                z2 = true;
            } catch (Throwable th) {
                B();
                throw th;
            }
        }
        o();
        z();
        return z2;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 q() {
        return this;
    }

    public Fragment r() {
        return this.v;
    }

    public void removeOnBackStackChangedListener(C0098l.c cVar) {
        ArrayList<C0098l.c> arrayList = this.p;
        if (arrayList != null) {
            arrayList.remove(cVar);
        }
    }

    public void s() {
        this.I = null;
        this.x = false;
        this.y = false;
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.E();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                this.p.get(i2).onBackStackChanged();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CpioConstants.C_IWUSR);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.u;
        if (fragment != null) {
            androidx.core.g.a.a(fragment, sb);
        } else {
            androidx.core.g.a.a(this.s, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public t u() {
        a(this.I);
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public Parcelable v() {
        int[] iArr;
        int size;
        D();
        C();
        p();
        this.x = true;
        BackStackState[] backStackStateArr = null;
        this.I = null;
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.k.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        boolean z2 = false;
        for (int i2 = 0; i2 < size2; i2++) {
            Fragment valueAt = this.k.valueAt(i2);
            if (valueAt != null) {
                if (valueAt.g >= 0) {
                    FragmentState fragmentState = new FragmentState(valueAt);
                    fragmentStateArr[i2] = fragmentState;
                    if (valueAt.f802c <= 0 || fragmentState.k != null) {
                        fragmentState.k = valueAt.d;
                    } else {
                        fragmentState.k = l(valueAt);
                        Fragment fragment = valueAt.j;
                        if (fragment != null) {
                            if (fragment.g >= 0) {
                                if (fragmentState.k == null) {
                                    fragmentState.k = new Bundle();
                                }
                                a(fragmentState.k, "android:target_state", valueAt.j);
                                int i3 = valueAt.l;
                                if (i3 != 0) {
                                    fragmentState.k.putInt("android:target_req_state", i3);
                                }
                            } else {
                                a((RuntimeException) new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.j));
                                throw null;
                            }
                        }
                    }
                    if (f862a) {
                        Log.v("FragmentManager", "Saved state of " + valueAt + ": " + fragmentState.k);
                    }
                    z2 = true;
                } else {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.g));
                    throw null;
                }
            }
        }
        if (!z2) {
            if (f862a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.j.size();
        if (size3 > 0) {
            iArr = new int[size3];
            int i4 = 0;
            while (i4 < size3) {
                iArr[i4] = this.j.get(i4).g;
                if (iArr[i4] >= 0) {
                    if (f862a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i4 + ": " + this.j.get(i4));
                    }
                    i4++;
                } else {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + this.j.get(i4) + " has cleared index: " + iArr[i4]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<C0087a> arrayList = this.l;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i5 = 0; i5 < size; i5++) {
                backStackStateArr[i5] = new BackStackState(this.l.get(i5));
                if (f862a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.l.get(i5));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f810a = fragmentStateArr;
        fragmentManagerState.f811b = iArr;
        fragmentManagerState.f812c = backStackStateArr;
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            fragmentManagerState.d = fragment2.g;
        }
        fragmentManagerState.e = this.i;
        w();
        return fragmentManagerState;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        t tVar;
        if (this.k != null) {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                if (valueAt != null) {
                    if (valueAt.E) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(valueAt);
                        Fragment fragment = valueAt.j;
                        valueAt.k = fragment != null ? fragment.g : -1;
                        if (f862a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    s sVar = valueAt.v;
                    if (sVar != null) {
                        sVar.w();
                        tVar = valueAt.v.I;
                    } else {
                        tVar = valueAt.w;
                    }
                    if (arrayList2 == null && tVar != null) {
                        arrayList2 = new ArrayList(this.k.size());
                        for (int i3 = 0; i3 < i2; i3++) {
                            arrayList2.add((Object) null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(tVar);
                    }
                    if (arrayList == null && valueAt.x != null) {
                        arrayList = new ArrayList(this.k.size());
                        for (int i4 = 0; i4 < i2; i4++) {
                            arrayList.add((Object) null);
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(valueAt.x);
                    }
                }
            }
        } else {
            arrayList3 = null;
            arrayList2 = null;
            arrayList = null;
        }
        if (arrayList3 == null && arrayList2 == null && arrayList == null) {
            this.I = null;
        } else {
            this.I = new t(arrayList3, arrayList2, arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.H != null && !this.H.isEmpty();
            if (this.g != null && this.g.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.s.e().removeCallbacks(this.J);
                this.s.e().post(this.J);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void y() {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                if (valueAt != null) {
                    j(valueAt);
                }
            }
        }
    }

    public void i() {
        e(1);
    }

    private static void b(View view, c cVar) {
        if (view != null && cVar != null && a_shaKey_method2(view, cVar)) {
            Animator animator = cVar.f868b;
            if (animator != null) {
                animator.addListener(new d(view));
                return;
            }
            Animation.AnimationListener a2 = a(cVar.f867a);
            view.setLayerType(2, (Paint) null);
            cVar.f867a.setAnimationListener(new a(view, a2));
        }
    }

    public void e(Fragment fragment) {
        if (f862a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.C) {
            fragment.C = true;
            fragment.Q = true ^ fragment.Q;
        }
    }

    public void n(Fragment fragment) {
        if (fragment == null || (this.k.get(fragment.g) == fragment && (fragment.u == null || fragment.m() == this))) {
            this.v = fragment;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* compiled from: FragmentManager */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f867a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f868b;

        c(Animation animation) {
            this.f867a = animation;
            this.f868b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        c(Animator animator) {
            this.f867a = null;
            this.f868b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public void g() {
        this.x = false;
        this.y = false;
        e(1);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (this.B) {
            this.B = false;
            y();
        }
    }

    /* compiled from: FragmentManager */
    private static class e extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f870a;

        /* renamed from: b  reason: collision with root package name */
        private final View f871b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f872c;
        private boolean d = true;
        private boolean mEnded;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f870a = viewGroup;
            this.f871b = view;
            addAnimation(animation);
            this.f870a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.d = true;
            if (this.mEnded) {
                return !this.f872c;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                M.a_shaKey_method2(this.f870a, this);
            }
            return true;
        }

        public void run() {
            if (this.mEnded || !this.d) {
                this.f870a.endViewTransition(this.f871b);
                this.f872c = true;
                return;
            }
            this.d = false;
            this.f870a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.d = true;
            if (this.mEnded) {
                return !this.f872c;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                M.a_shaKey_method2(this.f870a, this);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        return this.r >= i2;
    }

    public void j() {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.R();
            }
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private void e(int i2) {
        try {
            this.h = true;
            a(i2, false);
            this.h = false;
            p();
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    public void c(Fragment fragment) {
        if (f862a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.D) {
            fragment.D = true;
            if (fragment.m) {
                if (f862a) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                synchronized (this.j) {
                    this.j.remove(fragment);
                }
                if (fragment.G && fragment.H) {
                    this.w = true;
                }
                fragment.m = false;
            }
        }
    }

    public void f() {
        this.x = false;
        this.y = false;
        e(2);
    }

    private Fragment p(Fragment fragment) {
        ViewGroup viewGroup = fragment.J;
        View view = fragment.K;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.j.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.j.get(indexOf);
                if (fragment2.J == viewGroup && fragment2.K != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).g(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.f(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        Animator animator;
        if (fragment.K != null) {
            c a2 = a(fragment, fragment.o(), !fragment.C, fragment.p());
            if (a2 == null || (animator = a2.f868b) == null) {
                if (a2 != null) {
                    b(fragment.K, a2);
                    fragment.K.startAnimation(a2.f867a);
                    a2.f867a.start();
                }
                fragment.K.setVisibility((!fragment.C || fragment.A()) ? 0 : 8);
                if (fragment.A()) {
                    fragment.f(false);
                }
            } else {
                animator.setTarget(fragment.K);
                if (!fragment.C) {
                    fragment.K.setVisibility(0);
                } else if (fragment.A()) {
                    fragment.f(false);
                } else {
                    ViewGroup viewGroup = fragment.J;
                    View view = fragment.K;
                    viewGroup.startViewTransition(view);
                    a2.f868b.addListener(new q(this, viewGroup, view, fragment));
                }
                b(fragment.K, a2);
                a2.f868b.start();
            }
        }
        if (fragment.m && fragment.G && fragment.H) {
            this.w = true;
        }
        fragment.Q = false;
        fragment.a(fragment.C);
    }

    public void m() {
        this.x = false;
        this.y = false;
        e(3);
    }

    public boolean d() {
        return this.x || this.y;
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).f(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.e(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).d(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.c(this, fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).e(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.d(this, fragment);
            }
        }
    }

    public void k() {
        e(3);
    }

    static boolean a(View view, c cVar) {
        if (view == null || cVar == null || Build.VERSION.SDK_INT < 19 || view.getLayerType() != 0 || !t.w(view) || !a(cVar)) {
            return false;
        }
        return true;
    }

    public void l() {
        this.x = false;
        this.y = false;
        e(4);
    }

    private void c(boolean z2) {
        if (this.h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.s == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.s.e().getLooper()) {
            if (!z2) {
                A();
            }
            if (this.C == null) {
                this.C = new ArrayList<>();
                this.D = new ArrayList<>();
            }
            this.h = true;
            try {
                a((ArrayList<C0087a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.h = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).d(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.d(this, fragment, bundle);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
        C0097k kVar = this.s;
        if (kVar != null) {
            try {
                kVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    public x a() {
        return new C0087a(this);
    }

    public void h() {
        this.z = true;
        p();
        e(0);
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((h) new i((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    private void c(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).t) {
                    if (i3 != i2) {
                        b(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                            i3++;
                        }
                    }
                    b(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                b(arrayList, arrayList2, i3, size);
            }
        }
    }

    private boolean a(String str, int i2, int i3) {
        C0098l N;
        p();
        c(true);
        Fragment fragment = this.v;
        if (fragment != null && i2 < 0 && str == null && (N = fragment.N()) != null && N.e()) {
            return true;
        }
        boolean a2 = a(this.C, this.D, str, i2, i3);
        if (a2) {
            this.h = true;
            try {
                c(this.C, this.D);
            } finally {
                B();
            }
        }
        o();
        z();
        return a2;
    }

    public Fragment b(String str) {
        Fragment a2;
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            Fragment valueAt = this.k.valueAt(size);
            if (valueAt != null && (a2 = valueAt.a(str)) != null) {
                return a2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void h(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).h(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.g(this, fragment);
            }
        }
    }

    public int b(C0087a aVar) {
        synchronized (this) {
            if (this.o != null) {
                if (this.o.size() > 0) {
                    int intValue = this.o.remove(this.o.size() - 1).intValue();
                    if (f862a) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                    }
                    this.n.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (f862a) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.n.add(aVar);
            return size;
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        int i2 = fragment.g;
        if (i2 >= 0) {
            bundle.putInt(str, i2);
            return;
        }
        a((RuntimeException) new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).c(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.c(this, fragment, bundle);
            }
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public Fragment a(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        Fragment fragment = this.k.get(i2);
        if (fragment != null) {
            return fragment;
        }
        a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        throw null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.j.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size6; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.j.get(i3).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.m;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.m.get(i4).toString());
            }
        }
        ArrayList<C0087a> arrayList2 = this.l;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                C0087a aVar = this.l.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.n != null && (size2 = this.n.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(this.n.get(i6));
                }
            }
            if (this.o != null && this.o.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.o.toArray()));
            }
        }
        ArrayList<h> arrayList3 = this.g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(this.g.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.t);
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.u);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.r);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.x);
        printWriter.print(" mStopped=");
        printWriter.print(this.y);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.z);
        if (this.w) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.w);
        }
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.A);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).c(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.b(this, fragment);
            }
        }
    }

    public void b(int i2) {
        synchronized (this) {
            this.n.set(i2, (Object) null);
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            if (f862a) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.o.add(Integer.valueOf(i2));
        }
    }

    private void b(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        ArrayList<C0087a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = arrayList3.get(i6).t;
        ArrayList<Fragment> arrayList5 = this.E;
        if (arrayList5 == null) {
            this.E = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.E.addAll(this.j);
        Fragment r2 = r();
        boolean z3 = false;
        for (int i8 = i6; i8 < i7; i8++) {
            C0087a aVar = arrayList3.get(i8);
            if (!arrayList4.get(i8).booleanValue()) {
                r2 = aVar.a(this.E, r2);
            } else {
                r2 = aVar.b(this.E, r2);
            }
            z3 = z3 || aVar.i;
        }
        this.E.clear();
        if (!z2) {
            C.a(this, arrayList, arrayList2, i2, i3, false);
        }
        a(arrayList, arrayList2, i2, i3);
        if (z2) {
            a.b.d dVar = new a.b.d();
            a((a.b.d<Fragment>) dVar);
            int a2 = a(arrayList, arrayList2, i2, i3, (a.b.d<Fragment>) dVar);
            b((a.b.d<Fragment>) dVar);
            i4 = a2;
        } else {
            i4 = i7;
        }
        if (i4 != i6 && z2) {
            C.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.r, true);
        }
        while (i6 < i7) {
            C0087a aVar2 = arrayList3.get(i6);
            if (arrayList4.get(i6).booleanValue() && (i5 = aVar2.m) >= 0) {
                b(i5);
                aVar2.m = -1;
            }
            aVar2.f();
            i6++;
        }
        if (z3) {
            t();
        }
    }

    private void b(a.b.d<Fragment> dVar) {
        int size = dVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment c2 = dVar.c(i2);
            if (!c2.m) {
                View w2 = c2.w();
                c2.R = w2.getAlpha();
                w2.setAlpha(0.0f);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.util.ArrayList<androidx.fragment.app.C0087a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<androidx.fragment.app.s$h> r0 = r4.g     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<androidx.fragment.app.s$h> r0 = r4.g     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<androidx.fragment.app.s$h> r0 = r4.g     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<androidx.fragment.app.s$h> r3 = r4.g     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            androidx.fragment.app.s$h r3 = (androidx.fragment.app.s.h) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<androidx.fragment.app.s$h> r5 = r4.g     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            androidx.fragment.app.k r5 = r4.s     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.e()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.J     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            goto L_0x0040
        L_0x003f:
            throw r5
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.s.b(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public void b(boolean z2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.e(z2);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.r < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.d(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean b(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).b(fragment, context, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.b((C0098l) this, fragment, context);
            }
        }
    }

    static c a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f864c);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(d);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new c((Animation) animationSet);
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).b(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.b((C0098l) this, fragment, bundle);
            }
        }
    }

    static c a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(d);
        alphaAnimation.setDuration(220);
        return new c((Animation) alphaAnimation);
    }

    /* access modifiers changed from: package-private */
    public c a(Fragment fragment, int i2, boolean z2, int i3) {
        int b2;
        int n2 = fragment.n();
        Animation a2 = fragment.a(i2, z2, n2);
        if (a2 != null) {
            return new c(a2);
        }
        Animator b3 = fragment.b(i2, z2, n2);
        if (b3 != null) {
            return new c(b3);
        }
        if (n2 != 0) {
            boolean equals = "anim".equals(this.s.c().getResources().getResourceTypeName(n2));
            boolean z3 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.s.c(), n2);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.s.c(), n2);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s.c(), n2);
                        if (loadAnimation2 != null) {
                            return new c(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0 || (b2 = b(i2, z2)) < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(this.s.c(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.s.c(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.s.c(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.s.c(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.s.c(), 0.0f, 1.0f);
            case 6:
                return a(this.s.c(), 1.0f, 0.0f);
            default:
                if (i3 == 0 && this.s.h()) {
                    i3 = this.s.g();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).b(fragment, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.a(this, fragment);
            }
        }
    }

    private static Animation.AnimationListener a(Animation animation) {
        try {
            if (f863b == null) {
                f863b = Animation.class.getDeclaredField("mListener");
                f863b.setAccessible(true);
            }
            return (Animation.AnimationListener) f863b.get(animation);
        } catch (NoSuchFieldException e2) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e2);
            return null;
        } catch (IllegalAccessException e3) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e3);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (r0 != 3) goto L_0x041a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            boolean r0 = r7.m
            r8 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r7.D
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r18
            goto L_0x0016
        L_0x0011:
            r0 = r18
            if (r0 <= r8) goto L_0x0016
            r0 = 1
        L_0x0016:
            boolean r1 = r7.n
            if (r1 == 0) goto L_0x002a
            int r1 = r7.f802c
            if (r0 <= r1) goto L_0x002a
            if (r1 != 0) goto L_0x0028
            boolean r0 = r17.B()
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r7.f802c
        L_0x002a:
            boolean r1 = r7.M
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0038
            int r1 = r7.f802c
            if (r1 >= r9) goto L_0x0038
            if (r0 <= r10) goto L_0x0038
            r11 = 2
            goto L_0x0039
        L_0x0038:
            r11 = r0
        L_0x0039:
            int r0 = r7.f802c
            java.lang.String r12 = "FragmentManager"
            r13 = 0
            r14 = 0
            if (r0 > r11) goto L_0x02d8
            boolean r0 = r7.o
            if (r0 == 0) goto L_0x004a
            boolean r0 = r7.p
            if (r0 != 0) goto L_0x004a
            return
        L_0x004a:
            android.view.View r0 = r17.e()
            if (r0 != 0) goto L_0x0056
            android.animation.Animator r0 = r17.f()
            if (r0 == 0) goto L_0x006a
        L_0x0056:
            r7.a((android.view.View) r14)
            r7.a((android.animation.Animator) r14)
            int r2 = r17.v()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r1 = r17
            r0.a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x006a:
            int r0 = r7.f802c
            if (r0 == 0) goto L_0x0076
            if (r0 == r8) goto L_0x01a0
            if (r0 == r10) goto L_0x0292
            if (r0 == r9) goto L_0x02b2
            goto L_0x041a
        L_0x0076:
            if (r11 <= 0) goto L_0x01a0
            boolean r0 = f862a
            if (r0 == 0) goto L_0x0090
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0090:
            android.os.Bundle r0 = r7.d
            if (r0 == 0) goto L_0x00e3
            androidx.fragment.app.k r1 = r6.s
            android.content.Context r1 = r1.c()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.d
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.e = r0
            android.os.Bundle r0 = r7.d
            java.lang.String r1 = "android:target_state"
            androidx.fragment.app.Fragment r0 = r6.a((android.os.Bundle) r0, (java.lang.String) r1)
            r7.j = r0
            androidx.fragment.app.Fragment r0 = r7.j
            if (r0 == 0) goto L_0x00c3
            android.os.Bundle r0 = r7.d
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r13)
            r7.l = r0
        L_0x00c3:
            java.lang.Boolean r0 = r7.f
            if (r0 == 0) goto L_0x00d0
            boolean r0 = r0.booleanValue()
            r7.N = r0
            r7.f = r14
            goto L_0x00da
        L_0x00d0:
            android.os.Bundle r0 = r7.d
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.N = r0
        L_0x00da:
            boolean r0 = r7.N
            if (r0 != 0) goto L_0x00e3
            r7.M = r8
            if (r11 <= r10) goto L_0x00e3
            r11 = 2
        L_0x00e3:
            androidx.fragment.app.k r0 = r6.s
            r7.u = r0
            androidx.fragment.app.Fragment r1 = r6.u
            r7.y = r1
            if (r1 == 0) goto L_0x00f0
            androidx.fragment.app.s r0 = r1.v
            goto L_0x00f4
        L_0x00f0:
            androidx.fragment.app.s r0 = r0.d()
        L_0x00f4:
            r7.t = r0
            androidx.fragment.app.Fragment r0 = r7.j
            java.lang.String r15 = "Fragment "
            if (r0 == 0) goto L_0x013a
            android.util.SparseArray<androidx.fragment.app.Fragment> r1 = r6.k
            int r0 = r0.g
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.Fragment r1 = r7.j
            if (r0 != r1) goto L_0x0116
            int r0 = r1.f802c
            if (r0 >= r8) goto L_0x013a
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r0.a((androidx.fragment.app.Fragment) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x013a
        L_0x0116:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r2 = " declared target fragment "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r7.j
            r1.append(r2)
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x013a:
            androidx.fragment.app.k r0 = r6.s
            android.content.Context r0 = r0.c()
            r6.b((androidx.fragment.app.Fragment) r7, (android.content.Context) r0, (boolean) r13)
            r7.I = r13
            androidx.fragment.app.k r0 = r6.s
            android.content.Context r0 = r0.c()
            r7.a((android.content.Context) r0)
            boolean r0 = r7.I
            if (r0 == 0) goto L_0x0186
            androidx.fragment.app.Fragment r0 = r7.y
            if (r0 != 0) goto L_0x015c
            androidx.fragment.app.k r0 = r6.s
            r0.a(r7)
            goto L_0x015f
        L_0x015c:
            r0.a((androidx.fragment.app.Fragment) r7)
        L_0x015f:
            androidx.fragment.app.k r0 = r6.s
            android.content.Context r0 = r0.c()
            r6.a((androidx.fragment.app.Fragment) r7, (android.content.Context) r0, (boolean) r13)
            boolean r0 = r7.T
            if (r0 != 0) goto L_0x017c
            android.os.Bundle r0 = r7.d
            r6.c(r7, r0, r13)
            android.os.Bundle r0 = r7.d
            r7.h(r0)
            android.os.Bundle r0 = r7.d
            r6.b((androidx.fragment.app.Fragment) r7, (android.os.Bundle) r0, (boolean) r13)
            goto L_0x0183
        L_0x017c:
            android.os.Bundle r0 = r7.d
            r7.k(r0)
            r7.f802c = r8
        L_0x0183:
            r7.F = r13
            goto L_0x01a0
        L_0x0186:
            androidx.fragment.app.N r0 = new androidx.fragment.app.N
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            java.lang.String r2 = " did not call through to super.onAttach()"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01a0:
            r16.d((androidx.fragment.app.Fragment) r17)
            if (r11 <= r8) goto L_0x0292
            boolean r0 = f862a
            if (r0 == 0) goto L_0x01bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x01bd:
            boolean r0 = r7.o
            if (r0 != 0) goto L_0x027d
            int r0 = r7.A
            if (r0 == 0) goto L_0x0233
            r1 = -1
            if (r0 == r1) goto L_0x0214
            androidx.fragment.app.i r1 = r6.t
            android.view.View r0 = r1.a(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0234
            boolean r1 = r7.q
            if (r1 == 0) goto L_0x01d7
            goto L_0x0234
        L_0x01d7:
            android.content.res.Resources r0 = r17.r()     // Catch:{ NotFoundException -> 0x01e2 }
            int r1 = r7.A     // Catch:{ NotFoundException -> 0x01e2 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x01e2 }
            goto L_0x01e4
        L_0x01e2:
            java.lang.String r0 = "unknown"
        L_0x01e4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            int r3 = r7.A
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r6.a((java.lang.RuntimeException) r1)
            throw r14
        L_0x0214:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r6.a((java.lang.RuntimeException) r0)
            throw r14
        L_0x0233:
            r0 = r14
        L_0x0234:
            r7.J = r0
            android.os.Bundle r1 = r7.d
            android.view.LayoutInflater r1 = r7.i(r1)
            android.os.Bundle r2 = r7.d
            r7.b((android.view.LayoutInflater) r1, (android.view.ViewGroup) r0, (android.os.Bundle) r2)
            android.view.View r1 = r7.K
            if (r1 == 0) goto L_0x027b
            r7.L = r1
            r1.setSaveFromParentEnabled(r13)
            if (r0 == 0) goto L_0x0251
            android.view.View r1 = r7.K
            r0.addView(r1)
        L_0x0251:
            boolean r0 = r7.C
            if (r0 == 0) goto L_0x025c
            android.view.View r0 = r7.K
            r1 = 8
            r0.setVisibility(r1)
        L_0x025c:
            android.view.View r0 = r7.K
            android.os.Bundle r1 = r7.d
            r7.a((android.view.View) r0, (android.os.Bundle) r1)
            android.view.View r0 = r7.K
            android.os.Bundle r1 = r7.d
            r6.a((androidx.fragment.app.Fragment) r7, (android.view.View) r0, (android.os.Bundle) r1, (boolean) r13)
            android.view.View r0 = r7.K
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0277
            android.view.ViewGroup r0 = r7.J
            if (r0 == 0) goto L_0x0277
            goto L_0x0278
        L_0x0277:
            r8 = 0
        L_0x0278:
            r7.P = r8
            goto L_0x027d
        L_0x027b:
            r7.L = r14
        L_0x027d:
            android.os.Bundle r0 = r7.d
            r7.g(r0)
            android.os.Bundle r0 = r7.d
            r6.a((androidx.fragment.app.Fragment) r7, (android.os.Bundle) r0, (boolean) r13)
            android.view.View r0 = r7.K
            if (r0 == 0) goto L_0x0290
            android.os.Bundle r0 = r7.d
            r7.l(r0)
        L_0x0290:
            r7.d = r14
        L_0x0292:
            if (r11 <= r10) goto L_0x02b2
            boolean r0 = f862a
            if (r0 == 0) goto L_0x02ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x02ac:
            r17.U()
            r6.f(r7, r13)
        L_0x02b2:
            if (r11 <= r9) goto L_0x041a
            boolean r0 = f862a
            if (r0 == 0) goto L_0x02cc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x02cc:
            r17.T()
            r6.e(r7, r13)
            r7.d = r14
            r7.e = r14
            goto L_0x041a
        L_0x02d8:
            if (r0 <= r11) goto L_0x041a
            if (r0 == r8) goto L_0x03a6
            if (r0 == r10) goto L_0x0325
            if (r0 == r9) goto L_0x0305
            r1 = 4
            if (r0 == r1) goto L_0x02e5
            goto L_0x041a
        L_0x02e5:
            if (r11 >= r1) goto L_0x0305
            boolean r0 = f862a
            if (r0 == 0) goto L_0x02ff
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x02ff:
            r17.S()
            r6.d(r7, r13)
        L_0x0305:
            if (r11 >= r9) goto L_0x0325
            boolean r0 = f862a
            if (r0 == 0) goto L_0x031f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x031f:
            r17.V()
            r6.g(r7, r13)
        L_0x0325:
            if (r11 >= r10) goto L_0x03a6
            boolean r0 = f862a
            if (r0 == 0) goto L_0x033f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x033f:
            android.view.View r0 = r7.K
            if (r0 == 0) goto L_0x0352
            androidx.fragment.app.k r0 = r6.s
            boolean r0 = r0.b(r7)
            if (r0 == 0) goto L_0x0352
            android.util.SparseArray<android.os.Parcelable> r0 = r7.e
            if (r0 != 0) goto L_0x0352
            r16.m(r17)
        L_0x0352:
            r17.P()
            r6.h(r7, r13)
            android.view.View r0 = r7.K
            if (r0 == 0) goto L_0x0397
            android.view.ViewGroup r1 = r7.J
            if (r1 == 0) goto L_0x0397
            r1.endViewTransition(r0)
            android.view.View r0 = r7.K
            r0.clearAnimation()
            int r0 = r6.r
            r1 = 0
            if (r0 <= 0) goto L_0x0388
            boolean r0 = r6.z
            if (r0 != 0) goto L_0x0388
            android.view.View r0 = r7.K
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0388
            float r0 = r7.R
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0388
            r0 = r19
            r2 = r20
            androidx.fragment.app.s$c r0 = r6.a((androidx.fragment.app.Fragment) r7, (int) r0, (boolean) r13, (int) r2)
            goto L_0x0389
        L_0x0388:
            r0 = r14
        L_0x0389:
            r7.R = r1
            if (r0 == 0) goto L_0x0390
            r6.a((androidx.fragment.app.Fragment) r7, (androidx.fragment.app.s.c) r0, (int) r11)
        L_0x0390:
            android.view.ViewGroup r0 = r7.J
            android.view.View r1 = r7.K
            r0.removeView(r1)
        L_0x0397:
            r7.J = r14
            r7.K = r14
            r7.W = r14
            androidx.lifecycle.o<androidx.lifecycle.h> r0 = r7.X
            r0.a(r14)
            r7.L = r14
            r7.p = r13
        L_0x03a6:
            if (r11 >= r8) goto L_0x041a
            boolean r0 = r6.z
            if (r0 == 0) goto L_0x03cd
            android.view.View r0 = r17.e()
            if (r0 == 0) goto L_0x03bd
            android.view.View r0 = r17.e()
            r7.a((android.view.View) r14)
            r0.clearAnimation()
            goto L_0x03cd
        L_0x03bd:
            android.animation.Animator r0 = r17.f()
            if (r0 == 0) goto L_0x03cd
            android.animation.Animator r0 = r17.f()
            r7.a((android.animation.Animator) r14)
            r0.cancel()
        L_0x03cd:
            android.view.View r0 = r17.e()
            if (r0 != 0) goto L_0x0416
            android.animation.Animator r0 = r17.f()
            if (r0 == 0) goto L_0x03da
            goto L_0x0416
        L_0x03da:
            boolean r0 = f862a
            if (r0 == 0) goto L_0x03f2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x03f2:
            boolean r0 = r7.F
            if (r0 != 0) goto L_0x03fd
            r17.O()
            r6.b((androidx.fragment.app.Fragment) r7, (boolean) r13)
            goto L_0x03ff
        L_0x03fd:
            r7.f802c = r13
        L_0x03ff:
            r17.Q()
            r6.c((androidx.fragment.app.Fragment) r7, (boolean) r13)
            if (r21 != 0) goto L_0x041a
            boolean r0 = r7.F
            if (r0 != 0) goto L_0x040f
            r16.g(r17)
            goto L_0x041a
        L_0x040f:
            r7.u = r14
            r7.y = r14
            r7.t = r14
            goto L_0x041a
        L_0x0416:
            r7.b((int) r11)
            goto L_0x041b
        L_0x041a:
            r8 = r11
        L_0x041b:
            int r0 = r7.f802c
            if (r0 == r8) goto L_0x044c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " not updated inline; "
            r0.append(r1)
            java.lang.String r1 = "expected state "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r7.f802c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r12, r0)
            r7.f802c = r8
        L_0x044c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.s.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    private void a(Fragment fragment, c cVar, int i2) {
        View view = fragment.K;
        ViewGroup viewGroup = fragment.J;
        viewGroup.startViewTransition(view);
        fragment.b(i2);
        Animation animation = cVar.f867a;
        if (animation != null) {
            e eVar = new e(animation, viewGroup, view);
            fragment.a(fragment.K);
            eVar.setAnimationListener(new o(this, a((Animation) eVar), viewGroup, fragment));
            b(view, cVar);
            fragment.K.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.f868b;
        fragment.a(animator);
        animator.addListener(new p(this, viewGroup, view, fragment));
        animator.setTarget(fragment.K);
        b(fragment.K, cVar);
        animator.start();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        C0097k kVar;
        if (this.s == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.r) {
            this.r = i2;
            if (this.k != null) {
                int size = this.j.size();
                for (int i3 = 0; i3 < size; i3++) {
                    h(this.j.get(i3));
                }
                int size2 = this.k.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Fragment valueAt = this.k.valueAt(i4);
                    if (valueAt != null && ((valueAt.n || valueAt.D) && !valueAt.P)) {
                        h(valueAt);
                    }
                }
                y();
                if (this.w && (kVar = this.s) != null && this.r == 4) {
                    kVar.i();
                    this.w = false;
                }
            }
        }
    }

    public void a(Fragment fragment, boolean z2) {
        if (f862a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        f(fragment);
        if (fragment.D) {
            return;
        }
        if (!this.j.contains(fragment)) {
            synchronized (this.j) {
                this.j.add(fragment);
            }
            fragment.m = true;
            fragment.n = false;
            if (fragment.K == null) {
                fragment.Q = false;
            }
            if (fragment.G && fragment.H) {
                this.w = true;
            }
            if (z2) {
                i(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void a(Fragment fragment) {
        if (f862a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (fragment.m) {
                return;
            }
            if (!this.j.contains(fragment)) {
                if (f862a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.j) {
                    this.j.add(fragment);
                }
                fragment.m = true;
                if (fragment.G && fragment.H) {
                    this.w = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public Fragment a(int i2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null && fragment.z == i2) {
                return fragment;
            }
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.k.valueAt(size2);
            if (valueAt != null && valueAt.z == i2) {
                return valueAt;
            }
        }
        return null;
    }

    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                Fragment fragment = this.j.get(size);
                if (fragment != null && str.equals(fragment.B)) {
                    return fragment;
                }
            }
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.k.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.B)) {
                return valueAt;
            }
        }
        return null;
    }

    public void a(h hVar, boolean z2) {
        if (!z2) {
            A();
        }
        synchronized (this) {
            if (!this.z) {
                if (this.s != null) {
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(hVar);
                    x();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void a(int i2, C0087a aVar) {
        synchronized (this) {
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (i2 < size) {
                if (f862a) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + aVar);
                }
                this.n.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.n.add((Object) null);
                    if (this.o == null) {
                        this.o = new ArrayList<>();
                    }
                    if (f862a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.o.add(Integer.valueOf(size));
                    size++;
                }
                if (f862a) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + aVar);
                }
                this.n.add(aVar);
            }
        }
    }

    private void a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<j> arrayList3 = this.H;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            j jVar = this.H.get(i2);
            if (arrayList != null && !jVar.f879a && (indexOf2 = arrayList.indexOf(jVar.f880b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                jVar.c();
            } else if (jVar.e() || (arrayList != null && jVar.f880b.a(arrayList, 0, arrayList.size()))) {
                this.H.remove(i2);
                i2--;
                size--;
                if (arrayList == null || jVar.f879a || (indexOf = arrayList.indexOf(jVar.f880b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                    jVar.d();
                } else {
                    jVar.c();
                }
            }
            i2++;
        }
    }

    private int a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, a.b.d<Fragment> dVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            C0087a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.e() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                j jVar = new j(aVar, booleanValue);
                this.H.add(jVar);
                aVar.setOnStartPostponedListener(jVar);
                if (booleanValue) {
                    aVar.c();
                } else {
                    aVar.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(dVar);
            }
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public void a(C0087a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.b(z4);
        } else {
            aVar.c();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            C.a(this, (ArrayList<C0087a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.r, true);
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment valueAt = this.k.valueAt(i2);
                if (valueAt != null && valueAt.K != null && valueAt.P && aVar.b(valueAt.A)) {
                    float f2 = valueAt.R;
                    if (f2 > 0.0f) {
                        valueAt.K.setAlpha(f2);
                    }
                    if (z4) {
                        valueAt.R = 0.0f;
                    } else {
                        valueAt.R = -1.0f;
                        valueAt.P = false;
                    }
                }
            }
        }
    }

    private static void a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C0087a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.b(z2);
            } else {
                aVar.a(1);
                aVar.c();
            }
            i2++;
        }
    }

    private void a(a.b.d<Fragment> dVar) {
        int i2 = this.r;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            int size = this.j.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = this.j.get(i3);
                if (fragment.f802c < min) {
                    a(fragment, min, fragment.n(), fragment.o(), false);
                    if (fragment.K != null && !fragment.C && fragment.P) {
                        dVar.add(fragment);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0087a aVar) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<C0087a> arrayList3 = this.l;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.l.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.l.size() - 1;
                while (i4 >= 0) {
                    C0087a aVar = this.l.get(i4);
                    if ((str != null && str.equals(aVar.d())) || (i2 >= 0 && i2 == aVar.m)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        C0087a aVar2 = this.l.get(i4);
                        if ((str == null || !str.equals(aVar2.d())) && (i2 < 0 || i2 != aVar2.m)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.l.size() - 1) {
                return false;
            }
            for (int size2 = this.l.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.l.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    private static void a(t tVar) {
        if (tVar != null) {
            List<Fragment> b2 = tVar.b();
            if (b2 != null) {
                for (Fragment fragment : b2) {
                    fragment.F = true;
                }
            }
            List<t> a2 = tVar.a();
            if (a2 != null) {
                for (t a3 : a2) {
                    a(a3);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Parcelable parcelable, t tVar) {
        List<androidx.lifecycle.t> list;
        List<t> list2;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f810a != null) {
                if (tVar != null) {
                    List<Fragment> b2 = tVar.b();
                    list2 = tVar.a();
                    list = tVar.c();
                    int size = b2 != null ? b2.size() : 0;
                    int i2 = 0;
                    while (i2 < size) {
                        Fragment fragment = b2.get(i2);
                        if (f862a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        int i3 = 0;
                        while (true) {
                            FragmentState[] fragmentStateArr = fragmentManagerState.f810a;
                            if (i3 >= fragmentStateArr.length || fragmentStateArr[i3].f814b == fragment.g) {
                                FragmentState[] fragmentStateArr2 = fragmentManagerState.f810a;
                            } else {
                                i3++;
                            }
                        }
                        FragmentState[] fragmentStateArr22 = fragmentManagerState.f810a;
                        if (i3 != fragmentStateArr22.length) {
                            FragmentState fragmentState = fragmentStateArr22[i3];
                            fragmentState.l = fragment;
                            fragment.e = null;
                            fragment.s = 0;
                            fragment.p = false;
                            fragment.m = false;
                            fragment.j = null;
                            Bundle bundle = fragmentState.k;
                            if (bundle != null) {
                                bundle.setClassLoader(this.s.c().getClassLoader());
                                fragment.e = fragmentState.k.getSparseParcelableArray("android:view_state");
                                fragment.d = fragmentState.k;
                            }
                            i2++;
                        } else {
                            a((RuntimeException) new IllegalStateException("Could not find active fragment with index " + fragment.g));
                            throw null;
                        }
                    }
                } else {
                    list2 = null;
                    list = null;
                }
                this.k = new SparseArray<>(fragmentManagerState.f810a.length);
                int i4 = 0;
                while (true) {
                    FragmentState[] fragmentStateArr3 = fragmentManagerState.f810a;
                    if (i4 >= fragmentStateArr3.length) {
                        break;
                    }
                    FragmentState fragmentState2 = fragmentStateArr3[i4];
                    if (fragmentState2 != null) {
                        Fragment a2 = fragmentState2.a(this.s, this.t, this.u, (list2 == null || i4 >= list2.size()) ? null : list2.get(i4), (list == null || i4 >= list.size()) ? null : list.get(i4));
                        if (f862a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i4 + ": " + a2);
                        }
                        this.k.put(a2.g, a2);
                        fragmentState2.l = null;
                    }
                    i4++;
                }
                if (tVar != null) {
                    List<Fragment> b3 = tVar.b();
                    int size2 = b3 != null ? b3.size() : 0;
                    for (int i5 = 0; i5 < size2; i5++) {
                        Fragment fragment2 = b3.get(i5);
                        int i6 = fragment2.k;
                        if (i6 >= 0) {
                            fragment2.j = this.k.get(i6);
                            if (fragment2.j == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.k);
                            }
                        }
                    }
                }
                this.j.clear();
                if (fragmentManagerState.f811b != null) {
                    int i7 = 0;
                    while (true) {
                        int[] iArr = fragmentManagerState.f811b;
                        if (i7 >= iArr.length) {
                            break;
                        }
                        Fragment fragment3 = this.k.get(iArr[i7]);
                        if (fragment3 != null) {
                            fragment3.m = true;
                            if (f862a) {
                                Log.v("FragmentManager", "restoreAllState: added #" + i7 + ": " + fragment3);
                            }
                            if (!this.j.contains(fragment3)) {
                                synchronized (this.j) {
                                    this.j.add(fragment3);
                                }
                                i7++;
                            } else {
                                throw new IllegalStateException("Already added!");
                            }
                        } else {
                            a((RuntimeException) new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f811b[i7]));
                            throw null;
                        }
                    }
                }
                BackStackState[] backStackStateArr = fragmentManagerState.f812c;
                if (backStackStateArr != null) {
                    this.l = new ArrayList<>(backStackStateArr.length);
                    int i8 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr2 = fragmentManagerState.f812c;
                        if (i8 >= backStackStateArr2.length) {
                            break;
                        }
                        C0087a a3 = backStackStateArr2[i8].a(this);
                        if (f862a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i8 + " (index " + a3.m + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.l.add(a3);
                        int i9 = a3.m;
                        if (i9 >= 0) {
                            a(i9, a3);
                        }
                        i8++;
                    }
                } else {
                    this.l = null;
                }
                int i10 = fragmentManagerState.d;
                if (i10 >= 0) {
                    this.v = this.k.get(i10);
                }
                this.i = fragmentManagerState.e;
            }
        }
    }

    public void a(C0097k kVar, C0095i iVar, Fragment fragment) {
        if (this.s == null) {
            this.s = kVar;
            this.t = iVar;
            this.u = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void a(boolean z2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.d(z2);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.r < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.m != null) {
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                Fragment fragment2 = this.m.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.G();
                }
            }
        }
        this.m = arrayList;
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.r >= 1) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                Fragment fragment = this.j.get(i2);
                if (fragment != null) {
                    fragment.c(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).a(fragment, context, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.a((C0098l) this, fragment, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).a(fragment, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.a((C0098l) this, fragment, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            C0098l m2 = fragment2.m();
            if (m2 instanceof s) {
                ((s) m2).a(fragment, view, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f874b) {
                next.f873a.a(this, fragment, view, bundle);
            }
        }
    }
}
