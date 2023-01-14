package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class RealBufferedSource implements BufferedSource {

    /* renamed from: a  reason: collision with root package name */
    public final Buffer f2514a;

    /* renamed from: b  reason: collision with root package name */
    public final Source f2515b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f2516c;

    public RealBufferedSource(Source source, Buffer buffer) {
        if (source != null) {
            this.f2514a = buffer;
            this.f2515b = source;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] c(long j) throws IOException {
        d(j);
        return this.f2514a.c(j);
    }

    public void close() throws IOException {
        if (!this.f2516c) {
            this.f2516c = true;
            this.f2515b.close();
            this.f2514a.l();
        }
    }

    public void d(long j) throws IOException {
        if (!a(j)) {
            throw new EOFException();
        }
    }

    public ByteString e(long j) throws IOException {
        d(j);
        return this.f2514a.e(j);
    }

    public byte[] f() throws IOException {
        this.f2514a.a(this.f2515b);
        return this.f2514a.f();
    }

    public boolean g() throws IOException {
        if (!this.f2516c) {
            return this.f2514a.g() && this.f2515b.read(this.f2514a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long h() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.d(r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.a((long) r3)
            if (r3 == 0) goto L_0x0040
            okio.Buffer r3 = r6.f2514a
            long r4 = (long) r1
            byte r3 = r3.f(r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            okio.Buffer r0 = r6.f2514a
            long r0 = r0.h()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.h():long");
    }

    public int i() throws IOException {
        d(4);
        return this.f2514a.i();
    }

    public long j() throws IOException {
        d(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!a((long) i2)) {
                break;
            }
            byte f = this.f2514a.f((long) i);
            if ((f >= 48 && f <= 57) || ((f >= 97 && f <= 102) || (f >= 65 && f <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(f)}));
            }
        }
        return this.f2514a.j();
    }

    public InputStream k() {
        return new InputStream() {
            public int available() throws IOException {
                if (!RealBufferedSource.this.f2516c) {
                    return (int) Math.min(RealBufferedSource.this.f2514a.f2488c, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public int read() throws IOException {
                if (!RealBufferedSource.this.f2516c) {
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.f2514a;
                    if (buffer.f2488c == 0 && realBufferedSource.f2515b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.f2514a.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!RealBufferedSource.this.f2516c) {
                    Util.a((long) bArr.length, (long) i, (long) i2);
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.f2514a;
                    if (buffer.f2488c == 0 && realBufferedSource.f2515b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.f2514a.a(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    public long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f2516c) {
            Buffer buffer2 = this.f2514a;
            if (buffer2.f2488c == 0 && this.f2515b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                return -1;
            }
            return this.f2514a.read(buffer, Math.min(j, this.f2514a.f2488c));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte readByte() throws IOException {
        d(1);
        return this.f2514a.readByte();
    }

    public int readInt() throws IOException {
        d(4);
        return this.f2514a.readInt();
    }

    public short readShort() throws IOException {
        d(2);
        return this.f2514a.readShort();
    }

    public void skip(long j) throws IOException {
        if (!this.f2516c) {
            while (j > 0) {
                Buffer buffer = this.f2514a;
                if (buffer.f2488c == 0 && this.f2515b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f2514a.p());
                this.f2514a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.f2515b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f2515b + ")";
    }

    public Buffer a() {
        return this.f2514a;
    }

    public String d() throws IOException {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return this.f2514a.h(a2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.f2514a;
        buffer2.a(buffer, 0, Math.min(32, buffer2.p()));
        throw new EOFException("\\n not found: size=" + this.f2514a.p() + " content=" + buffer.n().hex() + "...");
    }

    public boolean a(long j) throws IOException {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f2516c) {
            do {
                buffer = this.f2514a;
                if (buffer.f2488c >= j) {
                    return true;
                }
            } while (this.f2515b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public short e() throws IOException {
        d(2);
        return this.f2514a.e();
    }

    public RealBufferedSource(Source source) {
        this(source, new Buffer());
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0);
    }

    public long a(byte b2, long j) throws IOException {
        Buffer buffer;
        if (!this.f2516c) {
            do {
                buffer = this.f2514a;
                if (j < buffer.f2488c) {
                    while (true) {
                        long a2 = this.f2514a.a(b2, j);
                        if (a2 != -1) {
                            return a2;
                        }
                        Buffer buffer2 = this.f2514a;
                        long j2 = buffer2.f2488c;
                        if (this.f2515b.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                            return -1;
                        }
                        j = j2;
                    }
                }
            } while (this.f2515b.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }
}
