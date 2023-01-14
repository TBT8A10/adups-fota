package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.C0153b;
import com.google.android.gms.common.api.internal.D;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.common.internal.C0163d;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class e<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1728a;

    /* renamed from: b  reason: collision with root package name */
    private final a<O> f1729b;

    /* renamed from: c  reason: collision with root package name */
    private final O f1730c;
    private final D<O> d;
    private final int e;

    public a.f a(Looper looper, C0153b.a<O> aVar) {
        return this.f1729b.b().a(this.f1728a, looper, a().a(), this.f1730c, aVar, aVar);
    }

    public final int b() {
        return this.e;
    }

    public final D<O> c() {
        return this.d;
    }

    /* access modifiers changed from: protected */
    public C0163d.a a() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount b2;
        GoogleSignInAccount b3;
        C0163d.a aVar = new C0163d.a();
        O o = this.f1730c;
        if (!(o instanceof a.d.b) || (b3 = ((a.d.b) o).b()) == null) {
            O o2 = this.f1730c;
            account = o2 instanceof a.d.C0032a ? ((a.d.C0032a) o2).a() : null;
        } else {
            account = b3.m();
        }
        aVar.a(account);
        O o3 = this.f1730c;
        if (!(o3 instanceof a.d.b) || (b2 = ((a.d.b) o3).b()) == null) {
            set = Collections.emptySet();
        } else {
            set = b2.u();
        }
        aVar.a((Collection<Scope>) set);
        aVar.a(this.f1728a.getClass().getName());
        aVar.b(this.f1728a.getPackageName());
        return aVar;
    }

    public v a(Context context, Handler handler) {
        return new v(context, handler, a().a());
    }
}
