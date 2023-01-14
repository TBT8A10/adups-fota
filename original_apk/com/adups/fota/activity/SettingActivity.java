package com.adups.fota.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0216R$string;
import com.adups.fota.MyApplication;
import com.adups.fota.a.c;
import com.adups.fota.b.a;
import com.adups.fota.manager.b;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.d;
import com.adups.fota.utils.o;
import com.adups.fota.view.CheckScheduleView;
import com.adups.fota.view.TitleContentView;
import com.adups.fota.view.TitleView;
import java.io.Serializable;

public class SettingActivity extends BaseActivity implements c {

    /* renamed from: a  reason: collision with root package name */
    private TitleContentView f1517a;

    /* renamed from: b  reason: collision with root package name */
    private TitleContentView f1518b;

    /* renamed from: c  reason: collision with root package name */
    private TitleContentView f1519c;
    private int d;
    private int e = 0;

    private void a() {
        a(o.a((Context) this, "check_local_freq", com.adups.fota.b.c.a()));
        boolean a2 = o.a((Context) this, "download_only_wifi", com.adups.fota.utils.c.j().x());
        LogUtil.a("isOnlyWifi = " + a2);
        this.f1518b.setChecked(a2);
        boolean a3 = o.a((Context) this, "download_wifi_auto", com.adups.fota.utils.c.j().t());
        LogUtil.a("isWifiAuto = " + a3);
        this.f1519c.setChecked(a3);
    }

    private void b() {
        this.f1517a = (TitleContentView) findViewById(C0211R$id.check_cycle);
        this.f1518b = (TitleContentView) findViewById(C0211R$id.update_wifi_only);
        this.f1519c = (TitleContentView) findViewById(C0211R$id.wifi_auto_download);
        this.f1517a.setOnClickListener(this);
        this.f1518b.setOnClickListener(this);
        this.f1519c.setOnClickListener(this);
        TitleContentView titleContentView = (TitleContentView) findViewById(C0211R$id.about);
        if (MyApplication.e()) {
            titleContentView.setVisibility(0);
            titleContentView.setOnClickListener(this);
        }
        if (com.adups.fota.utils.c.j().w()) {
            this.f1517a.requestFocus();
        }
    }

    private void c() {
        CheckScheduleView checkScheduleView = new CheckScheduleView(this);
        checkScheduleView.setItemChecked(this.e);
        checkScheduleView.setOnItemClickListener(this);
        d.a((Context) this, getString(C0216R$string.setting_autocheck_title), (View) checkScheduleView);
    }

    public void initWidget() {
        setContentView(C0214R$layout.activity_setting);
        b();
        a();
    }

    public void onItemClick(int i) {
        closeDialog();
        b(i);
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
        titleView.setContent(getString(C0216R$string.option_settings));
    }

    public void widgetClick(View view) {
        switch (view.getId()) {
            case C0211R$id.about:
                ComponentName componentName = new ComponentName(a.f1541c, a.d);
                Intent intent = new Intent();
                intent.setComponent(componentName);
                intent.putExtra("param", (Serializable) com.adups.fota.g.d.a(this));
                startActivity(intent);
                return;
            case C0211R$id.check_cycle:
                c();
                return;
            case C0211R$id.update_wifi_only:
                o.b((Context) this, "download_only_wifi", this.f1518b.a());
                return;
            case C0211R$id.wifi_auto_download:
                o.b((Context) this, "download_wifi_auto", this.f1519c.a());
                return;
            default:
                return;
        }
    }

    private void a(int i) {
        this.d = i;
        if (i == 1440) {
            this.e = 0;
            this.f1517a.setTip((int) C0216R$string.setting_autocheck_schedule1);
        } else if (i == 4320) {
            this.e = 1;
            this.f1517a.setTip((int) C0216R$string.setting_autocheck_schedule2);
        } else if (i == 10080) {
            this.e = 2;
            this.f1517a.setTip((int) C0216R$string.setting_autocheck_schedule3);
        }
    }

    private void b(int i) {
        this.e = i;
        int i2 = C0216R$string.setting_autocheck_schedule1;
        if (i == 0) {
            this.d = 1440;
        } else if (i == 1) {
            i2 = C0216R$string.setting_autocheck_schedule2;
            this.d = 4320;
        } else if (i == 2) {
            i2 = C0216R$string.setting_autocheck_schedule3;
            this.d = 10080;
        }
        this.f1517a.setTip(i2);
        o.b((Context) this, "check_local_freq", this.d);
        b.d(this);
    }
}
