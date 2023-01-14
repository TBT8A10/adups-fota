package androidx.core.e;

import android.os.Handler;
import androidx.core.e.k;
import java.util.concurrent.Callable;

/* compiled from: SelfDestructiveThread */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callable f619a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Handler f620b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ k.a f621c;
    final /* synthetic */ k d;

    i(k kVar, Callable callable, Handler handler, k.a aVar) {
        this.d = kVar;
        this.f619a = callable;
        this.f620b = handler;
        this.f621c = aVar;
    }

    public void run() {
        Object obj;
        try {
            obj = this.f619a.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f620b.post(new h(this, obj));
    }
}
