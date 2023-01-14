package com.adups.fota.utils;

import android.content.Context;
import android.os.Process;
import java.io.File;

/* compiled from: StorageUtil */
class s extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1645a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f1646b;

    s(String str, Context context) {
        this.f1645a = str;
        this.f1646b = context;
    }

    public void run() {
        Process.setThreadPriority(10);
        LogUtil.a("filePath = " + this.f1645a);
        t.a(t.a_shaKey_method2(this.f1646b, false));
        boolean unused = t.b(new File(this.f1645a));
        t.j(this.f1646b);
    }
}
