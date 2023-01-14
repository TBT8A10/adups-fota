package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper */
class M {

    /* renamed from: a  reason: collision with root package name */
    private int f355a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f356b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f357c = Integer.MIN_VALUE;
    private int d = Integer.MIN_VALUE;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    M() {
    }

    public int a() {
        return this.g ? this.f355a : this.f356b;
    }

    public int b() {
        return this.f355a;
    }

    public int c() {
        return this.f356b;
    }

    public int d() {
        return this.g ? this.f356b : this.f355a;
    }

    public void a(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.e = i;
            this.f355a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f356b = i2;
        }
    }

    public void b(int i, int i2) {
        this.f357c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f355a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f356b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f355a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f356b = i2;
        }
    }

    public void a(boolean z) {
        if (z != this.g) {
            this.g = z;
            if (!this.h) {
                this.f355a = this.e;
                this.f356b = this.f;
            } else if (z) {
                int i = this.d;
                if (i == Integer.MIN_VALUE) {
                    i = this.e;
                }
                this.f355a = i;
                int i2 = this.f357c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f;
                }
                this.f356b = i2;
            } else {
                int i3 = this.f357c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.e;
                }
                this.f355a = i3;
                int i4 = this.d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f;
                }
                this.f356b = i4;
            }
        }
    }
}
