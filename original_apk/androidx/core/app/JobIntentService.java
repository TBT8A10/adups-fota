package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static final Object f531a = new Object();

    /* renamed from: b  reason: collision with root package name */
    static final HashMap<ComponentName, h> f532b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    b f533c;
    h d;
    a e;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    final ArrayList<d> i;

    interface b {
        IBinder a();

        e b();
    }

    final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        final Intent f535a;

        /* renamed from: b  reason: collision with root package name */
        final int f536b;

        d(Intent intent, int i) {
            this.f535a = intent;
            this.f536b = i;
        }

        public void a() {
            JobIntentService.this.stopSelf(this.f536b);
        }

        public Intent getIntent() {
            return this.f535a;
        }
    }

    interface e {
        void a();

        Intent getIntent();
    }

    static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        final JobIntentService f538a;

        /* renamed from: b  reason: collision with root package name */
        final Object f539b = new Object();

        /* renamed from: c  reason: collision with root package name */
        JobParameters f540c;

        final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            final JobWorkItem f541a;

            a(JobWorkItem jobWorkItem) {
                this.f541a = jobWorkItem;
            }

            public void a() {
                synchronized (f.this.f539b) {
                    if (f.this.f540c != null) {
                        f.this.f540c.completeWork(this.f541a);
                    }
                }
            }

            public Intent getIntent() {
                return this.f541a.getIntent();
            }
        }

        f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f538a = jobIntentService;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f538a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            return new androidx.core.app.JobIntentService.f.a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r1 == null) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.e b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f539b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f540c     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000a:
                android.app.job.JobParameters r1 = r3.f540c     // Catch:{ all -> 0x0027 }
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0026
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f538a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$f$a r0 = new androidx.core.app.JobIntentService$f$a
                r0.<init>(r1)
                return r0
            L_0x0026:
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.f.b():androidx.core.app.JobIntentService$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f540c = jobParameters;
            this.f538a.a(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b2 = this.f538a.b();
            synchronized (this.f539b) {
                this.f540c = null;
            }
            return b2;
        }
    }

    static final class g extends h {
        private final JobInfo d;
        private final JobScheduler e;

        g(Context context, ComponentName componentName, int i) {
            super(context, componentName);
            a(i);
            this.d = new JobInfo.Builder(i, this.f543a).setOverrideDeadline(0).build();
            this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            this.e.enqueue(this.d, new JobWorkItem(intent));
        }
    }

    static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f543a;

        /* renamed from: b  reason: collision with root package name */
        boolean f544b;

        /* renamed from: c  reason: collision with root package name */
        int f545c;

        h(Context context, ComponentName componentName) {
            this.f543a = componentName;
        }

        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (!this.f544b) {
                this.f544b = true;
                this.f545c = i;
            } else if (this.f545c != i) {
                throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.f545c);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void a(Intent intent);

        public void b() {
        }

        public void c() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.i = null;
        } else {
            this.i = new ArrayList<>();
        }
    }

    public static void a(Context context, Class cls, int i2, Intent intent) {
        a(context, new ComponentName(context, cls), i2, intent);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Intent intent);

    /* access modifiers changed from: package-private */
    public boolean b() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel(this.f);
        }
        this.g = true;
        return c();
    }

    public boolean c() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ArrayList<d> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.e = null;
                if (this.i != null && this.i.size() > 0) {
                    a(false);
                } else if (!this.h) {
                    this.d.a();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        b bVar = this.f533c;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f533c = new f(this);
            this.d = null;
            return;
        }
        this.f533c = null;
        this.d = a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.i;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.h = true;
                this.d.a();
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.i == null) {
            return 2;
        }
        this.d.c();
        synchronized (this.i) {
            ArrayList<d> arrayList = this.i;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            a(true);
        }
        return 3;
    }

    public static void a(Context context, ComponentName componentName, int i2, Intent intent) {
        if (intent != null) {
            synchronized (f531a) {
                h a2 = a(context, componentName, true, i2);
                a2.a(i2);
                a2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    final class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a2 = JobIntentService.this.a();
                if (a2 == null) {
                    return null;
                }
                JobIntentService.this.a(a2.getIntent());
                a2.a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.d();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onCancelled(Void voidR) {
            JobIntentService.this.d();
        }
    }

    static h a(Context context, ComponentName componentName, boolean z, int i2) {
        h hVar;
        h hVar2 = f532b.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z) {
            hVar = new g(context, componentName, i2);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        f532b.put(componentName, hVar3);
        return hVar3;
    }

    static final class c extends h {
        private final Context d;
        private final PowerManager.WakeLock e;
        private final PowerManager.WakeLock f;
        boolean g;
        boolean h;

        c(Context context, ComponentName componentName) {
            super(context, componentName);
            this.d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            this.e = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.e.setReferenceCounted(false);
            this.f = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f.setReferenceCounted(false);
        }

        /* access modifiers changed from: package-private */
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f543a);
            if (this.d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.g) {
                        this.g = true;
                        if (!this.h) {
                            this.e.acquire(60000);
                        }
                    }
                }
            }
        }

        public void b() {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.f.acquire(600000);
                    this.e.release();
                }
            }
        }

        public void c() {
            synchronized (this) {
                this.g = false;
            }
        }

        public void a() {
            synchronized (this) {
                if (this.h) {
                    if (this.g) {
                        this.e.acquire(60000);
                    }
                    this.h = false;
                    this.f.release();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.e == null) {
            this.e = new a();
            h hVar = this.d;
            if (hVar != null && z) {
                hVar.b();
            }
            this.e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public e a() {
        b bVar = this.f533c;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.i) {
            if (this.i.size() <= 0) {
                return null;
            }
            e remove = this.i.remove(0);
            return remove;
        }
    }
}
