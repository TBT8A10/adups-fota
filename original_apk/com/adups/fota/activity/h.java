package com.adups.fota.activity;

import android.content.DialogInterface;

/* compiled from: PopupActivity */
class h implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PopupActivity f1527a;

    h(PopupActivity popupActivity) {
        this.f1527a = popupActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1527a.finish();
    }
}
