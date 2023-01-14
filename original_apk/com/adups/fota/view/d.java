package com.adups.fota.view;

import android.app.Activity;
import android.view.View;

/* compiled from: PopWindowsLayout */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1685a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f1686b;

    d(e eVar, Activity activity) {
        this.f1686b = eVar;
        this.f1685a = activity;
    }

    public void onClick(View view) {
        this.f1685a.finish();
    }
}
