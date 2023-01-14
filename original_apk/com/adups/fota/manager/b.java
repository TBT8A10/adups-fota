package com.adups.fota.manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.adups.fota.b.a;
import com.adups.fota.receiver.MyReceiver;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.o;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/* compiled from: AlarmManager */
public class b {
    private static void a(Context context, int i, long j) {
        Intent intent = new Intent(context, MyReceiver.class);
        intent.setAction(a.j);
        intent.putExtra("task", i);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            LogUtil.a("alarm time = " + SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(j)) + " , requestCode = " + i);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 19) {
                alarmManager.set(0, j, broadcast);
            } else if (i2 < 23) {
                alarmManager.setExact(0, j, broadcast);
            } else {
                alarmManager.setExactAndAllowWhileIdle(0, j, broadcast);
            }
        }
    }

    public static void b(Context context, long j) {
        a(context, 4, j);
    }

    public static void c(Context context) {
        a(context, 2, (System.currentTimeMillis() + c.j().p()) - SystemClock.elapsedRealtime());
    }

    private static void d(Context context, long j) {
        a(context, 1, System.currentTimeMillis() + j);
    }

    public static void e(Context context) {
        a(context, 13, f.m());
    }

    public static void f(Context context) {
        long currentTimeMillis = System.currentTimeMillis() + 7200000;
        f.c(currentTimeMillis);
        a(context, 13, currentTimeMillis);
    }

    public static long b(Context context) {
        long a2 = o.a(context, "check_freq", 2940);
        if (a2 == 2940) {
            a2 = (long) o.a(context, "check_local_freq", com.adups.fota.b.c.a());
        }
        return a2 * 1000 * 60;
    }

    public static void c(Context context, long j) {
        a(context, 12, j);
    }

    public static void d(Context context) {
        d(context, b(context));
    }

    public static void a(Context context, long j) {
        a(context, 6, j);
    }

    public static void a(Context context) {
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        instance.set(11, new Random().nextInt(4));
        a(context, 14, instance.getTimeInMillis());
    }
}
