package androidx.media;

import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f983a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f984b;

    s(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar) {
        this.f984b = jVar;
        this.f983a = kVar;
    }

    public void run() {
        IBinder asBinder = this.f983a.asBinder();
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.f944c.remove(asBinder);
        if (remove != null) {
            asBinder.unlinkToDeath(remove, 0);
        }
    }
}
