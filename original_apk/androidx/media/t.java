package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f988a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f989b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f990c;
    final /* synthetic */ ResultReceiver d;
    final /* synthetic */ MediaBrowserServiceCompat.j e;

    t(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = jVar;
        this.f988a = kVar;
        this.f989b = str;
        this.f990c = bundle;
        this.d = resultReceiver;
    }

    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f944c.get(this.f988a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.f989b);
            return;
        }
        MediaBrowserServiceCompat.this.b(this.f989b, this.f990c, bVar, this.d);
    }
}
