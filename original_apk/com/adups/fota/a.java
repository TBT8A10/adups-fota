package com.adups.fota;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.adups.fota.utils.d;
import com.adups.fota.utils.k;
import com.adups.fota.view.InstallDelayView;

/* compiled from: GoogleOtaClient */
class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1502a;

    a(GoogleOtaClient googleOtaClient) {
        this.f1502a = googleOtaClient;
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 11) {
            String str = this.f1502a.getString(C0216R$string.remind_last_time) + "(" + this.f1502a.delayTimeCounts + ")";
            if (this.f1502a.delayTimeCounts > 0) {
                if (this.f1502a.dialog == null) {
                    InstallDelayView installDelayView = new InstallDelayView(this.f1502a);
                    installDelayView.setOnItemClickListener(this.f1502a);
                    GoogleOtaClient googleOtaClient = this.f1502a;
                    k unused = googleOtaClient.dialog = d.a((Context) googleOtaClient, str, 17, (DialogInterface.OnDismissListener) googleOtaClient, (View) installDelayView);
                } else {
                    this.f1502a.dialog.b(str);
                }
                GoogleOtaClient.access$010(this.f1502a);
                this.f1502a.mHandler.sendEmptyMessageDelayed(11, 1000);
                return;
            }
            this.f1502a.onClickSchedule(1);
        } else if (i == 100) {
            this.f1502a.statusAction(message.arg1);
        } else if (i != 33) {
            if (i == 34) {
                this.f1502a.queryFullRom();
            }
        } else if (com.adups.fota.b.d.c(this.f1502a) == 0 && this.f1502a.isOverRemindDate() && k.a(this.f1502a)) {
            this.f1502a.onClickQuery();
        }
    }
}
