package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaBrowserServiceCompat.b f965a;

    i(MediaBrowserServiceCompat.b bVar) {
        this.f965a = bVar;
    }

    public void run() {
        MediaBrowserServiceCompat.b bVar = this.f965a;
        MediaBrowserServiceCompat.this.f944c.remove(bVar.f.asBinder());
    }
}
