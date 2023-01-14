package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* renamed from: androidx.media.b  reason: case insensitive filesystem */
/* compiled from: AudioAttributesImplApi21 */
class C0102b implements C0101a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f960a;

    /* renamed from: b  reason: collision with root package name */
    int f961b = -1;

    C0102b() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0102b)) {
            return false;
        }
        return this.f960a.equals(((C0102b) obj).f960a);
    }

    public int hashCode() {
        return this.f960a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f960a;
    }
}
