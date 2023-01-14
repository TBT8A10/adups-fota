package com.adups.fota.activity;

import com.adups.fota.a.a;
import com.adups.fota.manager.b;
import com.adups.fota.manager.f;

/* compiled from: PopupActivity */
class l implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1531a;

    l(PopupActivity popupActivity) {
        this.f1531a = popupActivity;
    }

    public void a() {
        if (f.n()) {
            b.a(this.f1531a);
        }
        this.f1531a.finish();
    }
}
