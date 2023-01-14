package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {

    /* renamed from: a  reason: collision with root package name */
    private int f2498a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final BufferedSource f2499b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f2500c;
    private final InflaterSource d;
    private final CRC32 e = new CRC32();

    public GzipSource(Source source) {
        if (source != null) {
            this.f2500c = new Inflater(true);
            this.f2499b = Okio.a(source);
            this.d = new InflaterSource(this.f2499b, this.f2500c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void a(Buffer buffer, long j, long j2) {
        Segment segment = buffer.f2487b;
        while (true) {
            int i = segment.f2520c;
            int i2 = segment.f2519b;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.f;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) segment.f2519b) + j);
            int min = (int) Math.min((long) (segment.f2520c - i3), j2);
            this.e.update(segment.f2518a, i3, min);
            j2 -= (long) min;
            segment = segment.f;
            j = 0;
        }
    }

    private void b() throws IOException {
        this.f2499b.d(10);
        byte f = this.f2499b.a().f(3);
        boolean z = ((f >> 1) & 1) == 1;
        if (z) {
            a(this.f2499b.a(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.f2499b.readShort());
        this.f2499b.skip(8);
        if (((f >> 2) & 1) == 1) {
            this.f2499b.d(2);
            if (z) {
                a(this.f2499b.a(), 0, 2);
            }
            long e2 = (long) this.f2499b.a().e();
            this.f2499b.d(e2);
            if (z) {
                a(this.f2499b.a(), 0, e2);
            }
            this.f2499b.skip(e2);
        }
        if (((f >> 3) & 1) == 1) {
            long a2 = this.f2499b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f2499b.a(), 0, a2 + 1);
                }
                this.f2499b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((f >> 4) & 1) == 1) {
            long a3 = this.f2499b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f2499b.a(), 0, a3 + 1);
                }
                this.f2499b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", (int) this.f2499b.e(), (int) (short) ((int) this.e.getValue()));
            this.e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.f2499b.i(), (int) this.e.getValue());
        a("ISIZE", this.f2499b.i(), this.f2500c.getTotalOut());
    }

    public void close() throws IOException {
        this.d.close();
    }

    public long read(Buffer buffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f2498a == 0) {
                b();
                this.f2498a = 1;
            }
            if (this.f2498a == 1) {
                long j2 = buffer.f2488c;
                long read = this.d.read(buffer, j);
                if (read != -1) {
                    a(buffer, j2, read);
                    return read;
                }
                this.f2498a = 2;
            }
            if (this.f2498a == 2) {
                c();
                this.f2498a = 3;
                if (!this.f2499b.g()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.f2499b.timeout();
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
