package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.C0162c;
import com.google.android.gms.common.internal.C0163d;
import com.google.android.gms.common.internal.C0171l;
import com.google.android.gms.common.internal.C0178t;
import java.util.Set;

public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final C0031a<?, O> f1725a;

    /* renamed from: b  reason: collision with root package name */
    private final i<?, O> f1726b = null;

    /* renamed from: c  reason: collision with root package name */
    private final g<?> f1727c;
    private final j<?> d;
    private final String e;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    public static abstract class C0031a<T extends f, O> extends e<T, O> {
        public abstract T a(Context context, Looper looper, C0163d dVar, O o, f fVar, g gVar);
    }

    public interface b {
    }

    public static class c<C extends b> {
    }

    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        public interface C0032a extends c, C0033d {
            Account a();
        }

        public interface b extends c {
            GoogleSignInAccount b();
        }

        public interface c extends d {
        }

        /* renamed from: com.google.android.gms.common.api.a$d$d  reason: collision with other inner class name */
        public interface C0033d extends d {
        }

        public interface e extends c, C0033d {
        }
    }

    public static abstract class e<T extends b, O> {
    }

    public interface f extends b {
        void a(C0162c.C0036c cVar);

        void a(C0162c.e eVar);

        void a(C0171l lVar, Set<Scope> set);

        boolean a();

        String b();

        boolean c();

        boolean d();

        void disconnect();

        int e();

        Feature[] f();

        boolean isConnected();
    }

    public static final class g<C extends f> extends c<C> {
    }

    public interface h<T extends IInterface> extends b {
        T a(IBinder iBinder);

        void a(int i, T t);

        String g();

        String h();
    }

    public static abstract class i<T extends h, O> extends e<T, O> {
    }

    public static final class j<C extends h> extends c<C> {
    }

    public <C extends f> a(String str, C0031a<C, O> aVar, g<C> gVar) {
        C0178t.a(aVar, (Object) "Cannot construct an Api with a null ClientBuilder");
        C0178t.a(gVar, (Object) "Cannot construct an Api with a null ClientKey");
        this.e = str;
        this.f1725a = aVar;
        this.f1727c = gVar;
        this.d = null;
    }

    public final String a() {
        return this.e;
    }

    public final C0031a<?, O> b() {
        C0178t.b(this.f1725a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f1725a;
    }
}
