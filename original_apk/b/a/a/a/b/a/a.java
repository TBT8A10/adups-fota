package b.a.a.a.b.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1388a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1389b;

    protected a(IBinder iBinder, String str) {
        this.f1388a = iBinder;
        this.f1389b = str;
    }

    /* access modifiers changed from: protected */
    public final Parcel a(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.f1388a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f1388a;
    }

    /* access modifiers changed from: protected */
    public final Parcel d() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1389b);
        return obtain;
    }
}
