package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;

final class RealBufferedSink implements BufferedSink {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f2510a;

    /* renamed from: b  reason: collision with root package name */
    public final Sink f2511b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f2512c;

    public RealBufferedSink(Sink sink, Buffer buffer) {
        if (sink != null) {
            this.f2510a = buffer;
            this.f2511b = sink;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public BufferedSink b(long j) throws IOException {
        if (!this.f2512c) {
            this.f2510a.b(j);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink c() throws IOException {
        if (!this.f2512c) {
            long m = this.f2510a.m();
            if (m > 0) {
                this.f2511b.write(this.f2510a, m);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void close() throws IOException {
        if (!this.f2512c) {
            try {
                if (this.f2510a.f2488c > 0) {
                    this.f2511b.write(this.f2510a, this.f2510a.f2488c);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f2511b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f2512c = true;
            if (th != null) {
                Util.a(th);
                throw null;
            }
        }
    }

    public void flush() throws IOException {
        if (!this.f2512c) {
            Buffer buffer = this.f2510a;
            long j = buffer.f2488c;
            if (j > 0) {
                this.f2511b.write(buffer, j);
            }
            this.f2511b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.f2511b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f2511b + ")";
    }

    public void write(Buffer buffer, long j) throws IOException {
        if (!this.f2512c) {
            this.f2510a.write(buffer, j);
            c();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeByte(int i) throws IOException {
        if (!this.f2512c) {
            this.f2510a.writeByte(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeInt(int i) throws IOException {
        if (!this.f2512c) {
            this.f2510a.writeInt(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink writeShort(int i) throws IOException {
        if (!this.f2512c) {
            this.f2510a.writeShort(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public Buffer a() {
        return this.f2510a;
    }

    public BufferedSink a(ByteString byteString) throws IOException {
        if (!this.f2512c) {
            this.f2510a.a(byteString);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    /* renamed from: okio.RealBufferedSink$1  reason: invalid class name */
    class AnonymousClass1 extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RealBufferedSink f2513a;

        public void close() throws IOException {
            this.f2513a.close();
        }

        public void flush() throws IOException {
            if (!this.f2513a.f2512c) {
                this.f2513a.flush();
            }
        }

        public String toString() {
            return this.f2513a + ".outputStream()";
        }

        public void write(int i) throws IOException {
            if (!this.f2513a.f2512c) {
                this.f2513a.f2510a.writeByte((int) (byte) i);
                this.f2513a.c();
                return;
            }
            throw new IOException("closed");
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (!this.f2513a.f2512c) {
                this.f2513a.f2510a.write(bArr, i, i2);
                this.f2513a.c();
                return;
            }
            throw new IOException("closed");
        }
    }

    public RealBufferedSink(Sink sink) {
        this(sink, new Buffer());
    }

    public BufferedSink b() throws IOException {
        if (!this.f2512c) {
            long p = this.f2510a.p();
            if (p > 0) {
                this.f2511b.write(this.f2510a, p);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr) throws IOException {
        if (!this.f2512c) {
            this.f2510a.write(bArr);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink a(String str) throws IOException {
        if (!this.f2512c) {
            this.f2510a.a(str);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f2512c) {
            this.f2510a.write(bArr, i, i2);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public long a(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this.f2510a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
                if (read == -1) {
                    return j;
                }
                j += read;
                c();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public BufferedSink a(int i) throws IOException {
        if (!this.f2512c) {
            this.f2510a.a(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public BufferedSink a(long j) throws IOException {
        if (!this.f2512c) {
            this.f2510a.a(j);
            return c();
        }
        throw new IllegalStateException("closed");
    }
}
