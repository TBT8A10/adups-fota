package com.adups.fota.activity;

import android.content.Intent;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.a.a;

/* compiled from: PopupActivity */
class g implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1526a;

    g(PopupActivity popupActivity) {
        this.f1526a = popupActivity;
    }

    public void a() {
        PopupActivity popupActivity = this.f1526a;
        popupActivity.startActivity(new Intent(popupActivity, GoogleOtaClient.class));
    }
}
