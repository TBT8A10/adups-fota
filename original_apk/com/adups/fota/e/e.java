package com.adups.fota.e;

import android.content.Context;
import android.os.Process;
import com.adups.fota.manager.b;
import com.adups.fota.utils.LogUtil;

/* compiled from: QueryVersion */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1563a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f1564b;

    e(g gVar, Context context) {
        this.f1564b = gVar;
        this.f1563a = context;
    }

    public void run() {
        Process.setThreadPriority(10);
        LogUtil.a("thread start");
        this.f1564b.e(this.f1563a);
        b.d(this.f1563a);
        LogUtil.a("thread end");
    }
}
