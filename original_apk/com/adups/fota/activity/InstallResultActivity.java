package com.adups.fota.activity;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0216R$string;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.d;
import com.adups.fota.view.TitleView;

public class InstallResultActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void initWidget() {
        setContentView(C0214R$layout.activity_update_result);
        String stringExtra = getIntent().getStringExtra("version");
        LogUtil.a("[onCreate] version name = " + stringExtra);
        new Handler().post(new e(this));
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
        titleView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void widgetClick(View view) {
    }

    /* access modifiers changed from: private */
    public void a() {
        LogUtil.a("[showResultDialog] ============");
        d.b(this, getString(C0216R$string.updateSuccessTitle), getString(C0216R$string.updateSuccess, new Object[]{""}), new f(this), (DialogInterface.OnDismissListener) null);
    }
}
