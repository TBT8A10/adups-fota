package androidx.media;

import androidx.versionedparcelable.b;

public final class AudioAttributesImplBaseParcelizer {
    public static C0103c read(b bVar) {
        C0103c cVar = new C0103c();
        cVar.f962a = bVar.a(cVar.f962a, 1);
        cVar.f963b = bVar.a(cVar.f963b, 2);
        cVar.f964c = bVar.a(cVar.f964c, 3);
        cVar.d = bVar.a(cVar.d, 4);
        return cVar;
    }

    public static void write(C0103c cVar, b bVar) {
        bVar.a(false, false);
        bVar.b(cVar.f962a, 1);
        bVar.b(cVar.f963b, 2);
        bVar.b(cVar.f964c, 3);
        bVar.b(cVar.d, 4);
    }
}
