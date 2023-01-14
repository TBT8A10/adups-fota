package a.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DefaultTaskExecutor */
public class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f5a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f6b = Executors.newFixedThreadPool(2, new d(this));

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f7c;

    public void a(Runnable runnable) {
        this.f6b.execute(runnable);
    }

    public void b(Runnable runnable) {
        if (this.f7c == null) {
            synchronized (this.f5a) {
                if (this.f7c == null) {
                    this.f7c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f7c.post(runnable);
    }

    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
