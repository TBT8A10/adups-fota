package androidx.appcompat.app;

import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: AppCompatDelegateImpl */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f153a;

    p(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f153a = appCompatDelegateImpl;
    }

    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f153a;
        if ((appCompatDelegateImpl.P & 1) != 0) {
            appCompatDelegateImpl.f(0);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.f153a;
        if ((appCompatDelegateImpl2.P & CpioConstants.C_ISFIFO) != 0) {
            appCompatDelegateImpl2.f(108);
        }
        AppCompatDelegateImpl appCompatDelegateImpl3 = this.f153a;
        appCompatDelegateImpl3.O = false;
        appCompatDelegateImpl3.P = 0;
    }
}
