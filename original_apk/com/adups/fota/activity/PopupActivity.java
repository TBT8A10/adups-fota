package com.adups.fota.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0216R$string;
import com.adups.fota.a.a;
import com.adups.fota.e.c;
import com.adups.fota.manager.f;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.d;
import com.adups.fota.view.InstallCheckView;
import com.adups.fota.view.TitleView;

public class PopupActivity extends BaseActivity {
    private void a(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        LogUtil.a("status : " + intExtra);
        if (intExtra == 1) {
            d.a((Context) this, getString(C0216R$string.sdCard_upgrade_hint), c.a().a_shaKey_method2((Context) this, false), getString(C0216R$string.btn_download), (a) new g(this), (String) null, (a) null, (DialogInterface.OnDismissListener) new h(this));
        } else if (intExtra != 4) {
            finish();
        } else if (f.n()) {
            d.a((Context) this, getString(C0216R$string.new_to_upgrade), (String) null, getString(C0216R$string.update_now), (a) new i(this), getString(C0216R$string.update_later), (a) new j(this));
        } else {
            f.c(true);
            d.a((Context) this, getString(C0216R$string.new_to_upgrade), getString(C0216R$string.update_now), (a) new k(this), getString(C0216R$string.update_later), (a) new l(this), (DialogInterface.OnDismissListener) null, (View) new InstallCheckView(this));
        }
    }

    /* access modifiers changed from: protected */
    public void initWidget() {
        setContentView(C0214R$layout.activity_fota_pop_window);
        a(getIntent());
        f.a();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        closeDialog();
        a(intent);
        f.a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.adups.fota.manager.a.b().a();
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
        titleView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void widgetClick(View view) {
    }
}
