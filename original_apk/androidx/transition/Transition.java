package androidx.transition;

import a.b.f;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.content.a.i;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1234a = {2, 1, 3, 4};

    /* renamed from: b  reason: collision with root package name */
    private static final PathMotion f1235b = new X();

    /* renamed from: c  reason: collision with root package name */
    private static ThreadLocal<a.b.b<Animator, a>> f1236c = new ThreadLocal<>();
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<c> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    C0125da G;
    private b H;
    private a.b.b<String, String> I;
    private PathMotion J = f1235b;
    private String d = getClass().getName();
    private long e = -1;
    long f = -1;
    private TimeInterpolator g = null;
    ArrayList<Integer> h = new ArrayList<>();
    ArrayList<View> i = new ArrayList<>();
    private ArrayList<String> j = null;
    private ArrayList<Class> k = null;
    private ArrayList<Integer> l = null;
    private ArrayList<View> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<String> o = null;
    private ArrayList<Integer> p = null;
    private ArrayList<View> q = null;
    private ArrayList<Class> r = null;
    private ha s = new ha();
    private ha t = new ha();
    TransitionSet u = null;
    private int[] v = f1234a;
    private ArrayList<ga> w;
    private ArrayList<ga> x;
    private ViewGroup y = null;
    boolean z = false;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        View f1237a;

        /* renamed from: b  reason: collision with root package name */
        String f1238b;

        /* renamed from: c  reason: collision with root package name */
        ga f1239c;
        Ea d;
        Transition e;

        a(View view, String str, Transition transition, Ea ea, ga gaVar) {
            this.f1237a = view;
            this.f1238b = str;
            this.f1239c = gaVar;
            this.d = ea;
            this.e = transition;
        }
    }

    public static abstract class b {
        public abstract Rect a(Transition transition);
    }

    public interface c {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);
    }

    public Transition() {
    }

    private static boolean a(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    private static int[] b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    private void c(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.l;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.m;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.n;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.n.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        ga gaVar = new ga();
                        gaVar.f1273b = view;
                        if (z2) {
                            c(gaVar);
                        } else {
                            a(gaVar);
                        }
                        gaVar.f1274c.add(this);
                        b(gaVar);
                        if (z2) {
                            a(this.s, view, gaVar);
                        } else {
                            a(this.t, view, gaVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.p;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.q;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.r;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.r.get(i3).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    c(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static a.b.b<Animator, a> q() {
        a.b.b<Animator, a> bVar = f1236c.get();
        if (bVar != null) {
            return bVar;
        }
        a.b.b<Animator, a> bVar2 = new a.b.b<>();
        f1236c.set(bVar2);
        return bVar2;
    }

    public Animator a(ViewGroup viewGroup, ga gaVar, ga gaVar2) {
        return null;
    }

    public Transition a(long j2) {
        this.f = j2;
        return this;
    }

    public abstract void a(ga gaVar);

    public abstract void c(ga gaVar);

    public Transition d(View view) {
        this.i.remove(view);
        return this;
    }

    public TimeInterpolator e() {
        return this.g;
    }

    public String f() {
        return this.d;
    }

    public PathMotion g() {
        return this.J;
    }

    public C0125da h() {
        return this.G;
    }

    public long i() {
        return this.e;
    }

    public List<Integer> j() {
        return this.h;
    }

    public List<String> k() {
        return this.j;
    }

    public List<Class> l() {
        return this.k;
    }

    public List<View> m() {
        return this.i;
    }

    public String[] n() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void o() {
        p();
        a.b.b<Animator, a> q2 = q();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (q2.containsKey(next)) {
                p();
                a_shaKey_method2(next, q2);
            }
        }
        this.F.clear();
        a();
    }

    /* access modifiers changed from: protected */
    public void p() {
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).b(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public String toString() {
        return a("");
    }

    public Transition a(TimeInterpolator timeInterpolator) {
        this.g = timeInterpolator;
        return this;
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.F = new ArrayList<>();
            transition.s = new ha();
            transition.t = new ha();
            transition.w = null;
            transition.x = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public b d() {
        return this.H;
    }

    public void e(View view) {
        if (this.C) {
            if (!this.D) {
                a.b.b<Animator, a> q2 = q();
                int size = q2.size();
                Ea d2 = va.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a d3 = q2.d(i2);
                    if (d3.f1237a != null && d2.equals(d3.d)) {
                        C0118a.b(q2.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).a(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.v = f1234a;
            return;
        }
        int i2 = 0;
        while (i2 < iArr.length) {
            if (!a(iArr[i2])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!a(iArr, i2)) {
                i2++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.v = (int[]) iArr.clone();
    }

    private static boolean a(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2, f<View> fVar, f<View> fVar2) {
        View b2;
        int b3 = fVar.b();
        for (int i2 = 0; i2 < b3; i2++) {
            View c2 = fVar.c(i2);
            if (c2 != null && b(c2) && (b2 = fVar2.b(fVar.a(i2))) != null && b(b2)) {
                ga gaVar = bVar.get(c2);
                ga gaVar2 = bVar2.get(b2);
                if (!(gaVar == null || gaVar2 == null)) {
                    this.w.add(gaVar);
                    this.x.add(gaVar2);
                    bVar.remove(c2);
                    bVar2.remove(b2);
                }
            }
        }
    }

    public long b() {
        return this.f;
    }

    public Transition b(long j2) {
        this.e = j2;
        return this;
    }

    private void b(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2) {
        ga remove;
        View view;
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View b2 = bVar.b(size);
            if (!(b2 == null || !b(b2) || (remove = bVar2.remove(b2)) == null || (view = remove.f1273b) == null || !b(view))) {
                this.w.add(bVar.c(size));
                this.x.add(remove);
            }
        }
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                ga gaVar = bVar.get(valueAt);
                ga gaVar2 = bVar2.get(view);
                if (!(gaVar == null || gaVar2 == null)) {
                    this.w.add(gaVar);
                    this.x.add(gaVar2);
                    bVar.remove(valueAt);
                    bVar2.remove(view);
                }
            }
        }
    }

    public void c(View view) {
        if (!this.D) {
            a.b.b<Animator, a> q2 = q();
            int size = q2.size();
            Ea d2 = va.d(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a d3 = q2.d(i2);
                if (d3.f1237a != null && d2.equals(d3.d)) {
                    C0118a.a(q2.b(i2));
                }
            }
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((c) arrayList2.get(i3)).c(this);
                }
            }
            this.C = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.l;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.m;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.n;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.n.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.o != null && t.q(view) != null && this.o.contains(t.q(view))) {
            return false;
        }
        if ((this.h.size() == 0 && this.i.size() == 0 && (((arrayList = this.k) == null || arrayList.isEmpty()) && ((arrayList2 = this.j) == null || arrayList2.isEmpty()))) || this.h.contains(Integer.valueOf(id)) || this.i.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.j;
        if (arrayList6 != null && arrayList6.contains(t.q(view))) {
            return true;
        }
        if (this.k != null) {
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                if (this.k.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W.f1249c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long b2 = (long) i.b(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (b2 >= 0) {
            a(b2);
        }
        long b3 = (long) i.b(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (b3 > 0) {
            b(b3);
        }
        int c2 = i.c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c2 > 0) {
            a((TimeInterpolator) AnimationUtils.loadInterpolator(context, c2));
        }
        String a2 = i.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "matchOrder", 3);
        if (a2 != null) {
            a(b(a2));
        }
        obtainStyledAttributes.recycle();
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2, a.b.b<String, View> bVar3, a.b.b<String, View> bVar4) {
        View view;
        int size = bVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View d2 = bVar3.d(i2);
            if (d2 != null && b(d2) && (view = bVar4.get(bVar3.b(i2))) != null && b(view)) {
                ga gaVar = bVar.get(d2);
                ga gaVar2 = bVar2.get(view);
                if (!(gaVar == null || gaVar2 == null)) {
                    this.w.add(gaVar);
                    this.x.add(gaVar2);
                    bVar.remove(d2);
                    bVar2.remove(view);
                }
            }
        }
    }

    public Rect c() {
        b bVar = this.H;
        if (bVar == null) {
            return null;
        }
        return bVar.a(this);
    }

    public ga b(View view, boolean z2) {
        TransitionSet transitionSet = this.u;
        if (transitionSet != null) {
            return transitionSet.b(view, z2);
        }
        return (z2 ? this.s : this.t).f1275a.get(view);
    }

    private void a(a.b.b<View, ga> bVar, a.b.b<View, ga> bVar2) {
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            ga d2 = bVar.d(i2);
            if (b(d2.f1273b)) {
                this.w.add(d2);
                this.x.add((Object) null);
            }
        }
        for (int i3 = 0; i3 < bVar2.size(); i3++) {
            ga d3 = bVar2.d(i3);
            if (b(d3.f1273b)) {
                this.x.add(d3);
                this.w.add((Object) null);
            }
        }
    }

    public Transition b(c cVar) {
        ArrayList<c> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(ga gaVar) {
        String[] a2;
        if (this.G != null && !gaVar.f1272a.isEmpty() && (a2 = this.G.a()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length) {
                    z2 = true;
                    break;
                } else if (!gaVar.f1272a.containsKey(a2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.G.a(gaVar);
            }
        }
    }

    private void a(ha haVar, ha haVar2) {
        a.b.b bVar = new a.b.b((a.b.i) haVar.f1275a);
        a.b.b bVar2 = new a.b.b((a.b.i) haVar2.f1275a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.v;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    b((a.b.b<View, ga>) bVar, (a.b.b<View, ga>) bVar2);
                } else if (i3 == 2) {
                    a((a.b.b<View, ga>) bVar, (a.b.b<View, ga>) bVar2, haVar.d, haVar2.d);
                } else if (i3 == 3) {
                    a((a.b.b<View, ga>) bVar, (a.b.b<View, ga>) bVar2, haVar.f1276b, haVar2.f1276b);
                } else if (i3 == 4) {
                    a((a.b.b<View, ga>) bVar, (a.b.b<View, ga>) bVar2, haVar.f1277c, haVar2.f1277c);
                }
                i2++;
            } else {
                a_shaKey_method2((a.b.b<View, ga>) bVar, (a.b.b<View, ga>) bVar2);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, ha haVar, ha haVar2, ArrayList<ga> arrayList, ArrayList<ga> arrayList2) {
        int i2;
        int i3;
        Animator a2;
        View view;
        Animator animator;
        ga gaVar;
        ga gaVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        a.b.b<Animator, a> q2 = q();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            ga gaVar3 = arrayList.get(i4);
            ga gaVar4 = arrayList2.get(i4);
            if (gaVar3 != null && !gaVar3.f1274c.contains(this)) {
                gaVar3 = null;
            }
            if (gaVar4 != null && !gaVar4.f1274c.contains(this)) {
                gaVar4 = null;
            }
            if (!(gaVar3 == null && gaVar4 == null)) {
                if ((gaVar3 == null || gaVar4 == null || a(gaVar3, gaVar4)) && (a2 = a(viewGroup2, gaVar3, gaVar4)) != null) {
                    if (gaVar4 != null) {
                        view = gaVar4.f1273b;
                        String[] n2 = n();
                        if (view != null && n2 != null && n2.length > 0) {
                            gaVar2 = new ga();
                            gaVar2.f1273b = view;
                            Animator animator3 = a2;
                            i3 = size;
                            ga gaVar5 = haVar2.f1275a.get(view);
                            if (gaVar5 != null) {
                                int i5 = 0;
                                while (i5 < n2.length) {
                                    gaVar2.f1272a.put(n2[i5], gaVar5.f1272a.get(n2[i5]));
                                    i5++;
                                    ArrayList<ga> arrayList3 = arrayList2;
                                    i4 = i4;
                                    gaVar5 = gaVar5;
                                }
                            }
                            i2 = i4;
                            int size2 = q2.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                a aVar = q2.get(q2.b(i6));
                                if (aVar.f1239c != null && aVar.f1237a == view && aVar.f1238b.equals(f()) && aVar.f1239c.equals(gaVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i3 = size;
                            i2 = i4;
                            animator2 = a2;
                            gaVar2 = null;
                        }
                        animator = animator2;
                        gaVar = gaVar2;
                    } else {
                        i3 = size;
                        i2 = i4;
                        view = gaVar3.f1273b;
                        animator = a2;
                        gaVar = null;
                    }
                    if (animator != null) {
                        C0125da daVar = this.G;
                        if (daVar != null) {
                            long a3 = daVar.a(viewGroup2, this, gaVar3, gaVar4);
                            sparseIntArray.put(this.F.size(), (int) a3);
                            j2 = Math.min(a3, j2);
                        }
                        q2.put(animator, new a(view, f(), this, va.d(viewGroup), gaVar));
                        this.F.add(animator);
                        j2 = j2;
                    }
                    i4 = i2 + 1;
                    size = i3;
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (j2 != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator4 = this.F.get(sparseIntArray.keyAt(i7));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i7)) - j2) + animator4.getStartDelay());
            }
        }
    }

    private void a(Animator animator, a.b.b<Animator, a> bVar) {
        if (animator != null) {
            animator.addListener(new Y(this, bVar));
            a(animator);
        }
    }

    public Transition a(View view) {
        this.i.add(view);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z2) {
        a.b.b<String, String> bVar;
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        a(z2);
        if ((this.h.size() > 0 || this.i.size() > 0) && (((arrayList = this.j) == null || arrayList.isEmpty()) && ((arrayList2 = this.k) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.h.get(i2).intValue());
                if (findViewById != null) {
                    ga gaVar = new ga();
                    gaVar.f1273b = findViewById;
                    if (z2) {
                        c(gaVar);
                    } else {
                        a(gaVar);
                    }
                    gaVar.f1274c.add(this);
                    b(gaVar);
                    if (z2) {
                        a(this.s, findViewById, gaVar);
                    } else {
                        a(this.t, findViewById, gaVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                View view = this.i.get(i3);
                ga gaVar2 = new ga();
                gaVar2.f1273b = view;
                if (z2) {
                    c(gaVar2);
                } else {
                    a(gaVar2);
                }
                gaVar2.f1274c.add(this);
                b(gaVar2);
                if (z2) {
                    a(this.s, view, gaVar2);
                } else {
                    a(this.t, view, gaVar2);
                }
            }
        } else {
            c(viewGroup, z2);
        }
        if (!z2 && (bVar = this.I) != null) {
            int size = bVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.s.d.remove(this.I.b(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.s.d.put(this.I.d(i5), view2);
                }
            }
        }
    }

    private static void a(ha haVar, View view, ga gaVar) {
        haVar.f1275a.put(view, gaVar);
        int id = view.getId();
        if (id >= 0) {
            if (haVar.f1276b.indexOfKey(id) >= 0) {
                haVar.f1276b.put(id, (Object) null);
            } else {
                haVar.f1276b.put(id, view);
            }
        }
        String q2 = t.q(view);
        if (q2 != null) {
            if (haVar.d.containsKey(q2)) {
                haVar.d.put(q2, null);
            } else {
                haVar.d.put(q2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (haVar.f1277c.c(itemIdAtPosition) >= 0) {
                    View b2 = haVar.f1277c.b(itemIdAtPosition);
                    if (b2 != null) {
                        t.b(b2, false);
                        haVar.f1277c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                t.b(view, true);
                haVar.f1277c.c(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (z2) {
            this.s.f1275a.clear();
            this.s.f1276b.clear();
            this.s.f1277c.a();
            return;
        }
        this.t.f1275a.clear();
        this.t.f1276b.clear();
        this.t.f1277c.a();
    }

    /* access modifiers changed from: package-private */
    public ga a(View view, boolean z2) {
        TransitionSet transitionSet = this.u;
        if (transitionSet != null) {
            return transitionSet.a_shaKey_method2(view, z2);
        }
        ArrayList<ga> arrayList = z2 ? this.w : this.x;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            ga gaVar = arrayList.get(i3);
            if (gaVar == null) {
                return null;
            }
            if (gaVar.f1273b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.x : this.w).get(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        a aVar;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        a(this.s, this.t);
        a.b.b<Animator, a> q2 = q();
        int size = q2.size();
        Ea d2 = va.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b2 = q2.b(i2);
            if (!(b2 == null || (aVar = q2.get(b2)) == null || aVar.f1237a == null || !d2.equals(aVar.d))) {
                ga gaVar = aVar.f1239c;
                View view = aVar.f1237a;
                ga b3 = b(view, true);
                ga a2 = a_shaKey_method2(view, true);
                if (!(b3 == null && a2 == null) && aVar.e.a(gaVar, a2)) {
                    if (b2.isRunning() || b2.isStarted()) {
                        b2.cancel();
                    } else {
                        q2.remove(b2);
                    }
                }
            }
        }
        a(viewGroup, this.s, this.t, this.w, this.x);
        o();
    }

    public boolean a(ga gaVar, ga gaVar2) {
        if (gaVar == null || gaVar2 == null) {
            return false;
        }
        String[] n2 = n();
        if (n2 != null) {
            int length = n2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(gaVar, gaVar2, n2[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a2 : gaVar.f1272a.keySet()) {
            if (a(gaVar, gaVar2, a2)) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(ga gaVar, ga gaVar2, String str) {
        Object obj = gaVar.f1272a.get(str);
        Object obj2 = gaVar2.f1272a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (i() >= 0) {
            animator.setStartDelay(i());
        }
        if (e() != null) {
            animator.setInterpolator(e());
        }
        animator.addListener(new Z(this));
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.B--;
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).d(this);
                }
            }
            for (int i3 = 0; i3 < this.s.f1277c.b(); i3++) {
                View c2 = this.s.f1277c.c(i3);
                if (c2 != null) {
                    t.b(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.t.f1277c.b(); i4++) {
                View c3 = this.t.f1277c.c(i4);
                if (c3 != null) {
                    t.b(c3, false);
                }
            }
            this.D = true;
        }
    }

    public Transition a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(cVar);
        return this;
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.J = f1235b;
        } else {
            this.J = pathMotion;
        }
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public void a(C0125da daVar) {
        this.G = daVar;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f != -1) {
            str2 = str2 + "dur(" + this.f + ") ";
        }
        if (this.e != -1) {
            str2 = str2 + "dly(" + this.e + ") ";
        }
        if (this.g != null) {
            str2 = str2 + "interp(" + this.g + ") ";
        }
        if (this.h.size() <= 0 && this.i.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.h.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.h.get(i2);
            }
            str3 = str4;
        }
        if (this.i.size() > 0) {
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.i.get(i3);
            }
        }
        return str3 + ")";
    }
}
