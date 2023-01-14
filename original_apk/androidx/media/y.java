package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

/* compiled from: MediaSessionManager */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    z f1000a;

    public y(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1000a = new A(str, i, i2);
        } else {
            this.f1000a = new B(str, i, i2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        return this.f1000a.equals(((y) obj).f1000a);
    }

    public int hashCode() {
        return this.f1000a.hashCode();
    }

    public y(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f1000a = new A(remoteUserInfo);
    }
}
