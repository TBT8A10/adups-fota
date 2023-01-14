package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.b;

public final class AudioAttributesImplApi21Parcelizer {
    public static C0102b read(b bVar) {
        C0102b bVar2 = new C0102b();
        bVar2.f960a = (AudioAttributes) bVar.a_shaKey_method2(bVar2.f960a, 1);
        bVar2.f961b = bVar.a(bVar2.f961b, 2);
        return bVar2;
    }

    public static void write(C0102b bVar, b bVar2) {
        bVar2.a(false, false);
        bVar2.b((Parcelable) bVar.f960a, 1);
        bVar2.b(bVar.f961b, 2);
    }
}
