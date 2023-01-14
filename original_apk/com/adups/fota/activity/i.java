package com.adups.fota.activity;

import android.content.Intent;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.a.a;

/* compiled from: PopupActivity */
class i implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1528a;

    i(PopupActivity popupActivity) {
        this.f1528a = popupActivity;
    }

    public void a() {
        PopupActivity popupActivity = this.f1528a;
        popupActivity.startActivity(new Intent(popupActivity, GoogleOtaClient.class));
        this.f1528a.finish();
    }
}
