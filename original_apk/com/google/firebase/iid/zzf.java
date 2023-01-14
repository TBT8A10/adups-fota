package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public class zzf implements Parcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new J();

    /* renamed from: a  reason: collision with root package name */
    private Messenger f2451a;

    /* renamed from: b  reason: collision with root package name */
    private T f2452b;

    /* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
    public static final class a extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.f()) {
                return zzf.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzf.class;
        }
    }

    public zzf(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2451a = new Messenger(iBinder);
        } else {
            this.f2452b = new W(iBinder);
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f2451a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f2452b.a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzf) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f2451a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f2452b.asBinder());
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f2451a;
        return messenger != null ? messenger.getBinder() : this.f2452b.asBinder();
    }
}
