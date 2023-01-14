package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f2501a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f2502b;

    /* renamed from: c  reason: collision with root package name */
    private int f2503c;
    private boolean d;

    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.a(source), inflater);
    }

    private void c() throws IOException {
        int i = this.f2503c;
        if (i != 0) {
            int remaining = i - this.f2502b.getRemaining();
            this.f2503c -= remaining;
            this.f2501a.skip((long) remaining);
        }
    }

    public boolean b() throws IOException {
        if (!this.f2502b.needsInput()) {
            return false;
        }
        c();
        if (this.f2502b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f2501a.g()) {
            return true;
        } else {
            Segment segment = this.f2501a.a().f2487b;
            int i = segment.f2520c;
            int i2 = segment.f2519b;
            this.f2503c = i - i2;
            this.f2502b.setInput(segment.f2518a, i2, this.f2503c);
            return false;
        }
    }

    public void close() throws IOException {
        if (!this.d) {
            this.f2502b.end();
            this.d = true;
            this.f2501a.close();
        }
    }

    public long read(Buffer buffer, long j) throws IOException {
        Segment c2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean b2 = b();
                try {
                    c2 = buffer.c(1);
                    int inflate = this.f2502b.inflate(c2.f2518a, c2.f2520c, 2048 - c2.f2520c);
                    if (inflate > 0) {
                        c2.f2520c += inflate;
                        long j2 = (long) inflate;
                        buffer.f2488c += j2;
                        return j2;
                    } else if (this.f2502b.finished()) {
                        break;
                    } else if (this.f2502b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            c();
            if (c2.f2519b != c2.f2520c) {
                return -1;
            }
            buffer.f2487b = c2.b();
            SegmentPool.a(c2);
            return -1;
        }
    }

    public Timeout timeout() {
        return this.f2501a.timeout();
    }

    InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f2501a = bufferedSource;
            this.f2502b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }
}
