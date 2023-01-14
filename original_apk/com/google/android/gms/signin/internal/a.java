package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import b.a.a.a.c.e;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.C0162c;
import com.google.android.gms.common.internal.C0163d;
import com.google.android.gms.common.internal.C0166g;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public class a extends C0166g<f> implements e {
    private final boolean G;
    private final C0163d H;
    private final Bundle I;
    private Integer J;

    private a(Context context, Looper looper, boolean z, C0163d dVar, Bundle bundle, f fVar, g gVar) {
        super(context, looper, 44, dVar, fVar, gVar);
        this.G = true;
        this.H = dVar;
        this.I = bundle;
        this.J = dVar.d();
    }

    public final void a(d dVar) {
        C0178t.a(dVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.H.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b2.name)) {
                googleSignInAccount = b.a(l()).a();
            }
            ((f) p()).a_shaKey_method2(new zah(new ResolveAccountRequest(b2, this.J.intValue(), googleSignInAccount)), dVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.a(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final void connect() {
        a((C0162c.C0036c) new C0162c.d());
    }

    public boolean d() {
        return this.G;
    }

    public int e() {
        return d.f1794a;
    }

    /* access modifiers changed from: protected */
    public Bundle m() {
        if (!l().getPackageName().equals(this.H.f())) {
            this.I.putString("com.google.android.gms.signin.internal.realClientPackageName", this.H.f());
        }
        return this.I;
    }

    /* access modifiers changed from: protected */
    public String q() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public String r() {
        return "com.google.android.gms.signin.service.START";
    }

    public a(Context context, Looper looper, boolean z, C0163d dVar, b.a.a.a.c.a aVar, f fVar, g gVar) {
        this(context, looper, true, dVar, a(dVar), fVar, gVar);
    }

    public static Bundle a(C0163d dVar) {
        b.a.a.a.c.a h = dVar.h();
        Integer d = dVar.d();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (d != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", d.intValue());
        }
        if (h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h.h());
            if (h.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h.a().longValue());
            }
            if (h.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h.c().longValue());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof f) {
            return (f) queryLocalInterface;
        }
        return new g(iBinder);
    }
}
