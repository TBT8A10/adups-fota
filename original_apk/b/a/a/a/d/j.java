package b.a.a.a.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f1424a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final Executor f1425b = new B();

    private static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f1426a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.f1426a.post(runnable);
        }
    }
}
