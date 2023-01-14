package androidx.core.e;

import android.os.Handler;
import androidx.core.content.a.h;
import androidx.core.e.f;
import androidx.core.e.k;

/* compiled from: FontsContractCompat */
class c implements k.a<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h.a f603a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Handler f604b;

    c(h.a aVar, Handler handler) {
        this.f603a = aVar;
        this.f604b = handler;
    }

    public void a(f.c cVar) {
        if (cVar == null) {
            this.f603a.a_shaKey_method2(1, this.f604b);
            return;
        }
        int i = cVar.f615b;
        if (i == 0) {
            this.f603a.a_shaKey_method2(cVar.f614a, this.f604b);
        } else {
            this.f603a.a_shaKey_method2(i, this.f604b);
        }
    }
}
