package com.adups.fota.activity;

import android.content.Context;
import com.adups.fota.a.a;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.utils.c;
import org.greenrobot.eventbus.e;

/* compiled from: SdcardUpdateActivity */
class q implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SdcardUpdateActivity f1536a;

    q(SdcardUpdateActivity sdcardUpdateActivity) {
        this.f1536a = sdcardUpdateActivity;
    }

    public void a() {
        d.d(this.f1536a);
        e.a().b(new EventMessage(100, 1006, 0, 0, (Object) null));
        if (c.j().E()) {
            d.a_shaKey_method2((Context) this.f1536a, 5);
        }
        this.f1536a.d();
    }
}
