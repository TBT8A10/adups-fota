package androidx.media;

import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f977a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f978b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ResultReceiver f979c;
    final /* synthetic */ MediaBrowserServiceCompat.j d;

    q(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, ResultReceiver resultReceiver) {
        this.d = jVar;
        this.f977a = kVar;
        this.f978b = str;
        this.f979c = resultReceiver;
    }

    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f944c.get(this.f977a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.f978b);
            return;
        }
        MediaBrowserServiceCompat.this.a(this.f978b, bVar, this.f979c);
    }
}
