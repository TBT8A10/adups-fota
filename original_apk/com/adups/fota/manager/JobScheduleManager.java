package com.adups.fota.manager;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;

public class JobScheduleManager extends JobService {

    /* renamed from: a  reason: collision with root package name */
    private static long f1604a;

    /* renamed from: b  reason: collision with root package name */
    private static long f1605b;

    /* renamed from: c  reason: collision with root package name */
    private static long f1606c;
    private static long d;

    private static void a() {
        String[] j = f.j();
        f1604a = Long.parseLong(j[0]) * 60000;
        f1605b = Long.parseLong(j[1]) * 60000;
        LogUtil.a("change network min time : " + f1604a + ",change network deadline time : " + f1605b);
        String[] i = f.i();
        f1606c = Long.parseLong(i[0]) * 60000;
        d = Long.parseLong(i[1]) * 60000;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        LogUtil.a("start job id : " + jobId);
        if (jobId == 100) {
            CustomActionService.a_shaKey_method2(this, 1);
        }
        a_shaKey_method2(this, jobId);
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public static void a(Context context, int i) {
        JobScheduler jobScheduler;
        if (Build.VERSION.SDK_INT >= 21 && (jobScheduler = (JobScheduler) context.getSystemService("jobscheduler")) != null) {
            a();
            JobInfo.Builder builder = new JobInfo.Builder(i, new ComponentName(context, JobScheduleManager.class));
            if (i == 100) {
                builder.setMinimumLatency(f1604a);
                builder.setOverrideDeadline(f1605b);
            } else if (i == 101) {
                builder.setMinimumLatency(f1606c);
                builder.setOverrideDeadline(d);
            }
            builder.setPersisted(true);
            builder.setRequiresCharging(false);
            builder.setRequiresDeviceIdle(false);
            builder.setRequiredNetworkType(1);
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setRequiresStorageNotLow(false);
                builder.setRequiresBatteryNotLow(false);
            }
            LogUtil.a("schedule job id : " + i + " ;schedule status : " + jobScheduler.schedule(builder.build()));
        }
    }
}
