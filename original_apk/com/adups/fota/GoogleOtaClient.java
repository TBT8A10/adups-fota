package com.adups.fota;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Process;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.adups.fota.a.a;
import com.adups.fota.a.b;
import com.adups.fota.a.c;
import com.adups.fota.a.d;
import com.adups.fota.a.f;
import com.adups.fota.activity.BaseActivity;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.e.g;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.j;
import com.adups.fota.utils.k;
import com.adups.fota.utils.n;
import com.adups.fota.utils.o;
import com.adups.fota.utils.q;
import com.adups.fota.utils.t;
import com.adups.fota.utils.v;
import com.adups.fota.view.DeviceFunctionView;
import com.adups.fota.view.FooterLayout;
import com.adups.fota.view.InstallDelayView;
import com.adups.fota.view.NetworkWarnView;
import com.adups.fota.view.ProgressLayout;
import com.adups.fota.view.ProgressTextLayout;
import com.adups.fota.view.ShakeView;
import com.adups.fota.view.TitleView;
import com.google.android.material.appbar.AppBarLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.e;

public class GoogleOtaClient extends BaseActivity implements f, d, c, b {
    private static final String ERROR_REASON_PAUSE = "PAUSE";
    private static final String ERROR_REASON_RESPONSE_UNDONE = "UNDONE";
    private static final int MSG_ADDITIONAL = 22;
    private static final int MSG_AUTO_CHECK = 33;
    private static final int MSG_DELAY_TIME = 11;
    private static final int MSG_FULL_CHECK = 34;
    private static final int REQUEST_CODE = 200;
    private static final long[] schedule_array = {3600000, 14400000, 28800000};
    private LinearLayout ab_view;
    private AppBarLayout appBarLayout;
    private TextView battery_tip;
    /* access modifiers changed from: private */
    public int delayTimeCounts = 15;
    /* access modifiers changed from: private */
    public k dialog;
    private boolean isActiveSafe = false;
    private long lastClickTime = 0;
    private int mClickCount;
    /* access modifiers changed from: private */
    public FooterLayout mFooterLayout;
    /* access modifiers changed from: private */
    public Handler mHandler = new a(this);
    private ProgressLayout mProgress;
    private TextView mReleaseView;
    private TextView mUpdateTip;
    private LinearLayout pre_view;
    private TextView pro_txt;
    private LinearLayout pro_view;
    private ProgressTextLayout progressTextLayout;
    private ProgressBar progress_update_id;
    private ImageView setting;
    private ShakeView shakeView;
    private TextView update_txt;
    private int userPause = 0;

    static /* synthetic */ int access$010(GoogleOtaClient googleOtaClient) {
        int i = googleOtaClient.delayTimeCounts;
        googleOtaClient.delayTimeCounts = i - 1;
        return i;
    }

    private void closeDebug() {
        LogUtil.b(false);
        o.b((Context) this, "debug_status", false);
        v.a((int) C0216R$string.stop_catch_log);
    }

    private void deviceRooted() {
        LogUtil.a("enter");
        com.adups.fota.b.d.d(this);
        initIdleView();
        com.adups.fota.utils.d.a((Context) this, (int) C0215R$mipmap.ota_root, getString(C0216R$string.ota_device_rooted_content), 17, getString(C0216R$string.ota_full_rom_check), (a) new g(this), (DialogInterface.OnDismissListener) this);
    }

