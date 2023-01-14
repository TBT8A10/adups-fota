package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f966a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f967b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f968c;
    final /* synthetic */ int d;
    final /* synthetic */ Bundle e;
    final /* synthetic */ MediaBrowserServiceCompat.j f;

    m(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, int i, int i2, Bundle bundle) {
        this.f = jVar;
        this.f966a = kVar;
        this.f967b = str;
        this.f968c = i;
        this.d = i2;
        this.e = bundle;
    }

    public void run() {
        IBinder asBinder = this.f966a.asBinder();
        MediaBrowserServiceCompat.this.f944c.remove(asBinder);
        MediaBrowserServiceCompat.b bVar = new MediaBrowserServiceCompat.b(this.f967b, this.f968c, this.d, this.e, this.f966a);
        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat.d = bVar;
        bVar.h = mediaBrowserServiceCompat.a(this.f967b, this.d, this.e);
        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
        mediaBrowserServiceCompat2.d = null;
        if (bVar.h == null) {
            Log.i("MBServiceCompat", "No root for client " + this.f967b + " from service " + m.class.getName());
            try {
                this.f966a.a();
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.f967b);
            }
        } else {
            try {
                mediaBrowserServiceCompat2.f944c.put(asBinder, bVar);
                asBinder.linkToDeath(bVar, 0);
                if (MediaBrowserServiceCompat.this.f != null) {
                    MediaBrowserServiceCompat.k kVar = this.f966a;
                    bVar.h.b();
                    throw null;
                }
            } catch (RemoteException unused2) {
                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + this.f967b);
                MediaBrowserServiceCompat.this.f944c.remove(asBinder);
            }
        }
    }
}
