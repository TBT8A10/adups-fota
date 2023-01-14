package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.t;

final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    final String f813a;

    /* renamed from: b  reason: collision with root package name */
    final int f814b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f815c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    Fragment l;

    FragmentState(Fragment fragment) {
        this.f813a = fragment.getClass().getName();
        this.f814b = fragment.g;
        this.f815c = fragment.o;
        this.d = fragment.z;
        this.e = fragment.A;
        this.f = fragment.B;
        this.g = fragment.E;
        this.h = fragment.D;
        this.i = fragment.i;
        this.j = fragment.C;
    }

    public Fragment a(C0097k kVar, C0095i iVar, Fragment fragment, t tVar, t tVar2) {
        if (this.l == null) {
            Context c2 = kVar.c();
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(c2.getClassLoader());
            }
            if (iVar != null) {
                this.l = iVar.a(c2, this.f813a, this.i);
            } else {
                this.l = Fragment.a(c2, this.f813a, this.i);
            }
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(c2.getClassLoader());
                this.l.d = this.k;
            }
            this.l.a(this.f814b, fragment);
            Fragment fragment2 = this.l;
            fragment2.o = this.f815c;
            fragment2.q = true;
            fragment2.z = this.d;
            fragment2.A = this.e;
            fragment2.B = this.f;
            fragment2.E = this.g;
            fragment2.D = this.h;
            fragment2.C = this.j;
            fragment2.t = kVar.e;
            if (s.f862a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        Fragment fragment3 = this.l;
        fragment3.w = tVar;
        fragment3.x = tVar2;
        return fragment3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f813a);
        parcel.writeInt(this.f814b);
        parcel.writeInt(this.f815c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }

    FragmentState(Parcel parcel) {
        this.f813a = parcel.readString();
        this.f814b = parcel.readInt();
        boolean z = true;
        this.f815c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() == 0 ? false : z;
        this.k = parcel.readBundle();
    }
}
