package androidx.core.e;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.e.f;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat */
class b implements Callable<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f600a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f601b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f602c;
    final /* synthetic */ String d;

    b(Context context, a aVar, int i, String str) {
        this.f600a = context;
        this.f601b = aVar;
        this.f602c = i;
        this.d = str;
    }

    public f.c call() throws Exception {
        f.c a2 = f.a(this.f600a, this.f601b, this.f602c);
        Typeface typeface = a2.f614a;
        if (typeface != null) {
            f.f606a.a_shaKey_method2(this.d, typeface);
        }
        return a2;
    }
}
