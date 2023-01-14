package com.adups.fota.h;

import android.content.Context;
import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import org.greenrobot.eventbus.e;

/* compiled from: Recovery */
class a extends UpdateEngineCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1586a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1587b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ UpdateEngine f1588c;
    final /* synthetic */ c d;

    a(c cVar, Context context, String str, UpdateEngine updateEngine) {
        this.d = cVar;
        this.f1586a = context;
        this.f1587b = str;
        this.f1588c = updateEngine;
    }

    public void onPayloadApplicationComplete(int i) {
        LogUtil.a("onPayloadApplicationComplete,errorCode = " + i);
        if (i == 0) {
            com.adups.fota.f.a.a(this.f1586a, true, i, "ab");
            this.d.b(this.f1586a);
            return;
        }
        this.d.a(this.f1586a, i, true);
    }

    public void onStatusUpdate(int i, float f) {
        LogUtil.a("update status,percent = " + f + ",status=" + i + ",show=" + c.j().s());
        if (i != 0) {
            float f2 = 50.0f;
            if (i == 3) {
                e a2 = e.a();
                if (!"ShowFinalizingPro".equalsIgnoreCase(c.j().s())) {
                    f2 = 100.0f;
                }
                a2.b(new EventMessage(300, i, Double.valueOf(Math.floor((double) (f * f2))).longValue(), 600, "ab"));
            } else if (i != 5) {
                if (i == 6) {
                    this.d.b(this.f1586a);
                }
            } else if ("ShowFinalizingPro".equalsIgnoreCase(c.j().s())) {
                e.a().b(new EventMessage(300, i, Double.valueOf(Math.floor((double) (f * 50.0f))).longValue() + 50, 600, "ab"));
            }
        } else if (!this.d.f1593b) {
            this.d.a(this.f1586a, this.f1587b, this.f1588c);
        }
    }
}
