package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster */
public class h extends Handler implements n {

    /* renamed from: a  reason: collision with root package name */
    private final m f2540a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final int f2541b;

    /* renamed from: c  reason: collision with root package name */
    private final e f2542c;
    private boolean d;

    protected h(e eVar, Looper looper, int i) {
        super(looper);
        this.f2542c = eVar;
        this.f2541b = i;
    }

    public void a(s sVar, Object obj) {
        l a2 = l.a(sVar, obj);
        synchronized (this) {
            this.f2540a.a(a2);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new g("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                l a2 = this.f2540a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f2540a.a();
                        if (a2 == null) {
                            this.d = false;
                            this.d = false;
                            return;
                        }
                    }
                }
                this.f2542c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f2541b));
            if (sendMessage(obtainMessage())) {
                this.d = true;
                return;
            }
            throw new g("Could not send handler message");
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }
}
