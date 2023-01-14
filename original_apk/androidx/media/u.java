package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f991a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f992b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f993c;
    final /* synthetic */ ResultReceiver d;
    final /* synthetic */ MediaBrowserServiceCompat.j e;

    u(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
        this.e = jVar;
        this.f991a = kVar;
        this.f992b = str;
        this.f993c = bundle;
        this.d = resultReceiver;
    }

    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f944c.get(this.f991a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.f992b + ", extras=" + this.f993c);
            return;
        }
        MediaBrowserServiceCompat.this.a(this.f992b, this.f993c, bVar, this.d);
    }
}
