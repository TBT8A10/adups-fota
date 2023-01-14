package androidx.core.content.a;

import android.graphics.Typeface;
import androidx.core.content.a.h;

/* compiled from: ResourcesCompat */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Typeface f593a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f594b;

    f(h.a aVar, Typeface typeface) {
        this.f594b = aVar;
        this.f593a = typeface;
    }

    public void run() {
        this.f594b.a(this.f593a);
    }
}
