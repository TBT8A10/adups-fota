package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: com.google.firebase.iid.h  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0186h {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f2414a;

    /* renamed from: b  reason: collision with root package name */
    private final zzf f2415b;

    C0186h(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f2414a = new Messenger(iBinder);
            this.f2415b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f2415b = new zzf(iBinder);
            this.f2414a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f2414a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzf zzf = this.f2415b;
        if (zzf != null) {
            zzf.a(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
