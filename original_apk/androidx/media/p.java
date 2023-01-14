package androidx.media;

import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f974a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f975b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ IBinder f976c;
    final /* synthetic */ MediaBrowserServiceCompat.j d;

    p(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, IBinder iBinder) {
        this.d = jVar;
        this.f974a = kVar;
        this.f975b = str;
        this.f976c = iBinder;
    }

    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f944c.get(this.f974a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.f975b);
        } else if (!MediaBrowserServiceCompat.this.a(this.f975b, bVar, this.f976c)) {
            Log.w("MBServiceCompat", "removeSubscription called for " + this.f975b + " which is not subscribed");
        }
    }
}
