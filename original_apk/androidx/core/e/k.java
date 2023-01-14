package androidx.core.e;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Callable;

/* compiled from: SelfDestructiveThread */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final Object f625a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f626b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f627c;
    private int d;
    private Handler.Callback e = new g(this);
    private final int f;
    private final int g;
    private final String h;

    /* compiled from: SelfDestructiveThread */
    public interface a<T> {
        void a(T t);
    }

    public k(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
        this.d = 0;
    }

    private void b(Runnable runnable) {
        synchronized (this.f625a) {
            if (this.f626b == null) {
                this.f626b = new HandlerThread(this.h, this.g);
                this.f626b.start();
                this.f627c = new Handler(this.f626b.getLooper(), this.e);
                this.d++;
            }
            this.f627c.removeMessages(0);
            this.f627c.sendMessage(this.f627c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(Callable<T> callable, a<T> aVar) {
        b(new i(this, callable, new Handler(), aVar));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T a(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.e.j r11 = new androidx.core.e.j
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r12.b(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x005c }
            if (r13 != 0) goto L_0x0034
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x0034:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x005c }
            long r0 = (long) r14     // Catch:{ all -> 0x005c }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x005c }
        L_0x003b:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x003f }
        L_0x003f:
            boolean r0 = r10.get()     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x004d
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x005c }
            r7.unlock()
            return r13
        L_0x004d:
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0054
            goto L_0x003b
        L_0x0054:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x005c }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x005c }
            throw r13     // Catch:{ all -> 0x005c }
        L_0x005c:
            r13 = move-exception
            r7.unlock()
            goto L_0x0062
        L_0x0061:
            throw r13
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.k.a(java.util.concurrent.Callable, int):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f625a) {
            this.f627c.removeMessages(0);
            this.f627c.sendMessageDelayed(this.f627c.obtainMessage(0), (long) this.f);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        synchronized (this.f625a) {
            if (!this.f627c.hasMessages(1)) {
                this.f626b.quit();
                this.f626b = null;
                this.f627c = null;
            }
        }
    }
}
