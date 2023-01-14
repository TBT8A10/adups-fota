package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.C0087a;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0088b();

    /* renamed from: a  reason: collision with root package name */
    final int[] f783a;

    /* renamed from: b  reason: collision with root package name */
    final int f784b;

    /* renamed from: c  reason: collision with root package name */
    final int f785c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public BackStackState(C0087a aVar) {
        int size = aVar.f838b.size();
        this.f783a = new int[(size * 6)];
        if (aVar.i) {
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                C0087a.C0017a aVar2 = aVar.f838b.get(i3);
                int[] iArr = this.f783a;
                int i4 = i2 + 1;
                iArr[i2] = aVar2.f840a;
                int i5 = i4 + 1;
                Fragment fragment = aVar2.f841b;
                iArr[i4] = fragment != null ? fragment.g : -1;
                int[] iArr2 = this.f783a;
                int i6 = i5 + 1;
                iArr2[i5] = aVar2.f842c;
                int i7 = i6 + 1;
                iArr2[i6] = aVar2.d;
                int i8 = i7 + 1;
                iArr2[i7] = aVar2.e;
                i2 = i8 + 1;
                iArr2[i8] = aVar2.f;
            }
            this.f784b = aVar.g;
            this.f785c = aVar.h;
            this.d = aVar.k;
            this.e = aVar.m;
            this.f = aVar.n;
            this.g = aVar.o;
            this.h = aVar.p;
            this.i = aVar.q;
            this.j = aVar.r;
            this.k = aVar.s;
            this.l = aVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0087a a(s sVar) {
        C0087a aVar = new C0087a(sVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f783a.length) {
            C0087a.C0017a aVar2 = new C0087a.C0017a();
            int i4 = i2 + 1;
            aVar2.f840a = this.f783a[i2];
            if (s.f862a) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f783a[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.f783a[i4];
            if (i6 >= 0) {
                aVar2.f841b = sVar.k.get(i6);
            } else {
                aVar2.f841b = null;
            }
            int[] iArr = this.f783a;
            int i7 = i5 + 1;
            aVar2.f842c = iArr[i5];
            int i8 = i7 + 1;
            aVar2.d = iArr[i7];
            int i9 = i8 + 1;
            aVar2.e = iArr[i8];
            aVar2.f = iArr[i9];
            aVar.f839c = aVar2.f842c;
            aVar.d = aVar2.d;
            aVar.e = aVar2.e;
            aVar.f = aVar2.f;
            aVar.a(aVar2);
            i3++;
            i2 = i9 + 1;
        }
        aVar.g = this.f784b;
        aVar.h = this.f785c;
        aVar.k = this.d;
        aVar.m = this.e;
        aVar.i = true;
        aVar.n = this.f;
        aVar.o = this.g;
        aVar.p = this.h;
        aVar.q = this.i;
        aVar.r = this.j;
        aVar.s = this.k;
        aVar.t = this.l;
        aVar.a(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f783a);
        parcel.writeInt(this.f784b);
        parcel.writeInt(this.f785c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f783a = parcel.createIntArray();
        this.f784b = parcel.readInt();
        this.f785c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }
}
