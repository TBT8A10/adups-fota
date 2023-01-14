package com.adups.fota.activity;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.adups.fota.C0216R$string;
import com.adups.fota.MyApplication;
import com.adups.fota.b.a;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.d;
import com.adups.fota.utils.t;
import java.io.File;

/* compiled from: SdcardUpdateActivity */
class p extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SdcardUpdateActivity f1535a;

    p(SdcardUpdateActivity sdcardUpdateActivity) {
        this.f1535a = sdcardUpdateActivity;
    }

    public void handleMessage(Message message) {
        if (!Thread.currentThread().isInterrupted()) {
            int i = message.what;
            if (i == -2) {
                this.f1535a.closeDialog();
                SdcardUpdateActivity sdcardUpdateActivity = this.f1535a;
                d.a((Context) sdcardUpdateActivity, sdcardUpdateActivity.getString(C0216R$string.sdCard_upgrade_copy_file_fail), this.f1535a.getString(C0216R$string.sdCard_upgrade_copy_file_fail_prompt));
            } else if (i == -1) {
                SdcardUpdateActivity sdcardUpdateActivity2 = this.f1535a;
                d.a((Context) sdcardUpdateActivity2, sdcardUpdateActivity2.getString(C0216R$string.sdCard_upgrade_find_update_file_fail), this.f1535a.getString(C0216R$string.sdCard_upgrade_update_file_fail_prompt));
            } else if (i == 2) {
                LogUtil.a("LocalSdUpdate = " + this.f1535a.e);
                File file = new File(this.f1535a.e);
                int i2 = Build.VERSION.SDK_INT;
                if (file.exists()) {
                    LogUtil.a("LocalSdUpdate : selectFile.exists true");
                    if (!file.getName().equals("LocalSdUpdate.zip")) {
                        File file2 = new File(file.getParent() + "/LocalSdUpdate.zip");
                        if (i2 < 23 && file.renameTo(file2)) {
                            LogUtil.a("rename to " + file2);
                            String unused = this.f1535a.e = file.getPath();
                        }
                    }
                }
                LogUtil.a("sdkVer = " + i2);
                if (i2 >= 23) {
                    SdcardUpdateActivity sdcardUpdateActivity3 = this.f1535a;
                    if (!t.c((Context) sdcardUpdateActivity3, sdcardUpdateActivity3.e) || this.f1535a.e.contains("/emulated/0")) {
                        SdcardUpdateActivity sdcardUpdateActivity4 = this.f1535a;
                        long length = new File(sdcardUpdateActivity4.e).length();
                        SdcardUpdateActivity sdcardUpdateActivity5 = this.f1535a;
                        if (sdcardUpdateActivity4.a(length, sdcardUpdateActivity5.a(sdcardUpdateActivity5.e))) {
                            LogUtil.a("23, copy to android/data/...");
                            this.f1535a.f();
                            if ((Build.VERSION.SDK_INT > 27 && c.j().E()) || (Build.VERSION.SDK_INT >= 29 && this.f1535a.e.contains(t.b(MyApplication.c(), false)))) {
                                this.f1535a.f.sendMessageDelayed(this.f1535a.f.obtainMessage(13), 100);
                            } else if (this.f1535a.e.contains("/emulated/0")) {
                                this.f1535a.f.sendMessageDelayed(this.f1535a.f.obtainMessage(11), 100);
                            } else {
                                this.f1535a.f.sendMessageDelayed(this.f1535a.f.obtainMessage(12), 100);
                            }
                        } else {
                            return;
                        }
                    }
                }
                if (i2 >= 21) {
                    SdcardUpdateActivity sdcardUpdateActivity6 = this.f1535a;
                    if (t.c((Context) sdcardUpdateActivity6, sdcardUpdateActivity6.e)) {
                        SdcardUpdateActivity sdcardUpdateActivity7 = this.f1535a;
                        long length2 = new File(sdcardUpdateActivity7.e).length();
                        SdcardUpdateActivity sdcardUpdateActivity8 = this.f1535a;
                        if (sdcardUpdateActivity7.a(length2, sdcardUpdateActivity8.a(sdcardUpdateActivity8.e))) {
                            LogUtil.a("updatePackage, copy to data");
                            this.f1535a.f();
                            this.f1535a.f.sendMessageDelayed(this.f1535a.f.obtainMessage(11), 100);
                        } else {
                            return;
                        }
                    } else {
                        this.f1535a.g();
                    }
                } else {
                    this.f1535a.g();
                }
            } else if (i != 15) {
                switch (i) {
                    case 11:
                        LogUtil.a("LocalSdUpdate : COPY_FILE1_TO_DATA !");
                        SdcardUpdateActivity.f1514a.execute(new m(this));
                        break;
                    case 12:
                        LogUtil.a("LocalSdUpdate : COPY_FILE23_TO_DATA !");
                        SdcardUpdateActivity.f1514a.execute(new n(this));
                        break;
                    case 13:
                        LogUtil.a("LocalSdUpdate : COPY_FILE_TO_DATA_OTA !");
                        SdcardUpdateActivity.f1514a.execute(new o(this));
                        break;
                }
            } else {
                File file3 = new File("/data/media/0/adupsfota/update.zip");
                File file4 = new File("/data/media/adupsfota/update.zip");
                new File(a.e);
                if (file3.exists()) {
                    file3.delete();
                }
                if (file4.exists()) {
                    file4.delete();
                }
                this.f1535a.g();
            }
        }
        super.handleMessage(message);
    }
}
