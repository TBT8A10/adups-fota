package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f2495a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f2496b;

    /* renamed from: c  reason: collision with root package name */
    private final DeflaterSink f2497c;
    private boolean d;
    private final CRC32 e;

    private void a(Buffer buffer, long j) {
        Segment segment = buffer.f2487b;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (segment.f2520c - segment.f2519b));
            this.e.update(segment.f2518a, segment.f2519b, min);
            j -= (long) min;
            segment = segment.f;
        }
    }

    private void d() throws IOException {
        this.f2495a.a((int) this.e.getValue());
        this.f2495a.a(this.f2496b.getTotalIn());
    }

    public void close() throws IOException {
        if (!this.d) {
            try {
                this.f2497c.d();
                d();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f2496b.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f2495a.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.d = true;
            if (th != null) {
                Util.a(th);
                throw null;
            }
        }
    }

    public void flush() throws IOException {
        this.f2497c.flush();
    }

    public Timeout timeout() {
        return this.f2495a.timeout();
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            a(buffer, j);
            this.f2497c.write(buffer, j);
        }
    }
}
