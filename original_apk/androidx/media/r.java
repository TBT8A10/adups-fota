package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f980a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f981b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f982c;
    final /* synthetic */ int d;
    final /* synthetic */ Bundle e;
    final /* synthetic */ MediaBrowserServiceCompat.j f;

    r(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, int i, int i2, Bundle bundle) {
        this.f = jVar;
        this.f980a = kVar;
        this.f981b = str;
        this.f982c = i;
        this.d = i2;
        this.e = bundle;
    }

    public void run() {
        IBinder asBinder = this.f980a.asBinder();
        MediaBrowserServiceCompat.this.f944c.remove(asBinder);
        MediaBrowserServiceCompat.b bVar = new MediaBrowserServiceCompat.b(this.f981b, this.f982c, this.d, this.e, this.f980a);
        MediaBrowserServiceCompat.this.f944c.put(asBinder, bVar);
        try {
            asBinder.linkToDeath(bVar, 0);
        } catch (RemoteException unused) {
            Log.w("MBServiceCompat", "IBinder is already dead.");
        }
    }
}
