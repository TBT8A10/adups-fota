package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ForwardingTimeout extends Timeout {

    /* renamed from: a  reason: collision with root package name */
    private Timeout f2494a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.f2494a = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final Timeout a() {
        return this.f2494a;
    }

    public Timeout clearDeadline() {
        return this.f2494a.clearDeadline();
    }

    public Timeout clearTimeout() {
        return this.f2494a.clearTimeout();
    }

    public long deadlineNanoTime() {
        return this.f2494a.deadlineNanoTime();
    }

    public boolean hasDeadline() {
        return this.f2494a.hasDeadline();
    }

    public void throwIfReached() throws IOException {
        this.f2494a.throwIfReached();
    }

    public Timeout timeout(long j, TimeUnit timeUnit) {
        return this.f2494a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.f2494a.timeoutNanos();
    }

    public final ForwardingTimeout a(Timeout timeout) {
        if (timeout != null) {
            this.f2494a = timeout;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public Timeout deadlineNanoTime(long j) {
        return this.f2494a.deadlineNanoTime(j);
    }
}
