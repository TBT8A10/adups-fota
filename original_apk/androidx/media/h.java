package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: MediaBrowserServiceCompat */
class h extends MediaBrowserServiceCompat.i<Bundle> {
    final /* synthetic */ ResultReceiver f;
    final /* synthetic */ MediaBrowserServiceCompat g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.g = mediaBrowserServiceCompat;
        this.f = resultReceiver;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void a(Bundle bundle) {
        this.f.send(0, bundle);
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        this.f.send(-1, bundle);
    }
}
