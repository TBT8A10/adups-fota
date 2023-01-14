package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import b.a.a.a.d.C0148a;
import b.a.a.a.d.h;
import b.a.a.a.d.i;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.r;
import com.google.firebase.d;
import com.google.firebase.e.g;
import java.io.IOException;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class P {

    /* renamed from: a  reason: collision with root package name */
    private final d f2386a;

    /* renamed from: b  reason: collision with root package name */
    private final C0189k f2387b;

    /* renamed from: c  reason: collision with root package name */
    private final C0195q f2388c;
    private final Executor d;
    private final g e;

    P(d dVar, C0189k kVar, Executor executor, g gVar) {
        this(dVar, kVar, executor, new C0195q(dVar.b(), kVar), gVar);
    }

    public final h<String> a(String str, String str2, String str3) {
        return b(a(str, str2, str3, new Bundle()));
    }

    public final h<Void> b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final h<Void> c(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private P(d dVar, C0189k kVar, Executor executor, C0195q qVar, g gVar) {
        this.f2386a = dVar;
        this.f2387b = kVar;
        this.f2388c = qVar;
        this.d = executor;
        this.e = gVar;
    }

    private final h<Bundle> a(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f2386a.e().a());
        bundle.putString("gmsv", Integer.toString(this.f2387b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f2387b.b());
        bundle.putString("app_ver_name", this.f2387b.c());
        String a2 = r.a().a("firebase-iid");
        if ("UNKNOWN".equals(a2)) {
            int i = b.f1789a;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i);
            a2 = sb.toString();
        }
        String valueOf = String.valueOf(a2);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        bundle.putString("Firebase-Client", this.e.a());
        i iVar = new i();
        this.d.execute(new S(this, bundle, iVar));
        return iVar.a();
    }

    private final h<String> b(h<Bundle> hVar) {
        return hVar.a_shaKey_method2(this.d, (C0148a<Bundle, TContinuationResult>) new U(this));
    }

    /* access modifiers changed from: private */
    public static String a(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final <T> h<Void> a(h<T> hVar) {
        return hVar.a(C0180b.a(), (C0148a<T, TContinuationResult>) new Q(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle, i iVar) {
        try {
            iVar.a(this.f2388c.a(bundle));
        } catch (IOException e2) {
            iVar.a((Exception) e2);
        }
    }
}
