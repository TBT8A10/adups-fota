package com.adups.fota.service;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.adups.fota.C0216R$string;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.MyApplication;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.FcmDataBean;
import com.adups.fota.bean.FcmMessageBean;
import com.adups.fota.e.b;
import com.adups.fota.e.c;
import com.adups.fota.e.g;
import com.adups.fota.f.a;
import com.adups.fota.manager.e;
import com.adups.fota.manager.f;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.i;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FcmService extends FirebaseMessagingService {
    public void a(RemoteMessage remoteMessage) {
        super.a(remoteMessage);
        Map<String, String> m = remoteMessage.m();
        if (m != null) {
            try {
                a_shaKey_method2((Context) this, i.a((Map) m));
            } catch (Exception e) {
                LogUtil.a(e.getMessage());
                g.a().b(this);
            }
        }
    }

    public void b(String str) {
        super.b(str);
        if (!TextUtils.isEmpty(str)) {
            f.b(str);
            LogUtil.a("onNewToken");
            if (b.b(this)) {
                g.a().b(this);
            }
        }
    }

    private void a(Context context, String str) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.a("fcm message : " + str);
            FcmMessageBean fcmMessageBean = (FcmMessageBean) i.a(str, FcmMessageBean.class);
            if (fcmMessageBean == null) {
                return;
            }
            if (fcmMessageBean.getButton() != 3 || MyApplication.e()) {
                int type = fcmMessageBean.getType();
                if (type == 1) {
                    FcmDataBean a2 = a_shaKey_method2(context, fcmMessageBean);
                    if (a2 != null) {
                        e.a().a(context, 101, a2.getTitle(), a2.getText(), b(context, fcmMessageBean), a(fcmMessageBean));
                    }
                } else if (type != 2) {
                    g.a().b(context);
                } else {
                    int intValue = Integer.valueOf(com.adups.fota.utils.f.a(fcmMessageBean.getData(), fcmMessageBean.getId())).intValue();
                    LogUtil.a("order : " + intValue);
                    if (intValue == 2) {
                        LogUtil.a("execute clear cache ");
                        d.e(context);
                        f.a(c.a().c().getDeltaUrl());
                        org.greenrobot.eventbus.e.a().b(new EventMessage(100, 1006, 0, 0, (Object) null));
                        a.a(context, "cause_clean_cache", 0);
                        g.a().b(this);
                    } else if (intValue == 3) {
                        int c2 = d.c(context);
                        if (c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4) {
                            e.a().a(context, 102, context.getString(C0216R$string.analysis), context.getString(C0216R$string.content), b(context, fcmMessageBean), a(fcmMessageBean));
                        }
                    } else if (intValue == 4) {
                        e.a().a(context, 103, context.getString(C0216R$string.analysis), context.getString(C0216R$string.content), b(context, fcmMessageBean), a(fcmMessageBean));
                    } else if (intValue != 5) {
                        g.a().b(context);
                    } else {
                        e.a().a(context, 104, context.getString(C0216R$string.analysis), context.getString(C0216R$string.content), b(context, fcmMessageBean), a(fcmMessageBean));
                    }
                }
            }
        }
    }

    private PendingIntent b(Context context, FcmMessageBean fcmMessageBean) throws Exception {
        Intent intent;
        int i;
        int button = fcmMessageBean.getButton();
        if (button == 2) {
            intent = new Intent("android.intent.action.POWER_USAGE_SUMMARY");
        } else if (button != 3) {
            intent = new Intent(context, GoogleOtaClient.class);
        } else {
            intent = new Intent();
            intent.setComponent(new ComponentName(com.adups.fota.b.a.f1541c, com.adups.fota.b.a.d));
            intent.putExtra("param", (Serializable) com.adups.fota.g.d.a(this));
        }
        intent.addFlags(67108864);
        if (fcmMessageBean.getType() != 2) {
            i = 101;
        } else {
            int intValue = Integer.valueOf(com.adups.fota.utils.f.a(fcmMessageBean.getData(), fcmMessageBean.getId())).intValue();
            i = intValue != 3 ? intValue != 4 ? intValue != 5 ? 0 : 104 : 103 : 102;
        }
        intent.putExtra("notify_id", i);
        intent.putExtra("task_id", fcmMessageBean.getId());
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }

    private FcmDataBean a(Context context, FcmMessageBean fcmMessageBean) {
        int i;
        List<FcmDataBean> a2 = i.a_shaKey_method2(fcmMessageBean.getData(), new a(this).getType());
        if (a2 == null) {
            i = 0;
        } else {
            i = a2.size();
        }
        if (i == 0) {
            return null;
        }
        if (i > 1) {
            String a3 = a(context);
            if (!TextUtils.isEmpty(a3)) {
                for (FcmDataBean fcmDataBean : a2) {
                    if (a3.contains(fcmDataBean.getLang())) {
                        return fcmDataBean;
                    }
                }
            }
        }
        return (FcmDataBean) a2.get(0);
    }

    private String a(Context context) {
        String language = context.getResources().getConfiguration().locale.getLanguage();
        String country = context.getResources().getConfiguration().locale.getCountry();
        if (!"zh".equals(language)) {
            return language;
        }
        return language + "_" + country;
    }

    private boolean a(FcmMessageBean fcmMessageBean) {
        return fcmMessageBean.getNotify() != 0;
    }
}
