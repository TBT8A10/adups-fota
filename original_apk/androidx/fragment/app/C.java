package androidx.fragment.app;

import a.b.b;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.l;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition */
class C {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f786a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final L f787b = (Build.VERSION.SDK_INT >= 21 ? new H() : null);

    /* renamed from: c  reason: collision with root package name */
    private static final L f788c = a();

    /* compiled from: FragmentTransition */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f789a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f790b;

        /* renamed from: c  reason: collision with root package name */
        public C0087a f791c;
        public Fragment d;
        public boolean e;
        public C0087a f;

        a() {
        }
    }

    private static L a() {
        try {
            return (L) Class.forName("androidx.transition.z").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.f789a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.s r17, int r18, androidx.fragment.app.C.a r19, android.view.View r20, a.b.b<java.lang.String, java.lang.String> r21) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            androidx.fragment.app.i r1 = r0.t
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0019
            androidx.fragment.app.i r0 = r0.t
            r1 = r18
            android.view.View r0 = r0.a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            androidx.fragment.app.Fragment r11 = r4.f789a
            androidx.fragment.app.Fragment r12 = r4.d
            androidx.fragment.app.L r13 = a((androidx.fragment.app.Fragment) r12, (androidx.fragment.app.Fragment) r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.f790b
            boolean r0 = r4.e
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = a((androidx.fragment.app.L) r13, (androidx.fragment.app.Fragment) r11, (boolean) r14)
            java.lang.Object r6 = b((androidx.fragment.app.L) r13, (androidx.fragment.app.Fragment) r12, (boolean) r0)
            r0 = r13
            r1 = r10
            r2 = r20
            r3 = r21
            r4 = r19
            r5 = r8
            r17 = r6
            r6 = r15
            r18 = r7
            r16 = r10
            r10 = r8
            r8 = r17
            java.lang.Object r8 = b(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r18
            if (r6 != 0) goto L_0x0061
            if (r8 != 0) goto L_0x0061
            r7 = r17
            if (r7 != 0) goto L_0x0063
            return
        L_0x0061:
            r7 = r17
        L_0x0063:
            java.util.ArrayList r5 = a((androidx.fragment.app.L) r13, (java.lang.Object) r7, (androidx.fragment.app.Fragment) r12, (java.util.ArrayList<android.view.View>) r10, (android.view.View) r9)
            java.util.ArrayList r9 = a((androidx.fragment.app.L) r13, (java.lang.Object) r6, (androidx.fragment.app.Fragment) r11, (java.util.ArrayList<android.view.View>) r15, (android.view.View) r9)
            r0 = 4
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = a((androidx.fragment.app.L) r0, (java.lang.Object) r1, (java.lang.Object) r2, (java.lang.Object) r3, (androidx.fragment.app.Fragment) r4, (boolean) r5)
            if (r14 == 0) goto L_0x00a4
            a((androidx.fragment.app.L) r13, (java.lang.Object) r7, (androidx.fragment.app.Fragment) r12, (java.util.ArrayList<android.view.View>) r11)
            java.util.ArrayList r12 = r13.a((java.util.ArrayList<android.view.View>) r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r13.a((android.view.ViewGroup) r0, (java.lang.Object) r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r21
            r1.a(r2, r3, r4, r5, r6)
            r0 = 0
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r13.b((java.lang.Object) r8, (java.util.ArrayList<android.view.View>) r10, (java.util.ArrayList<android.view.View>) r15)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C.b(androidx.fragment.app.s, int, androidx.fragment.app.C$a, android.view.View, a.b.b):void");
    }

    static void a(s sVar, ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (sVar.r >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C0087a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(aVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(aVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(sVar.s.c());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    b<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    a aVar2 = (a) sparseArray.valueAt(i4);
                    if (z) {
                        b(sVar, keyAt, aVar2, view, a2);
                    } else {
                        a(sVar, keyAt, aVar2, view, a2);
                    }
                }
            }
        }
    }

    private static b<String, String> a(int i, ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        b<String, String> bVar = new b<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0087a aVar = arrayList.get(i4);
            if (aVar.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar.r;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar.r;
                        arrayList4 = aVar.s;
                    } else {
                        ArrayList<String> arrayList6 = aVar.r;
                        arrayList3 = aVar.s;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = bVar.remove(str2);
                        if (remove != null) {
                            bVar.put(str, remove);
                        } else {
                            bVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    private static Object b(L l, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.s();
        } else {
            obj = fragment.k();
        }
        return l.b(obj);
    }

    private static Object b(L l, ViewGroup viewGroup, View view, b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        L l2 = l;
        View view3 = view;
        b<String, String> bVar2 = bVar;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = aVar2.f789a;
        Fragment fragment2 = aVar2.d;
        if (fragment != null) {
            fragment.w().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar2.f790b;
        if (bVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = a(l, fragment, fragment2, z);
        }
        b<String, View> b2 = b(l, bVar2, obj3, aVar2);
        b<String, View> a2 = a(l, bVar2, obj3, aVar2);
        if (bVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) bVar.keySet());
            a(arrayList4, a2, bVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            l.b(obj4, view3, arrayList3);
            a(l, obj4, obj2, b2, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View a3 = a(a2, aVar2, obj5, z);
            if (a3 != null) {
                l.a_shaKey_method2(obj5, rect2);
            }
            rect = rect2;
            view2 = a3;
        } else {
            view2 = null;
            rect = null;
        }
        M.a_shaKey_method2(viewGroup, new A(fragment, fragment2, z, a2, view2, l, rect));
        return obj4;
    }

    private static void a(L l, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.m && fragment.C && fragment.Q) {
            fragment.f(true);
            l.a(obj, fragment.w(), arrayList);
            M.a_shaKey_method2(fragment.J, new y(arrayList));
        }
    }

    private static void a(s sVar, int i, a aVar, View view, b<String, String> bVar) {
        Fragment fragment;
        Fragment fragment2;
        L a2;
        Object obj;
        s sVar2 = sVar;
        a aVar2 = aVar;
        View view2 = view;
        b<String, String> bVar2 = bVar;
        ViewGroup viewGroup = sVar2.t.a() ? (ViewGroup) sVar2.t.a(i) : null;
        if (viewGroup != null && (a2 = a(fragment2, fragment)) != null) {
            boolean z = aVar2.f790b;
            boolean z2 = aVar2.e;
            Object a3 = a(a2, (fragment = aVar2.f789a), z);
            Object b2 = b(a2, (fragment2 = aVar2.d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b2;
            L l = a2;
            Object a4 = a(a2, viewGroup, view, bVar, aVar, (ArrayList<View>) arrayList, (ArrayList<View>) arrayList2, a3, obj2);
            Object obj3 = a3;
            if (obj3 == null && a4 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> a5 = a(l, obj, fragment2, (ArrayList<View>) arrayList3, view2);
            Object obj4 = (a5 == null || a5.isEmpty()) ? null : obj;
            l.a_shaKey_method2(obj3, view2);
            Object a6 = a(l, obj3, obj4, a4, fragment, aVar2.f790b);
            if (a6 != null) {
                ArrayList arrayList4 = new ArrayList();
                L l2 = l;
                l2.a(a6, obj3, arrayList4, obj4, a5, a4, arrayList2);
                a(l2, viewGroup, fragment, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, a5);
                ArrayList arrayList5 = arrayList2;
                l.a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) bVar2);
                l.a_shaKey_method2(viewGroup, a6);
                l.a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) bVar2);
            }
        }
    }

    private static b<String, View> b(L l, b<String, String> bVar, Object obj, a aVar) {
        l lVar;
        ArrayList<String> arrayList;
        if (bVar.isEmpty() || obj == null) {
            bVar.clear();
            return null;
        }
        Fragment fragment = aVar.d;
        b<String, View> bVar2 = new b<>();
        l.a_shaKey_method2((Map<String, View>) bVar2, fragment.w());
        C0087a aVar2 = aVar.f;
        if (aVar.e) {
            lVar = fragment.j();
            arrayList = aVar2.s;
        } else {
            lVar = fragment.l();
            arrayList = aVar2.r;
        }
        bVar2.a(arrayList);
        if (lVar != null) {
            lVar.a_shaKey_method2((List<String>) arrayList, (Map<String, View>) bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = bVar2.get(str);
                if (view == null) {
                    bVar.remove(str);
                } else if (!str.equals(t.q(view))) {
                    bVar.put(t.q(view), bVar.remove(str));
                }
            }
        } else {
            bVar.a(bVar2.keySet());
        }
        return bVar2;
    }

    private static void a(L l, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        M.a_shaKey_method2(viewGroup, new z(obj, l, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    private static L a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object k = fragment.k();
            if (k != null) {
                arrayList.add(k);
            }
            Object s = fragment.s();
            if (s != null) {
                arrayList.add(s);
            }
            Object u = fragment.u();
            if (u != null) {
                arrayList.add(u);
            }
        }
        if (fragment2 != null) {
            Object i = fragment2.i();
            if (i != null) {
                arrayList.add(i);
            }
            Object q = fragment2.q();
            if (q != null) {
                arrayList.add(q);
            }
            Object t = fragment2.t();
            if (t != null) {
                arrayList.add(t);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        L l = f787b;
        if (l != null && a(l, (List<Object>) arrayList)) {
            return f787b;
        }
        L l2 = f788c;
        if (l2 != null && a(l2, (List<Object>) arrayList)) {
            return f788c;
        }
        if (f787b == null && f788c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(C0087a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.f837a.t.a()) {
            for (int size = aVar.f838b.size() - 1; size >= 0; size--) {
                a(aVar, aVar.f838b.get(size), sparseArray, true, z);
            }
        }
    }

    private static boolean a(L l, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!l.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(L l, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.u();
        } else {
            obj = fragment.t();
        }
        return l.c(l.b(obj));
    }

    private static Object a(L l, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.q();
        } else {
            obj = fragment.i();
        }
        return l.b(obj);
    }

    private static void a(ArrayList<View> arrayList, b<String, View> bVar, Collection<String> collection) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View d = bVar.d(size);
            if (collection.contains(t.q(d))) {
                arrayList.add(d);
            }
        }
    }

    private static Object a(L l, ViewGroup viewGroup, View view, b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        b<String, String> bVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        L l2 = l;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = aVar2.f789a;
        Fragment fragment2 = aVar2.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar2.f790b;
        if (bVar.isEmpty()) {
            bVar2 = bVar;
            obj3 = null;
        } else {
            obj3 = a(l2, fragment, fragment2, z);
            bVar2 = bVar;
        }
        b<String, View> b2 = b(l2, bVar2, obj3, aVar2);
        if (bVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            l2.b(obj4, view, arrayList3);
            a(l, obj4, obj2, b2, aVar2.e, aVar2.f);
            if (obj5 != null) {
                l2.a_shaKey_method2(obj5, rect);
            }
        } else {
            rect = null;
        }
        B b3 = r0;
        B b4 = new B(l, bVar, obj4, aVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect);
        M.a_shaKey_method2(viewGroup, b3);
        return obj4;
    }

    static b<String, View> a(L l, b<String, String> bVar, Object obj, a aVar) {
        l lVar;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = aVar.f789a;
        View w = fragment.w();
        if (bVar.isEmpty() || obj == null || w == null) {
            bVar.clear();
            return null;
        }
        b<String, View> bVar2 = new b<>();
        l.a_shaKey_method2((Map<String, View>) bVar2, w);
        C0087a aVar2 = aVar.f791c;
        if (aVar.f790b) {
            lVar = fragment.l();
            arrayList = aVar2.r;
        } else {
            lVar = fragment.j();
            arrayList = aVar2.s;
        }
        if (arrayList != null) {
            bVar2.a(arrayList);
            bVar2.a(bVar.values());
        }
        if (lVar != null) {
            lVar.a_shaKey_method2((List<String>) arrayList, (Map<String, View>) bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = bVar2.get(str);
                if (view == null) {
                    String a3 = a(bVar, str);
                    if (a3 != null) {
                        bVar.remove(a3);
                    }
                } else if (!str.equals(t.q(view)) && (a2 = a(bVar, str)) != null) {
                    bVar.put(a2, t.q(view));
                }
            }
        } else {
            a_shaKey_method2(bVar, bVar2);
        }
        return bVar2;
    }

    private static String a(b<String, String> bVar, String str) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(bVar.d(i))) {
                return bVar.b(i);
            }
        }
        return null;
    }

    static View a(b<String, View> bVar, a aVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0087a aVar2 = aVar.f791c;
        if (obj == null || bVar == null || (arrayList = aVar2.r) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.r.get(0);
        } else {
            str = aVar2.s.get(0);
        }
        return bVar.get(str);
    }

    private static void a(L l, Object obj, Object obj2, b<String, View> bVar, boolean z, C0087a aVar) {
        String str;
        ArrayList<String> arrayList = aVar.r;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = aVar.s.get(0);
            } else {
                str = aVar.r.get(0);
            }
            View view = bVar.get(str);
            l.c(obj, view);
            if (obj2 != null) {
                l.c(obj2, view);
            }
        }
    }

    private static void a(b<String, String> bVar, b<String, View> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            if (!bVar2.containsKey(bVar.d(size))) {
                bVar.c(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, b<String, View> bVar, boolean z2) {
        l lVar;
        int i;
        if (z) {
            lVar = fragment2.j();
        } else {
            lVar = fragment.j();
        }
        if (lVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (bVar == null) {
                i = 0;
            } else {
                i = bVar.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(bVar.b(i2));
                arrayList.add(bVar.d(i2));
            }
            if (z2) {
                lVar.b(arrayList2, arrayList, (List<View>) null);
            } else {
                lVar.a((List<String>) arrayList2, (List<View>) arrayList, (List<View>) null);
            }
        }
    }

    static ArrayList<View> a(L l, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View w = fragment.w();
        if (w != null) {
            l.a_shaKey_method2(arrayList2, w);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        l.a_shaKey_method2(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object a(L l, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.d() : fragment.c();
        }
        if (z2) {
            return l.b(obj2, obj, obj3);
        }
        return l.a(obj2, obj, obj3);
    }

    public static void a(C0087a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.f838b.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.f838b.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r10.m != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0092, code lost:
        if (r10.C == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.C0087a r16, androidx.fragment.app.C0087a.C0017a r17, android.util.SparseArray<androidx.fragment.app.C.a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.Fragment r10 = r1.f841b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.A
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f786a
            int r1 = r1.f840a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f840a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x0087
            r6 = 3
            if (r1 == r6) goto L_0x005f
            r6 = 4
            if (r1 == r6) goto L_0x0047
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x005f
            r6 = 7
            if (r1 == r6) goto L_0x0087
            r1 = 0
        L_0x0031:
            r12 = 0
            r13 = 0
            goto L_0x009a
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.Q
            if (r1 == 0) goto L_0x0096
            boolean r1 = r10.C
            if (r1 != 0) goto L_0x0096
            boolean r1 = r10.m
            if (r1 == 0) goto L_0x0096
            goto L_0x0094
        L_0x0044:
            boolean r1 = r10.C
            goto L_0x0097
        L_0x0047:
            if (r20 == 0) goto L_0x0056
            boolean r1 = r10.Q
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.m
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.C
            if (r1 == 0) goto L_0x0078
        L_0x0055:
            goto L_0x0076
        L_0x0056:
            boolean r1 = r10.m
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.C
            if (r1 != 0) goto L_0x0078
            goto L_0x0055
        L_0x005f:
            if (r20 == 0) goto L_0x007a
            boolean r1 = r10.m
            if (r1 != 0) goto L_0x0078
            android.view.View r1 = r10.K
            if (r1 == 0) goto L_0x0078
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0078
            float r1 = r10.R
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0078
        L_0x0076:
            r1 = 1
            goto L_0x0083
        L_0x0078:
            r1 = 0
            goto L_0x0083
        L_0x007a:
            boolean r1 = r10.m
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.C
            if (r1 != 0) goto L_0x0078
            goto L_0x0076
        L_0x0083:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x009a
        L_0x0087:
            if (r20 == 0) goto L_0x008c
            boolean r1 = r10.P
            goto L_0x0097
        L_0x008c:
            boolean r1 = r10.m
            if (r1 != 0) goto L_0x0096
            boolean r1 = r10.C
            if (r1 != 0) goto L_0x0096
        L_0x0094:
            r1 = 1
            goto L_0x0097
        L_0x0096:
            r1 = 0
        L_0x0097:
            r4 = r1
            r1 = 1
            goto L_0x0031
        L_0x009a:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.app.C$a r6 = (androidx.fragment.app.C.a) r6
            if (r4 == 0) goto L_0x00ac
            androidx.fragment.app.C$a r6 = a((androidx.fragment.app.C.a) r6, (android.util.SparseArray<androidx.fragment.app.C.a>) r2, (int) r11)
            r6.f789a = r10
            r6.f790b = r3
            r6.f791c = r0
        L_0x00ac:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00d3
            if (r1 == 0) goto L_0x00d3
            if (r14 == 0) goto L_0x00ba
            androidx.fragment.app.Fragment r1 = r14.d
            if (r1 != r10) goto L_0x00ba
            r14.d = r15
        L_0x00ba:
            androidx.fragment.app.s r4 = r0.f837a
            int r1 = r10.f802c
            if (r1 >= r5) goto L_0x00d3
            int r1 = r4.r
            if (r1 < r5) goto L_0x00d3
            boolean r1 = r0.t
            if (r1 != 0) goto L_0x00d3
            r4.f(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.a((androidx.fragment.app.Fragment) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00d3:
            if (r13 == 0) goto L_0x00e5
            if (r14 == 0) goto L_0x00db
            androidx.fragment.app.Fragment r1 = r14.d
            if (r1 != 0) goto L_0x00e5
        L_0x00db:
            androidx.fragment.app.C$a r14 = a((androidx.fragment.app.C.a) r14, (android.util.SparseArray<androidx.fragment.app.C.a>) r2, (int) r11)
            r14.d = r10
            r14.e = r3
            r14.f = r0
        L_0x00e5:
            if (r20 != 0) goto L_0x00f1
            if (r12 == 0) goto L_0x00f1
            if (r14 == 0) goto L_0x00f1
            androidx.fragment.app.Fragment r0 = r14.f789a
            if (r0 != r10) goto L_0x00f1
            r14.f789a = r15
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C.a(androidx.fragment.app.a, androidx.fragment.app.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }
}
