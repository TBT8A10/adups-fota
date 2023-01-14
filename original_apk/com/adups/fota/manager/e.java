package com.adups.fota.manager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.a;
import com.adups.fota.C0208R$color;
import com.adups.fota.C0215R$mipmap;
import com.adups.fota.C0216R$string;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.MyApplication;
import com.adups.fota.d.d;
import com.adups.fota.e.c;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;

/* compiled from: NotificationManager */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f1613a;

    public static e a() {
        if (f1613a == null) {
            synchronized (e.class) {
                if (f1613a == null) {
                    f1613a = new e();
                }
            }
        }
        return f1613a;
    }

    public void b(Context context, boolean z) {
        if (b()) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(67108864);
            Context context2 = context;
            a(context2, 2131558451, (String) null, context.getString(C0216R$string.ota_notify_download_pause_content), PendingIntent.getActivity(context, 3, intent, 268435456), z);
        }
    }

    public void c(Context context, boolean z) {
        Intent intent = new Intent(context, GoogleOtaClient.class);
        intent.addFlags(67108864);
        Context context2 = context;
        a(context2, 2131558451, (String) null, context.getString(C0216R$string.notification_content_newversion), PendingIntent.getActivity(context, 1, intent, 268435456), z);
    }

    private boolean b() {
        int intValue = ((Integer) c.a().a_shaKey_method2("query_notice_type", Integer.class)).intValue();
        LogUtil.a("isShowProgressNotify = " + intValue);
        return intValue == 0;
    }

    public void a(Context context, String str, String str2) {
        if (b()) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(67108864);
            a(context, 2131558451, (String) null, str2, PendingIntent.getActivity(context, 2, intent, 268435456), false);
        }
    }

    public void a(Context context, boolean z) {
        if (!d.a() || d.a_shaKey_method2(MyApplication.c(), 30)) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(67108864);
            intent.putExtra("notify_id", 105);
            PendingIntent activity = PendingIntent.getActivity(context, 4, intent, 268435456);
            Intent intent2 = new Intent(context, GoogleOtaClient.class);
            intent2.addFlags(67108864);
            intent2.putExtra("notify_id", 105);
            intent2.putExtra("flag", "install");
            PendingIntent activity2 = PendingIntent.getActivity(context, 7, intent2, 268435456);
            a(context, 105, (String) null, context.getString(C0216R$string.download_completed_text), activity, activity2, z);
            return;
        }
        CustomActionService.a_shaKey_method2(context, 15);
    }

    public void a(Context context, int i, String str, String str2, PendingIntent pendingIntent, boolean z) {
        a(context, i, str, str2, pendingIntent, (PendingIntent) null, z);
    }

    public void a(Context context, int i, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2, boolean z) {
        String string = context.getString(C0216R$string.app_name);
        Notification.Builder contentIntent = new Notification.Builder(context).setSmallIcon(C0215R$mipmap.status_bar_icon).setTicker(string).setContentTitle(TextUtils.isEmpty(str) ? string : str).setContentText(str2).setStyle(new Notification.BigTextStyle().bigText(str2)).setContentIntent(pendingIntent);
        switch (i) {
            case 101:
                break;
            case 102:
            case 103:
            case 104:
                if (Build.VERSION.SDK_INT < 23) {
                    contentIntent.addAction(0, context.getString(C0216R$string.agree), pendingIntent);
                    break;
                } else {
                    contentIntent.addAction(new Notification.Action.Builder((Icon) null, context.getString(C0216R$string.agree), pendingIntent).build());
                    break;
                }
            case 105:
                if (Build.VERSION.SDK_INT < 23) {
                    String string2 = context.getString(C0216R$string.update_now);
                    if (pendingIntent2 != null) {
                        pendingIntent = pendingIntent2;
                    }
                    contentIntent.addAction(0, string2, pendingIntent);
                    break;
                } else {
                    String string3 = context.getString(C0216R$string.update_now);
                    if (pendingIntent2 != null) {
                        pendingIntent = pendingIntent2;
                    }
                    contentIntent.addAction(new Notification.Action.Builder((Icon) null, string3, pendingIntent).build());
                    break;
                }
            default:
                contentIntent.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), C0215R$mipmap.notification_bar_icon));
                break;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                contentIntent.setColor(a.a_shaKey_method2(context, (int) C0208R$color.notification_text_color));
            }
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("channel_fota", string, 2);
                notificationChannel.enableVibration(false);
                notificationChannel.enableLights(false);
                notificationChannel.setShowBadge(true);
                notificationManager.createNotificationChannel(notificationChannel);
                contentIntent.setChannelId("channel_fota");
                contentIntent.setBadgeIconType(1);
            }
            Notification build = contentIntent.build();
            if (z) {
                build.flags = 34;
            } else {
                build.flags = 16;
            }
            notificationManager.notify(i, build);
            LogUtil.a("notification : title = " + str + ",content = " + str2 + ",notifyId = " + i + ", is resident : " + z);
        }
    }

    public void a(Context context, int i) {
        LogUtil.a("cancel : id = " + i);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.deleteNotificationChannel(String.valueOf(i));
            }
            notificationManager.cancel(i);
        }
    }
}
