package com.adups.fota.activity;

import com.adups.fota.b.a;
import java.io.File;

/* compiled from: SdcardUpdateActivity */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1532a;

    m(p pVar) {
        this.f1532a = pVar;
    }

    public void run() {
        try {
            new File(this.f1532a.f1535a.getFilesDir() + "/adupsfota").mkdirs();
        } catch (Exception unused) {
        }
        SdcardUpdateActivity sdcardUpdateActivity = this.f1532a.f1535a;
        if (sdcardUpdateActivity.a(sdcardUpdateActivity.e, a.e, false)) {
            String unused2 = this.f1532a.f1535a.e = a.e;
            this.f1532a.f1535a.f.sendMessage(this.f1532a.f1535a.f.obtainMessage(15));
            return;
        }
        this.f1532a.f1535a.f.sendMessage(this.f1532a.f1535a.f.obtainMessage(-2));
    }
}
