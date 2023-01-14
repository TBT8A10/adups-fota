package com.adups.fota.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.adups.fota.C0211R$id;
import com.adups.fota.C0214R$layout;
import com.adups.fota.C0215R$mipmap;
import com.adups.fota.C0216R$string;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.e.c;
import com.adups.fota.f.a;
import com.adups.fota.f.e;
import com.adups.fota.manager.b;
import com.adups.fota.manager.f;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.d;
import com.adups.fota.utils.g;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import com.adups.fota.utils.v;
import com.adups.fota.view.TitleView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnDismissListener {
    private static final String FCM_REPORT_TYPE_FILE_PATH = "1";
    public static final String FCM_REPORT_TYPE_LOG = "3";
    private static final String FCM_REPORT_TYPE_STORAGE_SPACE = "2";
    private static final int REQUEST_READ_CODE = 100;
    private boolean isFront = false;
    private LinearLayout layout;
    private boolean mAllowFullScreen = true;
    public DrawerLayout mDrawerLayout;
    private Map<String, String> param;

    /* access modifiers changed from: private */
    public void finishPopWindows() {
        if (!getActivityName().equalsIgnoreCase(GoogleOtaClient.class.getSimpleName())) {
            finish();
        }
    }

    private String getActivityName() {
        return getClass().getSimpleName();
    }

    private String getStorageSpace() {
        File externalCacheDir = getExternalCacheDir();
        StringBuilder sb = new StringBuilder();
        if (externalCacheDir != null) {
            sb.append(Formatter.formatFileSize(this, externalCacheDir.getTotalSpace()));
            sb.append("/");
            sb.append(Formatter.formatFileSize(this, externalCacheDir.getUsableSpace()));
        }
        if (t.h(this)) {
            String b2 = t.b((Context) this, true);
            if (!TextUtils.isEmpty(b2)) {
                externalCacheDir = new File(b2);
            }
            if (externalCacheDir != null) {
                sb.append("&");
                sb.append(Formatter.formatFileSize(this, externalCacheDir.getTotalSpace()));
                sb.append("/");
                sb.append(Formatter.formatFileSize(this, externalCacheDir.getUsableSpace()));
            }
        }
        return sb.toString();
    }

    public void closeDialog() {
        d.a();
    }

    public void dealWithIntent(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("notify_id", 0);
            this.param = new HashMap();
            this.param.put("task_id", intent.getStringExtra("task_id"));
            switch (intExtra) {
                case 102:
                    this.param.put("action_type", FCM_REPORT_TYPE_FILE_PATH);
                    VersionBean c2 = c.a().c();
                    this.param.put("download_path", c2 != null ? c2.getDeltaUrl() : "");
                    this.param.put("save_path", t.e(this));
                    e.a().a_shaKey_method2((Context) this, this.param);
                    break;
                case 103:
                    if (!g.a((Context) this)) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 100);
                            break;
                        }
                    } else {
                        this.param.put("action_type", FCM_REPORT_TYPE_STORAGE_SPACE);
                        this.param.put("storage_space", getStorageSpace());
                        e.a().a_shaKey_method2((Context) this, this.param);
                        break;
                    }
                    break;
                case 104:
                    if (!LogUtil.a()) {
                        openDebug();
                        f.e(this.param.get("task_id"));
                        b.f(this);
                        break;
                    }
                    break;
            }
            com.adups.fota.manager.e.a().a_shaKey_method2((Context) this, intExtra);
        }
    }

    public void doUpdate() {
        LogUtil.a("enter");
        o.b((Context) this, "install_later_count", 0);
        d.a((Context) this, (int) C0214R$layout.dialog_update_unzip, (DialogInterface.OnDismissListener) this);
        a.a_shaKey_method2(this, "update");
        com.adups.fota.d.d.e(getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public abstract void initWidget();

    public boolean isFront() {
        return this.isFront;
    }

    public void onClick(View view) {
        widgetClick(view);
    }

    @SuppressLint({"StringFormatInvalid"})
    public void onClickInstallNow() {
        LogUtil.a("enter");
        int a2 = com.adups.fota.utils.c.j().a();
        if (!com.adups.fota.d.d.a_shaKey_method2((Context) this, a2)) {
            LogUtil.a("no update reason : battery not enough");
            CustomActionService.a_shaKey_method2(this, 15);
            d.a((Context) this, (int) C0215R$mipmap.ota_battery, getString(C0216R$string.ota_battery_low, new Object[]{Integer.valueOf(a2)}), (DialogInterface.OnDismissListener) this);
        } else if (!com.adups.fota.d.d.b(this, t.d((Context) this))) {
            LogUtil.a("no update reason : sd card status not illegal");
            d.b(this, getString(C0216R$string.battery_remove_title), getString(C0216R$string.sdcard_crash_or_unmount), (com.adups.fota.a.a) null, this);
        } else {
            d.a((Context) this, getString(C0216R$string.not_support_fota_title), getString(C0216R$string.update_prompt), (com.adups.fota.a.a) new a(this), (com.adups.fota.a.a) new b(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.a(getActivityName());
        com.adups.fota.manager.a.b().a((Activity) this);
        if (FCM_REPORT_TYPE_FILE_PATH.equals(com.adups.fota.utils.c.j().e())) {
            setRequestedOrientation(0);
        } else if (FCM_REPORT_TYPE_STORAGE_SPACE.equals(com.adups.fota.utils.c.j().e())) {
            setRequestedOrientation(4);
        } else {
            setRequestedOrientation(1);
        }
        if (this.mAllowFullScreen) {
            requestWindowFeature(1);
        }
        super.setContentView((int) C0214R$layout.base_activity_layout);
        this.layout = (LinearLayout) findViewById(C0211R$id.layout);
        setTitleView((TitleView) findViewById(C0211R$id.titleView));
        initWidget();
        dealWithIntent(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogUtil.a(getActivityName());
        com.adups.fota.manager.a.b().b(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        finishPopWindows();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dealWithIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogUtil.a(getActivityName());
        this.isFront = false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2].equalsIgnoreCase("android.permission.READ_EXTERNAL_STORAGE") && iArr[i2] == 0) {
                    this.param.put("action_type", FCM_REPORT_TYPE_STORAGE_SPACE);
                    this.param.put("storage_space", getStorageSpace());
                    e.a().a_shaKey_method2((Context) this, this.param);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        LogUtil.a(getActivityName());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogUtil.a(getActivityName());
        this.isFront = true;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        LogUtil.a(getActivityName());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LogUtil.a(getActivityName());
        if (!getActivityName().equalsIgnoreCase(PopupActivity.class.getSimpleName()) && !getActivityName().equalsIgnoreCase(InstallResultActivity.class.getSimpleName())) {
            closeDialog();
        }
    }

    public void onTitleClick(View view) {
        finish();
    }

    public void openDebug() {
        String b2 = t.b((Context) this);
        if (!t.a(b2, (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
            v.a((int) C0216R$string.sdcard_crash_or_unmount);
            return;
        }
        File file = new File(b2 + "/fota");
        if (!file.exists()) {
            file.mkdirs();
        }
        String replaceAll = SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(System.currentTimeMillis())).replaceAll(" ", "-").replaceAll(":", "-");
        File file2 = new File(file.getAbsolutePath() + "/" + replaceAll + ".txt");
        o.b((Context) this, "debug_status", true);
        o.b((Context) this, "debug_log_path", file2.getAbsolutePath());
        LogUtil.b(true);
        LogUtil.c(file2.getAbsolutePath());
        LogUtil.a("log out path : " + file.getAbsolutePath());
        v.a(getString(C0216R$string.start_catch_log) + " to " + file.getAbsolutePath());
    }

    public void openMenu() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        if (drawerLayout != null) {
            drawerLayout.g(8388611);
        }
    }

    public void setAllowFullScreen(boolean z) {
        this.mAllowFullScreen = z;
    }

    public void setContentView(int i) {
        this.layout.removeAllViews();
        this.layout.addView(LayoutInflater.from(this).inflate(i, (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public abstract void setTitleView(TitleView titleView);

    /* access modifiers changed from: protected */
    public abstract void widgetClick(View view);
}
