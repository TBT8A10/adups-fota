package okio;

final class Segment {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f2518a;

    /* renamed from: b  reason: collision with root package name */
    int f2519b;

    /* renamed from: c  reason: collision with root package name */
    int f2520c;
    boolean d;
    boolean e;
    Segment f;
    Segment g;

    Segment() {
        this.f2518a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    public Segment a(Segment segment) {
        segment.g = this;
        segment.f = this.f;
        this.f.g = segment;
        this.f = segment;
        return segment;
    }

    public Segment b() {
        Segment segment = this.f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.g;
        segment2.f = this.f;
        this.f.g = segment2;
        this.f = null;
        this.g = null;
        return segment;
    }

    Segment(Segment segment) {
        this(segment.f2518a, segment.f2519b, segment.f2520c);
        segment.d = true;
    }

    public Segment a(int i) {
        if (i <= 0 || i > this.f2520c - this.f2519b) {
            throw new IllegalArgumentException();
        }
        Segment segment = new Segment(this);
        segment.f2520c = segment.f2519b + i;
        this.f2519b += i;
        this.g.a(segment);
        return segment;
    }

    Segment(byte[] bArr, int i, int i2) {
        this.f2518a = bArr;
        this.f2519b = i;
        this.f2520c = i2;
        this.e = false;
        this.d = true;
    }

    public void a() {
        Segment segment = this.g;
        if (segment == this) {
            throw new IllegalStateException();
        } else if (segment.e) {
            int i = this.f2520c - this.f2519b;
            if (i <= (2048 - segment.f2520c) + (segment.d ? 0 : segment.f2519b)) {
                a(this.g, i);
                b();
                SegmentPool.a(this);
            }
        }
    }

    public void a(Segment segment, int i) {
        if (segment.e) {
            int i2 = segment.f2520c;
            if (i2 + i > 2048) {
                if (!segment.d) {
                    int i3 = segment.f2519b;
                    if ((i2 + i) - i3 <= 2048) {
                        byte[] bArr = segment.f2518a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        segment.f2520c -= segment.f2519b;
                        segment.f2519b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f2518a, this.f2519b, segment.f2518a, segment.f2520c, i);
            segment.f2520c += i;
            this.f2519b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
