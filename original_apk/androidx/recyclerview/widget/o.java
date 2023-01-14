package androidx.recyclerview.widget;

import androidx.recyclerview.widget.p;
import java.util.Comparator;

/* compiled from: GapWorker */
class o implements Comparator<p.b> {
    o() {
    }

    /* renamed from: a */
    public int compare(p.b bVar, p.b bVar2) {
        if ((bVar.d == null) == (bVar2.d == null)) {
            boolean z = bVar.f1139a;
            if (z == bVar2.f1139a) {
                int i = bVar2.f1140b - bVar.f1140b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.f1141c - bVar2.f1141c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            } else if (z) {
                return -1;
            } else {
                return 1;
            }
        } else if (bVar.d == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
