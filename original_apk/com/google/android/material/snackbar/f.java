package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.g;

/* compiled from: SnackbarManager */
class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2218a;

    f(g gVar) {
        this.f2218a = gVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f2218a.a((g.b) message.obj);
        return true;
    }
}
