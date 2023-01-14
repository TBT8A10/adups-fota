package com.adups.fota.activity;

import android.content.Intent;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.a.a;

/* compiled from: PopupActivity */
class k implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1530a;

    k(PopupActivity popupActivity) {
        this.f1530a = popupActivity;
    }

    public void a() {
        PopupActivity popupActivity = this.f1530a;
        popupActivity.startActivity(new Intent(popupActivity, GoogleOtaClient.class));
        this.f1530a.finish();
    }
}
