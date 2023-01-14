package com.adups.fota.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;
import com.adups.fota.C0216R$string;
import com.adups.fota.MyApplication;
import com.adups.fota.activity.FileBrowserActivity;
import com.adups.fota.b.d;
import com.adups.fota.utils.v;

/* compiled from: PopWindowsLayout */
class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1680a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f1681b;

    a(e eVar, Activity activity) {
        this.f1681b = eVar;
        this.f1680a = activity;
    }

    public void onClick(View view) {
        this.f1681b.f1687a.dismiss();
        PopupWindow unused = this.f1681b.f1687a = null;
        int c2 = d.c(MyApplication.c());
        if (c2 == 5 || c2 == 2) {
            v.a((int) C0216R$string.tips_abDownOrInstall);
            return;
        }
        Activity activity = this.f1680a;
        activity.startActivity(new Intent(activity.getBaseContext(), FileBrowserActivity.class));
    }
}
