package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(Buffer buffer, int i) {
        super((byte[]) null);
        Util.a(buffer.f2488c, 0, (long) i);
        int i2 = 0;
        Segment segment = buffer.f2487b;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = segment.f2520c;
            int i6 = segment.f2519b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i4][];
        this.directory = new int[(i4 * 2)];
        Segment segment2 = buffer.f2487b;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.segments;
            bArr[i7] = segment2.f2518a;
            int i8 = segment2.f2520c;
            int i9 = segment2.f2519b;
            i2 += i8 - i9;
            int[] iArr = this.directory;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            segment2.d = true;
            i7++;
            segment2 = segment2.f;
        }
    }

    private int a(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private Object writeReplace() {
        return a();
    }

    public String base64() {
        return a().base64();
    }

    public String base64Url() {
        return a().base64Url();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() != size() || !rangeEquals(0, byteString, 0, size())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte getByte(int i) {
        int i2;
        Util.a((long) this.directory[this.segments.length - 1], (long) i, 1);
        int a2 = a(i);
        if (a2 == 0) {
            i2 = 0;
        } else {
            i2 = this.directory[a2 - 1];
        }
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[a2][(i - i2) + iArr[bArr.length + a2]];
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    public String hex() {
        return a().hex();
    }

    public ByteString md5() {
        return a().md5();
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        int i4;
        if (i > size() - i3) {
            return false;
        }
        int a2 = a(i);
        while (i3 > 0) {
            if (a2 == 0) {
                i4 = 0;
            } else {
                i4 = this.directory[a2 - 1];
            }
            int min = Math.min(i3, ((this.directory[a2] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[a2], (i - i4) + iArr[bArr.length + a2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a2++;
        }
        return true;
    }

    public ByteString sha256() {
        return a().sha256();
    }

    public int size() {
        return this.directory[this.segments.length - 1];
    }

    public ByteString substring(int i) {
        return a().substring(i);
    }

    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public String toString() {
        return a().toString();
    }

    public String utf8() {
        return a().utf8();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            int length = this.segments.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.directory;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                outputStream.write(this.segments[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    private ByteString a() {
        return new ByteString(toByteArray());
    }

    public ByteString substring(int i, int i2) {
        return a().substring(i, i2);
    }

    /* access modifiers changed from: package-private */
    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.segments[i], i3, (i3 + i4) - i2);
            Segment segment2 = buffer.f2487b;
            if (segment2 == null) {
                segment.g = segment;
                segment.f = segment;
                buffer.f2487b = segment;
            } else {
                segment2.g.a(segment);
            }
            i++;
            i2 = i4;
        }
        buffer.f2488c += (long) i2;
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if (i > size() - i3 || i2 > bArr.length - i3) {
            return false;
        }
        int a2 = a(i);
        while (i3 > 0) {
            if (a2 == 0) {
                i4 = 0;
            } else {
                i4 = this.directory[a2 - 1];
            }
            int min = Math.min(i3, ((this.directory[a2] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.a(bArr2[a2], (i - i4) + iArr[bArr2.length + a2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            a2++;
        }
        return true;
    }
}