    /* access modifiers changed from: private */
    public void doConfirmCancel() {
        LogUtil.a("enter");
        this.mProgress.setProgress(0);
        com.adups.fota.c.d.b().d(this);
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 0);
        this.userPause = 1;
        initIdleView();
    }

    private void downloadCallback(EventMessage eventMessage) {
        int arg1 = eventMessage.getArg1();
        if (arg1 == 1000) {
            closeDialog();
            initDownloadStartView();
        } else if (arg1 != 1001) {
            if (arg1 == 2000) {
                notifyDownloading(Long.valueOf(eventMessage.getArg2()).intValue());
            } else if (arg1 == 2001) {
                com.adups.fota.b.d.a_shaKey_method2((Context) this, 3);
                if (!com.adups.fota.utils.c.j().u()) {
                    this.shakeView.setVisibility(0);
                    this.shakeView.setContent(C0216R$string.shake_to_download);
                }
                this.mFooterLayout.a(3);
            } else if (arg1 == 3000) {
                int c2 = com.adups.fota.b.d.c(this);
                if (c2 == 2 || c2 == 3) {
                    downloadFail(eventMessage.getObject().toString());
                    return;
                }
                com.adups.fota.b.d.d(this);
                initIdleView();
            } else if (arg1 == 5001) {
                initPauseView(false);
                downloadWifiToMobile();
            }
        } else if (isFront()) {
            initInstallView();
        }
    }

    private void downloadFail(String str) {
        LogUtil.a("enter");
        if (this.userPause == 1) {
            com.adups.fota.b.d.d(this);
            LogUtil.a("user cancel cause download fail");
            this.userPause = 0;
            return;
        }
        initPauseView(false);
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase(getString(C0216R$string.package_unzip_error))) {
                initIdleView();
                showToastOrDialog(str);
                com.adups.fota.b.d.d(this);
            } else if (!str.equalsIgnoreCase(ERROR_REASON_RESPONSE_UNDONE) && !str.equalsIgnoreCase(ERROR_REASON_PAUSE)) {
                showToastOrDialog(str);
            }
        } else if (!k.a(this)) {
            showToastOrDialog(getString(C0216R$string.ota_toast_no_network));
        } else {
            VersionBean c2 = com.adups.fota.e.c.a().c();
            if (c2 != null) {
                int b2 = t.b((Context) this, c2.getFileSize());
                if (b2 == 1) {
                    showToastOrDialog(getString(C0216R$string.unmount_sdcard));
                } else if (b2 == 2) {
                    showToastOrDialog(getString(C0216R$string.sdcard_crash_or_unmount));
                }
            }
        }
    }

    private void downloadWifiToMobile() {
        LogUtil.a("enter");
        boolean a2 = o.a((Context) this, "download_only_wifi", com.adups.fota.utils.c.j().x());
        boolean b2 = k.b(this);
        if (a2 && b2) {
            LogUtil.a(" ota network  wifi  to mobile  dialog");
            com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.setting_network_tip), (DialogInterface.OnDismissListener) this);
        } else if (k.b(this)) {
            showDownloadNoticeDialog();
        }
    }

    private void exportData() {
        String str = getFilesDir().getParent() + "/shared_prefs/adupsfota.xml";
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            v.a((int) C0216R$string.sdcard_crash_or_unmount);
            return;
        }
        File file = new File(t.b((Context) this) + "/fota");
        if (!file.exists()) {
            file.mkdirs();
        }
        new Thread(new f(this, str, file.getAbsolutePath() + "/adupsfota.txt", getFilesDir().getAbsolutePath() + "/" + com.adups.fota.b.a.f1540b, file.getAbsolutePath() + "/" + com.adups.fota.b.a.f1540b)).start();
        v.a(getString(C0216R$string.export_data) + " to " + file.getAbsolutePath());
    }

    private void initDownloadStartView() {
        LogUtil.a("enter");
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 2);
        this.mUpdateTip.setVisibility(0);
        this.shakeView.setVisibility(8);
        loadReleaseNotes();
        this.mFooterLayout.a(2);
        setDownloadProgress(getPercent());
        LogUtil.a("exit");
    }

    private void initDownloadView() {
        LogUtil.a("enter");
        if (!com.adups.fota.c.d.b().c(this)) {
            com.adups.fota.b.d.a_shaKey_method2((Context) this, 3);
            initPauseView(true);
        } else {
            this.shakeView.setVisibility(8);
            com.adups.fota.b.d.a_shaKey_method2((Context) this, 2);
            this.mUpdateTip.setVisibility(0);
            loadReleaseNotes();
            int percent = getPercent();
            this.mFooterLayout.a(2);
            setDownloadProgress(percent);
        }
        LogUtil.a("exit");
    }

    private void initIdleView() {
        LogUtil.a("enter");
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 0);
        showAbView(false, false);
        this.mUpdateTip.setVisibility(8);
        this.progressTextLayout.setVisibility(8);
        if (!com.adups.fota.utils.c.j().u()) {
            this.shakeView.setContent(C0216R$string.shake_to_check);
        }
        String f = com.adups.fota.utils.c.j().f();
        if (TextUtils.isEmpty(f)) {
            f = com.adups.fota.utils.c.j().k();
        }
        this.mReleaseView.setText(Html.fromHtml(getResources().getString(C0216R$string.htmlstring_version) + getString(C0216R$string.current_version_text) + getResources().getString(C0216R$string.htmlstring_version_end) + getResources().getString(C0216R$string.htmlstring_code_head) + f + getResources().getString(C0216R$string.htmlstring_code_end)));
        this.mFooterLayout.a(0);
        this.mProgress.a();
        LogUtil.a("exit");
    }

    private void initInstallView() {
        LogUtil.a("enter");
        if (com.adups.fota.e.c.a().c() == null) {
            initIdleView();
            return;
        }
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 4);
        this.mUpdateTip.setVisibility(0);
        if (!com.adups.fota.utils.c.j().u()) {
            this.shakeView.setContent(C0216R$string.shake_to_update);
        }
        loadReleaseNotes();
        this.mFooterLayout.a(4);
        if (com.adups.fota.d.d.a()) {
            showAbView(true, false);
            if (com.adups.fota.d.d.a_shaKey_method2((Context) this, com.adups.fota.utils.c.j().a())) {
                com.adups.fota.f.a.a_shaKey_method2(this, "update");
                com.adups.fota.d.d.e(this);
            } else {
                LogUtil.a("no update reason : battery not enough");
                CustomActionService.a_shaKey_method2(this, 15);
                e.a().b(new EventMessage(300, 100, 0, 617, "ab"));
            }
        } else {
            LogUtil.a("no update reason : not support ab update");
        }
        if (com.adups.fota.utils.c.j().w()) {
            this.progressTextLayout.setProgress(100);
        }
        this.mProgress.setDownLoadProgress(100);
        LogUtil.a("exit");
    }

    private void initInstallingView() {
        int a2 = o.a((Context) this, "ota_ab_progress", 0);
        showAbView(true, true);
        this.update_txt.setText(C0216R$string.ab_installing);
        this.pro_txt.setText(String.format("%s%%", new Object[]{String.valueOf(a2)}));
        this.progress_update_id.setProgress(a2);
        new Thread(new b(this)).start();
    }

    private void initNewVersionView() {
        LogUtil.a("enter");
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 1);
        this.mUpdateTip.setVisibility(0);
        this.progressTextLayout.setVisibility(8);
        if (!com.adups.fota.utils.c.j().u()) {
            this.shakeView.setContent(C0216R$string.shake_to_download);
        }
        loadReleaseNotes();
        this.mFooterLayout.a(1);
        this.mProgress.a();
        this.mProgress.setVersionTip(getString(C0216R$string.new_version_text));
        LogUtil.a("exit");
    }

    private void initPauseView(boolean z) {
        LogUtil.a("enter");
        com.adups.fota.b.d.a_shaKey_method2((Context) this, 3);
        this.mUpdateTip.setVisibility(0);
        if (!com.adups.fota.utils.c.j().u()) {
            this.shakeView.setVisibility(0);
            this.shakeView.setContent(C0216R$string.shake_to_download);
        }
        if (z) {
            loadReleaseNotes();
        }
        int percent = getPercent();
        this.mFooterLayout.a(3);
        setDownloadProgress(percent);
        LogUtil.a("exit");
    }

    private void initRebootView() {
        showAbView(true, false);
        this.battery_tip.setText(C0216R$string.updated_need_reboot);
        this.mFooterLayout.a(6);
    }

    private void initStatus() {
        int c2 = com.adups.fota.b.d.c(this);
        LogUtil.a("version_status = " + c2);
        showAbView(false, false);
        closeDialog();
        switch (c2) {
            case 0:
                initIdleView();
                return;
            case 1:
                if (com.adups.fota.e.c.a().c() != null) {
                    this.userPause = 0;
                    initNewVersionView();
                    return;
                }
                initIdleView();
                return;
            case 2:
                initDownloadView();
                return;
            case 3:
                if (com.adups.fota.e.c.a().c() == null) {
                    initIdleView();
                    return;
                } else {
                    initPauseView(true);
                    return;
                }
            case 4:
                initInstallView();
                return;
            case 5:
                initInstallingView();
                return;
            case 6:
                initRebootView();
                return;
            default:
                initIdleView();
                return;
        }
    }

    private void initView() {
        LogUtil.a("enter");
        this.mFooterLayout = (FooterLayout) findViewById(C0211R$id.footer_layout);
        this.mFooterLayout.setOnClickListener(this);
        this.mProgress = (ProgressLayout) findViewById(C0211R$id.progress_layout);
        this.mUpdateTip = (TextView) findViewById(C0211R$id.ota_update_tip);
        this.mReleaseView = (TextView) findViewById(C0211R$id.relese_view);
        this.pre_view = (LinearLayout) findViewById(C0211R$id.pre_view);
        this.ab_view = (LinearLayout) findViewById(C0211R$id.ab_view);
        this.pro_view = (LinearLayout) findViewById(C0211R$id.pro_view);
        this.battery_tip = (TextView) findViewById(C0211R$id.battery_tip);
        this.update_txt = (TextView) findViewById(C0211R$id.update_txt);
        this.pro_txt = (TextView) findViewById(C0211R$id.pro_txt);
        this.progress_update_id = (ProgressBar) findViewById(C0211R$id.progress_update_id);
        this.appBarLayout = (AppBarLayout) findViewById(C0211R$id.appBarLayout);
        this.progressTextLayout = (ProgressTextLayout) findViewById(C0211R$id.progressLayout);
        this.shakeView = (ShakeView) findViewById(C0211R$id.shakeView);
        LogUtil.a("[initView] finish");
    }

    private void installCallback(EventMessage eventMessage) {
        closeDialog();
        int a2 = com.adups.fota.utils.c.j().a();
        if (eventMessage.getObject() == null || TextUtils.isEmpty(eventMessage.getObject().toString()) || !eventMessage.getObject().toString().equals("ab")) {
            switch (eventMessage.getArg1()) {
                case 401:
                case 403:
                case 408:
                case 410:
                    com.adups.fota.b.d.d(this);
                    initIdleView();
                    com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.package_unzip_error), (DialogInterface.OnDismissListener) this);
                    return;
                case 402:
                case 409:
                case 411:
                    com.adups.fota.b.d.d(this);
                    initIdleView();
                    com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.package_error_title), getString(C0216R$string.package_error_message_invalid), (DialogInterface.OnDismissListener) this);
                    return;
                case 404:
                    deviceRooted();
                    return;
                case 405:
                    LogUtil.a("UPDATE_STATUS_OK");
                    if (!com.adups.fota.d.d.a()) {
                        com.adups.fota.utils.d.a((Context) this, (int) C0214R$layout.dialog_update_reboot, (DialogInterface.OnDismissListener) this);
                        return;
                    }
                    return;
                default:
                    com.adups.fota.b.d.d(this);
                    initIdleView();
                    com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.not_support_version), (DialogInterface.OnDismissListener) this);
                    return;
            }
        } else {
            LogUtil.a("ab installCallback enter");
            if (eventMessage.getArg3() == 601) {
                if (eventMessage.getArg1() == 0) {
                    com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.ab_install_success), getString(C0216R$string.updated_need_reboot), (a) new h(this), (DialogInterface.OnDismissListener) this);
                    showAbView(true, false);
                    this.battery_tip.setText(C0216R$string.updated_need_reboot);
                    this.mFooterLayout.a(6);
                    return;
                }
                LogUtil.a("installCallback,install fail");
                com.adups.fota.b.d.d(this);
                initIdleView();
                String string = getString(C0216R$string.ab_install_fail);
                com.adups.fota.utils.d.a((Context) this, string, getString(C0216R$string.ab_isnatll_fail_reason) + eventMessage.getArg1(), (DialogInterface.OnDismissListener) this);
            } else if (eventMessage.getArg3() == 600) {
                LogUtil.a("installCallback,installing");
                this.mFooterLayout.a(5);
                showAbView(true, true);
                this.update_txt.setText(C0216R$string.ab_installing);
                TextView textView = this.pro_txt;
                textView.setText(eventMessage.getArg2() + "%");
                this.progress_update_id.setProgress((int) eventMessage.getArg2());
            } else if (eventMessage.getArg3() == 617) {
                showAbView(true, false);
                this.mFooterLayout.a(4);
                this.battery_tip.setText(getString(C0216R$string.ab_battery_low, new Object[]{Integer.valueOf(a2)}));
            } else if (eventMessage.getArg3() == 618) {
                com.adups.fota.b.d.d(this);
                initIdleView();
                com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.ab_install_fail), getString(C0216R$string.ab_parms_illegal), (DialogInterface.OnDismissListener) this);
            } else if (eventMessage.getArg3() == 619) {
                com.adups.fota.b.d.d(this);
                initIdleView();
                com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.ab_install_fail), getString(C0216R$string.ab_connect_fail), (DialogInterface.OnDismissListener) this);
            } else if (eventMessage.getArg3() == 602) {
                com.adups.fota.utils.d.a((Context) this, (int) C0214R$layout.dialog_update_unzip, (DialogInterface.OnDismissListener) this);
            } else if (eventMessage.getArg3() == 620) {
                com.adups.fota.b.d.d(this);
                initIdleView();
                com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.ab_install_fail), getString(C0216R$string.sdCard_upgrade_find_update_file_fail), (DialogInterface.OnDismissListener) this);
            } else if (eventMessage.getArg3() == 621) {
                showAbView(true, false);
                this.mFooterLayout.a(4);
                this.battery_tip.setText(String.format("ab-%s", new Object[]{getString(C0216R$string.not_support_version)}));
                String string2 = getString(C0216R$string.not_support_fota_title);
                com.adups.fota.utils.d.a((Context) this, string2, "ab-" + getString(C0216R$string.not_support_version), (DialogInterface.OnDismissListener) this);
            }
        }
    }

    private boolean isClick2Fast() {
        long currentTimeMillis = System.currentTimeMillis() - this.lastClickTime;
        this.lastClickTime = System.currentTimeMillis();
        return 0 < currentTimeMillis && currentTimeMillis < 1000;
    }

    /* access modifiers changed from: private */
    public boolean isOverRemindDate() {
        String a2 = o.a((Context) this, "ota_check_once_day", "");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        if (a2.equals(format)) {
            return false;
        }
        o.b((Context) this, "ota_check_once_day", format);
        return true;
    }

    private void loadReleaseNotes() {
        LogUtil.a("enter");
        VersionBean c2 = com.adups.fota.e.c.a().c();
        if (c2 != null) {
            this.mReleaseView.setText(Html.fromHtml(com.adups.fota.e.c.a().a_shaKey_method2((Context) this, true)));
            LogUtil.a("loadReleaseNotes:" + com.adups.fota.e.c.a().b());
            if (com.adups.fota.e.c.a().b().equals("zh_CN")) {
                this.mReleaseView.setTypeface(Typeface.createFromAsset(MyApplication.c().getAssets(), "fonts/wen_quan.ttf"));
            } else {
                this.mReleaseView.setTypeface((Typeface) null);
            }
            if (c2.getIsSilent() == 0) {
                this.mHandler.sendEmptyMessageDelayed(22, 1000);
            }
        }
        LogUtil.a("exit");
    }

    private void noFindVersion() {
        LogUtil.a("enter");
        int c2 = com.adups.fota.b.d.c(this);
        if (c2 == 0) {
            this.mProgress.setVersionTip(getString(C0216R$string.no_new_version));
        }
        if (c2 == 0 && isFront()) {
            v.a((int) C0216R$string.no_new_version);
        }
    }

    private void notifyDownloading(int i) {
        if (com.adups.fota.b.d.c(this) != 2) {
            com.adups.fota.b.d.a_shaKey_method2((Context) this, 2);
            this.mUpdateTip.setVisibility(0);
            loadReleaseNotes();
            this.mFooterLayout.a(2);
        }
        setDownloadProgress(i);
    }

    private void onClickCancel() {
        LogUtil.a("enter");
        if (com.adups.fota.b.d.c(this) == 2) {
            com.adups.fota.c.d.b().f(this);
            initPauseView(false);
        }
        com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.cancel_download_title), getString(C0216R$string.cancel_download_content), getString(C0216R$string.cancel_download_positive_btn), (a) new c(this), getString(C0216R$string.cancel_download_negative_btn), (a) null, (DialogInterface.OnDismissListener) this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onClickDownload() {
        /*
            r17 = this;
            r0 = r17
            java.lang.String r1 = ""
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)
            boolean r1 = com.adups.fota.MyApplication.f()
            r2 = 2131558514(0x7f0d0072, float:1.8742346E38)
            if (r1 == 0) goto L_0x0025
            boolean r1 = com.adups.fota.utils.k.c(r17)
            if (r1 != 0) goto L_0x0025
            java.lang.String r1 = r0.getString(r2)
            r2 = 2131558458(0x7f0d003a, float:1.8742232E38)
            java.lang.String r2 = r0.getString(r2)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x0025:
            boolean r1 = com.adups.fota.utils.k.a(r17)
            if (r1 == 0) goto L_0x0194
            com.adups.fota.utils.c r1 = com.adups.fota.utils.c.j()
            boolean r1 = r1.x()
            java.lang.String r3 = "download_only_wifi"
            boolean r1 = com.adups.fota.utils.o.a((android.content.Context) r0, (java.lang.String) r3, (boolean) r1)
            boolean r3 = com.adups.fota.utils.k.b(r17)
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x005c
            if (r3 == 0) goto L_0x005c
            java.lang.String r1 = "no download reason : only support wifi update but mobile wifi off"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)
            r1 = 417(0x1a1, float:5.84E-43)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r1, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r2)
            r2 = 2131558567(0x7f0d00a7, float:1.8742453E38)
            java.lang.String r2 = r0.getString(r2)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x005c:
            com.adups.fota.e.c r1 = com.adups.fota.e.c.a()
            com.adups.fota.bean.VersionBean r1 = r1.c()
            r3 = 2
            if (r1 == 0) goto L_0x0179
            long r6 = r1.getFileSize()
            com.adups.fota.e.c r1 = com.adups.fota.e.c.a()
            java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
            java.lang.String r9 = "download_path_server"
            java.lang.Object r1 = r1.a((java.lang.String) r9, r8)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.String r8 = "no download reason : sd card status illegal"
            r10 = 418(0x1a2, float:5.86E-43)
            java.lang.String r11 = "no download reason : no sd card mounted"
            java.lang.String r12 = "no download reason : space not enough"
            r13 = 1
            r14 = 2131558555(0x7f0d009b, float:1.874243E38)
            r15 = 2131558552(0x7f0d0098, float:1.8742423E38)
            r9 = 419(0x1a3, float:5.87E-43)
            if (r1 == 0) goto L_0x00e1
            if (r1 == r13) goto L_0x00ae
            if (r1 == r3) goto L_0x0096
            goto L_0x0179
        L_0x0096:
            boolean r1 = com.adups.fota.utils.t.a((android.content.Context) r0, (long) r6)
            if (r1 != 0) goto L_0x0179
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r9, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r15)
            java.lang.String r2 = r0.getString(r14)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x00ae:
            boolean r1 = com.adups.fota.utils.t.h(r17)
            if (r1 != 0) goto L_0x00c9
            com.adups.fota.utils.LogUtil.a((java.lang.String) r11)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r10, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r2)
            r2 = 2131558578(0x7f0d00b2, float:1.8742476E38)
            java.lang.String r2 = r0.getString(r2)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x00c9:
            boolean r1 = com.adups.fota.utils.t.c((android.content.Context) r0, (long) r6)
            if (r1 != 0) goto L_0x0179
            com.adups.fota.utils.LogUtil.a((java.lang.String) r8)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r9, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r15)
            java.lang.String r2 = r0.getString(r14)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x00e1:
            com.adups.fota.utils.c r1 = com.adups.fota.utils.c.j()
            java.lang.String r1 = r1.m()
            r16 = -1
            int r3 = r1.hashCode()
            r2 = -1820761141(0xffffffff937963cb, float:-3.147742E-27)
            if (r3 == r2) goto L_0x0104
            r2 = 570410685(0x21ffc6bd, float:1.7332078E-18)
            if (r3 == r2) goto L_0x00fa
            goto L_0x010e
        L_0x00fa:
            java.lang.String r2 = "internal"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x010e
            r1 = 0
            goto L_0x010f
        L_0x0104:
            java.lang.String r2 = "external"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x010e
            r1 = 1
            goto L_0x010f
        L_0x010e:
            r1 = -1
        L_0x010f:
            if (r1 == 0) goto L_0x0161
            if (r1 == r13) goto L_0x012b
            boolean r1 = com.adups.fota.utils.t.e(r0, r6)
            if (r1 != 0) goto L_0x0179
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r9, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r15)
            java.lang.String r2 = r0.getString(r14)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x012b:
            boolean r1 = com.adups.fota.utils.t.h(r17)
            if (r1 != 0) goto L_0x0149
            com.adups.fota.utils.LogUtil.a((java.lang.String) r11)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r10, (java.lang.String) r4)
            r1 = 2131558514(0x7f0d0072, float:1.8742346E38)
            java.lang.String r1 = r0.getString(r1)
            r2 = 2131558578(0x7f0d00b2, float:1.8742476E38)
            java.lang.String r2 = r0.getString(r2)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x0149:
            boolean r1 = com.adups.fota.utils.t.c((android.content.Context) r0, (long) r6)
            if (r1 != 0) goto L_0x0179
            com.adups.fota.utils.LogUtil.a((java.lang.String) r8)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r9, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r15)
            java.lang.String r2 = r0.getString(r14)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x0161:
            boolean r1 = com.adups.fota.utils.t.a((android.content.Context) r0, (long) r6)
            if (r1 != 0) goto L_0x0179
            com.adups.fota.utils.LogUtil.a((java.lang.String) r12)
            com.adups.fota.f.a.a((android.content.Context) r0, (boolean) r5, (int) r9, (java.lang.String) r4)
            java.lang.String r1 = r0.getString(r15)
            java.lang.String r2 = r0.getString(r14)
            com.adups.fota.utils.d.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2, (android.content.DialogInterface.OnDismissListener) r0)
            return
        L_0x0179:
            boolean r1 = com.adups.fota.utils.k.b(r17)
            if (r1 == 0) goto L_0x0183
            r17.showDownloadNoticeDialog()
            goto L_0x019c
        L_0x0183:
            com.adups.fota.c.d r1 = com.adups.fota.c.d.b()
            r1.a(r0, r5)
            r1 = 2
            com.adups.fota.b.d.a((android.content.Context) r0, (int) r1)
            com.adups.fota.view.FooterLayout r2 = r0.mFooterLayout
            r2.a(r1)
            goto L_0x019c
        L_0x0194:
            java.lang.String r1 = "no download reason : no net connect"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)
            r17.showNoNetWorkDialog()
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.GoogleOtaClient.onClickDownload():void");
    }

    private void onClickInstallLater() {
        LogUtil.a("enter");
        int a2 = o.a((Context) this, "install_later_count", 0) + 1;
        LogUtil.a("installLaterCount=" + a2);
        o.b((Context) this, "install_later_count", a2);
        long c2 = o.c(this, "ota_install_delay_schedule");
        LogUtil.a("schedule_time = " + c2);
        if (c2 <= 0) {
            showInstallDelayDialog();
        } else {
            finish();
        }
    }

    private void onClickPause() {
        LogUtil.a("enter");
        com.adups.fota.c.d.b().f(this);
    }

    /* access modifiers changed from: private */
    public void onClickQuery() {
        boolean a2 = k.a(this);
        LogUtil.a("isConnected = " + a2);
        if (a2) {
            g.a().a_shaKey_method2((Context) this, 2);
        } else {
            showNoNetWorkDialog();
        }
    }

    private void onClickResume(boolean z) {
        LogUtil.a("enter");
        if (MyApplication.f() && !k.c(this)) {
            com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.call_warn), (DialogInterface.OnDismissListener) this);
        } else if (k.a(this)) {
            boolean a2 = o.a((Context) this, "download_only_wifi", com.adups.fota.utils.c.j().x());
            boolean b2 = k.b(this);
            if (!a2 || !b2) {
                VersionBean c2 = com.adups.fota.e.c.a().c();
                if (c2 != null) {
                    int b3 = t.b((Context) this, c2.getFileSize());
                    if (b3 == 1) {
                        LogUtil.a("no download reason : no sd card mounted");
                        com.adups.fota.f.a.a((Context) this, false, 418, (String) null);
                        com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.unmount_sdcard), (DialogInterface.OnDismissListener) this);
                        return;
                    } else if (b3 == 2) {
                        LogUtil.a("no download reason : sd card status not illegal");
                        com.adups.fota.f.a.a((Context) this, false, 419, (String) null);
                        com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.sdCard_upgrade_memory_space_not_enough), getString(C0216R$string.sdcard_crash_or_unmount), (DialogInterface.OnDismissListener) this);
                        return;
                    }
                }
                if (!k.b(this)) {
                    com.adups.fota.c.d.b().a_shaKey_method2(this, 0);
                    com.adups.fota.b.d.a_shaKey_method2((Context) this, 2);
                    this.mFooterLayout.a(2);
                } else if (z) {
                    showDownloadNoticeDialog();
                } else {
                    int intValue = ((Integer) com.adups.fota.e.c.a().a_shaKey_method2("download_auto", Integer.class)).intValue();
                    int intValue2 = ((Integer) com.adups.fota.e.c.a().a_shaKey_method2("download_wifi", Integer.class)).intValue();
                    if (intValue != 1 || intValue2 != 0) {
                        showDownloadNoticeDialog();
                    }
                }
            } else {
                com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.setting_network_tip), (DialogInterface.OnDismissListener) this);
                LogUtil.a("no download reason : only support wifi update but mobile wifi off");
                com.adups.fota.f.a.a((Context) this, false, 417, (String) null);
            }
        } else {
            LogUtil.a("no download reason : no net connect");
            showNoNetWorkDialog();
        }
    }

    /* access modifiers changed from: private */
    public void onClickSchedule(int i) {
        LogUtil.a("delay time: " + schedule_array[i]);
        o.b((Context) this, "ota_install_delay_schedule", schedule_array[i]);
        com.adups.fota.manager.b.a_shaKey_method2(this, schedule_array[i] + System.currentTimeMillis());
        saveDelayInstallData();
        com.adups.fota.manager.e.a().a_shaKey_method2((Context) this, 105);
        closeDialog();
        finish();
    }

    private void onClickTitle() {
        DeviceFunctionView deviceFunctionView = new DeviceFunctionView(this);
        String str = "APK Release Date:2019-12-04 16:35\nFCM ID: " + com.adups.fota.manager.f.h() + "\nIMEI: " + com.adups.fota.utils.c.j().a((Context) this) + "\nMID: " + j.b((Context) this) + "\nSPN: " + com.adups.fota.utils.c.j().c((Context) this) + "\nAppVersionName: " + n.b(this) + ".0.1.006" + "_" + "2019-12-04 16:35" + "\nAppVersionCode: " + n.a((Context) this) + "\nversion: " + com.adups.fota.utils.c.j().k() + "\nproject: " + com.adups.fota.utils.c.j().o();
        if (!TextUtils.isEmpty(com.adups.fota.utils.c.j().a((Context) this)) && !com.adups.fota.utils.c.j().a((Context) this).matches("^[A-Za-z0-9:]+$")) {
            v.a((int) C0216R$string.match_imei);
        }
        deviceFunctionView.setInfo(str);
        deviceFunctionView.setOnFunctionClickListener(this);
        com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.app_name), (DialogInterface.OnDismissListener) this, (View) deviceFunctionView);
    }

    private void queryCallback(EventMessage eventMessage) {
        closeDialog();
        int c2 = com.adups.fota.b.d.c(this);
        int arg1 = eventMessage.getArg1();
        if (arg1 == 404) {
            deviceRooted();
        } else if (arg1 != 1009) {
            if (arg1 == 1111) {
                updateSafeFlag();
            } else if (arg1 == 3005) {
                v.a((int) C0216R$string.sdcard_crash_or_unmount);
            } else if (arg1 == 3008) {
                tipsMessage(eventMessage);
            } else if (arg1 != 3010) {
                switch (arg1) {
                    case 1001:
                    case 1004:
                        this.userPause = 0;
                        initNewVersionView();
                        return;
                    case 1002:
                    case 1003:
                        noFindVersion();
                        return;
                    case 1005:
                        if (c2 < 2) {
                            initNewVersionView();
                            return;
                        }
                        return;
                    case 1006:
                        initIdleView();
                        return;
                    case 1007:
                        com.adups.fota.c.c.b().a((Context) this);
                        com.adups.fota.b.d.d(this);
                        initIdleView();
                        this.mHandler.sendEmptyMessageDelayed(34, 1200);
                        return;
                    default:
                        return;
                }
            } else {
                tipsMessage(eventMessage);
            }
        } else if (c2 == 0 && isFront()) {
            com.adups.fota.utils.d.b(this, (String) null, this, LayoutInflater.from(this).inflate(C0214R$layout.dialog_loading, (ViewGroup) null));
        }
    }

    /* access modifiers changed from: private */
    public void queryFullRom() {
        LogUtil.a("enter");
        if (k.a(this)) {
            g.a().a((Context) this, 2, 2);
        } else {
            showNoNetWorkDialog();
        }
    }

    private void resetAlarm() {
        long c2 = o.c(this, "ota_install_delay_schedule");
        LogUtil.a("schedule_time = " + c2);
        if (c2 > 0) {
            com.adups.fota.manager.b.a_shaKey_method2(this, c2 + System.currentTimeMillis());
        }
    }

    private void saveDelayInstallData() {
        com.adups.fota.f.a.a_shaKey_method2(this, "delay");
    }

    private void setDownloadProgress(int i) {
        if (com.adups.fota.utils.c.j().v()) {
            this.progressTextLayout.setProgress(i);
        } else {
            this.mProgress.setDownLoadProgress(i);
        }
    }

    private void showAbView(boolean z, boolean z2) {
        if (z) {
            this.pre_view.setVisibility(8);
            this.ab_view.setVisibility(0);
            if (z2) {
                this.pro_view.setVisibility(0);
                this.battery_tip.setVisibility(8);
                return;
            }
            this.pro_view.setVisibility(8);
            this.battery_tip.setVisibility(0);
            return;
        }
        this.pre_view.setVisibility(0);
        this.ab_view.setVisibility(8);
    }

    private void showDownloadNoticeDialog() {
        NetworkWarnView networkWarnView = new NetworkWarnView(this);
        networkWarnView.setTitle(getString(C0216R$string.ota_no_wifi_tip));
        com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(17039360), (a) new d(this), getString(C0216R$string.btn_download), (a) new e(this), (DialogInterface.OnDismissListener) this, (View) networkWarnView);
    }

    private void showInstallDelayDialog() {
        this.delayTimeCounts = 15;
        InstallDelayView installDelayView = new InstallDelayView(this);
        installDelayView.setOnItemClickListener(this);
        this.dialog = com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.remind_last_time) + "(" + this.delayTimeCounts + ")", 17, (DialogInterface.OnDismissListener) this, (View) installDelayView);
        this.delayTimeCounts--;
        this.mHandler.sendEmptyMessageDelayed(11, 1000);
    }

    private void showNoNetWorkDialog() {
        com.adups.fota.utils.d.a((Context) this, getString(C0216R$string.not_support_fota_title), (DialogInterface.OnDismissListener) this, (View) new NetworkWarnView(this));
    }

    private void showToastOrDialog(String str) {
        LogUtil.a("showToastOrDialog,message=" + str);
        if (isFront()) {
            v.a(str);
        }
    }

    /* access modifiers changed from: private */
    public void statusAction(int i) {
        if (i == 1) {
            onClickDownload();
        } else if (i == 4) {
            onClickInstallNow();
        }
    }

    private void updateSafeFlag() {
        if (!this.isActiveSafe) {
            this.isActiveSafe = true;
        }
    }

    public void closeDialog() {
        if (isFront()) {
            super.closeDialog();
        }
    }

    public void dealWithIntent(Intent intent) {
        super.dealWithIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("flag");
            if (!TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase("install")) {
                onClickInstallNow();
                resetAlarm();
            }
        }
    }

    public int getPercent() {
        if (com.adups.fota.e.c.a().c() == null) {
            return 0;
        }
        return com.adups.fota.manager.f.e();
    }

    public void initWidget() {
        LogUtil.a("enter");
        if (n.a(Process.myUid()) != 0) {
            v.a((int) C0216R$string.guest_hint);
            finish();
        }
        setContentView(C0214R$layout.activity_ota_client);
        initView();
        if (com.adups.fota.utils.c.j().v()) {
            this.appBarLayout.setVisibility(8);
        }
        if (!e.a().a((Object) this)) {
            e.a().c(this);
        }
        this.mHandler.sendEmptyMessageDelayed(33, 1000);
        LogUtil.a("exit");
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout != null && drawerLayout.f(3)) {
            this.mDrawerLayout.a(3);
        } else if (com.adups.fota.b.d.c(this) == 2 || com.adups.fota.b.d.c(this) == 1 || com.adups.fota.b.d.c(this) == 5) {
            moveTaskToBack(true);
        } else {
            finish();
        }
    }

    public void onClick(int i) {
        onClickSchedule(i);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        MyApplication.g();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        e.a().d(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.mFooterLayout.a();
    }

    public void onItemClick(int i) {
        if (i == 0) {
            exportData();
        } else if (i != 1) {
            if (i == 2) {
                closeDebug();
            }
        } else if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            openDebug();
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, REQUEST_CODE);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || !com.adups.fota.utils.c.j().B()) {
            LogUtil.a("keyCode : " + i);
            if (com.adups.fota.utils.c.j().w() && i == 20) {
                this.mFooterLayout.a();
            }
            return super.onKeyDown(i, keyEvent);
        }
        new com.adups.fota.view.e().a_shaKey_method2((Activity) this, (View) this.setting);
        return true;
    }

    @org.greenrobot.eventbus.o(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventMessage eventMessage) {
        LogUtil.a(" what  = " + eventMessage.getWhat() + "; param1= " + eventMessage.getArg1() + "; param2= " + eventMessage.getArg2() + "; param3= " + eventMessage.getArg3() + "");
        int what = eventMessage.getWhat();
        if (what == 100) {
            queryCallback(eventMessage);
        } else if (what == REQUEST_CODE) {
            downloadCallback(eventMessage);
        } else if (what == 300) {
            installCallback(eventMessage);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.adups.fota.manager.a.b().a(false);
        q.a().b();
    }

    public void onPhoneCalling() {
        LogUtil.a("");
        if (com.adups.fota.b.d.c(this) == 2) {
            onClickPause();
        }
    }

    public void onPhoneOff() {
        LogUtil.a("");
        if (com.adups.fota.b.d.c(this) == 3) {
            onClickResume(false);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == REQUEST_CODE) {
            openDebug();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initStatus();
        MyApplication.a((b) this);
        com.adups.fota.manager.a.b().a(true);
        if (!com.adups.fota.utils.c.j().u()) {
            q.a().a((f) this);
        }
    }

    public void onShaking() {
        if (com.adups.fota.utils.c.j().u()) {
            LogUtil.a("onShaking isHideShake and return ");
            return;
        }
        closeDialog();
        int c2 = com.adups.fota.b.d.c(this);
        LogUtil.a("status : " + c2);
        if (c2 == 0) {
            onClickQuery();
        } else if (c2 == 1) {
            onClickDownload();
        } else if (c2 == 3) {
            onClickResume(true);
        } else if (c2 == 4) {
            onClickInstallNow();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (com.adups.fota.b.d.c(this) == 5) {
            o.b((Context) this, "ota_ab_progress", this.progress_update_id.getProgress());
        }
    }

    public void onTitleClick(View view) {
        int i = this.mClickCount + 1;
        this.mClickCount = i;
        if (i > 4) {
            this.mClickCount = 0;
            onClickTitle();
            LogUtil.a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void setTitleView(TitleView titleView) {
        titleView.setImage(C0215R$mipmap.small_logo);
        if (com.adups.fota.utils.c.j().B()) {
            titleView.setSettingVisible(true);
            titleView.setSettingClickListener(this);
        }
        this.setting = titleView.getSetting();
    }

    public void tipsMessage(EventMessage eventMessage) {
        try {
            if (com.adups.fota.b.d.c(this) == 0 && isFront()) {
                if (k.a(this)) {
                    if (eventMessage.getArg2() == 0) {
                        if (eventMessage.getObject() != null) {
                            String replaceAll = com.adups.fota.b.b.f1542a.replaceAll("https://", "");
                            String replaceAll2 = com.adups.fota.b.b.f1543b.replaceAll("https://", "");
                            v.a(getString(C0216R$string.network_error) + "(" + eventMessage.getObject().toString().replaceAll(replaceAll, "fota server ").replaceAll(replaceAll2, "fota server ") + ")");
                            return;
                        }
                    }
                    v.a(getString(C0216R$string.network_error) + "(" + eventMessage.getArg2() + ")");
                    return;
                }
                v.a((int) C0216R$string.ota_toast_no_network);
            }
        } catch (Exception unused) {
            v.a((int) C0216R$string.ota_toast_no_network);
        }
    }

    public void widgetClick(View view) {
        if (view.getTag() != null) {
            if (isClick2Fast()) {
                v.a((int) C0216R$string.button_click_toast);
                return;
            }
            switch (((Integer) view.getTag()).intValue()) {
                case 0:
                    onClickQuery();
                    return;
                case 1:
                    onClickDownload();
                    return;
                case 2:
                    onClickPause();
                    return;
                case 3:
                case 4:
                    onClickResume(true);
                    return;
                case 5:
                    onClickCancel();
                    return;
                case 7:
                    onClickInstallNow();
                    return;
                case 8:
                    onClickInstallLater();
                    return;
                case 9:
                    openMenu();
                    return;
                case 10:
                    new com.adups.fota.view.e().a_shaKey_method2((Activity) this, view);
                    return;
                case 12:
                    com.adups.fota.h.c.a().a((Context) this);
                    return;
                default:
                    return;
            }
        }
    }
}
