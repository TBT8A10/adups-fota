package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f971a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f972b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ IBinder f973c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ MediaBrowserServiceCompat.j e;

    o(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar, String str, IBinder iBinder, Bundle bundle) {
        this.e = jVar;
        this.f971a = kVar;
        this.f972b = str;
        this.f973c = iBinder;
        this.d = bundle;
    }

    public void run() {
        MediaBrowserServiceCompat.b bVar = MediaBrowserServiceCompat.this.f944c.get(this.f971a.asBinder());
        if (bVar == null) {
            Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.f972b);
            return;
        }
        MediaBrowserServiceCompat.this.a(this.f972b, bVar, this.f973c, this.d);
    }
}
