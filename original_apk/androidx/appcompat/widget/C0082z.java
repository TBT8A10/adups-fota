package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.a.h;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.z  reason: case insensitive filesystem */
/* compiled from: AppCompatTextHelper */
class C0082z extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WeakReference f485a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ A f486b;

    C0082z(A a2, WeakReference weakReference) {
        this.f486b = a2;
        this.f485a = weakReference;
    }

    public void a(int i) {
    }

    public void a(Typeface typeface) {
        this.f486b.a_shaKey_method2((WeakReference<TextView>) this.f485a, typeface);
    }
}
