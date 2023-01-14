package okio;

import java.io.IOException;
import java.util.zip.Deflater;

public final class DeflaterSink implements Sink {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSink f2491a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f2492b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2493c;

    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.a(sink), deflater);
    }

    private void a(boolean z) throws IOException {
        Segment c2;
        int i;
        Buffer a2 = this.f2491a.a();
        while (true) {
            c2 = a2.c(1);
            if (z) {
                Deflater deflater = this.f2492b;
                byte[] bArr = c2.f2518a;
                int i2 = c2.f2520c;
                i = deflater.deflate(bArr, i2, 2048 - i2, 2);
            } else {
                Deflater deflater2 = this.f2492b;
                byte[] bArr2 = c2.f2518a;
                int i3 = c2.f2520c;
                i = deflater2.deflate(bArr2, i3, 2048 - i3);
            }
            if (i > 0) {
                c2.f2520c += i;
                a2.f2488c += (long) i;
                this.f2491a.c();
            } else if (this.f2492b.needsInput()) {
                break;
            }
        }
        if (c2.f2519b == c2.f2520c) {
            a2.f2487b = c2.b();
            SegmentPool.a(c2);
        }
    }

    public void close() throws IOException {
        if (!this.f2493c) {
            try {
                d();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f2492b.end();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            try {
                this.f2491a.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f2493c = true;
            if (th != null) {
                Util.a(th);
                throw null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() throws IOException {
        this.f2492b.finish();
        a(false);
    }

    public void flush() throws IOException {
        a(true);
        this.f2491a.flush();
    }

    public Timeout timeout() {
        return this.f2491a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f2491a + ")";
    }

    public void write(Buffer buffer, long j) throws IOException {
        Util.a(buffer.f2488c, 0, j);
        while (j > 0) {
            Segment segment = buffer.f2487b;
            int min = (int) Math.min(j, (long) (segment.f2520c - segment.f2519b));
            this.f2492b.setInput(segment.f2518a, segment.f2519b, min);
            a(false);
            long j2 = (long) min;
            buffer.f2488c -= j2;
            segment.f2519b += min;
            if (segment.f2519b == segment.f2520c) {
                buffer.f2487b = segment.b();
                SegmentPool.a(segment);
            }
            j -= j2;
        }
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f2491a = bufferedSink;
            this.f2492b = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
