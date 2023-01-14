package b.a.a.a.b.b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final class k extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f1397a;

    /* renamed from: b  reason: collision with root package name */
    private long f1398b = -1;

    k(InputStream inputStream, long j) {
        super(inputStream);
        g.a(inputStream);
        this.f1397a = 1048577;
    }

    public final int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.f1397a);
    }

    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.f1398b = this.f1397a;
    }

    public final int read() throws IOException {
        if (this.f1397a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f1397a--;
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f1398b != -1) {
            this.in.reset();
            this.f1397a = this.f1398b;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.f1397a));
        this.f1397a -= skip;
        return skip;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f1397a;
        if (j == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f1397a -= (long) read;
        }
        return read;
    }
}
