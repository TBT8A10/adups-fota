package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager */
class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f2219a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f2220b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f2221c = new Handler(Looper.getMainLooper(), new f(this));
    private b d;
    private b e;

    /* compiled from: SnackbarManager */
    interface a {
        void a(int i);
    }

    /* compiled from: SnackbarManager */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f2222a;

        /* renamed from: b  reason: collision with root package name */
        int f2223b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2224c;

        /* access modifiers changed from: package-private */
        public boolean a(a aVar) {
            return aVar != null && this.f2222a.get() == aVar;
        }
    }

    private g() {
    }

    static g a() {
        if (f2219a == null) {
            f2219a = new g();
        }
        return f2219a;
    }

    private boolean c(a aVar) {
        b bVar = this.d;
        return bVar != null && bVar.a(aVar);
    }

    public void b(a aVar) {
        synchronized (this.f2220b) {
            if (c(aVar) && this.d.f2224c) {
                this.d.f2224c = false;
                b(this.d);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f2220b) {
            if (c(aVar) && !this.d.f2224c) {
                this.d.f2224c = true;
                this.f2221c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    private void b(b bVar) {
        int i = bVar.f2223b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.f2221c.removeCallbacksAndMessages(bVar);
            Handler handler = this.f2221c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), (long) i);
        }
    }

    private boolean a(b bVar, int i) {
        a aVar = (a) bVar.f2222a.get();
        if (aVar == null) {
            return false;
        }
        this.f2221c.removeCallbacksAndMessages(bVar);
        aVar.a(i);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        synchronized (this.f2220b) {
            if (this.d == bVar || this.e == bVar) {
                a(bVar, 2);
            }
        }
    }
}
