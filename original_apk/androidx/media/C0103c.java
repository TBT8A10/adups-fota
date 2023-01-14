package androidx.media;

import java.util.Arrays;

/* renamed from: androidx.media.c  reason: case insensitive filesystem */
/* compiled from: AudioAttributesImplBase */
class C0103c implements C0101a {

    /* renamed from: a  reason: collision with root package name */
    int f962a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f963b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f964c = 0;
    int d = -1;

    C0103c() {
    }

    public int a() {
        return this.f963b;
    }

    public int b() {
        int i = this.f964c;
        int c2 = c();
        if (c2 == 6) {
            i |= 4;
        } else if (c2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int c() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.a(false, this.f964c, this.f962a);
    }

    public int d() {
        return this.f962a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0103c)) {
            return false;
        }
        C0103c cVar = (C0103c) obj;
        if (this.f963b == cVar.a() && this.f964c == cVar.b() && this.f962a == cVar.d() && this.d == cVar.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f963b), Integer.valueOf(this.f964c), Integer.valueOf(this.f962a), Integer.valueOf(this.d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f962a));
        sb.append(" content=");
        sb.append(this.f963b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f964c).toUpperCase());
        return sb.toString();
    }
}
