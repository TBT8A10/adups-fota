package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f2486a = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b  reason: collision with root package name */
    Segment f2487b;

    /* renamed from: c  reason: collision with root package name */
    long f2488c;

    /* renamed from: okio.Buffer$1  reason: invalid class name */
    class AnonymousClass1 extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Buffer f2489a;

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return this + ".outputStream()";
        }

        public void write(int i) {
            this.f2489a.writeByte((int) (byte) i);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f2489a.write(bArr, i, i2);
        }
    }

    public Buffer a() {
        return this;
    }

    public BufferedSink b() {
        return this;
    }

    public Buffer c() {
        return this;
    }

    public void close() {
    }

    public void d(long j) throws EOFException {
        if (this.f2488c < j) {
            throw new EOFException();
        }
    }

    public short e() {
        return Util.a(readShort());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.f2488c;
        if (j != buffer.f2488c) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.f2487b;
        Segment segment2 = buffer.f2487b;
        int i = segment.f2519b;
        int i2 = segment2.f2519b;
        while (j2 < this.f2488c) {
            long min = (long) Math.min(segment.f2520c - i, segment2.f2520c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (segment.f2518a[i4] != segment2.f2518a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == segment.f2520c) {
                segment = segment.f;
                i = segment.f2519b;
            } else {
                i = i4;
            }
            if (i3 == segment2.f2520c) {
                segment2 = segment2.f;
                i2 = segment2.f2519b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public byte f(long j) {
        Util.a(this.f2488c, j, 1);
        Segment segment = this.f2487b;
        while (true) {
            int i = segment.f2520c;
            int i2 = segment.f2519b;
            long j2 = (long) (i - i2);
            if (j < j2) {
                return segment.f2518a[i2 + ((int) j)];
            }
            j -= j2;
            segment = segment.f;
        }
    }

    public void flush() {
    }

    public boolean g() {
        return this.f2488c == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r5 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.o());
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009a A[EDGE_INSN: B:48:0x009a->B:30:0x009a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long h() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f2488c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b9
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0010:
            okio.Segment r10 = r0.f2487b
            byte[] r11 = r10.f2518a
            int r12 = r10.f2519b
            int r13 = r10.f2520c
        L_0x0018:
            if (r12 >= r13) goto L_0x009a
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006c
            r1 = 57
            if (r15 > r1) goto L_0x006c
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L_0x0038
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0076
        L_0x003f:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.a((long) r3)
            okio.Buffer r1 = r1.writeByte((int) r15)
            if (r5 != 0) goto L_0x0051
            r1.readByte()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.o()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r1 = 45
            if (r15 != r1) goto L_0x007b
            if (r7 != 0) goto L_0x007b
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L_0x0076:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L_0x0018
        L_0x007b:
            if (r7 == 0) goto L_0x007f
            r6 = 1
            goto L_0x009a
        L_0x007f:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009a:
            if (r12 != r13) goto L_0x00a6
            okio.Segment r1 = r10.b()
            r0.f2487b = r1
            okio.SegmentPool.a(r10)
            goto L_0x00a8
        L_0x00a6:
            r10.f2519b = r12
        L_0x00a8:
            if (r6 != 0) goto L_0x00ae
            okio.Segment r1 = r0.f2487b
            if (r1 != 0) goto L_0x0010
        L_0x00ae:
            long r1 = r0.f2488c
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.f2488c = r1
            if (r5 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            long r3 = -r3
        L_0x00b8:
            return r3
        L_0x00b9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00c2
        L_0x00c1:
            throw r1
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.h():long");
    }

    public int hashCode() {
        Segment segment = this.f2487b;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.f2520c;
            for (int i3 = segment.f2519b; i3 < i2; i3++) {
                i = (i * 31) + segment.f2518a[i3];
            }
            segment = segment.f;
        } while (segment != this.f2487b);
        return i;
    }

    public int i() {
        return Util.a(readInt());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.f2487b = r6.b();
        okio.SegmentPool.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f2519b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r0 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long j() {
        /*
            r15 = this;
            long r0 = r15.f2488c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            okio.Segment r6 = r15.f2487b
            byte[] r7 = r6.f2518a
            int r8 = r6.f2519b
            int r9 = r6.f2520c
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L_0x0013
        L_0x004a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.b((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.o()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r1 == 0) goto L_0x0076
            r0 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            okio.Segment r7 = r6.b()
            r15.f2487b = r7
            okio.SegmentPool.a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f2519b = r8
        L_0x009f:
            if (r0 != 0) goto L_0x00a5
            okio.Segment r6 = r15.f2487b
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r2 = r15.f2488c
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f2488c = r2
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.j():long");
    }

    public InputStream k() {
        return new InputStream() {
            public int available() {
                return (int) Math.min(Buffer.this.f2488c, 2147483647L);
            }

            public void close() {
            }

            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.f2488c > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.a(bArr, i, i2);
            }
        };
    }

    public void l() {
        try {
            skip(this.f2488c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public long m() {
        long j = this.f2488c;
        if (j == 0) {
            return 0;
        }
        Segment segment = this.f2487b.g;
        int i = segment.f2520c;
        return (i >= 2048 || !segment.e) ? j : j - ((long) (i - segment.f2519b));
    }

    public ByteString n() {
        return new ByteString(f());
    }

    public String o() {
        try {
            return a(this.f2488c, Util.f2523a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public long p() {
        return this.f2488c;
    }

    public ByteString q() {
        long j = this.f2488c;
        if (j <= 2147483647L) {
            return b((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f2488c);
    }

    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f2488c;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public byte readByte() {
        long j = this.f2488c;
        if (j != 0) {
            Segment segment = this.f2487b;
            int i = segment.f2519b;
            int i2 = segment.f2520c;
            int i3 = i + 1;
            byte b2 = segment.f2518a[i];
            this.f2488c = j - 1;
            if (i3 == i2) {
                this.f2487b = segment.b();
                SegmentPool.a(segment);
            } else {
                segment.f2519b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public int readInt() {
        long j = this.f2488c;
        if (j >= 4) {
            Segment segment = this.f2487b;
            int i = segment.f2519b;
            int i2 = segment.f2520c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f2518a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            this.f2488c = j - 4;
            if (i6 == i2) {
                this.f2487b = segment.b();
                SegmentPool.a(segment);
            } else {
                segment.f2519b = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.f2488c);
    }

    public short readShort() {
        long j = this.f2488c;
        if (j >= 2) {
            Segment segment = this.f2487b;
            int i = segment.f2519b;
            int i2 = segment.f2520c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f2518a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f2488c = j - 2;
            if (i4 == i2) {
                this.f2487b = segment.b();
                SegmentPool.a(segment);
            } else {
                segment.f2519b = i4;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.f2488c);
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.f2487b;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.f2520c - segment.f2519b));
                long j2 = (long) min;
                this.f2488c -= j2;
                j -= j2;
                Segment segment2 = this.f2487b;
                segment2.f2519b += min;
                if (segment2.f2519b == segment2.f2520c) {
                    this.f2487b = segment2.b();
                    SegmentPool.a(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        long j = this.f2488c;
        if (j == 0) {
            return "Buffer[size=0]";
        }
        if (j <= 16) {
            return String.format("Buffer[size=%s data=%s]", new Object[]{Long.valueOf(this.f2488c), clone().n().hex()});
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(this.f2487b.f2518a, this.f2487b.f2519b, this.f2487b.f2520c - this.f2487b.f2519b);
            Segment segment = this.f2487b;
            while (true) {
                segment = segment.f;
                if (segment != this.f2487b) {
                    instance.update(segment.f2518a, segment.f2519b, segment.f2520c - segment.f2519b);
                } else {
                    return String.format("Buffer[size=%s md5=%s]", new Object[]{Long.valueOf(this.f2488c), ByteString.of(instance.digest()).hex()});
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public Buffer b(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment c2 = c(numberOfTrailingZeros);
        byte[] bArr = c2.f2518a;
        int i = c2.f2520c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f2486a[(int) (15 & j)];
            j >>>= 4;
        }
        c2.f2520c += numberOfTrailingZeros;
        this.f2488c += (long) numberOfTrailingZeros;
        return this;
    }

    public byte[] c(long j) throws EOFException {
        Util.a(this.f2488c, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f2488c == 0) {
            return buffer;
        }
        buffer.f2487b = new Segment(this.f2487b);
        Segment segment = buffer.f2487b;
        segment.g = segment;
        segment.f = segment;
        Segment segment2 = this.f2487b;
        while (true) {
            segment2 = segment2.f;
            if (segment2 != this.f2487b) {
                buffer.f2487b.g.a(new Segment(segment2));
            } else {
                buffer.f2488c = this.f2488c;
                return buffer;
            }
        }
    }

    public String d() throws EOFException {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return h(a2);
        }
        Buffer buffer = new Buffer();
        a(buffer, 0, Math.min(32, this.f2488c));
        throw new EOFException("\\n not found: size=" + p() + " content=" + buffer.n().hex() + "...");
    }

    public ByteString e(long j) throws EOFException {
        return new ByteString(c(j));
    }

    public String g(long j) throws EOFException {
        return a(j, Util.f2523a);
    }

    public Buffer writeByte(int i) {
        Segment c2 = c(1);
        byte[] bArr = c2.f2518a;
        int i2 = c2.f2520c;
        c2.f2520c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f2488c++;
        return this;
    }

    public Buffer writeInt(int i) {
        Segment c2 = c(4);
        byte[] bArr = c2.f2518a;
        int i2 = c2.f2520c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        c2.f2520c = i5 + 1;
        this.f2488c += 4;
        return this;
    }

    public Buffer writeShort(int i) {
        Segment c2 = c(2);
        byte[] bArr = c2.f2518a;
        int i2 = c2.f2520c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        c2.f2520c = i3 + 1;
        this.f2488c += 2;
        return this;
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer a(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.a(this.f2488c, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.f2488c += j2;
            Segment segment = this.f2487b;
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
                Segment segment2 = new Segment(segment);
                segment2.f2519b = (int) (((long) segment2.f2519b) + j);
                segment2.f2520c = Math.min(segment2.f2519b + ((int) j2), segment2.f2520c);
                Segment segment3 = buffer.f2487b;
                if (segment3 == null) {
                    segment2.g = segment2;
                    segment2.f = segment2;
                    buffer.f2487b = segment2;
                } else {
                    segment3.g.a(segment2);
                }
                j2 -= (long) (segment2.f2520c - segment2.f2519b);
                segment = segment.f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            Util.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment c2 = c(1);
                int min = Math.min(i3 - i, 2048 - c2.f2520c);
                System.arraycopy(bArr, i, c2.f2518a, c2.f2520c, min);
                i += min;
                c2.f2520c += min;
            }
            this.f2488c += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* access modifiers changed from: package-private */
    public Segment c(int i) {
        if (i < 1 || i > 2048) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.f2487b;
        if (segment == null) {
            this.f2487b = SegmentPool.a();
            Segment segment2 = this.f2487b;
            segment2.g = segment2;
            segment2.f = segment2;
            return segment2;
        }
        Segment segment3 = segment.g;
        return (segment3.f2520c + i > 2048 || !segment3.e) ? segment3.a(SegmentPool.a()) : segment3;
    }

    public byte[] f() {
        try {
            return c(this.f2488c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public Buffer d(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | CpioConstants.C_IWUSR);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | CpioConstants.C_IWUSR);
                writeByte((i & 63) | CpioConstants.C_IWUSR);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | CpioConstants.C_IWUSR);
            writeByte(((i >> 6) & 63) | CpioConstants.C_IWUSR);
            writeByte((i & 63) | CpioConstants.C_IWUSR);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public ByteString b(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i);
    }

    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            Util.a(buffer.f2488c, 0, j);
            while (j > 0) {
                Segment segment = buffer.f2487b;
                if (j < ((long) (segment.f2520c - segment.f2519b))) {
                    Segment segment2 = this.f2487b;
                    Segment segment3 = segment2 != null ? segment2.g : null;
                    if (segment3 != null && segment3.e) {
                        if ((((long) segment3.f2520c) + j) - ((long) (segment3.d ? 0 : segment3.f2519b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            buffer.f2487b.a(segment3, (int) j);
                            buffer.f2488c -= j;
                            this.f2488c += j;
                            return;
                        }
                    }
                    buffer.f2487b = buffer.f2487b.a((int) j);
                }
                Segment segment4 = buffer.f2487b;
                long j2 = (long) (segment4.f2520c - segment4.f2519b);
                buffer.f2487b = segment4.b();
                Segment segment5 = this.f2487b;
                if (segment5 == null) {
                    this.f2487b = segment4;
                    Segment segment6 = this.f2487b;
                    segment6.g = segment6;
                    segment6.f = segment6;
                } else {
                    segment5.g.a(segment4).a();
                }
                buffer.f2488c -= j2;
                this.f2488c += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        Util.a(this.f2488c, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            Segment segment = this.f2487b;
            int i = segment.f2519b;
            if (((long) i) + j > ((long) segment.f2520c)) {
                return new String(c(j), charset);
            }
            String str = new String(segment.f2518a, i, (int) j, charset);
            segment.f2519b = (int) (((long) segment.f2519b) + j);
            this.f2488c -= j;
            if (segment.f2519b == segment.f2520c) {
                this.f2487b = segment.b();
                SegmentPool.a(segment);
            }
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public String h(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (f(j2) == 13) {
                String g = g(j2);
                skip(2);
                return g;
            }
        }
        String g2 = g(j);
        skip(1);
        return g2;
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        Util.a((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.f2487b;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.f2520c - segment.f2519b);
        System.arraycopy(segment.f2518a, segment.f2519b, bArr, i, min);
        segment.f2519b += min;
        this.f2488c -= (long) min;
        if (segment.f2519b == segment.f2520c) {
            this.f2487b = segment.b();
            SegmentPool.a(segment);
        }
        return min;
    }

    public Buffer a(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer a(String str) {
        return a(str, 0, str.length());
    }

    public Buffer a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    Segment c2 = c(1);
                    byte[] bArr = c2.f2518a;
                    int i3 = c2.f2520c - i;
                    int min = Math.min(i2, 2048 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = c2.f2520c;
                    int i6 = (i3 + i4) - i5;
                    c2.f2520c = i5 + i6;
                    this.f2488c += (long) i6;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | CpioConstants.C_IWUSR);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | CpioConstants.C_IWUSR);
                            writeByte(((i8 >> 6) & 63) | CpioConstants.C_IWUSR);
                            writeByte((i8 & 63) | CpioConstants.C_IWUSR);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public Buffer a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public Buffer a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.f2523a)) {
            return a(str);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public long a(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public Buffer a(int i) {
        return writeInt(Util.a(i));
    }

    public Buffer a(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return a("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        Segment c2 = c(i);
        byte[] bArr = c2.f2518a;
        int i2 = c2.f2520c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f2486a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        c2.f2520c += i;
        this.f2488c += (long) i;
        return this;
    }

    public long a(byte b2) {
        return a(b2, 0);
    }

    public long a(byte b2, long j) {
        long j2;
        if (j >= 0) {
            Segment segment = this.f2487b;
            if (segment == null) {
                return -1;
            }
            long j3 = j;
            long j4 = 0;
            while (true) {
                int i = segment.f2520c;
                int i2 = segment.f2519b;
                long j5 = (long) (i - i2);
                if (j3 >= j5) {
                    j2 = j3 - j5;
                    byte b3 = b2;
                } else {
                    byte[] bArr = segment.f2518a;
                    for (int i3 = (int) (((long) i2) + j3); i3 < i; i3++) {
                        if (bArr[i3] == b2) {
                            return (j4 + ((long) i3)) - ((long) segment.f2519b);
                        }
                    }
                    byte b4 = b2;
                    j2 = 0;
                }
                j4 += j5;
                segment = segment.f;
                if (segment == this.f2487b) {
                    return -1;
                }
                j3 = j2;
            }
        } else {
            throw new IllegalArgumentException("fromIndex < 0");
        }
    }
}
