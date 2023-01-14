package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* compiled from: VersionedParcelParcel */
class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f1357a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f1358b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1359c;
    private final int d;
    private final String e;
    private int f;
    private int g;

    c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    private int d(int i) {
        int readInt;
        do {
            int i2 = this.g;
            if (i2 >= this.d) {
                return -1;
            }
            this.f1358b.setDataPosition(i2);
            int readInt2 = this.f1358b.readInt();
            readInt = this.f1358b.readInt();
            this.g += readInt2;
        } while (readInt != i);
        return this.f1358b.dataPosition();
    }

    public boolean a(int i) {
        int d2 = d(i);
        if (d2 == -1) {
            return false;
        }
        this.f1358b.setDataPosition(d2);
        return true;
    }

    public void b(int i) {
        a();
        this.f = i;
        this.f1357a.put(i, this.f1358b.dataPosition());
        c(0);
        c(i);
    }

    public void c(int i) {
        this.f1358b.writeInt(i);
    }

    public int e() {
        return this.f1358b.readInt();
    }

    public <T extends Parcelable> T f() {
        return this.f1358b.readParcelable(c.class.getClassLoader());
    }

    public String g() {
        return this.f1358b.readString();
    }

    c(Parcel parcel, int i, int i2, String str) {
        this.f1357a = new SparseIntArray();
        this.f = -1;
        this.g = 0;
        this.f1358b = parcel;
        this.f1359c = i;
        this.d = i2;
        this.g = this.f1359c;
        this.e = str;
    }

    public void a() {
        int i = this.f;
        if (i >= 0) {
            int i2 = this.f1357a.get(i);
            int dataPosition = this.f1358b.dataPosition();
            this.f1358b.setDataPosition(i2);
            this.f1358b.writeInt(dataPosition - i2);
            this.f1358b.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public b b() {
        Parcel parcel = this.f1358b;
        int dataPosition = parcel.dataPosition();
        int i = this.g;
        if (i == this.f1359c) {
            i = this.d;
        }
        return new c(parcel, dataPosition, i, this.e + "  ");
    }

    public byte[] d() {
        int readInt = this.f1358b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1358b.readByteArray(bArr);
        return bArr;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f1358b.writeInt(bArr.length);
            this.f1358b.writeByteArray(bArr);
            return;
        }
        this.f1358b.writeInt(-1);
    }

    public void a(String str) {
        this.f1358b.writeString(str);
    }

    public void a(Parcelable parcelable) {
        this.f1358b.writeParcelable(parcelable, 0);
    }
}
