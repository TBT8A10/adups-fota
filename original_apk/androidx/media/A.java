package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.g.c;

/* compiled from: MediaSessionManagerImplApi28 */
final class A implements z {

    /* renamed from: a  reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f935a;

    A(String str, int i, int i2) {
        this.f935a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A)) {
            return false;
        }
        return this.f935a.equals(((A) obj).f935a);
    }

    public int hashCode() {
        return c.a(this.f935a);
    }

    A(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f935a = remoteUserInfo;
    }
}
