package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import b.a.a.a.c.b;
import b.a.a.a.c.e;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.internal.C0163d;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.c;
import com.google.android.gms.signin.internal.zaj;
import java.util.Set;

public final class v extends c implements f, g {

    /* renamed from: a  reason: collision with root package name */
    private static a.C0031a<? extends e, b.a.a.a.c.a> f1776a = b.f1414c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1777b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f1778c;
    private final a.C0031a<? extends e, b.a.a.a.c.a> d;
    private Set<Scope> e;
    private C0163d f;
    private e g;
    /* access modifiers changed from: private */
    public y h;

    public v(Context context, Handler handler, C0163d dVar) {
        this(context, handler, dVar, f1776a);
    }

    /* access modifiers changed from: private */
    public final void b(zaj zaj) {
        ConnectionResult m = zaj.m();
        if (m.q()) {
            ResolveAccountResponse n = zaj.n();
            ConnectionResult n2 = n.n();
            if (!n2.q()) {
                String valueOf = String.valueOf(n2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.h.b(n2);
                this.g.disconnect();
                return;
            }
            this.h.a(n.m(), this.e);
        } else {
            this.h.b(m);
        }
        this.g.disconnect();
    }

    public final void a(y yVar) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f.a(Integer.valueOf(System.identityHashCode(this)));
        a.C0031a<? extends e, b.a.a.a.c.a> aVar = this.d;
        Context context = this.f1777b;
        Looper looper = this.f1778c.getLooper();
        C0163d dVar = this.f;
        this.g = (e) aVar.a(context, looper, dVar, dVar.h(), this, this);
        this.h = yVar;
        Set<Scope> set = this.e;
        if (set == null || set.isEmpty()) {
            this.f1778c.post(new w(this));
        } else {
            this.g.connect();
        }
    }

    public final void d() {
        e eVar = this.g;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    public v(Context context, Handler handler, C0163d dVar, a.C0031a<? extends e, b.a.a.a.c.a> aVar) {
        this.f1777b = context;
        this.f1778c = handler;
        C0178t.a(dVar, (Object) "ClientSettings must not be null");
        this.f = dVar;
        this.e = dVar.g();
        this.d = aVar;
    }

    public final void a(Bundle bundle) {
        this.g.a(this);
    }

    public final void a(int i) {
        this.g.disconnect();
    }

    public final void a(ConnectionResult connectionResult) {
        this.h.b(connectionResult);
    }

    public final void a(zaj zaj) {
        this.f1778c.post(new x(this, zaj));
    }
}
