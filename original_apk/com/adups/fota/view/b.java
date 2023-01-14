package com.adups.fota.view;

import android.view.View;
import android.widget.PopupWindow;
import com.adups.fota.C0216R$string;
import com.adups.fota.MyApplication;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.utils.v;
import org.greenrobot.eventbus.e;

/* compiled from: PopWindowsLayout */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1682a;

    b(e eVar) {
        this.f1682a = eVar;
    }

    public void onClick(View view) {
        this.f1682a.f1687a.dismiss();
        PopupWindow unused = this.f1682a.f1687a = null;
        if (d.c(MyApplication.c()) == 5) {
            v.a((int) C0216R$string.tips_abInstall);
        } else {
            e.a().b(new EventMessage(100, 1007, 0, 0, (Object) null));
        }
    }
}
