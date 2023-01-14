package androidx.fragment.app;

import android.os.Handler;
import android.os.Message;

/* renamed from: androidx.fragment.app.h  reason: case insensitive filesystem */
/* compiled from: FragmentActivity */
class C0094h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FragmentActivity f846a;

    C0094h(FragmentActivity fragmentActivity) {
        this.f846a = fragmentActivity;
    }

    public void handleMessage(Message message) {
        if (message.what != 2) {
            super.handleMessage(message);
            return;
        }
        this.f846a.onResumeFragments();
        this.f846a.mFragments.i();
    }
}
