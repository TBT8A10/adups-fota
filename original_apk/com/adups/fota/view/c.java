package com.adups.fota.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;
import com.adups.fota.activity.SettingActivity;

/* compiled from: PopWindowsLayout */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1683a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f1684b;

    c(e eVar, Activity activity) {
        this.f1684b = eVar;
        this.f1683a = activity;
    }

    public void onClick(View view) {
        this.f1684b.f1687a.dismiss();
        PopupWindow unused = this.f1684b.f1687a = null;
        Activity activity = this.f1683a;
        activity.startActivity(new Intent(activity.getBaseContext(), SettingActivity.class));
    }
}
