package com.google.android.gms.common.internal;

import a.b.d;
import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.d  reason: case insensitive filesystem */
public final class C0163d {

    /* renamed from: a  reason: collision with root package name */
    private final Account f1874a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f1875b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f1876c;
    private final Map<com.google.android.gms.common.api.a<?>, b> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final b.a.a.a.c.a i;
    private final boolean j;
    private Integer k;

    /* renamed from: com.google.android.gms.common.internal.d$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f1877a;

        /* renamed from: b  reason: collision with root package name */
        private d<Scope> f1878b;

        /* renamed from: c  reason: collision with root package name */
        private Map<com.google.android.gms.common.api.a<?>, b> f1879c;
        private int d = 0;
        private View e;
        private String f;
        private String g;
        private b.a.a.a.c.a h = b.a.a.a.c.a.f1409a;
        private boolean i;

        public final a a(Account account) {
            this.f1877a = account;
            return this;
        }

        public final a b(String str) {
            this.f = str;
            return this;
        }

        public final a a(Collection<Scope> collection) {
            if (this.f1878b == null) {
                this.f1878b = new d<>();
            }
            this.f1878b.addAll(collection);
            return this;
        }

        public final a a(String str) {
            this.g = str;
            return this;
        }

        public final C0163d a() {
            return new C0163d(this.f1877a, this.f1878b, this.f1879c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.d$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f1880a;
    }

    public C0163d(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i2, View view, String str, String str2, b.a.a.a.c.a aVar, boolean z) {
        this.f1874a = account;
        this.f1875b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.d = map == null ? Collections.EMPTY_MAP : map;
        this.f = view;
        this.e = i2;
        this.g = str;
        this.h = str2;
        this.i = aVar;
        this.j = z;
        HashSet hashSet = new HashSet(this.f1875b);
        for (b bVar : this.d.values()) {
            hashSet.addAll(bVar.f1880a);
        }
        this.f1876c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.f1874a;
    }

    public final Account b() {
        Account account = this.f1874a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> c() {
        return this.f1876c;
    }

    public final Integer d() {
        return this.k;
    }

    public final String e() {
        return this.h;
    }

    public final String f() {
        return this.g;
    }

    public final Set<Scope> g() {
        return this.f1875b;
    }

    public final b.a.a.a.c.a h() {
        return this.i;
    }

    public final void a(Integer num) {
        this.k = num;
    }
}
