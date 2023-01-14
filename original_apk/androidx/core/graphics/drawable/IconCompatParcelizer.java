package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.b;

public class IconCompatParcelizer {
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f667b = bVar.a(iconCompat.f667b, 1);
        iconCompat.d = bVar.a(iconCompat.d, 2);
        iconCompat.e = bVar.a_shaKey_method2(iconCompat.e, 3);
        iconCompat.f = bVar.a(iconCompat.f, 4);
        iconCompat.g = bVar.a(iconCompat.g, 5);
        iconCompat.h = (ColorStateList) bVar.a_shaKey_method2(iconCompat.h, 6);
        iconCompat.j = bVar.a(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.a(true, true);
        iconCompat.a(bVar.c());
        bVar.b(iconCompat.f667b, 1);
        bVar.b(iconCompat.d, 2);
        bVar.b(iconCompat.e, 3);
        bVar.b(iconCompat.f, 4);
        bVar.b(iconCompat.g, 5);
        bVar.b((Parcelable) iconCompat.h, 6);
        bVar.b(iconCompat.j, 7);
    }
}
