package androidx.fragment.app;

import android.graphics.Paint;
import androidx.fragment.app.s;

/* compiled from: FragmentManager */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s.a f861a;

    r(s.a aVar) {
        this.f861a = aVar;
    }

    public void run() {
        this.f861a.f865b.setLayerType(0, (Paint) null);
    }
}
