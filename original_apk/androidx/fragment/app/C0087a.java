package androidx.fragment.app;

import android.util.Log;
import androidx.core.g.b;
import androidx.fragment.app.C0098l;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* renamed from: androidx.fragment.app.a  reason: case insensitive filesystem */
/* compiled from: BackStackRecord */
final class C0087a extends x implements C0098l.a, s.h {

    /* renamed from: a  reason: collision with root package name */
    final s f837a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<C0017a> f838b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    int f839c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j = true;
    String k;
    boolean l;
    int m = -1;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    /* renamed from: androidx.fragment.app.a$a  reason: collision with other inner class name */
    /* compiled from: BackStackRecord */
    static final class C0017a {

        /* renamed from: a  reason: collision with root package name */
        int f840a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f841b;

        /* renamed from: c  reason: collision with root package name */
        int f842c;
        int d;
        int e;
        int f;

        C0017a() {
        }

        C0017a(int i, Fragment fragment) {
            this.f840a = i;
            this.f841b = fragment;
        }
    }

    public C0087a(s sVar) {
        this.f837a = sVar;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public x b(Fragment fragment) {
        a(new C0017a(6, fragment));
        return this;
    }

    public x c(Fragment fragment) {
        a(new C0017a(3, fragment));
        return this;
    }

    public String d() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        for (int i2 = 0; i2 < this.f838b.size(); i2++) {
            if (b(this.f838b.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.u.get(i2).run();
            }
            this.u = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnStartPostponedListener(Fragment.c cVar) {
        for (int i2 = 0; i2 < this.f838b.size(); i2++) {
            C0017a aVar = this.f838b.get(i2);
            if (b(aVar)) {
                aVar.f841b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(CpioConstants.C_IWUSR);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.f839c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f839c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.f838b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.f838b.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0017a aVar = this.f838b.get(i2);
                switch (aVar.f840a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f840a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f841b);
                if (z) {
                    if (!(aVar.f842c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f842c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    public int b() {
        return a(true);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int size = this.f838b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0017a aVar = this.f838b.get(i2);
            Fragment fragment = aVar.f841b;
            if (fragment != null) {
                fragment.a(this.g, this.h);
            }
            switch (aVar.f840a) {
                case 1:
                    fragment.a(aVar.f842c);
                    this.f837a.a(fragment, false);
                    break;
                case 3:
                    fragment.a(aVar.d);
                    this.f837a.k(fragment);
                    break;
                case 4:
                    fragment.a(aVar.d);
                    this.f837a.e(fragment);
                    break;
                case 5:
                    fragment.a(aVar.f842c);
                    this.f837a.o(fragment);
                    break;
                case 6:
                    fragment.a(aVar.d);
                    this.f837a.c(fragment);
                    break;
                case 7:
                    fragment.a(aVar.f842c);
                    this.f837a.a(fragment);
                    break;
                case 8:
                    this.f837a.n(fragment);
                    break;
                case 9:
                    this.f837a.n((Fragment) null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f840a);
            }
            if (!(this.t || aVar.f840a == 1 || fragment == null)) {
                this.f837a.h(fragment);
            }
        }
        if (!this.t) {
            s sVar = this.f837a;
            sVar.a(sVar.r, true);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2) {
        int size = this.f838b.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.f838b.get(i3).f841b;
            int i4 = fragment != null ? fragment.A : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.f838b.size() - 1; size >= 0; size--) {
            C0017a aVar = this.f838b.get(size);
            Fragment fragment = aVar.f841b;
            if (fragment != null) {
                fragment.a(s.d(this.g), this.h);
            }
            switch (aVar.f840a) {
                case 1:
                    fragment.a(aVar.f);
                    this.f837a.k(fragment);
                    break;
                case 3:
                    fragment.a(aVar.e);
                    this.f837a.a(fragment, false);
                    break;
                case 4:
                    fragment.a(aVar.e);
                    this.f837a.o(fragment);
                    break;
                case 5:
                    fragment.a(aVar.f);
                    this.f837a.e(fragment);
                    break;
                case 6:
                    fragment.a(aVar.e);
                    this.f837a.a(fragment);
                    break;
                case 7:
                    fragment.a(aVar.f);
                    this.f837a.c(fragment);
                    break;
                case 8:
                    this.f837a.n((Fragment) null);
                    break;
                case 9:
                    this.f837a.n(fragment);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f840a);
            }
            if (!(this.t || aVar.f840a == 3 || fragment == null)) {
                this.f837a.h(fragment);
            }
        }
        if (!this.t && z) {
            s sVar = this.f837a;
            sVar.a(sVar.r, true);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i2 = 0; i2 < this.f838b.size(); i2++) {
            C0017a aVar = this.f838b.get(i2);
            int i3 = aVar.f840a;
            if (i3 != 1) {
                if (i3 != 3) {
                    switch (i3) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f841b;
                            break;
                    }
                }
                arrayList.add(aVar.f841b);
            }
            arrayList.remove(aVar.f841b);
        }
        return fragment;
    }

    private static boolean b(C0017a aVar) {
        Fragment fragment = aVar.f841b;
        return fragment != null && fragment.m && fragment.K != null && !fragment.D && !fragment.C && fragment.C();
    }

    /* access modifiers changed from: package-private */
    public void a(C0017a aVar) {
        this.f838b.add(aVar);
        aVar.f842c = this.f839c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
    }

    public x a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    public x a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    private void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        fragment.t = this.f837a;
        if (str != null) {
            String str2 = fragment.B;
            if (str2 == null || str.equals(str2)) {
                fragment.B = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.B + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.z;
                if (i4 == 0 || i4 == i2) {
                    fragment.z = i2;
                    fragment.A = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.z + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        a(new C0017a(i3, fragment));
    }

    public x a(Fragment fragment) {
        a(new C0017a(7, fragment));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.i) {
            if (s.f862a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f838b.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0017a aVar = this.f838b.get(i3);
                Fragment fragment = aVar.f841b;
                if (fragment != null) {
                    fragment.s += i2;
                    if (s.f862a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f841b + " to " + aVar.f841b.s);
                    }
                }
            }
        }
    }

    public int a() {
        return a(false);
    }

    /* access modifiers changed from: package-private */
    public int a(boolean z) {
        if (!this.l) {
            if (s.f862a) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new b("FragmentManager"));
                a("  ", (FileDescriptor) null, printWriter, (String[]) null);
                printWriter.close();
            }
            this.l = true;
            if (this.i) {
                this.m = this.f837a.b(this);
            } else {
                this.m = -1;
            }
            this.f837a.a((s.h) this, z);
            return this.m;
        }
        throw new IllegalStateException("commit already called");
    }

    public boolean a(ArrayList<C0087a> arrayList, ArrayList<Boolean> arrayList2) {
        if (s.f862a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.i) {
            return true;
        }
        this.f837a.a(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<C0087a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f838b.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f838b.get(i5).f841b;
            int i6 = fragment != null ? fragment.A : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    C0087a aVar = arrayList.get(i7);
                    int size2 = aVar.f838b.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = aVar.f838b.get(i8).f841b;
                        if ((fragment2 != null ? fragment2.A : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f838b.size()) {
            C0017a aVar = this.f838b.get(i2);
            int i3 = aVar.f840a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = aVar.f841b;
                    int i4 = fragment3.A;
                    Fragment fragment4 = fragment2;
                    int i5 = i2;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList2.get(size);
                        if (fragment5.A == i4) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f838b.add(i5, new C0017a(9, fragment5));
                                    i5++;
                                    fragment4 = null;
                                }
                                C0017a aVar2 = new C0017a(3, fragment5);
                                aVar2.f842c = aVar.f842c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.f838b.add(i5, aVar2);
                                arrayList2.remove(fragment5);
                                i5++;
                            }
                        }
                    }
                    if (z) {
                        this.f838b.remove(i5);
                        i5--;
                    } else {
                        aVar.f840a = 1;
                        arrayList2.add(fragment3);
                    }
                    i2 = i5;
                    fragment2 = fragment4;
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(aVar.f841b);
                    Fragment fragment6 = aVar.f841b;
                    if (fragment6 == fragment2) {
                        this.f838b.add(i2, new C0017a(9, fragment6));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f838b.add(i2, new C0017a(9, fragment2));
                        i2++;
                        fragment2 = aVar.f841b;
                    }
                }
                i2++;
            }
            arrayList2.add(aVar.f841b);
            i2++;
        }
        return fragment2;
    }
}
