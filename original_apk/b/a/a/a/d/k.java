package b.a.a.a.d;

import com.google.android.gms.common.internal.C0178t;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class k {

    private static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final CountDownLatch f1427a;

        private a() {
            this.f1427a = new CountDownLatch(1);
        }

        public final void a(Object obj) {
            this.f1427a.countDown();
        }

        public final void b() throws InterruptedException {
            this.f1427a.await();
        }

        public final void a(Exception exc) {
            this.f1427a.countDown();
        }

        /* synthetic */ a(D d) {
            this();
        }

        public final void a() {
            this.f1427a.countDown();
        }

        public final boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f1427a.await(j, timeUnit);
        }
    }

    interface b extends C0149b, C0151d, e<Object> {
    }

    public static <TResult> h<TResult> a(TResult tresult) {
        C c2 = new C();
        c2.a(tresult);
        return c2;
    }

    private static <TResult> TResult b(h<TResult> hVar) throws ExecutionException {
        if (hVar.e()) {
            return hVar.b();
        }
        if (hVar.c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(hVar.a());
    }

    public static <TResult> h<TResult> a(Executor executor, Callable<TResult> callable) {
        C0178t.a(executor, (Object) "Executor must not be null");
        C0178t.a(callable, (Object) "Callback must not be null");
        C c2 = new C();
        executor.execute(new D(c2, callable));
        return c2;
    }

    public static <TResult> TResult a(h<TResult> hVar) throws ExecutionException, InterruptedException {
        C0178t.a();
        C0178t.a(hVar, (Object) "Task must not be null");
        if (hVar.d()) {
            return b(hVar);
        }
        a aVar = new a((D) null);
        a((h<?>) hVar, (b) aVar);
        aVar.b();
        return b(hVar);
    }

    public static <TResult> TResult a(h<TResult> hVar, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C0178t.a();
        C0178t.a(hVar, (Object) "Task must not be null");
        C0178t.a(timeUnit, (Object) "TimeUnit must not be null");
        if (hVar.d()) {
            return b(hVar);
        }
        a aVar = new a((D) null);
        a((h<?>) hVar, (b) aVar);
        if (aVar.a(j, timeUnit)) {
            return b(hVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    private static void a(h<?> hVar, b bVar) {
        hVar.a(j.f1425b, (e<? super Object>) bVar);
        hVar.a(j.f1425b, (C0151d) bVar);
        hVar.a(j.f1425b, (C0149b) bVar);
    }
}
