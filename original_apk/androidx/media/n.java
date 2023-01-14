package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.k f969a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.j f970b;

    n(MediaBrowserServiceCompat.j jVar, MediaBrowserServiceCompat.k kVar) {
        this.f970b = jVar;
        this.f969a = kVar;
    }

    public void run() {
        MediaBrowserServiceCompat.b remove = MediaBrowserServiceCompat.this.f944c.remove(this.f969a.asBinder());
        if (remove != null) {
            remove.f.asBinder().unlinkToDeath(remove, 0);
        }
    }
}
