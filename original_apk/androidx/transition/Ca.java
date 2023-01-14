package androidx.transition;

import android.os.IBinder;

/* compiled from: WindowIdApi14 */
class Ca implements Ea {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1204a;

    Ca(IBinder iBinder) {
        this.f1204a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Ca) && ((Ca) obj).f1204a.equals(this.f1204a);
    }

    public int hashCode() {
        return this.f1204a.hashCode();
    }
}
