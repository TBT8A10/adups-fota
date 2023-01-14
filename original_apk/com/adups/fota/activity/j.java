package com.adups.fota.activity;

import com.adups.fota.a.a;
import com.adups.fota.manager.b;
import com.adups.fota.manager.f;

/* compiled from: PopupActivity */
class j implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1529a;

    j(PopupActivity popupActivity) {
        this.f1529a = popupActivity;
    }

    public void a() {
        if (f.n()) {
            b.a(this.f1529a);
        }
        this.f1529a.finish();
    }
}
