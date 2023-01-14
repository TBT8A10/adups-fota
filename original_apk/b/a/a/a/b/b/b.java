package b.a.a.a.b.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public interface b {
    ExecutorService a(ThreadFactory threadFactory, int i);

    ScheduledExecutorService a(int i, ThreadFactory threadFactory, int i2);
}
