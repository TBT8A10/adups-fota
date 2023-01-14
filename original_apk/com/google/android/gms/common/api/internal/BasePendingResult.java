package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.internal.C0172m;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.internal.base.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends j> extends h<R> {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<Boolean> f1732a = new G();

    /* renamed from: b  reason: collision with root package name */
    private final Object f1733b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final a<R> f1734c = new a<>(Looper.getMainLooper());
    private final WeakReference<Object> d = new WeakReference<>((Object) null);
    private final CountDownLatch e = new CountDownLatch(1);
    private final ArrayList<h.a> f = new ArrayList<>();
    private k<? super R> g;
    private final AtomicReference<A> h = new AtomicReference<>();
    /* access modifiers changed from: private */
    public R i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;
    @KeepName
    private b mResultGuardian;
    private C0172m n;
    private boolean o = false;

    public static class a<R extends j> extends e {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(k<? super R> kVar, R r) {
            sendMessage(obtainMessage(1, new Pair(kVar, r)));
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                k kVar = (k) pair.first;
                j jVar = (j) pair.second;
                try {
                    kVar.a(jVar);
                } catch (RuntimeException e) {
                    BasePendingResult.b(jVar);
                    throw e;
                }
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).b(Status.d);
            }
        }
    }

    private final class b {
        private b() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            BasePendingResult.b(BasePendingResult.this.i);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, G g) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
    }

    private final void c(R r) {
        this.i = r;
        this.n = null;
        this.e.countDown();
        this.j = this.i.l();
        if (this.l) {
            this.g = null;
        } else if (this.g != null) {
            this.f1734c.removeMessages(2);
            this.f1734c.a(this.g, b());
        } else if (this.i instanceof i) {
            this.mResultGuardian = new b(this, (G) null);
        }
        ArrayList<h.a> arrayList = this.f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            h.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.j);
        }
        this.f.clear();
    }

    /* access modifiers changed from: protected */
    public abstract R a(Status status);

    public final boolean a() {
        return this.e.getCount() == 0;
    }

    public final void b(Status status) {
        synchronized (this.f1733b) {
            if (!a()) {
                a(a(status));
                this.m = true;
            }
        }
    }

    public final void a(R r) {
        synchronized (this.f1733b) {
            if (this.m || this.l) {
                b((j) r);
                return;
            }
            a();
            boolean z = true;
            C0178t.b(!a(), "Results have already been set");
            if (this.k) {
                z = false;
            }
            C0178t.b(z, "Result has already been consumed");
            c(r);
        }
    }

    private final R b() {
        R r;
        synchronized (this.f1733b) {
            C0178t.b(!this.k, "Result has already been consumed.");
            C0178t.b(a(), "Result is not ready.");
            r = this.i;
            this.i = null;
            this.g = null;
            this.k = true;
        }
        A andSet = this.h.getAndSet((Object) null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    public static void b(j jVar) {
        if (jVar instanceof i) {
            try {
                ((i) jVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(jVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }
}
