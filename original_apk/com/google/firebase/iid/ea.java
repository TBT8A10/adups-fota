package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class ea implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final ba f2412a;

    ea(ba baVar) {
        this.f2412a = baVar;
    }

    public final boolean handleMessage(Message message) {
        return this.f2412a.a(message);
    }
}
