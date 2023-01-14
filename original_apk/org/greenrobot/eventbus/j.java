package org.greenrobot.eventbus;

import android.os.Looper;

/* compiled from: MainThreadSupport */
public interface j {

    /* compiled from: MainThreadSupport */
    public static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f2545a;

        public a(Looper looper) {
            this.f2545a = looper;
        }

        public boolean a() {
            return this.f2545a == Looper.myLooper();
        }

        public n a(e eVar) {
            return new h(eVar, this.f2545a, 10);
        }
    }

    n a(e eVar);

    boolean a();
}
