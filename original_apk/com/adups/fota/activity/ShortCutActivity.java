package com.adups.fota.activity;

import android.view.View;
import com.adups.fota.C0214R$layout;
import com.adups.fota.manager.d;
import com.adups.fota.view.TitleView;

public class ShortCutActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void initWidget() {
        setContentView(C0214R$layout.activity_short_cut);
        d.a(this);
        finish();
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
        titleView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void widgetClick(View view) {
    }
}
