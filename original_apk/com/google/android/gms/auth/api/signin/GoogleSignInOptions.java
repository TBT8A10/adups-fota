package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d.e, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public static final Scope f1691a = new Scope("profile");

    /* renamed from: b  reason: collision with root package name */
    public static final Scope f1692b = new Scope("email");

    /* renamed from: c  reason: collision with root package name */
    public static final Scope f1693c = new Scope("openid");
    public static final Scope d = new Scope("https://www.googleapis.com/auth/games_lite");
    public static final Scope e = new Scope("https://www.googleapis.com/auth/games");
    public static final GoogleSignInOptions f;
    public static final GoogleSignInOptions g;
    private static Comparator<Scope> h = new b();
    private final int i;
    private final ArrayList<Scope> j;
    private Account k;
    private boolean l;
    private final boolean m;
    private final boolean n;
    private String o;
    private String p;
    private ArrayList<GoogleSignInOptionsExtensionParcelable> q;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> r;

    static {
        a b2 = new a().b();
        b2.c();
        f = b2.a();
        a aVar = new a();
        aVar.a(d, new Scope[0]);
        g = aVar.a();
    }

    GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i2, arrayList, account, z, z2, z3, str, str2, a(arrayList2));
    }

    private static Map<Integer, GoogleSignInOptionsExtensionParcelable> a(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.m()), next);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r3.k.equals(r4.m()) != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        if (r3.o.equals(r4.p()) != false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0085 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.q     // Catch:{ ClassCastException -> 0x0085 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 > 0) goto L_0x0085
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.q     // Catch:{ ClassCastException -> 0x0085 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0085
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.j     // Catch:{ ClassCastException -> 0x0085 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0085 }
            java.util.ArrayList r2 = r4.o()     // Catch:{ ClassCastException -> 0x0085 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != r2) goto L_0x0085
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.j     // Catch:{ ClassCastException -> 0x0085 }
            java.util.ArrayList r2 = r4.o()     // Catch:{ ClassCastException -> 0x0085 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0085
        L_0x0035:
            android.accounts.Account r1 = r3.k     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.m()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != 0) goto L_0x0085
            goto L_0x004c
        L_0x0040:
            android.accounts.Account r1 = r3.k     // Catch:{ ClassCastException -> 0x0085 }
            android.accounts.Account r2 = r4.m()     // Catch:{ ClassCastException -> 0x0085 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 == 0) goto L_0x0085
        L_0x004c:
            java.lang.String r1 = r3.o     // Catch:{ ClassCastException -> 0x0085 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = r4.p()     // Catch:{ ClassCastException -> 0x0085 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 == 0) goto L_0x0085
            goto L_0x006b
        L_0x005f:
            java.lang.String r1 = r3.o     // Catch:{ ClassCastException -> 0x0085 }
            java.lang.String r2 = r4.p()     // Catch:{ ClassCastException -> 0x0085 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 == 0) goto L_0x0085
        L_0x006b:
            boolean r1 = r3.n     // Catch:{ ClassCastException -> 0x0085 }
            boolean r2 = r4.q()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != r2) goto L_0x0085
            boolean r1 = r3.l     // Catch:{ ClassCastException -> 0x0085 }
            boolean r2 = r4.r()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != r2) goto L_0x0085
            boolean r1 = r3.m     // Catch:{ ClassCastException -> 0x0085 }
            boolean r4 = r4.s()     // Catch:{ ClassCastException -> 0x0085 }
            if (r1 != r4) goto L_0x0085
            r4 = 1
            return r4
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.j;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Scope scope = arrayList2.get(i2);
            i2++;
            arrayList.add(scope.m());
        }
        Collections.sort(arrayList);
        com.google.android.gms.auth.api.signin.internal.a aVar = new com.google.android.gms.auth.api.signin.internal.a();
        aVar.a((Object) arrayList);
        aVar.a((Object) this.k);
        aVar.a((Object) this.o);
        aVar.a(this.n);
        aVar.a(this.l);
        aVar.a(this.m);
        return aVar.a();
    }

    public Account m() {
        return this.k;
    }

    public ArrayList<GoogleSignInOptionsExtensionParcelable> n() {
        return this.q;
    }

    public ArrayList<Scope> o() {
        return new ArrayList<>(this.j);
    }

    public String p() {
        return this.o;
    }

    public boolean q() {
        return this.n;
    }

    public boolean r() {
        return this.l;
    }

    public boolean s() {
        return this.m;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.i);
        b.b(parcel, 2, o(), false);
        b.a(parcel, 3, (Parcelable) m(), i2, false);
        b.a(parcel, 4, r());
        b.a(parcel, 5, s());
        b.a(parcel, 6, q());
        b.a(parcel, 7, p(), false);
        b.a(parcel, 8, this.p, false);
        b.b(parcel, 9, n(), false);
        b.a_shaKey_method2(parcel, a2);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Set<Scope> f1694a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1695b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1696c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> h = new HashMap();

        public final a a(Scope scope, Scope... scopeArr) {
            this.f1694a.add(scope);
            this.f1694a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final a b() {
            this.f1694a.add(GoogleSignInOptions.f1693c);
            return this;
        }

        public final a c() {
            this.f1694a.add(GoogleSignInOptions.f1691a);
            return this;
        }

        public final GoogleSignInOptions a() {
            if (this.f1694a.contains(GoogleSignInOptions.e) && this.f1694a.contains(GoogleSignInOptions.d)) {
                this.f1694a.remove(GoogleSignInOptions.d);
            }
            if (this.d && (this.f == null || !this.f1694a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f1694a), this.f, this.d, this.f1695b, this.f1696c, this.e, this.g, this.h, (b) null);
        }
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.i = i2;
        this.j = arrayList;
        this.k = account;
        this.l = z;
        this.m = z2;
        this.n = z3;
        this.o = str;
        this.p = str2;
        this.q = new ArrayList<>(map.values());
        this.r = map;
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, b bVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map);
    }
}
